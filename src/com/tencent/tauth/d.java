package com.tencent.tauth;

import com.tencent.utils.HttpUtils.HttpStatusException;
import com.tencent.utils.HttpUtils.NetworkUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;

abstract class d
  implements IRequestListener
{
  private d(LocationApi paramLocationApi)
  {
  }

  protected abstract void a(Exception paramException);

  public void onConnectTimeoutException(ConnectTimeoutException paramConnectTimeoutException)
  {
    a(paramConnectTimeoutException);
  }

  public void onHttpStatusException(HttpUtils.HttpStatusException paramHttpStatusException)
  {
    a(paramHttpStatusException);
  }

  public void onIOException(IOException paramIOException)
  {
    a(paramIOException);
  }

  public void onJSONException(JSONException paramJSONException)
  {
    a(paramJSONException);
  }

  public void onMalformedURLException(MalformedURLException paramMalformedURLException)
  {
    a(paramMalformedURLException);
  }

  public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException paramNetworkUnavailableException)
  {
    a(paramNetworkUnavailableException);
  }

  public void onSocketTimeoutException(SocketTimeoutException paramSocketTimeoutException)
  {
    a(paramSocketTimeoutException);
  }

  public void onUnknowException(Exception paramException)
  {
    a(paramException);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.d
 * JD-Core Version:    0.6.2
 */