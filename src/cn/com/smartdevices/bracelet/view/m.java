package cn.com.smartdevices.bracelet.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

final class m
  implements ValueAnimator.AnimatorUpdateListener
{
  m(DynamicView paramDynamicView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    DynamicView.e(this.a).setRotationY(-90.0F + 90.0F * f1 / 100.0F);
    float f2 = 300.0F - 300.0F * f1 / 100.0F;
    DynamicView.e(this.a).setTranslationY(f2);
    if (f1 < 50.0F)
    {
      float f4 = f1 * 0.5F / 100.0F;
      DynamicView.e(this.a).setAlpha(f4);
      return;
    }
    float f3 = f1 / 100.0F;
    DynamicView.e(this.a).setAlpha(f3);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.m
 * JD-Core Version:    0.6.2
 */