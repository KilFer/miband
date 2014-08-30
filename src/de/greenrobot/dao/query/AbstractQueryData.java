package de.greenrobot.dao.query;

import android.os.Process;
import android.util.SparseArray;
import de.greenrobot.dao.AbstractDao;
import java.lang.ref.WeakReference;

abstract class AbstractQueryData<T, Q extends AbstractQuery<T>>
{
  final AbstractDao<T, ?> dao;
  final String[] initialValues;
  final SparseArray<WeakReference<Q>> queriesForThreads;
  final String sql;

  AbstractQueryData(AbstractDao<T, ?> paramAbstractDao, String paramString, String[] paramArrayOfString)
  {
    this.dao = paramAbstractDao;
    this.sql = paramString;
    this.initialValues = paramArrayOfString;
    this.queriesForThreads = new SparseArray();
  }

  protected abstract Q createQuery();

  Q forCurrentThread()
  {
    int i = Process.myTid();
    while (true)
    {
      synchronized (this.queriesForThreads)
      {
        WeakReference localWeakReference = (WeakReference)this.queriesForThreads.get(i);
        if (localWeakReference != null)
        {
          localAbstractQuery = (AbstractQuery)localWeakReference.get();
          if (localAbstractQuery == null)
          {
            gc();
            localAbstractQuery = createQuery();
            this.queriesForThreads.put(i, new WeakReference(localAbstractQuery));
            return localAbstractQuery;
          }
          System.arraycopy(this.initialValues, 0, localAbstractQuery.parameters, 0, this.initialValues.length);
        }
      }
      AbstractQuery localAbstractQuery = null;
    }
  }

  Q forCurrentThread(Q paramQ)
  {
    if (Thread.currentThread() == paramQ.ownerThread)
    {
      System.arraycopy(this.initialValues, 0, paramQ.parameters, 0, this.initialValues.length);
      return paramQ;
    }
    return forCurrentThread();
  }

  void gc()
  {
    while (true)
    {
      int i;
      synchronized (this.queriesForThreads)
      {
        i = -1 + this.queriesForThreads.size();
        if (i >= 0)
        {
          if (((WeakReference)this.queriesForThreads.valueAt(i)).get() == null)
            this.queriesForThreads.remove(this.queriesForThreads.keyAt(i));
        }
        else
          return;
      }
      i--;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.AbstractQueryData
 * JD-Core Version:    0.6.2
 */