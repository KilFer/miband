package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;

final class h
  implements ValueAnimator.AnimatorUpdateListener
{
  h(TextView paramTextView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    CharSequence localCharSequence = (CharSequence)paramValueAnimator.getAnimatedValue("Text");
    this.a.setText(localCharSequence);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.h
 * JD-Core Version:    0.6.2
 */