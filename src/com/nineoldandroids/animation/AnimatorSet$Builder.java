package com.nineoldandroids.animation;

import java.util.ArrayList;
import java.util.HashMap;

public class AnimatorSet$Builder
{
  private e a;

  AnimatorSet$Builder(AnimatorSet paramAnimatorSet, Animator paramAnimator)
  {
    this.a = ((e)AnimatorSet.b(paramAnimatorSet).get(paramAnimator));
    if (this.a == null)
    {
      this.a = new e(paramAnimator);
      AnimatorSet.b(paramAnimatorSet).put(paramAnimator, this.a);
      AnimatorSet.d(paramAnimatorSet).add(this.a);
    }
  }

  public Builder after(long paramLong)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(paramLong);
    after(localValueAnimator);
    return this;
  }

  public Builder after(Animator paramAnimator)
  {
    e locale = (e)AnimatorSet.b(this.b).get(paramAnimator);
    if (locale == null)
    {
      locale = new e(paramAnimator);
      AnimatorSet.b(this.b).put(paramAnimator, locale);
      AnimatorSet.d(this.b).add(locale);
    }
    c localc = new c(locale, 1);
    this.a.a(localc);
    return this;
  }

  public Builder before(Animator paramAnimator)
  {
    e locale = (e)AnimatorSet.b(this.b).get(paramAnimator);
    if (locale == null)
    {
      locale = new e(paramAnimator);
      AnimatorSet.b(this.b).put(paramAnimator, locale);
      AnimatorSet.d(this.b).add(locale);
    }
    locale.a(new c(this.a, 1));
    return this;
  }

  public Builder with(Animator paramAnimator)
  {
    e locale = (e)AnimatorSet.b(this.b).get(paramAnimator);
    if (locale == null)
    {
      locale = new e(paramAnimator);
      AnimatorSet.b(this.b).put(paramAnimator, locale);
      AnimatorSet.d(this.b).add(locale);
    }
    locale.a(new c(this.a, 0));
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.AnimatorSet.Builder
 * JD-Core Version:    0.6.2
 */