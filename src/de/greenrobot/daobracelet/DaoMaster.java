package de.greenrobot.daobracelet;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDaoMaster;
import de.greenrobot.dao.identityscope.IdentityScopeType;

public class DaoMaster extends AbstractDaoMaster
{
  public static final int SCHEMA_VERSION = 6;

  public DaoMaster(SQLiteDatabase paramSQLiteDatabase)
  {
    super(paramSQLiteDatabase, 6);
    registerDaoClass(LuaListDao.class);
    registerDaoClass(LuaZipFileDao.class);
  }

  public static void createAllTables(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    LuaListDao.createTable(paramSQLiteDatabase, paramBoolean);
    LuaZipFileDao.createTable(paramSQLiteDatabase, paramBoolean);
  }

  public static void dropAllTables(SQLiteDatabase paramSQLiteDatabase, boolean paramBoolean)
  {
    LuaListDao.dropTable(paramSQLiteDatabase, paramBoolean);
    LuaZipFileDao.dropTable(paramSQLiteDatabase, paramBoolean);
  }

  public DaoSession newSession()
  {
    return new DaoSession(this.db, IdentityScopeType.Session, this.daoConfigMap);
  }

  public DaoSession newSession(IdentityScopeType paramIdentityScopeType)
  {
    return new DaoSession(this.db, paramIdentityScopeType, this.daoConfigMap);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.daobracelet.DaoMaster
 * JD-Core Version:    0.6.2
 */