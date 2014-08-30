package cn.com.smartdevices.bracelet.ui;

import android.animation.ValueAnimator;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData;

final class T
  implements ViewPager.OnPageChangeListener
{
  T(DynamicFragment paramDynamicFragment)
  {
  }

  public final void onPageScrollStateChanged(int paramInt)
  {
  }

  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (DynamicFragment.b(this.a) != null)
    {
      if ((paramInt1 % 2 == 1) && (paramFloat == 0.0F))
        paramFloat = 1.0F;
      long l = ()(paramFloat * (float)DynamicFragment.b(this.a).getDuration());
      DynamicFragment.b(this.a).setCurrentPlayTime(l);
    }
  }

  public final void onPageSelected(int paramInt)
  {
    if (paramInt == 0)
      DynamicFragment.a(this.a, 16);
    while (true)
    {
      DynamicFragment.b(this.a, DynamicFragment.a(this.a));
      ChartData.getDynamicData().setCurrentMode(DynamicFragment.a(this.a));
      return;
      if (paramInt == 1)
        DynamicFragment.a(this.a, 1);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.T
 * JD-Core Version:    0.6.2
 */