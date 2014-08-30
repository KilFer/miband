package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class PullToRefreshWebView extends PullToRefreshBase<WebView>
{
  private static final PullToRefreshBase.OnRefreshListener<WebView> b = new m();
  private final WebChromeClient c = new n(this);

  public PullToRefreshWebView(Context paramContext)
  {
    super(paramContext);
    setOnRefreshListener(b);
    ((WebView)this.a).setWebChromeClient(this.c);
  }

  public PullToRefreshWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnRefreshListener(b);
    ((WebView)this.a).setWebChromeClient(this.c);
  }

  public PullToRefreshWebView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
    setOnRefreshListener(b);
    ((WebView)this.a).setWebChromeClient(this.c);
  }

  public PullToRefreshWebView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
    setOnRefreshListener(b);
    ((WebView)this.a).setWebChromeClient(this.c);
  }

  protected WebView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new o(this, paramContext, paramAttributeSet); ; localObject = new WebView(paramContext, paramAttributeSet))
    {
      ((WebView)localObject).setId(2131165218);
      return localObject;
    }
  }

  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }

  protected boolean isReadyForPullEnd()
  {
    float f = FloatMath.floor(((WebView)this.a).getContentHeight() * ((WebView)this.a).getScale());
    return ((WebView)this.a).getScrollY() >= f - ((WebView)this.a).getHeight();
  }

  protected boolean isReadyForPullStart()
  {
    return ((WebView)this.a).getScrollY() == 0;
  }

  protected void onPtrRestoreInstanceState(Bundle paramBundle)
  {
    super.onPtrRestoreInstanceState(paramBundle);
    ((WebView)this.a).restoreState(paramBundle);
  }

  protected void onPtrSaveInstanceState(Bundle paramBundle)
  {
    super.onPtrSaveInstanceState(paramBundle);
    ((WebView)this.a).saveState(paramBundle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshWebView
 * JD-Core Version:    0.6.2
 */