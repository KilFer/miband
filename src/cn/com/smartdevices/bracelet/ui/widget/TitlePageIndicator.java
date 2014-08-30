package cn.com.smartdevices.bracelet.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import com.xiaomi.hm.health.R.styleable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class TitlePageIndicator extends View
  implements PageIndicator
{
  private static final float a = 0.25F;
  private static final float b = 0.05F;
  private static final String c = "";
  private static final int v = -1;
  private Set A = new HashSet();
  private ViewPager d;
  private ViewPager.OnPageChangeListener e;
  private int f = -1;
  private float g;
  private int h;
  private final Paint i = new Paint();
  private boolean j;
  private int k;
  private int l;
  private Path m = new Path();
  private final Rect n = new Rect();
  private final Paint o = new Paint();
  private float p;
  private float q;
  private float r;
  private float s;
  private float t;
  private float u;
  private int w;
  private float x = -1.0F;
  private int y = -1;
  private boolean z;

  public TitlePageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }

  public TitlePageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130772011);
  }

  public TitlePageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (isInEditMode())
      return;
    Resources localResources = getResources();
    int i1 = localResources.getColor(2131230798);
    float f1 = localResources.getDimension(2131296258);
    float f2 = localResources.getDimension(2131296260);
    int i2 = localResources.getColor(2131230799);
    boolean bool = localResources.getBoolean(2131427328);
    int i3 = localResources.getColor(2131230800);
    float f3 = localResources.getDimension(2131296261);
    float f4 = localResources.getDimension(2131296262);
    float f5 = localResources.getDimension(2131296263);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TitlePageIndicator, paramInt, 0);
    this.p = localTypedArray.getDimension(7, f1);
    this.q = localTypedArray.getDimension(9, f2);
    this.u = localTypedArray.getDimension(12, f5);
    this.r = localTypedArray.getDimension(11, f4);
    this.l = localTypedArray.getColor(3, i2);
    this.k = localTypedArray.getColor(1, i3);
    this.j = localTypedArray.getBoolean(10, bool);
    this.s = localTypedArray.getDimension(13, 0.0F);
    this.t = localTypedArray.getDimension(14, 0.0F);
    float f6 = localTypedArray.getDimension(0, f3);
    int i4 = localTypedArray.getColor(5, i1);
    this.i.setTextSize(f6);
    this.i.setAntiAlias(true);
    this.o.setStyle(Paint.Style.FILL_AND_STROKE);
    this.o.setColor(i4);
    Drawable localDrawable = localTypedArray.getDrawable(2);
    if (localDrawable != null)
      setBackground(localDrawable);
    localTypedArray.recycle();
    this.w = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(paramContext));
  }

  private Rect a(int paramInt, Paint paramPaint)
  {
    Rect localRect = new Rect();
    CharSequence localCharSequence = a(paramInt);
    localRect.right = ((int)paramPaint.measureText(localCharSequence, 0, localCharSequence.length()));
    localRect.bottom = ((int)(paramPaint.descent() - paramPaint.ascent()));
    return localRect;
  }

  private CharSequence a(int paramInt)
  {
    Object localObject = this.d.getAdapter().getPageTitle(paramInt);
    if (localObject == null)
      localObject = "";
    return localObject;
  }

  private ArrayList<Rect> a(Paint paramPaint)
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = this.d.getAdapter().getCount();
    int i2 = (getWidth() - (int)this.s - (int)this.t) / i1;
    for (int i3 = 0; ; i3++)
    {
      if (i3 >= i1)
        return localArrayList;
      Rect localRect = a(i3, paramPaint);
      int i4 = localRect.right - localRect.left;
      int i5 = localRect.bottom - localRect.top;
      localRect.left = ((int)this.s + (i2 - i4) / 2 + i3 * i2);
      localRect.right = (i4 + localRect.left);
      localRect.top = 0;
      localRect.bottom = i5;
      localArrayList.add(localRect);
    }
  }

  public void clearBadges()
  {
    this.A.clear();
  }

  public void clearBadges(Integer paramInteger)
  {
    this.A.remove(paramInteger);
  }

  public int getCount()
  {
    if (this.d == null)
      return 0;
    return this.d.getAdapter().getCount();
  }

  public float getFooterIndicatorHeight()
  {
    return this.p;
  }

  public int getOffset()
  {
    return 0;
  }

  public int getSelectedColor()
  {
    return this.l;
  }

  public int getTextColor()
  {
    return this.k;
  }

  public float getTextSize()
  {
    return this.i.getTextSize();
  }

  public float getTitlePadding()
  {
    return this.r;
  }

  public float getTopPadding()
  {
    return this.u;
  }

  public Typeface getTypeface()
  {
    return this.i.getTypeface();
  }

  public boolean isSelectedBold()
  {
    return this.j;
  }

  public void notifyDataSetChanged()
  {
    invalidate();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.d == null);
    int i1;
    do
    {
      return;
      i1 = this.d.getAdapter().getCount();
    }
    while (i1 == 0);
    if ((this.f == -1) && (this.d != null))
      this.f = this.d.getCurrentItem();
    ArrayList localArrayList = a(this.i);
    int i2 = localArrayList.size();
    if (this.f >= i2)
    {
      setCurrentItem(i2 - 1);
      return;
    }
    int i3 = getLeft();
    int i4 = getWidth();
    int i5 = getHeight();
    int i6 = i3 + i4;
    int i7 = this.f;
    int i9;
    float f2;
    int i10;
    if (this.g <= 0.5D)
    {
      float f7 = this.g;
      i9 = i7;
      f2 = f7;
      if (f2 > 0.25F)
        break label344;
      i10 = 1;
      label155: if (f2 > 0.05F)
        break label350;
    }
    float f3;
    int i12;
    int i13;
    label344: label350: for (int i11 = 1; ; i11 = 0)
    {
      f3 = (0.25F - f2) / 0.25F;
      i12 = this.k >>> 24;
      i13 = 0;
      if (i13 < i1)
        break label356;
      float f4 = this.p;
      float f5 = (getWidth() - this.s - this.t) / (1.0F * i1);
      float f6 = this.s + f5 * (this.f + this.g) + f5 / 2.0F;
      this.m.reset();
      this.m.moveTo(f6, i5 - f4);
      this.m.lineTo(f6 + f4, i5);
      this.m.lineTo(f6 - f4, i5);
      this.m.close();
      paramCanvas.drawPath(this.m, this.o);
      return;
      int i8 = i7 + 1;
      float f1 = 1.0F - this.g;
      i9 = i8;
      f2 = f1;
      break;
      i10 = 0;
      break label155;
    }
    label356: Rect localRect1 = (Rect)localArrayList.get(i13);
    int i14;
    label417: CharSequence localCharSequence;
    Paint localPaint;
    if (((localRect1.left > i3) && (localRect1.left < i6)) || ((localRect1.right > i3) && (localRect1.right < i6)))
    {
      if (i13 != i9)
        break label799;
      i14 = 1;
      localCharSequence = a(i13);
      localPaint = this.i;
      if ((i14 == 0) || (i11 == 0) || (!this.j))
        break label805;
    }
    label799: label805: for (boolean bool = true; ; bool = false)
    {
      localPaint.setFakeBoldText(bool);
      this.i.setColor(this.k);
      if ((i14 != 0) && (i10 != 0))
        this.i.setAlpha(i12 - (int)(f3 * i12));
      if (i13 < i2 - 1)
      {
        Rect localRect3 = (Rect)localArrayList.get(i13 + 1);
        if (localRect1.right + this.r > localRect3.left)
        {
          int i16 = localRect1.right - localRect1.left;
          localRect1.left = ((int)(localRect3.left - i16 - this.r));
          localRect1.right = (i16 + localRect1.left);
        }
      }
      paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), localRect1.left, localRect1.bottom + this.u, this.i);
      if ((i14 != 0) && (i10 != 0))
      {
        this.i.setColor(this.l);
        this.i.setAlpha((int)(f3 * (this.l >>> 24)));
        paramCanvas.drawText(localCharSequence, 0, localCharSequence.length(), localRect1.left, localRect1.bottom + this.u, this.i);
      }
      Integer localInteger = Integer.valueOf(i13);
      if (this.A.contains(localInteger))
      {
        Rect localRect2 = a(i13, this.i);
        int i15 = localRect2.right - localRect2.left;
        paramCanvas.drawBitmap(BitmapFactory.decodeResource(getResources(), 2130837515), 5 + (i15 + localRect1.left), localRect1.top + localRect1.height() / 2, null);
      }
      i13++;
      break;
      i14 = 0;
      break label417;
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getSize(paramInt1);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824);
    for (float f1 = View.MeasureSpec.getSize(paramInt2); ; f1 = this.n.bottom - this.n.top + this.q + this.u + this.p)
    {
      setMeasuredDimension(i1, (int)f1);
      return;
      this.n.setEmpty();
      this.n.bottom = ((int)(this.i.descent() - this.i.ascent()));
    }
  }

  public void onPageScrollStateChanged(int paramInt)
  {
    this.h = paramInt;
    if (this.e != null)
      this.e.onPageScrollStateChanged(paramInt);
  }

  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramFloat;
    invalidate();
    if (this.e != null)
      this.e.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }

  public void onPageSelected(int paramInt)
  {
    if (this.h == 0)
    {
      this.f = paramInt;
      invalidate();
    }
    if (this.e != null)
      this.e.onPageSelected(paramInt);
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    TitlePageIndicator.SavedState localSavedState = (TitlePageIndicator.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.f = localSavedState.a;
    requestLayout();
  }

  public Parcelable onSaveInstanceState()
  {
    TitlePageIndicator.SavedState localSavedState = new TitlePageIndicator.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.f;
    return localSavedState;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (super.onTouchEvent(paramMotionEvent));
    float f2;
    do
    {
      float f1;
      do
      {
        return true;
        if ((this.d == null) || (this.d.getAdapter().getCount() == 0))
          return false;
        switch (0xFF & paramMotionEvent.getAction())
        {
        case 4:
        default:
          return true;
        case 0:
          this.y = MotionEventCompat.getPointerId(paramMotionEvent, 0);
          this.x = paramMotionEvent.getX();
          return true;
        case 2:
          f1 = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.y));
          f2 = f1 - this.x;
          if ((!this.z) && (Math.abs(f2) > this.w))
            this.z = true;
          break;
        case 1:
        case 3:
        case 5:
        case 6:
        }
      }
      while (!this.z);
      this.x = f1;
    }
    while ((!this.d.isFakeDragging()) && (!this.d.beginFakeDrag()));
    this.d.fakeDragBy(f2);
    return true;
    ArrayList localArrayList;
    int i4;
    int i5;
    if (!this.z)
    {
      localArrayList = a(this.i);
      i4 = localArrayList.size();
      i5 = (int)paramMotionEvent.getX();
    }
    label312: for (int i6 = 0; ; i6++)
    {
      if (i6 >= i4);
      while (true)
      {
        this.z = false;
        this.y = -1;
        if (!this.d.isFakeDragging())
          break;
        this.d.endFakeDrag();
        return true;
        Rect localRect = (Rect)localArrayList.get(i6);
        if ((i5 <= localRect.left) || (i5 >= localRect.right))
          break label312;
        this.d.setCurrentItem(i6);
      }
    }
    int i3 = MotionEventCompat.getActionIndex(paramMotionEvent);
    this.x = MotionEventCompat.getX(paramMotionEvent, i3);
    this.y = MotionEventCompat.getPointerId(paramMotionEvent, i3);
    return true;
    int i1 = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i1) == this.y)
      if (i1 != 0)
        break label396;
    label396: for (int i2 = 1; ; i2 = 0)
    {
      this.y = MotionEventCompat.getPointerId(paramMotionEvent, i2);
      this.x = MotionEventCompat.getX(paramMotionEvent, MotionEventCompat.findPointerIndex(paramMotionEvent, this.y));
      return true;
    }
  }

  public void setBadges(Integer paramInteger)
  {
    this.A.add(paramInteger);
  }

  public void setCurrentItem(int paramInt)
  {
    if (this.d == null)
      throw new IllegalStateException("ViewPager has not been bound.");
    this.d.setCurrentItem(paramInt);
    this.f = paramInt;
    invalidate();
  }

  public void setFooterColor(int paramInt)
  {
    this.o.setColor(paramInt);
    invalidate();
  }

  public void setFooterIndicatorHeight(float paramFloat)
  {
    this.p = paramFloat;
    invalidate();
  }

  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.e = paramOnPageChangeListener;
  }

  public void setSelectedBold(boolean paramBoolean)
  {
    this.j = paramBoolean;
    invalidate();
  }

  public void setSelectedColor(int paramInt)
  {
    this.l = paramInt;
    invalidate();
  }

  public void setTextColor(int paramInt)
  {
    this.i.setColor(paramInt);
    this.k = paramInt;
    invalidate();
  }

  public void setTextSize(float paramFloat)
  {
    this.i.setTextSize(paramFloat);
    invalidate();
  }

  public void setTitlePadding(float paramFloat)
  {
    this.r = paramFloat;
    invalidate();
  }

  public void setTopPadding(float paramFloat)
  {
    this.u = paramFloat;
    invalidate();
  }

  public void setTypeface(Typeface paramTypeface)
  {
    this.i.setTypeface(paramTypeface);
    invalidate();
  }

  public void setViewPager(ViewPager paramViewPager)
  {
    if (this.d == paramViewPager)
      return;
    if (this.d != null)
      this.d.setOnPageChangeListener(null);
    if (paramViewPager.getAdapter() == null)
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    this.d = paramViewPager;
    this.d.setOnPageChangeListener(this);
    invalidate();
  }

  public void setViewPager(ViewPager paramViewPager, int paramInt)
  {
    setViewPager(paramViewPager);
    setCurrentItem(paramInt);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.widget.TitlePageIndicator
 * JD-Core Version:    0.6.2
 */