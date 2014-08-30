package com.tencent.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.connect.auth.QQToken;
import com.tencent.tauth.IRequestListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

final class c extends Thread
{
  c(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener)
  {
  }

  public final void run()
  {
    try
    {
      JSONObject localJSONObject = HttpUtils.request(this.a, this.b, this.c, this.d, this.e);
      if (this.f != null)
      {
        this.f.onComplete(localJSONObject);
        com.tencent.a.a.c.b("openSDK_LOG", "OpenApi onComplete");
      }
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (this.f == null);
      this.f.onMalformedURLException(localMalformedURLException);
      com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync MalformedURLException", localMalformedURLException);
      return;
    }
    catch (ConnectTimeoutException localConnectTimeoutException)
    {
      while (this.f == null);
      this.f.onConnectTimeoutException(localConnectTimeoutException);
      com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onConnectTimeoutException", localConnectTimeoutException);
      return;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      while (this.f == null);
      this.f.onSocketTimeoutException(localSocketTimeoutException);
      com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onSocketTimeoutException", localSocketTimeoutException);
      return;
    }
    catch (HttpUtils.NetworkUnavailableException localNetworkUnavailableException)
    {
      while (this.f == null);
      this.f.onNetworkUnavailableException(localNetworkUnavailableException);
      com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onNetworkUnavailableException", localNetworkUnavailableException);
      return;
    }
    catch (HttpUtils.HttpStatusException localHttpStatusException)
    {
      while (this.f == null);
      this.f.onHttpStatusException(localHttpStatusException);
      com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onHttpStatusException", localHttpStatusException);
      return;
    }
    catch (IOException localIOException)
    {
      while (this.f == null);
      this.f.onIOException(localIOException);
      com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync IOException", localIOException);
      return;
    }
    catch (JSONException localJSONException)
    {
      while (this.f == null);
      this.f.onJSONException(localJSONException);
      com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync JSONException", localJSONException);
      return;
    }
    catch (Exception localException)
    {
      while (this.f == null);
      this.f.onUnknowException(localException);
      com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync onUnknowException", localException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.c
 * JD-Core Version:    0.6.2
 */