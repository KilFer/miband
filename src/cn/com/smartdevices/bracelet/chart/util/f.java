package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

final class f
  implements ValueAnimator.AnimatorUpdateListener
{
  f(TextView paramTextView1, TextView paramTextView2)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    float f2 = 0.9F * (1.0F - f1);
    float f3 = 0.5F + f1 * 0.5F;
    this.a.setAlpha(f2);
    this.a.setScaleX(f2);
    this.a.setScaleY(f2);
    this.b.setAlpha(f3);
    this.b.setScaleX(f3);
    this.b.setScaleY(f3);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.f
 * JD-Core Version:    0.6.2
 */