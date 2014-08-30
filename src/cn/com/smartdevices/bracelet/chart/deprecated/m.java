package cn.com.smartdevices.bracelet.chart.deprecated;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class m
  implements ValueAnimator.AnimatorUpdateListener
{
  m(DynamicPieChartViewOld paramDynamicPieChartViewOld)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = 360.0F * ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ((DynamicPieChartOld)DynamicPieChartViewOld.a(this.a)).rotate(f);
    this.a.postInvalidateOnAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.m
 * JD-Core Version:    0.6.2
 */