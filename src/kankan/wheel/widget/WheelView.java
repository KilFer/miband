package kankan.wheel.widget;

import android.content.Context;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import cn.com.smartdevices.bracelet.Debug;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kankan.wheel.widget.adapters.WheelViewAdapter;

public class WheelView extends View
{
  private static final int[] a;
  private static final int b = 10;
  private static final int c = 10;
  private static final int d = 5;
  private static final String e = "WheelView";
  private float A = 80.0F;
  private WheelScroller.ScrollingListener B = new c(this);
  private DataSetObserver C = new d(this);
  private int f = 0;
  private int g = 5;
  private int h = 0;
  private Drawable i;
  private GradientDrawable j;
  private GradientDrawable k;
  private WheelScroller l;
  private boolean m;
  private int n;
  private boolean o = false;
  private LinearLayout p;
  private int q;
  private WheelViewAdapter r;
  private WheelRecycle s = new WheelRecycle(this);
  private List<OnWheelChangedListener> t = new LinkedList();
  private List<OnWheelScrollListener> u = new LinkedList();
  private List<OnWheelClickedListener> v = new LinkedList();
  private int w = 2130837684;
  private Paint x;
  private String y = "";
  private float z = 50.0F;

  static
  {
    new int[] { -15658735, 11184810, 11184810 };
  }

