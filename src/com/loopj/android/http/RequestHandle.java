package com.loopj.android.http;

import java.lang.ref.WeakReference;

public class RequestHandle
{
  private final WeakReference<AsyncHttpRequest> a;

  public RequestHandle(AsyncHttpRequest paramAsyncHttpRequest)
  {
    this.a = new WeakReference(paramAsyncHttpRequest);
  }

  public boolean cancel(boolean paramBoolean)
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.a.get();
    return (localAsyncHttpRequest == null) || (localAsyncHttpRequest.cancel(paramBoolean));
  }

  public boolean isCancelled()
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.a.get();
    return (localAsyncHttpRequest == null) || (localAsyncHttpRequest.isCancelled());
  }

  public boolean isFinished()
  {
    AsyncHttpRequest localAsyncHttpRequest = (AsyncHttpRequest)this.a.get();
    return (localAsyncHttpRequest == null) || (localAsyncHttpRequest.isDone());
  }

  public boolean shouldBeGarbageCollected()
  {
    if ((!isCancelled()) && (!isFinished()));
    for (boolean bool = false; ; bool = true)
    {
      if (bool)
        this.a.clear();
      return bool;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.RequestHandle
 * JD-Core Version:    0.6.2
 */