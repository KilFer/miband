package cn.com.smartdevices.bracelet.ui;

import cn.com.smartdevices.bracelet.BraceletApp;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.IRealtimeStepsChangedCB;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

final class W
  implements Runnable
{
  W(DynamicFragment paramDynamicFragment, boolean paramBoolean, IMiLiProfile.IRealtimeStepsChangedCB paramIRealtimeStepsChangedCB)
  {
  }

  public final void run()
  {
    if (BraceletApp.BLEService == null);
    MiLiProfile localMiLiProfile;
    do
    {
      return;
      localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
    }
    while (localMiLiProfile == null);
    if (this.b)
    {
      int i = localMiLiProfile.getRealtimeSteps();
      if (i != -1)
        this.c.process(i);
    }
    localMiLiProfile.enableRealtimeStepNotification(this.b, this.c);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.W
 * JD-Core Version:    0.6.2
 */