package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import android.os.Message;
import cn.com.smartdevices.bracelet.Debug;
import cn.com.smartdevices.bracelet.Keeper;

final class U extends Handler
{
  U(DynamicFragment paramDynamicFragment)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 4116:
    case 4117:
    case 4118:
    default:
      return;
    case 4113:
      DynamicFragment.a(this.a, "加载运动数据", "正在加载运动数据，请稍候...");
      return;
    case 4114:
      DynamicFragment.c(this.a);
      Debug.i("DDDD", "Dynamic Update : Data Loaded,Prev/Next Day,Animation");
      DynamicFragment.a(this.a, false);
      return;
    case 4115:
      DynamicFragment.c(this.a, paramMessage.arg1);
      Keeper.keepSyncRealStepTime(System.currentTimeMillis());
      Debug.i("DDDD", "Dynamic Update : Real Steps.");
      DynamicFragment.a(this.a, true);
      return;
    case 4119:
      DynamicFragment.d(this.a);
      return;
    case 4120:
      DynamicFragment.e(this.a);
      return;
    case 4121:
    }
    DynamicFragment.f(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.U
 * JD-Core Version:    0.6.2
 */