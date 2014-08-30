package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

final class j
  implements ValueAnimator.AnimatorUpdateListener
{
  j(TextView paramTextView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    String str = (String)paramValueAnimator.getAnimatedValue("Text");
    Debug.i("Chart.AnimUtil", "Text : " + str);
    this.a.setText(str);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.j
 * JD-Core Version:    0.6.2
 */