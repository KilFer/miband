package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import cn.com.smartdevices.bracelet.chart.DynamicPieChartView;

final class i
  implements ValueAnimator.AnimatorUpdateListener
{
  i(DynamicView paramDynamicView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    DynamicView.d(this.a).setScaleX(f);
    DynamicView.d(this.a).setScaleY(f);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.i
 * JD-Core Version:    0.6.2
 */