package cn.com.smartdevices.bracelet;

import cn.com.smartdevices.bracelet.BleTask.BleCallBack;

final class f extends BleCallBack
{
  public final void onFailed(Object paramObject)
  {
    super.onFailed(paramObject);
    Debug.i("Utils", "\n                 sendUserInfo2Mili fail");
  }

  public final void onFinish(Object paramObject)
  {
    super.onFinish(paramObject);
    if (paramObject != null)
      Debug.i("Utils", "     sendUserInfo2Mili ok!");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.f
 * JD-Core Version:    0.6.2
 */