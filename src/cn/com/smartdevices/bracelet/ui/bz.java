package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.chart.LinePieChartView;

final class bz
  implements Animation.AnimationListener
{
  bz(SettingFragment paramSettingFragment)
  {
  }

  public final void onAnimationEnd(Animation paramAnimation)
  {
    SettingFragment.b(this.a, false);
  }

  public final void onAnimationRepeat(Animation paramAnimation)
  {
  }

  public final void onAnimationStart(Animation paramAnimation)
  {
    SettingFragment.a(this.a).setVisibility(0);
    SettingFragment.e(this.a).setVisibility(8);
    SettingFragment.f(this.a).setVisibility(8);
    SettingFragment.a(this.a).setImageResource(2130837644);
    SettingFragment.g(this.a).setMode(0);
    SettingFragment.h(this.a).setText(2131493223);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bz
 * JD-Core Version:    0.6.2
 */