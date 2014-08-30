package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class bu
  implements DialogInterface.OnCancelListener
{
  bu(SettingFirmwareActivity.SettingFirmwareFragment.DownloadFirmwareHandler paramDownloadFirmwareHandler)
  {
  }

  public final void onCancel(DialogInterface paramDialogInterface)
  {
    SettingFirmwareActivity.SettingFirmwareFragment.DownloadFirmwareHandler.a(this.a, true);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bu
 * JD-Core Version:    0.6.2
 */