package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class bs
  implements DialogInterface.OnClickListener
{
  bs(SettingFirmwareActivity.SettingFirmwareFragment paramSettingFirmwareFragment)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bs
 * JD-Core Version:    0.6.2
 */