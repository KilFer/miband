package cn.com.smartdevices.bracelet.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.xiaomi.hm.health.R.styleable;

public class CirclePageIndicator extends View
  implements PageIndicator
{
  private static final int a = -1;
  private float b;
  private final Paint c = new Paint(1);
  private final Paint d = new Paint(1);
  private final Paint e = new Paint(1);
  private ViewPager f;
  private ViewPager.OnPageChangeListener g;
  private int h;
  private int i;
  private float j;
  private int k;
  private int l;
  private boolean m;
  private boolean n;
  private float o;
  private int p;
  private float q;
  private int r;
  private boolean s;

  public CirclePageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }

  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772008);
  }

  public CirclePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
      return;
    Resources localResources = getResources();
    int i1 = localResources.getColor(2131230802);
    int i2 = localResources.getColor(2131230801);
    int i3 = localResources.getInteger(2131361794);
    int i4 = localResources.getColor(2131230803);
    float f1 = localResources.getDimension(2131296265);
    float f2 = localResources.getDimension(2131296264);
    boolean bool1 = localResources.getBoolean(2131427329);
    boolean bool2 = localResources.getBoolean(2131427330);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CirclePageIndicator, paramInt, 0);
    this.m = localTypedArray.getBoolean(2, bool1);
    this.l = localTypedArray.getInt(0, i3);
    this.c.setStyle(Paint.Style.FILL);
    this.c.setColor(localTypedArray.getColor(5, i1));
    this.d.setStyle(Paint.Style.STROKE);
    this.d.setColor(localTypedArray.getColor(8, i4));
    this.d.setStrokeWidth(localTypedArray.getDimension(3, f1));
    this.e.setStyle(Paint.Style.FILL);
    this.e.setColor(localTypedArray.getColor(4, i2));
    this.b = localTypedArray.getDimension(6, f2);
    this.n = localTypedArray.getBoolean(7, bool2);
    this.o = localTypedArray.getDimension(9, 12.0F);
    Drawable localDrawable = localTypedArray.getDrawable(1);
    if (localDrawable != null)
      setBackgroundDrawable(localDrawable);
    localTypedArray.recycle();
    ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }

  private int a(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    int i3;
    if ((i1 == 1073741824) || (this.f == null))
      i3 = i2;
    do
    {
      return i3;
      int i4 = getCount();
      i3 = (int)(1.0F + (getPaddingLeft() + getPaddingRight() + (i4 << 1) * this.b + (i4 - 1) * this.o));
    }
    while (i1 != -2147483648);
    return Math.min(i3, i2);
  }

  private int b(int paramInt)
  {
    int i1 = View.MeasureSpec.getMode(paramInt);
    int i2 = View.MeasureSpec.getSize(paramInt);
    if (i1 == 1073741824)
      return i2;
    int i3 = (int)(1.0F + (2.0F * this.b + getPaddingTop() + getPaddingBottom()));
    if (i1 == -2147483648)
      return Math.min(i3, i2);
    return i3;
  }

  public int getCount()
  {
    if (this.f == null)
      return 0;
    return this.f.getAdapter().getCount();
  }

  public int getFillColor()
  {
    return this.e.getColor();
  }

  public int getOffset()
  {
    return 0;
  }

  public int getOrientation()
  {
    return this.l;
  }

  public int getPageColor()
  {
    return this.c.getColor();
  }

  public float getRadius()
  {
    return this.b;
  }

  public int getStrokeColor()
  {
    return this.d.getColor();
  }

  public float getStrokeWidth()
  {
    return this.d.getStrokeWidth();
  }

  public ViewPager getViewPager()
  {
    return this.f;
  }

  public boolean isCentered()
  {
    return this.m;
  }

  public boolean isSnap()
  {
    return this.n;
  }

  public void notifyDataSetChanged()
  {
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.f == null);
    int i1;
    do
    {
      return;
      i1 = getCount();
    }
    while (i1 == 0);
    if (this.h < 0)
      setCurrentItem(0);
    if (this.h >= i1)
    {
      setCurrentItem(i1 - 1);
      return;
    }
    int i2;
    int i3;
    int i4;
    int i5;
    float f1;
    float f2;
    float f3;
    int i6;
    int i7;
    label207: float f6;
    float f7;
    if (this.l == 0)
    {
      i2 = getWidth();
      i3 = getPaddingLeft();
      i4 = getPaddingRight();
      i5 = getPaddingTop();
      f1 = i5 + this.b;
      f2 = i3 + this.b;
      if (this.m)
      {
        int i8 = (int)(1.0F + ((i1 << 1) * this.b + (i1 - 1) * this.o));
        f2 += (i2 - i3 - i4 - i8) / 2.0F;
      }
      f3 = this.b;
      boolean bool = this.d.getStrokeWidth() < 0.0F;
      i6 = 0;
      if (bool)
        f3 -= this.d.getStrokeWidth() / 2.0F;
      if (i6 < i1)
        break label317;
      if (!this.n)
        break label415;
      i7 = this.i;
      f6 = i7 * (this.o + 2.0F * this.b);
      if (!this.n)
        f6 += this.j * (this.o + 2.0F * this.b);
      if (this.l != 0)
        break label424;
      float f8 = f2 + f6;
      f7 = f1;
      f1 = f8;
    }
    while (true)
    {
      paramCanvas.drawCircle(f1, f7, this.b, this.e);
      return;
      i2 = getHeight();
      i3 = getPaddingTop();
      i4 = getPaddingBottom();
      i5 = getPaddingLeft();
      break;
      label317: float f4 = f2 + i6 * (this.o + 2.0F * this.b);
      float f5;
      if (this.l == 0)
        f5 = f1;
      while (true)
      {
        if (this.c.getAlpha() > 0)
          paramCanvas.drawCircle(f4, f5, f3, this.c);
        if (f3 != this.b)
          paramCanvas.drawCircle(f4, f5, this.b, this.d);
        i6++;
        break;
        f5 = f4;
        f4 = f1;
      }
      label415: i7 = this.h;
      break label207;
      label424: f7 = f2 + f6;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.l == 0)
    {
      setMeasuredDimension(a(paramInt1), b(paramInt2));
      return;
    }
    setMeasuredDimension(b(paramInt1), a(paramInt2));
  }

  public void onPageScrollStateChanged(int paramInt)
  {
    this.k = paramInt;
    if (this.g != null)
      this.g.onPageScrollStateChanged(paramInt);
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.h = (paramInt1 - getOffset());
    this.j = paramFloat;
    invalidate();
    if (this.g != null)
      this.g.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }

  public void onPageSelected(int paramInt)
  {
    if ((this.n) || (this.k == 0))
    {
      this.h = (paramInt - getOffset());
      this.i = (paramInt - getOffset());
      invalidate();
    }
    if (this.g != null)
      this.g.onPageSelected(paramInt);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    CirclePageIndicator.SavedState localSavedState = (CirclePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.h = localSavedState.a;
    this.i = localSavedState.a;
    requestLayout();
  }

  public Parcelable onSaveInstanceState()
  {
    CirclePageIndicator.SavedState localSavedState = new CirclePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.h;
    return localSavedState;
  }

  public void setCentered(boolean paramBoolean)
  {
    this.m = paramBoolean;
    invalidate();
  }

  public void setCurrentItem(int paramInt)
  {
    if (this.f == null)
      throw new IllegalStateException("ViewPager has not been bound.");
    this.f.setCurrentItem(paramInt + getOffset());
    this.h = paramInt;
    invalidate();
  }

  public void setFillColor(int paramInt)
  {
    this.e.setColor(paramInt);
    invalidate();
  }

  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.g = paramOnPageChangeListener;
  }

  public void setOrientation(int paramInt)
  {
    switch (paramInt)
    {
    default:
      throw new IllegalArgumentException("Orientation must be either HORIZONTAL or VERTICAL.");
    case 0:
    case 1:
    }
    this.l = paramInt;
    requestLayout();
  }

  public void setPageColor(int paramInt)
  {
    this.c.setColor(paramInt);
    invalidate();
  }

  public void setRadius(float paramFloat)
  {
    this.b = paramFloat;
    invalidate();
  }

  public void setSnap(boolean paramBoolean)
  {
    this.n = paramBoolean;
    invalidate();
  }

  public void setStrokeColor(int paramInt)
  {
    this.d.setColor(paramInt);
    invalidate();
  }

  public void setStrokeWidth(float paramFloat)
  {
    this.d.setStrokeWidth(paramFloat);
    invalidate();
  }

  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.f == paramViewPager)
      return;
    if (this.f != null)
      this.f.setOnPageChangeListener(null);
    if (paramViewPager.getAdapter() == null)
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    this.f = paramViewPager;
    this.f.setOnPageChangeListener(this);
    invalidate();
  }

  public void setViewPager(ViewPager paramViewPager, int paramInt)
  {
    setViewPager(paramViewPager);
    setCurrentItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.widget.CirclePageIndicator
 * JD-Core Version:    0.6.2
 */