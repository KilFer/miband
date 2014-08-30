package de.greenrobot.daobracelet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public abstract class DaoMaster$OpenHelper extends SQLiteOpenHelper
{
  public DaoMaster$OpenHelper(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    super(paramContext, paramString, paramCursorFactory, 6);
  }

  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    Log.i("greenDAO", "Creating tables for schema version 6");
    DaoMaster.createAllTables(paramSQLiteDatabase, false);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.daobracelet.DaoMaster.OpenHelper
 * JD-Core Version:    0.6.2
 */