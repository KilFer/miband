package cn.com.smartdevices.bracelet.ui;

import android.app.Activity;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.Debug;

final class aW extends BleCallBack
{
  aW(PersonInfoFragment paramPersonInfoFragment)
  {
  }

  public final void onFailed(Object paramObject)
  {
    super.onFailed(paramObject);
    Toast.makeText(this.a.getActivity(), this.a.getActivity().getString(2131492937), 0).show();
  }

  public final void onFinish(Object paramObject)
  {
    super.onFinish(paramObject);
    Debug.i("PersonInfoFragment", "sync to bracelet ok");
  }

  public final void onStart()
  {
    super.onStart();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aW
 * JD-Core Version:    0.6.2
 */