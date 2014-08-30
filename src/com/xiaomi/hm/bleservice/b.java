package com.xiaomi.hm.bleservice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class b extends Handler
{
  b(BLEService paramBLEService, Looper paramLooper)
  {
    super(paramLooper);
  }

  public final void handleMessage(Message paramMessage)
  {
    BLEService.access$0(this.a, paramMessage);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.b
 * JD-Core Version:    0.6.2
 */