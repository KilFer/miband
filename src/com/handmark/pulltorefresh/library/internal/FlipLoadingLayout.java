package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public class FlipLoadingLayout extends LoadingLayout
{
  private static int b = 150;
  private final Animation c;
  private final Animation d;

  public FlipLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    if (paramMode == PullToRefreshBase.Mode.PULL_FROM_START);
    for (int i = -180; ; i = 180)
    {
      this.c = new RotateAnimation(0.0F, i, 1, 0.5F, 1, 0.5F);
      this.c.setInterpolator(a);
      this.c.setDuration(150L);
      this.c.setFillAfter(true);
      this.d = new RotateAnimation(i, 0.0F, 1, 0.5F, 1, 0.5F);
      this.d.setInterpolator(a);
      this.d.setDuration(150L);
      this.d.setFillAfter(true);
      return;
    }
  }

  private float a()
  {
    switch (b()[this.mMode.ordinal()])
    {
    default:
    case 3:
    case 2:
    }
    do
    {
      return 0.0F;
      if (this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL)
        return 90.0F;
      return 180.0F;
    }
    while (this.mScrollDirection != PullToRefreshBase.Orientation.HORIZONTAL);
    return 270.0F;
  }

  protected int getDefaultDrawableResId()
  {
    return 2130837591;
  }

  protected void onLoadingDrawableSet(Drawable paramDrawable)
  {
    ViewGroup.LayoutParams localLayoutParams;
    Matrix localMatrix;
    float f;
    if (paramDrawable != null)
    {
      int i = paramDrawable.getIntrinsicHeight();
      int j = paramDrawable.getIntrinsicWidth();
      localLayoutParams = this.mHeaderImage.getLayoutParams();
      int k = Math.max(i, j);
      localLayoutParams.height = k;
      localLayoutParams.width = k;
      this.mHeaderImage.requestLayout();
      this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
      localMatrix = new Matrix();
      localMatrix.postTranslate((localLayoutParams.width - j) / 2.0F, (localLayoutParams.height - i) / 2.0F);
      int m = b()[this.mMode.ordinal()];
      f = 0.0F;
      switch (m)
      {
      default:
      case 3:
      case 2:
      }
    }
    while (true)
    {
      localMatrix.postRotate(f, localLayoutParams.width / 2.0F, localLayoutParams.height / 2.0F);
      this.mHeaderImage.setImageMatrix(localMatrix);
      return;
      if (this.mScrollDirection == PullToRefreshBase.Orientation.HORIZONTAL)
      {
        f = 90.0F;
      }
      else
      {
        f = 180.0F;
        continue;
        PullToRefreshBase.Orientation localOrientation1 = this.mScrollDirection;
        PullToRefreshBase.Orientation localOrientation2 = PullToRefreshBase.Orientation.HORIZONTAL;
        f = 0.0F;
        if (localOrientation1 == localOrientation2)
          f = 270.0F;
      }
    }
  }

  protected void onPullImpl(float paramFloat)
  {
  }

  protected void pullToRefreshImpl()
  {
    if (this.c == this.mHeaderImage.getAnimation())
      this.mHeaderImage.startAnimation(this.d);
  }

  protected void refreshingImpl()
  {
    this.mHeaderImage.clearAnimation();
    this.mHeaderImage.setVisibility(4);
    this.mHeaderProgress.setVisibility(0);
  }

  protected void releaseToRefreshImpl()
  {
    this.mHeaderImage.startAnimation(this.c);
  }

  protected void resetImpl()
  {
    this.mHeaderImage.clearAnimation();
    this.mHeaderProgress.setVisibility(8);
    this.mHeaderImage.setVisibility(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.internal.FlipLoadingLayout
 * JD-Core Version:    0.6.2
 */