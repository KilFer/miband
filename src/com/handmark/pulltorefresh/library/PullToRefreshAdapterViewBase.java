package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.IndicatorLayout;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T>
  implements AbsListView.OnScrollListener
{
  private boolean b;
  private AbsListView.OnScrollListener c;
  private PullToRefreshBase.OnLastItemVisibleListener d;
  private View e;
  private IndicatorLayout f;
  private IndicatorLayout g;
  private boolean h;
  private boolean i = true;

  public PullToRefreshAdapterViewBase(Context paramContext)
  {
    super(paramContext);
    ((AbsListView)this.a).setOnScrollListener(this);
  }

  public PullToRefreshAdapterViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    ((AbsListView)this.a).setOnScrollListener(this);
  }

  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
    ((AbsListView)this.a).setOnScrollListener(this);
  }

  public PullToRefreshAdapterViewBase(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
    ((AbsListView)this.a).setOnScrollListener(this);
  }

  private static FrameLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    FrameLayout.LayoutParams localLayoutParams = null;
    if (paramLayoutParams != null)
    {
      localLayoutParams = new FrameLayout.LayoutParams(paramLayoutParams);
      if ((paramLayoutParams instanceof LinearLayout.LayoutParams))
        localLayoutParams.gravity = ((LinearLayout.LayoutParams)paramLayoutParams).gravity;
    }
    else
    {
      return localLayoutParams;
    }
    localLayoutParams.gravity = 17;
    return localLayoutParams;
  }

  private void a()
  {
    PullToRefreshBase.Mode localMode = getMode();
    FrameLayout localFrameLayout = getRefreshableViewWrapper();
    if ((localMode.showHeaderLoadingLayout()) && (this.f == null))
    {
      this.f = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START);
      FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams2.rightMargin = getResources().getDimensionPixelSize(2131296313);
      localLayoutParams2.gravity = 53;
      localFrameLayout.addView(this.f, localLayoutParams2);
    }
    do
      while ((localMode.showFooterLoadingLayout()) && (this.g == null))
      {
        this.g = new IndicatorLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END);
        FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-2, -2);
        localLayoutParams1.rightMargin = getResources().getDimensionPixelSize(2131296313);
        localLayoutParams1.gravity = 85;
        localFrameLayout.addView(this.g, localLayoutParams1);
        return;
        if ((!localMode.showHeaderLoadingLayout()) && (this.f != null))
        {
          localFrameLayout.removeView(this.f);
          this.f = null;
        }
      }
    while ((localMode.showFooterLoadingLayout()) || (this.g == null));
    localFrameLayout.removeView(this.g);
    this.g = null;
  }

  private boolean b()
  {
    return (this.h) && (isPullToRefreshEnabled());
  }

  private boolean c()
  {
    Adapter localAdapter = ((AbsListView)this.a).getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty()))
    {
      Log.d("PullToRefresh", "isFirstItemVisible. Empty View.");
      return true;
    }
    if (((AbsListView)this.a).getFirstVisiblePosition() <= 1)
    {
      View localView = ((AbsListView)this.a).getChildAt(0);
      if (localView != null)
        return localView.getTop() >= ((AbsListView)this.a).getTop();
    }
    return false;
  }

  private boolean d()
  {
    Adapter localAdapter = ((AbsListView)this.a).getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty()))
    {
      Log.d("PullToRefresh", "isLastItemVisible. Empty View.");
      return true;
    }
    int k = -1 + ((AbsListView)this.a).getCount();
    int m = ((AbsListView)this.a).getLastVisiblePosition();
    Log.d("PullToRefresh", "isLastItemVisible. Last Item Position: " + k + " Last Visible Pos: " + m);
    if (m >= k - 1)
    {
      int n = m - ((AbsListView)this.a).getFirstVisiblePosition();
      View localView = ((AbsListView)this.a).getChildAt(n);
      if (localView != null)
        return localView.getBottom() <= ((AbsListView)this.a).getBottom();
    }
    return false;
  }

  private void e()
  {
    if (this.f != null)
    {
      getRefreshableViewWrapper().removeView(this.f);
      this.f = null;
    }
    if (this.g != null)
    {
      getRefreshableViewWrapper().removeView(this.g);
      this.g = null;
    }
  }

  private void f()
  {
    if (this.f != null)
    {
      if ((isRefreshing()) || (!isReadyForPullStart()))
        break label77;
      if (!this.f.isVisible())
        this.f.show();
    }
    label77: 
    do
      while (true)
      {
        if (this.g != null)
        {
          if ((isRefreshing()) || (!isReadyForPullEnd()))
            break;
          if (!this.g.isVisible())
            this.g.show();
        }
        return;
        if (this.f.isVisible())
          this.f.hide();
      }
    while (!this.g.isVisible());
    this.g.hide();
  }

  public boolean getShowIndicator()
  {
    return this.h;
  }

  protected void handleStyledAttributes(TypedArray paramTypedArray)
  {
    if (isPullToRefreshOverScrollEnabled());
    for (boolean bool = false; ; bool = true)
    {
      this.h = paramTypedArray.getBoolean(5, bool);
      return;
    }
  }

  protected boolean isReadyForPullEnd()
  {
    Adapter localAdapter = ((AbsListView)this.a).getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty()))
    {
      Log.d("PullToRefresh", "isLastItemVisible. Empty View.");
      return true;
    }
    int k = -1 + ((AbsListView)this.a).getCount();
    int m = ((AbsListView)this.a).getLastVisiblePosition();
    Log.d("PullToRefresh", "isLastItemVisible. Last Item Position: " + k + " Last Visible Pos: " + m);
    if (m >= k - 1)
    {
      int n = m - ((AbsListView)this.a).getFirstVisiblePosition();
      View localView = ((AbsListView)this.a).getChildAt(n);
      if (localView != null)
        return localView.getBottom() <= ((AbsListView)this.a).getBottom();
    }
    return false;
  }

  protected boolean isReadyForPullStart()
  {
    Adapter localAdapter = ((AbsListView)this.a).getAdapter();
    if ((localAdapter == null) || (localAdapter.isEmpty()))
    {
      Log.d("PullToRefresh", "isFirstItemVisible. Empty View.");
      return true;
    }
    if (((AbsListView)this.a).getFirstVisiblePosition() <= 1)
    {
      View localView = ((AbsListView)this.a).getChildAt(0);
      if (localView != null)
        return localView.getTop() >= ((AbsListView)this.a).getTop();
    }
    return false;
  }

  protected void onPullToRefresh()
  {
    super.onPullToRefresh();
    if (b());
    switch (g()[getCurrentMode().ordinal()])
    {
    default:
      return;
    case 3:
      this.g.pullToRefresh();
      return;
    case 2:
    }
    this.f.pullToRefresh();
  }

  protected void onRefreshing(boolean paramBoolean)
  {
    super.onRefreshing(paramBoolean);
    if (b())
      f();
  }

  protected void onReleaseToRefresh()
  {
    super.onReleaseToRefresh();
    if (b());
    switch (g()[getCurrentMode().ordinal()])
    {
    default:
      return;
    case 3:
      this.g.releaseToRefresh();
      return;
    case 2:
    }
    this.f.releaseToRefresh();
  }

  protected void onReset()
  {
    super.onReset();
    if (b())
      f();
  }

  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.d("PullToRefresh", "First Visible: " + paramInt1 + ". Visible Count: " + paramInt2 + ". Total Items:" + paramInt3);
    if (this.d != null)
      if ((paramInt3 <= 0) || (paramInt1 + paramInt2 < paramInt3 - 1))
        break label108;
    label108: for (boolean bool = true; ; bool = false)
    {
      this.b = bool;
      if (b())
        f();
      if (this.c != null)
        this.c.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      return;
    }
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.e != null) && (!this.i))
      this.e.scrollTo(-paramInt1, -paramInt2);
  }

  public final void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.d != null) && (this.b))
      this.d.onLastItemVisible();
    if (this.c != null)
      this.c.onScrollStateChanged(paramAbsListView, paramInt);
  }

  public void setAdapter(ListAdapter paramListAdapter)
  {
    ((AdapterView)this.a).setAdapter(paramListAdapter);
  }

  public final void setEmptyView(View paramView)
  {
    FrameLayout localFrameLayout = getRefreshableViewWrapper();
    FrameLayout.LayoutParams localLayoutParams1;
    FrameLayout.LayoutParams localLayoutParams2;
    if (paramView != null)
    {
      paramView.setClickable(true);
      ViewParent localViewParent = paramView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
        ((ViewGroup)localViewParent).removeView(paramView);
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams == null)
        break label162;
      localLayoutParams1 = new FrameLayout.LayoutParams(localLayoutParams);
      if (!(localLayoutParams instanceof LinearLayout.LayoutParams))
        break label126;
      localLayoutParams1.gravity = ((LinearLayout.LayoutParams)localLayoutParams).gravity;
      localLayoutParams2 = localLayoutParams1;
    }
    while (true)
    {
      if (localLayoutParams2 != null)
      {
        localFrameLayout.addView(paramView, localLayoutParams2);
        label97: if (!(this.a instanceof EmptyViewMethodAccessor))
          break label148;
        ((EmptyViewMethodAccessor)this.a).setEmptyViewInternal(paramView);
      }
      while (true)
      {
        this.e = paramView;
        return;
        label126: localLayoutParams1.gravity = 17;
        localLayoutParams2 = localLayoutParams1;
        break;
        localFrameLayout.addView(paramView);
        break label97;
        label148: ((AbsListView)this.a).setEmptyView(paramView);
      }
      label162: localLayoutParams2 = null;
    }
  }

  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    ((AbsListView)this.a).setOnItemClickListener(paramOnItemClickListener);
  }

  public final void setOnLastItemVisibleListener(PullToRefreshBase.OnLastItemVisibleListener paramOnLastItemVisibleListener)
  {
    this.d = paramOnLastItemVisibleListener;
  }

  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.c = paramOnScrollListener;
  }

  public final void setScrollEmptyView(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void setShowIndicator(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (b())
    {
      a();
      return;
    }
    e();
  }

  protected void updateUIForMode()
  {
    super.updateUIForMode();
    if (b())
    {
      a();
      return;
    }
    e();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshAdapterViewBase
 * JD-Core Version:    0.6.2
 */