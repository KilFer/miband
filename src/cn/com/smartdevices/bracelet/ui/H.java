package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cn.com.smartdevices.bracelet.Keeper;
import cn.com.smartdevices.bracelet.model.BraceletBtInfo;

final class H
  implements DialogInterface.OnClickListener
{
  H(BraceletSettingsFragment paramBraceletSettingsFragment, String paramString)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    BraceletBtInfo localBraceletBtInfo = Keeper.readBraceletBtInfo();
    BraceletSettingsFragment.a(this.a, localBraceletBtInfo.address, this.b);
    paramDialogInterface.dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.H
 * JD-Core Version:    0.6.2
 */