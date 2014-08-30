package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;

public class SettingInComingCallTimeFragment extends DimPanelFragment
{
  private static final int a = 10000;
  private PersonInfo b;
  private WheelView c;

  protected int inflateLayout()
  {
    return 2130903105;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = Keeper.readPersonInfo();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.c = ((WheelView)localView.findViewById(2131165456));
    this.c.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131493317), 24.0F).setViewAdapter(new PickAdapter(getActivity(), 0, 30, this.c, getResources().getColor(2131230732), getResources().getColor(2131230737), -2003199591, false, 46, 8, 7, 7, 1));
    if (this.b.getInComingCallTime() >= 0)
    {
      this.c.setCurrentItem(this.b.getInComingCallTime());
      return localView;
    }
    this.c.setCurrentItem(10000);
    return localView;
  }

  public void onPause()
  {
    super.onPause();
  }

  public void onResume()
  {
    super.onResume();
  }

  protected void onRightButtomClicked()
  {
    int i = this.b.getInComingCallTime();
    this.b.setInComingCallTime(this.c.getCurrentItem());
    if (i == this.b.getInComingCallTime())
    {
      dismiss();
      return;
    }
    this.b.setNeedSyncServer(2);
    Keeper.keepPersonInfo(this.b);
    EventBus.getDefault().post(new EventSettingFragmentUpdate());
    dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingInComingCallTimeFragment
 * JD-Core Version:    0.6.2
 */