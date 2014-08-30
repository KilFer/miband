package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGattCharacteristic;

class AbsGattCallback$9
  implements Runnable
{
  AbsGattCallback$9(AbsGattCallback paramAbsGattCallback, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
  }

  public void run()
  {
    this.this$0.GattCB_onCharacteristicRead(this.val$characteristic);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.9
 * JD-Core Version:    0.6.2
 */