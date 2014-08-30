package com.handmark.pulltorefresh.library;

import android.view.animation.Interpolator;
import com.handmark.pulltorefresh.library.internal.ViewCompat;

final class e
  implements Runnable
{
  private final Interpolator a;
  private final int b;
  private final int c;
  private final long d;
  private d e;
  private boolean f = true;
  private long g = -1L;
  private int h = -1;

  public e(PullToRefreshBase paramPullToRefreshBase, int paramInt1, int paramInt2, long paramLong, d paramd)
  {
    this.c = paramInt1;
    this.b = paramInt2;
    this.a = PullToRefreshBase.a(paramPullToRefreshBase);
    this.d = paramLong;
    this.e = paramd;
  }

  public final void a()
  {
    this.f = false;
    this.i.removeCallbacks(this);
  }

  public final void run()
  {
    if (this.g == -1L)
    {
      this.g = System.currentTimeMillis();
      if ((!this.f) || (this.b == this.h))
        break label126;
      ViewCompat.postOnAnimation(this.i, this);
    }
    label126: 
    while (this.e == null)
    {
      return;
      long l = Math.max(Math.min(1000L * (System.currentTimeMillis() - this.g) / this.d, 1000L), 0L);
      int j = Math.round((this.c - this.b) * this.a.getInterpolation((float)l / 1000.0F));
      this.h = (this.c - j);
      this.i.setHeaderScroll(this.h);
      break;
    }
    this.e.a();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.e
 * JD-Core Version:    0.6.2
 */