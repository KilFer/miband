package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

final class m
  implements Runnable
{
  m(l paraml, int paramInt1, int paramInt2)
  {
  }

  public final void run()
  {
    this.c.e.onProgressUpdate(this.c.a, this.c.b.getWrappedView(), this.a, this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.m
 * JD-Core Version:    0.6.2
 */