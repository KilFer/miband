package cn.com.smartdevices.bracelet.lua;

import android.view.View;

public abstract interface SlidingUpPanelLayout$PanelSlideListener
{
  public abstract int onGetPullDownDistance();

  public abstract Boolean onGetPullDownDockEnable();

  public abstract float onGetThreshhold();

  public abstract float onGetThreshhold2();

  public abstract void onLastSlideOffset(View paramView, float paramFloat);

  public abstract void onPanelAnchored(View paramView);

  public abstract void onPanelCollapsed(View paramView);

  public abstract void onPanelExpanded(View paramView);

  public abstract void onPanelSlide(View paramView, Boolean paramBoolean, float paramFloat);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.lua.SlidingUpPanelLayout.PanelSlideListener
 * JD-Core Version:    0.6.2
 */