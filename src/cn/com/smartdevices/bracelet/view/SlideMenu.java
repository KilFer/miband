package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.xiaomi.hm.health.R.styleable;

public class SlideMenu extends ViewGroup
{
  public static final Interpolator DEFAULT_INTERPOLATOR = new z();
  public static final int FLAG_DIRECTION_LEFT = 1;
  public static final int FLAG_DIRECTION_RIGHT = 2;
  public static final int MODE_SLIDE_CONTENT = 2;
  public static final int MODE_SLIDE_WINDOW = 1;
  public static final int STATE_CLOSE = 1;
  public static final int STATE_DRAG = 8;
  public static final int STATE_OPEN_LEFT = 2;
  public static final int STATE_OPEN_MASK = 6;
  public static final int STATE_OPEN_RIGHT = 4;
  public static final int STATE_SCROLL = 16;
  private static final int a = 500;
  private static int b = 0;
  private static final int c = -1;
  private static final int d = 0;
  private static final int e = 1;
  private int A;
  private Rect B;
  private boolean C;
  private int D;
  private int E;
  private SlideMenu.OnSlideStateChangeListener F;
  private SlideMenu.OnContentTapListener G;
  private VelocityTracker H;
  private Scroller I;
  private Interpolator J;
  private int f;
  private int g;
  private View h;
  private View i;
  private View j;
  private int k;
  private float l;
  private float m;
  private volatile int n;
  private int o;
  private int p;
  private boolean q;
  private Rect r;
  private Drawable s;
  private Drawable t;
  private float u;
  private float v;
  private int w;
  private boolean x;
  private int y = 2;
  private boolean z = true;

  public SlideMenu(Context paramContext)
  {
    this(paramContext, null);
  }

