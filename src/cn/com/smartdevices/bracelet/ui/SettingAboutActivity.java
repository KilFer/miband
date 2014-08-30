package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;
import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.eventbus.EventApkupgrade;
import de.greenrobot.event.EventBus;

public class SettingAboutActivity extends Activity
{
  private static final String a = "SettingAboutActivity";
  private SettingAboutActivity.SettingAboutFragment b = null;
  private BroadcastReceiver c;

  private void a()
  {
    this.c = new bf(this);
    registerReceiver(this.c, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    EventBus.getDefault().register(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    this.b = ((SettingAboutActivity.SettingAboutFragment)Fragment.instantiate(this, SettingAboutActivity.SettingAboutFragment.class.getName()));
    localFragmentTransaction.add(16908290, this.b);
    localFragmentTransaction.commit();
    this.c = new bf(this);
    registerReceiver(this.c, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
    EventBus.getDefault().register(this);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    unregisterReceiver(this.c);
    this.c = null;
    EventBus.getDefault().unregister(this);
  }

  public void onEvent(EventApkupgrade paramEventApkupgrade)
  {
    Debug.i("SettingAboutActivity", "onEvent, + changelog=" + paramEventApkupgrade.getChangeLog() + ", force=" + paramEventApkupgrade.isForceCheck() + " HasWindowfocus=" + hasWindowFocus());
    if (hasWindowFocus())
      Utils.checkXiaomiApkUpdate(this, paramEventApkupgrade.isForceCheck(), paramEventApkupgrade.getChangeLog());
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
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startSession(this);
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingAboutActivity
 * JD-Core Version:    0.6.2
 */