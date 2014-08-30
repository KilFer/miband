package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import cn.com.smartdevices.bracelet.chart.DynamicDetailChartView;

final class Q
  implements Animator.AnimatorListener
{
  Q(DynamicDetailFragment paramDynamicDetailFragment)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    if ((!"DynamicView".equals(DynamicDetailFragment.k(this.a))) || (DynamicDetailFragment.h(this.a) != 1))
      DynamicDetailFragment.g(this.a).setScrollable(true);
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.Q
 * JD-Core Version:    0.6.2
 */