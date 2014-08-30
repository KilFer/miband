package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.xiaomi.hm.health.R.styleable;
import java.util.Locale;

public class PagerSlidingTabStrip extends HorizontalScrollView
{
  private static final int[] a = { 16842901, 16842904 };
  private int A = 0;
  private int B = 2130837514;
  private Locale C;
  private LinearLayout.LayoutParams b;
  private LinearLayout.LayoutParams c;
  private final q d = new q(this, (byte)0);
  public ViewPager.OnPageChangeListener delegatePageListener;
  private LinearLayout e;
  private ViewPager f;
  private int g;
  private int h = 0;
  private float i = 0.0F;
  private Paint j;
  private Paint k;
  private int l = -10066330;
  private int m = 436207616;
  private int n = 436207616;
  private boolean o = false;
  private boolean p = true;
  private int q = 52;
  private int r = 8;
  private int s = 2;
  private int t = 12;
  private int u = 24;
  private int v = 1;
  private int w = 12;
  private int x = -10066330;
  private Typeface y = null;
  private int z = 1;

  public PagerSlidingTabStrip(Context paramContext)
  {
    this(paramContext, null);
  }

  public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PagerSlidingTabStrip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setFillViewport(true);
    setWillNotDraw(false);
    this.e = new LinearLayout(paramContext);
    this.e.setOrientation(0);
    this.e.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
    addView(this.e);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.q = ((int)TypedValue.applyDimension(1, this.q, localDisplayMetrics));
    this.r = ((int)TypedValue.applyDimension(1, this.r, localDisplayMetrics));
    this.s = ((int)TypedValue.applyDimension(1, this.s, localDisplayMetrics));
    this.t = ((int)TypedValue.applyDimension(1, this.t, localDisplayMetrics));
    this.u = ((int)TypedValue.applyDimension(1, this.u, localDisplayMetrics));
    this.v = ((int)TypedValue.applyDimension(1, this.v, localDisplayMetrics));
    this.w = ((int)TypedValue.applyDimension(2, this.w, localDisplayMetrics));
    TypedArray localTypedArray1 = paramContext.obtainStyledAttributes(paramAttributeSet, a);
    this.w = localTypedArray1.getDimensionPixelSize(0, this.w);
    this.x = localTypedArray1.getColor(1, this.x);
    localTypedArray1.recycle();
    TypedArray localTypedArray2 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PagerSlidingTabStrip);
    this.l = localTypedArray2.getColor(0, this.l);
    this.m = localTypedArray2.getColor(1, this.m);
    this.n = localTypedArray2.getColor(2, this.n);
    this.r = localTypedArray2.getDimensionPixelSize(3, this.r);
    this.s = localTypedArray2.getDimensionPixelSize(4, this.s);
    this.t = localTypedArray2.getDimensionPixelSize(5, this.t);
    this.u = localTypedArray2.getDimensionPixelSize(6, this.u);
    this.B = localTypedArray2.getResourceId(8, this.B);
    this.o = localTypedArray2.getBoolean(9, this.o);
    this.q = localTypedArray2.getDimensionPixelSize(7, this.q);
    this.p = localTypedArray2.getBoolean(10, this.p);
    localTypedArray2.recycle();
    this.j = new Paint();
    this.j.setAntiAlias(true);
    this.j.setStyle(Paint.Style.FILL);
    this.k = new Paint();
    this.k.setAntiAlias(true);
    this.k.setStrokeWidth(this.v);
    this.b = new LinearLayout.LayoutParams(-2, -1);
    this.c = new LinearLayout.LayoutParams(0, -1, 1.0F);
    if (this.C == null)
      this.C = getResources().getConfiguration().locale;
  }

  private void a()
  {
    int i1 = 0;
    if (i1 >= this.g)
      return;
    View localView = this.e.getChildAt(i1);
    localView.setBackgroundResource(this.B);
    TextView localTextView;
    if ((localView instanceof TextView))
    {
      localTextView = (TextView)localView;
      localTextView.setTextSize(0, this.w);
      localTextView.setTypeface(this.y, this.z);
      localTextView.setTextColor(this.x);
      if (this.p)
      {
        if (Build.VERSION.SDK_INT < 14)
          break label96;
        localTextView.setAllCaps(true);
      }
    }
    while (true)
    {
      i1++;
      break;
      label96: localTextView.setText(localTextView.getText().toString().toUpperCase(this.C));
    }
  }

  private void a(int paramInt1, int paramInt2)
  {
    ImageButton localImageButton = new ImageButton(getContext());
    localImageButton.setImageResource(paramInt2);
    a(paramInt1, localImageButton);
  }

  private void a(int paramInt, View paramView)
  {
    paramView.setFocusable(true);
    paramView.setOnClickListener(new p(this, paramInt));
    paramView.setPadding(this.u, 0, this.u, 0);
    LinearLayout localLinearLayout = this.e;
    if (this.o);
    for (LinearLayout.LayoutParams localLayoutParams = this.c; ; localLayoutParams = this.b)
    {
      localLinearLayout.addView(paramView, paramInt, localLayoutParams);
      return;
    }
  }

  private void a(int paramInt, String paramString)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setText(paramString);
    localTextView.setGravity(17);
    localTextView.setSingleLine();
    a(paramInt, localTextView);
  }

  private void b(int paramInt1, int paramInt2)
  {
    if (this.g == 0);
    int i1;
    do
    {
      return;
      i1 = paramInt2 + this.e.getChildAt(paramInt1).getLeft();
      if ((paramInt1 > 0) || (paramInt2 > 0))
        i1 -= this.q;
    }
    while (i1 == this.A);
    this.A = i1;
    scrollTo(i1, 0);
  }

  public int getDividerColor()
  {
    return this.n;
  }

  public int getDividerPadding()
  {
    return this.t;
  }

  public int getIndicatorColor()
  {
    return this.l;
  }

  public int getIndicatorHeight()
  {
    return this.r;
  }

  public int getScrollOffset()
  {
    return this.q;
  }

  public boolean getShouldExpand()
  {
    return this.o;
  }

  public int getTabBackground()
  {
    return this.B;
  }

  public int getTabPaddingLeftRight()
  {
    return this.u;
  }

  public int getTextColor()
  {
    return this.x;
  }

  public int getTextSize()
  {
    return this.w;
  }

  public int getUnderlineColor()
  {
    return this.m;
  }

  public int getUnderlineHeight()
  {
    return this.s;
  }

  public boolean isTextAllCaps()
  {
    return this.p;
  }

  public void notifyDataSetChanged()
  {
    this.e.removeAllViews();
    this.g = this.f.getAdapter().getCount();
    int i1 = 0;
    if (i1 >= this.g)
    {
      a();
      getViewTreeObserver().addOnGlobalLayoutListener(new o(this));
      return;
    }
    if ((this.f.getAdapter() instanceof PagerSlidingTabStrip.IconTabProvider))
    {
      int i2 = ((PagerSlidingTabStrip.IconTabProvider)this.f.getAdapter()).getPageIconResId(i1);
      ImageButton localImageButton = new ImageButton(getContext());
      localImageButton.setImageResource(i2);
      a(i1, localImageButton);
    }
    while (true)
    {
      i1++;
      break;
      String str = this.f.getAdapter().getPageTitle(i1).toString();
      TextView localTextView = new TextView(getContext());
      localTextView.setText(str);
      localTextView.setGravity(17);
      localTextView.setSingleLine();
      a(i1, localTextView);
    }
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((isInEditMode()) || (this.g == 0));
    while (true)
    {
      return;
      int i1 = getHeight();
      this.j.setColor(this.l);
      View localView1 = this.e.getChildAt(this.h);
      float f1 = localView1.getLeft();
      float f2 = localView1.getRight();
      if ((this.i > 0.0F) && (this.h < -1 + this.g))
      {
        View localView3 = this.e.getChildAt(1 + this.h);
        float f3 = localView3.getLeft();
        float f4 = localView3.getRight();
        f1 = f3 * this.i + f1 * (1.0F - this.i);
        f2 = f4 * this.i + f2 * (1.0F - this.i);
      }
      paramCanvas.drawRect(f1, i1 - this.r, f2, i1, this.j);
      this.j.setColor(this.m);
      paramCanvas.drawRect(0.0F, i1 - this.s, this.e.getWidth(), i1, this.j);
      this.k.setColor(this.n);
      for (int i2 = 0; i2 < -1 + this.g; i2++)
      {
        View localView2 = this.e.getChildAt(i2);
        paramCanvas.drawLine(localView2.getRight(), this.t, localView2.getRight(), i1 - this.t, this.k);
      }
    }
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    PagerSlidingTabStrip.SavedState localSavedState = (PagerSlidingTabStrip.SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.h = localSavedState.a;
    requestLayout();
  }

  public Parcelable onSaveInstanceState()
  {
    PagerSlidingTabStrip.SavedState localSavedState = new PagerSlidingTabStrip.SavedState(super.onSaveInstanceState());
    localSavedState.a = this.h;
    return localSavedState;
  }

  public void setAllCaps(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void setDividerColor(int paramInt)
  {
    this.n = paramInt;
    invalidate();
  }

  public void setDividerColorResource(int paramInt)
  {
    this.n = getResources().getColor(paramInt);
    invalidate();
  }

  public void setDividerPadding(int paramInt)
  {
    this.t = paramInt;
    invalidate();
  }

  public void setIndicatorColor(int paramInt)
  {
    this.l = paramInt;
    invalidate();
  }

  public void setIndicatorColorResource(int paramInt)
  {
    this.l = getResources().getColor(paramInt);
    invalidate();
  }

  public void setIndicatorHeight(int paramInt)
  {
    this.r = paramInt;
    invalidate();
  }

  public void setOnPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.delegatePageListener = paramOnPageChangeListener;
  }

  public void setScrollOffset(int paramInt)
  {
    this.q = paramInt;
    invalidate();
  }

  public void setShouldExpand(boolean paramBoolean)
  {
    this.o = paramBoolean;
    requestLayout();
  }

  public void setTabBackground(int paramInt)
  {
    this.B = paramInt;
  }

  public void setTabPaddingLeftRight(int paramInt)
  {
    this.u = paramInt;
    a();
  }

  public void setTextColor(int paramInt)
  {
    this.x = paramInt;
    a();
  }

  public void setTextColorResource(int paramInt)
  {
    this.x = getResources().getColor(paramInt);
    a();
  }

  public void setTextSize(int paramInt)
  {
    this.w = paramInt;
    a();
  }

  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    this.y = paramTypeface;
    this.z = paramInt;
    a();
  }

  public void setUnderlineColor(int paramInt)
  {
    this.m = paramInt;
    invalidate();
  }

  public void setUnderlineColorResource(int paramInt)
  {
    this.m = getResources().getColor(paramInt);
    invalidate();
  }

  public void setUnderlineHeight(int paramInt)
  {
    this.s = paramInt;
    invalidate();
  }

  public void setViewPager(ViewPager paramViewPager)
  {
    this.f = paramViewPager;
    if (paramViewPager.getAdapter() == null)
      throw new IllegalStateException("ViewPager does not have adapter instance.");
    paramViewPager.setOnPageChangeListener(this.d);
    notifyDataSetChanged();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.PagerSlidingTabStrip
 * JD-Core Version:    0.6.2
 */