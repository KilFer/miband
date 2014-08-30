package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.view.View;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.Debug;

final class aJ extends BleCallBack
{
  aJ(MiliRenameFragment paramMiliRenameFragment)
  {
  }

  public final void onFailed(Object paramObject)
  {
    super.onFailed(paramObject);
    this.a.mRightButton.setEnabled(true);
    Toast.makeText(this.a.getActivity(), 2131493002, 0).show();
    if (((Integer)paramObject).intValue() == 0)
    {
      Toast.makeText(this.a.getActivity(), 2131493004, 1).show();
      return;
    }
    Toast.makeText(this.a.getActivity(), 2131493003, 1).show();
  }

  public final void onFinish(Object paramObject)
  {
    super.onFinish(paramObject);
    Toast.makeText(this.a.getActivity(), 2131493001, 0).show();
    Fragment localFragment = this.a.getFragmentManager().findFragmentByTag(SettingFragment.class.getName());
    Debug.i("MiliRenameFragment", "miliFragment = " + localFragment);
    this.a.dismiss();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aJ
 * JD-Core Version:    0.6.2
 */