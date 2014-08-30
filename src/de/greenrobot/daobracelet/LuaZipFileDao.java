package de.greenrobot.daobracelet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.internal.DaoConfig;

public class LuaZipFileDao extends AbstractDao<LuaZipFile, Long>
{
  public static final String TABLENAME = "LUA_ZIP_FILE";

  public LuaZipFileDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }

  public LuaZipFileDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }

  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "IF NOT EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'LUA_ZIP_FILE' ('_id' INTEGER PRIMARY KEY ," + "'VERSION' TEXT,'DATE' TEXT," + "'ZIP_FILE' BLOB);");
      return;
    }
  }

  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean);
    for (String str = "IF EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'LUA_ZIP_FILE'");
      return;
    }
  }

  protected void bindValues(SQLiteStatement paramSQLiteStatement, LuaZipFile paramLuaZipFile)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramLuaZipFile.getId();
    if (localLong != null)
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    String str1 = paramLuaZipFile.getVersion();
    if (str1 != null)
      paramSQLiteStatement.bindString(2, str1);
    String str2 = paramLuaZipFile.getDate();
    if (str2 != null)
      paramSQLiteStatement.bindString(3, str2);
    byte[] arrayOfByte = paramLuaZipFile.getZipFile();
    if (arrayOfByte != null)
      paramSQLiteStatement.bindBlob(4, arrayOfByte);
  }

  public Long getKey(LuaZipFile paramLuaZipFile)
  {
    if (paramLuaZipFile != null)
      return paramLuaZipFile.getId();
    return null;
  }

  protected boolean isEntityUpdateable()
  {
    return true;
  }

  public LuaZipFile readEntity(Cursor paramCursor, int paramInt)
  {
    Long localLong;
    String str1;
    label27: String str2;
    label42: byte[] arrayOfByte;
    if (paramCursor.isNull(paramInt))
    {
      localLong = null;
      if (!paramCursor.isNull(paramInt + 1))
        break label90;
      str1 = null;
      if (!paramCursor.isNull(paramInt + 2))
        break label104;
      str2 = null;
      boolean bool = paramCursor.isNull(paramInt + 3);
      arrayOfByte = null;
      if (!bool)
        break label118;
    }
    while (true)
    {
      return new LuaZipFile(localLong, str1, str2, arrayOfByte);
      localLong = Long.valueOf(paramCursor.getLong(paramInt));
      break;
      label90: str1 = paramCursor.getString(paramInt + 1);
      break label27;
      label104: str2 = paramCursor.getString(paramInt + 2);
      break label42;
      label118: arrayOfByte = paramCursor.getBlob(paramInt + 3);
    }
  }

  public void readEntity(Cursor paramCursor, LuaZipFile paramLuaZipFile, int paramInt)
  {
    Long localLong;
    String str1;
    label34: String str2;
    label55: byte[] arrayOfByte;
    if (paramCursor.isNull(paramInt))
    {
      localLong = null;
      paramLuaZipFile.setId(localLong);
      if (!paramCursor.isNull(paramInt + 1))
        break label102;
      str1 = null;
      paramLuaZipFile.setVersion(str1);
      if (!paramCursor.isNull(paramInt + 2))
        break label116;
      str2 = null;
      paramLuaZipFile.setDate(str2);
      boolean bool = paramCursor.isNull(paramInt + 3);
      arrayOfByte = null;
      if (!bool)
        break label130;
    }
    while (true)
    {
      paramLuaZipFile.setZipFile(arrayOfByte);
      return;
      localLong = Long.valueOf(paramCursor.getLong(paramInt));
      break;
      label102: str1 = paramCursor.getString(paramInt + 1);
      break label34;
      label116: str2 = paramCursor.getString(paramInt + 2);
      break label55;
      label130: arrayOfByte = paramCursor.getBlob(paramInt + 3);
    }
  }

  public Long readKey(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt))
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt));
  }

  protected Long updateKeyAfterInsert(LuaZipFile paramLuaZipFile, long paramLong)
  {
    paramLuaZipFile.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.daobracelet.LuaZipFileDao
 * JD-Core Version:    0.6.2
 */