package cn.com.smartdevices.bracelet.chart.compat;

import android.view.View;

final class e
{
  static void a(View paramView)
  {
    paramView.postInvalidateOnAnimation();
  }

  static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postOnAnimation(paramRunnable);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.compat.e
 * JD-Core Version:    0.6.2
 */