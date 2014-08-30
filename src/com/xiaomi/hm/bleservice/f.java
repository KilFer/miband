package com.xiaomi.hm.bleservice;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.xiaomi.hm.bleservice.util.Debug;
import com.xiaomi.hm.bleservice.util.Helper;
import java.util.Map;

final class f
  implements BluetoothAdapter.LeScanCallback
{
  f(BLEService paramBLEService, Map paramMap)
  {
  }

  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    Debug.TRACE();
    String str = paramBluetoothDevice.getName();
    Debug.DEBUG("device: " + str + "," + paramBluetoothDevice.getAddress());
    Debug.DEBUG("scanRecord: " + Helper.bytesToHexString(paramArrayOfByte));
    Helper.parseAdvData(paramArrayOfByte);
    if (!paramBluetoothDevice.getAddress().startsWith("88:0F:10"));
    do
    {
      return;
      if (BLEService.access$5(this.a) != null)
        paramBluetoothDevice.getAddress().equals(BLEService.access$5(this.a).getAddress());
    }
    while (this.b.containsKey(paramBluetoothDevice.getAddress()));
    this.b.put(paramBluetoothDevice.getAddress(), paramBluetoothDevice);
    Intent localIntent = new Intent(BLEService.INTENT_ACTION_DEVICE_FOUND);
    localIntent.putExtra(BLEService.INTENT_EXTRA_DEVICE, paramBluetoothDevice);
    localIntent.putExtra(BLEService.INTENT_EXTRA_PARAM, paramInt);
    localIntent.putExtra(BLEService.INTENT_EXTRA_PARAM_EXT, paramArrayOfByte);
    BLEService.access$6().sendBroadcast(localIntent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.f
 * JD-Core Version:    0.6.2
 */