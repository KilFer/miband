package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.xiaomi.hm.bleservice.util.Debug;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class AbsGattCallback$16
  implements Runnable
{
  AbsGattCallback$16(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
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
        Debug.DEBUG_LOCK("NOTIFY: synchronizedReadCharacteristic(): " + AbsGattCallback.access$4());
        AbsGattCallback.access$5(false);
        AbsGattCallback.access$6().signal();
        return;
      }
      finally
      {
        AbsGattCallback.access$2().unlock();
      }
      bool = this.val$gatt.readCharacteristic(this.val$characteristic);
      Debug.ASSERT_TRUE(bool);
    }
    while (bool);
    AbsGattCallback.access$2().lock();
    try
    {
      AbsGattCallback.access$3(65282);
      Debug.DEBUG_LOCK("NOTIFY: synchronizedReadCharacteristic(): " + AbsGattCallback.access$4());
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
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.16
 * JD-Core Version:    0.6.2
 */