package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

final class t
  implements ValueAnimator.AnimatorUpdateListener
{
  t(RoundProgressBar paramRoundProgressBar)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    RoundProgressBar.b(this.a, (int)f);
    this.a.postInvalidate();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.t
 * JD-Core Version:    0.6.2
 */