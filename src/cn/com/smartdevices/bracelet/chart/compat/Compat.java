package cn.com.smartdevices.bracelet.chart.compat;

import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import android.view.View;

public class Compat
{
  public static void postOnAnimation(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postOnAnimation(paramRunnable);
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.postDelayed(paramRunnable, ValueAnimator.getFrameDelay());
      return;
    }
    paramView.postDelayed(paramRunnable, 10L);
  }

  public static void postOnAnimationInvalidate(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.postInvalidateOnAnimation();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.postDelayed(new d(paramView), ValueAnimator.getFrameDelay());
      return;
    }
    paramView.postDelayed(new b(paramView), 10L);
  }

  public static void setAlpha(View paramView, float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 11)
      paramView.setAlpha(paramFloat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.compat.Compat
 * JD-Core Version:    0.6.2
 */