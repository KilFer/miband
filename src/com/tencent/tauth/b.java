package com.tencent.tauth;

import android.os.Message;

final class b
  implements Runnable
{
  b(LocationApi paramLocationApi)
  {
  }

  public final void run()
  {
    if (LocationApi.b(this.a).verifyRegCode())
    {
      Message.obtain(LocationApi.c(this.a), 103).sendToTarget();
      return;
    }
    Message.obtain(LocationApi.c(this.a), 104).sendToTarget();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.tauth.b
 * JD-Core Version:    0.6.2
 */