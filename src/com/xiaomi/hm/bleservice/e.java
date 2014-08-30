package com.xiaomi.hm.bleservice;

import android.os.Handler;
import android.os.HandlerThread;
import com.xiaomi.hm.bleservice.gatt.IGattCallback;
import com.xiaomi.hm.bleservice.gatt.IGattCallback.STATE;
import com.xiaomi.hm.bleservice.util.Debug;

final class e
  implements Runnable
{
  e(BLEService paramBLEService)
  {
  }

  public final void run()
  {
    if ((BLEService.access$3(this.a) != null) && ((BLEService.access$3(this.a).getState() == IGattCallback.STATE.CONNECTED) || (BLEService.access$3(this.a).getState() == IGattCallback.STATE.CONNECTING)))
    {
      Debug.WARN("Quiting HandlerThread postponed for 500ms... (due to m_State=" + BLEService.access$3(this.a).getState() + ")");
      BLEService.access$1(this.a).postDelayed(this, 500L);
      return;
    }
    Debug.DEBUG("Quiting HandlerThread...");
    BLEService.access$4(this.a).quitSafely();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.e
 * JD-Core Version:    0.6.2
 */