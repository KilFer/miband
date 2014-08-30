package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewGroupCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public class DrawerLayout extends ViewGroup
{
  public static final int LOCK_MODE_LOCKED_CLOSED = 1;
  public static final int LOCK_MODE_LOCKED_OPEN = 2;
  public static final int LOCK_MODE_UNLOCKED = 0;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String a = "DrawerLayout";
  private static final int b = 64;
  private static final int c = -1728053248;
  private static final int d = 160;
  private static final int e = 400;
  private static final boolean f = false;
  private static final boolean g = true;
  private static final float h = 1.0F;
  private static final int[] i = { 16842931 };
  private float A;
  private Drawable B;
  private Drawable C;
  private int j;
  private int k = -1728053248;
  private float l;
  private Paint m = new Paint();
  private final ViewDragHelper n;
  private final ViewDragHelper o;
  private final h p;
  private final h q;
  private int r;
  private boolean s;
  private boolean t = true;
  private int u;
  private int v;
  private boolean w;
  private boolean x;
  private DrawerLayout.DrawerListener y;
  private float z;

  public DrawerLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = getResources().getDisplayMetrics().density;
    this.j = ((int)(0.5F + 64.0F * f1));
    float f2 = f1 * 400.0F;
    this.p = new h(this, 3);
    this.q = new h(this, 5);
    this.n = ViewDragHelper.create(this, 1.0F, this.p);
    this.n.setEdgeTrackingEnabled(1);
    this.n.setMinVelocity(f2);
    this.p.a(this.n);
    this.o = ViewDragHelper.create(this, 1.0F, this.q);
    this.o.setEdgeTrackingEnabled(2);
    this.o.setMinVelocity(f2);
    this.q.a(this.o);
    setFocusableInTouchMode(true);
    ViewCompat.setAccessibilityDelegate(this, new f(this));
    ViewGroupCompat.setMotionEventSplittingEnabled(this, false);
  }

  static float a(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).a;
  }

  private void a(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int i2 = 0;
    boolean bool = false;
    if (i2 < i1)
    {
      View localView = getChildAt(i2);
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
      if ((b(localView)) && ((!paramBoolean) || (localLayoutParams.b)))
      {
        int i3 = localView.getWidth();
        if (!a(localView, 3))
          break label103;
        bool |= this.n.smoothSlideViewTo(localView, -i3, localView.getTop());
      }
      while (true)
      {
        localLayoutParams.b = false;
        i2++;
        break;
        label103: bool |= this.o.smoothSlideViewTo(localView, getWidth(), localView.getTop());
      }
    }
    this.p.a();
    this.q.a();
    if (bool)
      invalidate();
  }

  private static String b(int paramInt)
  {
    if ((paramInt & 0x3) == 3)
      return "LEFT";
    if ((paramInt & 0x5) == 5)
      return "RIGHT";
    return Integer.toHexString(paramInt);
  }

  private void b(View paramView, float paramFloat)
  {
    if (this.y != null)
      this.y.onDrawerSlide(paramView, paramFloat);
  }

  static boolean b(View paramView)
  {
    return (0x7 & GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView))) != 0;
  }

  private void c(View paramView)
  {
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (localLayoutParams.c)
    {
      localLayoutParams.c = false;
      if (this.y != null)
        this.y.onDrawerClosed(paramView);
      sendAccessibilityEvent(32);
    }
  }

  private void c(View paramView, float paramFloat)
  {
    float f1 = a(paramView);
    int i1 = paramView.getWidth();
    int i2 = (int)(f1 * i1);
    int i3 = (int)(paramFloat * i1) - i2;
    if (a(paramView, 3));
    while (true)
    {
      paramView.offsetLeftAndRight(i3);
      a(paramView, paramFloat);
      return;
      i3 = -i3;
    }
  }

  private void d(View paramView)
  {
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (!localLayoutParams.c)
    {
      localLayoutParams.c = true;
      if (this.y != null)
        this.y.onDrawerOpened(paramView);
      paramView.sendAccessibilityEvent(32);
    }
  }

  private boolean d()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
      if (((DrawerLayout.LayoutParams)getChildAt(i2).getLayoutParams()).b)
        return true;
    return false;
  }

  private static int e(View paramView)
  {
    return GravityCompat.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, ViewCompat.getLayoutDirection(paramView));
  }

  private boolean e()
  {
    return f() != null;
  }

  private View f()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if ((b(localView)) && (isDrawerVisible(localView)))
        return localView;
    }
    return null;
  }

  private static boolean f(View paramView)
  {
    Drawable localDrawable = paramView.getBackground();
    boolean bool = false;
    if (localDrawable != null)
    {
      int i1 = localDrawable.getOpacity();
      bool = false;
      if (i1 == -1)
        bool = true;
    }
    return bool;
  }

  private static boolean g(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }

  final View a()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if (((DrawerLayout.LayoutParams)localView.getLayoutParams()).c)
        return localView;
    }
    return null;
  }

  final View a(int paramInt)
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if ((0x7 & e(localView)) == (paramInt & 0x7))
        return localView;
    }
    return null;
  }

  final void a(int paramInt, View paramView)
  {
    int i1 = this.n.getViewDragState();
    int i2 = this.o.getViewDragState();
    int i3;
    DrawerLayout.LayoutParams localLayoutParams1;
    if ((i1 == 1) || (i2 == 1))
    {
      i3 = 1;
      if ((paramView != null) && (paramInt == 0))
      {
        localLayoutParams1 = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
        if (localLayoutParams1.a != 0.0F)
          break label161;
        DrawerLayout.LayoutParams localLayoutParams3 = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
        if (localLayoutParams3.c)
        {
          localLayoutParams3.c = false;
          if (this.y != null)
            this.y.onDrawerClosed(paramView);
          sendAccessibilityEvent(32);
        }
      }
    }
    while (true)
    {
      if (i3 != this.r)
      {
        this.r = i3;
        if (this.y != null)
          this.y.onDrawerStateChanged(i3);
      }
      return;
      if ((i1 == 2) || (i2 == 2))
      {
        i3 = 2;
        break;
      }
      i3 = 0;
      break;
      label161: if (localLayoutParams1.a == 1.0F)
      {
        DrawerLayout.LayoutParams localLayoutParams2 = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
        if (!localLayoutParams2.c)
        {
          localLayoutParams2.c = true;
          if (this.y != null)
            this.y.onDrawerOpened(paramView);
          paramView.sendAccessibilityEvent(32);
        }
      }
    }
  }

  final void a(View paramView, float paramFloat)
  {
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (paramFloat == localLayoutParams.a);
    do
    {
      return;
      localLayoutParams.a = paramFloat;
    }
    while (this.y == null);
    this.y.onDrawerSlide(paramView, paramFloat);
  }

  final boolean a(View paramView, int paramInt)
  {
    return (paramInt & e(paramView)) == paramInt;
  }

  final void b()
  {
    int i1 = 0;
    if (!this.x)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
      int i2 = getChildCount();
      while (i1 < i2)
      {
        getChildAt(i1).dispatchTouchEvent(localMotionEvent);
        i1++;
      }
      localMotionEvent.recycle();
      this.x = true;
    }
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof DrawerLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }

  public void closeDrawer(int paramInt)
  {
    int i1 = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    View localView = a(i1);
    if (localView == null)
      throw new IllegalArgumentException("No drawer view found with absolute gravity " + b(i1));
    closeDrawer(localView);
  }

  public void closeDrawer(View paramView)
  {
    if (!b(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    if (this.t)
    {
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.a = 0.0F;
      localLayoutParams.c = false;
    }
    while (true)
    {
      invalidate();
      return;
      if (a(paramView, 3))
        this.n.smoothSlideViewTo(paramView, -paramView.getWidth(), paramView.getTop());
      else
        this.o.smoothSlideViewTo(paramView, getWidth(), paramView.getTop());
    }
  }

  public void closeDrawers()
  {
    a(false);
  }

  public void computeScroll()
  {
    int i1 = getChildCount();
    float f1 = 0.0F;
    for (int i2 = 0; i2 < i1; i2++)
      f1 = Math.max(f1, ((DrawerLayout.LayoutParams)getChildAt(i2).getLayoutParams()).a);
    this.l = f1;
    if ((this.n.continueSettling(true) | this.o.continueSettling(true)))
      ViewCompat.postInvalidateOnAnimation(this);
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i1 = getHeight();
    boolean bool1 = g(paramView);
    int i2 = getWidth();
    int i3 = paramCanvas.save();
    int i4 = 0;
    int i15;
    View localView;
    int i17;
    label94: int i18;
    if (bool1)
    {
      int i14 = getChildCount();
      i15 = 0;
      if (i15 < i14)
      {
        localView = getChildAt(i15);
        if ((localView != paramView) && (localView.getVisibility() == 0))
        {
          Drawable localDrawable = localView.getBackground();
          if (localDrawable != null)
            if (localDrawable.getOpacity() == -1)
            {
              i17 = 1;
              if ((i17 == 0) || (!b(localView)) || (localView.getHeight() < i1))
                break label185;
              if (!a(localView, 3))
                break label171;
              i18 = localView.getRight();
              if (i18 <= i4)
                break label520;
            }
        }
      }
    }
    while (true)
    {
      i4 = i18;
      int i16 = i2;
      while (true)
      {
        i15++;
        i2 = i16;
        break;
        i17 = 0;
        break label94;
        i17 = 0;
        break label94;
        label171: i16 = localView.getLeft();
        if (i16 >= i2)
          label185: i16 = i2;
      }
      paramCanvas.clipRect(i4, 0, i2, getHeight());
      int i5 = i2;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i3);
      if ((this.l > 0.0F) && (bool1))
      {
        int i13 = (int)(((0xFF000000 & this.k) >>> 24) * this.l) << 24 | 0xFFFFFF & this.k;
        this.m.setColor(i13);
        paramCanvas.drawRect(i4, 0.0F, i5, getHeight(), this.m);
      }
      do
      {
        return bool2;
        if ((this.B != null) && (a(paramView, 3)))
        {
          int i10 = this.B.getIntrinsicWidth();
          int i11 = paramView.getRight();
          int i12 = this.n.getEdgeSize();
          float f2 = Math.max(0.0F, Math.min(i11 / i12, 1.0F));
          this.B.setBounds(i11, paramView.getTop(), i10 + i11, paramView.getBottom());
          this.B.setAlpha((int)(255.0F * f2));
          this.B.draw(paramCanvas);
          return bool2;
        }
      }
      while ((this.C == null) || (!a(paramView, 5)));
      int i6 = this.C.getIntrinsicWidth();
      int i7 = paramView.getLeft();
      int i8 = getWidth() - i7;
      int i9 = this.o.getEdgeSize();
      float f1 = Math.max(0.0F, Math.min(i8 / i9, 1.0F));
      this.C.setBounds(i7 - i6, paramView.getTop(), i7, paramView.getBottom());
      this.C.setAlpha((int)(255.0F * f1));
      this.C.draw(paramCanvas);
      return bool2;
      label520: i18 = i4;
    }
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new DrawerLayout.LayoutParams(-1, -1);
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new DrawerLayout.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof DrawerLayout.LayoutParams))
      return new DrawerLayout.LayoutParams((DrawerLayout.LayoutParams)paramLayoutParams);
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new DrawerLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new DrawerLayout.LayoutParams(paramLayoutParams);
  }

  public int getDrawerLockMode(int paramInt)
  {
    int i1 = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if (i1 == 3)
      return this.u;
    if (i1 == 5)
      return this.v;
    return 0;
  }

  public int getDrawerLockMode(View paramView)
  {
    int i1 = e(paramView);
    if (i1 == 3)
      return this.u;
    if (i1 == 5)
      return this.v;
    return 0;
  }

  public boolean isDrawerOpen(int paramInt)
  {
    View localView = a(paramInt);
    if (localView != null)
      return isDrawerOpen(localView);
    return false;
  }

  public boolean isDrawerOpen(View paramView)
  {
    if (!b(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).c;
  }

  public boolean isDrawerVisible(int paramInt)
  {
    View localView = a(paramInt);
    if (localView != null)
      return isDrawerVisible(localView);
    return false;
  }

  public boolean isDrawerVisible(View paramView)
  {
    if (!b(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).a > 0.0F;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.t = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.t = true;
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    boolean bool1 = this.n.shouldInterceptTouchEvent(paramMotionEvent) | this.o.shouldInterceptTouchEvent(paramMotionEvent);
    label59: int i4;
    label77: int i5;
    switch (i1)
    {
    default:
      i2 = 0;
      if ((!bool1) && (i2 == 0))
      {
        int i3 = getChildCount();
        i4 = 0;
        if (i4 >= i3)
          break label243;
        if (!((DrawerLayout.LayoutParams)getChildAt(i4).getLayoutParams()).b)
          break;
        i5 = 1;
        if (i5 == 0)
        {
          boolean bool3 = this.x;
          bool2 = false;
          if (!bool3)
            break label127;
        }
      }
      boolean bool2 = true;
      return bool2;
    case 0:
      label105: label127: float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.z = f1;
      this.A = f2;
      if ((this.l <= 0.0F) || (!g(this.n.findTopChildUnder((int)f1, (int)f2))));
      break;
    case 2:
    case 1:
    case 3:
    }
    for (int i2 = 1; ; i2 = 0)
    {
      this.x = false;
      break label59;
      if (!this.n.checkTouchSlop(3))
        break;
      this.p.a();
      this.q.a();
      i2 = 0;
      break label59;
      a(true);
      this.x = false;
      break;
      i4++;
      break label77;
      label243: i5 = 0;
      break label105;
    }
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (f() != null);
      for (int i1 = 1; i1 != 0; i1 = 0)
      {
        KeyEventCompat.startTracking(paramKeyEvent);
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      View localView = f();
      if ((localView != null) && (getDrawerLockMode(localView) == 0))
        closeDrawers();
      return localView != null;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.s = true;
    int i1 = paramInt3 - paramInt1;
    int i2 = getChildCount();
    int i3 = 0;
    while (i3 < i2)
    {
      View localView = getChildAt(i3);
      DrawerLayout.LayoutParams localLayoutParams;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (g(localView))
          localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
      }
      else
      {
        i3++;
        continue;
      }
      int i4 = localView.getMeasuredWidth();
      int i5 = localView.getMeasuredHeight();
      int i6;
      float f1;
      label158: int i7;
      if (a(localView, 3))
      {
        i6 = -i4 + (int)(i4 * localLayoutParams.a);
        f1 = (i4 + i6) / i4;
        if (f1 == localLayoutParams.a)
          break label303;
        i7 = 1;
        label172: switch (0x70 & localLayoutParams.gravity)
        {
        default:
          localView.layout(i6, localLayoutParams.topMargin, i4 + i6, i5);
          label227: if (i7 != 0)
            a(localView, f1);
          if (localLayoutParams.a <= 0.0F)
            break;
        case 80:
        case 16:
        }
      }
      for (int i10 = 0; localView.getVisibility() != i10; i10 = 4)
      {
        localView.setVisibility(i10);
        break;
        i6 = i1 - (int)(i4 * localLayoutParams.a);
        f1 = (i1 - i6) / i4;
        break label158;
        label303: i7 = 0;
        break label172;
        int i11 = paramInt4 - paramInt2;
        localView.layout(i6, i11 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i4 + i6, i11 - localLayoutParams.bottomMargin);
        break label227;
        int i8 = paramInt4 - paramInt2;
        int i9 = (i8 - i5) / 2;
        if (i9 < localLayoutParams.topMargin)
          i9 = localLayoutParams.topMargin;
        while (true)
        {
          localView.layout(i6, i9, i4 + i6, i5 + i9);
          break;
          if (i9 + i5 > i8 - localLayoutParams.bottomMargin)
            i9 = i8 - localLayoutParams.bottomMargin - i5;
        }
      }
    }
    this.s = false;
    this.t = false;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 300;
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt1);
    int i5 = View.MeasureSpec.getSize(paramInt2);
    if ((i2 != 1073741824) || (i3 != 1073741824))
      if (isInEditMode())
      {
        if ((i2 != -2147483648) && (i2 == 0))
          i4 = i1;
        if ((i3 == -2147483648) || (i3 != 0))
          break label363;
      }
    while (true)
    {
      setMeasuredDimension(i4, i1);
      int i6 = getChildCount();
      int i7 = 0;
      if (i7 < i6)
      {
        View localView = getChildAt(i7);
        DrawerLayout.LayoutParams localLayoutParams;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if (!g(localView))
            break label200;
          localView.measure(View.MeasureSpec.makeMeasureSpec(i4 - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(i1 - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
        }
        while (true)
        {
          i7++;
          break;
          throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
          label200: if (!b(localView))
            break label319;
          int i8 = 0x7 & e(localView);
          if ((i8 & 0x0) != 0)
            throw new IllegalStateException("Child drawer has absolute gravity " + b(i8) + " but this DrawerLayout" + " already has a drawer view along that edge");
          localView.measure(getChildMeasureSpec(paramInt1, this.j + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
        }
        label319: throw new IllegalStateException("Child " + localView + " at index " + i7 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
      }
      return;
      label363: i1 = i5;
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    DrawerLayout.SavedState localSavedState = (DrawerLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.a != 0)
    {
      View localView = a(localSavedState.a);
      if (localView != null)
        openDrawer(localView);
    }
    setDrawerLockMode(localSavedState.b, 3);
    setDrawerLockMode(localSavedState.c, 5);
  }

  protected Parcelable onSaveInstanceState()
  {
    DrawerLayout.SavedState localSavedState = new DrawerLayout.SavedState(super.onSaveInstanceState());
    int i1 = getChildCount();
    for (int i2 = 0; ; i2++)
      if (i2 < i1)
      {
        View localView = getChildAt(i2);
        if (b(localView))
        {
          DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if (localLayoutParams.c)
            localSavedState.a = localLayoutParams.gravity;
        }
      }
      else
      {
        localSavedState.b = this.u;
        localSavedState.c = this.v;
        return localSavedState;
      }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.n.processTouchEvent(paramMotionEvent);
    this.o.processTouchEvent(paramMotionEvent);
    switch (0xFF & paramMotionEvent.getAction())
    {
    case 2:
    default:
      return true;
    case 0:
      float f5 = paramMotionEvent.getX();
      float f6 = paramMotionEvent.getY();
      this.z = f5;
      this.A = f6;
      this.x = false;
      return true;
    case 1:
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      View localView1 = this.n.findTopChildUnder((int)f1, (int)f2);
      if ((localView1 != null) && (g(localView1)))
      {
        float f3 = f1 - this.z;
        float f4 = f2 - this.A;
        int i1 = this.n.getTouchSlop();
        if (f3 * f3 + f4 * f4 < i1 * i1)
        {
          View localView2 = a();
          if (localView2 != null)
          {
            int i2 = getDrawerLockMode(localView2);
            bool = false;
            if (i2 != 2)
              break;
          }
        }
      }
      break;
    case 3:
    }
    for (boolean bool = true; ; bool = true)
    {
      a(bool);
      return true;
      a(true);
      this.x = false;
      return true;
    }
  }

  public void openDrawer(int paramInt)
  {
    int i1 = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    View localView = a(i1);
    if (localView == null)
      throw new IllegalArgumentException("No drawer view found with absolute gravity " + b(i1));
    openDrawer(localView);
  }

  public void openDrawer(View paramView)
  {
    if (!b(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    if (this.t)
    {
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.a = 1.0F;
      localLayoutParams.c = true;
    }
    while (true)
    {
      invalidate();
      return;
      if (a(paramView, 3))
        this.n.smoothSlideViewTo(paramView, 0, paramView.getTop());
      else
        this.o.smoothSlideViewTo(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
    }
  }

  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if (paramBoolean)
      a(true);
  }

  public void requestLayout()
  {
    if (!this.s)
      super.requestLayout();
  }

  public void setDrawerListener(DrawerLayout.DrawerListener paramDrawerListener)
  {
    this.y = paramDrawerListener;
  }

  public void setDrawerLockMode(int paramInt)
  {
    setDrawerLockMode(paramInt, 3);
    setDrawerLockMode(paramInt, 5);
  }

  public void setDrawerLockMode(int paramInt1, int paramInt2)
  {
    int i1 = GravityCompat.getAbsoluteGravity(paramInt2, ViewCompat.getLayoutDirection(this));
    ViewDragHelper localViewDragHelper;
    if (i1 == 3)
    {
      this.u = paramInt1;
      if (paramInt1 != 0)
      {
        if (i1 != 3)
          break label78;
        localViewDragHelper = this.n;
        label34: localViewDragHelper.cancel();
      }
      switch (paramInt1)
      {
      default:
      case 2:
      case 1:
      }
    }
    label78: View localView1;
    do
    {
      View localView2;
      do
      {
        return;
        if (i1 != 5)
          break;
        this.v = paramInt1;
        break;
        localViewDragHelper = this.o;
        break label34;
        localView2 = a(i1);
      }
      while (localView2 == null);
      openDrawer(localView2);
      return;
      localView1 = a(i1);
    }
    while (localView1 == null);
    closeDrawer(localView1);
  }

  public void setDrawerLockMode(int paramInt, View paramView)
  {
    if (!b(paramView))
      throw new IllegalArgumentException("View " + paramView + " is not a drawer with appropriate layout_gravity");
    setDrawerLockMode(paramInt, e(paramView));
  }

  public void setDrawerShadow(int paramInt1, int paramInt2)
  {
    setDrawerShadow(getResources().getDrawable(paramInt1), paramInt2);
  }

  public void setDrawerShadow(Drawable paramDrawable, int paramInt)
  {
    int i1 = GravityCompat.getAbsoluteGravity(paramInt, ViewCompat.getLayoutDirection(this));
    if ((i1 & 0x3) == 3)
    {
      this.B = paramDrawable;
      invalidate();
    }
    if ((i1 & 0x5) == 5)
    {
      this.C = paramDrawable;
      invalidate();
    }
  }

  public void setScrimColor(int paramInt)
  {
    this.k = paramInt;
    invalidate();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * JD-Core Version:    0.6.2
 */