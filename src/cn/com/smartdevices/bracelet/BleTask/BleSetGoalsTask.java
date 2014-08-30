package cn.com.smartdevices.bracelet.BleTask;

import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class BleSetGoalsTask extends BleTask
{
  private int a = 8000;

  public BleSetGoalsTask(int paramInt, BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
    this.a = paramInt;
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (this.callback != null)
      this.callback.sendOnStartMessage();
    boolean bool = this.gattPeripheral.setGoal((byte)0, this.a);
    if (this.callback != null)
      this.callback.sendOnFinishMessage(Boolean.valueOf(bool));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleSetGoalsTask
 * JD-Core Version:    0.6.2
 */