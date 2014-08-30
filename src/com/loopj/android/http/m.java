package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

final class m
  implements Runnable
{
  m(BaseJsonHttpResponseHandler paramBaseJsonHttpResponseHandler, String paramString, int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable)
  {
  }

  public final void run()
  {
    try
    {
      Object localObject = this.a.parseResponse(this.b, true);
      this.a.postRunnable(new n(this, this.c, this.d, this.e, this.b, localObject));
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", localThrowable);
      this.a.postRunnable(new o(this, this.c, this.d, this.e, this.b));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.m
 * JD-Core Version:    0.6.2
 */