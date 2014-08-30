package cn.com.smartdevices.bracelet.chart;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class h
  implements Animator.AnimatorListener
{
  h(DynamicPieChartView paramDynamicPieChartView)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    ((DynamicPieChart)DynamicPieChartView.a(this.a)).dismissLoading();
    ((DynamicPieChart)DynamicPieChartView.a(this.a)).rotate(0.0F);
    this.a.postInvalidateOnAnimation();
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    ((DynamicPieChart)DynamicPieChartView.a(this.a)).showLoading();
    ((DynamicPieChart)DynamicPieChartView.a(this.a)).rotate(0.0F);
    this.a.postInvalidateOnAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.h
 * JD-Core Version:    0.6.2
 */