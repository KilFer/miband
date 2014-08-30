package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener;

final class bv
  implements SlidingUpPanelLayout.PanelSlideListener
{
  bv(SettingFragment paramSettingFragment)
  {
  }

  public final int onGetPullDownDistance()
  {
    return 0;
  }

  public final Boolean onGetPullDownDockEnable()
  {
    return Boolean.valueOf(false);
  }

  public final float onGetThreshhold()
  {
    return 0.0F;
  }

  public final float onGetThreshhold2()
  {
    return 0.0F;
  }

  public final void onLastSlideOffset(View paramView, float paramFloat)
  {
  }

  public final void onPanelAnchored(View paramView)
  {
    Debug.i("SettingFragment", "onPanelAnchored");
  }

  public final void onPanelCollapsed(View paramView)
  {
    Debug.i("SettingFragment", "onPanelCollapsed");
  }

  public final void onPanelExpanded(View paramView)
  {
    Debug.i("SettingFragment", "onPanelExpanded");
    SettingFragment.a(this.a).invalidate();
  }

  public final void onPanelSlide(View paramView, Boolean paramBoolean, float paramFloat)
  {
    if (paramFloat <= 1.0F)
      SettingFragment.a(this.a, paramFloat);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bv
 * JD-Core Version:    0.6.2
 */