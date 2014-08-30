package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Handler;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;

final class bC extends BleCallBack
{
  bC(SettingResetBraceletFragment paramSettingResetBraceletFragment)
  {
  }

  public final void onFailed(Object paramObject)
  {
    super.onFailed(paramObject);
    if (SettingResetBraceletFragment.a(this.a) != null)
    {
      SettingResetBraceletFragment.a(this.a).dismiss();
      SettingResetBraceletFragment.a(this.a, null);
    }
    Toast.makeText(this.a.getActivity(), this.a.getActivity().getString(2131492937), 0).show();
  }

  public final void onFinish(Object paramObject)
  {
    super.onFinish(paramObject);
    new Handler().postDelayed(new bD(this), 10000L);
  }

  public final void onStart()
  {
    super.onStart();
    if (this.a.getActivity() != null)
      SettingResetBraceletFragment.a(this.a, ProgressDialog.show(this.a.getActivity(), this.a.getString(2131492990), this.a.getString(2131493086)));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bC
 * JD-Core Version:    0.6.2
 */