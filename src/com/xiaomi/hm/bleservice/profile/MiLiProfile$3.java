package com.xiaomi.hm.bleservice.profile;

import com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback;
import com.xiaomi.hm.bleservice.util.Debug;

class MiLiProfile$3
  implements IGattCallback.INotifyCallback
{
  MiLiProfile$3(MiLiProfile paramMiLiProfile)
  {
  }

  public void notify(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length == 2);
    for (boolean bool = true; ; bool = false)
    {
      Debug.ASSERT_TRUE(bool);
      int i = 0xFF & paramArrayOfByte[0] | (0xFF & paramArrayOfByte[1]) << 8;
      Debug.DEBUG("RealtimeSteps: " + i);
      MiLiProfile.access$1(this.this$0, i);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.MiLiProfile.3
 * JD-Core Version:    0.6.2
 */