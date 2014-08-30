package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class D
  implements DialogInterface.OnClickListener
{
  D(BraceletSettingsFragment paramBraceletSettingsFragment)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    BraceletSettingsFragment.b(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.D
 * JD-Core Version:    0.6.2
 */