package cn.com.smartdevices.bracelet.chart.deprecated;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;

final class t
  implements ViewPager.OnPageChangeListener
{
  t(StatisticHostFragment paramStatisticHostFragment)
  {
  }

  public final void onPageScrollStateChanged(int paramInt)
  {
  }

  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
  }

  public final void onPageSelected(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.getView().findViewById(2131165503).setVisibility(0);
      this.a.getView().findViewById(2131165506).setVisibility(4);
      return;
    }
    this.a.getView().findViewById(2131165503).setVisibility(4);
    this.a.getView().findViewById(2131165506).setVisibility(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.deprecated.t
 * JD-Core Version:    0.6.2
 */