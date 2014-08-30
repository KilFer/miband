package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.UmengAnalytics;

public class PersonInfoActivity extends Activity
{
  private static final String a = "PersonInfoActivity";

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    PersonInfoFragment localPersonInfoFragment = (PersonInfoFragment)getFragmentManager().findFragmentByTag(PersonInfoFragment.class.getName());
    Debug.i("PersonInfoActivity", "person info fragment =" + localPersonInfoFragment);
    if (localPersonInfoFragment != null)
      localPersonInfoFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    localFragmentTransaction.add(16908290, PersonInfoFragment.newInstance(), PersonInfoFragment.class.getName());
    localFragmentTransaction.commit();
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
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.PersonInfoActivity
 * JD-Core Version:    0.6.2
 */