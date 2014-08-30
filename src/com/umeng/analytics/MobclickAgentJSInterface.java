package com.umeng.analytics;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MobclickAgentJSInterface
{
  private Context a;

  public MobclickAgentJSInterface(Context paramContext, WebView paramWebView)
  {
    this.a = paramContext;
    paramWebView.getSettings().setJavaScriptEnabled(true);
    paramWebView.setWebChromeClient(new k(this, null));
  }

  public MobclickAgentJSInterface(Context paramContext, WebView paramWebView, WebChromeClient paramWebChromeClient)
  {
    this.a = paramContext;
    paramWebView.getSettings().setJavaScriptEnabled(true);
    paramWebView.setWebChromeClient(new k(this, paramWebChromeClient));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.MobclickAgentJSInterface
 * JD-Core Version:    0.6.2
 */