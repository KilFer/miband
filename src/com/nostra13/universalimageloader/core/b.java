package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.utils.L;

final class b
  implements Runnable
{
  private static final String a = "Display image in ImageAware (loaded from %1$s) [%2$s]";
  private static final String b = "ImageAware is reused for another image. Task is cancelled. [%s]";
  private static final String c = "ImageAware was collected by GC. Task is cancelled. [%s]";
  private final Bitmap d;
  private final String e;
  private final ImageAware f;
  private final String g;
  private final BitmapDisplayer h;
  private final ImageLoadingListener i;
  private final c j;
  private final LoadedFrom k;

  public b(Bitmap paramBitmap, k paramk, c paramc, LoadedFrom paramLoadedFrom)
  {
    this.d = paramBitmap;
    this.e = paramk.a;
    this.f = paramk.c;
    this.g = paramk.b;
    this.h = paramk.e.getDisplayer();
    this.i = paramk.f;
    this.j = paramc;
    this.k = paramLoadedFrom;
  }

  private boolean a()
  {
    String str = this.j.a(this.f);
    return !this.g.equals(str);
  }

  public final void run()
  {
    if (this.f.isCollected())
    {
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.g;
      L.d("ImageAware was collected by GC. Task is cancelled. [%s]", arrayOfObject3);
      this.i.onLoadingCancelled(this.e, this.f.getWrappedView());
      return;
    }
    String str = this.j.a(this.f);
    if (!this.g.equals(str));
    for (int m = 1; m != 0; m = 0)
    {
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.g;
      L.d("ImageAware is reused for another image. Task is cancelled. [%s]", arrayOfObject2);
      this.i.onLoadingCancelled(this.e, this.f.getWrappedView());
      return;
    }
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.k;
    arrayOfObject1[1] = this.g;
    L.d("Display image in ImageAware (loaded from %1$s) [%2$s]", arrayOfObject1);
    this.h.display(this.d, this.f, this.k);
    this.j.b(this.f);
    this.i.onLoadingComplete(this.e, this.f.getWrappedView(), this.d);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.b
 * JD-Core Version:    0.6.2
 */