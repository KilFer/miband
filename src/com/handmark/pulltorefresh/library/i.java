package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;

final class i extends h
{
  public i(PullToRefreshGridView paramPullToRefreshGridView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramPullToRefreshGridView, paramContext, paramAttributeSet);
  }

  protected final boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    boolean bool = super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    OverscrollHelper.overScrollBy(this.a, paramInt1, paramInt3, paramInt2, paramInt4, paramBoolean);
    return bool;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.i
 * JD-Core Version:    0.6.2
 */