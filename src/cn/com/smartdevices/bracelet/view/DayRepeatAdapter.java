package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

public class DayRepeatAdapter extends WeekAdapter
{
  private static final String a = "DayRepeatAdapter";

  public DayRepeatAdapter(Context paramContext, String[] paramArrayOfString, int paramInt)
  {
    super(paramContext, paramArrayOfString, paramInt);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = LayoutInflater.from(this.mContext).inflate(2130903143, null);
    TextView localTextView = (TextView)paramView.findViewById(2131165679);
    localTextView.setText(this.mShowItems[paramInt]);
    localTextView.setTextColor(this.mContext.getResources().getColor(2131230736));
    ImageView localImageView = (ImageView)paramView.findViewById(2131165680);
    if ((this.mDays & cn.com.smartdevices.bracelet.model.AlarmClockItem.WEEK_MASK[paramInt]) != 0);
    for (int i = 1; i != 0; i = 0)
    {
      Debug.i("DayRepeatAdapter", "mDays =" + this.mDays + ", checkbox = " + localImageView);
      localImageView.setImageResource(2130837576);
      return paramView;
    }
    localImageView.setImageResource(2130837577);
    return paramView;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.DayRepeatAdapter
 * JD-Core Version:    0.6.2
 */