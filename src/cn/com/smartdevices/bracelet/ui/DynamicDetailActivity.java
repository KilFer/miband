package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.AnalyticsTrackerManager;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.model.PersonInfo;

public class DynamicDetailActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Intent localIntent = getIntent();
    Bundle localBundle = null;
    if (localIntent != null)
      localBundle = localIntent.getExtras();
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.add(16908290, Fragment.instantiate(this, DynamicDetailFragment.class.getName(), localBundle));
    localFragmentTransaction.commit();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }

  protected void onPause()
  {
    super.onPause();
    AnalyticsTrackerManager.endTimedEvent(new String[] { "EventDynamicDetailPage" });
    AnalyticsTrackerManager.endSession(this);
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    AnalyticsTrackerManager.startSession(this, Keeper.readPersonInfo().uid);
    AnalyticsTrackerManager.trackTimedEvent("EventDynamicDetailPage");
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.DynamicDetailActivity
 * JD-Core Version:    0.6.2
 */