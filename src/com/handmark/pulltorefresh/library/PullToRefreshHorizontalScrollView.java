package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

public class PullToRefreshHorizontalScrollView extends PullToRefreshBase<HorizontalScrollView>
{
  public PullToRefreshHorizontalScrollView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshHorizontalScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshHorizontalScrollView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }

  public PullToRefreshHorizontalScrollView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }

  protected HorizontalScrollView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new j(this, paramContext, paramAttributeSet); ; localObject = new HorizontalScrollView(paramContext, paramAttributeSet))
    {
      ((HorizontalScrollView)localObject).setId(2131165219);
      return localObject;
    }
  }

  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.HORIZONTAL;
  }

  protected boolean isReadyForPullEnd()
  {
    View localView = ((HorizontalScrollView)this.a).getChildAt(0);
    if (localView != null)
      return ((HorizontalScrollView)this.a).getScrollX() >= localView.getWidth() - getWidth();
    return false;
  }

  protected boolean isReadyForPullStart()
  {
    return ((HorizontalScrollView)this.a).getScrollX() == 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshHorizontalScrollView
 * JD-Core Version:    0.6.2
 */