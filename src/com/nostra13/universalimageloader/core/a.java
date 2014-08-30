package com.nostra13.universalimageloader.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class a
  implements ThreadFactory
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private final ThreadGroup b;
  private final AtomicInteger c = new AtomicInteger(1);
  private final String d;
  private final int e;

  a(int paramInt, String paramString)
  {
    this.e = paramInt;
    SecurityManager localSecurityManager = System.getSecurityManager();
    if (localSecurityManager != null);
    for (ThreadGroup localThreadGroup = localSecurityManager.getThreadGroup(); ; localThreadGroup = Thread.currentThread().getThreadGroup())
    {
      this.b = localThreadGroup;
      this.d = (paramString + a.getAndIncrement() + "-thread-");
      return;
    }
  }

  public final Thread newThread(Runnable paramRunnable)
  {
    Thread localThread = new Thread(this.b, paramRunnable, this.d + this.c.getAndIncrement(), 0L);
    if (localThread.isDaemon())
      localThread.setDaemon(false);
    localThread.setPriority(this.e);
    return localThread;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.a
 * JD-Core Version:    0.6.2
 */