package de.greenrobot.dao.async;

import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.DaoLog;
import de.greenrobot.dao.query.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class AsyncOperationExecutor
  implements Handler.Callback, Runnable
{
  private static ExecutorService executorService = Executors.newCachedThreadPool();
  private int countOperationsCompleted;
  private int countOperationsEnqueued;
  private volatile boolean executorRunning;
  private Handler handlerMainThread;
  private int lastSequenceNumber;
  private volatile AsyncOperationListener listener;
  private volatile AsyncOperationListener listenerMainThread;
  private volatile int maxOperationCountToMerge = 50;
  private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue();
  private volatile int waitForMergeMillis = 50;

  private void executeOperation(AsyncOperation paramAsyncOperation)
  {
    paramAsyncOperation.timeStarted = System.currentTimeMillis();
    try
    {
      switch (AsyncOperationExecutor.1.$SwitchMap$de$greenrobot$dao$async$AsyncOperation$OperationType[paramAsyncOperation.type.ordinal()])
      {
      default:
        throw new DaoException("Unsupported operation: " + paramAsyncOperation.type);
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      case 8:
      case 9:
      case 10:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 17:
      case 18:
      case 19:
      case 20:
      case 21:
      case 22:
      }
    }
    catch (Throwable localThrowable)
    {
      paramAsyncOperation.throwable = localThrowable;
    }
    while (true)
    {
      paramAsyncOperation.timeCompleted = System.currentTimeMillis();
      return;
      paramAsyncOperation.dao.delete(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.deleteInTx((Iterable)paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.deleteInTx((Object[])paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insert(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertInTx((Iterable)paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertInTx((Object[])paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertOrReplace(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertOrReplaceInTx((Iterable)paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.insertOrReplaceInTx((Object[])paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.update(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.updateInTx((Iterable)paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.updateInTx((Object[])paramAsyncOperation.parameter);
      continue;
      executeTransactionRunnable(paramAsyncOperation);
      continue;
      executeTransactionCallable(paramAsyncOperation);
      continue;
      paramAsyncOperation.result = ((Query)paramAsyncOperation.parameter).list();
      continue;
      paramAsyncOperation.result = ((Query)paramAsyncOperation.parameter).unique();
      continue;
      paramAsyncOperation.dao.deleteByKey(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.dao.deleteAll();
      continue;
      paramAsyncOperation.result = paramAsyncOperation.dao.load(paramAsyncOperation.parameter);
      continue;
      paramAsyncOperation.result = paramAsyncOperation.dao.loadAll();
      continue;
      paramAsyncOperation.result = Long.valueOf(paramAsyncOperation.dao.count());
      continue;
      paramAsyncOperation.dao.refresh(paramAsyncOperation.parameter);
    }
  }

  private void executeOperationAndPostCompleted(AsyncOperation paramAsyncOperation)
  {
    executeOperation(paramAsyncOperation);
    handleOperationCompleted(paramAsyncOperation);
  }

  private void executeTransactionCallable(AsyncOperation paramAsyncOperation)
  {
    SQLiteDatabase localSQLiteDatabase = paramAsyncOperation.getDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      paramAsyncOperation.result = ((Callable)paramAsyncOperation.parameter).call();
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  private void executeTransactionRunnable(AsyncOperation paramAsyncOperation)
  {
    SQLiteDatabase localSQLiteDatabase = paramAsyncOperation.getDatabase();
    localSQLiteDatabase.beginTransaction();
    try
    {
      ((Runnable)paramAsyncOperation.parameter).run();
      localSQLiteDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localSQLiteDatabase.endTransaction();
    }
  }

  private void handleOperationCompleted(AsyncOperation paramAsyncOperation)
  {
    paramAsyncOperation.setCompleted();
    AsyncOperationListener localAsyncOperationListener = this.listener;
    if (localAsyncOperationListener != null)
      localAsyncOperationListener.onAsyncOperationCompleted(paramAsyncOperation);
    if (this.listenerMainThread != null)
    {
      if (this.handlerMainThread == null)
        this.handlerMainThread = new Handler(Looper.getMainLooper(), this);
      Message localMessage = this.handlerMainThread.obtainMessage(1, paramAsyncOperation);
      this.handlerMainThread.sendMessage(localMessage);
    }
    try
    {
      this.countOperationsCompleted = (1 + this.countOperationsCompleted);
      if (this.countOperationsCompleted == this.countOperationsEnqueued)
        notifyAll();
      return;
    }
    finally
    {
    }
  }

  private void mergeTxAndExecute(AsyncOperation paramAsyncOperation1, AsyncOperation paramAsyncOperation2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAsyncOperation1);
    localArrayList.add(paramAsyncOperation2);
    SQLiteDatabase localSQLiteDatabase = paramAsyncOperation1.getDatabase();
    localSQLiteDatabase.beginTransaction();
    for (int i = 0; ; i++)
      while (true)
      {
        AsyncOperation localAsyncOperation5;
        try
        {
          if (i >= localArrayList.size())
            break label289;
          AsyncOperation localAsyncOperation3 = (AsyncOperation)localArrayList.get(i);
          executeOperation(localAsyncOperation3);
          boolean bool = localAsyncOperation3.isFailed();
          if (bool)
          {
            j = 1;
            localSQLiteDatabase.endTransaction();
            if (j == 0)
              break label238;
            DaoLog.i("Revered merged transaction because one of the operations failed. Executing operations one by one instead...");
            Iterator localIterator2 = localArrayList.iterator();
            if (!localIterator2.hasNext())
              break label288;
            AsyncOperation localAsyncOperation2 = (AsyncOperation)localIterator2.next();
            localAsyncOperation2.reset();
            executeOperationAndPostCompleted(localAsyncOperation2);
            continue;
          }
          if (i != -1 + localArrayList.size())
            break;
          AsyncOperation localAsyncOperation4 = (AsyncOperation)this.queue.peek();
          if ((i >= this.maxOperationCountToMerge) || (!localAsyncOperation3.isMergeableWith(localAsyncOperation4)))
            break label230;
          localAsyncOperation5 = (AsyncOperation)this.queue.remove();
          if (localAsyncOperation5 != localAsyncOperation4)
            throw new DaoException("Internal error: peeked op did not match removed op");
        }
        finally
        {
          localSQLiteDatabase.endTransaction();
        }
        localArrayList.add(localAsyncOperation5);
        break;
        label230: localSQLiteDatabase.setTransactionSuccessful();
        break;
        label238: int k = localArrayList.size();
        Iterator localIterator1 = localArrayList.iterator();
        while (localIterator1.hasNext())
        {
          AsyncOperation localAsyncOperation1 = (AsyncOperation)localIterator1.next();
          localAsyncOperation1.mergedOperationsCount = k;
          handleOperationCompleted(localAsyncOperation1);
        }
        label288: return;
        label289: int j = 0;
      }
  }

  public void enqueue(AsyncOperation paramAsyncOperation)
  {
    try
    {
      int i = 1 + this.lastSequenceNumber;
      this.lastSequenceNumber = i;
      paramAsyncOperation.sequenceNumber = i;
      this.queue.add(paramAsyncOperation);
      this.countOperationsEnqueued = (1 + this.countOperationsEnqueued);
      if (!this.executorRunning)
      {
        this.executorRunning = true;
        executorService.execute(this);
      }
      return;
    }
    finally
    {
    }
  }

  public AsyncOperationListener getListener()
  {
    return this.listener;
  }

  public AsyncOperationListener getListenerMainThread()
  {
    return this.listenerMainThread;
  }

  public int getMaxOperationCountToMerge()
  {
    return this.maxOperationCountToMerge;
  }

  public int getWaitForMergeMillis()
  {
    return this.waitForMergeMillis;
  }

  public boolean handleMessage(Message paramMessage)
  {
    AsyncOperationListener localAsyncOperationListener = this.listenerMainThread;
    if (localAsyncOperationListener != null)
      localAsyncOperationListener.onAsyncOperationCompleted((AsyncOperation)paramMessage.obj);
    return false;
  }

  public boolean isCompleted()
  {
    try
    {
      int i = this.countOperationsEnqueued;
      int j = this.countOperationsCompleted;
      if (i == j)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public void run()
  {
    while (true)
    {
      AsyncOperation localAsyncOperation1;
      AsyncOperation localAsyncOperation4;
      try
      {
        localAsyncOperation1 = (AsyncOperation)this.queue.poll(1L, TimeUnit.SECONDS);
        if (localAsyncOperation1 != null)
          break label195;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
      finally
      {
        AsyncOperation localAsyncOperation2;
        this.executorRunning = false;
      }
      executeOperationAndPostCompleted(localAsyncOperation3);
      executeOperationAndPostCompleted(localAsyncOperation4);
      continue;
      executeOperationAndPostCompleted(localAsyncOperation3);
      continue;
      label195: AsyncOperation localAsyncOperation3 = localAsyncOperation1;
    }
  }

  public void setListener(AsyncOperationListener paramAsyncOperationListener)
  {
    this.listener = paramAsyncOperationListener;
  }

  public void setListenerMainThread(AsyncOperationListener paramAsyncOperationListener)
  {
    this.listenerMainThread = paramAsyncOperationListener;
  }

  public void setMaxOperationCountToMerge(int paramInt)
  {
    this.maxOperationCountToMerge = paramInt;
  }

  public void setWaitForMergeMillis(int paramInt)
  {
    this.waitForMergeMillis = paramInt;
  }

  public void waitForCompletion()
  {
    try
    {
      while (true)
      {
        boolean bool = isCompleted();
        if (!bool)
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            throw new DaoException("Interrupted while waiting for all operations to complete", localInterruptedException);
          }
      }
    }
    finally
    {
    }
  }

  public boolean waitForCompletion(int paramInt)
  {
    try
    {
      boolean bool1 = isCompleted();
      long l;
      if (!bool1)
        l = paramInt;
      try
      {
        wait(l);
        boolean bool2 = isCompleted();
        return bool2;
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new DaoException("Interrupted while waiting for all operations to complete", localInterruptedException);
      }
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.async.AsyncOperationExecutor
 * JD-Core Version:    0.6.2
 */