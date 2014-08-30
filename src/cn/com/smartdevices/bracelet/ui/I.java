package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class I
  implements DialogInterface.OnClickListener
{
  I(BraceletSettingsFragment paramBraceletSettingsFragment)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.I
 * JD-Core Version:    0.6.2
 */