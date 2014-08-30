package com.tencent.stat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class s extends SQLiteOpenHelper
{
  private static String a = "tencent_analysis.db";
  private static int b = 3;

  public s(Context paramContext)
  {
    super(paramContext, a, null, b);
  }

  private static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("user", null, null, null, null, null, null);
    ContentValues localContentValues = new ContentValues();
    boolean bool = localCursor.moveToNext();
    String str = null;
    if (bool)
    {
      str = localCursor.getString(0);
      localCursor.getInt(1);
      localCursor.getString(2);
      localCursor.getLong(3);
      localContentValues.put("uid", StatCommonHelper.encode(str));
    }
    if (str != null)
      paramSQLiteDatabase.update("user", localContentValues, "uid=?", new String[] { str });
  }

  private static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("events", null, null, null, null, null, null);
    ArrayList localArrayList = new ArrayList();
    while (localCursor.moveToNext())
      localArrayList.add(new t(localCursor.getLong(0), localCursor.getString(1), localCursor.getInt(2), localCursor.getInt(3)));
    ContentValues localContentValues = new ContentValues();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      t localt = (t)localIterator.next();
      localContentValues.put("content", StatCommonHelper.encode(localt.b));
      String[] arrayOfString = new String[1];
      arrayOfString[0] = Long.toString(localt.a);
      paramSQLiteDatabase.update("events", localContentValues, "event_id=?", arrayOfString);
    }
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
    paramSQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
    paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StatStore.a().debug("upgrade DB from oldVersion " + paramInt1 + " to newVersion " + paramInt2);
    if (paramInt1 == 1)
    {
      paramSQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
    if (paramInt1 == 2)
    {
      a(paramSQLiteDatabase);
      b(paramSQLiteDatabase);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.s
 * JD-Core Version:    0.6.2
 */