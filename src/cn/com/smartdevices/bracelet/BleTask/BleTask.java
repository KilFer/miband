package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class BleTask
  implements Runnable
{
  public static String TAG = "BleTask";
  public static final int TASK_CONTINUE = 2;
  public static final int TASK_SLEEP = 2;
  public static final int TASK_START = 0;
  public static final int TASK_STOP = 1;
  private static ExecutorService a = Executors.newSingleThreadExecutor();
  private static ExecutorService b = Executors.newSingleThreadExecutor();
  protected BleCallBack callback = null;
  protected MiLiProfile gattPeripheral = null;

  public BleTask(BleCallBack paramBleCallBack)
  {
    if (BraceletApp.BLEService == null)
      return;
    this.callback = paramBleCallBack;
    this.gattPeripheral = ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral());
  }

  public abstract void doWork(BleCallBack paramBleCallBack);

  public void run()
  {
    Debug.i(TAG, "BleTask Run..........................................in:" + getClass().getName());
    if (Utils.isBraceletConnected())
      doWork(this.callback);
    while (true)
    {
      Debug.i(TAG, "BleTask Run..........................................out:" + getClass().getName());
      return;
      if (this.callback != null)
        this.callback.sendOnFailedMessage(Boolean.valueOf(false));
    }
  }

  public void work()
  {
    a.execute(this);
  }

  public void workX()
  {
    b.execute(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleTask
 * JD-Core Version:    0.6.2
 */