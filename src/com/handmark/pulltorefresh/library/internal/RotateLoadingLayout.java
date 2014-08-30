package com.handmark.pulltorefresh.library.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public class RotateLoadingLayout extends LoadingLayout
{
  private static int b = 1200;
  private final Animation c;
  private final Matrix d;
  private float e;
  private float f;
  private final boolean g;

  public RotateLoadingLayout(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.Orientation paramOrientation, TypedArray paramTypedArray)
  {
    super(paramContext, paramMode, paramOrientation, paramTypedArray);
    this.g = paramTypedArray.getBoolean(15, true);
    this.mHeaderImage.setScaleType(ImageView.ScaleType.MATRIX);
    this.d = new Matrix();
    this.mHeaderImage.setImageMatrix(this.d);
    this.c = new RotateAnimation(0.0F, 720.0F, 1, 0.5F, 1, 0.5F);
    this.c.setInterpolator(a);
    this.c.setDuration(1200L);
    this.c.setRepeatCount(-1);
    this.c.setRepeatMode(1);
  }

  private void a()
  {
    if (this.d != null)
    {
      this.d.reset();
      this.mHeaderImage.setImageMatrix(this.d);
    }
  }

  protected int getDefaultDrawableResId()
  {
    return 2130837592;
  }

  public void onLoadingDrawableSet(Drawable paramDrawable)
  {
    if (paramDrawable != null)
    {
      this.e = Math.round(paramDrawable.getIntrinsicWidth() / 2.0F);
      this.f = Math.round(paramDrawable.getIntrinsicHeight() / 2.0F);
    }
  }

  protected void onPullImpl(float paramFloat)
  {
    if (this.g);
    for (float f1 = 90.0F * paramFloat; ; f1 = Math.max(0.0F, Math.min(180.0F, 360.0F * paramFloat - 180.0F)))
    {
      this.d.setRotate(f1, this.e, this.f);
      this.mHeaderImage.setImageMatrix(this.d);
      return;
    }
  }

  protected void pullToRefreshImpl()
  {
  }

  protected void refreshingImpl()
  {
    this.mHeaderImage.startAnimation(this.c);
  }

  protected void releaseToRefreshImpl()
  {
  }

  protected void resetImpl()
  {
    this.mHeaderImage.clearAnimation();
    if (this.d != null)
    {
      this.d.reset();
      this.mHeaderImage.setImageMatrix(this.d);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.internal.RotateLoadingLayout
 * JD-Core Version:    0.6.2
 */