package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class q
  implements Runnable
{
  q(p paramp, Object paramObject, int paramInt, Header[] paramArrayOfHeader)
  {
  }

  public final void run()
  {
    if ((this.b instanceof JSONObject))
    {
      this.a.a.onSuccess(this.c, this.d, (JSONObject)this.b);
      return;
    }
    if ((this.b instanceof JSONArray))
    {
      this.a.a.onSuccess(this.c, this.d, (JSONArray)this.b);
      return;
    }
    if ((this.b instanceof String))
    {
      this.a.a.onFailure(this.c, this.d, (String)this.b, new JSONException("Response cannot be parsed as JSON data"));
      return;
    }
    this.a.a.onFailure(this.c, this.d, new JSONException("Unexpected response type " + this.b.getClass().getName()), null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.q
 * JD-Core Version:    0.6.2
 */