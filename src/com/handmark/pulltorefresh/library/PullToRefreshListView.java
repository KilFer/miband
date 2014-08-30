package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;

public class PullToRefreshListView extends PullToRefreshAdapterViewBase<ListView>
{
  private LoadingLayout b;
  private LoadingLayout c;
  private FrameLayout d;
  private boolean e;

  public PullToRefreshListView(Context paramContext)
  {
    super(paramContext);
  }

  public PullToRefreshListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
  }

  public PullToRefreshListView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
  }

  protected ListView createListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9)
      return new k(this, paramContext, paramAttributeSet);
    return new PullToRefreshListView.InternalListView(this, paramContext, paramAttributeSet);
  }

  protected LoadingLayoutProxy createLoadingLayoutProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    LoadingLayoutProxy localLoadingLayoutProxy = super.createLoadingLayoutProxy(paramBoolean1, paramBoolean2);
    if (this.e)
    {
      PullToRefreshBase.Mode localMode = getMode();
      if ((paramBoolean1) && (localMode.showHeaderLoadingLayout()))
        localLoadingLayoutProxy.addLayout(this.b);
      if ((paramBoolean2) && (localMode.showFooterLoadingLayout()))
        localLoadingLayoutProxy.addLayout(this.c);
    }
    return localLoadingLayoutProxy;
  }

  protected ListView createRefreshableView(Context paramContext, AttributeSet paramAttributeSet)
  {
    ListView localListView = createListView(paramContext, paramAttributeSet);
    localListView.setId(16908298);
    return localListView;
  }

  public final PullToRefreshBase.Orientation getPullToRefreshScrollDirection()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }

  protected void handleStyledAttributes(TypedArray paramTypedArray)
  {
    super.handleStyledAttributes(paramTypedArray);
    this.e = paramTypedArray.getBoolean(14, true);
    if (this.e)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -2, 1);
      FrameLayout localFrameLayout = new FrameLayout(getContext());
      this.b = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_START, paramTypedArray);
      this.b.setVisibility(8);
      localFrameLayout.addView(this.b, localLayoutParams);
      ((ListView)this.a).addHeaderView(localFrameLayout, null, false);
      this.d = new FrameLayout(getContext());
      this.c = createLoadingLayout(getContext(), PullToRefreshBase.Mode.PULL_FROM_END, paramTypedArray);
      this.c.setVisibility(8);
      this.d.addView(this.c, localLayoutParams);
      if (!paramTypedArray.hasValue(13))
        setScrollingWhileRefreshingEnabled(true);
    }
  }

  protected void onRefreshing(boolean paramBoolean)
  {
    ListAdapter localListAdapter = ((ListView)this.a).getAdapter();
    if ((!this.e) || (!getShowViewWhileRefreshing()) || (localListAdapter == null) || (localListAdapter.isEmpty()))
    {
      super.onRefreshing(paramBoolean);
      return;
    }
    super.onRefreshing(false);
    int j;
    LoadingLayout localLoadingLayout1;
    LoadingLayout localLoadingLayout2;
    LoadingLayout localLoadingLayout3;
    int i;
    switch (a()[getCurrentMode().ordinal()])
    {
    case 4:
    default:
      LoadingLayout localLoadingLayout4 = getHeaderLayout();
      LoadingLayout localLoadingLayout5 = this.b;
      LoadingLayout localLoadingLayout6 = this.c;
      j = getScrollY() + getHeaderSize();
      localLoadingLayout1 = localLoadingLayout4;
      localLoadingLayout2 = localLoadingLayout5;
      localLoadingLayout3 = localLoadingLayout6;
      i = 0;
    case 3:
    case 5:
    }
    while (true)
    {
      localLoadingLayout1.reset();
      localLoadingLayout1.hideAllViews();
      localLoadingLayout3.setVisibility(8);
      localLoadingLayout2.setVisibility(0);
      localLoadingLayout2.refreshing();
      if (!paramBoolean)
        break;
      disableLoadingLayoutVisibilityChanges();
      setHeaderScroll(j);
      ((ListView)this.a).setSelection(i);
      smoothScrollTo(0);
      return;
      localLoadingLayout1 = getFooterLayout();
      localLoadingLayout2 = this.c;
      localLoadingLayout3 = this.b;
      i = -1 + ((ListView)this.a).getCount();
      j = getScrollY() - getFooterSize();
    }
  }

  protected void onReset()
  {
    int i = 0;
    int j = 1;
    if (!this.e)
    {
      super.onReset();
      return;
    }
    LoadingLayout localLoadingLayout3;
    LoadingLayout localLoadingLayout4;
    int i2;
    switch (a()[getCurrentMode().ordinal()])
    {
    case 4:
    default:
      localLoadingLayout3 = getHeaderLayout();
      localLoadingLayout4 = this.b;
      i2 = -getHeaderSize();
      if (Math.abs(((ListView)this.a).getFirstVisiblePosition()) > j)
        break;
    case 3:
    case 5:
    }
    while (true)
    {
      int n = j;
      int i1 = i2;
      Object localObject1 = localLoadingLayout4;
      Object localObject2 = localLoadingLayout3;
      if (((LoadingLayout)localObject1).getVisibility() == 0)
      {
        ((LoadingLayout)localObject2).showInvisibleViews();
        ((LoadingLayout)localObject1).setVisibility(8);
        if ((n != 0) && (getState() != PullToRefreshBase.State.MANUAL_REFRESHING))
        {
          ((ListView)this.a).setSelection(i);
          setHeaderScroll(i1);
        }
      }
      super.onReset();
      return;
      LoadingLayout localLoadingLayout1 = getFooterLayout();
      LoadingLayout localLoadingLayout2 = this.c;
      int k = -1 + ((ListView)this.a).getCount();
      int m = getFooterSize();
      if (Math.abs(((ListView)this.a).getLastVisiblePosition() - k) <= j);
      for (n = j; ; n = 0)
      {
        i = k;
        i1 = m;
        localObject1 = localLoadingLayout2;
        localObject2 = localLoadingLayout1;
        break;
      }
      j = 0;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshListView
 * JD-Core Version:    0.6.2
 */