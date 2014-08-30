package cn.com.smartdevices.bracelet.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import java.util.Iterator;
import java.util.List;

final class aD extends BroadcastReceiver
{
  aD(MainUIActivity paramMainUIActivity)
  {
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    Debug.i("MainUIActivity", "action : " + str);
    if ("android.intent.action.DOWNLOAD_COMPLETE".equals(str))
    {
      Debug.i("intent", paramIntent.getLongExtra("extra_download_id", 0L));
      Utils.queryDownloadStatus(this.a);
    }
    while (!"ACTION_BATTERY_LOW".equals(str))
      return;
    ActivityManager localActivityManager = (ActivityManager)this.a.getSystemService("activity");
    List localList = localActivityManager.getRunningTasks(50);
    Iterator localIterator;
    int i;
    if (localList != null)
    {
      localIterator = localList.iterator();
      i = -1;
      if (localIterator.hasNext());
    }
    while (true)
    {
      if (i != -1)
        localActivityManager.moveTaskToFront(i, 0);
      Intent localIntent = new Intent(paramContext, SettingActivity.class);
      localIntent.setFlags(268435456);
      paramContext.startActivity(localIntent);
      return;
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)localIterator.next();
      ComponentName localComponentName = localRunningTaskInfo.baseActivity;
      Debug.i("MainUIActivity", "recent activity:" + localComponentName.getClassName());
      if (!localComponentName.getClassName().contains("cn.com.smartdevices.bracelet.ui.MainUIActivity"))
        break;
      i = localRunningTaskInfo.id;
      break;
      i = -1;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aD
 * JD-Core Version:    0.6.2
 */