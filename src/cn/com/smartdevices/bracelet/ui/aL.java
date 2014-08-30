package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;

final class aL
  implements CompoundButton.OnCheckedChangeListener
{
  aL(NewAlarmActivity paramNewAlarmActivity)
  {
  }

  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      NewAlarmActivity.a(this.a).setDuration(30);
      return;
    }
    NewAlarmActivity.a(this.a).setDuration(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aL
 * JD-Core Version:    0.6.2
 */