package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo;

final class bx extends BleCallBack
{
  bx(SettingFragment paramSettingFragment, boolean paramBoolean)
  {
  }

  public final void onFailed(Object paramObject)
  {
    super.onFailed(paramObject);
    if (SettingFragment.a(this.a, SettingFragment.c(this.a)))
      return;
    SettingFragment.a(this.a, this.b);
  }

  public final void onFinish(Object paramObject)
  {
    super.onFinish(paramObject);
    if (SettingFragment.a(this.a, SettingFragment.c(this.a)));
    do
    {
      return;
      if (paramObject != null)
        SettingFragment.a(this.a, (IMiLiProfile.BatteryInfo)paramObject);
    }
    while (SettingFragment.d(this.a) == null);
    SettingFragment.a(this.a, this.b);
  }

  public final void onStart()
  {
    super.onStart();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bx
 * JD-Core Version:    0.6.2
 */