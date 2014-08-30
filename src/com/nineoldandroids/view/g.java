package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import java.lang.ref.WeakReference;

final class g extends ViewPropertyAnimator
{
  private static final long a = -1L;
  private final WeakReference<android.view.ViewPropertyAnimator> b;

  g(View paramView)
  {
    this.b = new WeakReference(paramView.animate());
  }

  public final ViewPropertyAnimator alpha(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.alpha(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator alphaBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.alphaBy(paramFloat);
    return this;
  }

  public final void cancel()
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.cancel();
  }

  public final long getDuration()
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      return localViewPropertyAnimator.getDuration();
    return -1L;
  }

  public final long getStartDelay()
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      return localViewPropertyAnimator.getStartDelay();
    return -1L;
  }

  public final ViewPropertyAnimator rotation(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.rotation(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.rotationBy(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationX(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.rotationX(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationXBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.rotationXBy(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationY(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.rotationY(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator rotationYBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.rotationYBy(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator scaleX(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.scaleX(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator scaleXBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.scaleXBy(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator scaleY(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.scaleY(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator scaleYBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.scaleYBy(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator setDuration(long paramLong)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.setDuration(paramLong);
    return this;
  }

  public final ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.setInterpolator(paramInterpolator);
    return this;
  }

  public final ViewPropertyAnimator setListener(Animator.AnimatorListener paramAnimatorListener)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
    {
      if (paramAnimatorListener == null)
        localViewPropertyAnimator.setListener(null);
    }
    else
      return this;
    localViewPropertyAnimator.setListener(new h(this, paramAnimatorListener));
    return this;
  }

  public final ViewPropertyAnimator setStartDelay(long paramLong)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.setStartDelay(paramLong);
    return this;
  }

  public final void start()
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.start();
  }

  public final ViewPropertyAnimator translationX(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.translationX(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator translationXBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.translationXBy(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator translationY(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.translationY(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator translationYBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.translationYBy(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator x(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.x(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator xBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.xBy(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator y(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.y(paramFloat);
    return this;
  }

  public final ViewPropertyAnimator yBy(float paramFloat)
  {
    android.view.ViewPropertyAnimator localViewPropertyAnimator = (android.view.ViewPropertyAnimator)this.b.get();
    if (localViewPropertyAnimator != null)
      localViewPropertyAnimator.yBy(paramFloat);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.g
 * JD-Core Version:    0.6.2
 */