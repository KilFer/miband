package com.xiaomi.hm.bleservice.profile;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.xiaomi.hm.bleservice.BLEService;
import com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback;
import com.xiaomi.hm.bleservice.util.Debug;

class MiLiProfile$2
  implements IGattCallback.INotifyCallback
{
  MiLiProfile$2(MiLiProfile paramMiLiProfile)
  {
  }

  public void notify(byte[] paramArrayOfByte)
  {
    int i = 1;
    if (paramArrayOfByte.length == i);
    while (true)
    {
      Debug.ASSERT_TRUE(i);
      Debug.INFO("=================================================");
      Debug.INFO("========== NOTIFICATION STATUS CHANGED ==========");
      Debug.INFO("=================================================");
      Intent localIntent = new Intent(MiLiProfile.INTENT_ACTION_DEVICE_STATUS_CHANGED);
      localIntent.putExtra(BLEService.INTENT_EXTRA_DEVICE, this.this$0.getDevice());
      localIntent.putExtra(BLEService.INTENT_EXTRA_PARAM, paramArrayOfByte[0]);
      BLEService.getBroadcastManager().sendBroadcast(localIntent);
      return;
      int j = 0;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.MiLiProfile.2
 * JD-Core Version:    0.6.2
 */