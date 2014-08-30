package com.loopj.android.http;

import org.apache.http.Header;

public abstract class BaseJsonHttpResponseHandler<JSON_TYPE> extends TextHttpResponseHandler
{
  private static final String a = "BaseJsonHttpResponseHandler";

  public BaseJsonHttpResponseHandler()
  {
    this("UTF-8");
  }

  public BaseJsonHttpResponseHandler(String paramString)
  {
    super(paramString);
  }

  public final void onFailure(int paramInt, Header[] paramArrayOfHeader, String paramString, Throwable paramThrowable)
  {
    if (paramString != null)
    {
      m localm = new m(this, paramString, paramInt, paramArrayOfHeader, paramThrowable);
      if (!getUseSynchronousMode())
      {
        new Thread(localm).start();
        return;
      }
      localm.run();
      return;
    }
    onFailure(paramInt, paramArrayOfHeader, paramThrowable, null, null);
  }

  public abstract void onFailure(int paramInt, Header[] paramArrayOfHeader, Throwable paramThrowable, String paramString, JSON_TYPE paramJSON_TYPE);

  public final void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString)
  {
    if (paramInt != 204)
    {
      j localj = new j(this, paramString, paramInt, paramArrayOfHeader);
      if (!getUseSynchronousMode())
      {
        new Thread(localj).start();
        return;
      }
      localj.run();
      return;
    }
    onSuccess(paramInt, paramArrayOfHeader, null, null);
  }

  public abstract void onSuccess(int paramInt, Header[] paramArrayOfHeader, String paramString, JSON_TYPE paramJSON_TYPE);

  protected abstract JSON_TYPE parseResponse(String paramString, boolean paramBoolean);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.BaseJsonHttpResponseHandler
 * JD-Core Version:    0.6.2
 */