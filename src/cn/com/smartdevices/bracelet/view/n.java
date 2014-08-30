package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import cn.com.smartdevices.bracelet.chart.compat.Compat;

final class n
  implements ValueAnimator.AnimatorUpdateListener
{
  n(DynamicView.FlowBgView paramFlowBgView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(DynamicView.FlowBgView.a(this.a) * (0.1948262F + f * 0.8051738F));
    DynamicView.FlowBgView.a(this.a, i);
    Compat.postOnAnimationInvalidate(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.n
 * JD-Core Version:    0.6.2
 */