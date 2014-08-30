package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.DeviceInfo;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import com.xiaomi.hm.bleservice.util.Helper;
import java.io.FileInputStream;

public class BleFwUpgradeTask extends BleTask
{
  private static Object d = new Object();
  private static Object e = new Object();
  private String a = null;
  private String b = null;
  private byte[] c = null;

  public BleFwUpgradeTask(String paramString1, String paramString2, BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
    this.a = paramString2;
    this.b = paramString1;
  }

  public BleFwUpgradeTask(String paramString, byte[] paramArrayOfByte, BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
    this.c = paramArrayOfByte;
    this.b = paramString;
  }

  public static void waiting()
  {
    synchronized (d)
    {
      Debug.i(TAG, "BleFwUpgradeTask before waiting...");
    }
    try
    {
      d.wait(10000L);
      label23: Debug.i(TAG, "BleFwUpgradeTask after waiting..." + e);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label23;
    }
  }

  public static void waitingNotify(Object paramObject)
  {
    Debug.i(TAG, "waitingNotify:" + paramObject);
    synchronized (d)
    {
      e = paramObject;
      d.notify();
      return;
    }
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    Thread.currentThread().setPriority(10);
    e = Integer.valueOf(-1);
    paramBleCallBack.sendOnStartMessage();
    if (this.a != null);
    int k;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.a);
      this.c = new byte[localFileInputStream.available()];
      localFileInputStream.read(this.c);
      localFileInputStream.close();
      if ((this.c == null) || (this.c.length <= 0))
      {
        Debug.i(TAG, "no fw data!");
        paramBleCallBack.sendOnFinishMessage(Integer.valueOf(1));
        return;
      }
    }
    catch (Exception localException)
    {
      while (true)
        this.c = null;
      int i = Utils.getFwVersion(this.c);
      Debug.i(TAG, "new firmware version:" + i);
      String[] arrayOfString = this.b.split(":");
      int j = ((0xFF & Integer.decode("0x" + arrayOfString[4]).byteValue()) << 8 | 0xFF & Integer.decode("0x" + arrayOfString[5]).byteValue()) ^ Helper.CRC16(this.c);
      if (!this.gattPeripheral.sendFirmwareInfo(this.gattPeripheral.getDeviceInfo().firmwareVersion, i, this.c.length, j))
      {
        Debug.i(TAG, "prepareFirmwareUpdate failed!");
        paramBleCallBack.sendOnFinishMessage(Integer.valueOf(1));
        return;
      }
      if (((Integer)e).intValue() == -1)
        waiting();
      if (((Integer)e).intValue() != 12)
      {
        paramBleCallBack.sendOnFinishMessage(Integer.valueOf(1));
        return;
      }
      e = Integer.valueOf(-1);
      if (!this.gattPeripheral.sendFirmwareData(this.c))
      {
        Debug.i(TAG, "sendFirmwareData failed!");
        paramBleCallBack.sendOnFinishMessage(Integer.valueOf(1));
        this.gattPeripheral.resetFirmwareUpdatingProgress();
        return;
      }
      if (((Integer)e).intValue() == -1)
        waiting();
      k = ((Integer)e).intValue();
      if (k != -1);
    }
    for (int m = 1; ; m = k)
    {
      boolean bool = false;
      if (m == 2)
        bool = this.gattPeripheral._reboot();
      if (bool);
      for (int n = 2; ; n = 1)
      {
        paramBleCallBack.sendOnFinishMessage(Integer.valueOf(n));
        this.gattPeripheral.resetFirmwareUpdatingProgress();
        return;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleFwUpgradeTask
 * JD-Core Version:    0.6.2
 */