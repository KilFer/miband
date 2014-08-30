package com.tencent.mm.sdk.platformtools;

final class e
  implements MTimerHandler.CallBack
{
  e(LBSManager paramLBSManager)
  {
  }

  public final boolean onTimerExpired()
  {
    Log.v("MicroMsg.LBSManager", "get location by GPS failed.");
    this.a.a = true;
    this.a.start();
    LBSManager.a(this.a);
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.e
 * JD-Core Version:    0.6.2
 */