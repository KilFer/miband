package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import cn.com.smartdevices.bracelet.Debug;

final class aO
  implements AdapterView.OnItemClickListener
{
  aO(NewAlarmActivity.AlarmSimpleRepeatFragment paramAlarmSimpleRepeatFragment)
  {
  }

  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Debug.i("NewAlarmActivity", "onItemClick: " + paramInt);
    switch (paramInt)
    {
    default:
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (true)
    {
      this.a.dismiss();
      return;
      NewAlarmActivity.AlarmSimpleRepeatFragment.a(this.a, NewAlarmActivity.FIXED_DAYS[paramInt]);
      NewAlarmActivity.a((NewAlarmActivity)this.a.getActivity(), NewAlarmActivity.AlarmSimpleRepeatFragment.a(this.a));
      continue;
      Intent localIntent = new Intent(this.a.getActivity(), AlarmRepeatActivity.class);
      localIntent.putExtra("Days", NewAlarmActivity.AlarmSimpleRepeatFragment.a(this.a));
      this.a.getActivity().startActivityForResult(localIntent, 1);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aO
 * JD-Core Version:    0.6.2
 */