package com.xiaomi.account.openauth;

import android.graphics.Bitmap;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class a extends WebViewClient
{
  a(AuthorizeActivity paramAuthorizeActivity)
  {
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    Log.i("AuthorizeActivity", "After Cookies: " + CookieManager.getInstance().getCookie("https://account.xiaomi.com"));
    super.onPageFinished(paramWebView, paramString);
  }

  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    Log.i("AuthorizeActivity", "Before Cookies: " + CookieManager.getInstance().getCookie("https://account.xiaomi.com"));
    String str1 = new String(paramString);
    int i = str1.indexOf('?');
    String str3;
    if (i > 0)
    {
      str3 = str1.substring(i + 1);
      if ((str3.startsWith("code=")) || (str3.contains("&code=")))
        AuthorizeActivity.a(this.a, AuthorizeActivity.RESULT_SUCCESS, str1);
    }
    String str2;
    do
    {
      int j;
      do
      {
        do
          return;
        while ((!str3.startsWith("error=")) && (!str3.contains("&error=")));
        AuthorizeActivity.a(this.a, AuthorizeActivity.RESULT_FAIL, str1);
        return;
        j = str1.indexOf('#');
      }
      while (j <= 0);
      str2 = str1.substring(j + 1);
      if ((str2.startsWith("access_token=")) || (str2.contains("&access_token=")))
      {
        AuthorizeActivity.a(this.a, AuthorizeActivity.RESULT_SUCCESS, str1.replace("#", "?"));
        return;
      }
    }
    while ((!str2.startsWith("error=")) && (!str2.contains("&error=")));
    AuthorizeActivity.a(this.a, AuthorizeActivity.RESULT_FAIL, str1.replace("#", "?"));
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.a
 * JD-Core Version:    0.6.2
 */