package com.tencent.mm.sdk.platformtools;

final class l
  implements Runnable
{
  l(MMHandlerThread paramMMHandlerThread, MMHandlerThread.IWaitWorkThread paramIWaitWorkThread)
  {
  }

  public final void run()
  {
    this.a.doInBackground();
    MMHandlerThread.a(new m(this));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.l
 * JD-Core Version:    0.6.2
 */