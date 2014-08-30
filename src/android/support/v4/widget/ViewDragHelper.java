package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

public class ViewDragHelper
{
  public static final int DIRECTION_ALL = 3;
  public static final int DIRECTION_HORIZONTAL = 1;
  public static final int DIRECTION_VERTICAL = 2;
  public static final int EDGE_ALL = 15;
  public static final int EDGE_BOTTOM = 8;
  public static final int EDGE_LEFT = 1;
  public static final int EDGE_RIGHT = 2;
  public static final int EDGE_TOP = 4;
  public static final int INVALID_POINTER = -1;
  public static final int STATE_DRAGGING = 1;
  public static final int STATE_IDLE = 0;
  public static final int STATE_SETTLING = 2;
  private static final String a = "ViewDragHelper";
  private static final int b = 20;
  private static final int c = 256;
  private static final int d = 600;
  private static final Interpolator z = new P();
  private final Runnable A = new Q(this);
  private int e;
  private int f;
  private int g = -1;
  private float[] h;
  private float[] i;
  private float[] j;
  private float[] k;
  private int[] l;
  private int[] m;
  private int[] n;
  private int o;
  private VelocityTracker p;
  private float q;
  private float r;
  private int s;
  private int t;
  private ScrollerCompat u;
  private final ViewDragHelper.Callback v;
  private View w;
  private boolean x;
  private final ViewGroup y;

  private ViewDragHelper(Context paramContext, ViewGroup paramViewGroup, ViewDragHelper.Callback paramCallback)
  {
    if (paramViewGroup == null)
      throw new IllegalArgumentException("Parent view may not be null");
    if (paramCallback == null)
      throw new IllegalArgumentException("Callback may not be null");
    this.y = paramViewGroup;
    this.v = paramCallback;
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(paramContext);
    this.s = ((int)(0.5F + 20.0F * paramContext.getResources().getDisplayMetrics().density));
    this.f = localViewConfiguration.getScaledTouchSlop();
    this.q = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.r = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.u = ScrollerCompat.create(paramContext, z);
  }

