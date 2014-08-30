package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class k
  implements Animator.AnimatorListener
{
  k(LinePieChartView paramLinePieChartView)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    ((LinePieChart)LinePieChartView.a(this.a)).dismissLoading();
    ((LinePieChart)LinePieChartView.a(this.a)).rotate(0.0F);
    this.a.postInvalidateOnAnimation();
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    ((LinePieChart)LinePieChartView.a(this.a)).showLoading();
    ((LinePieChart)LinePieChartView.a(this.a)).rotate(0.0F);
    this.a.postInvalidateOnAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.k
 * JD-Core Version:    0.6.2
 */