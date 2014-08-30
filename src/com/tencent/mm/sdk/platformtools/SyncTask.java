package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.Looper;

public abstract class SyncTask<R>
{
  private R a;
  private Object b = new Object();
  private final long c;
  private long d;
  private long e;
  private Runnable f = new y(this);

  public SyncTask()
  {
    this(0L, null);
  }

  public SyncTask(long paramLong, R paramR)
  {
    this.c = paramLong;
    this.a = paramR;
  }

  public R exec(Handler paramHandler)
  {
    if (paramHandler == null)
    {
      Log.d("MicroMsg.SDK.SyncTask", "null handler, task in exec thread, return now");
      return run();
    }
    if (Thread.currentThread().getId() == paramHandler.getLooper().getThread().getId())
    {
      Log.d("MicroMsg.SDK.SyncTask", "same tid, task in exec thread, return now");
      return run();
    }
    this.d = Util.currentTicks();
    try
    {
      synchronized (this.b)
      {
        paramHandler.post(this.f);
        this.b.wait(this.c);
        long l = Util.ticksToNow(this.d);
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = this.a;
        arrayOfObject[1] = Long.valueOf(l);
        arrayOfObject[2] = Long.valueOf(this.e);
        arrayOfObject[3] = Long.valueOf(l - this.e);
        Log.v("MicroMsg.SDK.SyncTask", "sync task done, return=%s, cost=%d(wait=%d, run=%d)", arrayOfObject);
        return this.a;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
        localInterruptedException.printStackTrace();
    }
  }

  protected abstract R run();

  public void setResult(R paramR)
  {
    this.a = paramR;
    synchronized (this.b)
    {
      this.b.notify();
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SyncTask
 * JD-Core Version:    0.6.2
 */