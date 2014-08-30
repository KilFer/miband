package com.xiaomi.miui.analyticstracker;

import android.os.Looper;

final class g extends Thread
{
  private g(d paramd)
  {
  }

  public final void run()
  {
    Looper.prepare();
    synchronized (d.a(this.a))
    {
      d.a(this.a, new h(this));
      d.a(this.a).notify();
      Looper.loop();
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.g
 * JD-Core Version:    0.6.2
 */