package com.handmark.pulltorefresh.library;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

final class n extends WebChromeClient
{
  n(PullToRefreshWebView paramPullToRefreshWebView)
  {
  }

  public final void onProgressChanged(WebView paramWebView, int paramInt)
  {
    if (paramInt == 100)
      this.a.onRefreshComplete();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.n
 * JD-Core Version:    0.6.2
 */