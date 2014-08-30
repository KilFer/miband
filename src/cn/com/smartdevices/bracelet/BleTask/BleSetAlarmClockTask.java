package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.AlarmClockItem;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.util.ArrayList;
import java.util.Calendar;

public class BleSetAlarmClockTask extends BleTask
{
  private ArrayList<AlarmClockItem> a = null;

  public BleSetAlarmClockTask(ArrayList<AlarmClockItem> paramArrayList, BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
    this.a = paramArrayList;
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    if (paramBleCallBack != null)
      paramBleCallBack.sendOnStartMessage();
    int i = 0;
    if (i >= this.a.size())
    {
      if (paramBleCallBack != null)
        paramBleCallBack.sendOnFinishMessage(Boolean.valueOf(true));
      return;
    }
    AlarmClockItem localAlarmClockItem = (AlarmClockItem)this.a.get(i);
    Debug.i(TAG, "BleSetAlarmClockTask:" + localAlarmClockItem.toJson());
    int j = localAlarmClockItem.getCoded();
    if (localAlarmClockItem.calendar == null)
      localAlarmClockItem.calendar = Calendar.getInstance();
    Debug.i(TAG, "Set alarm at: " + i + ", " + localAlarmClockItem.getCalendar());
    Debug.f(TAG, "Set alarm at: " + i + ", " + localAlarmClockItem.toJson());
    MiLiProfile localMiLiProfile = this.gattPeripheral;
    byte b = (byte)i;
    if (localAlarmClockItem.isEnabled());
    for (int k = 1; ; k = 0)
    {
      localMiLiProfile.setTimer(b, (byte)k, localAlarmClockItem.calendar, (byte)localAlarmClockItem.getDuration(), (byte)j);
      localAlarmClockItem.setUpdate(false);
      i++;
      break;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleSetAlarmClockTask
 * JD-Core Version:    0.6.2
 */