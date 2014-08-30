package cn.com.smartdevices.bracelet.BleTask;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.model.DaySportData;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityData;
import com.xiaomi.hm.bleservice.profile.IMiLiProfile.ActivityDataFragment;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BleSyncDataTask extends BleTask
{
  private long a = 0L;

  public BleSyncDataTask(long paramLong, BleCallBack paramBleCallBack)
  {
    super(paramBleCallBack);
    this.a = paramLong;
  }

  public void doWork(BleCallBack paramBleCallBack)
  {
    Debug.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    Debug.i(TAG, "===========================start sync data================================");
    Debug.i(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    Debug.f(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    Debug.f(TAG, "===========================start sync data================================");
    Debug.f(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    paramBleCallBack.sendOnStartMessage();
    List localList1 = this.gattPeripheral.getActivities();
    if (localList1 == null)
    {
      Debug.f(TAG, "getActivities return null,now finish!");
      paramBleCallBack.sendOnFinishMessage(Long.valueOf(-1L));
      return;
    }
    Iterator localIterator1 = localList1.iterator();
    if (!localIterator1.hasNext())
    {
      Debug.f(TAG, "analysis...............................before");
      DataManager.getInstance().analysis();
      Debug.f(TAG, "analysis...............................after");
      Debug.f(TAG, "saveToDb...............................before");
      DataManager.getInstance().saveToDb();
      Debug.f(TAG, "saveToDb...............................after");
      Debug.f(TAG, "initDays...............................before");
      DataManager.getInstance().initDays();
      Debug.f(TAG, "initDays...............................after");
      paramBleCallBack.sendOnFinishMessage(Long.valueOf(this.a));
      this.gattPeripheral.resetActivitySyncingProgress();
      Debug.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      Debug.i(TAG, "============================stop sync data================================");
      Debug.i(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      Debug.f(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      Debug.f(TAG, "============================stop sync data================================");
      Debug.f(TAG, "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
      return;
    }
    IMiLiProfile.ActivityDataFragment localActivityDataFragment = (IMiLiProfile.ActivityDataFragment)localIterator1.next();
    List localList2 = localActivityDataFragment.data;
    Calendar localCalendar = localActivityDataFragment.timestamp;
    Debug.i(TAG, "data size:" + localList2.size() + ",data time:" + localCalendar.getTime().toString());
    Debug.f(TAG, "data size:" + localList2.size() + ",data time:" + localCalendar.getTime().toString());
    Iterator localIterator2 = localList2.iterator();
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        this.a = localCalendar.getTimeInMillis();
        break;
      }
      IMiLiProfile.ActivityData localActivityData = (IMiLiProfile.ActivityData)localIterator2.next();
      int i = localCalendar.get(1);
      int j = localCalendar.get(2);
      int k = localCalendar.get(5);
      int m = localCalendar.get(11);
      int n = localCalendar.get(12) + m * 60;
      DaySportData localDaySportData = DataManager.getInstance().getSync(i, j, k);
      if (localDaySportData == null)
      {
        localDaySportData = new DaySportData(i, j, k);
        DataManager.getInstance().add(localDaySportData);
      }
      localDaySportData.setNeedSync(true);
      localDaySportData.setNeedPostProcess(true);
      localDaySportData.add(n, localActivityData);
      localCalendar.add(12, 1);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleSyncDataTask
 * JD-Core Version:    0.6.2
 */