package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import com.xiaomi.hm.bleservice.util.Debug;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class AbsGattCallback$18
  implements Runnable
{
  AbsGattCallback$18(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
  }

  public void run()
  {
    Debug.TRACE();
    Debug.ASSERT_RUN_ON_THREAD(AbsGattCallback.access$1());
    Debug.ASSERT_NOT_NULL(this.val$gatt);
    if (this.val$gatt == null)
      AbsGattCallback.access$2().lock();
    boolean bool;
    do
    {
      try
      {
        AbsGattCallback.access$3(65281);
        Debug.DEBUG_LOCK("NOTIFY: synchronizedReadDescriptor(): " + AbsGattCallback.access$4());
        AbsGattCallback.access$5(false);
        AbsGattCallback.access$6().signal();
        return;
      }
      finally
      {
        AbsGattCallback.access$2().unlock();
      }
      bool = this.val$gatt.readDescriptor(this.val$descriptor);
      Debug.ASSERT_TRUE(bool);
    }
    while (bool);
    AbsGattCallback.access$2().lock();
    try
    {
      AbsGattCallback.access$3(65282);
      Debug.DEBUG_LOCK("NOTIFY: synchronizedReadDescriptor(): " + AbsGattCallback.access$4());
      AbsGattCallback.access$5(false);
      AbsGattCallback.access$6().signal();
      return;
    }
    finally
    {
      AbsGattCallback.access$2().unlock();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.18
 * JD-Core Version:    0.6.2
 */