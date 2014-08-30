package cn.com.smartdevices.bracelet.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class s
  implements Animator.AnimatorListener
{
  s(RoundProgressBar paramRoundProgressBar)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    if ((RoundProgressBar.a(this.a) < RoundProgressBar.b(this.a)) && (RoundProgressBar.c(this.a) < RoundProgressBar.b(this.a)))
    {
      RoundProgressBar.a(this.a, RoundProgressBar.b(this.a));
      RoundProgressBar.a(this.a, RoundProgressBar.a(this.a) - RoundProgressBar.c(this.a), RoundProgressBar.c(this.a), RoundProgressBar.a(this.a));
    }
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.s
 * JD-Core Version:    0.6.2
 */