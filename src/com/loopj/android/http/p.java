package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONException;

final class p
  implements Runnable
{
  p(JsonHttpResponseHandler paramJsonHttpResponseHandler, byte[] paramArrayOfByte, int paramInt, Header[] paramArrayOfHeader)
  {
  }

  public final void run()
  {
    try
    {
      Object localObject = this.a.parseResponse(this.b);
      this.a.postRunnable(new q(this, localObject, this.c, this.d));
      return;
    }
    catch (JSONException localJSONException)
    {
      this.a.postRunnable(new r(this, this.c, this.d, localJSONException));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.p
 * JD-Core Version:    0.6.2
 */