package cn.com.smartdevices.bracelet.ui;

import android.animation.Animator;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo;

final class bA
  implements Runnable
{
  bA(SettingFragment paramSettingFragment)
  {
  }

  public final void run()
  {
    SettingFragment.g(this.a).setMaxValue(100L);
    SettingFragment.g(this.a).setValue(SettingFragment.a(this.a, SettingFragment.d(this.a).level));
    SettingFragment.i(this.a).start();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bA
 * JD-Core Version:    0.6.2
 */