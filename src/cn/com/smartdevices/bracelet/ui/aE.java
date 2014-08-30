package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cn.com.smartdevices.bracelet.upgrade.UpgradeUtil;

final class aE
  implements DialogInterface.OnClickListener
{
  aE(MainUIActivity paramMainUIActivity)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeUtil.updateCheckState(this.a.getApplicationContext());
    paramDialogInterface.dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aE
 * JD-Core Version:    0.6.2
 */