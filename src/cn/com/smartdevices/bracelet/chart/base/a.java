package cn.com.smartdevices.bracelet.chart.base;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class a
  implements ValueAnimator.AnimatorUpdateListener
{
  a(BaseChartView paramBaseChartView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.mAnimFactor = paramValueAnimator.getAnimatedFraction();
    this.a.postInvalidateOnAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.base.a
 * JD-Core Version:    0.6.2
 */