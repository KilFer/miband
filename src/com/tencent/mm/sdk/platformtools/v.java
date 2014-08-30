package com.tencent.mm.sdk.platformtools;

import java.util.Vector;

final class v extends Thread
{
  private int a = 60;

  private v(QueueWorkerThread paramQueueWorkerThread)
  {
    super(QueueWorkerThread.a(paramQueueWorkerThread));
    setPriority(QueueWorkerThread.b(paramQueueWorkerThread));
    QueueWorkerThread.c(paramQueueWorkerThread).add(this);
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/mm/sdk/platformtools/v:a	I
    //   4: ifle +145 -> 149
    //   7: aload_0
    //   8: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   11: invokestatic 50	com/tencent/mm/sdk/platformtools/QueueWorkerThread:d	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/lang/Object;
    //   14: astore_2
    //   15: aload_2
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   21: invokestatic 54	com/tencent/mm/sdk/platformtools/QueueWorkerThread:e	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   31: invokestatic 50	com/tencent/mm/sdk/platformtools/QueueWorkerThread:d	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/lang/Object;
    //   34: invokevirtual 59	java/lang/Object:wait	()V
    //   37: aload_2
    //   38: monitorexit
    //   39: aload_0
    //   40: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   43: invokestatic 63	com/tencent/mm/sdk/platformtools/QueueWorkerThread:f	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/concurrent/LinkedBlockingQueue;
    //   46: ldc2_w 64
    //   49: getstatic 71	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   52: invokevirtual 77	java/util/concurrent/LinkedBlockingQueue:poll	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   55: checkcast 79	com/tencent/mm/sdk/platformtools/QueueWorkerThread$ThreadObject
    //   58: astore 6
    //   60: aload 6
    //   62: ifnonnull +44 -> 106
    //   65: aload_0
    //   66: iconst_m1
    //   67: aload_0
    //   68: getfield 22	com/tencent/mm/sdk/platformtools/v:a	I
    //   71: iadd
    //   72: putfield 22	com/tencent/mm/sdk/platformtools/v:a	I
    //   75: goto -75 -> 0
    //   78: astore 4
    //   80: aload 4
    //   82: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   85: goto -48 -> 37
    //   88: astore_3
    //   89: aload_2
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    //   93: astore 5
    //   95: aload 5
    //   97: invokevirtual 82	java/lang/Exception:printStackTrace	()V
    //   100: aconst_null
    //   101: astore 6
    //   103: goto -43 -> 60
    //   106: aload_0
    //   107: bipush 60
    //   109: putfield 22	com/tencent/mm/sdk/platformtools/v:a	I
    //   112: aload 6
    //   114: invokeinterface 86 1 0
    //   119: ifeq -119 -> 0
    //   122: aload_0
    //   123: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   126: invokestatic 90	com/tencent/mm/sdk/platformtools/QueueWorkerThread:g	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Landroid/os/Handler;
    //   129: aload_0
    //   130: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   133: invokestatic 90	com/tencent/mm/sdk/platformtools/QueueWorkerThread:g	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Landroid/os/Handler;
    //   136: iconst_0
    //   137: aload 6
    //   139: invokevirtual 96	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   142: invokevirtual 100	android/os/Handler:sendMessage	(Landroid/os/Message;)Z
    //   145: pop
    //   146: goto -146 -> 0
    //   149: aload_0
    //   150: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   153: invokestatic 33	com/tencent/mm/sdk/platformtools/QueueWorkerThread:c	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/Vector;
    //   156: aload_0
    //   157: invokevirtual 103	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   160: pop
    //   161: ldc 105
    //   163: new 107	java/lang/StringBuilder
    //   166: dup
    //   167: ldc 109
    //   169: invokespecial 110	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload_0
    //   173: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   176: invokestatic 63	com/tencent/mm/sdk/platformtools/QueueWorkerThread:f	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/concurrent/LinkedBlockingQueue;
    //   179: invokevirtual 114	java/util/concurrent/LinkedBlockingQueue:size	()I
    //   182: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   185: ldc 120
    //   187: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload_0
    //   191: getfield 12	com/tencent/mm/sdk/platformtools/v:b	Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;
    //   194: invokestatic 33	com/tencent/mm/sdk/platformtools/QueueWorkerThread:c	(Lcom/tencent/mm/sdk/platformtools/QueueWorkerThread;)Ljava/util/Vector;
    //   197: invokevirtual 124	java/util/Vector:size	()I
    //   200: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   203: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 133	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: return
    //
    // Exception table:
    //   from	to	target	type
    //   17	37	78	java/lang/Exception
    //   17	37	88	finally
    //   37	39	88	finally
    //   80	85	88	finally
    //   39	60	93	java/lang/Exception
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.v
 * JD-Core Version:    0.6.2
 */