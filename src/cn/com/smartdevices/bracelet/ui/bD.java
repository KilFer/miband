package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import cn.com.smartdevices.bracelet.BraceletApp;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Utils;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.profile.MiLiProfile;

final class bD
  implements Runnable
{
  bD(bC parambC)
  {
  }

  public final void run()
  {
    if (SettingResetBraceletFragment.a(bC.a(this.a)) != null)
    {
      SettingResetBraceletFragment.a(bC.a(this.a)).dismiss();
      SettingResetBraceletFragment.a(bC.a(this.a), null);
    }
    Utils.removeBond(BluetoothDevice.class, ((MiLiProfile)BraceletApp.BLEService.getDefaultPeripheral()).getDevice());
    Activity localActivity = SettingResetBraceletFragment.b(bC.a(this.a));
    if (localActivity == null)
    {
      Debug.i("", "getActivity is null! System.exit(-1) now!");
      System.exit(-1);
      return;
    }
    bC.a(this.a).dismiss();
    Intent localIntent = new Intent();
    localIntent.setClass(localActivity, SearchSingleBraceletActivity.class);
    localIntent.setFlags(268468224);
    localActivity.startActivity(localIntent);
    localActivity.finish();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bD
 * JD-Core Version:    0.6.2
 */