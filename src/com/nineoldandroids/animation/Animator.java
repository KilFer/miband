package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import java.util.ArrayList;

public abstract class Animator
  implements Cloneable
{
  ArrayList<Animator.AnimatorListener> a = null;

  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.a == null)
      this.a = new ArrayList();
    this.a.add(paramAnimatorListener);
  }

  public void cancel()
  {
  }

  public Animator clone()
  {
    Animator localAnimator;
    int i;
    int j;
    do
      try
      {
        localAnimator = (Animator)super.clone();
        if (this.a == null)
          break;
        ArrayList localArrayList = this.a;
        localAnimator.a = new ArrayList();
        i = localArrayList.size();
        j = 0;
        continue;
        localAnimator.a.add((Animator.AnimatorListener)localArrayList.get(j));
        j++;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException)
      {
        throw new AssertionError();
      }
    while (j < i);
    return localAnimator;
  }

  public void end()
  {
  }

  public abstract long getDuration();

  public ArrayList<Animator.AnimatorListener> getListeners()
  {
    return this.a;
  }

  public abstract long getStartDelay();

  public abstract boolean isRunning();

  public boolean isStarted()
  {
    return isRunning();
  }

  public void removeAllListeners()
  {
    if (this.a != null)
    {
      this.a.clear();
      this.a = null;
    }
  }

  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (this.a == null);
    do
    {
      return;
      this.a.remove(paramAnimatorListener);
    }
    while (this.a.size() != 0);
    this.a = null;
  }

  public abstract Animator setDuration(long paramLong);

  public abstract void setInterpolator(Interpolator paramInterpolator);

  public abstract void setStartDelay(long paramLong);

  public void setTarget(Object paramObject)
  {
  }

  public void setupEndValues()
  {
  }

  public void setupStartValues()
  {
  }

  public void start()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.animation.Animator
 * JD-Core Version:    0.6.2
 */