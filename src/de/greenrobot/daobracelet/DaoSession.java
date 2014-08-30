package de.greenrobot.daobracelet;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.Map;

public class DaoSession extends AbstractDaoSession
{
  private final LuaListDao luaListDao;
  private final DaoConfig luaListDaoConfig;
  private final LuaZipFileDao luaZipFileDao;
  private final DaoConfig luaZipFileDaoConfig;

  public DaoSession(SQLiteDatabase paramSQLiteDatabase, IdentityScopeType paramIdentityScopeType, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> paramMap)
  {
    super(paramSQLiteDatabase);
    this.luaListDaoConfig = ((DaoConfig)paramMap.get(LuaListDao.class)).clone();
    this.luaListDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.luaZipFileDaoConfig = ((DaoConfig)paramMap.get(LuaZipFileDao.class)).clone();
    this.luaZipFileDaoConfig.initIdentityScope(paramIdentityScopeType);
    this.luaListDao = new LuaListDao(this.luaListDaoConfig, this);
    this.luaZipFileDao = new LuaZipFileDao(this.luaZipFileDaoConfig, this);
    registerDao(LuaList.class, this.luaListDao);
    registerDao(LuaZipFile.class, this.luaZipFileDao);
  }

  public void clear()
  {
    this.luaListDaoConfig.getIdentityScope().clear();
    this.luaZipFileDaoConfig.getIdentityScope().clear();
  }

  public LuaListDao getLuaListDao()
  {
    return this.luaListDao;
  }

  public LuaZipFileDao getLuaZipFileDao()
  {
    return this.luaZipFileDao;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.daobracelet.DaoSession
 * JD-Core Version:    0.6.2
 */