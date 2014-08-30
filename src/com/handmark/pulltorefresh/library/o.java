package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.webkit.WebView;

final class o extends WebView
{
  private static int a = 2;
  private static float b = 1.5F;

  public o(PullToRefreshWebView paramPullToRefreshWebView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private int a()
  {
    return (int)Math.max(0.0F, FloatMath.floor(((WebView)this.c.a).getContentHeight() * ((WebView)this.c.a).getScale()) - (getHeight() - getPaddingBottom() - getPaddingTop()));
  }

  protected final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    OverscrollHelper.overScrollBy(this.c, paramInt1, paramInt3, paramInt2, paramInt4, (int)Math.max(0.0F, FloatMath.floor(((WebView)this.c.a).getContentHeight() * ((WebView)this.c.a).getScale()) - (getHeight() - getPaddingBottom() - getPaddingTop())), 2, 1.5F, paramBoolean);
    return bool;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.o
 * JD-Core Version:    0.6.2
 */