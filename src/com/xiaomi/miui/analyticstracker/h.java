package com.xiaomi.miui.analyticstracker;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class h extends Handler
{
  h(g paramg)
  {
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
      return;
    case 1:
      d.b(this.a.a);
      return;
    case 2:
      d.a(this.a.a, (Event)paramMessage.obj);
      return;
    case 3:
    }
    d.c(this.a.a);
    d.d(this.a.a).getLooper().quit();
    d.a(this.a.a, null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.h
 * JD-Core Version:    0.6.2
 */