package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

final class n
  implements Runnable
{
  n(l paraml, FailReason.FailType paramFailType, Throwable paramThrowable)
  {
  }

  public final void run()
  {
    if (this.c.c.shouldShowImageOnFail())
      this.c.b.setImageDrawable(this.c.c.getImageOnFail(l.a(this.c).a));
    this.c.d.onLoadingFailed(this.c.a, this.c.b.getWrappedView(), new FailReason(this.a, this.b));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.n
 * JD-Core Version:    0.6.2
 */