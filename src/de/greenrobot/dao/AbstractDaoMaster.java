package de.greenrobot.dao;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDaoMaster
{
  protected final Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap;
  protected final SQLiteDatabase db;
  protected final int schemaVersion;

  public AbstractDaoMaster(SQLiteDatabase paramSQLiteDatabase, int paramInt)
  {
    this.db = paramSQLiteDatabase;
    this.schemaVersion = paramInt;
    this.daoConfigMap = new HashMap();
  }

  public SQLiteDatabase getDatabase()
  {
    return this.db;
  }

  public int getSchemaVersion()
  {
    return this.schemaVersion;
  }

  public abstract AbstractDaoSession newSession();

  public abstract AbstractDaoSession newSession(IdentityScopeType paramIdentityScopeType);

  protected void registerDaoClass(Class<? extends AbstractDao<?, ?>> paramClass)
  {
    DaoConfig localDaoConfig = new DaoConfig(this.db, paramClass);
    this.daoConfigMap.put(paramClass, localDaoConfig);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.AbstractDaoMaster
 * JD-Core Version:    0.6.2
 */