package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

final class o
  implements Runnable
{
  o(l paraml)
  {
  }

  public final void run()
  {
    this.a.d.onLoadingCancelled(this.a.a, this.a.b.getWrappedView());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.o
 * JD-Core Version:    0.6.2
 */