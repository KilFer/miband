package cn.com.smartdevices.bracelet.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cn.com.smartdevices.bracelet.upgrade.UpgradeUtil;

final class aF
  implements DialogInterface.OnClickListener
{
  aF(MainUIActivity paramMainUIActivity, String paramString)
  {
  }

  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UpgradeUtil.downloadApkFile(this.a.getApplicationContext(), this.b);
    paramDialogInterface.dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aF
 * JD-Core Version:    0.6.2
 */