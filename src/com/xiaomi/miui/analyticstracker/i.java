package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

class i
  implements j
{
  private static String a = "ANALYTICS.SQLITESTORE";
  private static final String b = "analytics";
  private static final String c = "insert into %s values(null, ?, ?, ?, ?, ?)";
  private static final String d = "select * from analytics ";
  private static final String e = "delete from analytics ";
  private static final int f = 2;
  private SQLiteOpenHelper g;

  public final Cursor a(String paramString)
  {
    SQLiteOpenHelper localSQLiteOpenHelper = this.g;
    Object localObject = null;
    String str;
    if (localSQLiteOpenHelper != null)
    {
      str = "select * from analytics ";
      if (paramString != null)
        str = String.format("%s where %s", new Object[] { "select * from analytics ", paramString });
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.g.getReadableDatabase();
      localObject = null;
      if (localSQLiteDatabase != null)
      {
        Cursor localCursor = localSQLiteDatabase.rawQuery(str, null);
        localObject = localCursor;
      }
      return localObject;
    }
    catch (SQLiteException localSQLiteException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.g.getDatabaseName();
      Log.e("ANALYTICS.SQLITESTORE", String.format("can't read database:%s", arrayOfObject));
    }
    return null;
  }

  public final void a()
  {
    if (this.g != null)
      this.g.close();
  }

  public final void a(Context paramContext, String paramString)
  {
    this.g = new a(paramContext, paramString, "analytics", 2);
  }

  public final void a(Integer paramInteger, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.g != null);
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.g.getWritableDatabase();
      if (localSQLiteDatabase != null)
        localSQLiteDatabase.execSQL(String.format("insert into %s values(null, ?, ?, ?, ?, ?)", new Object[] { "analytics" }), new Object[] { paramInteger, paramString1, paramString2, paramString3, paramString4 });
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.g.getDatabaseName();
      Log.e("ANALYTICS.SQLITESTORE", String.format("database:%s is not writable!", arrayOfObject));
    }
  }

  public final void b(String paramString)
  {
    String str;
    if (this.g != null)
    {
      str = "delete from analytics ";
      if (paramString != null)
        str = String.format("%s where %s", new Object[] { "delete from analytics ", paramString });
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.g.getWritableDatabase();
      if (localSQLiteDatabase != null)
        localSQLiteDatabase.execSQL(str);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.g.getDatabaseName();
      Log.e("ANALYTICS.SQLITESTORE", String.format("can't remove data from database:%s", arrayOfObject));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.i
 * JD-Core Version:    0.6.2
 */