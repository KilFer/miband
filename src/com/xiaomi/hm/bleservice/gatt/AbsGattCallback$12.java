package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGattCharacteristic;

class AbsGattCallback$12
  implements Runnable
{
  AbsGattCallback$12(AbsGattCallback paramAbsGattCallback, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
  }

  public void run()
  {
    this.this$0.GattCB_onCharacteristicChanged(this.val$characteristic);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.12
 * JD-Core Version:    0.6.2
 */