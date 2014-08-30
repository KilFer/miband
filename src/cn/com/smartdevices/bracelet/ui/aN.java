package cn.com.smartdevices.bracelet.ui;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.view.SelectDaysView;

final class aN
  implements AdapterView.OnItemClickListener
{
  aN(NewAlarmActivity.AlarmRepeatFragment paramAlarmRepeatFragment)
  {
  }

  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Debug.i("NewAlarmActivity", "onItemClick: " + paramInt);
    int i = cn.com.smartdevices.bracelet.model.AlarmClockItem.WEEK_MASK[paramInt];
    int j = (1 << paramInt & NewAlarmActivity.AlarmRepeatFragment.a(this.a)) >> paramInt;
    Debug.i("NewAlarmActivity", "thebit at position: " + paramInt + ", thebit=" + j);
    NewAlarmActivity.AlarmRepeatFragment localAlarmRepeatFragment = this.a;
    if (j == 0);
    for (int k = i | NewAlarmActivity.AlarmRepeatFragment.a(this.a); ; k = NewAlarmActivity.AlarmRepeatFragment.a(this.a) & (i ^ 0xFFFFFFFF))
    {
      NewAlarmActivity.AlarmRepeatFragment.a(localAlarmRepeatFragment, k);
      NewAlarmActivity.AlarmRepeatFragment.b(this.a).setDays(NewAlarmActivity.AlarmRepeatFragment.a(this.a));
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aN
 * JD-Core Version:    0.6.2
 */