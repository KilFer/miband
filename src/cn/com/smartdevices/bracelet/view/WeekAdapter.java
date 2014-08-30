package cn.com.smartdevices.bracelet.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import cn.com.smartdevices.bracelet.Debug;

public class WeekAdapter extends BaseAdapter
{
  private static final String a = "WeekAdapter";
  protected final Context mContext;
  protected int mDays;
  protected int mSetDays;
  protected String[] mShowItems;

  public WeekAdapter(Context paramContext, String[] paramArrayOfString, int paramInt)
  {
    this.mContext = paramContext;
    this.mDays = paramInt;
    this.mShowItems = paramArrayOfString;
    Debug.i("WeekAdapter", "mDays =" + Long.toHexString(this.mDays));
  }

  public int getCount()
  {
    return this.mShowItems.length;
  }

  public int getDays()
  {
    return this.mSetDays;
  }

  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
      paramView = LayoutInflater.from(this.mContext).inflate(2130903142, null);
    TextView localTextView = (TextView)paramView.findViewById(2131165679);
    localTextView.setText(this.mShowItems[paramInt]);
    ImageView localImageView = (ImageView)paramView.findViewById(2131165678);
    localImageView.setImageResource(2130837512);
    if ((this.mDays & cn.com.smartdevices.bracelet.model.AlarmClockItem.WEEK_MASK[paramInt]) != 0);
    for (int i = 1; i != 0; i = 0)
    {
      localImageView.setVisibility(0);
      localTextView.setTextColor(this.mContext.getResources().getColor(2131230732));
      return paramView;
    }
    localImageView.setVisibility(4);
    localTextView.setTextColor(this.mContext.getResources().getColor(2131230736));
    return paramView;
  }

  public void setDays(int paramInt)
  {
    this.mDays = paramInt;
    notifyDataSetChanged();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.view.WeekAdapter
 * JD-Core Version:    0.6.2
 */