package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGattDescriptor;

class AbsGattCallback$14
  implements Runnable
{
  AbsGattCallback$14(AbsGattCallback paramAbsGattCallback, BluetoothGattDescriptor paramBluetoothGattDescriptor)
  {
  }

  public void run()
  {
    this.this$0.GattCB_onDescriptorWrite(this.val$descriptor);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.14
 * JD-Core Version:    0.6.2
 */