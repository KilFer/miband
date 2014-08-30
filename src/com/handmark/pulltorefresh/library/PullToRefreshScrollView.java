package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class PullToRefreshScrollView extends PullToRefreshBase<ScrollView>
{
  public PullToRefreshScrollView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }

  public PullToRefreshScrollView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }

  protected ScrollView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9);
    for (Object localObject = new l(this, paramContext, paramAttributeSet); ; localObject = new ScrollView(paramContext, paramAttributeSet))
    {
      ((ScrollView)localObject).setId(2131165219);
      return localObject;
    }
  }

  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }

  protected boolean isReadyForPullEnd()
  {
    View localView = ((ScrollView)this.a).getChildAt(0);
    if (localView != null)
      return ((ScrollView)this.a).getScrollY() >= localView.getHeight() - getHeight();
    return false;
  }

  protected boolean isReadyForPullStart()
  {
    return ((ScrollView)this.a).getScrollY() == 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshScrollView
 * JD-Core Version:    0.6.2
 */