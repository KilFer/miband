package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGattCharacteristic;

class AbsGattCallback$10
  implements Runnable
{
  AbsGattCallback$10(AbsGattCallback paramAbsGattCallback, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
  }

  public void run()
  {
    this.this$0.GattCB_onCharacteristicWrite(this.val$characteristic);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.10
 * JD-Core Version:    0.6.2
 */