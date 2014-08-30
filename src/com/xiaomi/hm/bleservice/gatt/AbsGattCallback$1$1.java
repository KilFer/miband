package com.xiaomi.hm.bleservice.gatt;

import com.xiaomi.hm.bleservice.util.Debug;

class AbsGattCallback$1$1
  implements Thread.UncaughtExceptionHandler
{
  AbsGattCallback$1$1(AbsGattCallback.1 param1)
  {
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Debug.TRACE();
    paramThrowable.printStackTrace();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.1.1
 * JD-Core Version:    0.6.2
 */