package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleResetTask extends BleTask
{
  public BleResetTask(BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    boolean bool = this.gattPeripheral._factoryReset();
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnFinishMessage(Boolean.valueOf(bool));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleResetTask
 * JD-Core Version:    0.6.2
 */