package de.greenrobot.event;

import java.util.concurrent.ExecutorService;

final class BackgroundPoster
  implements Runnable
{
  private final EventBus eventBus;
  private volatile boolean executorRunning;
  private final PendingPostQueue queue;

  BackgroundPoster(EventBus paramEventBus)
  {
    this.eventBus = paramEventBus;
    this.queue = new PendingPostQueue();
  }

  public final void enqueue(Subscription paramSubscription, Object paramObject)
  {
    PendingPost localPendingPost = PendingPost.obtainPendingPost(paramSubscription, paramObject);
    try
    {
      this.queue.enqueue(localPendingPost);
      if (!this.executorRunning)
      {
        this.executorRunning = true;
        EventBus.executorService.execute(this);
      }
      return;
    }
    finally
    {
    }
  }

  public final void run()
  {
    try
    {
      localPendingPost = this.queue.poll(1000);
      if (localPendingPost != null);
    }
    catch (InterruptedException localInterruptedException)
    {
    }
    finally
    {
      PendingPost localPendingPost;
      this.executorRunning = false;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.BackgroundPoster
 * JD-Core Version:    0.6.2
 */