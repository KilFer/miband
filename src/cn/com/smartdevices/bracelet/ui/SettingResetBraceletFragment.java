package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.View;
import cn.com.smartdevices.bracelet.BleTask.BleResetTask;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

public class SettingResetBraceletFragment extends DimPanelFragment
{
  private Activity a;
  private ProgressDialog b = null;

  private void a()
  {
    new BleResetTask(new bC(this)).work();
  }

  protected int inflateLayout()
  {
    this.a = getActivity();
    Debug.i(getTag(), "mContext = " + this.a);
    return 2130903106;
  }

  protected void onLeftButtonClicked()
  {
    MiLiProfile localMiLiProfile = (MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral();
    if (localMiLiProfile == null)
    {
      dismiss();
      return;
    }
    localMiLiProfile.setAutoReconnect(false);
    new BleResetTask(new bC(this)).work();
    this.mRightButton.setEnabled(false);
  }

  protected void onRightButtomClicked()
  {
    dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.SettingResetBraceletFragment
 * JD-Core Version:    0.6.2
 */