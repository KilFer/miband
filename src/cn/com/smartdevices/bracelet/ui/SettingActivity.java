package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class SettingActivity extends Activity
{
  private static final String a = "SettingActivity";

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    SettingFragment localSettingFragment = (SettingFragment)getFragmentManager().findFragmentByTag(SettingFragment.class.getName());
    Debug.i("SettingActivity", "setting fragment =" + localSettingFragment);
    if (localSettingFragment != null)
      localSettingFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.add(16908290, SettingFragment.newInstance(), SettingFragment.class.getName());
    localFragmentTransaction.commit();
    Debug.i("SettingActivity", "onCreate");
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    Debug.i("SettingActivity", "onNewIntent");
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
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingActivity
 * JD-Core Version:    0.6.2
 */