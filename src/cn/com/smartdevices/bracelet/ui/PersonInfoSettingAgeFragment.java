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

public class PersonInfoSettingAgeFragment extends DimPanelFragment
{
  private PersonInfo a;
  private WheelView b;

  protected int inflateLayout()
  {
    return 2130903090;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = Keeper.readPersonInfo();
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.b = ((WheelView)localView.findViewById(2131165417));
    this.b.setVisibleItems(5).setCenterDrawable(2130837685).setCenterStyle(getString(2131493122), 24.0F).setViewAdapter(new PickAdapter(getActivity(), 5, 100, this.b, getResources().getColor(2131230732), getResources().getColor(2131230737), -2003199591, false, 46, 8, 7, 7, 1));
    if (this.a.age > 0)
    {
      this.b.setCurrentItem(-5 + this.a.age);
      return localView;
    }
    this.b.setCurrentItem(19);
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PagePersonInfoAge");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PagePersonInfoAge");
  }

  protected void onRightButtomClicked()
  {
    int i = this.a.age;
    this.a.age = (5 + this.b.getCurrentItem());
    if (i == this.a.age)
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
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PersonInfoSettingAgeFragment
 * JD-Core Version:    0.6.2
 */