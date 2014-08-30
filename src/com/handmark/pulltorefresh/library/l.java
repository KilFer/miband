package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

final class l extends ScrollView
{
  public l(PullToRefreshScrollView paramPullToRefreshScrollView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  private int a()
  {
    int i = getChildCount();
    int j = 0;
    if (i > 0)
      j = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    return j;
  }

  protected final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    PullToRefreshScrollView localPullToRefreshScrollView = this.a;
    int i = getChildCount();
    int j = 0;
    if (i > 0)
      j = Math.max(0, getChildAt(0).getHeight() - (getHeight() - getPaddingBottom() - getPaddingTop()));
    OverscrollHelper.overScrollBy(localPullToRefreshScrollView, paramInt1, paramInt3, paramInt2, paramInt4, j, paramBoolean);
    return bool;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.l
 * JD-Core Version:    0.6.2
 */