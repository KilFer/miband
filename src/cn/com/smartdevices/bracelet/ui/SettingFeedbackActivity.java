package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class SettingFeedbackActivity extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.add(16908290, Fragment.instantiate(this, SettingFeedbackFragment.class.getName()));
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
    UmengAnalytics.endSession(this);
  }

  protected void onResume()
  {
    super.onResume();
    UmengAnalytics.startSession(this);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingFeedbackActivity
 * JD-Core Version:    0.6.2
 */