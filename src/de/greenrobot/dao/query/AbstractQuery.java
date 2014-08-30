package de.greenrobot.dao.query;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.InternalQueryDaoAccess;

abstract class AbstractQuery<T>
{
  protected final AbstractDao<T, ?> dao;
  protected final InternalQueryDaoAccess<T> daoAccess;
  protected final Thread ownerThread;
  protected final String[] parameters;
  protected final String sql;

  protected AbstractQuery(AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    this.dao = paramAbstractDao;
    this.daoAccess = new InternalQueryDaoAccess(paramAbstractDao);
    this.sql = paramString;
    this.parameters = paramArrayOfString;
    this.ownerThread = Thread.currentThread();
  }

  protected static String[] toStringArray(Object[] paramArrayOfObject)
  {
    int i = paramArrayOfObject.length;
    String[] arrayOfString = new String[i];
    int j = 0;
    if (j < i)
    {
      Object localObject = paramArrayOfObject[j];
      if (localObject != null)
        arrayOfString[j] = localObject.toString();
      while (true)
      {
        j++;
        break;
        arrayOfString[j] = null;
      }
    }
    return arrayOfString;
  }

  protected void checkThread()
  {
    if (Thread.currentThread() != this.ownerThread)
      throw new DaoException("Method may be called only in owner thread, use forCurrentThread to get an instance for this thread");
  }

  public void setParameter(int paramInt, Object paramObject)
  {
    checkThread();
    if (paramObject != null)
    {
      this.parameters[paramInt] = paramObject.toString();
      return;
    }
    this.parameters[paramInt] = null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.AbstractQuery
 * JD-Core Version:    0.6.2
 */