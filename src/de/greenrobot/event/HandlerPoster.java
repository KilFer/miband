package de.greenrobot.event;

import android.os.Handler;
import android.os.Looper;

final class HandlerPoster extends Handler
{
  private final EventBus eventBus;
  private boolean handlerActive;
  private final int maxMillisInsideHandleMessage;
  private final PendingPostQueue queue;

  HandlerPoster(EventBus paramEventBus, Looper paramLooper, int paramInt)
  {
    super(paramLooper);
    this.eventBus = paramEventBus;
    this.maxMillisInsideHandleMessage = paramInt;
    this.queue = new PendingPostQueue();
  }

  final void enqueue(Subscription paramSubscription, Object paramObject)
  {
    PendingPost localPendingPost = PendingPost.obtainPendingPost(paramSubscription, paramObject);
    try
    {
      this.queue.enqueue(localPendingPost);
      if (!this.handlerActive)
      {
        this.handlerActive = true;
        if (!sendMessage(obtainMessage()))
          throw new EventBusException("Could not send handler message");
      }
    }
    finally
    {
    }
  }

  // ERROR //
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: invokestatic 64	android/os/SystemClock:uptimeMillis	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 28	de/greenrobot/event/HandlerPoster:queue	Lde/greenrobot/event/PendingPostQueue;
    //   8: invokevirtual 68	de/greenrobot/event/PendingPostQueue:poll	()Lde/greenrobot/event/PendingPost;
    //   11: astore 5
    //   13: aload 5
    //   15: ifnonnull +34 -> 49
    //   18: aload_0
    //   19: monitorenter
    //   20: aload_0
    //   21: getfield 28	de/greenrobot/event/HandlerPoster:queue	Lde/greenrobot/event/PendingPostQueue;
    //   24: invokevirtual 68	de/greenrobot/event/PendingPostQueue:poll	()Lde/greenrobot/event/PendingPost;
    //   27: astore 5
    //   29: aload 5
    //   31: ifnonnull +16 -> 47
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 41	de/greenrobot/event/HandlerPoster:handlerActive	Z
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 41	de/greenrobot/event/HandlerPoster:handlerActive	Z
    //   46: return
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: getfield 19	de/greenrobot/event/HandlerPoster:eventBus	Lde/greenrobot/event/EventBus;
    //   53: aload 5
    //   55: invokevirtual 73	de/greenrobot/event/EventBus:invokeSubscriber	(Lde/greenrobot/event/PendingPost;)V
    //   58: invokestatic 64	android/os/SystemClock:uptimeMillis	()J
    //   61: lload_3
    //   62: lsub
    //   63: aload_0
    //   64: getfield 21	de/greenrobot/event/HandlerPoster:maxMillisInsideHandleMessage	I
    //   67: i2l
    //   68: lcmp
    //   69: iflt -65 -> 4
    //   72: aload_0
    //   73: aload_0
    //   74: invokevirtual 45	de/greenrobot/event/HandlerPoster:obtainMessage	()Landroid/os/Message;
    //   77: invokevirtual 49	de/greenrobot/event/HandlerPoster:sendMessage	(Landroid/os/Message;)Z
    //   80: ifne +28 -> 108
    //   83: new 51	de/greenrobot/event/EventBusException
    //   86: dup
    //   87: ldc 53
    //   89: invokespecial 56	de/greenrobot/event/EventBusException:<init>	(Ljava/lang/String;)V
    //   92: athrow
    //   93: astore_2
    //   94: aload_0
    //   95: iconst_0
    //   96: putfield 41	de/greenrobot/event/HandlerPoster:handlerActive	Z
    //   99: aload_2
    //   100: athrow
    //   101: astore 6
    //   103: aload_0
    //   104: monitorexit
    //   105: aload 6
    //   107: athrow
    //   108: aload_0
    //   109: iconst_1
    //   110: putfield 41	de/greenrobot/event/HandlerPoster:handlerActive	Z
    //   113: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	4	93	finally
    //   4	13	93	finally
    //   18	20	93	finally
    //   47	49	93	finally
    //   49	93	93	finally
    //   103	108	93	finally
    //   20	29	101	finally
    //   34	41	101	finally
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.HandlerPoster
 * JD-Core Version:    0.6.2
 */