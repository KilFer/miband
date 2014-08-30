package com.handmark.pulltorefresh.library.extras;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshWebView;
import java.util.concurrent.atomic.AtomicBoolean;

public class PullToRefreshWebView2 extends PullToRefreshWebView
{
  private static String b = "ptr";
  private static String c = "javascript:isReadyForPullDown();";
  private static String d = "javascript:isReadyForPullUp();";
  private a e;
  private final AtomicBoolean f = new AtomicBoolean(false);
  private final AtomicBoolean g = new AtomicBoolean(false);

  public PullToRefreshWebView2(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshWebView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshWebView2(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }

  protected WebView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    WebView localWebView = super.createRefreshableView(paramContext, paramAttributeSet);
    this.e = new a(this);
    localWebView.addJavascriptInterface(this.e, "ptr");
    return localWebView;
  }

  protected boolean isReadyForPullEnd()
  {
    ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullUp();");
    return this.g.get();
  }

  protected boolean isReadyForPullStart()
  {
    ((WebView)getRefreshableView()).loadUrl("javascript:isReadyForPullDown();");
    return this.f.get();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.extras.PullToRefreshWebView2
 * JD-Core Version:    0.6.2
 */