package cn.com.smartdevices.bracelet.activity;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

final class l extends WebViewClient
{
  l(WebActivity paramWebActivity)
  {
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    WebActivity.a(this.a).setVisibility(4);
  }

  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    WebActivity.a(this.a).setVisibility(0);
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView.loadUrl(paramString);
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.l
 * JD-Core Version:    0.6.2
 */