package com.xiaomi.hm.bleservice.gatt;

import com.xiaomi.hm.bleservice.util.Debug;
import java.util.concurrent.ThreadFactory;

class AbsGattCallback$1
  implements ThreadFactory
{
  AbsGattCallback$1(AbsGattCallback paramAbsGattCallback)
  {
  }

  public Thread newThread(Runnable paramRunnable)
  {
    Debug.TRACE();
    Debug.INFO("********************************");
    Debug.INFO("NEW THREAD: " + AbsGattCallback.access$0());
    Debug.INFO("********************************");
    Thread localThread = new Thread(paramRunnable, AbsGattCallback.access$0());
    localThread.setUncaughtExceptionHandler(new AbsGattCallback.1.1(this));
    return localThread;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.1
 * JD-Core Version:    0.6.2
 */