package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleSetColorThemeTask extends BleTask
{
  public static final int BLUE = 1542;
  public static final byte FLAG_SLASH_NONE = 0;
  public static final byte FLAG_SLASH_NOW = 1;
  public static final int GREEN = 263424;
  public static final int ORANGE = 393728;
  public static final int RED = 393474;
  private int a = 1542;
  private byte b = 0;

  public BleSetColorThemeTask(BleCallBack paramBleCallBack, int paramInt)
  {
    super(paramBleCallBack);
    this.a = paramInt;
    this.b = 1;
  }

  public BleSetColorThemeTask(BleCallBack paramBleCallBack, int paramInt, byte paramByte)
  {
    super(paramBleCallBack);
    this.a = paramInt;
    this.b = paramByte;
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    byte b1 = (byte)(this.a >> 16);
    byte b2 = (byte)(this.a >> 8);
    byte b3 = (byte)this.a;
    Debug.i(TAG, "r=" + b1 + ",g=" + b2 + ",b=" + b3);
    boolean bool = this.gattPeripheral.setColorTheme(b1, b2, b3, this.b);
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnFinishMessage(Boolean.valueOf(bool));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleSetColorThemeTask
 * JD-Core Version:    0.6.2
 */