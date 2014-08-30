package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class aH
  implements ValueAnimator.AnimatorUpdateListener
{
  aH(MainUIActivity paramMainUIActivity)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    MainUIActivity.p(this.a).setScaleX(f);
    MainUIActivity.p(this.a).setScaleY(f);
    MainUIActivity.p(this.a).setAlpha(f);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aH
 * JD-Core Version:    0.6.2
 */