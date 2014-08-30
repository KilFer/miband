package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleSetWearLocationTask extends BleTask
{
  public static final byte LEFT = 0;
  public static final byte RIGHT = 1;
  private byte a = 0;

  public BleSetWearLocationTask(BleCallBack paramBleCallBack, byte paramByte)
  {
    super(paramBleCallBack);
    this.a = paramByte;
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    Debug.i(TAG, "location:" + this.a);
    boolean bool = this.gattPeripheral.setWearLocation(this.a);
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnFinishMessage(Boolean.valueOf(bool));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleSetWearLocationTask
 * JD-Core Version:    0.6.2
 */