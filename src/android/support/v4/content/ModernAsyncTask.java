package android.support.v4.content;

import android.os.Message;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

abstract class ModernAsyncTask<Params, Progress, Result>
{
  private static final String a = "AsyncTask";
  public static final Executor b = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, g, f);
  private static final int c = 5;
  private static final int d = 128;
  private static final int e = 1;
  private static final ThreadFactory f = new o();
  private static final BlockingQueue<Runnable> g = new LinkedBlockingQueue(10);
  private static final int h = 1;
  private static final int i = 2;
  private static final t j = new t((byte)0);
  private static volatile Executor k = b;
  private final u<Params, Result> l = new p(this);
  private final FutureTask<Result> m = new q(this, this.l);
  private volatile ModernAsyncTask.Status n = ModernAsyncTask.Status.PENDING;
  private final AtomicBoolean o = new AtomicBoolean();

  private Result a(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.m.get(paramLong, paramTimeUnit);
  }

  private static void a(Runnable paramRunnable)
  {
    k.execute(paramRunnable);
  }

  private static void a(Executor paramExecutor)
  {
    k = paramExecutor;
  }

  private ModernAsyncTask<Params, Progress, Result> b(Params[] paramArrayOfParams)
  {
    return a(k, paramArrayOfParams);
  }

  protected static void b()
  {
  }

  private void b(Result paramResult)
  {
    if (!this.o.get())
      c(paramResult);
  }

  private Result c(Result paramResult)
  {
    j.obtainMessage(1, new j(this, new Object[] { paramResult })).sendToTarget();
    return paramResult;
  }

  private static void c()
  {
    j.getLooper();
  }

  private void c(Progress[] paramArrayOfProgress)
  {
    if (!this.m.isCancelled())
      j.obtainMessage(2, new j(this, paramArrayOfProgress)).sendToTarget();
  }

  private ModernAsyncTask.Status d()
  {
    return this.n;
  }

  private void d(Result paramResult)
  {
    if (this.m.isCancelled())
      a();
    while (true)
    {
      this.n = ModernAsyncTask.Status.FINISHED;
      return;
      a(paramResult);
    }
  }

  private static void e()
  {
  }

  private void f()
  {
    a();
  }

  private boolean g()
  {
    return this.m.isCancelled();
  }

  private Result h()
  {
    return this.m.get();
  }

  public final ModernAsyncTask<Params, Progress, Result> a(Executor paramExecutor, Params[] paramArrayOfParams)
  {
    if (this.n != ModernAsyncTask.Status.PENDING);
    switch (r.a[this.n.ordinal()])
    {
    default:
      this.n = ModernAsyncTask.Status.RUNNING;
      this.l.a = paramArrayOfParams;
      paramExecutor.execute(this.m);
      return this;
    case 1:
      throw new IllegalStateException("Cannot execute task: the task is already running.");
    case 2:
    }
    throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
  }

  protected abstract Result a(Params[] paramArrayOfParams);

  protected void a()
  {
  }

  protected void a(Result paramResult)
  {
  }

  public final boolean a(boolean paramBoolean)
  {
    return this.m.cancel(false);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.content.ModernAsyncTask
 * JD-Core Version:    0.6.2
 */