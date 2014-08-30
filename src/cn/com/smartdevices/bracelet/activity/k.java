package cn.com.smartdevices.bracelet.activity;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

final class k extends WebChromeClient
{
  k(WebActivity paramWebActivity)
  {
  }

  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    WebActivity.a(this.a).setProgress(paramInt + 5);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.k
 * JD-Core Version:    0.6.2
 */