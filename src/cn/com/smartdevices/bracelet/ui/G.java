package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.view.Util;

final class G extends BleCallBack
{
  G(BraceletSettingsFragment paramBraceletSettingsFragment)
  {
  }

  public final void onFailed(Object paramObject)
  {
    super.onFailed(paramObject);
    Util.hideProgressDialog();
    Toast.makeText(this.a.getActivity(), this.a.getActivity().getString(2131492937), 0).show();
  }

  public final void onFinish(Object paramObject)
  {
    super.onFinish(paramObject);
    Util.hideProgressDialog();
  }

  public final void onStart()
  {
    super.onStart();
    Util.showProgressDialog(this.a.getActivity(), "正在重置手环", "请稍等！");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.G
 * JD-Core Version:    0.6.2
 */