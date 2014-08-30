package com.tencent.mm.sdk.platformtools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import junit.framework.Assert;

public class MMHandlerThread
{
  public static long mainThreadID = -1L;
  private HandlerThread a = null;
  private Handler b = null;

  public MMHandlerThread()
  {
    a();
  }

  private void a()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Util.getStack();
    Log.d("MicroMsg.MMHandlerThread", "MMHandlerThread init [%s]", arrayOfObject);
    this.b = null;
    this.a = new HandlerThread("MMHandlerThread", 1);
    this.a.start();
  }

  public static boolean isMainThread()
  {
    if (mainThreadID == -1L);
    for (boolean bool = true; ; bool = false)
    {
      Assert.assertFalse("mainThreadID not init ", bool);
      if (Thread.currentThread().getId() != mainThreadID)
        break;
      return true;
    }
    return false;
  }

  public static void postToMainThread(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      return;
    new Handler(Looper.getMainLooper()).post(paramRunnable);
  }

  public static void postToMainThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable == null)
      return;
    new Handler(Looper.getMainLooper()).postDelayed(paramRunnable, paramLong);
  }

  public static void setMainThreadID(long paramLong)
  {
    if ((mainThreadID < 0L) && (paramLong > 0L))
      mainThreadID = paramLong;
  }

  public Looper getLooper()
  {
    return this.a.getLooper();
  }

  public Handler getWorkerHandler()
  {
    if (this.b == null)
      this.b = new Handler(this.a.getLooper());
    return this.b;
  }

  public int postAtFrontOfWorker(MMHandlerThread.IWaitWorkThread paramIWaitWorkThread)
  {
    if (paramIWaitWorkThread == null)
      return -1;
    if (new Handler(getLooper()).postAtFrontOfQueue(new l(this, paramIWaitWorkThread)))
      return 0;
    return -2;
  }

  public int postToWorker(Runnable paramRunnable)
  {
    if (paramRunnable == null)
      return -1;
    getWorkerHandler().post(paramRunnable);
    return 0;
  }

  public int reset(MMHandlerThread.IWaitWorkThread paramIWaitWorkThread)
  {
    return postAtFrontOfWorker(new j(this, paramIWaitWorkThread));
  }

  // ERROR //
  public int syncReset(MMHandlerThread.ResetCallback paramResetCallback)
  {
    // Byte code:
    //   0: ldc 130
    //   2: invokestatic 132	com/tencent/mm/sdk/platformtools/MMHandlerThread:isMainThread	()Z
    //   5: invokestatic 135	junit/framework/Assert:assertTrue	(Ljava/lang/String;Z)V
    //   8: iconst_0
    //   9: newarray byte
    //   11: astore_2
    //   12: new 137	com/tencent/mm/sdk/platformtools/k
    //   15: dup
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: invokespecial 140	com/tencent/mm/sdk/platformtools/k:<init>	(Lcom/tencent/mm/sdk/platformtools/MMHandlerThread;Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$ResetCallback;Ljava/lang/Object;)V
    //   22: astore_3
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: aload_3
    //   27: invokevirtual 124	com/tencent/mm/sdk/platformtools/MMHandlerThread:postAtFrontOfWorker	(Lcom/tencent/mm/sdk/platformtools/MMHandlerThread$IWaitWorkThread;)I
    //   30: istore 5
    //   32: iload 5
    //   34: ifne +7 -> 41
    //   37: aload_2
    //   38: invokevirtual 143	java/lang/Object:wait	()V
    //   41: aload_2
    //   42: monitorexit
    //   43: iload 5
    //   45: ireturn
    //   46: astore 4
    //   48: aload_2
    //   49: monitorexit
    //   50: aload 4
    //   52: athrow
    //   53: astore 6
    //   55: goto -14 -> 41
    //
    // Exception table:
    //   from	to	target	type
    //   25	32	46	finally
    //   37	41	46	finally
    //   41	43	46	finally
    //   37	41	53	java/lang/Exception
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMHandlerThread
 * JD-Core Version:    0.6.2
 */