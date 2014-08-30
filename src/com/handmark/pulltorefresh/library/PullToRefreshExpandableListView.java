package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase<ExpandableListView>
{
  public PullToRefreshExpandableListView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshExpandableListView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }

  public PullToRefreshExpandableListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }

  protected ExpandableListView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new g(this, paramContext, paramAttributeSet); ; localObject = new f(this, paramContext, paramAttributeSet))
    {
      ((ExpandableListView)localObject).setId(16908298);
      return localObject;
    }
  }

  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshExpandableListView
 * JD-Core Version:    0.6.2
 */