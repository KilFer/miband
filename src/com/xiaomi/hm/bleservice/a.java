package com.xiaomi.hm.bleservice;

import com.xiaomi.hm.bleservice.util.Debug;

final class a
  implements Thread.UncaughtExceptionHandler
{
  a(BLEService paramBLEService)
  {
  }

  public final void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Debug.TRACE();
    paramThrowable.printStackTrace();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.a
 * JD-Core Version:    0.6.2
 */