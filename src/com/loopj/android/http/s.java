package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

final class s
  implements Runnable
{
  s(JsonHttpResponseHandler paramJsonHttpResponseHandler, byte[] paramArrayOfByte, int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable)
  {
  }

  public final void run()
  {
    try
    {
      Object localObject = this.a.parseResponse(this.b);
      this.a.postRunnable(new t(this, localObject, this.c, this.d, this.e));
      return;
    }
    catch (JSONException localJSONException)
    {
      this.a.postRunnable(new u(this, this.c, this.d, localJSONException));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.s
 * JD-Core Version:    0.6.2
 */