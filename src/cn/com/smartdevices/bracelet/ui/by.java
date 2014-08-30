package cn.com.smartdevices.bracelet.ui;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.eventbus.EventSettingFragmentUpdate;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import de.greenrobot.event.EventBus;

final class by
  implements CompoundButton.OnCheckedChangeListener
{
  by(SettingFragment paramSettingFragment)
  {
  }

  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramBoolean)
      SettingFragment.b(this.a).enableInComingCallTime();
    while (true)
    {
      SettingFragment.b(this.a).setNeedSyncServer(2);
      Keeper.keepPersonInfo(SettingFragment.b(this.a));
      EventBus.getDefault().post(new EventSettingFragmentUpdate());
      return;
      SettingFragment.b(this.a).disableInComingCallTime();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.by
 * JD-Core Version:    0.6.2
 */