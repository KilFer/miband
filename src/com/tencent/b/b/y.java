package com.tencent.b.b;

import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class y extends Handler
{
  public y(n paramn)
  {
    super(Looper.getMainLooper());
  }

  public final void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default:
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 256:
    case 16:
    case 8:
    }
    do
    {
      do
      {
        do
        {
          return;
          n.a(this.a, (e.a)paramMessage.obj);
          return;
          n.a(this.a, (m.b)paramMessage.obj);
          return;
          n.a(this.a, (f.b)paramMessage.obj);
          return;
          n.a(this.a, paramMessage.arg1);
          return;
          n.b(this.a, paramMessage.arg1);
          return;
          n.a(this.a, (Location)paramMessage.obj);
          return;
        }
        while (n.e(this.a) != 1);
        n.c(this.a);
        return;
      }
      while (paramMessage.obj == null);
      n.a(this.a, (String)paramMessage.obj);
      n.f(this.a);
      return;
      if (paramMessage.arg1 == 0)
      {
        n.b(this.a, (String)paramMessage.obj);
        return;
      }
    }
    while ((n.g(this.a) != null) && (n.g(this.a).a()));
    n.h(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.y
 * JD-Core Version:    0.6.2
 */