package com.xiaomi.hm.bleservice.profile;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback;
import com.xiaomi.hm.bleservice.util.Debug;

class MiLiProfile$1
  implements IGattCallback.INotifyCallback
{
  MiLiProfile$1(MiLiProfile paramMiLiProfile)
  {
  }

  public void notify(byte[] paramArrayOfByte)
  {
    Debug.INFO("=================================================");
    Debug.INFO("============= DEVICE STATUS CHANGED =============");
    Debug.INFO("=================================================");
    Intent localIntent = new Intent(MiLiProfile.INTENT_ACTION_DEVICE_STATUS_CHANGED);
    localIntent.putExtra(BLEService.INTENT_EXTRA_DEVICE, this.this$0.getDevice());
    localIntent.putExtra(BLEService.INTENT_EXTRA_PARAM, paramArrayOfByte[16]);
    BLEService.getBroadcastManager().sendBroadcast(localIntent);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.MiLiProfile.1
 * JD-Core Version:    0.6.2
 */