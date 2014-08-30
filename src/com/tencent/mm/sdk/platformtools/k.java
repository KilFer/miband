package com.tencent.mm.sdk.platformtools;

import android.os.HandlerThread;

final class k
  implements MMHandlerThread.IWaitWorkThread
{
  k(MMHandlerThread paramMMHandlerThread, MMHandlerThread.ResetCallback paramResetCallback, Object paramObject)
  {
  }

  public final boolean doInBackground()
  {
    Log.d("MicroMsg.MMHandlerThread", "syncReset doInBackground");
    MMHandlerThread.a(this.c).quit();
    if (this.a != null)
      this.a.callback();
    MMHandlerThread.b(this.c);
    synchronized (this.b)
    {
      this.b.notify();
      return true;
    }
  }

  public final boolean onPostExecute()
  {
    Log.d("MicroMsg.MMHandlerThread", "syncReset onPostExecute");
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.k
 * JD-Core Version:    0.6.2
 */