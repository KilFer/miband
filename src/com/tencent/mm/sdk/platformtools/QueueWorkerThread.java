package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class QueueWorkerThread
{
  private LinkedBlockingQueue<QueueWorkerThread.ThreadObject> a = new LinkedBlockingQueue();
  private boolean b = false;
  private int c = 1;
  private int d = 1;
  private String e = "";
  private Object f = new byte[0];
  private Vector<v> g = new Vector();
  private Handler h = new u(this);

  public QueueWorkerThread(int paramInt, String paramString)
  {
    this(paramInt, paramString, 1);
  }

  public QueueWorkerThread(int paramInt1, String paramString, int paramInt2)
  {
    this.c = paramInt2;
    this.e = paramString;
    this.d = paramInt1;
  }

  public int add(QueueWorkerThread.ThreadObject paramThreadObject)
  {
    int j;
    if (paramThreadObject == null)
    {
      Log.e("QueueWorkerThread.QueueWorkerThread", "add empty thread object");
      j = -1;
    }
    int k;
    int m;
    do
    {
      int i;
      do
      {
        return j;
        try
        {
          if (!this.a.offer(paramThreadObject, 1L, TimeUnit.MILLISECONDS))
          {
            Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed");
            return -2;
          }
        }
        catch (Exception localException)
        {
          Log.e("QueueWorkerThread.QueueWorkerThread", "add To Queue failed :" + localException.getMessage());
          localException.printStackTrace();
          return -3;
        }
        if (this.g.size() == 0)
          break;
        i = this.a.size();
        j = 0;
      }
      while (i <= 0);
      k = this.c;
      m = this.g.size();
      j = 0;
    }
    while (k <= m);
    new v(this, (byte)0).start();
    return 0;
  }

  public int getQueueSize()
  {
    return this.a.size();
  }

  public boolean isDead()
  {
    return (this.g == null) || (this.g.size() == 0);
  }

  public void pause(boolean paramBoolean)
  {
    synchronized (this.f)
    {
      this.b = paramBoolean;
      if (!paramBoolean);
      synchronized (this.f)
      {
        this.f.notifyAll();
        return;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.QueueWorkerThread
 * JD-Core Version:    0.6.2
 */