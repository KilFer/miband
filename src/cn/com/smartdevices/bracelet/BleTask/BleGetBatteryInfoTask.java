package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.IMiLiProfile.BatteryInfo;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleGetBatteryInfoTask extends BleTask
{
  public BleGetBatteryInfoTask(BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    IMiLiProfile.BatteryInfo localBatteryInfo = this.gattPeripheral._getBatteryInfo();
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnFinishMessage(localBatteryInfo);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleGetBatteryInfoTask
 * JD-Core Version:    0.6.2
 */