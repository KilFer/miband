package de.greenrobot.event;

final class PendingPostQueue
{
  private PendingPost head;
  private PendingPost tail;

  final void enqueue(PendingPost paramPendingPost)
  {
    if (paramPendingPost == null)
      try
      {
        throw new NullPointerException("null cannot be enqueued");
      }
      finally
      {
      }
    if (this.tail != null)
    {
      this.tail.next = paramPendingPost;
      this.tail = paramPendingPost;
    }
    while (true)
    {
      notifyAll();
      return;
      if (this.head != null)
        break;
      this.tail = paramPendingPost;
      this.head = paramPendingPost;
    }
    throw new IllegalStateException("Head present, but no tail");
  }

  final PendingPost poll()
  {
    try
    {
      PendingPost localPendingPost = this.head;
      if (this.head != null)
      {
        this.head = this.head.next;
        if (this.head == null)
          this.tail = null;
      }
      return localPendingPost;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final PendingPost poll(int paramInt)
  {
    try
    {
      if (this.head == null)
        wait(paramInt);
      PendingPost localPendingPost = poll();
      return localPendingPost;
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.PendingPostQueue
 * JD-Core Version:    0.6.2
 */