  public WheelView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public WheelView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public WheelView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private int a(int paramInt1, int paramInt2)
  {
    if (this.i == null)
      this.i = getContext().getResources().getDrawable(this.w);
    if (this.j == null)
      this.j = new GradientDrawable();
    if (this.k == null)
      this.k = new GradientDrawable();
    this.p.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    this.p.measure(View.MeasureSpec.makeMeasureSpec(paramInt1, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int i1 = this.p.getMeasuredWidth();
    if (paramInt2 == 1073741824);
    while (true)
    {
      this.p.measure(View.MeasureSpec.makeMeasureSpec(paramInt1 - 20, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      return paramInt1;
      int i2 = Math.max(i1 + 20, getSuggestedMinimumWidth());
      if ((paramInt2 != -2147483648) || (paramInt1 >= i2))
        paramInt1 = i2;
    }
  }

  private int a(LinearLayout paramLinearLayout)
  {
    if ((paramLinearLayout != null) && (paramLinearLayout.getChildAt(0) != null))
      this.h = paramLinearLayout.getChildAt(0).getMeasuredHeight();
    return Math.max(this.h * this.g - 10 * this.h / 50, getSuggestedMinimumHeight());
  }

  private void a()
  {
    this.l = new WheelScroller(getContext(), this.B);
    this.x = new Paint();
    addChangingListener(new e(this));
  }

  private void a(int paramInt)
  {
    this.n = (paramInt + this.n);
    int i1 = c();
    int i2 = this.n / i1;
    int i3 = this.f - i2;
    int i4 = this.r.getItemsCount();
    int i5 = this.n % i1;
    if (Math.abs(i5) <= i1 / 2)
      i5 = 0;
    int i9;
    int i7;
    if ((this.o) && (i4 > 0))
      if (i5 > 0)
      {
        int i12 = i3 - 1;
        int i13 = i2 + 1;
        i9 = i12;
        i7 = i13;
      }
    while (true)
    {
      int i6;
      if (i9 >= 0)
        i6 = i9 % i4;
      while (true)
      {
        label111: int i8 = this.n;
        if (i6 != this.f)
          setCurrentItem(i6, false);
        while (true)
        {
          this.n = (i8 - i7 * i1);
          if (this.n > getHeight())
            this.n = (this.n % getHeight() + getHeight());
          return;
          if (i5 >= 0)
            break label324;
          int i10 = i3 + 1;
          int i11 = i2 - 1;
          i9 = i10;
          i7 = i11;
          break;
          i9 += i4;
          break;
          if (i3 < 0)
          {
            i7 = this.f;
            i6 = 0;
            break label111;
          }
          if (i3 >= i4)
          {
            i7 = 1 + (this.f - i4);
            i6 = i4 - 1;
            break label111;
          }
          if ((i3 > 0) && (i5 > 0))
          {
            i6 = i3 - 1;
            i7 = i2 + 1;
            break label111;
          }
          if ((i3 >= i4 - 1) || (i5 >= 0))
            break label314;
          i6 = i3 + 1;
          i7 = i2 - 1;
          break label111;
          invalidate();
        }
        label314: i6 = i3;
        i7 = i2;
      }
      label324: i9 = i3;
      i7 = i2;
    }
  }

  private void a(Canvas paramCanvas)
  {
    int i1 = (int)(1.5D * c());
    this.j.setBounds(0, 0, getWidth(), i1);
    this.j.draw(paramCanvas);
    this.k.setBounds(0, getHeight() - i1, getWidth(), getHeight());
    this.k.draw(paramCanvas);
  }

  private boolean a(int paramInt, boolean paramBoolean)
  {
    View localView;
    boolean bool;
    if ((this.r == null) || (this.r.getItemsCount() == 0))
    {
      localView = null;
      bool = false;
      if (localView != null)
      {
        if (!paramBoolean)
          break label131;
        this.p.addView(localView, 0);
      }
    }
    while (true)
    {
      bool = true;
      return bool;
      int i1 = this.r.getItemsCount();
      if (!b(paramInt))
      {
        localView = this.r.getEmptyItem(this.s.getEmptyItem(), this.p);
        break;
      }
      while (paramInt < 0)
        paramInt += i1;
      int i2 = paramInt % i1;
      localView = this.r.getItem(i2, this.s.getItem(), this.p);
      break;
      label131: this.p.addView(localView);
    }
  }

  private void b()
  {
    if (this.i == null)
      this.i = getContext().getResources().getDrawable(this.w);
    if (this.j == null)
      this.j = new GradientDrawable();
    if (this.k == null)
      this.k = new GradientDrawable();
  }

  private void b(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 - 20;
    this.p.layout(0, 0, i1, paramInt2);
  }

  private void b(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.translate(10.0F, -((this.f - this.q) * c() + (c() - getHeight()) / 2) + this.n);
    this.p.draw(paramCanvas);
    paramCanvas.restore();
  }

  private boolean b(int paramInt)
  {
    return (this.r != null) && (this.r.getItemsCount() > 0) && ((this.o) || ((paramInt >= 0) && (paramInt < this.r.getItemsCount())));
  }

  private int c()
  {
    if (this.h != 0)
      return this.h;
    if ((this.p != null) && (this.p.getChildAt(0) != null))
    {
      this.h = this.p.getChildAt(0).getHeight();
      return this.h;
    }
    return getHeight() / this.g;
  }

  private View c(int paramInt)
  {
    if ((this.r == null) || (this.r.getItemsCount() == 0))
      return null;
    int i1 = this.r.getItemsCount();
    if (!b(paramInt))
      return this.r.getEmptyItem(this.s.getEmptyItem(), this.p);
    while (paramInt < 0)
      paramInt += i1;
    int i2 = paramInt % i1;
    return this.r.getItem(i2, this.s.getItem(), this.p);
  }

  private void c(Canvas paramCanvas)
  {
    int i1 = getHeight() / 2;
    int i2 = (int)(1.2D * (c() / 2));
    this.i.setBounds(0, i1 - i2, getWidth(), i2 + i1);
    paramCanvas.drawText(this.y, getWidth() / 2 + this.A, i1 - this.z, this.x);
    this.i.draw(paramCanvas);
  }

  private ItemsRange d()
  {
    if (c() == 0)
      return null;
    int i1 = this.f;
    for (int i2 = 1; ; i2 += 2)
    {
      if (i2 * c() >= getHeight())
      {
        if (this.n != 0)
        {
          if (this.n > 0)
            i1--;
          int i3 = i2 + 1;
          int i4 = this.n / c();
          i1 -= i4;
          i2 = (int)(i3 + Math.asin(i4));
        }
        return new ItemsRange(i1, i2);
      }
      i1--;
    }
  }

  private boolean e()
  {
    ItemsRange localItemsRange;
    boolean bool;
    label46: label52: label85: int i5;
    label115: label124: int i3;
    if (c() == 0)
    {
      localItemsRange = null;
      if (this.p == null)
        break label255;
      int i6 = this.s.recycleItems(this.p, this.q, localItemsRange);
      if (this.q == i6)
        break label249;
      bool = true;
      this.q = i6;
      if (!bool)
      {
        if ((this.q != localItemsRange.getFirst()) || (this.p.getChildCount() != localItemsRange.getCount()))
          break label265;
        bool = false;
      }
      if ((this.q <= localItemsRange.getFirst()) || (this.q > localItemsRange.getLast()))
        break label293;
      i5 = -1 + this.q;
      if (i5 >= localItemsRange.getFirst())
        break label271;
      i3 = this.q;
    }
    for (int i4 = this.p.getChildCount(); ; i4++)
    {
      if (i4 >= localItemsRange.getCount())
      {
        this.q = i3;
        return bool;
        int i1 = this.f;
        for (int i2 = 1; ; i2 += 2)
        {
          if (i2 * c() >= getHeight())
          {
            if (this.n != 0)
            {
              if (this.n > 0)
                i1--;
              int i7 = i2 + 1;
              int i8 = this.n / c();
              i1 -= i8;
              i2 = (int)(i7 + Math.asin(i8));
            }
            localItemsRange = new ItemsRange(i1, i2);
            break;
          }
          i1--;
        }
        label249: bool = false;
        break label46;
        label255: g();
        bool = true;
        break label52;
        label265: bool = true;
        break label85;
        label271: if (!a(i5, true))
          break label124;
        this.q = i5;
        i5--;
        break label115;
        label293: this.q = localItemsRange.getFirst();
        break label124;
      }
      if ((!a(i4 + this.q, false)) && (this.p.getChildCount() == 0))
        i3++;
    }
  }

  private void f()
  {
    ItemsRange localItemsRange;
    int i3;
    label46: label52: label85: int i6;
    label115: label124: int i4;
    if (c() == 0)
    {
      localItemsRange = null;
      if (this.p == null)
        break label281;
      int i7 = this.s.recycleItems(this.p, this.q, localItemsRange);
      if (this.q == i7)
        break label275;
      i3 = 1;
      this.q = i7;
      if (i3 == 0)
      {
        if ((this.q != localItemsRange.getFirst()) || (this.p.getChildCount() != localItemsRange.getCount()))
          break label291;
        i3 = 0;
      }
      if ((this.q <= localItemsRange.getFirst()) || (this.q > localItemsRange.getLast()))
        break label319;
      i6 = -1 + this.q;
      if (i6 >= localItemsRange.getFirst())
        break label297;
      i4 = this.q;
    }
    for (int i5 = this.p.getChildCount(); ; i5++)
    {
      if (i5 >= localItemsRange.getCount())
      {
        this.q = i4;
        if (i3 != 0)
        {
          a(getWidth(), 1073741824);
          b(getWidth(), getHeight());
        }
        return;
        int i1 = this.f;
        for (int i2 = 1; ; i2 += 2)
        {
          if (i2 * c() >= getHeight())
          {
            if (this.n != 0)
            {
              if (this.n > 0)
                i1--;
              int i8 = i2 + 1;
              int i9 = this.n / c();
              i1 -= i9;
              i2 = (int)(i8 + Math.asin(i9));
            }
            localItemsRange = new ItemsRange(i1, i2);
            break;
          }
          i1--;
        }
        label275: i3 = 0;
        break label46;
        label281: g();
        i3 = 1;
        break label52;
        label291: i3 = 1;
        break label85;
        label297: if (!a(i6, true))
          break label124;
        this.q = i6;
        i6--;
        break label115;
        label319: this.q = localItemsRange.getFirst();
        break label124;
      }
      if ((!a(i5 + this.q, false)) && (this.p.getChildCount() == 0))
        i4++;
    }
  }

  private void g()
  {
    if (this.p == null)
    {
      this.p = new LinearLayout(getContext());
      this.p.setOrientation(1);
    }
  }

  private void h()
  {
    int i1;
    if (this.p != null)
    {
      this.s.recycleItems(this.p, this.q, new ItemsRange());
      i1 = this.g / 2;
    }
    for (int i2 = i1 + this.f; ; i2--)
    {
      if (i2 < this.f - i1)
      {
        return;
        g();
        break;
      }
      if (a(i2, true))
        this.q = i2;
    }
  }

  public void addChangingListener(OnWheelChangedListener paramOnWheelChangedListener)
  {
    this.t.add(paramOnWheelChangedListener);
  }

  public void addClickingListener(OnWheelClickedListener paramOnWheelClickedListener)
  {
    this.v.add(paramOnWheelClickedListener);
  }

  public void addScrollingListener(OnWheelScrollListener paramOnWheelScrollListener)
  {
    this.u.add(paramOnWheelScrollListener);
  }

  public int getCurrentItem()
  {
    if ((this.r != null) && (this.r.isNeedLoop()))
      return this.f % this.r.getBASE_BUNDLE();
    return this.f;
  }

  public int getRealCurrentItem()
  {
    return this.f;
  }

  public WheelViewAdapter getViewAdapter()
  {
    return this.r;
  }

  public int getVisibleItems()
  {
    return this.g;
  }

  public void invalidateWheel(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.s.clearAll();
      if (this.p != null)
        this.p.removeAllViews();
      this.n = 0;
    }
    while (true)
    {
      invalidate();
      return;
      if (this.p != null)
        this.s.recycleItems(this.p, this.q, new ItemsRange());
    }
  }

  public boolean isCyclic()
  {
    return this.o;
  }

  protected void notifyChangingListeners(int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.t.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((OnWheelChangedListener)localIterator.next()).onChanged(this, paramInt1, paramInt2);
    }
  }

  protected void notifyClickListenersAboutClick(int paramInt)
  {
    Iterator localIterator = this.v.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((OnWheelClickedListener)localIterator.next()).onItemClicked(this, paramInt);
    }
  }

  protected void notifyScrollingListenersAboutEnd()
  {
    Iterator localIterator = this.u.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((OnWheelScrollListener)localIterator.next()).onScrollingFinished(this);
    }
  }

