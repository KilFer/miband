package com.tencent.connect.common;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.tencent.tauth.IRequestListener;
import com.tencent.tauth.IUiListener;
import com.tencent.utils.HttpUtils.HttpStatusException;
import com.tencent.utils.HttpUtils.NetworkUnavailableException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseApi$TempRequestListener
  implements IRequestListener
{
  private IUiListener a;
  private Handler b;

  public BaseApi$TempRequestListener(BaseApi paramBaseApi, IUiListener paramIUiListener)
  {
    this.a = paramIUiListener;
    this.b = new a(this, paramBaseApi.mContext.getMainLooper(), paramBaseApi);
  }

  public void onComplete(JSONObject paramJSONObject)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramJSONObject;
    localMessage.what = 0;
    this.b.sendMessage(localMessage);
  }

  public void onConnectTimeoutException(ConnectTimeoutException paramConnectTimeoutException)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramConnectTimeoutException.getMessage();
    localMessage.what = -7;
    this.b.sendMessage(localMessage);
  }

  public void onHttpStatusException(HttpUtils.HttpStatusException paramHttpStatusException)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramHttpStatusException.getMessage();
    localMessage.what = -9;
    this.b.sendMessage(localMessage);
  }

  public void onIOException(IOException paramIOException)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramIOException.getMessage();
    localMessage.what = -2;
    this.b.sendMessage(localMessage);
  }

  public void onJSONException(JSONException paramJSONException)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramJSONException.getMessage();
    localMessage.what = -4;
    this.b.sendMessage(localMessage);
  }

  public void onMalformedURLException(MalformedURLException paramMalformedURLException)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramMalformedURLException.getMessage();
    localMessage.what = -3;
    this.b.sendMessage(localMessage);
  }

  public void onNetworkUnavailableException(HttpUtils.NetworkUnavailableException paramNetworkUnavailableException)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramNetworkUnavailableException.getMessage();
    localMessage.what = -10;
    this.b.sendMessage(localMessage);
  }

  public void onSocketTimeoutException(SocketTimeoutException paramSocketTimeoutException)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramSocketTimeoutException.getMessage();
    localMessage.what = -8;
    this.b.sendMessage(localMessage);
  }

  public void onUnknowException(Exception paramException)
  {
    Message localMessage = this.b.obtainMessage();
    localMessage.obj = paramException.getMessage();
    localMessage.what = -6;
    this.b.sendMessage(localMessage);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.common.BaseApi.TempRequestListener
 * JD-Core Version:    0.6.2
 */