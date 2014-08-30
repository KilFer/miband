package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.GridView;

public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView>
{
  public PullToRefreshGridView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshGridView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }

  public PullToRefreshGridView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }

  protected final GridView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new i(this, paramContext, paramAttributeSet); ; localObject = new h(this, paramContext, paramAttributeSet))
    {
      ((GridView)localObject).setId(2131165217);
      return localObject;
    }
  }

  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshGridView
 * JD-Core Version:    0.6.2
 */