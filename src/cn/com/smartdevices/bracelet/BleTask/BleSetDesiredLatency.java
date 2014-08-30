package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.LEParams;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleSetDesiredLatency extends BleTask
{
  public static String TAG = "BleTaskX";
  private static final int b = 2;
  private static Object c = new Object();
  protected static Object waitingResult = new Object();
  private int a = 0;

  public BleSetDesiredLatency(int paramInt, BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
    this.a = paramInt;
  }

  private void a(int paramInt)
  {
    Debug.i(TAG, "value:" + paramInt);
    Debug.f(TAG, "value:" + paramInt);
    waitingResult = Integer.valueOf(-1);
    boolean bool;
    if (paramInt == 39)
      bool = this.gattPeripheral._setLEParams(39, 49, 0, 1000, 0);
    while (true)
    {
      if ((bool) && (((Integer)waitingResult).intValue() == -1))
        synchronized (c)
        {
          Debug.i(TAG, "before waiting...");
        }
      try
      {
        c.wait(10000L);
        label116: Debug.i(TAG, "after waiting..." + waitingResult);
        IMiLiProfile.LEParams localLEParams = this.gattPeripheral._getLEParams();
        Debug.i(TAG, "out setLatency!\n" + localLEParams);
        Debug.f(TAG, "out setLatency!\n" + localLEParams);
        return;
        bool = false;
        if (paramInt != 480)
          continue;
        bool = this.gattPeripheral._setLEParams(460, 500, 0, 1000, 0);
        continue;
        localObject2 = finally;
        throw localObject2;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label116;
      }
    }
  }

  private static void a(long paramLong)
  {
    synchronized (c)
    {
      Debug.i(TAG, "before waiting...");
    }
    try
    {
      c.wait(10000L);
      label23: Debug.i(TAG, "after waiting..." + waitingResult);
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
    synchronized (c)
    {
      waitingResult = paramObject;
      c.notify();
      return;
    }
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    IMiLiProfile.LEParams localLEParams1 = this.gattPeripheral._getLEParams();
    if (localLEParams1 != null)
    {
      Debug.i(TAG, "set latency:" + this.a + "\n" + localLEParams1);
      Debug.f(TAG, "set latency:" + this.a + "\n" + localLEParams1);
      if (this.a == 39)
      {
        if ((localLEParams1.connInt < 39) || (localLEParams1.connInt > 49))
          break label165;
        paramBleCallBack.sendOnFinishMessage(Integer.valueOf(8));
      }
    }
    label165: int i;
    label167: int j;
    while (paramBleCallBack == null)
    {
      if ((this.a == 480) && (localLEParams1.connInt >= 460) && (localLEParams1.connInt <= 500))
      {
        paramBleCallBack.sendOnFinishMessage(Integer.valueOf(8));
        return;
      }
      i = 0;
      j = i + 1;
      if (i < 2)
        break;
    }
    paramBleCallBack.sendOnFinishMessage(waitingResult);
    return;
    int k = this.a;
    Debug.i(TAG, "value:" + k);
    Debug.f(TAG, "value:" + k);
    waitingResult = Integer.valueOf(-1);
    boolean bool;
    if (k == 39)
      bool = this.gattPeripheral._setLEParams(39, 49, 0, 1000, 0);
    while (true)
    {
      if ((bool) && (((Integer)waitingResult).intValue() == -1))
        a(10000L);
      IMiLiProfile.LEParams localLEParams2 = this.gattPeripheral._getLEParams();
      Debug.i(TAG, "out setLatency!\n" + localLEParams2);
      Debug.f(TAG, "out setLatency!\n" + localLEParams2);
      if (((Integer)waitingResult).intValue() == 8)
        break;
      i = j;
      break label167;
      if (k == 480)
        bool = this.gattPeripheral._setLEParams(460, 500, 0, 1000, 0);
      else
        bool = false;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleSetDesiredLatency
 * JD-Core Version:    0.6.2
 */