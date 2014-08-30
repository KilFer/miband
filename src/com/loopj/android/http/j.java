package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;

final class j
  implements Runnable
{
  j(BaseJsonHttpResponseHandler paramBaseJsonHttpResponseHandler, String paramString, int paramInt, Header[] paramArrayOfHeader)
  {
  }

  public final void run()
  {
    try
    {
      Object localObject = this.a.parseResponse(this.b, false);
      this.a.postRunnable(new k(this, this.c, this.d, this.b, localObject));
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("BaseJsonHttpResponseHandler", "parseResponse thrown an problem", localThrowable);
      this.a.postRunnable(new l(this, this.c, this.d, localThrowable, this.b));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.j
 * JD-Core Version:    0.6.2
 */