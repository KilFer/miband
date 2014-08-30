package de.greenrobot.daobracelet;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.internal.DaoConfig;

public class LuaListDao extends AbstractDao<LuaList, Long>
{
  public static final String TABLENAME = "LUA_LIST";

  public LuaListDao(DaoConfig paramDaoConfig)
  {
    super(paramDaoConfig);
  }

  public LuaListDao(DaoConfig paramDaoConfig, DaoSession paramDaoSession)
  {
    super(paramDaoConfig, paramDaoSession);
  }

  public static void createTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    if (paramBoolean);
    for (String str = "IF NOT EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + str + "'LUA_LIST' ('_id' INTEGER PRIMARY KEY ," + "'DATE' TEXT,'TIME' TEXT," + "'TYPE' TEXT,'RIGHT' TEXT," + "'INDEX' TEXT,'JSON_STRING' TEXT," + "'SCRIPT_VERSION' TEXT,'LUA_ACTION_SCRIPT' TEXT," + "'TEXT1' TEXT,'TEXT2' TEXT," + "'START' TEXT,'STOP' TEXT);");
      return;
    }
  }

  public static void dropTable(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DROP TABLE ");
    if (paramBoolean);
    for (String str = "IF EXISTS "; ; str = "")
    {
      paramSQLiteDatabase.execSQL(str + "'LUA_LIST'");
      return;
    }
  }

  protected void bindValues(SQLiteStatement paramSQLiteStatement, LuaList paramLuaList)
  {
    paramSQLiteStatement.clearBindings();
    Long localLong = paramLuaList.getId();
    if (localLong != null)
      paramSQLiteStatement.bindLong(1, localLong.longValue());
    String str1 = paramLuaList.getDate();
    if (str1 != null)
      paramSQLiteStatement.bindString(2, str1);
    String str2 = paramLuaList.getTime();
    if (str2 != null)
      paramSQLiteStatement.bindString(3, str2);
    String str3 = paramLuaList.getType();
    if (str3 != null)
      paramSQLiteStatement.bindString(4, str3);
    String str4 = paramLuaList.getRight();
    if (str4 != null)
      paramSQLiteStatement.bindString(5, str4);
    String str5 = paramLuaList.getIndex();
    if (str5 != null)
      paramSQLiteStatement.bindString(6, str5);
    String str6 = paramLuaList.getJsonString();
    if (str6 != null)
      paramSQLiteStatement.bindString(7, str6);
    String str7 = paramLuaList.getScriptVersion();
    if (str7 != null)
      paramSQLiteStatement.bindString(8, str7);
    String str8 = paramLuaList.getLuaActionScript();
    if (str8 != null)
      paramSQLiteStatement.bindString(9, str8);
    String str9 = paramLuaList.getText1();
    if (str9 != null)
      paramSQLiteStatement.bindString(10, str9);
    String str10 = paramLuaList.getText2();
    if (str10 != null)
      paramSQLiteStatement.bindString(11, str10);
    String str11 = paramLuaList.getStart();
    if (str11 != null)
      paramSQLiteStatement.bindString(12, str11);
    String str12 = paramLuaList.getStop();
    if (str12 != null)
      paramSQLiteStatement.bindString(13, str12);
  }

  public Long getKey(LuaList paramLuaList)
  {
    if (paramLuaList != null)
      return paramLuaList.getId();
    return null;
  }

  protected boolean isEntityUpdateable()
  {
    return true;
  }

  public LuaList readEntity(Cursor paramCursor, int paramInt)
  {
    Long localLong;
    String str1;
    label27: String str2;
    label42: String str3;
    label57: String str4;
    label72: String str5;
    label87: String str6;
    label103: String str7;
    label119: String str8;
    label135: String str9;
    label151: String str10;
    label167: String str11;
    if (paramCursor.isNull(paramInt))
    {
      localLong = null;
      if (!paramCursor.isNull(paramInt + 1))
        break label246;
      str1 = null;
      if (!paramCursor.isNull(paramInt + 2))
        break label260;
      str2 = null;
      if (!paramCursor.isNull(paramInt + 3))
        break label274;
      str3 = null;
      if (!paramCursor.isNull(paramInt + 4))
        break label288;
      str4 = null;
      if (!paramCursor.isNull(paramInt + 5))
        break label302;
      str5 = null;
      if (!paramCursor.isNull(paramInt + 6))
        break label316;
      str6 = null;
      if (!paramCursor.isNull(paramInt + 7))
        break label331;
      str7 = null;
      if (!paramCursor.isNull(paramInt + 8))
        break label346;
      str8 = null;
      if (!paramCursor.isNull(paramInt + 9))
        break label361;
      str9 = null;
      if (!paramCursor.isNull(paramInt + 10))
        break label376;
      str10 = null;
      if (!paramCursor.isNull(paramInt + 11))
        break label391;
      str11 = null;
      label183: if (!paramCursor.isNull(paramInt + 12))
        break label406;
    }
    label260: label274: label406: for (String str12 = null; ; str12 = paramCursor.getString(paramInt + 12))
    {
      return new LuaList(localLong, str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12);
      localLong = Long.valueOf(paramCursor.getLong(paramInt));
      break;
      label246: str1 = paramCursor.getString(paramInt + 1);
      break label27;
      str2 = paramCursor.getString(paramInt + 2);
      break label42;
      str3 = paramCursor.getString(paramInt + 3);
      break label57;
      label288: str4 = paramCursor.getString(paramInt + 4);
      break label72;
      label302: str5 = paramCursor.getString(paramInt + 5);
      break label87;
      label316: str6 = paramCursor.getString(paramInt + 6);
      break label103;
      label331: str7 = paramCursor.getString(paramInt + 7);
      break label119;
      label346: str8 = paramCursor.getString(paramInt + 8);
      break label135;
      label361: str9 = paramCursor.getString(paramInt + 9);
      break label151;
      label376: str10 = paramCursor.getString(paramInt + 10);
      break label167;
      str11 = paramCursor.getString(paramInt + 11);
      break label183;
    }
  }

  public void readEntity(Cursor paramCursor, LuaList paramLuaList, int paramInt)
  {
    Long localLong;
    String str1;
    label34: String str2;
    label55: String str3;
    label76: String str4;
    label97: String str5;
    label118: String str6;
    label140: String str7;
    label162: String str8;
    label184: String str9;
    label206: String str10;
    label228: String str11;
    label250: String str12;
    if (paramCursor.isNull(paramInt))
    {
      localLong = null;
      paramLuaList.setId(localLong);
      if (!paramCursor.isNull(paramInt + 1))
        break label298;
      str1 = null;
      paramLuaList.setDate(str1);
      if (!paramCursor.isNull(paramInt + 2))
        break label312;
      str2 = null;
      paramLuaList.setTime(str2);
      if (!paramCursor.isNull(paramInt + 3))
        break label326;
      str3 = null;
      paramLuaList.setType(str3);
      if (!paramCursor.isNull(paramInt + 4))
        break label340;
      str4 = null;
      paramLuaList.setRight(str4);
      if (!paramCursor.isNull(paramInt + 5))
        break label354;
      str5 = null;
      paramLuaList.setIndex(str5);
      if (!paramCursor.isNull(paramInt + 6))
        break label368;
      str6 = null;
      paramLuaList.setJsonString(str6);
      if (!paramCursor.isNull(paramInt + 7))
        break label383;
      str7 = null;
      paramLuaList.setScriptVersion(str7);
      if (!paramCursor.isNull(paramInt + 8))
        break label398;
      str8 = null;
      paramLuaList.setLuaActionScript(str8);
      if (!paramCursor.isNull(paramInt + 9))
        break label413;
      str9 = null;
      paramLuaList.setText1(str9);
      if (!paramCursor.isNull(paramInt + 10))
        break label428;
      str10 = null;
      paramLuaList.setText2(str10);
      if (!paramCursor.isNull(paramInt + 11))
        break label443;
      str11 = null;
      paramLuaList.setStart(str11);
      boolean bool = paramCursor.isNull(paramInt + 12);
      str12 = null;
      if (!bool)
        break label458;
    }
    while (true)
    {
      paramLuaList.setStop(str12);
      return;
      localLong = Long.valueOf(paramCursor.getLong(paramInt));
      break;
      label298: str1 = paramCursor.getString(paramInt + 1);
      break label34;
      label312: str2 = paramCursor.getString(paramInt + 2);
      break label55;
      label326: str3 = paramCursor.getString(paramInt + 3);
      break label76;
      label340: str4 = paramCursor.getString(paramInt + 4);
      break label97;
      label354: str5 = paramCursor.getString(paramInt + 5);
      break label118;
      label368: str6 = paramCursor.getString(paramInt + 6);
      break label140;
      label383: str7 = paramCursor.getString(paramInt + 7);
      break label162;
      label398: str8 = paramCursor.getString(paramInt + 8);
      break label184;
      label413: str9 = paramCursor.getString(paramInt + 9);
      break label206;
      label428: str10 = paramCursor.getString(paramInt + 10);
      break label228;
      label443: str11 = paramCursor.getString(paramInt + 11);
      break label250;
      label458: str12 = paramCursor.getString(paramInt + 12);
    }
  }

  public Long readKey(Cursor paramCursor, int paramInt)
  {
    if (paramCursor.isNull(paramInt))
      return null;
    return Long.valueOf(paramCursor.getLong(paramInt));
  }

  protected Long updateKeyAfterInsert(LuaList paramLuaList, long paramLong)
  {
    paramLuaList.setId(Long.valueOf(paramLong));
    return Long.valueOf(paramLong);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.daobracelet.LuaListDao
 * JD-Core Version:    0.6.2
 */