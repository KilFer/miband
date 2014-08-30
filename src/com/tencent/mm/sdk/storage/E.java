package com.tencent.mm.sdk.storage;

final class E
  implements Runnable
{
  E(MStorageEvent paramMStorageEvent, Object paramObject1, Object paramObject2)
  {
  }

  public final void run()
  {
    this.c.processEvent(this.a, this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.E
 * JD-Core Version:    0.6.2
 */