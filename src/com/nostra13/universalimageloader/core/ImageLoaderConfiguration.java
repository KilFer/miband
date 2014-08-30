package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;
import com.nostra13.universalimageloader.utils.L;
import java.util.concurrent.Executor;

public final class ImageLoaderConfiguration
{
  final Resources a;
  final int b;
  final int c;
  final BitmapProcessor d;
  final Executor e;
  final Executor f;
  final boolean g;
  final boolean h;
  final int i;
  final int j;
  final QueueProcessingType k;
  final MemoryCache l;
  final DiskCache m;
  final ImageDownloader n;
  final ImageDecoder o;
  final DisplayImageOptions p;
  final ImageDownloader q;
  final ImageDownloader r;
  private int s;
  private int t;

  private ImageLoaderConfiguration(ImageLoaderConfiguration.Builder paramBuilder)
  {
    this.a = ImageLoaderConfiguration.Builder.a(paramBuilder).getResources();
    this.s = ImageLoaderConfiguration.Builder.b(paramBuilder);
    this.t = ImageLoaderConfiguration.Builder.c(paramBuilder);
    this.b = ImageLoaderConfiguration.Builder.d(paramBuilder);
    this.c = ImageLoaderConfiguration.Builder.e(paramBuilder);
    this.d = ImageLoaderConfiguration.Builder.f(paramBuilder);
    this.e = ImageLoaderConfiguration.Builder.g(paramBuilder);
    this.f = ImageLoaderConfiguration.Builder.h(paramBuilder);
    this.i = ImageLoaderConfiguration.Builder.i(paramBuilder);
    this.j = ImageLoaderConfiguration.Builder.j(paramBuilder);
    this.k = ImageLoaderConfiguration.Builder.k(paramBuilder);
    this.m = ImageLoaderConfiguration.Builder.l(paramBuilder);
    this.l = ImageLoaderConfiguration.Builder.m(paramBuilder);
    this.p = ImageLoaderConfiguration.Builder.n(paramBuilder);
    this.n = ImageLoaderConfiguration.Builder.o(paramBuilder);
    this.o = ImageLoaderConfiguration.Builder.p(paramBuilder);
    this.g = ImageLoaderConfiguration.Builder.q(paramBuilder);
    this.h = ImageLoaderConfiguration.Builder.r(paramBuilder);
    this.q = new g(this.n);
    this.r = new h(this.n);
    L.writeDebugLogs(ImageLoaderConfiguration.Builder.s(paramBuilder));
  }

  public static ImageLoaderConfiguration createDefault(Context paramContext)
  {
    return new ImageLoaderConfiguration.Builder(paramContext).build();
  }

  final ImageSize a()
  {
    DisplayMetrics localDisplayMetrics = this.a.getDisplayMetrics();
    int i1 = this.s;
    if (i1 <= 0)
      i1 = localDisplayMetrics.widthPixels;
    int i2 = this.t;
    if (i2 <= 0)
      i2 = localDisplayMetrics.heightPixels;
    return new ImageSize(i1, i2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.ImageLoaderConfiguration
 * JD-Core Version:    0.6.2
 */