package cn.com.smartdevices.bracelet.ui;

import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import java.io.File;

final class J extends BleCallBack
{
  J(BraceletSettingsFragment paramBraceletSettingsFragment, String paramString)
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
      BraceletSettingsFragment.c(this.a);
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
    BraceletSettingsFragment.a(this.a, (int)new File(this.b).length());
    BraceletSettingsFragment.a(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.J
 * JD-Core Version:    0.6.2
 */