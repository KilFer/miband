package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

class f extends ExpandableListView
  implements EmptyViewMethodAccessor
{
  public f(PullToRefreshExpandableListView paramPullToRefreshExpandableListView, Context paramContext, AttributeSet paramAttributeSet)
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
 * Qualified Name:     com.handmark.pulltorefresh.library.f
 * JD-Core Version:    0.6.2
 */