package cn.com.smartdevices.bracelet.BleTask;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Debug;

public class BleCallBack
{
  private static final int a;
  private final int b;
  private final int c;
  private final int d;
  private final String e;
  private Handler f = new a(this);

  public void onFailed(Object paramObject)
  {
    Debug.i("BleCallBack", "onFailed:" + paramObject);
  }

  public void onFinish(Object paramObject)
  {
    Debug.i("BleCallBack", "onFinish:" + paramObject);
  }

  public void onProgress(int paramInt)
  {
    Debug.i("BleCallBack", "onProgress:" + paramInt);
  }

  public void onStart()
  {
    Debug.i("BleCallBack", "onStart");
  }

  public void sendOnFailedMessage(Object paramObject)
  {
    Message localMessage = this.f.obtainMessage(3);
    localMessage.obj = paramObject;
    this.f.sendMessage(localMessage);
  }

  public void sendOnFinishMessage(Object paramObject)
  {
    Message localMessage = this.f.obtainMessage(1);
    localMessage.obj = paramObject;
    this.f.sendMessage(localMessage);
  }

  public void sendOnProgressMessage(int paramInt)
  {
    Message localMessage = this.f.obtainMessage(2);
    localMessage.arg1 = paramInt;
    this.f.sendMessage(localMessage);
  }

  public void sendOnStartMessage()
  {
    Message localMessage = this.f.obtainMessage(0);
    this.f.sendMessage(localMessage);
  }

  public int taskCondition()
  {
    return 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BleTask.BleCallBack
 * JD-Core Version:    0.6.2
 */