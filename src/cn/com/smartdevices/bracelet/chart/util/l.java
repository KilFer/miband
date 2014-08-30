package cn.com.smartdevices.bracelet.chart.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;

final class l
  implements ValueAnimator.AnimatorUpdateListener
{
  l(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, View[] paramArrayOfView)
  {
  }

  public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = Color.rgb((int)(f1 * this.a + this.b * (1.0F - f1)), (int)(f1 * this.c + this.d * (1.0F - f1)), (int)(f1 * this.e + this.f * (1.0F - f1)));
    View[] arrayOfView = this.g;
    int j = arrayOfView.length;
    for (int k = 0; ; k++)
    {
      if (k >= j)
        return;
      arrayOfView[k].setBackgroundColor(i);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.l
 * JD-Core Version:    0.6.2
 */