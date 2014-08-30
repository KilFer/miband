package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;

final class bJ
  implements Animator.AnimatorListener
{
  bJ(StatisticFragment paramStatisticFragment)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    StatisticFragment.C(this.a).setScrollable(true);
    StatisticFragment.D(this.a).setScrollable(true);
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bJ
 * JD-Core Version:    0.6.2
 */