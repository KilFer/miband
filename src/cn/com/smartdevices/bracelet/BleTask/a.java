package cn.com.smartdevices.bracelet.BleTask;

import android.os.Handler;
import android.os.Message;

final class a extends Handler
{
  a(BleCallBack paramBleCallBack)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 0:
      this.a.onStart();
      return;
    case 1:
      this.a.onFinish(paramMessage.obj);
      return;
    case 2:
      this.a.onProgress(paramMessage.arg1);
      return;
    case 3:
    }
    this.a.onFailed(paramMessage.obj);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.a
 * JD-Core Version:    0.6.2
 */