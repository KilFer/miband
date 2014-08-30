package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.chart.StatisticChartView;

final class bL
  implements Animator.AnimatorListener
{
  bL(StatisticFragment paramStatisticFragment, StatisticChartView paramStatisticChartView1, StatisticChartView paramStatisticChartView2)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    Debug.i("Statistic.Main", "OUT VIEW : " + this.c);
    this.c.setVisibility(4);
    this.c.setAlpha(1.0F);
    this.c.setScaleX(1.0F);
    if (StatisticFragment.k(this.a) != 1)
      StatisticFragment.E(this.a).setEnabled(true);
    if (StatisticFragment.k(this.a) != 256)
      StatisticFragment.F(this.a).setEnabled(true);
    StatisticFragment.C(this.a).setScrollable(true);
    StatisticFragment.D(this.a).setScrollable(true);
    StatisticFragment.b(this.a, false);
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    Debug.i("Statistic.Main", "IN VIEW : " + this.b);
    this.b.setVisibility(0);
    this.b.refresh();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bL
 * JD-Core Version:    0.6.2
 */