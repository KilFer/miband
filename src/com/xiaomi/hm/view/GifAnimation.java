package com.xiaomi.hm.view;

import android.os.Handler;
import android.os.Looper;

public class GifAnimation
{
  private GifReDraw a = null;
  private boolean b = false;
  private Handler c = new Handler(Looper.getMainLooper());
  private a d = new a(this, (byte)0);

  public void destroy()
  {
    stopAnimation();
    this.a = null;
  }

  public void pauseAnimation()
  {
    synchronized (this.d)
    {
      this.c.removeCallbacks(this.d);
      this.b = true;
      return;
    }
  }

  public void restartAnimation()
  {
    synchronized (this.d)
    {
      this.b = false;
      this.c.post(this.d);
      return;
    }
  }

  public void runAnimation()
  {
    this.b = false;
    this.c.post(this.d);
  }

  public void setRedraw(GifReDraw paramGifReDraw)
  {
    this.a = paramGifReDraw;
  }

  public void stopAnimation()
  {
    pauseAnimation();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.hm.view.GifAnimation
 * JD-Core Version:    0.6.2
 */