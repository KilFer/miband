package de.greenrobot.event;

import java.util.concurrent.ExecutorService;

class AsyncPoster
  implements Runnable
{
  private final EventBus eventBus;
  private final PendingPostQueue queue;

  AsyncPoster(EventBus paramEventBus)
  {
    this.eventBus = paramEventBus;
    this.queue = new PendingPostQueue();
  }

  public void enqueue(Subscription paramSubscription, Object paramObject)
  {
    PendingPost localPendingPost = PendingPost.obtainPendingPost(paramSubscription, paramObject);
    this.queue.enqueue(localPendingPost);
    EventBus.executorService.execute(this);
  }

  public void run()
  {
    PendingPost localPendingPost = this.queue.poll();
    if (localPendingPost == null)
      throw new IllegalStateException("No pending post available");
    this.eventBus.invokeSubscriber(localPendingPost);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.AsyncPoster
 * JD-Core Version:    0.6.2
 */