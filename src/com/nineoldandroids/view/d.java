package com.nineoldandroids.view;

import android.view.View;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

final class d
  implements Animator.AnimatorListener, ValueAnimator.AnimatorUpdateListener
{
  private d(b paramb)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
    if (b.b(this.a) != null)
      b.b(this.a).onAnimationCancel(paramAnimator);
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    if (b.b(this.a) != null)
      b.b(this.a).onAnimationEnd(paramAnimator);
    b.c(this.a).remove(paramAnimator);
    if (b.c(this.a).isEmpty())
      b.a(this.a, null);
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
    if (b.b(this.a) != null)
      b.b(this.a).onAnimationRepeat(paramAnimator);
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    if (b.b(this.a) != null)
      b.b(this.a).onAnimationStart(paramAnimator);
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = paramValueAnimator.getAnimatedFraction();
    f localf = (f)b.c(this.a).get(paramValueAnimator);
    if ((0x1FF & localf.a) != 0)
    {
      View localView2 = (View)b.d(this.a).get();
      if (localView2 != null)
        localView2.invalidate();
    }
    ArrayList localArrayList = localf.b;
    int i;
    if (localArrayList != null)
      i = localArrayList.size();
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        View localView1 = (View)b.d(this.a).get();
        if (localView1 != null)
          localView1.invalidate();
        return;
      }
      a locala = (a)localArrayList.get(j);
      float f2 = locala.b + f1 * locala.c;
      b.a(this.a, locala.a, f2);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nineoldandroids.view.d
 * JD-Core Version:    0.6.2
 */