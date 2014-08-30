package com.loopj.android.http;

import android.util.Log;
import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonHttpResponseHandler extends TextHttpResponseHandler
{
  private static final String a = "JsonHttpResponseHandler";

  public JsonHttpResponseHandler()
  {
    super("UTF-8");
  }

  public JsonHttpResponseHandler(String paramString)
  {
    super(paramString);
  }

  public void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable)
  {
  }

  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONArray paramJSONArray)
  {
  }

  public void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, JSONObject paramJSONObject)
  {
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte, Throwable paramThrowable)
  {
    if (paramArrayOfByte != null)
    {
      s locals = new s(this, paramArrayOfByte, paramInt, paramArrayOfHeader, paramThrowable);
      if (!getUseSynchronousMode())
      {
        new Thread(locals).start();
        return;
      }
      locals.run();
      return;
    }
    Log.v("JsonHttpResponseHandler", "response body is null, calling onFailure(Throwable, JSONObject)");
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, null);
  }

  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
  }

  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONArray paramJSONArray)
  {
  }

  public void onSuccess(int paramInt, Header[] paramArrayOfHeader, JSONObject paramJSONObject)
  {
  }

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, byte[] paramArrayOfByte)
  {
    if (paramInt != 204)
    {
      p localp = new p(this, paramArrayOfByte, paramInt, paramArrayOfHeader);
      if (!getUseSynchronousMode())
      {
        new Thread(localp).start();
        return;
      }
      localp.run();
      return;
    }
    onSuccess(paramInt, paramArrayOfHeader, new JSONObject());
  }

  protected Object parseResponse(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    if (paramArrayOfByte == null);
    while (true)
    {
      return localObject1;
      String str = getResponseString(paramArrayOfByte, getCharset());
      Object localObject3;
      if (str != null)
      {
        str = str.trim();
        if ((str.startsWith("{")) || (str.startsWith("[")))
        {
          localObject3 = new JSONTokener(str).nextValue();
          localObject1 = str;
        }
      }
      for (Object localObject2 = localObject3; localObject2 != null; localObject2 = null)
      {
        return localObject2;
        localObject1 = str;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.JsonHttpResponseHandler
 * JD-Core Version:    0.6.2
 */