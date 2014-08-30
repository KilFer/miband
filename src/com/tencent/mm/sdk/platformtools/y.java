package com.tencent.mm.sdk.platformtools;

final class y
  implements Runnable
{
  y(SyncTask paramSyncTask)
  {
  }

  public final void run()
  {
    SyncTask.a(this.a, Util.ticksToNow(SyncTask.a(this.a)));
    this.a.setResult(this.a.run());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.y
 * JD-Core Version:    0.6.2
 */