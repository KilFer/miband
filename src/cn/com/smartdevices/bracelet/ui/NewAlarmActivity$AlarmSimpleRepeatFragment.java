package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.view.SelectDaysView;
import cn.com.smartdevices.bracelet.view.SimpleAlarmWeekAdapter;

public class NewAlarmActivity$AlarmSimpleRepeatFragment extends DimPanelFragment
{
  private int a;

  protected int inflateLayout()
  {
    return 2130903102;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    SelectDaysView localSelectDaysView = (SelectDaysView)localView.findViewById(2131165320);
    this.a = getArguments().getInt("Days");
    String[] arrayOfString = getResources().getStringArray(2131558403);
    localSelectDaysView.setAdapter(new SimpleAlarmWeekAdapter(getActivity(), arrayOfString, this.a));
    localSelectDaysView.setOnItemClickListener(new aO(this));
    return localView;
  }

  public void onPause()
  {
    super.onPause();
    UmengAnalytics.endPage("PageAlarmNewRepeat");
  }

  public void onResume()
  {
    super.onResume();
    UmengAnalytics.startPage("PageAlarmNewRepeat");
  }

  protected void onRightButtomClicked()
  {
    dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.NewAlarmActivity.AlarmSimpleRepeatFragment
 * JD-Core Version:    0.6.2
 */