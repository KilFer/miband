package com.xiaomi.hm.bleservice.profile;

import com.xiaomi.hm.bleservice.gatt.IGattCallback.INotifyCallback;
import java.io.IOException;
import java.io.PipedOutputStream;

class MiLiProfile$4
  implements IGattCallback.INotifyCallback
{
  MiLiProfile$4(MiLiProfile paramMiLiProfile)
  {
  }

  public void notify(byte[] paramArrayOfByte)
  {
    try
    {
      MiLiProfile.access$2(this.this$0).write(paramArrayOfByte);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.profile.MiLiProfile.4
 * JD-Core Version:    0.6.2
 */