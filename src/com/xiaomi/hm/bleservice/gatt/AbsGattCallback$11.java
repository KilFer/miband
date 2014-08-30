package com.xiaomi.hm.bleservice.gatt;

class AbsGattCallback$11
  implements Runnable
{
  AbsGattCallback$11(AbsGattCallback paramAbsGattCallback, IGattCallback.INotifyCallback paramINotifyCallback, byte[] paramArrayOfByte)
  {
  }

  public void run()
  {
    this.val$notifyCB.notify(this.val$value);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.bleservice.gatt.AbsGattCallback.11
 * JD-Core Version:    0.6.2
 */