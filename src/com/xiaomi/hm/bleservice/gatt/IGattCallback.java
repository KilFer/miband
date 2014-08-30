package com.xiaomi.hm.bleservice.gatt;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.List;
import java.util.UUID;

public abstract interface IGattCallback
{
  public static final int ERROR_GATT_INVALID = 65281;
  public static final int ERROR_GATT_OPERATION_FAILED = 65282;
  public static final int ERROR_GATT_SUCCESS = 0;
  public static final int ERROR_GATT_UNKNOWN = 65534;

  public abstract void connect();

  public abstract void disconnect();

  public abstract boolean getAutoReconnect();

  public abstract BluetoothDevice getDevice();

  public abstract BluetoothGattService getService(UUID paramUUID);

  public abstract List<BluetoothGattService> getServices();

  public abstract IGattCallback.STATE getState();

  public abstract int readCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic);

  public abstract int readRemoteRSSI();

  public abstract void refreshGatt();

  public abstract boolean registerNotification(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, IGattCallback.INotifyCallback paramINotifyCallback);

  public abstract void setAutoReconnect(boolean paramBoolean);

  public abstract boolean unregisterNotification(BluetoothGattCharacteristic paramBluetoothGattCharacteristic);

  public abstract int writeCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, byte[] paramArrayOfByte);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.IGattCallback
 * JD-Core Version:    0.6.2
 */