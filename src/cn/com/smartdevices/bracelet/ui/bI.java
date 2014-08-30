package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.animation.DecelerateInterpolator;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;

final class bI
  implements Animator.AnimatorListener
{
  bI(StatisticFragment paramStatisticFragment, long paramLong)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    StatisticFragment.C(this.a).setMode(StatisticFragment.x(this.a));
    StatisticFragment.D(this.a).setMode(StatisticFragment.x(this.a));
    Animator localAnimator = StatisticFragment.p(this.a).animRefresh();
    localAnimator.setDuration(this.b / 2L);
    localAnimator.setInterpolator(new DecelerateInterpolator(1.5F));
    localAnimator.start();
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bI
 * JD-Core Version:    0.6.2
 */