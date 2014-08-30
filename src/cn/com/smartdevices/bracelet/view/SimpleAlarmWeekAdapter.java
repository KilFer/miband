package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.ui.NewAlarmActivity;

public class SimpleAlarmWeekAdapter extends WeekAdapter
{
  private static final int a = 3;
  private static final String b = "SimpleAlarmWeekAdapter";

  public SimpleAlarmWeekAdapter(Context paramContext, String[] paramArrayOfString, int paramInt)
  {
    super(paramContext, paramArrayOfString, paramInt);
  }

  private boolean a()
  {
    for (int i = 0; ; i++)
    {
      boolean bool;
      if (i >= NewAlarmActivity.FIXED_DAYS.length)
        bool = true;
      int j;
      int k;
      do
      {
        return bool;
        j = this.mDays;
        k = NewAlarmActivity.FIXED_DAYS[i];
        bool = false;
      }
      while (j == k);
    }
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = LayoutInflater.from(this.mContext).inflate(2130903142, null);
    View localView = paramView.findViewById(2131165678);
    localView.setVisibility(4);
    TextView localTextView = (TextView)paramView.findViewById(2131165679);
    localTextView.setText(this.mShowItems[paramInt]);
    localTextView.setTextColor(this.mContext.getResources().getColor(2131230736));
    Debug.i("SimpleAlarmWeekAdapter", "Get view : mdays:" + this.mDays + ", pos:" + paramInt + ", day:" + NewAlarmActivity.FIXED_DAYS[paramInt]);
    if (paramInt == 3)
      if (a())
      {
        localTextView.setTextColor(this.mContext.getResources().getColor(2131230780));
        localView.setVisibility(0);
      }
    while (this.mDays != NewAlarmActivity.FIXED_DAYS[paramInt])
      return paramView;
    localTextView.setTextColor(this.mContext.getResources().getColor(2131230780));
    localView.setVisibility(0);
    return paramView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.SimpleAlarmWeekAdapter
 * JD-Core Version:    0.6.2
 */