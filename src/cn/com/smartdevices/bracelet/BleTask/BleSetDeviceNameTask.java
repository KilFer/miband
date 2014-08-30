package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleSetDeviceNameTask extends BleTask
{
  public static final int FAIL = 0;
  public static final int TOO_LONG = 1;
  private final String a;

  public BleSetDeviceNameTask(BleCallBack paramBleCallBack, String paramString)
  {
    super(paramBleCallBack);
    this.a = paramString;
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    boolean bool = this.gattPeripheral._setDeviceName(this.a);
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnFinishMessage(Boolean.valueOf(bool));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleSetDeviceNameTask
 * JD-Core Version:    0.6.2
 */