  protected void notifyScrollingListenersAboutStart()
  {
    Iterator localIterator = this.u.iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ((OnWheelScrollListener)localIterator.next()).onScrollingStarted(this);
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    ItemsRange localItemsRange;
    int i4;
    label72: label78: label113: int i9;
    label145: label155: int i5;
    if ((this.r != null) && (this.r.getItemsCount() > 0))
    {
      if (c() != 0)
        break label419;
      localItemsRange = null;
      if (this.p == null)
        break label523;
      int i10 = this.s.recycleItems(this.p, this.q, localItemsRange);
      if (this.q == i10)
        break label517;
      i4 = 1;
      this.q = i10;
      if (i4 == 0)
      {
        if ((this.q != localItemsRange.getFirst()) || (this.p.getChildCount() != localItemsRange.getCount()))
          break label533;
        i4 = 0;
      }
      if ((this.q <= localItemsRange.getFirst()) || (this.q > localItemsRange.getLast()))
        break label561;
      i9 = -1 + this.q;
      if (i9 >= localItemsRange.getFirst())
        break label539;
      i5 = this.q;
    }
    for (int i6 = this.p.getChildCount(); ; i6++)
    {
      if (i6 >= localItemsRange.getCount())
      {
        this.q = i5;
        if (i4 != 0)
        {
          a(getWidth(), 1073741824);
          b(getWidth(), getHeight());
        }
        paramCanvas.save();
        paramCanvas.translate(10.0F, -((this.f - this.q) * c() + (c() - getHeight()) / 2) + this.n);
        this.p.draw(paramCanvas);
        paramCanvas.restore();
        int i7 = getHeight() / 2;
        int i8 = (int)(1.2D * (c() / 2));
        this.i.setBounds(0, i7 - i8, getWidth(), i8 + i7);
        paramCanvas.drawText(this.y, getWidth() / 2 + this.A, i7 - this.z, this.x);
        this.i.draw(paramCanvas);
        int i1 = (int)(1.5D * c());
        this.j.setBounds(0, 0, getWidth(), i1);
        this.j.draw(paramCanvas);
        this.k.setBounds(0, getHeight() - i1, getWidth(), getHeight());
        this.k.draw(paramCanvas);
        return;
        label419: int i2 = this.f;
        for (int i3 = 1; ; i3 += 2)
        {
          if (i3 * c() >= getHeight())
          {
            if (this.n != 0)
            {
              if (this.n > 0)
                i2--;
              int i11 = i3 + 1;
              int i12 = this.n / c();
              i2 -= i12;
              i3 = (int)(i11 + Math.asin(i12));
            }
            localItemsRange = new ItemsRange(i2, i3);
            break;
          }
          i2--;
        }
        label517: i4 = 0;
        break label72;
        label523: g();
        i4 = 1;
        break label78;
        label533: i4 = 1;
        break label113;
        label539: if (!a(i9, true))
          break label155;
        this.q = i9;
        i9--;
        break label145;
        label561: this.q = localItemsRange.getFirst();
        break label155;
      }
      if ((!a(i6 + this.q, false)) && (this.p.getChildCount() == 0))
        i5++;
    }
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    b(paramInt3 - paramInt1, paramInt4 - paramInt2);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    int i6;
    label70: int i7;
    int i8;
    if (this.p != null)
    {
      this.s.recycleItems(this.p, this.q, new ItemsRange());
      int i5 = this.g / 2;
      i6 = i5 + this.f;
      if (i6 >= this.f - i5)
        break label118;
      i7 = a(i3, i1);
      if (i2 != 1073741824)
        break label140;
      i8 = i4;
    }
    while (true)
    {
      setMeasuredDimension(i7, i8);
      return;
      g();
      break;
      label118: if (a(i6, true))
        this.q = i6;
      i6--;
      break label70;
      label140: LinearLayout localLinearLayout = this.p;
      if ((localLinearLayout != null) && (localLinearLayout.getChildAt(0) != null))
        this.h = localLinearLayout.getChildAt(0).getMeasuredHeight();
      i8 = Math.max(this.h * this.g - 10 * this.h / 50, getSuggestedMinimumHeight());
      if (i2 == -2147483648)
        i8 = Math.min(i8, i4);
    }
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!isEnabled()) || (getViewAdapter() == null))
      return true;
    switch (paramMotionEvent.getAction())
    {
    default:
    case 2:
    case 1:
    }
    do
      while (true)
      {
        return this.l.onTouchEvent(paramMotionEvent);
        if (getParent() != null)
          getParent().requestDisallowInterceptTouchEvent(true);
      }
    while (this.m);
    int i1 = (int)paramMotionEvent.getY() - getHeight() / 2;
    if (i1 > 0);
    for (int i2 = i1 + c() / 2; ; i2 = i1 - c() / 2)
    {
      int i3 = i2 / c();
      if ((i3 == 0) || (!b(i3 + this.f)))
        break;
      notifyClickListenersAboutClick(i3 + this.f);
      break;
    }
  }

  public void removeChangingListener(OnWheelChangedListener paramOnWheelChangedListener)
  {
    this.t.remove(paramOnWheelChangedListener);
  }

  public void removeClickingListener(OnWheelClickedListener paramOnWheelClickedListener)
  {
    this.v.remove(paramOnWheelClickedListener);
  }

  public void removeScrollingListener(OnWheelScrollListener paramOnWheelScrollListener)
  {
    this.u.remove(paramOnWheelScrollListener);
  }

  public void scroll(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1 * c() - this.n;
    this.l.scroll(i1, paramInt2);
  }

  public WheelView setCenterDrawable(int paramInt)
  {
    this.w = paramInt;
    if (this.i == null)
      this.i = getContext().getResources().getDrawable(this.w);
    invalidate();
    return this;
  }

  public WheelView setCenterStyle(String paramString, float paramFloat)
  {
    return setCenterStyle(paramString, 2131230780, 10, paramFloat, 1.5F);
  }

  public WheelView setCenterStyle(String paramString, int paramInt, float paramFloat)
  {
    return setCenterStyle(paramString, paramInt, 10, paramFloat, 1.5F);
  }

  public WheelView setCenterStyle(String paramString, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.y = paramString;
    this.A = TypedValue.applyDimension(1, paramFloat1, getResources().getDisplayMetrics());
    this.z = TypedValue.applyDimension(1, paramFloat2, getResources().getDisplayMetrics());
    float f1 = TypedValue.applyDimension(1, paramInt2, getResources().getDisplayMetrics());
    this.x.setTextSize(f1);
    this.x.setFakeBoldText(false);
    this.x.setAntiAlias(true);
    this.x.setColor(getResources().getColor(paramInt1));
    return this;
  }

  public WheelView setCurrentItem(int paramInt)
  {
    setCurrentItem(paramInt, false);
    return this;
  }

  public void setCurrentItem(int paramInt, boolean paramBoolean)
  {
    if ((this.r == null) || (this.r.getItemsCount() == 0));
    int i1;
    do
    {
      do
      {
        return;
        i1 = this.r.getItemsCount();
        if ((paramInt >= 0) && (paramInt < i1))
          break;
      }
      while (!this.o);
      if (paramInt < 0)
        break;
      paramInt %= i1;
    }
    while (paramInt == this.f);
    int i3;
    int i4;
    if (paramBoolean)
    {
      i3 = paramInt - this.f;
      if (!this.o)
        break label171;
      i4 = i1 + Math.min(paramInt, this.f) - Math.max(paramInt, this.f);
      if (i4 >= Math.abs(i3))
        break label171;
      if (i3 >= 0);
    }
    while (true)
    {
      scroll(i4, 0);
      return;
      paramInt += i1;
      break;
      i4 = -i4;
      continue;
      this.n = 0;
      int i2 = this.f;
      this.f = paramInt;
      notifyChangingListeners(i2, this.f);
      invalidate();
      return;
      label171: i4 = i3;
    }
  }

  public WheelView setCurrentItemLooped(int paramInt)
  {
    if (this.r.isNeedLoop())
    {
      Debug.i("WheelView", "setCurrentItemLooped: " + paramInt);
      paramInt += this.r.getInitLoopBase();
      Debug.i("WheelView", ", after add loopbase:" + paramInt);
    }
    setCurrentItem(paramInt, false);
    return this;
  }

  public void setCyclic(boolean paramBoolean)
  {
    this.o = paramBoolean;
    invalidateWheel(false);
  }

  public void setInterpolator(Interpolator paramInterpolator)
  {
    this.l.setInterpolator(paramInterpolator);
  }

  public WheelView setViewAdapter(WheelViewAdapter paramWheelViewAdapter)
  {
    if (this.r != null)
      this.r.unregisterDataSetObserver(this.C);
    this.r = paramWheelViewAdapter;
    if (this.r != null)
      this.r.registerDataSetObserver(this.C);
    invalidateWheel(true);
    return this;
  }

  public WheelView setVisibleItems(int paramInt)
  {
    this.g = paramInt;
    return this;
  }

  public void stopScrolling()
  {
    this.l.stopScrolling();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     kankan.wheel.widget.WheelView
 * JD-Core Version:    0.6.2
 */