package com.xiaomi.market.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

public class r extends SQLiteOpenHelper
{
  private static r a;
  private static final String b = "MarketSDKDatabaseHelper";
  private static String c = "xiaomi_market_sdk_update.db";
  private static int d = 1;

  private r(Context paramContext)
  {
    super(paramContext, "xiaomi_market_sdk_update.db", null, 1);
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE update_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_name TEXT,download_id INTEGER, version_code INTEGER, apk_url TEXT, apk_hash TEXT, diff_url TEXT, diff_hash TEXT, apk_path TEXT, UNIQUE(package_name));");
  }

  public static r j(Context paramContext)
  {
    if (a == null)
      a = new r(paramContext);
    return a;
  }

  public long a(ContentValues paramContentValues)
  {
    SQLiteStatement localSQLiteStatement = getWritableDatabase().compileStatement("INSERT OR REPLACE INTO update_download(package_name,download_id,version_code,apk_url,apk_hash,diff_url,diff_hash,apk_path) VALUES(?,?,?,?,?,?,?,?)");
    localSQLiteStatement.bindString(1, paramContentValues.getAsString("package_name"));
    localSQLiteStatement.bindLong(2, paramContentValues.getAsLong("download_id").longValue());
    localSQLiteStatement.bindLong(3, paramContentValues.getAsInteger("version_code").intValue());
    localSQLiteStatement.bindString(4, paramContentValues.getAsString("apk_url"));
    localSQLiteStatement.bindString(5, paramContentValues.getAsString("apk_hash"));
    localSQLiteStatement.bindString(6, paramContentValues.getAsString("diff_url"));
    localSQLiteStatement.bindString(7, paramContentValues.getAsString("diff_hash"));
    localSQLiteStatement.bindString(8, paramContentValues.getAsString("apk_path"));
    localSQLiteStatement.execute();
    return 1L;
  }

  public long a(String paramString, ContentValues paramContentValues)
  {
    try
    {
      long l = getWritableDatabase().insert(paramString, null, paramContentValues);
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.d("MarketSDKDatabaseHelper", "create database");
    paramSQLiteDatabase.execSQL("CREATE TABLE update_download (_id INTEGER PRIMARY KEY AUTOINCREMENT,package_name TEXT,download_id INTEGER, version_code INTEGER, apk_url TEXT, apk_hash TEXT, diff_url TEXT, diff_hash TEXT, apk_path TEXT, UNIQUE(package_name));");
  }

  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }

  public Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    return getReadableDatabase().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.r
 * JD-Core Version:    0.6.2
 */