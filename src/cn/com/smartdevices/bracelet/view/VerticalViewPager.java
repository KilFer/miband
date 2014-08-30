package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.view.KeyEventCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import cn.com.smartdevices.bracelet.Debug;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class VerticalViewPager extends ViewGroup
{
  private static final int J = -1;
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final String a = "VerticalViewPager";
  private static final boolean b = false;
  private static final boolean c = false;
  private static final int d = 1;
  private static final int e = 600;
  private static final int f = 25;
  private static final int[] g = { 16842931 };
  private static final Comparator<E> h = new B();
  private static final Interpolator i = new C();
  private boolean A;
  private int B = 1;
  private boolean C;
  private boolean D;
  private int E;
  private float F;
  private float G;
  private float H;
  private int I = -1;
  private VelocityTracker K;
  private int L;
  private int M;
  private int N;
  private boolean O;
  private long P;
  private EdgeEffectCompat Q;
  private EdgeEffectCompat R;
  private boolean S = true;
  private boolean T;
  private int U;
  private VerticalViewPager.OnPageChangeListener V;
  private VerticalViewPager.OnPageChangeListener W;
  private F Z;
  private int aa = 0;
  private final ArrayList<E> j = new ArrayList();
  private PagerAdapter k;
  private int l;
  private int m = -1;
  private Parcelable n = null;
  private ClassLoader o = null;
  private Scroller p;
  private G q;
  private int r;
  private Drawable s;
  private int t;
  private int u;
  private int v;
  private int w;
  private boolean x;
  private boolean y;
  private boolean z;

  public VerticalViewPager(Context paramContext)
  {
    super(paramContext);
    c();
  }

  public VerticalViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }

  private static float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.N) && (Math.abs(paramInt2) > this.L))
    {
      if (paramInt2 > 0)
        return paramInt1;
      return paramInt1 + 1;
    }
    return (int)(0.5F + (paramFloat + paramInt1));
  }

  private E a(View paramView)
  {
    for (int i1 = 0; ; i1++)
    {
      E localE;
      if (i1 >= this.j.size())
        localE = null;
      do
      {
        return localE;
        localE = (E)this.j.get(i1);
      }
      while (this.k.isViewFromObject(paramView, localE.a));
    }
  }

  private VerticalViewPager.OnPageChangeListener a(VerticalViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    VerticalViewPager.OnPageChangeListener localOnPageChangeListener = this.W;
    this.W = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }

  private void a(int paramInt)
  {
    if (this.aa == paramInt);
    do
    {
      return;
      this.aa = paramInt;
    }
    while (this.V == null);
    this.V.onPageScrollStateChanged(paramInt);
  }

  private void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0);
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      a(false);
      return;
    }
    int i1 = getScrollX();
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    int i4 = paramInt2 - i2;
    if ((i3 == 0) && (i4 == 0))
    {
      f();
      a(0);
      return;
    }
    a(true);
    this.A = true;
    a(2);
    int i5 = getHeight();
    int i6 = i5 / 2;
    float f1 = Math.min(1.0F, 1.0F * Math.abs(i4) / i5);
    float f2 = i6 + i6 * (float)Math.sin((float)(0.47123891676382D * (f1 - 0.5F)));
    int i7 = Math.abs(paramInt3);
    if (i7 > 0);
    for (int i8 = 4 * Math.round(1000.0F * Math.abs(f2 / i7)); ; i8 = (int)(100.0F * (1.0F + Math.abs(i4) / (i5 + this.r))))
    {
      int i9 = Math.min(i8, 600);
      this.p.startScroll(i1, i2, i3, i4, i9);
      invalidate();
      return;
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = paramInt1 + paramInt3;
    if (paramInt2 > 0)
    {
      int i3 = getScrollY();
      int i4 = paramInt2 + paramInt4;
      int i5 = i3 / i4;
      int i6 = (int)((i3 % i4 / i4 + i5) * i1);
      scrollTo(getScrollX(), i6);
      if (!this.p.isFinished())
      {
        int i7 = this.p.getDuration() - this.p.timePassed();
        this.p.startScroll(0, i6, i1 * this.l, 0, i7);
      }
    }
    int i2;
    do
    {
      return;
      i2 = i1 * this.l;
    }
    while (i2 == getScrollY());
    f();
    scrollTo(getScrollX(), i2);
  }

  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }

  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((this.k == null) || (this.k.getCount() <= 0))
    {
      a(false);
      return;
    }
    if ((!paramBoolean2) && (this.l == paramInt1) && (this.j.size() != 0))
    {
      a(false);
      return;
    }
    label57: int i2;
    if (paramInt1 < 0)
    {
      paramInt1 = 0;
      int i1 = this.B;
      if ((paramInt1 > i1 + this.l) || (paramInt1 < this.l - i1))
      {
        i2 = 0;
        label88: if (i2 < this.j.size())
          break label215;
      }
      if (this.l == paramInt1)
        break label237;
    }
    int i4;
    label215: label237: for (int i3 = 1; ; i3 = 0)
    {
      this.l = paramInt1;
      e();
      i4 = paramInt1 * (getHeight() + this.r);
      if (!paramBoolean1)
        break label243;
      a(0, i4, paramInt2);
      if ((i3 != 0) && (this.V != null))
        this.V.onPageSelected(paramInt1);
      if ((i3 == 0) || (this.W == null))
        break;
      this.W.onPageSelected(paramInt1);
      return;
      if (paramInt1 < this.k.getCount())
        break label57;
      paramInt1 = -1 + this.k.getCount();
      break label57;
      ((E)this.j.get(i2)).c = true;
      i2++;
      break label88;
    }
    label243: if ((i3 != 0) && (this.V != null))
      this.V.onPageSelected(paramInt1);
    if ((i3 != 0) && (this.W != null))
      this.W.onPageSelected(paramInt1);
    f();
    scrollTo(0, i4);
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.I)
      if (i1 != 0)
        break label56;
    label56: for (int i2 = 1; ; i2 = 0)
    {
      this.G = MotionEventCompat.getY(paramMotionEvent, i2);
      this.I = MotionEventCompat.getPointerId(paramMotionEvent, i2);
      if (this.K != null)
        this.K.clear();
      return;
    }
  }

  private void a(F paramF)
  {
    this.Z = paramF;
  }

  private void a(boolean paramBoolean)
  {
    if (this.y != paramBoolean)
      this.y = paramBoolean;
  }

  private E b(View paramView)
  {
    while (true)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this)
        return a(paramView);
      if ((localViewParent == null) || (!(localViewParent instanceof View)))
        return null;
      paramView = (View)localViewParent;
    }
  }

  private void b(int paramInt)
  {
    int i1 = getHeight() + this.r;
    int i2 = paramInt / i1;
    int i3 = paramInt % i1;
    float f1 = i3 / i1;
    this.T = false;
    onPageScrolled(i2, f1, i3);
    if (!this.T)
      throw new IllegalStateException("onPageScrolled did not call superclass implementation");
  }

  private void b(int paramInt1, int paramInt2)
  {
    E localE = new E();
    localE.b = paramInt1;
    localE.a = this.k.instantiateItem(this, paramInt1);
    if (paramInt2 < 0)
    {
      this.j.add(localE);
      return;
    }
    this.j.add(paramInt2, localE);
  }

  private void c()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.p = new Scroller(localContext, i);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    this.E = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.L = localViewConfiguration.getScaledMinimumFlingVelocity();
    this.M = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.Q = new EdgeEffectCompat(localContext);
    this.R = new EdgeEffectCompat(localContext);
    this.N = ((int)(25.0F * localContext.getResources().getDisplayMetrics().density));
  }

  private void d()
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= getChildCount())
        return;
      if (!((VerticalViewPager.LayoutParams)getChildAt(i1).getLayoutParams()).isDecor)
      {
        removeViewAt(i1);
        i1--;
      }
    }
  }

  private void e()
  {
    if (this.k == null);
    label7: int i2;
    int i3;
    int i4;
    int i5;
    label71: int i11;
    label117: int i17;
    label135: int i12;
    label144: E localE2;
    label159: Object localObject;
    label183: 
    do
    {
      break label7;
      do
        return;
      while ((this.z) || (getWindowToken() == null));
      this.k.startUpdate(this);
      int i1 = this.B;
      i2 = Math.max(0, this.l - i1);
      i3 = Math.min(-1 + this.k.getCount(), i1 + this.l);
      i4 = 0;
      i5 = -1;
      if (i4 < this.j.size())
        break;
      if (this.j.size() <= 0)
        break label507;
      i11 = ((E)this.j.get(-1 + this.j.size())).b;
      if (i11 < i3)
      {
        i17 = i11 + 1;
        if (i17 <= i2)
          break label513;
        if (i17 <= i3)
          break label519;
      }
      i12 = 0;
      if (i12 < this.j.size())
        break label532;
      localE2 = null;
      PagerAdapter localPagerAdapter = this.k;
      int i13 = this.l;
      if (localE2 == null)
        break label577;
      localObject = localE2.a;
      localPagerAdapter.setPrimaryItem(this, i13, localObject);
      this.k.finishUpdate(this);
    }
    while (!hasFocus());
    View localView1 = findFocus();
    E localE3 = null;
    if (localView1 != null);
    ViewParent localViewParent;
    for (View localView3 = localView1; ; localView3 = (View)localViewParent)
    {
      localViewParent = localView3.getParent();
      if (localViewParent == this)
        localE3 = a(localView3);
      label333: label507: boolean bool;
      label513: label519: label532: label577: 
      do
      {
        do
        {
          int i14 = 0;
          if (localE3 != null)
          {
            int i15 = localE3.b;
            int i16 = this.l;
            i14 = 0;
            if (i15 == i16)
              break;
          }
          while (true)
          {
            if (i14 >= getChildCount())
              break label333;
            View localView2 = getChildAt(i14);
            E localE4 = a(localView2);
            if ((localE4 != null) && (localE4.b == this.l) && (localView2.requestFocus(2)))
              break;
            i14++;
          }
          break label7;
          E localE1 = (E)this.j.get(i4);
          int i6;
          if (((localE1.b < i2) || (localE1.b > i3)) && (!localE1.c))
          {
            this.j.remove(i4);
            int i10 = i4 - 1;
            this.k.destroyItem(this, localE1.b, localE1.a);
            i6 = i10;
            int i7 = localE1.b;
            int i8 = i6 + 1;
            i5 = i7;
            i4 = i8;
            break label71;
          }
          int i9;
          if ((i5 < i3) && (localE1.b > i2))
          {
            i9 = i5 + 1;
            if (i9 < i2)
              i9 = i2;
          }
          while (true)
          {
            if ((i9 > i3) || (i9 >= localE1.b))
            {
              i6 = i4;
              break;
            }
            b(i9, i4);
            i9++;
            i4++;
          }
          i11 = -1;
          break label117;
          i17 = i2;
          break label135;
          b(i17, -1);
          i17++;
          break label135;
          if (((E)this.j.get(i12)).b == this.l)
          {
            localE2 = (E)this.j.get(i12);
            break label159;
          }
          i12++;
          break label144;
          localObject = null;
          break label183;
          localE3 = null;
        }
        while (localViewParent == null);
        bool = localViewParent instanceof View;
        localE3 = null;
      }
      while (!bool);
    }
  }

  private void f()
  {
    boolean bool1 = this.A;
    if (bool1)
    {
      a(false);
      this.p.abortAnimation();
      int i2 = getScrollX();
      int i3 = getScrollY();
      int i4 = this.p.getCurrX();
      int i5 = this.p.getCurrY();
      if ((i2 != i4) || (i3 != i5))
        scrollTo(i4, i5);
      a(0);
    }
    this.z = false;
    this.A = false;
    int i1 = 0;
    boolean bool2 = bool1;
    while (true)
    {
      if (i1 >= this.j.size())
      {
        if (bool2)
          e();
        return;
      }
      E localE = (E)this.j.get(i1);
      if (localE.c)
      {
        bool2 = true;
        localE.c = false;
      }
      i1++;
    }
  }

  private void g()
  {
    this.C = false;
    this.D = false;
    if (this.K != null)
    {
      this.K.recycle();
      this.K = null;
    }
  }

  private boolean h()
  {
    if (this.l > 0)
    {
      setCurrentItem(-1 + this.l, true);
      return true;
    }
    return false;
  }

  private boolean i()
  {
    if ((this.k != null) && (this.l < -1 + this.k.getCount()))
    {
      setCurrentItem(1 + this.l, true);
      return true;
    }
    return false;
  }

  final void a()
  {
    boolean bool1 = true;
    if ((this.j.size() < 3) && (this.j.size() < this.k.getCount()));
    int i1;
    int i2;
    int i3;
    boolean bool3;
    for (boolean bool2 = bool1; ; bool2 = false)
    {
      i1 = 0;
      i2 = 0;
      i3 = -1;
      bool3 = bool2;
      if (i1 < this.j.size())
        break;
      if (i2 != 0)
        this.k.finishUpdate(this);
      Collections.sort(this.j, h);
      if (i3 < 0)
        break label319;
      a(i3, false, bool1);
      label90: if (bool1)
      {
        e();
        requestLayout();
      }
      return;
    }
    E localE = (E)this.j.get(i1);
    int i4 = this.k.getItemPosition(localE.a);
    int i9;
    int i5;
    int i6;
    int i7;
    boolean bool4;
    if (i4 != -1)
      if (i4 == -2)
      {
        this.j.remove(i1);
        i9 = i1 - 1;
        if (i2 == 0)
        {
          this.k.startUpdate(this);
          i2 = bool1;
        }
        this.k.destroyItem(this, localE.b, localE.a);
        if (this.l != localE.b)
          break label343;
        int i10 = Math.max(0, Math.min(this.l, -1 + this.k.getCount()));
        i5 = i9;
        i6 = i2;
        i7 = i10;
        bool4 = bool1;
      }
    while (true)
    {
      int i8 = i5 + 1;
      bool3 = bool4;
      i3 = i7;
      i2 = i6;
      i1 = i8;
      break;
      if (localE.b != i4)
      {
        if (localE.b == this.l)
          i3 = i4;
        localE.b = i4;
        i5 = i1;
        i6 = i2;
        i7 = i3;
        bool4 = bool1;
        continue;
        label319: bool1 = bool3;
        break label90;
      }
      i5 = i1;
      i6 = i2;
      i7 = i3;
      bool4 = bool3;
      continue;
      label343: i5 = i9;
      i6 = i2;
      i7 = i3;
      bool4 = bool1;
    }
  }

  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayList.size();
    int i2 = getDescendantFocusability();
    int i3;
    if (i2 != 393216)
    {
      i3 = 0;
      if (i3 < getChildCount());
    }
    else
    {
      if (((i2 != 262144) || (i1 == paramArrayList.size())) && (isFocusable()))
        break label112;
    }
    label112: 
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null))
    {
      return;
      View localView = getChildAt(i3);
      if (localView.getVisibility() == 0)
      {
        E localE = a(localView);
        if ((localE != null) && (localE.b == this.l))
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
      }
      i3++;
      break;
    }
    paramArrayList.add(this);
  }

  public void addTouchables(ArrayList<View> paramArrayList)
  {
    for (int i1 = 0; ; i1++)
    {
      if (i1 >= getChildCount())
        return;
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        E localE = a(localView);
        if ((localE != null) && (localE.b == this.l))
          localView.addTouchables(paramArrayList);
      }
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams));
    for (ViewGroup.LayoutParams localLayoutParams = generateLayoutParams(paramLayoutParams); ; localLayoutParams = paramLayoutParams)
    {
      VerticalViewPager.LayoutParams localLayoutParams1 = (VerticalViewPager.LayoutParams)localLayoutParams;
      localLayoutParams1.isDecor |= paramView instanceof D;
      if (this.x)
      {
        if ((localLayoutParams1 != null) && (localLayoutParams1.isDecor))
          throw new IllegalStateException("Cannot add pager decor view during layout");
        addViewInLayout(paramView, paramInt, localLayoutParams);
        paramView.measure(this.v, this.w);
        return;
      }
      super.addView(paramView, paramInt, localLayoutParams);
      return;
    }
  }

  public boolean arrowScroll(int paramInt)
  {
    View localView1 = findFocus();
    if (localView1 == this)
      localView1 = null;
    View localView2 = FocusFinder.getInstance().findNextFocus(this, localView1, paramInt);
    boolean bool;
    if ((localView2 != null) && (localView2 != localView1))
      if (paramInt == 33)
        if ((localView1 != null) && (localView2.getTop() >= localView1.getTop()))
          bool = h();
    while (true)
    {
      if (bool)
        playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
      return bool;
      bool = localView2.requestFocus();
      continue;
      if (paramInt == 130)
      {
        if ((localView1 == null) || (localView2.getTop() > localView1.getTop()))
        {
          bool = localView2.requestFocus();
          continue;
          if ((paramInt == 33) || (paramInt == 1))
            bool = h();
          else if ((paramInt != 130) && (paramInt != 2));
        }
        else
        {
          bool = i();
        }
      }
      else
        bool = false;
    }
  }

  public boolean beginFakeDrag()
  {
    if (this.C)
      return false;
    this.O = true;
    a(1);
    this.G = 0.0F;
    this.H = 0.0F;
    if (this.K == null)
      this.K = VelocityTracker.obtain();
    while (true)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.K.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.P = l1;
      return true;
      this.K.clear();
    }
  }

  protected boolean canScroll(View paramView, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    ViewGroup localViewGroup;
    int i1;
    int i2;
    if ((paramView instanceof ViewGroup))
    {
      localViewGroup = (ViewGroup)paramView;
      i1 = paramView.getScrollX();
      i2 = paramView.getScrollY();
    }
    for (int i3 = -1 + localViewGroup.getChildCount(); ; i3--)
    {
      if (i3 < 0)
        if ((!paramBoolean) || (!ViewCompat.canScrollVertically(paramView, -paramInt1)))
          break;
      View localView;
      do
      {
        return true;
        localView = localViewGroup.getChildAt(i3);
      }
      while ((paramInt2 + i1 >= localView.getLeft()) && (paramInt2 + i1 < localView.getRight()) && (paramInt3 + i2 >= localView.getTop()) && (paramInt3 + i2 < localView.getBottom()) && (canScroll(localView, true, paramInt1, paramInt2 + i1 - localView.getLeft(), paramInt3 + i2 - localView.getTop())));
    }
    return false;
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof VerticalViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }

  public void computeScroll()
  {
    if ((!this.p.isFinished()) && (this.p.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.p.getCurrX();
      int i4 = this.p.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        b(i4);
      }
      invalidate();
      return;
    }
    f();
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    int i1 = getChildCount();
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
        return false;
      View localView = getChildAt(i2);
      if (localView.getVisibility() == 0)
      {
        E localE = a(localView);
        if ((localE != null) && (localE.b == this.l) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
          return true;
      }
    }
  }

  public void draw(Canvas paramCanvas)
  {
    int i1 = 1;
    super.draw(paramCanvas);
    int i2 = ViewCompat.getOverScrollMode(this);
    boolean bool2;
    if ((i2 == 0) || ((i2 == i1) && (this.k != null) && (this.k.getCount() > i1)))
    {
      boolean bool1 = this.Q.isFinished();
      bool2 = false;
      if (!bool1)
      {
        int i6 = paramCanvas.save();
        int i7 = getWidth() - getPaddingLeft() - getPaddingRight();
        paramCanvas.rotate(0.0F);
        this.Q.setSize(i7, getHeight());
        bool2 = false | this.Q.draw(paramCanvas);
        paramCanvas.restoreToCount(i6);
      }
      if (!this.R.isFinished())
      {
        int i3 = paramCanvas.save();
        int i4 = getWidth() - getPaddingLeft() - getPaddingRight();
        int i5 = getHeight();
        if (this.k != null)
          i1 = this.k.getCount();
        paramCanvas.rotate(180.0F);
        paramCanvas.translate(-i4 + getPaddingLeft(), -i1 * (i5 + this.r) + this.r);
        this.R.setSize(i4, i5);
        bool2 |= this.R.draw(paramCanvas);
        paramCanvas.restoreToCount(i3);
      }
    }
    while (true)
    {
      if (bool2)
        invalidate();
      return;
      this.Q.finish();
      this.R.finish();
      bool2 = false;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.s;
    if ((localDrawable != null) && (localDrawable.isStateful()))
      localDrawable.setState(getDrawableState());
  }

  public void endFakeDrag()
  {
    if (!this.O)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    VelocityTracker localVelocityTracker = this.K;
    localVelocityTracker.computeCurrentVelocity(1000, this.M);
    int i1 = (int)VelocityTrackerCompat.getXVelocity(localVelocityTracker, this.I);
    this.z = true;
    int i2 = (int)(this.G - this.H);
    int i3 = getScrollY();
    int i4 = getHeight() + this.r;
    a(a(i3 / i4, i3 % i4 / i4, i1, i2), true, true, i1);
    g();
    this.O = false;
  }

  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
      switch (paramKeyEvent.getKeyCode())
      {
      default:
      case 19:
      case 20:
      case 61:
      }
    do
    {
      do
      {
        return false;
        return arrowScroll(33);
        return arrowScroll(130);
      }
      while (Build.VERSION.SDK_INT < 11);
      if (KeyEventCompat.hasNoModifiers(paramKeyEvent))
        return arrowScroll(2);
    }
    while (!KeyEventCompat.hasModifiers(paramKeyEvent, 1));
    return arrowScroll(1);
  }

  public void fakeDragBy(float paramFloat)
  {
    if (!this.O)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    this.G = (paramFloat + this.G);
    float f1 = getScrollY() - paramFloat;
    int i1 = getHeight() + this.r;
    float f2 = Math.max(0, i1 * (-1 + this.l));
    float f3 = i1 * Math.min(1 + this.l, -1 + this.k.getCount());
    if (f1 < f2);
    while (true)
    {
      this.G += f2 - (int)f2;
      scrollTo(getScrollX(), (int)f2);
      b((int)f2);
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(this.P, l1, 2, 0.0F, this.G, 0);
      this.K.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      return;
      if (f1 > f3)
        f2 = f3;
      else
        f2 = f1;
    }
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new VerticalViewPager.LayoutParams();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new VerticalViewPager.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }

  public PagerAdapter getAdapter()
  {
    return this.k;
  }

  public int getCurrentItem()
  {
    return this.l;
  }

  public int getOffscreenPageLimit()
  {
    return this.B;
  }

  public int getPageMargin()
  {
    return this.r;
  }

  public boolean isFakeDragging()
  {
    return this.O;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.S = true;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.r > 0) && (this.s != null))
    {
      int i1 = getScrollY();
      int i2 = getHeight();
      int i3 = i1 % (i2 + this.r);
      if (i3 != 0)
      {
        int i4 = i2 + (i1 - i3);
        this.s.setBounds(this.t, i4, this.u, i4 + this.r);
        this.s.draw(paramCanvas);
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 0xFF & paramMotionEvent.getAction();
    if ((i1 == 3) || (i1 == 1))
    {
      this.C = false;
      this.D = false;
      this.I = -1;
      if (this.K != null)
      {
        this.K.recycle();
        this.K = null;
      }
    }
    do
    {
      return false;
      if (i1 == 0)
        break;
      if (this.C)
        return true;
    }
    while (this.D);
    switch (i1)
    {
    default:
    case 2:
    case 0:
    case 6:
    }
    while (true)
    {
      if (!this.C)
      {
        if (this.K == null)
          this.K = VelocityTracker.obtain();
        this.K.addMovement(paramMotionEvent);
      }
      return this.C;
      int i2 = this.I;
      if (i2 != -1)
      {
        int i3 = MotionEventCompat.findPointerIndex(paramMotionEvent, i2);
        float f2 = MotionEventCompat.getX(paramMotionEvent, i3);
        float f3 = Math.abs(f2 - this.F);
        float f4 = MotionEventCompat.getY(paramMotionEvent, i3);
        float f5 = f4 - this.G;
        float f6 = Math.abs(f5);
        if (canScroll(this, false, (int)f5, (int)f2, (int)f4))
        {
          this.G = f4;
          this.H = f4;
          this.F = f2;
          return false;
        }
        if ((f6 > this.E) && (f6 > f3))
        {
          this.C = true;
          a(1);
          this.G = f4;
          a(true);
        }
        else if (f3 > this.E)
        {
          this.D = true;
          continue;
          this.F = paramMotionEvent.getX();
          float f1 = paramMotionEvent.getY();
          this.H = f1;
          this.G = f1;
          this.I = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          if (this.aa == 2)
          {
            this.C = true;
            this.D = false;
            a(1);
          }
          else
          {
            f();
            this.C = false;
            this.D = false;
            continue;
            a(paramMotionEvent);
          }
        }
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.x = true;
    e();
    this.x = false;
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    int i4 = getPaddingLeft();
    int i5 = getPaddingTop();
    int i6 = getPaddingRight();
    int i7 = getPaddingBottom();
    int i8 = getScrollY();
    int i9 = 0;
    int i10 = 0;
    if (i10 >= i1)
    {
      this.t = i4;
      this.u = (i2 - i6);
      this.U = i9;
      this.S = false;
      return;
    }
    View localView = getChildAt(i10);
    int i19;
    label200: int i20;
    int i22;
    int i23;
    label252: int i11;
    int i12;
    int i13;
    if (localView.getVisibility() != 8)
    {
      VerticalViewPager.LayoutParams localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
      if (localLayoutParams.isDecor)
      {
        int i16 = 0x7 & localLayoutParams.gravity;
        int i17 = 0x70 & localLayoutParams.gravity;
        switch (i16)
        {
        case 2:
        case 4:
        default:
          i19 = i4;
          switch (i17)
          {
          default:
            i20 = i5;
            int i28 = i7;
            i22 = i5;
            i23 = i28;
            int i24 = i20 + i8;
            i11 = i9 + 1;
            localView.layout(i19, i24, i19 + localView.getMeasuredWidth(), i24 + localView.getMeasuredHeight());
            i12 = i22;
            i7 = i23;
            i13 = i6;
          case 48:
          case 16:
          case 80:
          }
          break;
        case 3:
        case 1:
        case 5:
        }
      }
    }
    for (int i14 = i4; ; i14 = i4)
    {
      i10++;
      i4 = i14;
      i6 = i13;
      i5 = i12;
      i9 = i11;
      break;
      int i29 = i4 + localView.getMeasuredWidth();
      i19 = i4;
      i4 = i29;
      break label200;
      i19 = Math.max((i2 - localView.getMeasuredWidth()) / 2, i4);
      break label200;
      int i18 = i2 - i6 - localView.getMeasuredWidth();
      i6 += localView.getMeasuredWidth();
      i19 = i18;
      break label200;
      int i26 = i5 + localView.getMeasuredHeight();
      int i27 = i5;
      i23 = i7;
      i22 = i26;
      i20 = i27;
      break label252;
      i20 = Math.max((i3 - localView.getMeasuredHeight()) / 2, i5);
      int i25 = i7;
      i22 = i5;
      i23 = i25;
      break label252;
      i20 = i3 - i7 - localView.getMeasuredHeight();
      int i21 = i7 + localView.getMeasuredHeight();
      i22 = i5;
      i23 = i21;
      break label252;
      E localE = a(localView);
      if (localE != null)
      {
        int i15 = i5 + (i3 + this.r) * localE.b;
        localView.layout(i4, i15, i4 + localView.getMeasuredWidth(), i15 + localView.getMeasuredHeight());
      }
      i11 = i9;
      i12 = i5;
      i13 = i6;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    int i1 = getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
    int i2 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i3 = getChildCount();
    int i4 = 0;
    int i14;
    label107: View localView1;
    int i10;
    int i11;
    label251: int i12;
    label266: label276: int i5;
    int i6;
    if (i4 >= i3)
    {
      this.v = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
      this.w = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
      this.x = true;
      e();
      this.x = false;
      int i13 = getChildCount();
      i14 = 0;
      if (i14 < i13);
    }
    else
    {
      localView1 = getChildAt(i4);
      if (localView1.getVisibility() == 8)
        break label431;
      VerticalViewPager.LayoutParams localLayoutParams1 = (VerticalViewPager.LayoutParams)localView1.getLayoutParams();
      if ((localLayoutParams1 == null) || (!localLayoutParams1.isDecor))
        break label431;
      int i7 = 0x7 & localLayoutParams1.gravity;
      int i8 = 0x70 & localLayoutParams1.gravity;
      Debug.i("VerticalViewPager", "gravity: " + localLayoutParams1.gravity + " hgrav: " + i7 + " vgrav: " + i8);
      int i9 = -2147483648;
      i10 = -2147483648;
      if ((i8 != 48) && (i8 != 80))
      {
        i11 = 0;
        if ((i7 == 3) || (i7 == 5))
          break label331;
        i12 = 0;
        if (i11 == 0)
          break label337;
        i9 = 1073741824;
        localView1.measure(View.MeasureSpec.makeMeasureSpec(i1, i9), View.MeasureSpec.makeMeasureSpec(i2, i10));
        if (i11 == 0)
          break label350;
        i5 = i2 - localView1.getMeasuredHeight();
        i6 = i1;
      }
    }
    while (true)
    {
      i4++;
      i1 = i6;
      i2 = i5;
      break;
      i11 = 1;
      break label251;
      label331: i12 = 1;
      break label266;
      label337: if (i12 == 0)
        break label276;
      i10 = 1073741824;
      break label276;
      label350: if (i12 != 0)
      {
        i6 = i1 - localView1.getMeasuredWidth();
        i5 = i2;
        continue;
        View localView2 = getChildAt(i14);
        if (localView2.getVisibility() != 8)
        {
          VerticalViewPager.LayoutParams localLayoutParams2 = (VerticalViewPager.LayoutParams)localView2.getLayoutParams();
          if ((localLayoutParams2 == null) || (!localLayoutParams2.isDecor))
            localView2.measure(this.v, this.w);
        }
        i14++;
        break label107;
      }
      label431: i5 = i2;
      i6 = i1;
    }
  }

  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i1;
    int i2;
    int i3;
    int i4;
    int i6;
    if (this.U > 0)
    {
      i1 = getScrollY();
      i2 = getPaddingTop();
      i3 = getPaddingBottom();
      i4 = getHeight();
      int i5 = getChildCount();
      i6 = 0;
      if (i6 < i5);
    }
    else
    {
      if (this.V != null)
        this.V.onPageScrolled(paramInt1, paramFloat, paramInt2);
      if (this.W != null)
        this.W.onPageScrolled(paramInt1, paramFloat, paramInt2);
      this.T = true;
      return;
    }
    View localView = getChildAt(i6);
    VerticalViewPager.LayoutParams localLayoutParams = (VerticalViewPager.LayoutParams)localView.getLayoutParams();
    int i11;
    int i8;
    int i9;
    if (localLayoutParams.isDecor)
      switch (0x70 & localLayoutParams.gravity)
      {
      default:
        i11 = i2;
        int i17 = i3;
        i8 = i2;
        i9 = i17;
        label176: int i13 = i11 + i1 - localView.getTop();
        if (i13 != 0)
          localView.offsetTopAndBottom(i13);
        break;
      case 48:
      case 1:
      case 80:
      }
    while (true)
    {
      i6++;
      int i10 = i9;
      i2 = i8;
      i3 = i10;
      break;
      int i15 = i2 + localView.getHeight();
      int i16 = i2;
      i9 = i3;
      i8 = i15;
      i11 = i16;
      break label176;
      i11 = Math.max((i4 - localView.getMeasuredHeight()) / 2, i2);
      int i14 = i3;
      i8 = i2;
      i9 = i14;
      break label176;
      i11 = i4 - i3 - localView.getMeasuredHeight();
      int i12 = i3 + localView.getMeasuredHeight();
      i8 = i2;
      i9 = i12;
      break label176;
      int i7 = i3;
      i8 = i2;
      i9 = i7;
    }
  }

  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = 1;
    int i2 = -1;
    int i3 = getChildCount();
    int i4;
    if ((paramInt & 0x2) != 0)
    {
      i2 = i1;
      i4 = 0;
    }
    while (true)
    {
      if (i4 == i3)
        i1 = 0;
      View localView;
      E localE;
      do
      {
        return i1;
        i4 = i3 - 1;
        i3 = i2;
        break;
        localView = getChildAt(i4);
        if (localView.getVisibility() != 0)
          break label98;
        localE = a(localView);
      }
      while ((localE != null) && (localE.b == this.l) && (localView.requestFocus(paramInt, paramRect)));
      label98: i4 += i2;
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof VerticalViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    VerticalViewPager.SavedState localSavedState = (VerticalViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.k != null)
    {
      this.k.restoreState(localSavedState.b, localSavedState.c);
      a(localSavedState.a, false, true);
      return;
    }
    this.m = localSavedState.a;
    this.n = localSavedState.b;
    this.o = localSavedState.c;
  }

  public Parcelable onSaveInstanceState()
  {
    VerticalViewPager.SavedState localSavedState = new VerticalViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.l;
    if (this.k != null)
      localSavedState.b = this.k.saveState();
    return localSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt2 != paramInt4)
      a(paramInt2, paramInt4, this.r, this.r);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    if (this.O)
      bool1 = true;
    int i1;
    do
    {
      PagerAdapter localPagerAdapter;
      do
      {
        int i11;
        do
        {
          return bool1;
          if (paramMotionEvent.getAction() != 0)
            break;
          i11 = paramMotionEvent.getEdgeFlags();
          bool1 = false;
        }
        while (i11 != 0);
        localPagerAdapter = this.k;
        bool1 = false;
      }
      while (localPagerAdapter == null);
      i1 = this.k.getCount();
      bool1 = false;
    }
    while (i1 == 0);
    if (this.K == null)
      this.K = VelocityTracker.obtain();
    this.K.addMovement(paramMotionEvent);
    int i2 = 0xFF & paramMotionEvent.getAction();
    boolean bool2 = false;
    float f3;
    int i7;
    int i8;
    int i9;
    float f5;
    boolean bool6;
    float f6;
    switch (i2)
    {
    case 4:
    default:
    case 0:
    case 2:
      boolean bool5;
      do
      {
        while (true)
        {
          if (bool2)
            invalidate();
          return true;
          f();
          float f12 = paramMotionEvent.getY();
          this.H = f12;
          this.G = f12;
          this.I = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          bool2 = false;
        }
        if (!this.C)
        {
          int i10 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.I);
          float f9 = Math.abs(MotionEventCompat.getX(paramMotionEvent, i10) - this.F);
          float f10 = MotionEventCompat.getY(paramMotionEvent, i10);
          float f11 = Math.abs(f10 - this.G);
          if ((f11 > this.E) && (f11 > f9))
          {
            this.C = true;
            this.G = f10;
            a(1);
            a(true);
          }
        }
        bool5 = this.C;
        bool2 = false;
      }
      while (!bool5);
      float f1 = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.I));
      float f2 = this.G - f1;
      this.G = f1;
      f3 = f2 + getScrollY();
      i7 = getHeight();
      i8 = i7 + this.r;
      i9 = -1 + this.k.getCount();
      float f4 = Math.max(0, i8 * (-1 + this.l));
      f5 = i8 * Math.min(1 + this.l, i9);
      if (f3 < f4)
      {
        boolean bool9 = f4 < 0.0F;
        boolean bool10 = false;
        if (!bool9)
        {
          float f8 = -f3;
          bool10 = this.Q.onPull(f8 / i7);
        }
        bool6 = bool10;
        f6 = f4;
      }
      break;
    case 1:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      this.G += f6 - (int)f6;
      scrollTo(getScrollX(), (int)f6);
      b((int)f6);
      bool2 = bool6;
      break;
      if (f3 > f5)
      {
        boolean bool7 = f5 < i9 * i8;
        boolean bool8 = false;
        if (!bool7)
        {
          float f7 = f3 - f5;
          bool8 = this.R.onPull(f7 / i7);
        }
        bool6 = bool8;
        f6 = f5;
        continue;
        boolean bool4 = this.C;
        bool2 = false;
        if (!bool4)
          break;
        VelocityTracker localVelocityTracker = this.K;
        localVelocityTracker.computeCurrentVelocity(1000, this.M);
        int i4 = (int)VelocityTrackerCompat.getYVelocity(localVelocityTracker, this.I);
        this.z = true;
        int i5 = getHeight() + this.r;
        int i6 = getScrollY();
        a(a(i6 / i5, i6 % i5 / i5, i4, (int)(MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.I)) - this.H)), true, true, i4);
        this.I = -1;
        g();
        bool2 = this.Q.onRelease() | this.R.onRelease();
        break;
        boolean bool3 = this.C;
        bool2 = false;
        if (!bool3)
          break;
        a(this.l, true, true);
        this.I = -1;
        g();
        bool2 = this.Q.onRelease() | this.R.onRelease();
        break;
        int i3 = MotionEventCompat.getActionIndex(paramMotionEvent);
        this.G = MotionEventCompat.getY(paramMotionEvent, i3);
        this.I = MotionEventCompat.getPointerId(paramMotionEvent, i3);
        bool2 = false;
        break;
        a(paramMotionEvent);
        this.G = MotionEventCompat.getY(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.I));
        bool2 = false;
        break;
      }
      f6 = f3;
      bool6 = false;
    }
  }

  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    int i1;
    int i2;
    label59: PagerAdapter localPagerAdapter;
    if (this.k != null)
    {
      this.k.unregisterDataSetObserver(this.q);
      this.k.startUpdate(this);
      i1 = 0;
      if (i1 >= this.j.size())
      {
        this.k.finishUpdate(this);
        this.j.clear();
        i2 = 0;
        if (i2 < getChildCount())
          break label235;
        this.l = 0;
        scrollTo(0, 0);
      }
    }
    else
    {
      localPagerAdapter = this.k;
      this.k = paramPagerAdapter;
      if (this.k != null)
      {
        if (this.q == null)
          this.q = new G(this, (byte)0);
        this.k.registerDataSetObserver(this.q);
        this.z = false;
        if (this.m < 0)
          break label268;
        this.k.restoreState(this.n, this.o);
        a(this.m, false, true);
        this.m = -1;
        this.n = null;
        this.o = null;
      }
    }
    while (true)
    {
      if ((this.Z != null) && (localPagerAdapter != paramPagerAdapter));
      return;
      E localE = (E)this.j.get(i1);
      this.k.destroyItem(this, localE.b, localE.a);
      i1++;
      break;
      label235: if (!((VerticalViewPager.LayoutParams)getChildAt(i2).getLayoutParams()).isDecor)
      {
        removeViewAt(i2);
        i2--;
      }
      i2++;
      break label59;
      label268: e();
    }
  }

  public void setCurrentItem(int paramInt)
  {
    this.z = false;
    if (this.S);
    for (boolean bool = false; ; bool = true)
    {
      a(paramInt, bool, false);
      return;
    }
  }

  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.z = false;
    a(paramInt, paramBoolean, false);
  }

  public void setOffscreenPageLimit(int paramInt)
  {
    if (paramInt <= 0)
    {
      Debug.w("VerticalViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to 1");
      paramInt = 1;
    }
    if (paramInt != this.B)
    {
      this.B = paramInt;
      e();
    }
  }

  public void setOnPageChangeListener(VerticalViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.V = paramOnPageChangeListener;
  }

  public void setPageMargin(int paramInt)
  {
    int i1 = this.r;
    this.r = paramInt;
    int i2 = getHeight();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }

  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }

  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.s = paramDrawable;
    if (paramDrawable != null)
      refreshDrawableState();
    if (paramDrawable == null);
    for (boolean bool = true; ; bool = false)
    {
      setWillNotDraw(bool);
      invalidate();
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.s);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.VerticalViewPager
 * JD-Core Version:    0.6.2
 */