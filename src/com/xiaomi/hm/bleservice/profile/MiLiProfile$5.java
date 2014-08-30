package com.xiaomi.hm.bleservice.profile;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback;
import com.xiaomi.hm.bleservice.util.Debug;

class MiLiProfile$5
  implements IGattCallback.INotifyCallback
{
  MiLiProfile$5(MiLiProfile paramMiLiProfile)
  {
  }

  public void notify(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 10);
    byte b;
    int i;
    for (boolean bool = true; ; bool = false)
    {
      Debug.ASSERT_TRUE(bool);
      b = paramArrayOfByte[9];
      i = 0xFF & paramArrayOfByte[0];
      switch (b)
      {
      default:
        Debug.WARN(">>> UNEXPECTED <<<");
        return;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    Debug.WARN(">>> UNEXPECTED <<<");
    while (true)
    {
      Intent localIntent = new Intent(MiLiProfile.INTENT_ACTION_DEVICE_BATTERY_STATUS_CHANGED);
      localIntent.putExtra(BLEService.INTENT_EXTRA_DEVICE, this.this$0.getDevice());
      localIntent.putExtra(BLEService.INTENT_EXTRA_PARAM, b);
      localIntent.putExtra(BLEService.INTENT_EXTRA_PARAM_EXT, i);
      BLEService.getBroadcastManager().sendBroadcast(localIntent);
      return;
      Debug.DEBUG("Battery low");
      continue;
      Debug.DEBUG("Battery charging");
      continue;
      Debug.DEBUG("Battery full (charging)");
      continue;
      Debug.DEBUG("Battery charger off");
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.MiLiProfile.5
 * JD-Core Version:    0.6.2
 */