package cn.com.smartdevices.bracelet.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class SettingFirmwareActivity extends Activity
{
  private SettingFirmwareActivity.SettingFirmwareFragment a = null;

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    this.a = ((SettingFirmwareActivity.SettingFirmwareFragment)Fragment.instantiate(this, SettingFirmwareActivity.SettingFirmwareFragment.class.getName()));
    localFragmentTransaction.add(16908290, this.a);
    localFragmentTransaction.commit();
    ActionBar localActionBar = getActionBar();
    localActionBar.setDisplayHomeAsUpEnabled(true);
    localActionBar.setDisplayShowHomeEnabled(false);
    localActionBar.setDisplayUseLogoEnabled(false);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689473, paramMenu);
    return true;
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      finish();
      return true;
    }
    if ((paramMenuItem.getItemId() == 2131165687) && (this.a != null) && (this.a.isVisible()))
      this.a.confirmFwUpgrade();
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingFirmwareActivity
 * JD-Core Version:    0.6.2
 */