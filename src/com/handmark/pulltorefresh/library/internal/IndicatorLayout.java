package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;

public class IndicatorLayout extends FrameLayout
  implements Animation.AnimationListener
{
  private static int a = 150;
  private Animation b;
  private Animation c;
  private ImageView d;
  private final Animation e;
  private final Animation f;

  public IndicatorLayout(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext);
    this.d = new ImageView(paramContext);
    Drawable localDrawable = getResources().getDrawable(2130837619);
    this.d.setImageDrawable(localDrawable);
    int i = getResources().getDimensionPixelSize(2131296315);
    this.d.setPadding(i, i, i, i);
    addView(this.d);
    int j;
    int k;
    switch (a()[paramMode.ordinal()])
    {
    default:
      j = 2130968590;
      k = 2130968592;
      setBackgroundResource(2130837621);
    case 3:
    }
    while (true)
    {
      this.b = AnimationUtils.loadAnimation(paramContext, j);
      this.b.setAnimationListener(this);
      this.c = AnimationUtils.loadAnimation(paramContext, k);
      this.c.setAnimationListener(this);
      LinearInterpolator localLinearInterpolator = new LinearInterpolator();
      this.e = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
      this.e.setInterpolator(localLinearInterpolator);
      this.e.setDuration(150L);
      this.e.setFillAfter(true);
      this.f = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.f.setInterpolator(localLinearInterpolator);
      this.f.setDuration(150L);
      this.f.setFillAfter(true);
      return;
      j = 2130968589;
      k = 2130968591;
      setBackgroundResource(2130837620);
      this.d.setScaleType(ImageView.ScaleType.MATRIX);
      Matrix localMatrix = new Matrix();
      localMatrix.setRotate(180.0F, localDrawable.getIntrinsicWidth() / 2.0F, localDrawable.getIntrinsicHeight() / 2.0F);
      this.d.setImageMatrix(localMatrix);
    }
  }

  public void hide()
  {
    startAnimation(this.c);
  }

  public final boolean isVisible()
  {
    Animation localAnimation = getAnimation();
    if (localAnimation != null)
      if (this.b != localAnimation);
    while (getVisibility() == 0)
    {
      return true;
      return false;
    }
    return false;
  }

  public void onAnimationEnd(Animation paramAnimation)
  {
    if (paramAnimation == this.c)
    {
      this.d.clearAnimation();
      setVisibility(8);
    }
    while (true)
    {
      clearAnimation();
      return;
      if (paramAnimation == this.b)
        setVisibility(0);
    }
  }

  public void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public void onAnimationStart(Animation paramAnimation)
  {
    setVisibility(0);
  }

  public void pullToRefresh()
  {
    this.d.startAnimation(this.f);
  }

  public void releaseToRefresh()
  {
    this.d.startAnimation(this.e);
  }

  public void show()
  {
    this.d.clearAnimation();
    startAnimation(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.internal.IndicatorLayout
 * JD-Core Version:    0.6.2
 */