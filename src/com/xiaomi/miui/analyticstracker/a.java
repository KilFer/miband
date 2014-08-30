package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class a extends SQLiteOpenHelper
{
  private static final String a = "create table %s(_id integer primary key autoincrement, type integer, event_id text, param text, time text, value text)";
  private String b;

  public a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    super(paramContext, paramString1, null, 2);
    this.b = paramString2;
  }

  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.b;
    paramSQLiteDatabase.execSQL(String.format("create table %s(_id integer primary key autoincrement, type integer, event_id text, param text, time text, value text)", arrayOfObject));
  }

  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.a
 * JD-Core Version:    0.6.2
 */