package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleInComingCallTask extends BleTask
{
  public BleInComingCallTask(BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    boolean bool = this.gattPeripheral._sendNotification((byte)1);
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnFinishMessage(Boolean.valueOf(bool));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleInComingCallTask
 * JD-Core Version:    0.6.2
 */