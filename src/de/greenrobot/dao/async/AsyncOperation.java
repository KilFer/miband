package de.greenrobot.dao.async;

import android.database.sqlite.SQLiteDatabase;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;

public class AsyncOperation
{
  public static final int FLAG_MERGE_TX = 1;
  public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
  private volatile boolean completed;
  final AbstractDao<Object, Object> dao;
  private final SQLiteDatabase database;
  final int flags;
  volatile int mergedOperationsCount;
  final Object parameter;
  volatile Object result;
  int sequenceNumber;
  volatile Throwable throwable;
  volatile long timeCompleted;
  volatile long timeStarted;
  final AsyncOperation.OperationType type;

  AsyncOperation(AsyncOperation.OperationType paramOperationType, SQLiteDatabase paramSQLiteDatabase, Object paramObject, int paramInt)
  {
    this.type = paramOperationType;
    this.database = paramSQLiteDatabase;
    this.flags = paramInt;
    this.dao = null;
    this.parameter = paramObject;
  }

  AsyncOperation(AsyncOperation.OperationType paramOperationType, AbstractDao<?, ?> paramAbstractDao, Object paramObject, int paramInt)
  {
    this.type = paramOperationType;
    this.flags = paramInt;
    this.dao = paramAbstractDao;
    this.database = null;
    this.parameter = paramObject;
  }

  SQLiteDatabase getDatabase()
  {
    if (this.database != null)
      return this.database;
    return this.dao.getDatabase();
  }

  public long getDuration()
  {
    if (this.timeCompleted == 0L)
      throw new DaoException("This operation did not yet complete");
    return this.timeCompleted - this.timeStarted;
  }

  public int getMergedOperationsCount()
  {
    return this.mergedOperationsCount;
  }

  public Object getParameter()
  {
    return this.parameter;
  }

  public Object getResult()
  {
    try
    {
      if (!this.completed)
        waitForCompletion();
      if (this.throwable != null)
        throw new AsyncDaoException(this, this.throwable);
    }
    finally
    {
    }
    Object localObject2 = this.result;
    return localObject2;
  }

  public int getSequenceNumber()
  {
    return this.sequenceNumber;
  }

  public Throwable getThrowable()
  {
    return this.throwable;
  }

  public long getTimeCompleted()
  {
    return this.timeCompleted;
  }

  public long getTimeStarted()
  {
    return this.timeStarted;
  }

  public AsyncOperation.OperationType getType()
  {
    return this.type;
  }

  public boolean isCompleted()
  {
    return this.completed;
  }

  public boolean isCompletedSucessfully()
  {
    return (this.completed) && (this.throwable == null);
  }

  public boolean isFailed()
  {
    return this.throwable != null;
  }

  public boolean isMergeTx()
  {
    return (0x1 & this.flags) != 0;
  }

  boolean isMergeableWith(AsyncOperation paramAsyncOperation)
  {
    return (paramAsyncOperation != null) && (isMergeTx()) && (paramAsyncOperation.isMergeTx()) && (getDatabase() == paramAsyncOperation.getDatabase());
  }

  void reset()
  {
    this.timeStarted = 0L;
    this.timeCompleted = 0L;
    this.completed = false;
    this.throwable = null;
    this.result = null;
    this.mergedOperationsCount = 0;
  }

  void setCompleted()
  {
    try
    {
      this.completed = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setThrowable(Throwable paramThrowable)
  {
    this.throwable = paramThrowable;
  }

  public Object waitForCompletion()
  {
    try
    {
      while (true)
      {
        boolean bool = this.completed;
        if (!bool)
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new DaoException("Interrupted while waiting for operation to complete", localInterruptedException);
          }
      }
    }
    finally
    {
    }
    Object localObject2 = this.result;
    return localObject2;
  }

  public boolean waitForCompletion(int paramInt)
  {
    try
    {
      boolean bool1 = this.completed;
      long l;
      if (!bool1)
        l = paramInt;
      try
      {
        wait(l);
        boolean bool2 = this.completed;
        return bool2;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new DaoException("Interrupted while waiting for operation to complete", localInterruptedException);
      }
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.async.AsyncOperation
 * JD-Core Version:    0.6.2
 */