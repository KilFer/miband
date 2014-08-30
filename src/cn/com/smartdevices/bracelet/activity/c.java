package cn.com.smartdevices.bracelet.activity;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

final class c
  implements ValueAnimator.AnimatorUpdateListener
{
  c(b paramb)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    Float localFloat = (Float)paramValueAnimator.getAnimatedValue();
    LoginActivity.e(b.a(this.a)).setAlpha(localFloat.floatValue());
    LoginActivity.f(b.a(this.a)).setAlpha(localFloat.floatValue());
    LoginActivity.a(b.a(this.a)).setAlpha(localFloat.floatValue());
    LoginActivity.b(b.a(this.a)).setAlpha(localFloat.floatValue());
    LoginActivity.c(b.a(this.a)).setAlpha(localFloat.floatValue());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.activity.c
 * JD-Core Version:    0.6.2
 */