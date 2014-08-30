package com.tencent.open;

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

final class m extends WebViewClient
{
  private m(TDialog paramTDialog)
  {
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((TDialog.b() != null) && (TDialog.b().get() != null))
      ((View)TDialog.b().get()).setVisibility(8);
    TDialog.c(this.a).setVisibility(0);
  }

  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    Util.logd("TDialog", "Webview loading URL: " + paramString);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if ((TDialog.b() != null) && (TDialog.b().get() != null))
      ((View)TDialog.b().get()).setVisibility(0);
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    TDialog.b(this.a).onError(new UiError(paramInt, paramString1, paramString2));
    if ((TDialog.a() != null) && (TDialog.a().get() != null))
      Toast.makeText((Context)TDialog.a().get(), "网络连接异常或系统错误", 0).show();
    this.a.dismiss();
  }

  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    paramSslErrorHandler.proceed();
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    Util.logd("TDialog", "Redirect URL: " + paramString);
    if (paramString.startsWith(ServerSetting.getInstance().getEnvUrl((Context)TDialog.a().get(), "auth://tauth.qq.com/")))
    {
      TDialog.b(this.a).onComplete(Util.parseUrlToJson(paramString));
      if (this.a.isShowing())
        this.a.dismiss();
      return true;
    }
    if (paramString.startsWith("auth://cancel"))
    {
      TDialog.b(this.a).onCancel();
      if (this.a.isShowing())
        this.a.dismiss();
      return true;
    }
    if (paramString.startsWith("auth://close"))
    {
      if (this.a.isShowing())
        this.a.dismiss();
      return true;
    }
    if (paramString.startsWith("download://"))
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse(Uri.decode(paramString.substring(11))));
      if ((TDialog.a() != null) && (TDialog.a().get() != null))
        ((Context)TDialog.a().get()).startActivity(localIntent);
      return true;
    }
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.open.m
 * JD-Core Version:    0.6.2
 */