package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.Utils;
import com.xiaomi.hm.health.R.styleable;

public abstract class PullToRefreshBase<T extends View> extends LinearLayout
  implements IPullToRefresh<T>
{
  public static final int SMOOTH_SCROLL_DURATION_MS = 200;
  public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
  private static boolean b = true;
  private static boolean c = false;
  private static String d = "PullToRefresh";
  private static float e = 4.2F;
  private static int f = 225;
  private static String g = "ptr_state";
  private static String h = "ptr_mode";
  private static String i = "ptr_current_mode";
  private static String j = "ptr_disable_scrolling";
  private static String k = "ptr_show_refreshing_view";
  private static String l = "ptr_super";
  private boolean A = true;
  private Interpolator B;
  private PullToRefreshBase.AnimationStyle C = PullToRefreshBase.AnimationStyle.a();
  private LoadingLayout D;
  private LoadingLayout E;
  private PullToRefreshBase.OnRefreshListener<T> F;
  private PullToRefreshBase.OnRefreshListener2<T> G;
  private PullToRefreshBase.OnPullEventListener<T> H;
  private PullToRefreshBase<T>.e I;
  T a;
  private int m;
  private float n;
  private float o;
  private float p;
  private float q;
  private boolean r = false;
  private PullToRefreshBase.State s = PullToRefreshBase.State.RESET;
  private PullToRefreshBase.Mode t = PullToRefreshBase.Mode.a();
  private PullToRefreshBase.Mode u;
  private FrameLayout v;
  private boolean w = true;
  private boolean x = false;
  private boolean y = true;
  private boolean z = true;

  public PullToRefreshBase(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public PullToRefreshBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public PullToRefreshBase(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.t = paramMode;
    a(paramContext, null);
  }

  public PullToRefreshBase(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext);
    this.t = paramMode;
    this.C = paramAnimationStyle;
    a(paramContext, null);
  }

  private void a()
  {
    if (this.F != null)
      this.F.onRefresh(this);
    do
    {
      do
        return;
      while (this.G == null);
      if (this.u == PullToRefreshBase.Mode.PULL_FROM_START)
      {
        this.G.onPullDownToRefresh(this);
        return;
      }
    }
    while (this.u != PullToRefreshBase.Mode.PULL_FROM_END);
    this.G.onPullUpToRefresh(this);
  }

  private final void a(int paramInt)
  {
    a(paramInt, 200L, 0L, new c(this));
  }

  private final void a(int paramInt, long paramLong)
  {
    a(paramInt, paramLong, 0L, null);
  }

  private final void a(int paramInt, long paramLong1, long paramLong2, d paramd)
  {
    if (this.I != null)
      this.I.a();
    switch (f()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
    case 2:
    }
    for (int i1 = getScrollY(); ; i1 = getScrollX())
    {
      if (i1 != paramInt)
      {
        if (this.B == null)
          this.B = new DecelerateInterpolator();
        this.I = new e(this, i1, paramInt, paramLong1, paramd);
        if (paramLong2 <= 0L)
          break;
        postDelayed(this.I, paramLong2);
      }
      return;
    }
    post(this.I);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray;
    switch (f()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      setOrientation(1);
      setGravity(17);
      this.m = ViewConfiguration.get(paramContext).getScaledTouchSlop();
      localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PullToRefresh);
      if (localTypedArray.hasValue(4))
        this.t = PullToRefreshBase.Mode.a(localTypedArray.getInteger(4, 0));
      if (localTypedArray.hasValue(12))
        this.C = PullToRefreshBase.AnimationStyle.a(localTypedArray.getInteger(12, 0));
      this.a = createRefreshableView(paramContext, paramAttributeSet);
      View localView = this.a;
      this.v = new FrameLayout(paramContext);
      this.v.addView(localView, -1, -1);
      addViewInternal(this.v, new LinearLayout.LayoutParams(-1, -1));
      this.D = createLoadingLayout(paramContext, PullToRefreshBase.Mode.PULL_FROM_START, localTypedArray);
      this.E = createLoadingLayout(paramContext, PullToRefreshBase.Mode.PULL_FROM_END, localTypedArray);
      if (localTypedArray.hasValue(0))
      {
        Drawable localDrawable2 = localTypedArray.getDrawable(0);
        if (localDrawable2 != null)
          this.a.setBackgroundDrawable(localDrawable2);
      }
      break;
    case 2:
    }
    while (true)
    {
      if (localTypedArray.hasValue(9))
        this.z = localTypedArray.getBoolean(9, true);
      if (localTypedArray.hasValue(13))
        this.x = localTypedArray.getBoolean(13, false);
      handleStyledAttributes(localTypedArray);
      localTypedArray.recycle();
      updateUIForMode();
      return;
      setOrientation(0);
      break;
      if (localTypedArray.hasValue(16))
      {
        Utils.warnDeprecation("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
        Drawable localDrawable1 = localTypedArray.getDrawable(16);
        if (localDrawable1 != null)
          this.a.setBackgroundDrawable(localDrawable1);
      }
    }
  }

  private void a(Context paramContext, T paramT)
  {
    this.v = new FrameLayout(paramContext);
    this.v.addView(paramT, -1, -1);
    addViewInternal(this.v, new LinearLayout.LayoutParams(-1, -1));
  }

  private boolean b()
  {
    switch (h()[this.t.ordinal()])
    {
    default:
    case 2:
    case 3:
    case 4:
    }
    do
    {
      return false;
      return isReadyForPullStart();
      return isReadyForPullEnd();
    }
    while ((!isReadyForPullEnd()) && (!isReadyForPullStart()));
    return true;
  }

  private void c()
  {
    float f1;
    float f2;
    int i1;
    int i2;
    label88: float f3;
    switch (f()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      f1 = this.q;
      f2 = this.o;
      switch (h()[this.u.ordinal()])
      {
      default:
        i1 = Math.round(Math.min(f1 - f2, 0.0F) / 4.2F);
        i2 = getHeaderSize();
        setHeaderScroll(i1);
        if ((i1 != 0) && (!isRefreshing()))
        {
          f3 = Math.abs(i1) / i2;
          switch (h()[this.u.ordinal()])
          {
          default:
            this.D.onPull(f3);
            label153: if ((this.s != PullToRefreshBase.State.PULL_TO_REFRESH) && (i2 >= Math.abs(i1)))
              a(PullToRefreshBase.State.PULL_TO_REFRESH, new boolean[0]);
            break;
          case 3:
          }
        }
        break;
      case 3:
      }
      break;
    case 2:
    }
    while ((this.s != PullToRefreshBase.State.PULL_TO_REFRESH) || (i2 >= Math.abs(i1)))
    {
      return;
      f1 = this.p;
      f2 = this.n;
      break;
      i1 = Math.round(Math.max(f1 - f2, 0.0F) / 4.2F);
      i2 = getFooterSize();
      break label88;
      this.E.onPull(f3);
      break label153;
    }
    a(PullToRefreshBase.State.RELEASE_TO_REFRESH, new boolean[0]);
  }

  private LinearLayout.LayoutParams d()
  {
    switch (f()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      return new LinearLayout.LayoutParams(-1, -2);
    case 2:
    }
    return new LinearLayout.LayoutParams(-2, -1);
  }

  private int e()
  {
    switch (f()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      return Math.round(getHeight() / 4.2F);
    case 2:
    }
    return Math.round(getWidth() / 4.2F);
  }

  final void a(PullToRefreshBase.State paramState, boolean[] paramArrayOfBoolean)
  {
    this.s = paramState;
    Log.d("PullToRefresh", "State: " + this.s.name());
    switch (g()[this.s.ordinal()])
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      if (this.H != null)
        this.H.onPullEvent(this, this.s, this.u);
      return;
      onReset();
      continue;
      onPullToRefresh();
      continue;
      onReleaseToRefresh();
      continue;
      onRefreshing(paramArrayOfBoolean[0]);
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    Log.d("PullToRefresh", "addView: " + paramView.getClass().getSimpleName());
    View localView = getRefreshableView();
    if ((localView instanceof ViewGroup))
    {
      ((ViewGroup)localView).addView(paramView, paramInt, paramLayoutParams);
      return;
    }
    throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
  }

  protected final void addViewInternal(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
  }

  protected final void addViewInternal(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, -1, paramLayoutParams);
  }

  protected LoadingLayout createLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, TypedArray paramTypedArray)
  {
    LoadingLayout localLoadingLayout = this.C.a(paramContext, paramMode, getPullToRefreshScrollDirection(), paramTypedArray);
    localLoadingLayout.setVisibility(4);
    return localLoadingLayout;
  }

  protected LoadingLayoutProxy createLoadingLayoutProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    LoadingLayoutProxy localLoadingLayoutProxy = new LoadingLayoutProxy();
    if ((paramBoolean1) && (this.t.showHeaderLoadingLayout()))
      localLoadingLayoutProxy.addLayout(this.D);
    if ((paramBoolean2) && (this.t.showFooterLoadingLayout()))
      localLoadingLayoutProxy.addLayout(this.E);
    return localLoadingLayoutProxy;
  }

  protected abstract T createRefreshableView(Context paramContext, AttributeSet paramAttributeSet);

  public final boolean demo()
  {
    if ((this.t.showHeaderLoadingLayout()) && (isReadyForPullStart()))
    {
      a(-getHeaderSize() << 1);
      return true;
    }
    if ((this.t.showFooterLoadingLayout()) && (isReadyForPullEnd()))
    {
      a(getFooterSize() << 1);
      return true;
    }
    return false;
  }

  protected final void disableLoadingLayoutVisibilityChanges()
  {
    this.A = false;
  }

  public final PullToRefreshBase.Mode getCurrentMode()
  {
    return this.u;
  }

  public final boolean getFilterTouchEvents()
  {
    return this.y;
  }

  protected final LoadingLayout getFooterLayout()
  {
    return this.E;
  }

  protected final int getFooterSize()
  {
    return this.E.getContentSize();
  }

  protected final LoadingLayout getHeaderLayout()
  {
    return this.D;
  }

  protected final int getHeaderSize()
  {
    return this.D.getContentSize();
  }

  public final ILoadingLayout getLoadingLayoutProxy()
  {
    return getLoadingLayoutProxy(true, true);
  }

  public final ILoadingLayout getLoadingLayoutProxy(boolean paramBoolean1, boolean paramBoolean2)
  {
    return createLoadingLayoutProxy(paramBoolean1, paramBoolean2);
  }

  public final PullToRefreshBase.Mode getMode()
  {
    return this.t;
  }

  public abstract PullToRefreshBase.Orientation getPullToRefreshScrollDirection();

  protected int getPullToRefreshScrollDuration()
  {
    return 200;
  }

  protected int getPullToRefreshScrollDurationLonger()
  {
    return 325;
  }

  public final T getRefreshableView()
  {
    return this.a;
  }

  protected FrameLayout getRefreshableViewWrapper()
  {
    return this.v;
  }

  public final boolean getShowViewWhileRefreshing()
  {
    return this.w;
  }

  public final PullToRefreshBase.State getState()
  {
    return this.s;
  }

  protected void handleStyledAttributes(TypedArray paramTypedArray)
  {
  }

  public final boolean isDisableScrollingWhileRefreshing()
  {
    return !isScrollingWhileRefreshingEnabled();
  }

  public final boolean isPullToRefreshEnabled()
  {
    return this.t.b();
  }

  public final boolean isPullToRefreshOverScrollEnabled()
  {
    return (Build.VERSION.SDK_INT >= 9) && (this.z) && (OverscrollHelper.a(this.a));
  }

  protected abstract boolean isReadyForPullEnd();

  protected abstract boolean isReadyForPullStart();

  public final boolean isRefreshing()
  {
    return (this.s == PullToRefreshBase.State.REFRESHING) || (this.s == PullToRefreshBase.State.MANUAL_REFRESHING);
  }

  public final boolean isScrollingWhileRefreshingEnabled()
  {
    return this.x;
  }

  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isPullToRefreshEnabled())
      return false;
    int i1 = paramMotionEvent.getAction();
    if ((i1 == 3) || (i1 == 1))
    {
      this.r = false;
      return false;
    }
    if ((i1 != 0) && (this.r))
      return true;
    switch (i1)
    {
    case 1:
    default:
    case 2:
    case 0:
    }
    while (true)
    {
      return this.r;
      if ((!this.x) && (isRefreshing()))
        return true;
      if (b())
      {
        float f3 = paramMotionEvent.getY();
        float f4 = paramMotionEvent.getX();
        float f5;
        switch (f()[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
          f5 = f3 - this.o;
        case 2:
        }
        for (float f6 = f4 - this.n; ; f6 = f3 - this.o)
        {
          float f7 = Math.abs(f5);
          if ((f7 <= this.m) || ((this.y) && (f7 <= Math.abs(f6))))
            break;
          if ((!this.t.showHeaderLoadingLayout()) || (f5 < 1.0F) || (!isReadyForPullStart()))
            break label276;
          this.o = f3;
          this.n = f4;
          this.r = true;
          if (this.t != PullToRefreshBase.Mode.BOTH)
            break;
          this.u = PullToRefreshBase.Mode.PULL_FROM_START;
          break;
          f5 = f4 - this.n;
        }
        label276: if ((this.t.showFooterLoadingLayout()) && (f5 <= -1.0F) && (isReadyForPullEnd()))
        {
          this.o = f3;
          this.n = f4;
          this.r = true;
          if (this.t == PullToRefreshBase.Mode.BOTH)
          {
            this.u = PullToRefreshBase.Mode.PULL_FROM_END;
            continue;
            if (b())
            {
              float f1 = paramMotionEvent.getY();
              this.q = f1;
              this.o = f1;
              float f2 = paramMotionEvent.getX();
              this.p = f2;
              this.n = f2;
              this.r = false;
            }
          }
        }
      }
    }
  }

  protected void onPtrRestoreInstanceState(Bundle paramBundle)
  {
  }

  protected void onPtrSaveInstanceState(Bundle paramBundle)
  {
  }

  protected void onPullToRefresh()
  {
    switch (h()[this.u.ordinal()])
    {
    default:
      return;
    case 3:
      this.E.pullToRefresh();
      return;
    case 2:
    }
    this.D.pullToRefresh();
  }

  public final void onRefreshComplete()
  {
    if (isRefreshing())
      a(PullToRefreshBase.State.RESET, new boolean[0]);
  }

  protected void onRefreshing(boolean paramBoolean)
  {
    if (this.t.showHeaderLoadingLayout())
      this.D.refreshing();
    if (this.t.showFooterLoadingLayout())
      this.E.refreshing();
    if (paramBoolean)
    {
      if (this.w)
      {
        a locala = new a(this);
        switch (h()[this.u.ordinal()])
        {
        case 4:
        default:
          smoothScrollTo(-getHeaderSize(), locala);
          return;
        case 3:
        case 5:
        }
        smoothScrollTo(getFooterSize(), locala);
        return;
      }
      smoothScrollTo(0);
      return;
    }
    a();
  }

  protected void onReleaseToRefresh()
  {
    switch (h()[this.u.ordinal()])
    {
    default:
      return;
    case 3:
      this.E.releaseToRefresh();
      return;
    case 2:
    }
    this.D.releaseToRefresh();
  }

  protected void onReset()
  {
    this.r = false;
    this.A = true;
    this.D.reset();
    this.E.reset();
    smoothScrollTo(0);
  }

  protected final void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof Bundle))
    {
      Bundle localBundle = (Bundle)paramParcelable;
      setMode(PullToRefreshBase.Mode.a(localBundle.getInt("ptr_mode", 0)));
      this.u = PullToRefreshBase.Mode.a(localBundle.getInt("ptr_current_mode", 0));
      this.x = localBundle.getBoolean("ptr_disable_scrolling", false);
      this.w = localBundle.getBoolean("ptr_show_refreshing_view", true);
      super.onRestoreInstanceState(localBundle.getParcelable("ptr_super"));
      PullToRefreshBase.State localState = PullToRefreshBase.State.a(localBundle.getInt("ptr_state", 0));
      if ((localState == PullToRefreshBase.State.REFRESHING) || (localState == PullToRefreshBase.State.MANUAL_REFRESHING))
        a(localState, new boolean[] { true });
      onPtrRestoreInstanceState(localBundle);
      return;
    }
    super.onRestoreInstanceState(paramParcelable);
  }

  protected final Parcelable onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    onPtrSaveInstanceState(localBundle);
    localBundle.putInt("ptr_state", this.s.a());
    localBundle.putInt("ptr_mode", this.t.c());
    localBundle.putInt("ptr_current_mode", this.u.c());
    localBundle.putBoolean("ptr_disable_scrolling", this.x);
    localBundle.putBoolean("ptr_show_refreshing_view", this.w);
    localBundle.putParcelable("ptr_super", super.onSaveInstanceState());
    return localBundle;
  }

  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    Log.d("PullToRefresh", String.format("onSizeChanged. W: %d, H: %d", arrayOfObject));
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    refreshLoadingViewsSize();
    refreshRefreshableViewSize(paramInt1, paramInt2);
    post(new b(this));
  }

  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!isPullToRefreshEnabled())
      return false;
    if ((!this.x) && (isRefreshing()))
      return true;
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
      return false;
    switch (paramMotionEvent.getAction())
    {
    default:
    case 2:
    case 0:
    case 1:
    case 3:
    }
    label195: 
    do
    {
      do
      {
        do
          return false;
        while (!this.r);
        this.o = paramMotionEvent.getY();
        this.n = paramMotionEvent.getX();
        float f3;
        float f4;
        int i1;
        int i2;
        float f5;
        switch (f()[getPullToRefreshScrollDirection().ordinal()])
        {
        default:
          f3 = this.q;
          f4 = this.o;
          switch (h()[this.u.ordinal()])
          {
          default:
            i1 = Math.round(Math.min(f3 - f4, 0.0F) / 4.2F);
            i2 = getHeaderSize();
            setHeaderScroll(i1);
            if ((i1 != 0) && (!isRefreshing()))
            {
              f5 = Math.abs(i1) / i2;
              switch (h()[this.u.ordinal()])
              {
              default:
                this.D.onPull(f5);
                if ((this.s != PullToRefreshBase.State.PULL_TO_REFRESH) && (i2 >= Math.abs(i1)))
                  a(PullToRefreshBase.State.PULL_TO_REFRESH, new boolean[0]);
                break;
              case 3:
              }
            }
            break;
          case 3:
          }
          break;
        case 2:
        }
        while (true)
        {
          return true;
          f3 = this.p;
          f4 = this.n;
          break;
          i1 = Math.round(Math.max(f3 - f4, 0.0F) / 4.2F);
          i2 = getFooterSize();
          break label195;
          this.E.onPull(f5);
          break label265;
          if ((this.s == PullToRefreshBase.State.PULL_TO_REFRESH) && (i2 < Math.abs(i1)))
            a(PullToRefreshBase.State.RELEASE_TO_REFRESH, new boolean[0]);
        }
      }
      while (!b());
      float f1 = paramMotionEvent.getY();
      this.q = f1;
      this.o = f1;
      float f2 = paramMotionEvent.getX();
      this.p = f2;
      this.n = f2;
      return true;
    }
    while (!this.r);
    label265: this.r = false;
    if ((this.s == PullToRefreshBase.State.RELEASE_TO_REFRESH) && ((this.F != null) || (this.G != null)))
    {
      a(PullToRefreshBase.State.REFRESHING, new boolean[] { true });
      return true;
    }
    if (isRefreshing())
    {
      smoothScrollTo(0);
      return true;
    }
    a(PullToRefreshBase.State.RESET, new boolean[0]);
    return true;
  }

  protected final void refreshLoadingViewsSize()
  {
    int i1 = (int)(1.2F * e());
    int i2 = getPaddingLeft();
    int i3 = getPaddingTop();
    int i4 = getPaddingRight();
    int i5 = getPaddingBottom();
    int i10;
    int i7;
    int i9;
    int i8;
    switch (f()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      i10 = i5;
      i7 = i4;
      i9 = i3;
      i8 = i2;
    case 2:
    case 1:
    }
    while (true)
    {
      Object[] arrayOfObject = new Object[4];
      arrayOfObject[0] = Integer.valueOf(i8);
      arrayOfObject[1] = Integer.valueOf(i9);
      arrayOfObject[2] = Integer.valueOf(i7);
      arrayOfObject[3] = Integer.valueOf(i10);
      Log.d("PullToRefresh", String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", arrayOfObject));
      setPadding(i8, i9, i7, i10);
      return;
      if (this.t.showHeaderLoadingLayout())
        this.D.setWidth(i1);
      for (int i12 = -i1; ; i12 = 0)
      {
        if (!this.t.showFooterLoadingLayout())
          break label215;
        this.E.setWidth(i1);
        i7 = -i1;
        i9 = i3;
        i8 = i12;
        i10 = i5;
        break;
      }
      label215: i9 = i3;
      i8 = i12;
      i10 = i5;
      i7 = 0;
      continue;
      if (this.t.showHeaderLoadingLayout())
        this.D.setHeight(i1);
      for (int i6 = -i1; ; i6 = 0)
      {
        if (!this.t.showFooterLoadingLayout())
          break label300;
        this.E.setHeight(i1);
        int i11 = -i1;
        i8 = i2;
        i9 = i6;
        i10 = i11;
        i7 = i4;
        break;
      }
      label300: i7 = i4;
      i8 = i2;
      i9 = i6;
      i10 = 0;
    }
  }

  protected final void refreshRefreshableViewSize(int paramInt1, int paramInt2)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.v.getLayoutParams();
    switch (f()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
    case 2:
    case 1:
    }
    do
    {
      do
        return;
      while (localLayoutParams.width == paramInt1);
      localLayoutParams.width = paramInt1;
      this.v.requestLayout();
      return;
    }
    while (localLayoutParams.height == paramInt2);
    localLayoutParams.height = paramInt2;
    this.v.requestLayout();
  }

  public void setDisableScrollingWhileRefreshing(boolean paramBoolean)
  {
    if (paramBoolean);
    for (boolean bool = false; ; bool = true)
    {
      this.x = bool;
      return;
    }
  }

  public final void setFilterTouchEvents(boolean paramBoolean)
  {
    this.y = paramBoolean;
  }

  protected final void setHeaderScroll(int paramInt)
  {
    Log.d("PullToRefresh", "setHeaderScroll: " + paramInt);
    int i1 = e();
    int i2 = Math.min(i1, Math.max(-i1, paramInt));
    if (this.A)
    {
      if (i2 >= 0)
        break label93;
      this.D.setVisibility(0);
    }
    while (true)
      switch (f()[getPullToRefreshScrollDirection().ordinal()])
      {
      default:
        return;
        label93: if (i2 > 0)
        {
          this.E.setVisibility(0);
        }
        else
        {
          this.D.setVisibility(4);
          this.E.setVisibility(4);
        }
        break;
      case 1:
      case 2:
      }
    scrollTo(0, i2);
    return;
    scrollTo(i2, 0);
  }

  public void setLastUpdatedLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setLastUpdatedLabel(paramCharSequence);
  }

  public void setLoadingDrawable(Drawable paramDrawable)
  {
    getLoadingLayoutProxy().setLoadingDrawable(paramDrawable);
  }

  public void setLoadingDrawable(Drawable paramDrawable, PullToRefreshBase.Mode paramMode)
  {
    getLoadingLayoutProxy(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setLoadingDrawable(paramDrawable);
  }

  public void setLongClickable(boolean paramBoolean)
  {
    getRefreshableView().setLongClickable(paramBoolean);
  }

  public final void setMode(PullToRefreshBase.Mode paramMode)
  {
    if (paramMode != this.t)
    {
      Log.d("PullToRefresh", "Setting mode to: " + paramMode);
      this.t = paramMode;
      updateUIForMode();
    }
  }

  public void setOnPullEventListener(PullToRefreshBase.OnPullEventListener<T> paramOnPullEventListener)
  {
    this.H = paramOnPullEventListener;
  }

  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener2<T> paramOnRefreshListener2)
  {
    this.G = paramOnRefreshListener2;
    this.F = null;
  }

  public final void setOnRefreshListener(PullToRefreshBase.OnRefreshListener<T> paramOnRefreshListener)
  {
    this.F = paramOnRefreshListener;
    this.G = null;
  }

  public void setPullLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setPullLabel(paramCharSequence);
  }

  public void setPullLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    getLoadingLayoutProxy(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setPullLabel(paramCharSequence);
  }

  public final void setPullToRefreshEnabled(boolean paramBoolean)
  {
    if (paramBoolean);
    for (PullToRefreshBase.Mode localMode = PullToRefreshBase.Mode.a(); ; localMode = PullToRefreshBase.Mode.DISABLED)
    {
      setMode(localMode);
      return;
    }
  }

  public final void setPullToRefreshOverScrollEnabled(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }

  public final void setRefreshing()
  {
    setRefreshing(true);
  }

  public final void setRefreshing(boolean paramBoolean)
  {
    if (!isRefreshing())
      a(PullToRefreshBase.State.MANUAL_REFRESHING, new boolean[] { paramBoolean });
  }

  public void setRefreshingLabel(CharSequence paramCharSequence)
  {
    getLoadingLayoutProxy().setRefreshingLabel(paramCharSequence);
  }

  public void setRefreshingLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    getLoadingLayoutProxy(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setRefreshingLabel(paramCharSequence);
  }

  public void setReleaseLabel(CharSequence paramCharSequence)
  {
    setReleaseLabel(paramCharSequence, PullToRefreshBase.Mode.BOTH);
  }

  public void setReleaseLabel(CharSequence paramCharSequence, PullToRefreshBase.Mode paramMode)
  {
    getLoadingLayoutProxy(paramMode.showHeaderLoadingLayout(), paramMode.showFooterLoadingLayout()).setReleaseLabel(paramCharSequence);
  }

  public void setScrollAnimationInterpolator(Interpolator paramInterpolator)
  {
    this.B = paramInterpolator;
  }

  public final void setScrollingWhileRefreshingEnabled(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }

  public final void setShowViewWhileRefreshing(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }

  protected final void smoothScrollTo(int paramInt)
  {
    a(paramInt, getPullToRefreshScrollDuration());
  }

  protected final void smoothScrollTo(int paramInt, d paramd)
  {
    a(paramInt, getPullToRefreshScrollDuration(), 0L, paramd);
  }

  protected final void smoothScrollToLonger(int paramInt)
  {
    a(paramInt, getPullToRefreshScrollDurationLonger());
  }

  protected void updateUIForMode()
  {
    LinearLayout.LayoutParams localLayoutParams;
    switch (f()[getPullToRefreshScrollDirection().ordinal()])
    {
    default:
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (this == this.D.getParent())
        removeView(this.D);
      if (this.t.showHeaderLoadingLayout())
        addViewInternal(this.D, 0, localLayoutParams);
      if (this == this.E.getParent())
        removeView(this.E);
      if (this.t.showFooterLoadingLayout())
        addViewInternal(this.E, localLayoutParams);
      refreshLoadingViewsSize();
      if (this.t == PullToRefreshBase.Mode.BOTH)
        break;
    case 2:
    }
    for (PullToRefreshBase.Mode localMode = this.t; ; localMode = PullToRefreshBase.Mode.PULL_FROM_START)
    {
      this.u = localMode;
      return;
      localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
      break;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.PullToRefreshBase
 * JD-Core Version:    0.6.2
 */