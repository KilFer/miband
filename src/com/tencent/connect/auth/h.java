package com.tencent.connect.auth;

import android.os.Handler;
import android.os.Message;
import com.tencent.a.a.c;
import com.tencent.tauth.IRequestListener;
import com.tencent.utils.HttpUtils.HttpStatusException;
import com.tencent.utils.HttpUtils.NetworkUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

final class h
  implements IRequestListener
{
  public h(AuthAgent paramAuthAgent)
  {
    c.b("openSDK_LOG", "OpenUi, RequestListener()");
  }

  public final void onComplete(JSONObject paramJSONObject)
  {
    c.b("openSDK_LOG", "OpenUi, RequestListener() onComplete");
    Message localMessage = new Message();
    localMessage.what = 0;
    localMessage.obj = paramJSONObject;
    AuthAgent.h(this.a).sendMessage(localMessage);
  }

  public final void onConnectTimeoutException(ConnectTimeoutException paramConnectTimeoutException)
  {
    c.a("openSDK_LOG", "OpenUi, RequestListener() onConnectTimeoutException", paramConnectTimeoutException);
    Message localMessage = new Message();
    localMessage.what = -7;
    localMessage.obj = paramConnectTimeoutException.getMessage();
    AuthAgent.h(this.a).sendMessage(localMessage);
  }

  public final void onHttpStatusException(HttpUtils.HttpStatusException paramHttpStatusException)
  {
    c.a("openSDK_LOG", "OpenUi, RequestListener() onHttpStatusException", paramHttpStatusException);
    Message localMessage = new Message();
    localMessage.what = -9;
    localMessage.obj = paramHttpStatusException.getMessage();
    AuthAgent.h(this.a).sendMessage(localMessage);
  }

  public final void onIOException(IOException paramIOException)
  {
    c.a("openSDK_LOG", "OpenUi, RequestListener() onIOException", paramIOException);
    Message localMessage = new Message();
    localMessage.what = -2;
    localMessage.obj = paramIOException.getMessage();
    AuthAgent.h(this.a).sendMessage(localMessage);
  }

  public final void onJSONException(JSONException paramJSONException)
  {
    c.a("openSDK_LOG", "OpenUi, RequestListener() onJSONException", paramJSONException);
    Message localMessage = new Message();
    localMessage.what = -4;
    localMessage.obj = paramJSONException.getMessage();
    AuthAgent.h(this.a).sendMessage(localMessage);
  }

  public final void onMalformedURLException(MalformedURLException paramMalformedURLException)
  {
    Message localMessage = new Message();
    localMessage.what = -3;
    localMessage.obj = paramMalformedURLException.getMessage();
    AuthAgent.h(this.a).sendMessage(localMessage);
  }

  public final void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException paramNetworkUnavailableException)
  {
    c.a("openSDK_LOG", "OpenUi, RequestListener() onNetworkUnavailableException", paramNetworkUnavailableException);
    Message localMessage = new Message();
    localMessage.what = -2;
    localMessage.obj = paramNetworkUnavailableException.getMessage();
    AuthAgent.h(this.a).sendMessage(localMessage);
  }

  public final void onSocketTimeoutException(SocketTimeoutException paramSocketTimeoutException)
  {
    c.a("openSDK_LOG", "OpenUi, RequestListener() onSocketTimeoutException", paramSocketTimeoutException);
    Message localMessage = new Message();
    localMessage.what = -8;
    localMessage.obj = paramSocketTimeoutException.getMessage();
    AuthAgent.h(this.a).sendMessage(localMessage);
  }

  public final void onUnknowException(Exception paramException)
  {
    c.a("openSDK_LOG", "OpenUi, RequestListener() onUnknowException", paramException);
    Message localMessage = new Message();
    localMessage.what = -6;
    localMessage.obj = paramException.getMessage();
    AuthAgent.h(this.a).sendMessage(localMessage);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.h
 * JD-Core Version:    0.6.2
 */