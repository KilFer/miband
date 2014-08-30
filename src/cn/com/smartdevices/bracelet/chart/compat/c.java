package cn.com.smartdevices.bracelet.chart.compat;

import android.animation.ValueAnimator;
import android.view.View;

final class c
{
  static void a(View paramView)
  {
    paramView.postDelayed(new d(paramView), ValueAnimator.getFrameDelay());
  }

  static void a(View paramView, float paramFloat)
  {
    paramView.setAlpha(paramFloat);
  }

  static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.compat.c
 * JD-Core Version:    0.6.2
 */