  private static float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    float f1 = Math.abs(paramFloat1);
    if (f1 < paramFloat2)
      paramFloat3 = 0.0F;
    do
    {
      return paramFloat3;
      if (f1 <= paramFloat3)
        break;
    }
    while (paramFloat1 > 0.0F);
    return -paramFloat3;
    return paramFloat1;
  }

  private int a(int paramInt1, int paramInt2)
  {
    int i1 = this.y.getLeft() + this.s;
    int i2 = 0;
    if (paramInt1 < i1)
      i2 = 1;
    if (paramInt2 < this.y.getTop() + this.s)
      i2 |= 4;
    if (paramInt1 > this.y.getRight() - this.s)
      i2 |= 2;
    if (paramInt2 > this.y.getBottom() - this.s)
      i2 |= 8;
    return i2;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 == 0)
      return 0;
    int i1 = this.y.getWidth();
    int i2 = i1 / 2;
    float f1 = Math.min(1.0F, Math.abs(paramInt1) / i1);
    float f2 = i2 + i2 * (float)Math.sin((float)(0.47123891676382D * (f1 - 0.5F)));
    int i3 = Math.abs(paramInt2);
    if (i3 > 0);
    for (int i4 = 4 * Math.round(1000.0F * Math.abs(f2 / i3)); ; i4 = (int)(256.0F * (1.0F + Math.abs(paramInt1) / paramInt3)))
      return Math.min(i4, 600);
  }

  private int a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = b(paramInt3, (int)this.r, (int)this.q);
    int i2 = b(paramInt4, (int)this.r, (int)this.q);
    int i3 = Math.abs(paramInt1);
    int i4 = Math.abs(paramInt2);
    int i5 = Math.abs(i1);
    int i6 = Math.abs(i2);
    int i7 = i5 + i6;
    int i8 = i3 + i4;
    float f1;
    if (i1 != 0)
    {
      f1 = i5 / i7;
      if (i2 == 0)
        break label163;
    }
    label163: for (float f2 = i6 / i7; ; f2 = i4 / i8)
    {
      int i9 = a(paramInt1, i1, this.v.getViewHorizontalDragRange(paramView));
      int i10 = a(paramInt2, i2, this.v.getViewVerticalDragRange(paramView));
      return (int)(f1 * i9 + f2 * i10);
      f1 = i3 / i8;
      break;
    }
  }

  private void a()
  {
    if (this.h == null)
      return;
    Arrays.fill(this.h, 0.0F);
    Arrays.fill(this.i, 0.0F);
    Arrays.fill(this.j, 0.0F);
    Arrays.fill(this.k, 0.0F);
    Arrays.fill(this.l, 0);
    Arrays.fill(this.m, 0);
    Arrays.fill(this.n, 0);
    this.o = 0;
  }

  private void a(float paramFloat1, float paramFloat2)
  {
    this.x = true;
    this.v.onViewReleased(this.w, paramFloat1, paramFloat2);
    this.x = false;
    if (this.e == 1)
      a(0);
  }

  private void a(float paramFloat1, float paramFloat2, int paramInt)
  {
    if ((this.h == null) || (this.h.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.h != null)
      {
        System.arraycopy(this.h, 0, arrayOfFloat1, 0, this.h.length);
        System.arraycopy(this.i, 0, arrayOfFloat2, 0, this.i.length);
        System.arraycopy(this.j, 0, arrayOfFloat3, 0, this.j.length);
        System.arraycopy(this.k, 0, arrayOfFloat4, 0, this.k.length);
        System.arraycopy(this.l, 0, arrayOfInt1, 0, this.l.length);
        System.arraycopy(this.m, 0, arrayOfInt2, 0, this.m.length);
        System.arraycopy(this.n, 0, arrayOfInt3, 0, this.n.length);
      }
      this.h = arrayOfFloat1;
      this.i = arrayOfFloat2;
      this.j = arrayOfFloat3;
      this.k = arrayOfFloat4;
      this.l = arrayOfInt1;
      this.m = arrayOfInt2;
      this.n = arrayOfInt3;
    }
    float[] arrayOfFloat5 = this.h;
    this.j[paramInt] = paramFloat1;
    arrayOfFloat5[paramInt] = paramFloat1;
    float[] arrayOfFloat6 = this.i;
    this.k[paramInt] = paramFloat2;
    arrayOfFloat6[paramInt] = paramFloat2;
    int[] arrayOfInt4 = this.l;
    int i1 = (int)paramFloat1;
    int i2 = (int)paramFloat2;
    int i3 = this.y.getLeft() + this.s;
    int i4 = 0;
    if (i1 < i3)
      i4 = 1;
    if (i2 < this.y.getTop() + this.s)
      i4 |= 4;
    if (i1 > this.y.getRight() - this.s)
      i4 |= 2;
    if (i2 > this.y.getBottom() - this.s)
      i4 |= 8;
    arrayOfInt4[paramInt] = i4;
    this.o |= 1 << paramInt;
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getPointerCount(paramMotionEvent);
    for (int i2 = 0; i2 < i1; i2++)
    {
      int i3 = MotionEventCompat.getPointerId(paramMotionEvent, i2);
      float f1 = MotionEventCompat.getX(paramMotionEvent, i2);
      float f2 = MotionEventCompat.getY(paramMotionEvent, i2);
      this.j[i3] = f1;
      this.k[i3] = f2;
    }
  }

  private boolean a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    float f1 = Math.abs(paramFloat1);
    float f2 = Math.abs(paramFloat2);
    if (((paramInt2 & this.l[paramInt1]) != paramInt2) || ((paramInt2 & this.t) == 0) || ((paramInt2 & this.n[paramInt1]) == paramInt2) || ((paramInt2 & this.m[paramInt1]) == paramInt2) || ((f1 <= this.f) && (f2 <= this.f)));
    do
    {
      return false;
      if ((f1 < f2 * 0.5F) && (this.v.onEdgeLock(paramInt2)))
      {
        int[] arrayOfInt = this.n;
        arrayOfInt[paramInt1] = (paramInt2 | arrayOfInt[paramInt1]);
        return false;
      }
    }
    while (((paramInt2 & this.m[paramInt1]) != 0) || (f1 <= this.f));
    return true;
  }

  private boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.w.getLeft();
    int i2 = this.w.getTop();
    int i3 = paramInt1 - i1;
    int i4 = paramInt2 - i2;
    if ((i3 == 0) && (i4 == 0))
    {
      this.u.abortAnimation();
      a(0);
      return false;
    }
    View localView = this.w;
    int i5 = b(paramInt3, (int)this.r, (int)this.q);
    int i6 = b(paramInt4, (int)this.r, (int)this.q);
    int i7 = Math.abs(i3);
    int i8 = Math.abs(i4);
    int i9 = Math.abs(i5);
    int i10 = Math.abs(i6);
    int i11 = i9 + i10;
    int i12 = i7 + i8;
    float f1;
    if (i5 != 0)
    {
      f1 = i9 / i11;
      if (i6 == 0)
        break label253;
    }
    label253: for (float f2 = i10 / i11; ; f2 = i8 / i12)
    {
      int i13 = a(i3, i5, this.v.getViewHorizontalDragRange(localView));
      int i14 = a(i4, i6, this.v.getViewVerticalDragRange(localView));
      int i15 = (int)(f1 * i13 + f2 * i14);
      this.u.startScroll(i1, i2, i3, i4, i15);
      a(2);
      return true;
      f1 = i7 / i12;
      break;
    }
  }

  private boolean a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null);
    label20: int i2;
    label73: label79: 
    do
    {
      do
      {
        return false;
        int i1;
        if (this.v.getViewHorizontalDragRange(paramView) > 0)
        {
          i1 = 1;
          if (this.v.getViewVerticalDragRange(paramView) <= 0)
            break label73;
        }
        for (i2 = 1; ; i2 = 0)
        {
          if ((i1 == 0) || (i2 == 0))
            break label79;
          if (paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2 <= this.f * this.f)
            break;
          return true;
          i1 = 0;
          break label20;
        }
        if (i1 == 0)
          break;
      }
      while (Math.abs(paramFloat1) <= this.f);
      return true;
    }
    while ((i2 == 0) || (Math.abs(paramFloat2) <= this.f));
    return true;
  }

  private boolean a(View paramView, int paramInt)
  {
    if ((paramView == this.w) && (this.g == paramInt))
      return true;
    if ((paramView != null) && (this.v.tryCaptureView(paramView, paramInt)))
    {
      this.g = paramInt;
      captureChildView(paramView, paramInt);
      return true;
    }
    return false;
  }

  private static int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = Math.abs(paramInt1);
    if (i1 < paramInt2)
      paramInt3 = 0;
    do
    {
      return paramInt3;
      if (i1 <= paramInt3)
        break;
    }
    while (paramInt1 > 0);
    return -paramInt3;
    return paramInt1;
  }

  private void b()
  {
    this.p.computeCurrentVelocity(1000, this.q);
    a(a(VelocityTrackerCompat.getXVelocity(this.p, this.g), this.r, this.q), a(VelocityTrackerCompat.getYVelocity(this.p, this.g), this.r, this.q));
  }

  private void b(float paramFloat1, float paramFloat2, int paramInt)
  {
    int i1 = 1;
    if (a(paramFloat1, paramFloat2, paramInt, i1));
    while (true)
    {
      if (a(paramFloat2, paramFloat1, paramInt, 4))
        i1 |= 4;
      if (a(paramFloat1, paramFloat2, paramInt, 2))
        i1 |= 2;
      if (a(paramFloat2, paramFloat1, paramInt, 8))
        i1 |= 8;
      if (i1 != 0)
      {
        int[] arrayOfInt = this.m;
        arrayOfInt[paramInt] = (i1 | arrayOfInt[paramInt]);
        this.v.onEdgeDragStarted(i1, paramInt);
      }
      return;
      i1 = 0;
    }
  }

  private void b(int paramInt)
  {
    if (this.h == null)
      return;
    this.h[paramInt] = 0.0F;
    this.i[paramInt] = 0.0F;
    this.j[paramInt] = 0.0F;
    this.k[paramInt] = 0.0F;
    this.l[paramInt] = 0;
    this.m[paramInt] = 0;
    this.n[paramInt] = 0;
    this.o &= (0xFFFFFFFF ^ 1 << paramInt);
  }

  private void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = this.w.getLeft();
    int i2 = this.w.getTop();
    int i3;
    if (paramInt3 != 0)
    {
      i3 = this.v.clampViewPositionHorizontal(this.w, paramInt1, paramInt3);
      this.w.offsetLeftAndRight(i3 - i1);
    }
    while (true)
    {
      int i4;
      if (paramInt4 != 0)
      {
        i4 = this.v.clampViewPositionVertical(this.w, paramInt2, paramInt4);
        this.w.offsetTopAndBottom(i4 - i2);
      }
      while (true)
      {
        if ((paramInt3 != 0) || (paramInt4 != 0))
        {
          int i5 = i3 - i1;
          int i6 = i4 - i2;
          this.v.onViewPositionChanged(this.w, i3, i4, i5, i6);
        }
        return;
        i4 = paramInt2;
      }
      i3 = paramInt1;
    }
  }

  private void c(int paramInt)
  {
    if ((this.h == null) || (this.h.length <= paramInt))
    {
      float[] arrayOfFloat1 = new float[paramInt + 1];
      float[] arrayOfFloat2 = new float[paramInt + 1];
      float[] arrayOfFloat3 = new float[paramInt + 1];
      float[] arrayOfFloat4 = new float[paramInt + 1];
      int[] arrayOfInt1 = new int[paramInt + 1];
      int[] arrayOfInt2 = new int[paramInt + 1];
      int[] arrayOfInt3 = new int[paramInt + 1];
      if (this.h != null)
      {
        System.arraycopy(this.h, 0, arrayOfFloat1, 0, this.h.length);
        System.arraycopy(this.i, 0, arrayOfFloat2, 0, this.i.length);
        System.arraycopy(this.j, 0, arrayOfFloat3, 0, this.j.length);
        System.arraycopy(this.k, 0, arrayOfFloat4, 0, this.k.length);
        System.arraycopy(this.l, 0, arrayOfInt1, 0, this.l.length);
        System.arraycopy(this.m, 0, arrayOfInt2, 0, this.m.length);
        System.arraycopy(this.n, 0, arrayOfInt3, 0, this.n.length);
      }
      this.h = arrayOfFloat1;
      this.i = arrayOfFloat2;
      this.j = arrayOfFloat3;
      this.k = arrayOfFloat4;
      this.l = arrayOfInt1;
      this.m = arrayOfInt2;
      this.n = arrayOfInt3;
    }
  }

  public static ViewDragHelper create(ViewGroup paramViewGroup, float paramFloat, ViewDragHelper.Callback paramCallback)
  {
    ViewDragHelper localViewDragHelper = create(paramViewGroup, paramCallback);
    localViewDragHelper.f = ((int)(localViewDragHelper.f * (1.0F / paramFloat)));
    return localViewDragHelper;
  }

  public static ViewDragHelper create(ViewGroup paramViewGroup, ViewDragHelper.Callback paramCallback)
  {
    return new ViewDragHelper(paramViewGroup.getContext(), paramViewGroup, paramCallback);
  }

  final void a(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      this.v.onViewDragStateChanged(paramInt);
      if (paramInt == 0)
        this.w = null;
    }
  }

  public void abort()
  {
    cancel();
    if (this.e == 2)
    {
      int i1 = this.u.getCurrX();
      int i2 = this.u.getCurrY();
      this.u.abortAnimation();
      int i3 = this.u.getCurrX();
      int i4 = this.u.getCurrY();
      this.v.onViewPositionChanged(this.w, i3, i4, i3 - i1, i4 - i2);
    }
    a(0);
  }

  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      for (int i3 = -1 + localViewGroup.getChildCount(); i3 >= 0; i3--)
      {
        View localView = localViewGroup.getChildAt(i3);
        if ((paramInt3 + i1 >= localView.getLeft()) && (paramInt3 + i1 < localView.getRight()) && (paramInt4 + i2 >= localView.getTop()) && (paramInt4 + i2 < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2, paramInt3 + i1 - localView.getLeft(), paramInt4 + i2 - localView.getTop())))
          return true;
      }
    }
    return (paramBoolean) && ((ViewCompat.canScrollHorizontally(paramView, -paramInt1)) || (ViewCompat.canScrollVertically(paramView, -paramInt2)));
  }

  public void cancel()
  {
    this.g = -1;
    if (this.h != null)
    {
      Arrays.fill(this.h, 0.0F);
      Arrays.fill(this.i, 0.0F);
      Arrays.fill(this.j, 0.0F);
      Arrays.fill(this.k, 0.0F);
      Arrays.fill(this.l, 0);
      Arrays.fill(this.m, 0);
      Arrays.fill(this.n, 0);
      this.o = 0;
    }
    if (this.p != null)
    {
      this.p.recycle();
      this.p = null;
    }
  }

  public void captureChildView(View paramView, int paramInt)
  {
    if (paramView.getParent() != this.y)
      throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.y + ")");
    this.w = paramView;
    this.g = paramInt;
    this.v.onViewCaptured(paramView, paramInt);
    a(1);
  }

  public boolean checkTouchSlop(int paramInt)
  {
    int i1 = this.h.length;
    for (int i2 = 0; ; i2++)
    {
      boolean bool = false;
      if (i2 < i1)
      {
        if (checkTouchSlop(paramInt, i2))
          bool = true;
      }
      else
        return bool;
    }
  }

  public boolean checkTouchSlop(int paramInt1, int paramInt2)
  {
    if (!isPointerDown(paramInt2));
    label19: int i2;
    float f2;
    label100: label106: 
    do
    {
      float f1;
      do
      {
        return false;
        int i1;
        if ((paramInt1 & 0x1) == 1)
        {
          i1 = 1;
          if ((paramInt1 & 0x2) != 2)
            break label100;
        }
        for (i2 = 1; ; i2 = 0)
        {
          f1 = this.j[paramInt2] - this.h[paramInt2];
          f2 = this.k[paramInt2] - this.i[paramInt2];
          if ((i1 == 0) || (i2 == 0))
            break label106;
          if (f1 * f1 + f2 * f2 <= this.f * this.f)
            break;
          return true;
          i1 = 0;
          break label19;
        }
        if (i1 == 0)
          break;
      }
      while (Math.abs(f1) <= this.f);
      return true;
    }
    while ((i2 == 0) || (Math.abs(f2) <= this.f));
    return true;
  }

  public boolean continueSettling(boolean paramBoolean)
  {
    boolean bool1;
    if (this.e == 2)
    {
      bool1 = this.u.computeScrollOffset();
      int i1 = this.u.getCurrX();
      int i2 = this.u.getCurrY();
      int i3 = i1 - this.w.getLeft();
      int i4 = i2 - this.w.getTop();
      if (i3 != 0)
        this.w.offsetLeftAndRight(i3);
      if (i4 != 0)
        this.w.offsetTopAndBottom(i4);
      if ((i3 != 0) || (i4 != 0))
        this.v.onViewPositionChanged(this.w, i1, i2, i3, i4);
      if ((!bool1) || (i1 != this.u.getFinalX()) || (i2 != this.u.getFinalY()))
        break label196;
      this.u.abortAnimation();
    }
    label186: label196: for (boolean bool2 = this.u.isFinished(); ; bool2 = bool1)
    {
      if (!bool2)
      {
        if (!paramBoolean)
          break label186;
        this.y.post(this.A);
      }
      while (this.e == 2)
      {
        return true;
        a(0);
      }
      return false;
    }
  }

  public View findTopChildUnder(int paramInt1, int paramInt2)
  {
    for (int i1 = -1 + this.y.getChildCount(); i1 >= 0; i1--)
    {
      View localView = this.y.getChildAt(this.v.getOrderedChildIndex(i1));
      if ((paramInt1 >= localView.getLeft()) && (paramInt1 < localView.getRight()) && (paramInt2 >= localView.getTop()) && (paramInt2 < localView.getBottom()))
        return localView;
    }
    return null;
  }

  public void flingCapturedView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.x)
      throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    this.u.fling(this.w.getLeft(), this.w.getTop(), (int)VelocityTrackerCompat.getXVelocity(this.p, this.g), (int)VelocityTrackerCompat.getYVelocity(this.p, this.g), paramInt1, paramInt3, paramInt2, paramInt4);
    a(2);
  }

  public int getActivePointerId()
  {
    return this.g;
  }

  public View getCapturedView()
  {
    return this.w;
  }

  public int getEdgeSize()
  {
    return this.s;
  }

  public float getMinVelocity()
  {
    return this.r;
  }

  public int getTouchSlop()
  {
    return this.f;
  }

  public int getViewDragState()
  {
    return this.e;
  }

  public boolean isCapturedViewUnder(int paramInt1, int paramInt2)
  {
    return isViewUnder(this.w, paramInt1, paramInt2);
  }

  public boolean isEdgeTouched(int paramInt)
  {
    int i1 = this.l.length;
    for (int i2 = 0; ; i2++)
    {
      boolean bool = false;
      if (i2 < i1)
      {
        if (isEdgeTouched(paramInt, i2))
          bool = true;
      }
      else
        return bool;
    }
  }

  public boolean isEdgeTouched(int paramInt1, int paramInt2)
  {
    return (isPointerDown(paramInt2)) && ((paramInt1 & this.l[paramInt2]) != 0);
  }

  public boolean isPointerDown(int paramInt)
  {
    return (this.o & 1 << paramInt) != 0;
  }

  public boolean isViewUnder(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null);
    while ((paramInt1 < paramView.getLeft()) || (paramInt1 >= paramView.getRight()) || (paramInt2 < paramView.getTop()) || (paramInt2 >= paramView.getBottom()))
      return false;
    return true;
  }

  public void processTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 0;
    int i2 = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i3 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i2 == 0)
      cancel();
    if (this.p == null)
      this.p = VelocityTracker.obtain();
    this.p.addMovement(paramMotionEvent);
    int i4;
    switch (i2)
    {
    case 4:
    default:
    case 0:
    case 5:
      int i19;
      float f9;
      float f10;
      do
      {
        int i20;
        do
        {
          int i21;
          int i22;
          do
          {
            return;
            float f11 = paramMotionEvent.getX();
            float f12 = paramMotionEvent.getY();
            i21 = MotionEventCompat.getPointerId(paramMotionEvent, 0);
            View localView2 = findTopChildUnder((int)f11, (int)f12);
            a(f11, f12, i21);
            a(localView2, i21);
            i22 = this.l[i21];
          }
          while ((i22 & this.t) == 0);
          this.v.onEdgeTouched(i22 & this.t, i21);
          return;
          i19 = MotionEventCompat.getPointerId(paramMotionEvent, i3);
          f9 = MotionEventCompat.getX(paramMotionEvent, i3);
          f10 = MotionEventCompat.getY(paramMotionEvent, i3);
          a(f9, f10, i19);
          if (this.e != 0)
            break;
          a(findTopChildUnder((int)f9, (int)f10), i19);
          i20 = this.l[i19];
        }
        while ((i20 & this.t) == 0);
        this.v.onEdgeTouched(i20 & this.t, i19);
        return;
      }
      while (!isCapturedViewUnder((int)f9, (int)f10));
      a(this.w, i19);
      return;
    case 2:
      if (this.e == 1)
      {
        int i10 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.g);
        float f7 = MotionEventCompat.getX(paramMotionEvent, i10);
        float f8 = MotionEventCompat.getY(paramMotionEvent, i10);
        int i11 = (int)(f7 - this.j[this.g]);
        int i12 = (int)(f8 - this.k[this.g]);
        int i13 = i11 + this.w.getLeft();
        int i14 = i12 + this.w.getTop();
        int i15 = this.w.getLeft();
        int i16 = this.w.getTop();
        if (i11 != 0)
        {
          i13 = this.v.clampViewPositionHorizontal(this.w, i13, i11);
          this.w.offsetLeftAndRight(i13 - i15);
        }
        if (i12 != 0)
        {
          i14 = this.v.clampViewPositionVertical(this.w, i14, i12);
          this.w.offsetTopAndBottom(i14 - i16);
        }
        if ((i11 != 0) || (i12 != 0))
        {
          int i17 = i13 - i15;
          int i18 = i14 - i16;
          this.v.onViewPositionChanged(this.w, i13, i14, i17, i18);
        }
        a(paramMotionEvent);
        return;
      }
      int i8 = MotionEventCompat.getPointerCount(paramMotionEvent);
      while (i1 < i8)
      {
        int i9 = MotionEventCompat.getPointerId(paramMotionEvent, i1);
        float f3 = MotionEventCompat.getX(paramMotionEvent, i1);
        float f4 = MotionEventCompat.getY(paramMotionEvent, i1);
        float f5 = f3 - this.h[i9];
        float f6 = f4 - this.i[i9];
        b(f5, f6, i9);
        if (this.e == 1)
          break;
        View localView1 = findTopChildUnder((int)f3, (int)f4);
        if ((a(localView1, f5, f6)) && (a(localView1, i9)))
          break;
        i1++;
      }
      a(paramMotionEvent);
      return;
    case 6:
      i4 = MotionEventCompat.getPointerId(paramMotionEvent, i3);
      if ((this.e == 1) && (i4 == this.g))
      {
        int i5 = MotionEventCompat.getPointerCount(paramMotionEvent);
        if (i1 >= i5)
          break label802;
        int i7 = MotionEventCompat.getPointerId(paramMotionEvent, i1);
        if (i7 == this.g)
          break label760;
        float f1 = MotionEventCompat.getX(paramMotionEvent, i1);
        float f2 = MotionEventCompat.getY(paramMotionEvent, i1);
        if ((findTopChildUnder((int)f1, (int)f2) != this.w) || (!a(this.w, i7)))
          break label760;
      }
      break;
    case 1:
    case 3:
    }
    label802: for (int i6 = this.g; ; i6 = -1)
    {
      if (i6 == -1)
        b();
      b(i4);
      return;
      label760: i1++;
      break;
      if (this.e == 1)
        b();
      cancel();
      return;
      if (this.e == 1)
        a(0.0F, 0.0F);
      cancel();
      return;
    }
  }

  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.t = paramInt;
  }

  public void setMinVelocity(float paramFloat)
  {
    this.r = paramFloat;
  }

  public boolean settleCapturedViewAt(int paramInt1, int paramInt2)
  {
    if (!this.x)
      throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    return a(paramInt1, paramInt2, (int)VelocityTrackerCompat.getXVelocity(this.p, this.g), (int)VelocityTrackerCompat.getYVelocity(this.p, this.g));
  }

  public boolean shouldInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    int i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (i1 == 0)
      cancel();
    if (this.p == null)
      this.p = VelocityTracker.obtain();
    this.p.addMovement(paramMotionEvent);
    switch (i1)
    {
    case 4:
    default:
    case 0:
    case 5:
    case 2:
    case 6:
    case 1:
    case 3:
    }
    while (this.e == 1)
    {
      return true;
      float f7 = paramMotionEvent.getX();
      float f8 = paramMotionEvent.getY();
      int i8 = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      a(f7, f8, i8);
      View localView3 = findTopChildUnder((int)f7, (int)f8);
      if ((localView3 == this.w) && (this.e == 2))
        a(localView3, i8);
      int i9 = this.l[i8];
      if ((i9 & this.t) != 0)
      {
        this.v.onEdgeTouched(i9 & this.t, i8);
        continue;
        int i6 = MotionEventCompat.getPointerId(paramMotionEvent, i2);
        float f5 = MotionEventCompat.getX(paramMotionEvent, i2);
        float f6 = MotionEventCompat.getY(paramMotionEvent, i2);
        a(f5, f6, i6);
        if (this.e == 0)
        {
          int i7 = this.l[i6];
          if ((i7 & this.t) != 0)
            this.v.onEdgeTouched(i7 & this.t, i6);
        }
        else if (this.e == 2)
        {
          View localView2 = findTopChildUnder((int)f5, (int)f6);
          if (localView2 == this.w)
          {
            a(localView2, i6);
            continue;
            int i3 = MotionEventCompat.getPointerCount(paramMotionEvent);
            for (int i4 = 0; i4 < i3; i4++)
            {
              int i5 = MotionEventCompat.getPointerId(paramMotionEvent, i4);
              float f1 = MotionEventCompat.getX(paramMotionEvent, i4);
              float f2 = MotionEventCompat.getY(paramMotionEvent, i4);
              float f3 = f1 - this.h[i5];
              float f4 = f2 - this.i[i5];
              b(f3, f4, i5);
              if (this.e == 1)
                break;
              View localView1 = findTopChildUnder((int)f1, (int)f2);
              if ((localView1 != null) && (a(localView1, f3, f4)) && (a(localView1, i5)))
                break;
            }
            a(paramMotionEvent);
            continue;
            b(MotionEventCompat.getPointerId(paramMotionEvent, i2));
            continue;
            cancel();
          }
        }
      }
    }
    return false;
  }

  public boolean smoothSlideViewTo(View paramView, int paramInt1, int paramInt2)
  {
    this.w = paramView;
    this.g = -1;
    return a(paramInt1, paramInt2, 0, 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.ViewDragHelper
 * JD-Core Version:    0.6.2
 */