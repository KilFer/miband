package cn.com.smartdevices.bracelet.ui;

import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import java.io.File;

final class bt extends BleCallBack
{
  bt(SettingFirmwareActivity.SettingFirmwareFragment paramSettingFirmwareFragment, String paramString)
  {
  }

  public final void onFinish(Object paramObject)
  {
    super.onFinish(paramObject);
    int i = ((Integer)paramObject).intValue();
    if (i == 1)
      Toast.makeText(this.a.getActivity(), "固件升级失败！", 1).show();
    while (true)
    {
      SettingFirmwareActivity.SettingFirmwareFragment.c(this.a);
      return;
      if (i == 2)
        Toast.makeText(this.a.getActivity(), "固件升级成功!", 1).show();
      else if (i == 0)
        Toast.makeText(this.a.getActivity(), "固件升级状态未知！", 1).show();
    }
  }

  public final void onStart()
  {
    super.onStart();
    SettingFirmwareActivity.SettingFirmwareFragment.a(this.a, (int)new File(this.b).length());
    SettingFirmwareActivity.SettingFirmwareFragment.b(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bt
 * JD-Core Version:    0.6.2
 */