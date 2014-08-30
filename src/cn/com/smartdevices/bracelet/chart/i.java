package cn.com.smartdevices.bracelet.chart;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class i
  implements ValueAnimator.AnimatorUpdateListener
{
  i(DynamicPieChartView paramDynamicPieChartView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ((DynamicPieChart)DynamicPieChartView.a(this.a)).rotate(f);
    this.a.postInvalidateOnAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.i
 * JD-Core Version:    0.6.2
 */