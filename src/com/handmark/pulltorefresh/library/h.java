package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

class h extends GridView
  implements EmptyViewMethodAccessor
{
  public h(PullToRefreshGridView paramPullToRefreshGridView, Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public void setEmptyView(View paramView)
  {
    this.a.setEmptyView(paramView);
  }

  public void setEmptyViewInternal(View paramView)
  {
    super.setEmptyView(paramView);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.h
 * JD-Core Version:    0.6.2
 */