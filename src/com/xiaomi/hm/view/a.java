package com.xiaomi.hm.view;

import android.os.Handler;
import android.os.SystemClock;

final class a
  implements Runnable
{
  private a(GifAnimation paramGifAnimation)
  {
  }

  public final void run()
  {
    int i = GifAnimation.a(this.a).reDraw();
    if (!GifAnimation.b(this.a))
      if (i > 0)
        SystemClock.sleep(i);
    synchronized (GifAnimation.c(this.a))
    {
      if (!GifAnimation.b(this.a))
        GifAnimation.d(this.a).post(GifAnimation.c(this.a));
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.view.a
 * JD-Core Version:    0.6.2
 */