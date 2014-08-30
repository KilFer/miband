package cn.com.smartdevices.bracelet.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.view.SelectDaysView;
import cn.com.smartdevices.bracelet.view.WeekAdapter;

public class NewAlarmActivity$AlarmRepeatFragment extends DimPanelFragment
{
  private SelectDaysView a;
  private int b;

  protected int inflateLayout()
  {
    return 2130903101;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.a = ((SelectDaysView)localView.findViewById(2131165320));
    this.b = getArguments().getInt("Days");
    Debug.i("DDDD", "Days : " + this.b);
    String[] arrayOfString = getResources().getStringArray(2131558400);
    this.a.setAdapter(new WeekAdapter(getActivity(), arrayOfString, this.b));
    this.a.setOnItemClickListener(new aN(this));
    return localView;
  }

  protected void onRightButtomClicked()
  {
    dismiss();
    NewAlarmActivity.a((NewAlarmActivity)getActivity(), this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.NewAlarmActivity.AlarmRepeatFragment
 * JD-Core Version:    0.6.2
 */