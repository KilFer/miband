package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothGattCharacteristic;

public abstract interface IGattProfile
{
  public abstract void cleanup();

  public abstract boolean init();

  public abstract byte[] read(BluetoothGattCharacteristic paramBluetoothGattCharacteristic);

  public abstract boolean write(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.IGattProfile
 * JD-Core Version:    0.6.2
 */