package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class SlidingPaneLayout extends ViewGroup
{
  private static final String a = "SlidingPaneLayout";
  private static final int b = 32;
  private static final int c = -858993460;
  private static final int e = 400;
  private static L x = new L();
  private int d = -858993460;
  private int f;
  private Drawable g;
  private final int h;
  private boolean i;
  private View j;
  private float k;
  private float l;
  private int m;
  private boolean n;
  private int o;
  private float p;
  private float q;
  private SlidingPaneLayout.PanelSlideListener r;
  private final ViewDragHelper s;
  private boolean t;
  private boolean u = true;
  private final Rect v = new Rect();
  private final ArrayList<I> w = new ArrayList();

  static
  {
    int i1 = Build.VERSION.SDK_INT;
    if (i1 >= 17)
    {
      x = new O();
      return;
    }
    if (i1 >= 16)
    {
      x = new N();
      return;
    }
  }

  public SlidingPaneLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.h = ((int)(0.5F + 32.0F * f1));
    ViewConfiguration.get(paramContext);
    setWillNotDraw(false);
    ViewCompat.setAccessibilityDelegate(this, new H(this));
    ViewCompat.setImportantForAccessibility(this, 1);
    this.s = ViewDragHelper.create(this, 0.5F, new J(this, (byte)0));
    this.s.setEdgeTrackingEnabled(1);
    this.s.setMinVelocity(f1 * 400.0F);
  }

  private void a(View paramView, float paramFloat, int paramInt)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      i1 = (int)(paramFloat * ((0xFF000000 & paramInt) >>> 24)) << 24 | 0xFFFFFF & paramInt;
      if (localLayoutParams.c == null)
        localLayoutParams.c = new Paint();
      localLayoutParams.c.setColorFilter(new PorterDuffColorFilter(i1, PorterDuff.Mode.SRC_OVER));
      if (ViewCompat.getLayerType(paramView) != 2)
        ViewCompat.setLayerType(paramView, 2, localLayoutParams.c);
      g(paramView);
    }
    while (ViewCompat.getLayerType(paramView) == 0)
    {
      int i1;
      return;
    }
    if (localLayoutParams.c != null)
      localLayoutParams.c.setColorFilter(null);
    I localI = new I(this, paramView);
    this.w.add(localI);
    ViewCompat.postOnAnimation(this, localI);
  }

  private boolean a(float paramFloat)
  {
    if (!this.i)
      return false;
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)this.j.getLayoutParams();
    int i1 = (int)(getPaddingLeft() + localLayoutParams.leftMargin + paramFloat * this.m);
    if (this.s.smoothSlideViewTo(this.j, i1, this.j.getTop()))
    {
      a();
      ViewCompat.postInvalidateOnAnimation(this);
      return true;
    }
    return false;
  }

  private boolean a(int paramInt)
  {
    boolean bool1;
    if (!this.u)
    {
      boolean bool2 = a(0.0F);
      bool1 = false;
      if (!bool2);
    }
    else
    {
      this.t = false;
      bool1 = true;
    }
    return bool1;
  }

  private void b(float paramFloat)
  {
    int i1 = 0;
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)this.j.getLayoutParams();
    if ((localLayoutParams.b) && (localLayoutParams.leftMargin <= 0));
    for (int i2 = 1; ; i2 = 0)
    {
      int i3 = getChildCount();
      while (i1 < i3)
      {
        View localView = getChildAt(i1);
        if (localView != this.j)
        {
          int i4 = (int)((1.0F - this.l) * this.o);
          this.l = paramFloat;
          localView.offsetLeftAndRight(i4 - (int)((1.0F - paramFloat) * this.o));
          if (i2 != 0)
            a(localView, 1.0F - this.l, this.f);
        }
        i1++;
      }
    }
  }

  private boolean b(int paramInt)
  {
    if ((this.u) || (a(1.0F)))
    {
      this.t = true;
      return true;
    }
    return false;
  }

  private void c(int paramInt)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)this.j.getLayoutParams();
    this.k = ((paramInt - (getPaddingLeft() + localLayoutParams.leftMargin)) / this.m);
    if (this.o != 0)
      b(this.k);
    if (localLayoutParams.b)
      a(this.j, this.k, this.d);
    View localView = this.j;
    if (this.r != null)
      this.r.onPanelSlide(localView, this.k);
  }

  private void e(View paramView)
  {
    if (this.r != null)
      this.r.onPanelSlide(paramView, this.k);
  }

  private static boolean f(View paramView)
  {
    if (ViewCompat.isOpaque(paramView));
    Drawable localDrawable;
    do
    {
      return true;
      if (Build.VERSION.SDK_INT >= 18)
        return false;
      localDrawable = paramView.getBackground();
      if (localDrawable == null)
        break;
    }
    while (localDrawable.getOpacity() == -1);
    return false;
    return false;
  }

  private void g(View paramView)
  {
    x.a(this, paramView);
  }

  final void a()
  {
    int i1 = getChildCount();
    for (int i2 = 0; i2 < i1; i2++)
    {
      View localView = getChildAt(i2);
      if (localView.getVisibility() == 4)
        localView.setVisibility(0);
    }
  }

  final void a(View paramView)
  {
    if (this.r != null)
      this.r.onPanelOpened(paramView);
    sendAccessibilityEvent(32);
  }

  final void b(View paramView)
  {
    if (this.r != null)
      this.r.onPanelClosed(paramView);
    sendAccessibilityEvent(32);
  }

  final void c(View paramView)
  {
    int i1 = getPaddingLeft();
    int i2 = getWidth() - getPaddingRight();
    int i3 = getPaddingTop();
    int i4 = getHeight() - getPaddingBottom();
    int i16;
    int i8;
    int i7;
    int i6;
    int i5;
    label75: int i10;
    label84: View localView;
    if (paramView != null)
      if (ViewCompat.isOpaque(paramView))
      {
        i16 = 1;
        if (i16 == 0)
          break label241;
        i8 = paramView.getLeft();
        i7 = paramView.getRight();
        i6 = paramView.getTop();
        i5 = paramView.getBottom();
        int i9 = getChildCount();
        i10 = 0;
        if (i10 >= i9)
          return;
        localView = getChildAt(i10);
        if (localView == paramView)
          return;
        int i11 = Math.max(i1, localView.getLeft());
        int i12 = Math.max(i3, localView.getTop());
        int i13 = Math.min(i2, localView.getRight());
        int i14 = Math.min(i4, localView.getBottom());
        if ((i11 < i8) || (i12 < i6) || (i13 > i7) || (i14 > i5))
          break label256;
      }
    label256: for (int i15 = 4; ; i15 = 0)
    {
      localView.setVisibility(i15);
      i10++;
      break label84;
      if (Build.VERSION.SDK_INT < 18)
      {
        Drawable localDrawable = paramView.getBackground();
        if (localDrawable != null)
        {
          if (localDrawable.getOpacity() == -1)
          {
            i16 = 1;
            break;
          }
          i16 = 0;
          break;
        }
      }
      i16 = 0;
      break;
      label241: i5 = 0;
      i6 = 0;
      i7 = 0;
      i8 = 0;
      break label75;
    }
  }

  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    int i3;
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      i3 = -1 + localViewGroup.getChildCount();
      if (i3 >= 0)
      {
        localView = localViewGroup.getChildAt(i3);
        if ((paramInt2 + i1 < localView.getLeft()) || (paramInt2 + i1 >= localView.getRight()) || (paramInt3 + i2 < localView.getTop()) || (paramInt3 + i2 >= localView.getBottom()) || (!canScroll(localView, true, paramInt1, paramInt2 + i1 - localView.getLeft(), paramInt3 + i2 - localView.getTop())));
      }
    }
    while ((paramBoolean) && (ViewCompat.canScrollHorizontally(paramView, -paramInt1)))
    {
      View localView;
      return true;
      i3--;
      break;
    }
    return false;
  }

  public boolean canSlide()
  {
    return this.i;
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof SlidingPaneLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }

  public boolean closePane()
  {
    return a(0);
  }

  public void computeScroll()
  {
    if (this.s.continueSettling(true))
    {
      if (!this.i)
        this.s.abort();
    }
    else
      return;
    ViewCompat.postInvalidateOnAnimation(this);
  }

  final boolean d(View paramView)
  {
    if (paramView == null)
      return false;
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    return (this.i) && (localLayoutParams.b) && (this.k > 0.0F);
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (getChildCount() > 1);
    for (View localView = getChildAt(1); (localView == null) || (this.g == null); localView = null)
      return;
    int i1 = this.g.getIntrinsicWidth();
    int i2 = localView.getLeft();
    int i3 = localView.getTop();
    int i4 = localView.getBottom();
    int i5 = i2 - i1;
    this.g.setBounds(i5, i3, i2, i4);
    this.g.draw(paramCanvas);
  }

  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    int i1 = paramCanvas.save(2);
    if ((this.i) && (!localLayoutParams.a) && (this.j != null))
    {
      paramCanvas.getClipBounds(this.v);
      this.v.right = Math.min(this.v.right, this.j.getLeft());
      paramCanvas.clipRect(this.v);
    }
    boolean bool;
    if (Build.VERSION.SDK_INT < 11)
      if ((localLayoutParams.b) && (this.k > 0.0F))
      {
        if (!paramView.isDrawingCacheEnabled())
          paramView.setDrawingCacheEnabled(true);
        Bitmap localBitmap = paramView.getDrawingCache();
        if (localBitmap != null)
        {
          paramCanvas.drawBitmap(localBitmap, paramView.getLeft(), paramView.getTop(), localLayoutParams.c);
          bool = false;
        }
      }
    while (true)
    {
      paramCanvas.restoreToCount(i1);
      return bool;
      Log.e("SlidingPaneLayout", "drawChild: child view " + paramView + " returned null drawing cache");
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      continue;
      if (paramView.isDrawingCacheEnabled())
        paramView.setDrawingCacheEnabled(false);
      bool = super.drawChild(paramCanvas, paramView, paramLong);
    }
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new SlidingPaneLayout.LayoutParams();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new SlidingPaneLayout.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams))
      return new SlidingPaneLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    return new SlidingPaneLayout.LayoutParams(paramLayoutParams);
  }

  public int getCoveredFadeColor()
  {
    return this.f;
  }

  public int getParallaxDistance()
  {
    return this.o;
  }

  public int getSliderFadeColor()
  {
    return this.d;
  }

  public boolean isOpen()
  {
    return (!this.i) || (this.k == 1.0F);
  }

  public boolean isSlideable()
  {
    return this.i;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.u = true;
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.u = true;
    int i1 = this.w.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((I)this.w.get(i2)).run();
    this.w.clear();
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionMasked(paramMotionEvent);
    if ((!this.i) && (i1 == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null)
        if (this.s.isViewUnder(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))
          break label100;
    }
    boolean bool1;
    label100: for (boolean bool2 = true; ; bool2 = false)
    {
      this.t = bool2;
      if ((this.i) && ((!this.n) || (i1 == 0)))
        break;
      this.s.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i1 == 3) || (i1 == 1))
    {
      this.s.cancel();
      return false;
    }
    switch (i1)
    {
    case 1:
    default:
    case 0:
    case 2:
    }
    label152: float f3;
    float f4;
    do
    {
      for (int i2 = 0; ; i2 = 1)
      {
        if (!this.s.shouldInterceptTouchEvent(paramMotionEvent))
        {
          bool1 = false;
          if (i2 == 0)
            break;
        }
        return true;
        this.n = false;
        float f5 = paramMotionEvent.getX();
        float f6 = paramMotionEvent.getY();
        this.p = f5;
        this.q = f6;
        if ((!this.s.isViewUnder(this.j, (int)f5, (int)f6)) || (!d(this.j)))
          break label152;
      }
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      f3 = Math.abs(f1 - this.p);
      f4 = Math.abs(f2 - this.q);
    }
    while ((f3 <= this.s.getTouchSlop()) || (f4 <= f3));
    this.s.cancel();
    this.n = true;
    return false;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt3 - paramInt1;
    int i2 = getPaddingLeft();
    int i3 = getPaddingRight();
    int i4 = getPaddingTop();
    int i5 = getChildCount();
    float f1;
    int i6;
    int i7;
    label67: int i11;
    boolean bool;
    label189: int i9;
    if (this.u)
    {
      if ((this.i) && (this.t))
      {
        f1 = 1.0F;
        this.k = f1;
      }
    }
    else
    {
      i6 = 0;
      i7 = i2;
      if (i6 >= i5)
        break label317;
      View localView = getChildAt(i6);
      if (localView.getVisibility() == 8)
        break label429;
      SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)localView.getLayoutParams();
      int i10 = localView.getMeasuredWidth();
      i11 = 0;
      if (!localLayoutParams.a)
        break label277;
      int i14 = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
      int i15 = Math.min(i7, i1 - i3 - this.h) - i2 - i14;
      this.m = i15;
      if (i15 + (i2 + localLayoutParams.leftMargin) + i10 / 2 <= i1 - i3)
        break label271;
      bool = true;
      localLayoutParams.b = bool;
      i9 = i2 + ((int)(i15 * this.k) + localLayoutParams.leftMargin);
      int i13 = i9 - i11;
      localView.layout(i13, i4, i13 + i10, i4 + localView.getMeasuredHeight());
      i7 += localView.getWidth();
    }
    while (true)
    {
      i6++;
      i2 = i9;
      break label67;
      f1 = 0.0F;
      break;
      label271: bool = false;
      break label189;
      label277: if ((this.i) && (this.o != 0));
      for (int i12 = (int)((1.0F - this.k) * this.o); ; i12 = 0)
      {
        i11 = i12;
        i9 = i7;
        break;
        label317: if (this.u)
        {
          if (!this.i)
            break label392;
          if (this.o != 0)
            b(this.k);
          if (((SlidingPaneLayout.LayoutParams)this.j.getLayoutParams()).b)
            a(this.j, this.k, this.d);
        }
        while (true)
        {
          c(this.j);
          this.u = false;
          return;
          label392: for (int i8 = 0; i8 < i5; i8++)
            a(getChildAt(i8), 0.0F, this.d);
        }
      }
      label429: i9 = i2;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i5;
    int i6;
    int i7;
    if (i1 != 1073741824)
      if (isInEditMode())
      {
        if ((i1 == -2147483648) || (i1 != 0))
          break label1092;
        i5 = i3;
        i6 = 300;
        i7 = i4;
      }
    while (true)
    {
      int i9;
      int i8;
      label94: boolean bool1;
      int i10;
      int i11;
      int i12;
      int i13;
      float f1;
      label147: View localView2;
      SlidingPaneLayout.LayoutParams localLayoutParams2;
      int i29;
      int i30;
      float f2;
      boolean bool4;
      switch (i5)
      {
      default:
        i9 = 0;
        i8 = -1;
        bool1 = false;
        i10 = i6 - getPaddingLeft() - getPaddingRight();
        i11 = getChildCount();
        if (i11 > 2)
          Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        this.j = null;
        i12 = 0;
        i13 = i9;
        f1 = 0.0F;
        if (i12 < i11)
        {
          localView2 = getChildAt(i12);
          localLayoutParams2 = (SlidingPaneLayout.LayoutParams)localView2.getLayoutParams();
          if (localView2.getVisibility() == 8)
          {
            localLayoutParams2.b = false;
            i29 = i10;
            i30 = i13;
            f2 = f1;
            bool4 = bool1;
          }
        }
        break;
      case 1073741824:
      case -2147483648:
      }
      while (true)
      {
        i12++;
        bool1 = bool4;
        i13 = i30;
        i10 = i29;
        f1 = f2;
        break label147;
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (i3 != 0)
          break label1092;
        if (isInEditMode())
        {
          if (i3 != 0)
            break label1092;
          i5 = -2147483648;
          i6 = i2;
          i7 = 300;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        i9 = i7 - getPaddingTop() - getPaddingBottom();
        i8 = i9;
        break label94;
        i8 = i7 - getPaddingTop() - getPaddingBottom();
        i9 = 0;
        break label94;
        if (localLayoutParams2.weight > 0.0F)
        {
          f1 += localLayoutParams2.weight;
          if (localLayoutParams2.width == 0);
        }
        else
        {
          int i23 = localLayoutParams2.leftMargin + localLayoutParams2.rightMargin;
          int i24;
          label387: int i25;
          label407: int i28;
          if (localLayoutParams2.width == -2)
          {
            i24 = View.MeasureSpec.makeMeasureSpec(i6 - i23, -2147483648);
            if (localLayoutParams2.height != -2)
              break label557;
            i25 = View.MeasureSpec.makeMeasureSpec(i8, -2147483648);
            localView2.measure(i24, i25);
            int i26 = localView2.getMeasuredWidth();
            int i27 = localView2.getMeasuredHeight();
            if ((i5 == -2147483648) && (i27 > i13))
              i13 = Math.min(i27, i8);
            i28 = i10 - i26;
            if (i28 >= 0)
              break label595;
          }
          label557: label595: for (boolean bool2 = true; ; bool2 = false)
          {
            localLayoutParams2.a = bool2;
            boolean bool3 = bool2 | bool1;
            if (localLayoutParams2.a)
              this.j = localView2;
            i29 = i28;
            f2 = f1;
            bool4 = bool3;
            i30 = i13;
            break;
            if (localLayoutParams2.width == -1)
            {
              i24 = View.MeasureSpec.makeMeasureSpec(i6 - i23, 1073741824);
              break label387;
            }
            i24 = View.MeasureSpec.makeMeasureSpec(localLayoutParams2.width, 1073741824);
            break label387;
            if (localLayoutParams2.height == -1)
            {
              i25 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
              break label407;
            }
            i25 = View.MeasureSpec.makeMeasureSpec(localLayoutParams2.height, 1073741824);
            break label407;
          }
          if ((bool1) || (f1 > 0.0F))
          {
            int i14 = i6 - this.h;
            int i15 = 0;
            if (i15 < i11)
            {
              View localView1 = getChildAt(i15);
              SlidingPaneLayout.LayoutParams localLayoutParams1;
              int i16;
              label691: int i17;
              label699: int i22;
              if (localView1.getVisibility() != 8)
              {
                localLayoutParams1 = (SlidingPaneLayout.LayoutParams)localView1.getLayoutParams();
                if (localView1.getVisibility() != 8)
                {
                  if ((localLayoutParams1.width != 0) || (localLayoutParams1.weight <= 0.0F))
                    break label784;
                  i16 = 1;
                  if (i16 == 0)
                    break label790;
                  i17 = 0;
                  if ((!bool1) || (localView1 == this.j))
                    break label854;
                  if ((localLayoutParams1.width < 0) && ((i17 > i14) || (localLayoutParams1.weight > 0.0F)))
                  {
                    if (i16 == 0)
                      break label838;
                    if (localLayoutParams1.height != -2)
                      break label800;
                    i22 = View.MeasureSpec.makeMeasureSpec(i8, -2147483648);
                    label763: localView1.measure(View.MeasureSpec.makeMeasureSpec(i14, 1073741824), i22);
                  }
                }
              }
              while (true)
              {
                i15++;
                break;
                label784: i16 = 0;
                break label691;
                label790: i17 = localView1.getMeasuredWidth();
                break label699;
                label800: if (localLayoutParams1.height == -1)
                {
                  i22 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                  break label763;
                }
                i22 = View.MeasureSpec.makeMeasureSpec(localLayoutParams1.height, 1073741824);
                break label763;
                label838: i22 = View.MeasureSpec.makeMeasureSpec(localView1.getMeasuredHeight(), 1073741824);
                break label763;
                label854: if (localLayoutParams1.weight > 0.0F)
                {
                  int i18;
                  if (localLayoutParams1.width == 0)
                    if (localLayoutParams1.height == -2)
                      i18 = View.MeasureSpec.makeMeasureSpec(i8, -2147483648);
                  while (true)
                  {
                    if (!bool1)
                      break label996;
                    int i20 = i6 - (localLayoutParams1.leftMargin + localLayoutParams1.rightMargin);
                    int i21 = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
                    if (i17 == i20)
                      break;
                    localView1.measure(i21, i18);
                    break;
                    if (localLayoutParams1.height == -1)
                    {
                      i18 = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
                    }
                    else
                    {
                      i18 = View.MeasureSpec.makeMeasureSpec(localLayoutParams1.height, 1073741824);
                      continue;
                      i18 = View.MeasureSpec.makeMeasureSpec(localView1.getMeasuredHeight(), 1073741824);
                    }
                  }
                  label996: int i19 = Math.max(0, i10);
                  localView1.measure(View.MeasureSpec.makeMeasureSpec(i17 + (int)(localLayoutParams1.weight * i19 / f1), 1073741824), i18);
                }
              }
            }
          }
          setMeasuredDimension(i6, i13);
          this.i = bool1;
          if ((this.s.getViewDragState() != 0) && (!bool1))
            this.s.abort();
          return;
        }
        i29 = i10;
        i30 = i13;
        f2 = f1;
        bool4 = bool1;
      }
      label1092: i5 = i3;
      i6 = i2;
      i7 = i4;
    }
  }

  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    SlidingPaneLayout.SavedState localSavedState = (SlidingPaneLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (localSavedState.a)
      openPane();
    while (true)
    {
      this.t = localSavedState.a;
      return;
      closePane();
    }
  }

  protected Parcelable onSaveInstanceState()
  {
    SlidingPaneLayout.SavedState localSavedState = new SlidingPaneLayout.SavedState(super.onSaveInstanceState());
    if (isSlideable());
    for (boolean bool = isOpen(); ; bool = this.t)
    {
      localSavedState.a = bool;
      return localSavedState;
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      this.u = true;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.i)
      return super.onTouchEvent(paramMotionEvent);
    this.s.processTouchEvent(paramMotionEvent);
    switch (0xFF & paramMotionEvent.getAction())
    {
    default:
    case 0:
    case 1:
    }
    while (true)
    {
      return true;
      float f5 = paramMotionEvent.getX();
      float f6 = paramMotionEvent.getY();
      this.p = f5;
      this.q = f6;
      continue;
      if (d(this.j))
      {
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        float f3 = f1 - this.p;
        float f4 = f2 - this.q;
        int i1 = this.s.getTouchSlop();
        if ((f3 * f3 + f4 * f4 < i1 * i1) && (this.s.isViewUnder(this.j, (int)f1, (int)f2)))
          a(0);
      }
    }
  }

  public boolean openPane()
  {
    if ((this.u) || (a(1.0F)))
    {
      this.t = true;
      return true;
    }
    return false;
  }

  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.i))
      if (paramView1 != this.j)
        break label36;
    label36: for (boolean bool = true; ; bool = false)
    {
      this.t = bool;
      return;
    }
  }

  public void setCoveredFadeColor(int paramInt)
  {
    this.f = paramInt;
  }

  public void setPanelSlideListener(SlidingPaneLayout.PanelSlideListener paramPanelSlideListener)
  {
    this.r = paramPanelSlideListener;
  }

  public void setParallaxDistance(int paramInt)
  {
    this.o = paramInt;
    requestLayout();
  }

  public void setShadowDrawable(Drawable paramDrawable)
  {
    this.g = paramDrawable;
  }

  public void setShadowResource(int paramInt)
  {
    setShadowDrawable(getResources().getDrawable(paramInt));
  }

  public void setSliderFadeColor(int paramInt)
  {
    this.d = paramInt;
  }

  public void smoothSlideClosed()
  {
    closePane();
  }

  public void smoothSlideOpen()
  {
    openPane();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.6.2
 */