package cn.com.smartdevices.bracelet.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;

final class aK
  implements View.OnClickListener
{
  aK(NewAlarmActivity paramNewAlarmActivity)
  {
  }

  public final void onClick(View paramView)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("Days", NewAlarmActivity.a(this.a).getCoded());
    DimPanelFragment.showPanel(this.a, NewAlarmActivity.AlarmSimpleRepeatFragment.class, localBundle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aK
 * JD-Core Version:    0.6.2
 */