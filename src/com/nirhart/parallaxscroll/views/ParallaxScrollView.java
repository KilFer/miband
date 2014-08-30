package com.nirhart.parallaxscroll.views;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.xiaomi.hm.health.R.styleable;
import java.util.ArrayList;
import java.util.Iterator;

public class ParallaxScrollView extends ScrollView
{
  private static final int a = 1;
  private static final float b = 1.9F;
  private static final float c = 1.9F;
  private static final String d = "ParallaxedScrollView";
  private static final int m = 0;
  private static final int o = 50;
  private static final boolean p;
  private int e = 1;
  private float f = 1.9F;
  private float g = 1.9F;
  private ArrayList<ParallaxedView> h = new ArrayList();
  private Drawable i = null;
  private View j;
  private View k = null;
  private int l = 0;
  private int n;
  private ParallaxScrollView.OnScrollListener q;

  static
  {
    if (Build.VERSION.SDK_INT >= 11);
    for (boolean bool = true; ; bool = false)
    {
      p = bool;
      return;
    }
  }

  public ParallaxScrollView(Context paramContext)
  {
    super(paramContext);
  }

  public ParallaxScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }

  public ParallaxScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }

  private void a()
  {
    ViewGroup localViewGroup;
    int i1;
    if ((getChildCount() > 0) && ((getChildAt(0) instanceof ViewGroup)))
    {
      localViewGroup = (ViewGroup)getChildAt(0);
      i1 = Math.min(this.e, localViewGroup.getChildCount());
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        localViewGroup.getChildAt(0);
        this.k = localViewGroup.getChildAt(1);
        return;
      }
      ParallaxScrollView.ParallaxedScrollView localParallaxedScrollView = new ParallaxScrollView.ParallaxedScrollView(this, localViewGroup.getChildAt(i2));
      this.h.add(localParallaxedScrollView);
    }
  }

  private static void a(View paramView, boolean paramBoolean)
  {
    if (!p);
    while (true)
    {
      return;
      if (paramBoolean);
      for (int i1 = 2; i1 != paramView.getLayerType(); i1 = 0)
      {
        paramView.setLayerType(i1, null);
        return;
      }
    }
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.k == null);
    int i1;
    int i2;
    int i3;
    int i4;
    do
    {
      return;
      i1 = this.k.getRight();
      i2 = this.k.getTop() - this.l;
      i3 = this.k.getTop();
      i4 = this.k.getLeft();
    }
    while (this.i == null);
    this.i.setBounds(i4, i2, i1, i3);
    this.i.draw(paramCanvas);
  }

  protected void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ParallaxScroll);
    this.g = localTypedArray.getFloat(0, 1.9F);
    this.f = localTypedArray.getFloat(1, 1.9F);
    this.e = localTypedArray.getInt(2, 1);
    localTypedArray.recycle();
    this.i = getResources().getDrawable(2130837505);
    float f1 = paramContext.getResources().getDisplayMetrics().density;
    this.l = ((int)(0.0F * f1));
    this.n = ((int)(f1 * 50.0F));
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
    ViewGroup localViewGroup;
    int i1;
    if ((getChildCount() > 0) && ((getChildAt(0) instanceof ViewGroup)))
    {
      localViewGroup = (ViewGroup)getChildAt(0);
      i1 = Math.min(this.e, localViewGroup.getChildCount());
    }
    for (int i2 = 0; ; i2++)
    {
      if (i2 >= i1)
      {
        localViewGroup.getChildAt(0);
        this.k = localViewGroup.getChildAt(1);
        return;
      }
      ParallaxScrollView.ParallaxedScrollView localParallaxedScrollView = new ParallaxScrollView.ParallaxedScrollView(this, localViewGroup.getChildAt(i2));
      this.h.add(localParallaxedScrollView);
    }
  }

  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.q != null)
      this.q.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    float f1;
    Iterator localIterator;
    if (paramInt2 >= 0)
    {
      f1 = this.g;
      localIterator = this.h.iterator();
    }
    for (float f2 = f1; ; f2 *= this.f)
    {
      if (!localIterator.hasNext())
        return;
      ((ParallaxedView)localIterator.next()).setOffset(paramInt2 / f2);
    }
  }

  protected boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (paramInt2 + paramInt4 >= 0)
      return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, this.n, paramBoolean);
    return super.overScrollBy(paramInt1, 0, paramInt3, 0, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
  }

  public void setOnScrollListener(ParallaxScrollView.OnScrollListener paramOnScrollListener)
  {
    this.q = paramOnScrollListener;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nirhart.parallaxscroll.views.ParallaxScrollView
 * JD-Core Version:    0.6.2
 */