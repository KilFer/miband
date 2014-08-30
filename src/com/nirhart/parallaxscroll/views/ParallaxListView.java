package com.nirhart.parallaxscroll.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.xiaomi.hm.health.R.styleable;

public class ParallaxListView extends ListView
  implements AbsListView.OnScrollListener
{
  private static final float a = 1.9F;
  private static final boolean b;
  private float c = 1.9F;
  private ParallaxedView d;
  private boolean e;
  private AbsListView.OnScrollListener f = null;

  public ParallaxListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, paramAttributeSet);
  }

  public ParallaxListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext, paramAttributeSet);
  }

  private void a()
  {
    int i;
    float f1;
    if (getChildCount() > 0)
    {
      i = -getChildAt(0).getTop();
      f1 = this.c;
      if ((this.d == null) || (!this.d.is(getChildAt(0))))
      {
        if (this.d == null)
          break label83;
        this.d.setOffset(0.0F);
        this.d.setView(getChildAt(0));
      }
    }
    while (true)
    {
      this.d.setOffset(i / f1);
      return;
      label83: this.d = new ParallaxListView.ParallaxedListView(this, getChildAt(0));
    }
  }

  private void a(View paramView)
  {
    this.d = new ParallaxListView.ParallaxedListView(this, paramView);
  }

  private void b()
  {
    if ((this.d != null) && (getChildCount() > 0))
    {
      int i = -getChildAt(0).getTop();
      float f1 = this.c;
      this.d.setOffset(i / f1);
    }
  }

  private void c()
  {
    if ((this.d == null) || (!this.d.is(getChildAt(0))))
    {
      if (this.d != null)
      {
        this.d.setOffset(0.0F);
        this.d.setView(getChildAt(0));
      }
    }
    else
      return;
    this.d = new ParallaxListView.ParallaxedListView(this, getChildAt(0));
  }

  public void addParallaxedHeaderView(View paramView)
  {
    super.addHeaderView(paramView);
    a(paramView);
  }

  public void addParallaxedHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    super.addHeaderView(paramView, paramObject, paramBoolean);
    a(paramView);
  }

  protected void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ParallaxScroll);
    this.c = localTypedArray.getFloat(0, 1.9F);
    this.e = localTypedArray.getBoolean(3, false);
    localTypedArray.recycle();
    super.setOnScrollListener(this);
  }

  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }

  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    parallaxScroll();
    if (this.f != null)
      this.f.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
  }

  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.f != null)
      this.f.onScrollStateChanged(paramAbsListView, paramInt);
  }

  protected void parallaxScroll()
  {
    if (this.e)
      if (getChildCount() > 0)
      {
        j = -getChildAt(0).getTop();
        f2 = this.c;
        if ((this.d == null) || (!this.d.is(getChildAt(0))))
        {
          if (this.d == null)
            break label92;
          this.d.setOffset(0.0F);
          this.d.setView(getChildAt(0));
        }
        this.d.setOffset(j / f2);
      }
    label92: 
    while ((this.d == null) || (getChildCount() <= 0))
      while (true)
      {
        int j;
        float f2;
        return;
        this.d = new ParallaxListView.ParallaxedListView(this, getChildAt(0));
      }
    int i = -getChildAt(0).getTop();
    float f1 = this.c;
    this.d.setOffset(i / f1);
  }

  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.f = paramOnScrollListener;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nirhart.parallaxscroll.views.ParallaxListView
 * JD-Core Version:    0.6.2
 */