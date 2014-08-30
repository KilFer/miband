package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

final class k
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private k(i parami)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (i.b(this.a) != null)
      i.b(this.a).onAnimationCancel(paramAnimator);
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (i.b(this.a) != null)
      i.b(this.a).onAnimationEnd(paramAnimator);
    i.c(this.a).remove(paramAnimator);
    if (i.c(this.a).isEmpty())
      i.a(this.a, null);
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
    if (i.b(this.a) != null)
      i.b(this.a).onAnimationRepeat(paramAnimator);
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    if (i.b(this.a) != null)
      i.b(this.a).onAnimationStart(paramAnimator);
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    m localm = (m)i.c(this.a).get(paramValueAnimator);
    if ((0x1FF & localm.a) != 0)
    {
      View localView2 = (View)i.d(this.a).get();
      if (localView2 != null)
        localView2.invalidate();
    }
    ArrayList localArrayList = localm.b;
    int i;
    if (localArrayList != null)
      i = localArrayList.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        View localView1 = (View)i.d(this.a).get();
        if (localView1 != null)
          localView1.invalidate();
        return;
      }
      l locall = (l)localArrayList.get(j);
      float f2 = locall.b + f1 * locall.c;
      i.a(this.a, locall.a, f2);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.k
 * JD-Core Version:    0.6.2
 */