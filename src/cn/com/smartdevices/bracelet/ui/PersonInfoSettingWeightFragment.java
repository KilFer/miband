package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;
import kankan.wheel.widget.WheelView;

public class PersonInfoSettingWeightFragment extends DimPanelFragment
{
  private PersonInfo a;
  private WheelView b;

  protected int inflateLayout()
  {
    return 2130903095;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = Keeper.readPersonInfo();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = ((WheelView)localView.findViewById(2131165425));
    this.b.setCenterDrawable(2130837685).setCenterStyle(getString(2131492964), 25.122999F).setViewAdapter(new PickAdapter(getActivity(), 20, 205, this.b, getResources().getColor(2131230732), getResources().getColor(2131230737), -2003199591, false, 46, 8, 7, 7, 1)).setCurrentItem(-20 + this.a.weight);
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonInfoWeight");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonInfoWeight");
  }

  protected void onRightButtomClicked()
  {
    this.mRightButton.setEnabled(false);
    int i = this.a.weight;
    this.a.weight = (20 + this.b.getCurrentItem());
    if (i == this.a.weight)
    {
      dismiss();
      return;
    }
    this.a.setNeedSyncServer(2);
    Keeper.keepPersonInfo(this.a);
    EventBus.getDefault().post(new EventPersonInfoUpdate());
    dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PersonInfoSettingWeightFragment
 * JD-Core Version:    0.6.2
 */