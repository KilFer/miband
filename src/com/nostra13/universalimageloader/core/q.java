package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;

final class q
  implements Runnable
{
  private static final String a = "PostProcess image before displaying [%s]";
  private final c b;
  private final Bitmap c;
  private final k d;
  private final Handler e;

  public q(c paramc, Bitmap paramBitmap, k paramk, Handler paramHandler)
  {
    this.b = paramc;
    this.c = paramBitmap;
    this.d = paramk;
    this.e = paramHandler;
  }

  public final void run()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.d.b;
    L.d("PostProcess image before displaying [%s]", arrayOfObject);
    l.a(new b(this.d.e.getPostProcessor().process(this.c), this.d, this.b, LoadedFrom.MEMORY_CACHE), this.d.e.a(), this.e, this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.q
 * JD-Core Version:    0.6.2
 */