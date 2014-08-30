package cn.com.smartdevices.bracelet.ui;

import android.os.Handler;
import cn.com.smartdevices.bracelet.DataManager;

final class V
  implements Runnable
{
  V(DynamicFragment paramDynamicFragment, int paramInt1, int paramInt2)
  {
  }

  public final void run()
  {
    DynamicFragment.g(this.a).load(this.b, this.c);
    DynamicFragment.mHandler.sendEmptyMessage(4114);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.V
 * JD-Core Version:    0.6.2
 */