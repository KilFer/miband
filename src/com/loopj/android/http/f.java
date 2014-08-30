package com.loopj.android.http;

import android.os.Handler;
import android.os.Message;

final class f extends Handler
{
  private final AsyncHttpResponseHandler a;

  f(AsyncHttpResponseHandler paramAsyncHttpResponseHandler)
  {
    this.a = paramAsyncHttpResponseHandler;
  }

  public final void handleMessage(Message paramMessage)
  {
    this.a.handleMessage(paramMessage);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.f
 * JD-Core Version:    0.6.2
 */