package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;

public class StatisticActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    String str = localIntent.getStringExtra("type");
    if (str != null)
    {
      if (str.compareTo("weekreport") != 0)
        break label85;
      Debug.i("chenee", "weeeeeeeeeeeeeeeeekkkkkkkkkkkk");
    }
    while (true)
    {
      Bundle localBundle = null;
      if (localIntent != null)
        localBundle = localIntent.getExtras();
      FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
      localFragmentTransaction.add(16908290, Fragment.instantiate(this, StatisticFragment.class.getName(), localBundle));
      localFragmentTransaction.commit();
      return;
      label85: if (str.compareTo("monthreport") == 0)
        Debug.i("chenee", "mooooooooooooooooothhhhhhhhhh");
    }
  }

  protected void onPause()
  {
    super.onPause();
    AnalyticsTrackerManager.endTimedEvent(new String[] { "EventStatisticPage" });
    AnalyticsTrackerManager.endSession(this);
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    AnalyticsTrackerManager.startSession(this, Keeper.readPersonInfo().uid);
    AnalyticsTrackerManager.trackTimedEvent("EventStatisticPage");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.StatisticActivity
 * JD-Core Version:    0.6.2
 */