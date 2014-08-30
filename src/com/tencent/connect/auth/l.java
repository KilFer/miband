package com.tencent.connect.auth;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.tencent.tauth.UiError;
import com.tencent.utils.ServerSetting;
import com.tencent.utils.Util;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

final class l extends WebViewClient
{
  private l(AuthDialog paramAuthDialog)
  {
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((AuthDialog.b() != null) && (AuthDialog.b().get() != null))
      ((View)AuthDialog.b().get()).setVisibility(8);
    AuthDialog.d(this.a).setVisibility(0);
  }

  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    Util.logd("AuthDialog", "Webview loading URL: " + paramString);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if ((AuthDialog.b() != null) && (AuthDialog.b().get() != null))
      ((View)AuthDialog.b().get()).setVisibility(0);
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    AuthDialog.e(this.a).onError(new UiError(paramInt, paramString1, paramString2));
    if ((AuthDialog.a() != null) && (AuthDialog.a().get() != null))
      Toast.makeText((Context)AuthDialog.a().get(), "网络连接异常或系统错误", 0).show();
    this.a.dismiss();
  }

  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.proceed();
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Util.logd("AuthDialog", "Redirect URL: " + paramString);
    if (paramString.startsWith("auth://browser"))
    {
      JSONObject localJSONObject = Util.parseUrlToJson(paramString);
      AuthDialog.a(this.a, AuthDialog.a(this.a));
      if (!AuthDialog.b(this.a))
      {
        if (localJSONObject.optString("fail_cb", null) == null)
          break label90;
        this.a.callJs(localJSONObject.optString("fail_cb"), "");
      }
      while (true)
      {
        return true;
        label90: if (localJSONObject.optInt("fall_to_wv") == 1)
        {
          AuthDialog localAuthDialog = this.a;
          if (AuthDialog.c(this.a).indexOf("?") >= 0);
          for (String str2 = "&"; ; str2 = "?")
          {
            AuthDialog.a(localAuthDialog, str2);
            AuthDialog.a(this.a, "browser_error=1");
            AuthDialog.d(this.a).loadUrl(AuthDialog.c(this.a));
            break;
          }
        }
        String str1 = localJSONObject.optString("redir", null);
        if (str1 != null)
          AuthDialog.d(this.a).loadUrl(str1);
      }
    }
    if (paramString.startsWith(ServerSetting.getInstance().getEnvUrl((Context)AuthDialog.a().get(), "auth://tauth.qq.com/")))
    {
      AuthDialog.e(this.a).onComplete(Util.parseUrlToJson(paramString));
      this.a.dismiss();
      return true;
    }
    if (paramString.startsWith("auth://cancel"))
    {
      AuthDialog.e(this.a).onCancel();
      this.a.dismiss();
      return true;
    }
    if (paramString.startsWith("auth://close"))
    {
      this.a.dismiss();
      return true;
    }
    if (paramString.startsWith("download://"))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(paramString.substring(11))));
      if ((AuthDialog.a() != null) && (AuthDialog.a().get() != null))
        ((Context)AuthDialog.a().get()).startActivity(localIntent);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.connect.auth.l
 * JD-Core Version:    0.6.2
 */