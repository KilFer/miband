package cn.com.smartdevices.bracelet.chart.deprecated;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

final class l
  implements Animator.AnimatorListener
{
  l(DynamicPieChartViewOld paramDynamicPieChartViewOld)
  {
  }

  public final void onAnimationCancel(Animator paramAnimator)
  {
  }

  public final void onAnimationEnd(Animator paramAnimator)
  {
    ((DynamicPieChartOld)DynamicPieChartViewOld.a(this.a)).dismissLoading();
    ((DynamicPieChartOld)DynamicPieChartViewOld.a(this.a)).rotate(0.0F);
    this.a.postInvalidateOnAnimation();
  }

  public final void onAnimationRepeat(Animator paramAnimator)
  {
  }

  public final void onAnimationStart(Animator paramAnimator)
  {
    ((DynamicPieChartOld)DynamicPieChartViewOld.a(this.a)).showLoading();
    ((DynamicPieChartOld)DynamicPieChartViewOld.a(this.a)).rotate(0.0F);
    this.a.postInvalidateOnAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.l
 * JD-Core Version:    0.6.2
 */