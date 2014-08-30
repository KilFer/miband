package cn.com.smartdevices.bracelet.chart;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class l
  implements ValueAnimator.AnimatorUpdateListener
{
  l(LinePieChartView paramLinePieChartView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    ((LinePieChart)LinePieChartView.a(this.a)).rotate(f);
    this.a.postInvalidateOnAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.l
 * JD-Core Version:    0.6.2
 */