  public SlideMenu(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130771968);
  }

  public SlideMenu(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.k = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.H = VelocityTracker.obtain();
    this.r = new Rect();
    this.B = new Rect();
    b = (int)getStatusBarHeight(paramContext);
    setWillNotDraw(false);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SlideMenu, paramInt, 0);
    setPrimaryShadowWidth(localTypedArray.getDimension(0, 30.0F));
    setSecondaryShadowWidth(localTypedArray.getDimension(1, 30.0F));
    Object localObject1 = localTypedArray.getDrawable(2);
    if (localObject1 == null)
    {
      GradientDrawable.Orientation localOrientation2 = GradientDrawable.Orientation.LEFT_RIGHT;
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[1] = Color.argb(99, 0, 0, 0);
      localObject1 = new GradientDrawable(localOrientation2, arrayOfInt2);
    }
    setPrimaryShadowDrawable((Drawable)localObject1);
    Object localObject2 = localTypedArray.getDrawable(3);
    if (localObject2 == null)
    {
      GradientDrawable.Orientation localOrientation1 = GradientDrawable.Orientation.LEFT_RIGHT;
      int[] arrayOfInt1 = new int[2];
      arrayOfInt1[0] = Color.argb(99, 0, 0, 0);
      localObject2 = new GradientDrawable(localOrientation1, arrayOfInt1);
    }
    setSecondaryShadowDrawable((Drawable)localObject2);
    int i1 = localTypedArray.getResourceId(7, -1);
    if (-1 == i1);
    for (Interpolator localInterpolator = DEFAULT_INTERPOLATOR; ; localInterpolator = AnimationUtils.loadInterpolator(paramContext, i1))
    {
      setInterpolator(localInterpolator);
      this.w = localTypedArray.getInt(6, 3);
      setEdgeSlideEnable(localTypedArray.getBoolean(4, false));
      setEdgetSlideWidth(localTypedArray.getDimensionPixelSize(5, 100));
      localTypedArray.recycle();
      setFocusable(true);
      setFocusableInTouchMode(true);
      return;
    }
  }

  private void a()
  {
    int i1;
    if (this.n < 0)
      i1 = -1;
    while (true)
    {
      this.f = i1;
      switch (this.f)
      {
      default:
        return;
        if (this.n == 0)
          i1 = 0;
        else
          i1 = 1;
        break;
      case -1:
      case 0:
      case 1:
      }
    }
    a(this.i, 4);
    a(this.j, 0);
    return;
    a(this.i, 4);
    a(this.j, 4);
    return;
    a(this.i, 0);
    a(this.j, 4);
  }

  private void a(int paramInt)
  {
    int i1 = this.w;
    int i2;
    int i5;
    float f1;
    if ((i1 & 0x2) == 2)
    {
      i2 = this.p;
      int i3 = i1 & 0x1;
      int i4 = 0;
      if (i3 == 1)
        i4 = this.o;
      i5 = Math.min(i2, Math.max(paramInt, i4));
      this.n = i5;
      if (this.F != null)
      {
        if (i5 <= 0)
          break label107;
        f1 = i5 / this.p;
      }
    }
    while (true)
    {
      this.F.onSlideOffsetChange(f1);
      a();
      invalidate();
      requestLayout();
      return;
      i2 = 0;
      break;
      label107: f1 = 0.0F;
      if (i5 < 0)
        f1 = -i5 / this.o;
    }
  }

  private void a(Canvas paramCanvas)
  {
    if (this.h == null);
    int i1;
    int i2;
    int i3;
    do
    {
      return;
      i1 = this.h.getLeft();
      i2 = this.D;
      i3 = this.E;
      if (this.s != null)
      {
        this.s.setBounds((int)(i1 - this.u), 0, i1, i3);
        this.s.draw(paramCanvas);
      }
    }
    while (this.t == null);
    this.t.setBounds(i1 + i2, 0, (int)(i1 + i2 + this.v), i3);
    this.t.draw(paramCanvas);
  }

  private static void a(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramView.getVisibility() != paramInt))
      paramView.setVisibility(paramInt);
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    View localView = this.h;
    if (localView != null)
    {
      localView.getHitRect(this.r);
      return this.r.contains((int)paramFloat1, (int)paramFloat2);
    }
    return false;
  }

  private boolean b()
  {
    View localView = (View)getParent();
    return (localView != null) && (16908290 == localView.getId()) && (2 == this.y) && (getRootView() == localView) && (1 == this.y);
  }

  private boolean b(float paramFloat1, float paramFloat2)
  {
    Rect localRect = this.B;
    View localView = this.i;
    boolean bool = false;
    if (localView != null)
    {
      getHitRect(localRect);
      localRect.right = this.A;
      bool = false | localRect.contains((int)paramFloat1, (int)paramFloat2);
    }
    if (this.j != null)
    {
      getHitRect(localRect);
      localRect.left = (localRect.right - this.A);
      bool |= localRect.contains((int)paramFloat1, (int)paramFloat2);
    }
    return bool;
  }

  public static float getStatusBarHeight(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    int i1 = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if (i1 != 0)
      return localResources.getDimension(i1);
    return 0.0F;
  }

  public static void removeViewFromParent(View paramView)
  {
    if (paramView == null);
    ViewGroup localViewGroup;
    do
    {
      return;
      localViewGroup = (ViewGroup)paramView.getParent();
    }
    while (localViewGroup == null);
    localViewGroup.removeView(paramView);
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!(paramLayoutParams instanceof SlideMenu.LayoutParams))
      throw new IllegalArgumentException("The parameter params must a instance of com.aretha.slidemenu.SlideMenu$LayoutParams");
    if (paramLayoutParams == null)
      return;
    switch (((SlideMenu.LayoutParams)paramLayoutParams).role)
    {
    default:
      return;
    case 0:
      removeView(this.h);
      this.h = paramView;
    case 1:
    case 2:
    }
    while (true)
    {
      a();
      super.addView(paramView, paramInt, paramLayoutParams);
      return;
      removeView(this.i);
      this.i = paramView;
      continue;
      removeView(this.j);
      this.j = paramView;
    }
  }

  protected final boolean canScroll(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup localViewGroup;
    int i1;
    int i2;
    int i3;
    if ((paramView instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)paramView;
      i1 = paramView.getScrollX();
      i2 = paramView.getScrollY();
      i3 = localViewGroup.getChildCount();
    }
    for (int i4 = 0; ; i4++)
    {
      if (i4 >= i3)
        return ViewCompat.canScrollHorizontally(paramView, -paramInt1);
      View localView = localViewGroup.getChildAt(i4);
      int i5 = localView.getLeft();
      int i6 = localView.getTop();
      if ((paramInt2 + i1 >= i5) && (paramInt2 + i1 < localView.getRight()) && (paramInt3 + i2 >= i6) && (paramInt3 + i2 < localView.getBottom()) && (localView.getVisibility() == 0) && ((ScrollDetectors.canScrollHorizontal(localView, paramInt1)) || (canScroll(localView, paramInt1, paramInt2 + i1 - i5, paramInt3 + i2 - i6))))
        return true;
    }
  }

  public void close(boolean paramBoolean)
  {
    if (1 == this.g)
      return;
    if (paramBoolean)
    {
      smoothScrollContentTo(0);
      return;
    }
    this.I.abortAnimation();
    a(0);
    setCurrentState(1);
  }

  public void computeScroll()
  {
    if ((16 == this.g) || (isOpen()))
    {
      if (this.I.computeScrollOffset())
        a(this.I.getCurrX());
    }
    else
      return;
    int i1;
    if (this.n == 0)
      i1 = 1;
    while (true)
    {
      setCurrentState(i1);
      return;
      if (this.n > 0)
        i1 = 2;
      else
        i1 = 4;
    }
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (1 == paramKeyEvent.getAction())
    {
      bool = isOpen();
      switch (paramKeyEvent.getKeyCode())
      {
      default:
      case 4:
      case 21:
      case 22:
      }
    }
    do
    {
      do
      {
        do
          return super.dispatchKeyEvent(paramKeyEvent);
        while (!bool);
        close(true);
        return true;
        if (2 == this.g)
        {
          close(true);
          return true;
        }
      }
      while (bool);
      open(true, true);
      return true;
      if (4 == this.g)
      {
        close(true);
        return true;
      }
    }
    while (bool);
    open(false, true);
    return true;
  }

  protected void drag(float paramFloat1, float paramFloat2)
  {
    this.n += (int)(paramFloat2 - paramFloat1);
    a(this.n);
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.h != null)
    {
      int i1 = this.h.getLeft();
      int i2 = this.D;
      int i3 = this.E;
      if (this.s != null)
      {
        this.s.setBounds((int)(i1 - this.u), 0, i1, i3);
        this.s.draw(paramCanvas);
      }
      if (this.t != null)
      {
        this.t.setBounds(i1 + i2, 0, (int)(i1 + i2 + this.v), i3);
        this.t.draw(paramCanvas);
      }
    }
  }

  protected void endDrag(float paramFloat1, float paramFloat2)
  {
    int i1 = this.f;
    int i2;
    if (Math.abs(paramFloat2) > 400.0F)
    {
      i2 = 1;
      switch (i1)
      {
      default:
      case -1:
      case 0:
      case 1:
      }
    }
    do
    {
      do
      {
        return;
        i2 = 0;
        break;
        if (((paramFloat2 < 0.0F) && (i2 != 0)) || ((paramFloat2 >= 0.0F) && (i2 == 0)))
        {
          smoothScrollContentTo(this.o, paramFloat2);
          return;
        }
      }
      while (((paramFloat2 <= 0.0F) || (i2 == 0)) && ((paramFloat2 > 0.0F) || (i2 != 0)));
      smoothScrollContentTo(0, paramFloat2);
      return;
      setCurrentState(1);
      return;
      if (((paramFloat2 > 0.0F) && (i2 != 0)) || ((paramFloat2 <= 0.0F) && (i2 == 0)))
      {
        smoothScrollContentTo(this.p, paramFloat2);
        return;
      }
    }
    while (((paramFloat2 >= 0.0F) || (i2 == 0)) && ((paramFloat2 < 0.0F) || (i2 != 0)));
    smoothScrollContentTo(0, paramFloat2);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new SlideMenu.LayoutParams(getContext(), paramAttributeSet);
  }

  public int getCurrentState()
  {
    return this.g;
  }

  protected Drawable getDefaultContentBackground(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(16842836, localTypedValue, true);
    return paramContext.getResources().getDrawable(localTypedValue.resourceId);
  }

  public float getEdgeSlideWidth()
  {
    return this.A;
  }

  public Interpolator getInterpolator()
  {
    return this.J;
  }

  public SlideMenu.OnContentTapListener getOnContentTapListener()
  {
    return this.G;
  }

  public SlideMenu.OnSlideStateChangeListener getOnSlideStateChangeListener()
  {
    return this.F;
  }

  public View getPrimaryMenu()
  {
    return this.i;
  }

  public Drawable getPrimaryShadowDrawable()
  {
    return this.s;
  }

  public float getPrimaryShadowWidth()
  {
    return this.u;
  }

  public View getSecondaryMenu()
  {
    return this.j;
  }

  public Drawable getSecondaryShadowDrawable()
  {
    return this.t;
  }

  public float getSecondaryShadowWidth()
  {
    return this.v;
  }

  public int getSlideDirection()
  {
    return this.w;
  }

  public int getSlideMode()
  {
    return this.y;
  }

  public boolean isEdgeSlideEnable()
  {
    return this.z;
  }

  public boolean isOpen()
  {
    return (0x6 & this.g) != 0;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = this.g;
    if ((8 == i1) || (16 == i1))
      return true;
    switch (paramMotionEvent.getAction())
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    float f3;
    do
    {
      return false;
      this.m = f1;
      this.l = f1;
      this.q = a(f1, f2);
      this.C = b(f1, f2);
      if ((isOpen()) && (this.q))
        break;
      return false;
      f3 = f1 - this.l;
      if ((this.z) && (!this.C) && (this.g == 1))
        return false;
    }
    while ((Math.abs(f3) < this.k) || (!this.q) || (canScroll(this, (int)f3, (int)f1, (int)f2)));
    setCurrentState(8);
    return true;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    int i4 = getPaddingTop();
    if (this.y == 1);
    int i6;
    for (int i5 = b; ; i5 = 0)
    {
      i6 = 0;
      if (i6 < i1)
        break;
      return;
    }
    View localView = getChildAt(i6);
    int i7 = localView.getMeasuredWidth();
    int i8 = localView.getMeasuredHeight();
    switch (((SlideMenu.LayoutParams)localView.getLayoutParams()).role)
    {
    default:
    case 0:
    case 1:
    case 2:
    }
    while (true)
    {
      i6++;
      break;
      localView.bringToFront();
      localView.layout(i2 + this.n, i4, i7 + i2 + this.n, i8 + i4);
      continue;
      this.p = i7;
      localView.layout(i2, i5 + i4, i7 + i2, i8 + (i5 + i4));
      continue;
      this.o = (-i7);
      localView.layout(paramInt3 - i3 - i7, i5 + i4, paramInt3 - i3, i8 + (i5 + i4));
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount();
    int i2 = this.y;
    int i3 = b;
    int i4 = 0;
    int i5 = 0;
    View localView1;
    int i10;
    for (int i6 = 0; ; i6 = i10)
    {
      if (i4 >= i1)
      {
        int i12 = i6 + (getPaddingLeft() + getPaddingRight());
        int i13 = i5 + (getPaddingTop() + getPaddingBottom());
        setMeasuredDimension(resolveSize(i12, paramInt1), resolveSize(i13, paramInt2));
        return;
      }
      localView1 = getChildAt(i4);
      switch (((SlideMenu.LayoutParams)localView1.getLayoutParams()).role)
      {
      default:
        i10 = Math.max(i6, localView1.getMeasuredWidth());
        int i11 = Math.max(i5, localView1.getMeasuredHeight());
        i4++;
        i5 = i11;
      case 0:
      case 1:
      case 2:
      }
    }
    int i7 = paramInt1;
    View localView2 = localView1;
    for (SlideMenu localSlideMenu1 = this; ; localSlideMenu1 = this)
    {
      SlideMenu localSlideMenu2 = localSlideMenu1;
      View localView3 = localView2;
      int i8 = i7;
      int i9 = paramInt2;
      while (true)
      {
        localSlideMenu2.measureChild(localView3, i8, i9);
        break;
        if (i2 != 1)
          break label232;
        i9 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt2) - i3, View.MeasureSpec.getMode(paramInt2));
        i8 = paramInt1;
        localView3 = localView1;
        localSlideMenu2 = this;
      }
      label232: i7 = paramInt1;
      localView2 = localView1;
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SlideMenu.SavedState localSavedState = (SlideMenu.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.u = localSavedState.primaryShadowWidth;
    this.v = localSavedState.secondaryShadaryWidth;
    this.w = localSavedState.slideDirectionFlag;
    setSlideMode(localSavedState.slideMode);
    this.g = localSavedState.currentState;
    this.n = localSavedState.currentContentOffset;
    a();
    requestLayout();
    invalidate();
  }

  protected Parcelable onSaveInstanceState()
  {
    SlideMenu.SavedState localSavedState = new SlideMenu.SavedState(super.onSaveInstanceState());
    localSavedState.primaryShadowWidth = this.u;
    localSavedState.secondaryShadaryWidth = this.v;
    localSavedState.slideDirectionFlag = this.w;
    localSavedState.slideMode = this.y;
    localSavedState.currentState = this.g;
    localSavedState.currentContentOffset = this.n;
    return localSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.D = paramInt1;
    this.E = paramInt2;
    if (this.x)
      resolveSlideMode();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    int i1 = this.g;
    int i2 = paramMotionEvent.getAction();
    switch (i2)
    {
    default:
    case 0:
    case 2:
      while (true)
      {
        boolean bool = true;
        int i3;
        do
        {
          return bool;
          this.m = f1;
          this.l = f1;
          this.q = a(f1, f2);
          this.C = b(f1, f2);
          if (!this.q)
            break;
          this.I.abortAnimation();
          break;
          this.H.addMovement(paramMotionEvent);
          if ((!this.z) || (this.C))
            break label150;
          i3 = this.g;
          bool = false;
        }
        while (i3 == 1);
        label150: if ((Math.abs(f1 - this.l) >= this.k) && (this.q) && (i1 != 8))
        {
          getParent().requestDisallowInterceptTouchEvent(true);
          setCurrentState(8);
        }
        if (8 != i1)
        {
          this.m = f1;
          return false;
        }
        drag(this.m, f1);
        this.m = f1;
      }
    case 1:
    case 3:
    case 4:
    }
    if (8 == i1)
    {
      this.H.computeCurrentVelocity(1000);
      endDrag(f1, this.H.getXVelocity());
    }
    while (true)
    {
      this.H.clear();
      getParent().requestDisallowInterceptTouchEvent(false);
      this.C = false;
      this.q = false;
      break;
      if ((this.q) && (1 == i2))
        performContentTap();
    }
  }

  public void open(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (isOpen())
      return;
    if (paramBoolean1);
    for (int i1 = this.o; paramBoolean2; i1 = this.p)
    {
      smoothScrollContentTo(i1);
      return;
    }
    this.I.abortAnimation();
    a(i1);
    if (paramBoolean1);
    for (int i2 = 2; ; i2 = 4)
    {
      setCurrentState(i2);
      return;
    }
  }

  public void performContentTap()
  {
    if (isOpen())
      smoothScrollContentTo(0);
    while (this.G == null)
      return;
    this.G.onContentTap(this);
  }

  protected void resolveSlideMode()
  {
    ViewGroup localViewGroup1 = (ViewGroup)getRootView();
    ViewGroup localViewGroup2 = (ViewGroup)localViewGroup1.findViewById(16908290);
    View localView1 = this.h;
    if ((localViewGroup1 == null) || (localView1 == null) || (getChildCount() == 0))
      return;
    TypedValue localTypedValue = new TypedValue();
    getContext().getTheme().resolveAttribute(16842836, localTypedValue, true);
    switch (this.y)
    {
    default:
      return;
    case 1:
      removeViewFromParent(this);
      SlideMenu.LayoutParams localLayoutParams2 = new SlideMenu.LayoutParams(localView1.getLayoutParams());
      removeViewFromParent(localView1);
      localViewGroup2.addView(localView1);
      View localView4 = localViewGroup1.getChildAt(0);
      localView4.setBackgroundResource(0);
      removeViewFromParent(localView4);
      addView(localView4, localLayoutParams2);
      localViewGroup1.addView(this);
      setBackgroundResource(localTypedValue.resourceId);
      return;
    case 2:
    }
    setBackgroundResource(0);
    removeViewFromParent(this);
    View localView2 = localViewGroup2.getChildAt(0);
    View localView3 = this.h;
    SlideMenu.LayoutParams localLayoutParams1 = (SlideMenu.LayoutParams)localView3.getLayoutParams();
    removeViewFromParent(localView2);
    removeViewFromParent(localView3);
    localView3.setBackgroundResource(localTypedValue.resourceId);
    localViewGroup1.addView(localView3);
    localViewGroup2.addView(this);
    addView(localView2, localLayoutParams1);
  }

  protected void setCurrentState(int paramInt)
  {
    if ((this.F != null) && (paramInt != this.g))
      this.F.onSlideStateChange(paramInt);
    this.g = paramInt;
  }

  public void setEdgeSlideEnable(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }

  public void setEdgetSlideWidth(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("Edge slide width must above 0");
    this.A = paramInt;
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.J = paramInterpolator;
    this.I = new Scroller(getContext(), paramInterpolator);
  }

  public void setOnContentTapListener(SlideMenu.OnContentTapListener paramOnContentTapListener)
  {
    this.G = paramOnContentTapListener;
  }

  public void setOnSlideStateChangeListener(SlideMenu.OnSlideStateChangeListener paramOnSlideStateChangeListener)
  {
    this.F = paramOnSlideStateChangeListener;
  }

  public void setPrimaryShadowDrawable(Drawable paramDrawable)
  {
    this.s = paramDrawable;
  }

  public void setPrimaryShadowWidth(float paramFloat)
  {
    this.u = paramFloat;
    invalidate();
  }

  public void setSecondaryShadowDrawable(Drawable paramDrawable)
  {
    this.t = paramDrawable;
  }

  public void setSecondaryShadowWidth(float paramFloat)
  {
    this.v = paramFloat;
    invalidate();
  }

  public void setSlideDirection(int paramInt)
  {
    this.w = paramInt;
  }

  public void setSlideMode(int paramInt)
  {
    View localView = (View)getParent();
    if ((localView != null) && (16908290 == localView.getId()) && (2 == this.y) && (getRootView() == localView) && (1 == this.y));
    for (int i1 = 1; i1 != 0; i1 = 0)
      throw new IllegalStateException("SlidingMenu must be the root of layout");
    if (this.y == paramInt)
      return;
    this.y = paramInt;
    if (getChildCount() == 0)
    {
      this.x = true;
      return;
    }
    resolveSlideMode();
  }

  public boolean shouldDelayChildPressedState()
  {
    return false;
  }

  public void smoothScrollContentTo(int paramInt)
  {
    smoothScrollContentTo(paramInt, 0.0F);
  }

  public void smoothScrollContentTo(int paramInt, float paramFloat)
  {
    setCurrentState(16);
    int i1 = paramInt - this.n;
    float f1 = Math.abs(paramFloat);
    int i2 = 400;
    if (f1 > 0.0F)
      i2 = 3 * Math.round(1000.0F * Math.abs(i1 / f1));
    int i3 = Math.min(i2, 500);
    this.I.abortAnimation();
    this.I.startScroll(this.n, 0, i1, 0, i3);
    invalidate();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.SlideMenu
 * JD-Core Version:    0.6.2
 */