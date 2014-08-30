package cn.com.smartdevices.bracelet.ui;

import android.content.Context;
import android.widget.Toast;
import cn.com.smartdevices.bracelet.BleTask.BleCallBack;
import cn.com.smartdevices.bracelet.Debug;

final class aM extends BleCallBack
{
  aM(NewAlarmActivity paramNewAlarmActivity)
  {
  }

  public final void onFailed(Object paramObject)
  {
    super.onFailed(paramObject);
    Toast.makeText(NewAlarmActivity.b(this.a), NewAlarmActivity.b(this.a).getString(2131492937), 0).show();
  }

  public final void onFinish(Object paramObject)
  {
    super.onFinish(paramObject);
    Debug.i("NewAlarmActivity", "set alarm to mili OK");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.aM
 * JD-Core Version:    0.6.2
 */