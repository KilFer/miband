package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.widget.EdgeEffectCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
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
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ViewPager extends ViewGroup
{
  public static final int SCROLL_STATE_DRAGGING = 1;
  public static final int SCROLL_STATE_IDLE = 0;
  public static final int SCROLL_STATE_SETTLING = 2;
  private static final int T = -1;
  private static final String a = "ViewPager";
  private static final int ab = 2;
  private static final int ap = 0;
  private static final int aq = 1;
  private static final int ar = 2;
  private static final aH au = new aH();
  private static final boolean b = false;
  private static final boolean c = false;
  private static final int d = 1;
  private static final int e = 600;
  private static final int f = 25;
  private static final int g = 16;
  private static final int h = 400;
  private static final int[] i = { 16842931 };
  private static final Comparator<aC> k = new ay();
  private static final Interpolator l = new az();
  private float A = -3.402824E+038F;
  private float B = 3.4028235E+38F;
  private int C;
  private int D;
  private boolean E;
  private boolean F;
  private boolean G;
  private int H = 1;
  private boolean I;
  private boolean J;
  private boolean K;
  private int L;
  private int M;
  private int N;
  private float O;
  private float P;
  private float Q;
  private float R;
  private int S = -1;
  private VelocityTracker U;
  private int V;
  private int W;
  private int Z;
  private int aa;
  private boolean ac;
  private long ad;
  private EdgeEffectCompat ae;
  private EdgeEffectCompat af;
  private boolean ag = true;
  private boolean ah;
  private boolean ai;
  private int aj;
  private ViewPager.OnPageChangeListener ak;
  private ViewPager.OnPageChangeListener al;
  private aE am;
  private ViewPager.PageTransformer an;
  private Method ao;
  private int as;
  private ArrayList<View> at;
  private final Runnable av = new aA(this);
  private int aw = 0;
  private int j;
  private final ArrayList<aC> m = new ArrayList();
  private final aC n = new aC();
  private final Rect o = new Rect();
  private PagerAdapter p;
  private int q;
  private int r = -1;
  private Parcelable s = null;
  private ClassLoader t = null;
  private Scroller u;
  private aF v;
  private int w;
  private Drawable x;
  private int y;
  private int z;

  public ViewPager(Context paramContext)
  {
    super(paramContext);
    d();
  }

  public ViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    d();
  }

  private static float a(float paramFloat)
  {
    return (float)Math.sin((float)(0.47123891676382D * (paramFloat - 0.5F)));
  }

  private int a(int paramInt1, float paramFloat, int paramInt2, int paramInt3)
  {
    if ((Math.abs(paramInt3) > this.Z) && (Math.abs(paramInt2) > this.V))
    {
      if (paramInt2 > 0);
      while (true)
      {
        if (this.m.size() > 0)
        {
          aC localaC1 = (aC)this.m.get(0);
          aC localaC2 = (aC)this.m.get(-1 + this.m.size());
          paramInt1 = Math.max(localaC1.b, Math.min(paramInt1, localaC2.b));
        }
        return paramInt1;
        paramInt1++;
      }
    }
    if (paramInt1 >= this.q);
    for (float f1 = 0.4F; ; f1 = 0.6F)
    {
      paramInt1 = (int)(f1 + (paramFloat + paramInt1));
      break;
    }
  }

  private Rect a(Rect paramRect, View paramView)
  {
    if (paramRect == null);
    for (Rect localRect = new Rect(); ; localRect = paramRect)
    {
      if (paramView == null)
      {
        localRect.set(0, 0, 0, 0);
        return localRect;
      }
      localRect.left = paramView.getLeft();
      localRect.right = paramView.getRight();
      localRect.top = paramView.getTop();
      localRect.bottom = paramView.getBottom();
      ViewGroup localViewGroup;
      for (ViewParent localViewParent = paramView.getParent(); ((localViewParent instanceof ViewGroup)) && (localViewParent != this); localViewParent = localViewGroup.getParent())
      {
        localViewGroup = (ViewGroup)localViewParent;
        localRect.left += localViewGroup.getLeft();
        localRect.right += localViewGroup.getRight();
        localRect.top += localViewGroup.getTop();
        localRect.bottom += localViewGroup.getBottom();
      }
      return localRect;
    }
  }

  private aC a(View paramView)
  {
    for (int i1 = 0; i1 < this.m.size(); i1++)
    {
      aC localaC = (aC)this.m.get(i1);
      if (this.p.isViewFromObject(paramView, localaC.a))
        return localaC;
    }
    return null;
  }

  private void a(int paramInt)
  {
    if (this.aw == paramInt);
    label35: label71: 
    do
    {
      return;
      this.aw = paramInt;
      if (this.an != null)
      {
        int i1;
        int i3;
        if (paramInt != 0)
        {
          i1 = 1;
          int i2 = getChildCount();
          i3 = 0;
          if (i3 >= i2)
            continue;
          if (i1 == 0)
            break label71;
        }
        for (int i4 = 2; ; i4 = 0)
        {
          ViewCompat.setLayerType(getChildAt(i3), i4, null);
          i3++;
          break label35;
          i1 = 0;
          break;
        }
      }
    }
    while (this.ak == null);
    this.ak.onPageScrollStateChanged(paramInt);
  }

  private void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, 0);
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getChildCount() == 0)
    {
      d(false);
      return;
    }
    int i1 = getScrollX();
    int i2 = getScrollY();
    int i3 = paramInt1 - i1;
    int i4 = paramInt2 - i2;
    if ((i3 == 0) && (i4 == 0))
    {
      b(false);
      b();
      a(0);
      return;
    }
    d(true);
    a(2);
    int i5 = f();
    int i6 = i5 / 2;
    float f1 = Math.min(1.0F, 1.0F * Math.abs(i3) / i5);
    float f2 = i6 + i6 * (float)Math.sin((float)(0.47123891676382D * (f1 - 0.5F)));
    int i7 = Math.abs(paramInt3);
    if (i7 > 0);
    float f3;
    for (int i8 = 4 * Math.round(1000.0F * Math.abs(f2 / i7)); ; i8 = (int)(100.0F * (1.0F + Math.abs(i3) / (f3 + this.w))))
    {
      int i9 = Math.min(i8, 600);
      this.u.startScroll(i1, i2, i3, i4, i9);
      ViewCompat.postInvalidateOnAnimation(this);
      return;
      f3 = i5 * this.p.getPageWidth(this.q);
    }
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 > 0) && (!this.m.isEmpty()))
    {
      int i2 = paramInt3 + (paramInt1 - getPaddingLeft() - getPaddingRight());
      int i3 = paramInt4 + (paramInt2 - getPaddingLeft() - getPaddingRight());
      int i4 = (int)(getScrollX() / i3 * i2);
      scrollTo(i4, getScrollY());
      if (!this.u.isFinished())
      {
        int i5 = this.u.getDuration() - this.u.timePassed();
        aC localaC2 = c(this.q);
        this.u.startScroll(i4, 0, (int)(localaC2.e * paramInt1), 0, i5);
      }
      return;
    }
    aC localaC1 = c(this.q);
    if (localaC1 != null);
    for (float f1 = Math.min(localaC1.e, this.B); ; f1 = 0.0F)
    {
      int i1 = (int)(f1 * (paramInt1 - getPaddingLeft() - getPaddingRight()));
      if (i1 == getScrollX())
        break;
      b(false);
      scrollTo(i1, getScrollY());
      return;
    }
  }

  private void a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    aC localaC = c(paramInt1);
    if (localaC != null);
    for (int i1 = (int)(f() * Math.max(this.A, Math.min(localaC.e, this.B))); ; i1 = 0)
    {
      if (paramBoolean1)
      {
        a(i1, 0, paramInt2);
        if ((paramBoolean2) && (this.ak != null))
          this.ak.onPageSelected(paramInt1);
        if ((paramBoolean2) && (this.al != null))
          this.al.onPageSelected(paramInt1);
        return;
      }
      if ((paramBoolean2) && (this.ak != null))
        this.ak.onPageSelected(paramInt1);
      if ((paramBoolean2) && (this.al != null))
        this.al.onPageSelected(paramInt1);
      b(false);
      scrollTo(i1, 0);
      d(i1);
      return;
    }
  }

  private void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramInt, paramBoolean1, paramBoolean2, 0);
  }

  private void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    if ((this.p == null) || (this.p.getCount() <= 0))
    {
      d(false);
      return;
    }
    if ((!paramBoolean2) && (this.q == paramInt1) && (this.m.size() != 0))
    {
      d(false);
      return;
    }
    if (paramInt1 < 0)
      paramInt1 = 0;
    while (true)
    {
      int i1 = this.H;
      if ((paramInt1 <= i1 + this.q) && (paramInt1 >= this.q - i1))
        break;
      for (int i2 = 0; i2 < this.m.size(); i2++)
        ((aC)this.m.get(i2)).c = true;
      if (paramInt1 >= this.p.getCount())
        paramInt1 = -1 + this.p.getCount();
    }
    int i3 = this.q;
    boolean bool = false;
    if (i3 != paramInt1)
      bool = true;
    if (this.ag)
    {
      this.q = paramInt1;
      if ((bool) && (this.ak != null))
        this.ak.onPageSelected(paramInt1);
      if ((bool) && (this.al != null))
        this.al.onPageSelected(paramInt1);
      requestLayout();
      return;
    }
    b(paramInt1);
    a(paramInt1, paramBoolean1, paramInt2, bool);
  }

  private void a(aC paramaC1, int paramInt, aC paramaC2)
  {
    int i1 = this.p.getCount();
    int i2 = f();
    float f1;
    int i12;
    int i15;
    float f9;
    if (i2 > 0)
    {
      f1 = this.w / i2;
      if (paramaC2 == null)
        break label371;
      i12 = paramaC2.b;
      if (i12 < paramaC1.b)
      {
        i15 = 0;
        f9 = f1 + (paramaC2.e + paramaC2.d);
      }
    }
    else
    {
      for (int i16 = i12 + 1; ; i16++)
      {
        if ((i16 > paramaC1.b) || (i15 >= this.m.size()))
          break label371;
        aC localaC4 = (aC)this.m.get(i15);
        while (true)
          if ((i16 > localaC4.b) && (i15 < -1 + this.m.size()))
          {
            i15++;
            localaC4 = (aC)this.m.get(i15);
            continue;
            f1 = 0.0F;
            break;
          }
        while (i16 < localaC4.b)
        {
          f9 += f1 + this.p.getPageWidth(i16);
          i16++;
        }
        localaC4.e = f9;
        f9 += f1 + localaC4.d;
      }
    }
    if (i12 > paramaC1.b)
    {
      int i13 = -1 + this.m.size();
      float f8 = paramaC2.e;
      for (int i14 = i12 - 1; (i14 >= paramaC1.b) && (i13 >= 0); i14--)
      {
        for (aC localaC3 = (aC)this.m.get(i13); (i14 < localaC3.b) && (i13 > 0); localaC3 = (aC)this.m.get(i13))
          i13--;
        while (i14 > localaC3.b)
        {
          f8 -= f1 + this.p.getPageWidth(i14);
          i14--;
        }
        f8 -= f1 + localaC3.d;
        localaC3.e = f8;
      }
    }
    label371: int i3 = this.m.size();
    float f2 = paramaC1.e;
    int i4 = -1 + paramaC1.b;
    float f3;
    float f4;
    if (paramaC1.b == 0)
    {
      f3 = paramaC1.e;
      this.A = f3;
      if (paramaC1.b != i1 - 1)
        break label522;
      f4 = paramaC1.e + paramaC1.d - 1.0F;
      label437: this.B = f4;
    }
    label522: int i10;
    for (int i5 = paramInt - 1; ; i5 = i10)
    {
      if (i5 < 0)
        break label579;
      aC localaC2 = (aC)this.m.get(i5);
      float f7 = f2;
      while (true)
        if (i4 > localaC2.b)
        {
          PagerAdapter localPagerAdapter2 = this.p;
          int i11 = i4 - 1;
          f7 -= f1 + localPagerAdapter2.getPageWidth(i4);
          i4 = i11;
          continue;
          f3 = -3.402824E+038F;
          break;
          f4 = 3.4028235E+38F;
          break label437;
        }
      f2 = f7 - (f1 + localaC2.d);
      localaC2.e = f2;
      if (localaC2.b == 0)
        this.A = f2;
      i10 = i5 - 1;
      i4--;
    }
    label579: float f5 = f1 + (paramaC1.e + paramaC1.d);
    int i6 = 1 + paramaC1.b;
    int i8;
    for (int i7 = paramInt + 1; i7 < i3; i7 = i8)
    {
      aC localaC1 = (aC)this.m.get(i7);
      float f6 = f5;
      while (i6 < localaC1.b)
      {
        PagerAdapter localPagerAdapter1 = this.p;
        int i9 = i6 + 1;
        f6 += f1 + localPagerAdapter1.getPageWidth(i6);
        i6 = i9;
      }
      if (localaC1.b == i1 - 1)
        this.B = (f6 + localaC1.d - 1.0F);
      localaC1.e = f6;
      f5 = f6 + (f1 + localaC1.d);
      i8 = i7 + 1;
      i6++;
    }
  }

  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.S)
      if (i1 != 0)
        break label56;
    label56: for (int i2 = 1; ; i2 = 0)
    {
      this.O = MotionEventCompat.getX(paramMotionEvent, i2);
      this.S = MotionEventCompat.getPointerId(paramMotionEvent, i2);
      if (this.U != null)
        this.U.clear();
      return;
    }
  }

  private void a(boolean paramBoolean)
  {
    if ((Build.VERSION.SDK_INT < 7) || (this.ao == null));
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      this.ao = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", arrayOfClass);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      try
      {
        while (true)
        {
          Method localMethod = this.ao;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Boolean.valueOf(paramBoolean);
          localMethod.invoke(this, arrayOfObject);
          return;
          localNoSuchMethodException = localNoSuchMethodException;
          Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
        }
      }
      catch (Exception localException)
      {
        Log.e("ViewPager", "Error changing children drawing order", localException);
      }
    }
  }

  private boolean a(float paramFloat1, float paramFloat2)
  {
    return ((paramFloat1 < this.M) && (paramFloat2 > 0.0F)) || ((paramFloat1 > getWidth() - this.M) && (paramFloat2 < 0.0F));
  }

  private aC b(int paramInt1, int paramInt2)
  {
    aC localaC = new aC();
    localaC.b = paramInt1;
    localaC.a = this.p.instantiateItem(this, paramInt1);
    localaC.d = this.p.getPageWidth(paramInt1);
    if ((paramInt2 < 0) || (paramInt2 >= this.m.size()))
    {
      this.m.add(localaC);
      return localaC;
    }
    this.m.add(paramInt2, localaC);
    return localaC;
  }

  private aC b(View paramView)
  {
    while (true)
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent == this)
        break;
      if ((localViewParent == null) || (!(localViewParent instanceof View)))
        return null;
      paramView = (View)localViewParent;
    }
    return a(paramView);
  }

  private void b(int paramInt)
  {
    int i21;
    aC localaC1;
    int i1;
    if (this.q != paramInt)
      if (this.q < paramInt)
      {
        i21 = 66;
        aC localaC14 = c(this.q);
        this.q = paramInt;
        localaC1 = localaC14;
        i1 = i21;
      }
    while (true)
    {
      if (this.p == null)
        g();
      do
      {
        return;
        i21 = 17;
        break;
        if (this.G)
        {
          g();
          return;
        }
      }
      while (getWindowToken() == null);
      this.p.startUpdate(this);
      int i2 = this.H;
      int i3 = Math.max(0, this.q - i2);
      int i4 = this.p.getCount();
      int i5 = Math.min(i4 - 1, i2 + this.q);
      if (i4 != this.j)
        try
        {
          String str2 = getResources().getResourceName(getId());
          str1 = str2;
          throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.j + ", found: " + i4 + " Pager id: " + str1 + " Pager class: " + getClass() + " Problematic adapter: " + this.p.getClass());
        }
        catch (Resources.NotFoundException localNotFoundException)
        {
          while (true)
            String str1 = Integer.toHexString(getId());
        }
      int i6 = 0;
      aC localaC2;
      if (i6 < this.m.size())
      {
        localaC2 = (aC)this.m.get(i6);
        if (localaC2.b >= this.q)
          if (localaC2.b != this.q)
            break label1295;
      }
      while (true)
      {
        if ((localaC2 == null) && (i4 > 0));
        for (aC localaC3 = b(this.q, i6); ; localaC3 = localaC2)
        {
          label355: int i12;
          label369: int i15;
          label392: label503: label636: float f3;
          label525: label531: aC localaC8;
          label682: float f4;
          label690: int i19;
          int i20;
          Object localObject2;
          label714: aC localaC13;
          label810: Object localObject3;
          float f6;
          if (localaC3 != null)
          {
            int i11 = i6 - 1;
            aC localaC7;
            float f1;
            float f2;
            int i14;
            int i16;
            if (i11 >= 0)
            {
              localaC7 = (aC)this.m.get(i11);
              i12 = f();
              if (i12 > 0)
                break label503;
              f1 = 0.0F;
              int i13 = -1 + this.q;
              f2 = 0.0F;
              i14 = i13;
              i15 = i6;
              i16 = i11;
              if (i14 < 0)
                break label636;
              if ((f2 < f1) || (i14 >= i3))
                break label531;
              if (localaC7 == null)
                break label636;
              if ((i14 == localaC7.b) && (!localaC7.c))
              {
                this.m.remove(i16);
                this.p.destroyItem(this, i14, localaC7.a);
                i16--;
                i15--;
                if (i16 < 0)
                  break label525;
                localaC7 = (aC)this.m.get(i16);
              }
            }
            while (true)
            {
              i14--;
              break label392;
              i6++;
              break;
              localaC7 = null;
              break label355;
              f1 = 2.0F - localaC3.d + getPaddingLeft() / i12;
              break label369;
              localaC7 = null;
              continue;
              if ((localaC7 != null) && (i14 == localaC7.b))
              {
                f2 += localaC7.d;
                i16--;
                if (i16 >= 0)
                  localaC7 = (aC)this.m.get(i16);
                else
                  localaC7 = null;
              }
              else
              {
                f2 += b(i14, i16 + 1).d;
                i15++;
                if (i16 >= 0)
                  localaC7 = (aC)this.m.get(i16);
                else
                  localaC7 = null;
              }
            }
            f3 = localaC3.d;
            int i17 = i15 + 1;
            if (f3 < 2.0F)
              if (i17 < this.m.size())
              {
                localaC8 = (aC)this.m.get(i17);
                if (i12 > 0)
                  break label846;
                f4 = 0.0F;
                int i18 = 1 + this.q;
                aC localaC9 = localaC8;
                i19 = i17;
                i20 = i18;
                localObject2 = localaC9;
                if (i20 >= i4)
                  break label1005;
                if ((f3 < f4) || (i20 <= i5))
                  break label868;
                if (localObject2 == null)
                  break label1005;
                if ((i20 != ((aC)localObject2).b) || (((aC)localObject2).c))
                  break label1273;
                this.m.remove(i19);
                this.p.destroyItem(this, i20, ((aC)localObject2).a);
                if (i19 >= this.m.size())
                  break label862;
                localaC13 = (aC)this.m.get(i19);
                float f10 = f3;
                localObject3 = localaC13;
                f6 = f10;
              }
          }
          while (true)
          {
            i20++;
            float f7 = f6;
            localObject2 = localObject3;
            f3 = f7;
            break label714;
            localaC8 = null;
            break label682;
            label846: f4 = 2.0F + getPaddingRight() / i12;
            break label690;
            label862: localaC13 = null;
            break label810;
            label868: if ((localObject2 != null) && (i20 == ((aC)localObject2).b))
            {
              float f8 = f3 + ((aC)localObject2).d;
              i19++;
              if (i19 < this.m.size());
              for (aC localaC12 = (aC)this.m.get(i19); ; localaC12 = null)
              {
                localObject3 = localaC12;
                f6 = f8;
                break;
              }
            }
            aC localaC10 = b(i20, i19);
            i19++;
            float f5 = f3 + localaC10.d;
            if (i19 < this.m.size());
            for (aC localaC11 = (aC)this.m.get(i19); ; localaC11 = null)
            {
              localObject3 = localaC11;
              f6 = f5;
              break;
            }
            label1005: a(localaC3, i15, localaC1);
            PagerAdapter localPagerAdapter = this.p;
            int i7 = this.q;
            if (localaC3 != null);
            for (Object localObject1 = localaC3.a; ; localObject1 = null)
            {
              localPagerAdapter.setPrimaryItem(this, i7, localObject1);
              this.p.finishUpdate(this);
              int i8 = getChildCount();
              for (int i9 = 0; i9 < i8; i9++)
              {
                View localView3 = getChildAt(i9);
                ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)localView3.getLayoutParams();
                localLayoutParams.d = i9;
                if ((!localLayoutParams.isDecor) && (localLayoutParams.a == 0.0F))
                {
                  aC localaC6 = a(localView3);
                  if (localaC6 != null)
                  {
                    localLayoutParams.a = localaC6.d;
                    localLayoutParams.c = localaC6.b;
                  }
                }
              }
            }
            g();
            if (!hasFocus())
              break;
            View localView1 = findFocus();
            if (localView1 != null);
            for (aC localaC4 = b(localView1); ; localaC4 = null)
            {
              if ((localaC4 != null) && (localaC4.b == this.q))
                break label1271;
              for (int i10 = 0; ; i10++)
              {
                if (i10 >= getChildCount())
                  break label1265;
                View localView2 = getChildAt(i10);
                aC localaC5 = a(localView2);
                if ((localaC5 != null) && (localaC5.b == this.q) && (localView2.requestFocus(i1)))
                  break;
              }
              label1265: break;
            }
            label1271: break;
            label1273: float f9 = f3;
            localObject3 = localObject2;
            f6 = f9;
          }
        }
        label1295: localaC2 = null;
      }
      i1 = 2;
      localaC1 = null;
    }
  }

  private void b(boolean paramBoolean)
  {
    if (this.aw == 2);
    int i3;
    for (int i1 = 1; ; i1 = 0)
    {
      if (i1 != 0)
      {
        d(false);
        this.u.abortAnimation();
        int i4 = getScrollX();
        int i5 = getScrollY();
        int i6 = this.u.getCurrX();
        int i7 = this.u.getCurrY();
        if ((i4 != i6) || (i5 != i7))
          scrollTo(i6, i7);
      }
      this.G = false;
      int i2 = 0;
      i3 = i1;
      while (i2 < this.m.size())
      {
        aC localaC = (aC)this.m.get(i2);
        if (localaC.c)
        {
          localaC.c = false;
          i3 = 1;
        }
        i2++;
      }
    }
    if (i3 != 0)
    {
      if (paramBoolean)
        ViewCompat.postOnAnimation(this, this.av);
    }
    else
      return;
    this.av.run();
  }

  private boolean b(float paramFloat)
  {
    int i1 = 1;
    float f1 = this.O - paramFloat;
    this.O = paramFloat;
    float f2 = f1 + getScrollX();
    int i2 = f();
    float f3 = i2 * this.A;
    float f4 = i2 * this.B;
    aC localaC1 = (aC)this.m.get(0);
    aC localaC2 = (aC)this.m.get(-1 + this.m.size());
    if (localaC1.b != 0)
      f3 = localaC1.e * i2;
    for (int i3 = 0; ; i3 = i1)
    {
      float f5;
      if (localaC2.b != -1 + this.p.getCount())
      {
        f5 = localaC2.e * i2;
        i1 = 0;
      }
      while (true)
      {
        boolean bool;
        if (f2 < f3)
        {
          bool = false;
          if (i3 != 0)
          {
            float f6 = f3 - f2;
            bool = this.ae.onPull(Math.abs(f6) / i2);
          }
        }
        while (true)
        {
          this.O += f3 - (int)f3;
          scrollTo((int)f3, getScrollY());
          d((int)f3);
          return bool;
          if (f2 > f5)
          {
            bool = false;
            if (i1 != 0)
            {
              float f7 = f2 - f5;
              bool = this.af.onPull(Math.abs(f7) / i2);
            }
            f3 = f5;
          }
          else
          {
            f3 = f2;
            bool = false;
          }
        }
        f5 = f4;
      }
    }
  }

  private aC c(int paramInt)
  {
    for (int i1 = 0; i1 < this.m.size(); i1++)
    {
      aC localaC = (aC)this.m.get(i1);
      if (localaC.b == paramInt)
        return localaC;
    }
    return null;
  }

  private void c(boolean paramBoolean)
  {
    int i1 = getChildCount();
    int i2 = 0;
    if (i2 < i1)
    {
      if (paramBoolean);
      for (int i3 = 2; ; i3 = 0)
      {
        ViewCompat.setLayerType(getChildAt(i2), i3, null);
        i2++;
        break;
      }
    }
  }

  private void d()
  {
    setWillNotDraw(false);
    setDescendantFocusability(262144);
    setFocusable(true);
    Context localContext = getContext();
    this.u = new Scroller(localContext, l);
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(localContext);
    float f1 = localContext.getResources().getDisplayMetrics().density;
    this.N = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
    this.V = ((int)(400.0F * f1));
    this.W = localViewConfiguration.getScaledMaximumFlingVelocity();
    this.ae = new EdgeEffectCompat(localContext);
    this.af = new EdgeEffectCompat(localContext);
    this.Z = ((int)(25.0F * f1));
    this.aa = ((int)(2.0F * f1));
    this.L = ((int)(16.0F * f1));
    ViewCompat.setAccessibilityDelegate(this, new aD(this));
    if (ViewCompat.getImportantForAccessibility(this) == 0)
      ViewCompat.setImportantForAccessibility(this, 1);
  }

  private void d(boolean paramBoolean)
  {
    if (this.F != paramBoolean)
      this.F = paramBoolean;
  }

  private boolean d(int paramInt)
  {
    boolean bool1;
    if (this.m.size() == 0)
    {
      this.ai = false;
      onPageScrolled(0, 0.0F, 0);
      boolean bool2 = this.ai;
      bool1 = false;
      if (!bool2)
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }
    else
    {
      aC localaC = h();
      int i1 = f();
      int i2 = i1 + this.w;
      float f1 = this.w / i1;
      int i3 = localaC.b;
      float f2 = (paramInt / i1 - localaC.e) / (f1 + localaC.d);
      int i4 = (int)(f2 * i2);
      this.ai = false;
      onPageScrolled(i3, f2, i4);
      if (!this.ai)
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
      bool1 = true;
    }
    return bool1;
  }

  private void e()
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
      if (!((ViewPager.LayoutParams)getChildAt(i1).getLayoutParams()).isDecor)
      {
        removeViewAt(i1);
        i1--;
      }
  }

  private int f()
  {
    return getMeasuredWidth() - getPaddingLeft() - getPaddingRight();
  }

  private void g()
  {
    if (this.as != 0)
    {
      if (this.at == null)
        this.at = new ArrayList();
      while (true)
      {
        int i1 = getChildCount();
        for (int i2 = 0; i2 < i1; i2++)
        {
          View localView = getChildAt(i2);
          this.at.add(localView);
        }
        this.at.clear();
      }
      Collections.sort(this.at, au);
    }
  }

  private aC h()
  {
    int i1 = f();
    float f1;
    float f2;
    label31: float f3;
    float f4;
    int i2;
    int i3;
    int i4;
    Object localObject;
    label49: aC localaC1;
    aC localaC3;
    int i5;
    if (i1 > 0)
    {
      f1 = getScrollX() / i1;
      if (i1 <= 0)
        break label210;
      f2 = this.w / i1;
      f3 = 0.0F;
      f4 = 0.0F;
      i2 = -1;
      i3 = 0;
      i4 = 1;
      localObject = null;
      if (i3 < this.m.size())
      {
        localaC1 = (aC)this.m.get(i3);
        if ((i4 != 0) || (localaC1.b == i2 + 1))
          break label261;
        localaC3 = this.n;
        localaC3.e = (f2 + (f3 + f4));
        localaC3.b = (i2 + 1);
        localaC3.d = this.p.getPageWidth(localaC3.b);
        i5 = i3 - 1;
      }
    }
    for (aC localaC2 = localaC3; ; localaC2 = localaC1)
    {
      float f5 = localaC2.e;
      float f6 = f2 + (f5 + localaC2.d);
      if ((i4 != 0) || (f1 >= f5))
      {
        if ((f1 < f6) || (i5 == -1 + this.m.size()))
          localObject = localaC2;
      }
      else
      {
        return localObject;
        f1 = 0.0F;
        break;
        label210: f2 = 0.0F;
        break label31;
      }
      int i6 = localaC2.b;
      float f7 = localaC2.d;
      int i7 = i5 + 1;
      f4 = f5;
      i2 = i6;
      f3 = f7;
      localObject = localaC2;
      i3 = i7;
      i4 = 0;
      break label49;
      label261: i5 = i3;
    }
  }

  private void i()
  {
    this.I = false;
    this.J = false;
    if (this.U != null)
    {
      this.U.recycle();
      this.U = null;
    }
  }

  private boolean j()
  {
    if (this.q > 0)
    {
      setCurrentItem(-1 + this.q, true);
      return true;
    }
    return false;
  }

  private boolean k()
  {
    if ((this.p != null) && (this.q < -1 + this.p.getCount()))
    {
      setCurrentItem(1 + this.q, true);
      return true;
    }
    return false;
  }

  final ViewPager.OnPageChangeListener a(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    ViewPager.OnPageChangeListener localOnPageChangeListener = this.al;
    this.al = paramOnPageChangeListener;
    return localOnPageChangeListener;
  }

  final void a()
  {
    int i1 = this.p.getCount();
    this.j = i1;
    int i2;
    int i4;
    int i5;
    int i6;
    int i7;
    label61: aC localaC;
    int i10;
    int i16;
    int i11;
    int i12;
    int i13;
    int i14;
    if ((this.m.size() < 1 + (this.H << 1)) && (this.m.size() < i1))
    {
      i2 = 1;
      int i3 = this.q;
      i4 = 0;
      i5 = i3;
      i6 = i2;
      i7 = 0;
      if (i7 >= this.m.size())
        break label288;
      localaC = (aC)this.m.get(i7);
      i10 = this.p.getItemPosition(localaC.a);
      if (i10 == -1)
        break label379;
      if (i10 != -2)
        break label237;
      this.m.remove(i7);
      i16 = i7 - 1;
      if (i4 == 0)
      {
        this.p.startUpdate(this);
        i4 = 1;
      }
      this.p.destroyItem(this, localaC.b, localaC.a);
      if (this.q != localaC.b)
        break label398;
      int i17 = Math.max(0, Math.min(this.q, i1 - 1));
      i11 = i16;
      i12 = i4;
      i13 = i17;
      i14 = 1;
    }
    label288: 
    while (true)
    {
      int i15 = i11 + 1;
      i6 = i14;
      i5 = i13;
      i4 = i12;
      i7 = i15;
      break label61;
      i2 = 0;
      break;
      label237: if (localaC.b != i10)
      {
        if (localaC.b == this.q)
          i5 = i10;
        localaC.b = i10;
        i11 = i7;
        i12 = i4;
        i13 = i5;
        i14 = 1;
        continue;
        if (i4 != 0)
          this.p.finishUpdate(this);
        Collections.sort(this.m, k);
        if (i6 != 0)
        {
          int i8 = getChildCount();
          for (int i9 = 0; i9 < i8; i9++)
          {
            ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)getChildAt(i9).getLayoutParams();
            if (!localLayoutParams.isDecor)
              localLayoutParams.a = 0.0F;
          }
          a(i5, false, true);
          requestLayout();
        }
      }
      else
      {
        label379: i11 = i7;
        i12 = i4;
        i13 = i5;
        i14 = i6;
        continue;
        i11 = i16;
        i12 = i4;
        i13 = i5;
        i14 = 1;
      }
    }
  }

  final void a(aE paramaE)
  {
    this.am = paramaE;
  }

  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    int i1 = paramArrayList.size();
    int i2 = getDescendantFocusability();
    if (i2 != 393216)
      for (int i3 = 0; i3 < getChildCount(); i3++)
      {
        View localView = getChildAt(i3);
        if (localView.getVisibility() == 0)
        {
          aC localaC = a(localView);
          if ((localaC != null) && (localaC.b == this.q))
            localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
      }
    if (((i2 == 262144) && (i1 != paramArrayList.size())) || (!isFocusable()));
    while ((((paramInt2 & 0x1) == 1) && (isInTouchMode()) && (!isFocusableInTouchMode())) || (paramArrayList == null))
      return;
    paramArrayList.add(this);
  }

  public void addTouchables(ArrayList<View> paramArrayList)
  {
    for (int i1 = 0; i1 < getChildCount(); i1++)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        aC localaC = a(localView);
        if ((localaC != null) && (localaC.b == this.q))
          localView.addTouchables(paramArrayList);
      }
    }
  }

  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (!checkLayoutParams(paramLayoutParams));
    for (ViewGroup.LayoutParams localLayoutParams = generateLayoutParams(paramLayoutParams); ; localLayoutParams = paramLayoutParams)
    {
      ViewPager.LayoutParams localLayoutParams1 = (ViewPager.LayoutParams)localLayoutParams;
      localLayoutParams1.isDecor |= paramView instanceof aB;
      if (this.E)
      {
        if ((localLayoutParams1 != null) && (localLayoutParams1.isDecor))
          throw new IllegalStateException("Cannot add pager decor view during layout");
        localLayoutParams1.b = true;
        addViewInLayout(paramView, paramInt, localLayoutParams);
        return;
      }
      super.addView(paramView, paramInt, localLayoutParams);
      return;
    }
  }

  public boolean arrowScroll(int paramInt)
  {
    View localView1 = findFocus();
    View localView2;
    View localView3;
    boolean bool;
    label86: ViewParent localViewParent1;
    if (localView1 == this)
    {
      localView2 = null;
      localView3 = FocusFinder.getInstance().findNextFocus(this, localView2, paramInt);
      if ((localView3 == null) || (localView3 == localView2))
        break label321;
      if (paramInt != 17)
        break label256;
      int i3 = a(this.o, localView3).left;
      int i4 = a(this.o, localView2).left;
      if ((localView2 != null) && (i3 >= i4))
      {
        bool = j();
        if (bool)
          playSoundEffect(SoundEffectConstants.getContantForFocusDirection(paramInt));
        return bool;
      }
    }
    else
    {
      if (localView1 == null)
        break label367;
      localViewParent1 = localView1.getParent();
      if (!(localViewParent1 instanceof ViewGroup))
        break label372;
      if (localViewParent1 != this);
    }
    label256: label321: label367: label372: for (int i5 = 1; ; i5 = 0)
    {
      if (i5 == 0)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localView1.getClass().getSimpleName());
        ViewParent localViewParent2 = localView1.getParent();
        while (true)
          if ((localViewParent2 instanceof ViewGroup))
          {
            localStringBuilder.append(" => ").append(localViewParent2.getClass().getSimpleName());
            localViewParent2 = localViewParent2.getParent();
            continue;
            localViewParent1 = localViewParent1.getParent();
            break;
          }
        Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + localStringBuilder.toString());
        localView2 = null;
        break;
        bool = localView3.requestFocus();
        break label86;
        if (paramInt == 66)
        {
          int i1 = a(this.o, localView3).left;
          int i2 = a(this.o, localView2).left;
          if ((localView2 != null) && (i1 <= i2))
          {
            bool = k();
            break label86;
          }
          bool = localView3.requestFocus();
          break label86;
          if ((paramInt == 17) || (paramInt == 1))
          {
            bool = j();
            break label86;
          }
          if ((paramInt == 66) || (paramInt == 2))
          {
            bool = k();
            break label86;
          }
        }
        bool = false;
        break label86;
      }
      localView2 = localView1;
      break;
    }
  }

  final void b()
  {
    b(this.q);
  }

  public boolean beginFakeDrag()
  {
    if (this.I)
      return false;
    this.ac = true;
    a(1);
    this.O = 0.0F;
    this.Q = 0.0F;
    if (this.U == null)
      this.U = VelocityTracker.obtain();
    while (true)
    {
      long l1 = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l1, l1, 0, 0.0F, 0.0F, 0);
      this.U.addMovement(localMotionEvent);
      localMotionEvent.recycle();
      this.ad = l1;
      return true;
      this.U.clear();
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

  public boolean canScrollHorizontally(int paramInt)
  {
    if (this.p == null);
    int i1;
    int i2;
    do
    {
      do
      {
        return false;
        i1 = f();
        i2 = getScrollX();
        if (paramInt >= 0)
          break;
      }
      while (i2 <= (int)(i1 * this.A));
      return true;
    }
    while ((paramInt <= 0) || (i2 >= (int)(i1 * this.B)));
    return true;
  }

  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof ViewPager.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }

  public void computeScroll()
  {
    if ((!this.u.isFinished()) && (this.u.computeScrollOffset()))
    {
      int i1 = getScrollX();
      int i2 = getScrollY();
      int i3 = this.u.getCurrX();
      int i4 = this.u.getCurrY();
      if ((i1 != i3) || (i2 != i4))
      {
        scrollTo(i3, i4);
        if (!d(i3))
        {
          this.u.abortAnimation();
          scrollTo(0, i4);
        }
      }
      ViewCompat.postInvalidateOnAnimation(this);
      return;
    }
    b(true);
  }

  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (super.dispatchKeyEvent(paramKeyEvent)) || (executeKeyEvent(paramKeyEvent));
  }

  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    boolean bool;
    if (paramAccessibilityEvent.getEventType() == 4096)
    {
      bool = super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
      return bool;
    }
    int i1 = getChildCount();
    for (int i2 = 0; ; i2++)
    {
      bool = false;
      if (i2 >= i1)
        break;
      View localView = getChildAt(i2);
      if (localView.getVisibility() == 0)
      {
        aC localaC = a(localView);
        if ((localaC != null) && (localaC.b == this.q) && (localView.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent)))
          return true;
      }
    }
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i1 = ViewCompat.getOverScrollMode(this);
    boolean bool2;
    if ((i1 == 0) || ((i1 == 1) && (this.p != null) && (this.p.getCount() > 1)))
    {
      boolean bool1 = this.ae.isFinished();
      bool2 = false;
      if (!bool1)
      {
        int i5 = paramCanvas.save();
        int i6 = getHeight() - getPaddingTop() - getPaddingBottom();
        int i7 = getWidth();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-i6 + getPaddingTop(), this.A * i7);
        this.ae.setSize(i6, i7);
        bool2 = false | this.ae.draw(paramCanvas);
        paramCanvas.restoreToCount(i5);
      }
      if (!this.af.isFinished())
      {
        int i2 = paramCanvas.save();
        int i3 = getWidth();
        int i4 = getHeight() - getPaddingTop() - getPaddingBottom();
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-getPaddingTop(), -(1.0F + this.B) * i3);
        this.af.setSize(i4, i3);
        bool2 |= this.af.draw(paramCanvas);
        paramCanvas.restoreToCount(i2);
      }
    }
    while (true)
    {
      if (bool2)
        ViewCompat.postInvalidateOnAnimation(this);
      return;
      this.ae.finish();
      this.af.finish();
      bool2 = false;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    Drawable localDrawable = this.x;
    if ((localDrawable != null) && (localDrawable.isStateful()))
      localDrawable.setState(getDrawableState());
  }

  public void endFakeDrag()
  {
    if (!this.ac)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    VelocityTracker localVelocityTracker = this.U;
    localVelocityTracker.computeCurrentVelocity(1000, this.W);
    int i1 = (int)VelocityTrackerCompat.getXVelocity(localVelocityTracker, this.S);
    this.G = true;
    int i2 = f();
    int i3 = getScrollX();
    aC localaC = h();
    a(a(localaC.b, (i3 / i2 - localaC.e) / localaC.d, i1, (int)(this.O - this.Q)), true, true, i1);
    i();
    this.ac = false;
  }

  public boolean executeKeyEvent(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 0)
      switch (paramKeyEvent.getKeyCode())
      {
      default:
      case 21:
      case 22:
      case 61:
      }
    do
    {
      do
      {
        return false;
        return arrowScroll(17);
        return arrowScroll(66);
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
    if (!this.ac)
      throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
    this.O = (paramFloat + this.O);
    float f1 = getScrollX() - paramFloat;
    int i1 = f();
    float f2 = i1 * this.A;
    float f3 = i1 * this.B;
    aC localaC1 = (aC)this.m.get(0);
    aC localaC2 = (aC)this.m.get(-1 + this.m.size());
    if (localaC1.b != 0);
    for (float f4 = localaC1.e * i1; ; f4 = f2)
    {
      if (localaC2.b != -1 + this.p.getCount());
      for (float f5 = localaC2.e * i1; ; f5 = f3)
      {
        if (f1 < f4);
        while (true)
        {
          this.O += f4 - (int)f4;
          scrollTo((int)f4, getScrollY());
          d((int)f4);
          long l1 = SystemClock.uptimeMillis();
          MotionEvent localMotionEvent = MotionEvent.obtain(this.ad, l1, 2, this.O, 0.0F, 0);
          this.U.addMovement(localMotionEvent);
          localMotionEvent.recycle();
          return;
          if (f1 > f5)
            f4 = f5;
          else
            f4 = f1;
        }
      }
    }
  }

  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new ViewPager.LayoutParams();
  }

  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new ViewPager.LayoutParams(getContext(), paramAttributeSet);
  }

  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return generateDefaultLayoutParams();
  }

  public PagerAdapter getAdapter()
  {
    return this.p;
  }

  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (this.as == 2)
      paramInt2 = paramInt1 - 1 - paramInt2;
    return ((ViewPager.LayoutParams)((View)this.at.get(paramInt2)).getLayoutParams()).d;
  }

  public int getCurrentItem()
  {
    return this.q;
  }

  public int getOffscreenPageLimit()
  {
    return this.H;
  }

  public int getPageMargin()
  {
    return this.w;
  }

  public boolean isFakeDragging()
  {
    return this.ac;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.ag = true;
  }

  protected void onDetachedFromWindow()
  {
    removeCallbacks(this.av);
    super.onDetachedFromWindow();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.w > 0) && (this.x != null) && (this.m.size() > 0) && (this.p != null))
    {
      int i1 = getScrollX();
      int i2 = getWidth();
      float f1 = this.w / i2;
      aC localaC = (aC)this.m.get(0);
      float f2 = localaC.e;
      int i3 = this.m.size();
      int i4 = localaC.b;
      int i5 = ((aC)this.m.get(i3 - 1)).b;
      int i6 = 0;
      int i7 = i4;
      if (i7 < i5)
      {
        while ((i7 > localaC.b) && (i6 < i3))
        {
          ArrayList localArrayList = this.m;
          i6++;
          localaC = (aC)localArrayList.get(i6);
        }
        float f4;
        if (i7 == localaC.b)
          f4 = (localaC.e + localaC.d) * i2;
        float f3;
        for (f2 = f1 + (localaC.e + localaC.d); ; f2 += f3 + f1)
        {
          if (f4 + this.w > i1)
          {
            this.x.setBounds((int)f4, this.y, (int)(0.5F + (f4 + this.w)), this.z);
            this.x.draw(paramCanvas);
          }
          if (f4 > i1 + i2)
            return;
          i7++;
          break;
          f3 = this.p.getPageWidth(i7);
          f4 = (f2 + f3) * i2;
        }
      }
    }
  }

  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = 0xFF & paramMotionEvent.getAction();
    if ((i1 == 3) || (i1 == 1))
    {
      this.I = false;
      this.J = false;
      this.S = -1;
      if (this.U != null)
      {
        this.U.recycle();
        this.U = null;
      }
    }
    do
    {
      return false;
      if (i1 == 0)
        break;
      if (this.I)
        return true;
    }
    while (this.J);
    switch (i1)
    {
    default:
    case 2:
    case 0:
    case 6:
    }
    while (true)
    {
      if (this.U == null)
        this.U = VelocityTracker.obtain();
      this.U.addMovement(paramMotionEvent);
      return this.I;
      int i2 = this.S;
      if (i2 != -1)
      {
        int i3 = MotionEventCompat.findPointerIndex(paramMotionEvent, i2);
        float f3 = MotionEventCompat.getX(paramMotionEvent, i3);
        float f4 = f3 - this.O;
        float f5 = Math.abs(f4);
        float f6 = MotionEventCompat.getY(paramMotionEvent, i3);
        float f7 = Math.abs(f6 - this.R);
        if (f4 != 0.0F)
        {
          float f9 = this.O;
          if (((f9 < this.M) && (f4 > 0.0F)) || ((f9 > getWidth() - this.M) && (f4 < 0.0F)));
          for (int i4 = 1; (i4 == 0) && (canScroll(this, false, (int)f4, (int)f3, (int)f6)); i4 = 0)
          {
            this.O = f3;
            this.P = f6;
            this.J = true;
            return false;
          }
        }
        float f8;
        if ((f5 > this.N) && (0.5F * f5 > f7))
        {
          this.I = true;
          a(1);
          if (f4 > 0.0F)
          {
            f8 = this.Q + this.N;
            label359: this.O = f8;
            this.P = f6;
            d(true);
          }
        }
        while ((this.I) && (b(f3)))
        {
          ViewCompat.postInvalidateOnAnimation(this);
          break;
          f8 = this.Q - this.N;
          break label359;
          if (f7 > this.N)
            this.J = true;
        }
        float f1 = paramMotionEvent.getX();
        this.Q = f1;
        this.O = f1;
        float f2 = paramMotionEvent.getY();
        this.R = f2;
        this.P = f2;
        this.S = MotionEventCompat.getPointerId(paramMotionEvent, 0);
        this.J = false;
        this.u.computeScrollOffset();
        if ((this.aw == 2) && (Math.abs(this.u.getFinalX() - this.u.getCurrX()) > this.aa))
        {
          this.u.abortAnimation();
          this.G = false;
          b();
          this.I = true;
          a(1);
        }
        else
        {
          b(false);
          this.I = false;
          continue;
          a(paramMotionEvent);
        }
      }
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = getChildCount();
    int i2 = paramInt3 - paramInt1;
    int i3 = paramInt4 - paramInt2;
    int i4 = getPaddingLeft();
    int i5 = getPaddingTop();
    int i6 = getPaddingRight();
    int i7 = getPaddingBottom();
    int i8 = getScrollX();
    int i9 = 0;
    int i10 = 0;
    View localView2;
    int i21;
    label156: int i22;
    int i24;
    int i25;
    label208: int i14;
    int i15;
    int i16;
    if (i10 < i1)
    {
      localView2 = getChildAt(i10);
      if (localView2.getVisibility() == 8)
        break label659;
      ViewPager.LayoutParams localLayoutParams2 = (ViewPager.LayoutParams)localView2.getLayoutParams();
      if (!localLayoutParams2.isDecor)
        break label659;
      int i18 = 0x7 & localLayoutParams2.gravity;
      int i19 = 0x70 & localLayoutParams2.gravity;
      switch (i18)
      {
      case 2:
      case 4:
      default:
        i21 = i4;
        switch (i19)
        {
        default:
          i22 = i5;
          int i30 = i7;
          i24 = i5;
          i25 = i30;
          int i26 = i21 + i8;
          localView2.layout(i26, i22, i26 + localView2.getMeasuredWidth(), i22 + localView2.getMeasuredHeight());
          i14 = i9 + 1;
          i15 = i24;
          i7 = i25;
          i16 = i6;
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
    for (int i17 = i4; ; i17 = i4)
    {
      i10++;
      i4 = i17;
      i6 = i16;
      i5 = i15;
      i9 = i14;
      break;
      int i31 = i4 + localView2.getMeasuredWidth();
      i21 = i4;
      i4 = i31;
      break label156;
      i21 = Math.max((i2 - localView2.getMeasuredWidth()) / 2, i4);
      break label156;
      int i20 = i2 - i6 - localView2.getMeasuredWidth();
      i6 += localView2.getMeasuredWidth();
      i21 = i20;
      break label156;
      int i28 = i5 + localView2.getMeasuredHeight();
      int i29 = i5;
      i25 = i7;
      i24 = i28;
      i22 = i29;
      break label208;
      i22 = Math.max((i3 - localView2.getMeasuredHeight()) / 2, i5);
      int i27 = i7;
      i24 = i5;
      i25 = i27;
      break label208;
      i22 = i3 - i7 - localView2.getMeasuredHeight();
      int i23 = i7 + localView2.getMeasuredHeight();
      i24 = i5;
      i25 = i23;
      break label208;
      int i11 = i2 - i4 - i6;
      for (int i12 = 0; i12 < i1; i12++)
      {
        View localView1 = getChildAt(i12);
        if (localView1.getVisibility() != 8)
        {
          ViewPager.LayoutParams localLayoutParams1 = (ViewPager.LayoutParams)localView1.getLayoutParams();
          if (!localLayoutParams1.isDecor)
          {
            aC localaC = a(localView1);
            if (localaC != null)
            {
              int i13 = i4 + (int)(i11 * localaC.e);
              if (localLayoutParams1.b)
              {
                localLayoutParams1.b = false;
                localView1.measure(View.MeasureSpec.makeMeasureSpec((int)(i11 * localLayoutParams1.a), 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - i5 - i7, 1073741824));
              }
              localView1.layout(i13, i5, i13 + localView1.getMeasuredWidth(), i5 + localView1.getMeasuredHeight());
            }
          }
        }
      }
      this.y = i5;
      this.z = (i3 - i7);
      this.aj = i9;
      if (this.ag)
        a(this.q, false, 0, false);
      this.ag = false;
      return;
      label659: i14 = i9;
      i15 = i5;
      i16 = i6;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getDefaultSize(0, paramInt1), getDefaultSize(0, paramInt2));
    int i1 = getMeasuredWidth();
    this.M = Math.min(i1 / 10, this.L);
    int i2 = i1 - getPaddingLeft() - getPaddingRight();
    int i3 = getMeasuredHeight() - getPaddingTop() - getPaddingBottom();
    int i4 = getChildCount();
    int i5 = 0;
    View localView2;
    ViewPager.LayoutParams localLayoutParams2;
    int i10;
    int i11;
    int i12;
    label167: int i13;
    label182: label192: int i14;
    int i15;
    if (i5 < i4)
    {
      localView2 = getChildAt(i5);
      if (localView2.getVisibility() != 8)
      {
        localLayoutParams2 = (ViewPager.LayoutParams)localView2.getLayoutParams();
        if ((localLayoutParams2 != null) && (localLayoutParams2.isDecor))
        {
          int i8 = 0x7 & localLayoutParams2.gravity;
          int i9 = 0x70 & localLayoutParams2.gravity;
          i10 = -2147483648;
          i11 = -2147483648;
          if ((i9 != 48) && (i9 != 80))
            break label294;
          i12 = 1;
          if ((i8 != 3) && (i8 != 5))
            break label300;
          i13 = 1;
          if (i12 == 0)
            break label306;
          i10 = 1073741824;
          if (localLayoutParams2.width == -2)
            break label475;
          i14 = 1073741824;
          if (localLayoutParams2.width == -1)
            break label468;
          i15 = localLayoutParams2.width;
        }
      }
    }
    while (true)
    {
      if (localLayoutParams2.height != -2)
      {
        i11 = 1073741824;
        if (localLayoutParams2.height == -1);
      }
      for (int i16 = localLayoutParams2.height; ; i16 = i3)
      {
        localView2.measure(View.MeasureSpec.makeMeasureSpec(i15, i14), View.MeasureSpec.makeMeasureSpec(i16, i11));
        if (i12 != 0)
          i3 -= localView2.getMeasuredHeight();
        while (true)
        {
          i5++;
          break;
          label294: i12 = 0;
          break label167;
          label300: i13 = 0;
          break label182;
          label306: if (i13 == 0)
            break label192;
          i11 = 1073741824;
          break label192;
          if (i13 != 0)
            i2 -= localView2.getMeasuredWidth();
        }
        View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
        this.D = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        this.E = true;
        b();
        this.E = false;
        int i6 = getChildCount();
        for (int i7 = 0; i7 < i6; i7++)
        {
          View localView1 = getChildAt(i7);
          if (localView1.getVisibility() != 8)
          {
            ViewPager.LayoutParams localLayoutParams1 = (ViewPager.LayoutParams)localView1.getLayoutParams();
            if ((localLayoutParams1 == null) || (!localLayoutParams1.isDecor))
              localView1.measure(View.MeasureSpec.makeMeasureSpec((int)(i2 * localLayoutParams1.a), 1073741824), this.D);
          }
        }
        return;
      }
      label468: i15 = i2;
      continue;
      label475: i14 = i10;
      i15 = i2;
    }
  }

  protected void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    int i5;
    int i6;
    int i7;
    int i9;
    View localView2;
    int i14;
    int i11;
    int i12;
    if (this.aj > 0)
    {
      int i4 = getScrollX();
      i5 = getPaddingLeft();
      i6 = getPaddingRight();
      i7 = getWidth();
      int i8 = getChildCount();
      i9 = 0;
      if (i9 < i8)
      {
        localView2 = getChildAt(i9);
        ViewPager.LayoutParams localLayoutParams = (ViewPager.LayoutParams)localView2.getLayoutParams();
        if (!localLayoutParams.isDecor)
          break label401;
        switch (0x7 & localLayoutParams.gravity)
        {
        case 2:
        case 4:
        default:
          i14 = i5;
          int i20 = i6;
          i11 = i5;
          i12 = i20;
          label132: int i16 = i14 + i4 - localView2.getLeft();
          if (i16 != 0)
            localView2.offsetLeftAndRight(i16);
          break;
        case 3:
        case 1:
        case 5:
        }
      }
    }
    while (true)
    {
      i9++;
      int i13 = i12;
      i5 = i11;
      i6 = i13;
      break;
      int i18 = i5 + localView2.getWidth();
      int i19 = i5;
      i12 = i6;
      i11 = i18;
      i14 = i19;
      break label132;
      i14 = Math.max((i7 - localView2.getMeasuredWidth()) / 2, i5);
      int i17 = i6;
      i11 = i5;
      i12 = i17;
      break label132;
      i14 = i7 - i6 - localView2.getMeasuredWidth();
      int i15 = i6 + localView2.getMeasuredWidth();
      i11 = i5;
      i12 = i15;
      break label132;
      if (this.ak != null)
        this.ak.onPageScrolled(paramInt1, paramFloat, paramInt2);
      if (this.al != null)
        this.al.onPageScrolled(paramInt1, paramFloat, paramInt2);
      if (this.an != null)
      {
        int i1 = getScrollX();
        int i2 = getChildCount();
        for (int i3 = 0; i3 < i2; i3++)
        {
          View localView1 = getChildAt(i3);
          if (!((ViewPager.LayoutParams)localView1.getLayoutParams()).isDecor)
          {
            float f1 = (localView1.getLeft() - i1) / f();
            this.an.transformPage(localView1, f1);
          }
        }
      }
      this.ai = true;
      return;
      label401: int i10 = i6;
      i11 = i5;
      i12 = i10;
    }
  }

  protected boolean onRequestFocusInDescendants(int paramInt, Rect paramRect)
  {
    int i1 = -1;
    int i2 = getChildCount();
    int i3;
    if ((paramInt & 0x2) != 0)
    {
      i1 = 1;
      i3 = 0;
    }
    while (i3 != i2)
    {
      View localView = getChildAt(i3);
      if (localView.getVisibility() == 0)
      {
        aC localaC = a(localView);
        if ((localaC != null) && (localaC.b == this.q) && (localView.requestFocus(paramInt, paramRect)))
        {
          return true;
          i3 = i2 - 1;
          i2 = i1;
        }
      }
      else
      {
        i3 += i1;
      }
    }
    return false;
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ViewPager.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    ViewPager.SavedState localSavedState = (ViewPager.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    if (this.p != null)
    {
      this.p.restoreState(localSavedState.b, localSavedState.c);
      a(localSavedState.a, false, true);
      return;
    }
    this.r = localSavedState.a;
    this.s = localSavedState.b;
    this.t = localSavedState.c;
  }

  public Parcelable onSaveInstanceState()
  {
    ViewPager.SavedState localSavedState = new ViewPager.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.q;
    if (this.p != null)
      localSavedState.b = this.p.saveState();
    return localSavedState;
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3)
      a(paramInt1, paramInt3, this.w, this.w);
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.ac)
      return true;
    if ((paramMotionEvent.getAction() == 0) && (paramMotionEvent.getEdgeFlags() != 0))
      return false;
    if ((this.p == null) || (this.p.getCount() == 0))
      return false;
    if (this.U == null)
      this.U = VelocityTracker.obtain();
    this.U.addMovement(paramMotionEvent);
    int i1 = 0xFF & paramMotionEvent.getAction();
    boolean bool1 = false;
    switch (i1)
    {
    case 4:
    default:
    case 0:
    case 2:
    case 1:
    case 3:
    case 5:
    case 6:
    }
    while (true)
    {
      if (bool1)
        ViewCompat.postInvalidateOnAnimation(this);
      return true;
      this.u.abortAnimation();
      this.G = false;
      b();
      this.I = true;
      a(1);
      float f6 = paramMotionEvent.getX();
      this.Q = f6;
      this.O = f6;
      float f7 = paramMotionEvent.getY();
      this.R = f7;
      this.P = f7;
      this.S = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      bool1 = false;
      continue;
      float f3;
      if (!this.I)
      {
        int i6 = MotionEventCompat.findPointerIndex(paramMotionEvent, this.S);
        float f1 = MotionEventCompat.getX(paramMotionEvent, i6);
        float f2 = Math.abs(f1 - this.O);
        f3 = MotionEventCompat.getY(paramMotionEvent, i6);
        float f4 = Math.abs(f3 - this.P);
        if ((f2 > this.N) && (f2 > f4))
        {
          this.I = true;
          if (f1 - this.Q <= 0.0F)
            break label368;
        }
      }
      label368: for (float f5 = this.Q + this.N; ; f5 = this.Q - this.N)
      {
        this.O = f5;
        this.P = f3;
        a(1);
        d(true);
        boolean bool4 = this.I;
        bool1 = false;
        if (!bool4)
          break;
        bool1 = false | b(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.S)));
        break;
      }
      boolean bool3 = this.I;
      bool1 = false;
      if (bool3)
      {
        VelocityTracker localVelocityTracker = this.U;
        localVelocityTracker.computeCurrentVelocity(1000, this.W);
        int i3 = (int)VelocityTrackerCompat.getXVelocity(localVelocityTracker, this.S);
        this.G = true;
        int i4 = f();
        int i5 = getScrollX();
        aC localaC = h();
        a(a(localaC.b, (i5 / i4 - localaC.e) / localaC.d, i3, (int)(MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.S)) - this.Q)), true, true, i3);
        this.S = -1;
        i();
        bool1 = this.ae.onRelease() | this.af.onRelease();
        continue;
        boolean bool2 = this.I;
        bool1 = false;
        if (bool2)
        {
          a(this.q, true, 0, false);
          this.S = -1;
          i();
          bool1 = this.ae.onRelease() | this.af.onRelease();
          continue;
          int i2 = MotionEventCompat.getActionIndex(paramMotionEvent);
          this.O = MotionEventCompat.getX(paramMotionEvent, i2);
          this.S = MotionEventCompat.getPointerId(paramMotionEvent, i2);
          bool1 = false;
          continue;
          a(paramMotionEvent);
          this.O = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.S));
          bool1 = false;
        }
      }
    }
  }

  public void removeView(View paramView)
  {
    if (this.E)
    {
      removeViewInLayout(paramView);
      return;
    }
    super.removeView(paramView);
  }

  public void setAdapter(PagerAdapter paramPagerAdapter)
  {
    if (this.p != null)
    {
      this.p.unregisterDataSetObserver(this.v);
      this.p.startUpdate(this);
      for (int i1 = 0; i1 < this.m.size(); i1++)
      {
        aC localaC = (aC)this.m.get(i1);
        this.p.destroyItem(this, localaC.b, localaC.a);
      }
      this.p.finishUpdate(this);
      this.m.clear();
      for (int i2 = 0; i2 < getChildCount(); i2++)
        if (!((ViewPager.LayoutParams)getChildAt(i2).getLayoutParams()).isDecor)
        {
          removeViewAt(i2);
          i2--;
        }
      this.q = 0;
      scrollTo(0, 0);
    }
    PagerAdapter localPagerAdapter = this.p;
    this.p = paramPagerAdapter;
    this.j = 0;
    boolean bool;
    if (this.p != null)
    {
      if (this.v == null)
        this.v = new aF(this, (byte)0);
      this.p.registerDataSetObserver(this.v);
      this.G = false;
      bool = this.ag;
      this.ag = true;
      this.j = this.p.getCount();
      if (this.r < 0)
        break label300;
      this.p.restoreState(this.s, this.t);
      a(this.r, false, true);
      this.r = -1;
      this.s = null;
      this.t = null;
    }
    while (true)
    {
      if ((this.am != null) && (localPagerAdapter != paramPagerAdapter))
        this.am.a(localPagerAdapter, paramPagerAdapter);
      return;
      label300: if (!bool)
        b();
      else
        requestLayout();
    }
  }

  public void setCurrentItem(int paramInt)
  {
    this.G = false;
    if (!this.ag);
    for (boolean bool = true; ; bool = false)
    {
      a(paramInt, bool, false);
      return;
    }
  }

  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    this.G = false;
    a(paramInt, paramBoolean, false);
  }

  public void setOffscreenPageLimit(int paramInt)
  {
    if (paramInt <= 0)
    {
      Log.w("ViewPager", "Requested offscreen page limit " + paramInt + " too small; defaulting to 1");
      paramInt = 1;
    }
    if (paramInt != this.H)
    {
      this.H = paramInt;
      b();
    }
  }

  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.ak = paramOnPageChangeListener;
  }

  public void setPageMargin(int paramInt)
  {
    int i1 = this.w;
    this.w = paramInt;
    int i2 = getWidth();
    a(i2, i2, paramInt, i1);
    requestLayout();
  }

  public void setPageMarginDrawable(int paramInt)
  {
    setPageMarginDrawable(getContext().getResources().getDrawable(paramInt));
  }

  public void setPageMarginDrawable(Drawable paramDrawable)
  {
    this.x = paramDrawable;
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

  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    int i1 = 1;
    int i2;
    if (Build.VERSION.SDK_INT >= 11)
    {
      if (paramPageTransformer == null)
        break label140;
      i2 = i1;
    }
    while (true)
    {
      label27: int i6;
      if (this.an != null)
      {
        int i4 = i1;
        if (i2 == i4)
          break label152;
        i6 = i1;
        label37: this.an = paramPageTransformer;
        if ((Build.VERSION.SDK_INT >= 7) && (this.ao != null));
      }
      try
      {
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Boolean.TYPE;
        this.ao = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", arrayOfClass);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          while (true)
          {
            Method localMethod = this.ao;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Boolean.valueOf(i2);
            localMethod.invoke(this, arrayOfObject);
            if (i2 == 0)
              break label190;
            if (paramBoolean)
              i1 = 2;
            this.as = i1;
            if (i6 != 0)
              b();
            return;
            label140: int i3 = 0;
            break;
            int i5 = 0;
            break label27;
            label152: i6 = 0;
            break label37;
            localNoSuchMethodException = localNoSuchMethodException;
            Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", localNoSuchMethodException);
          }
        }
        catch (Exception localException)
        {
          while (true)
          {
            Log.e("ViewPager", "Error changing children drawing order", localException);
            continue;
            label190: this.as = 0;
          }
        }
      }
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.x);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewPager
 * JD-Core Version:    0.6.2
 */