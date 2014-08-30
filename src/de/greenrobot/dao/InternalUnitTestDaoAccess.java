package de.greenrobot.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.identityscope.IdentityScope;
import de.greenrobot.dao.internal.DaoConfig;
import java.lang.reflect.Constructor;

public class InternalUnitTestDaoAccess<T, K>
{
  private final AbstractDao<T, K> dao;

  public InternalUnitTestDaoAccess(SQLiteDatabase paramSQLiteDatabase, Class<AbstractDao<T, K>> paramClass, IdentityScope<?, ?> paramIdentityScope)
  {
    DaoConfig localDaoConfig = new DaoConfig(paramSQLiteDatabase, paramClass);
    localDaoConfig.setIdentityScope(paramIdentityScope);
    this.dao = ((AbstractDao)paramClass.getConstructor(new Class[] { DaoConfig.class }).newInstance(new Object[] { localDaoConfig }));
  }

  public AbstractDao<T, K> getDao()
  {
    return this.dao;
  }

  public K getKey(T paramT)
  {
    return this.dao.getKey(paramT);
  }

  public Property[] getProperties()
  {
    return this.dao.getProperties();
  }

  public boolean isEntityUpdateable()
  {
    return this.dao.isEntityUpdateable();
  }

  public T readEntity(Cursor paramCursor, int paramInt)
  {
    return this.dao.readEntity(paramCursor, paramInt);
  }

  public K readKey(Cursor paramCursor, int paramInt)
  {
    return this.dao.readKey(paramCursor, paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.InternalUnitTestDaoAccess
 * JD-Core Version:    0.6.2
 */