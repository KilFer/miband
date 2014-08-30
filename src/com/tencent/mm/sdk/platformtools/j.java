package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;

final class j
  implements MMHandlerThread.IWaitWorkThread
{
  j(MMHandlerThread paramMMHandlerThread, MMHandlerThread.IWaitWorkThread paramIWaitWorkThread)
  {
  }

  public final boolean doInBackground()
  {
    if (this.a != null)
      return this.a.doInBackground();
    MMHandlerThread.a(this.b).quit();
    MMHandlerThread.b(this.b);
    return true;
  }

  public final boolean onPostExecute()
  {
    if (this.a != null)
      return this.a.onPostExecute();
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.j
 * JD-Core Version:    0.6.2
 */