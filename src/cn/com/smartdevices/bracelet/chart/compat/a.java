package cn.com.smartdevices.bracelet.chart.compat;

import android.view.View;

final class a
{
  static void a()
  {
  }

  static void a(View paramView)
  {
    paramView.postDelayed(new b(paramView), 10L);
  }

  static void a(View paramView, Runnable paramRunnable)
  {
    paramView.postDelayed(paramRunnable, 10L);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.compat.a
 * JD-Core Version:    0.6.2
 */