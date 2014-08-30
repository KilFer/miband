package com.loopj.android.http;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class t
  implements Runnable
{
  t(s params, Object paramObject, int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable)
  {
  }

  public final void run()
  {
    if ((this.b instanceof JSONObject))
    {
      this.a.a.onFailure(this.c, this.d, this.e, (JSONObject)this.b);
      return;
    }
    if ((this.b instanceof JSONArray))
    {
      this.a.a.onFailure(this.c, this.d, this.e, (JSONArray)this.b);
      return;
    }
    if ((this.b instanceof String))
    {
      this.a.a.onFailure(this.c, this.d, (String)this.b, this.e);
      return;
    }
    this.a.a.onFailure(this.c, this.d, new JSONException("Unexpected response type " + this.b.getClass().getName()), null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.t
 * JD-Core Version:    0.6.2
 */