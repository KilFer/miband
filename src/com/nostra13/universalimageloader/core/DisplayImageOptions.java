package com.nostra13.universalimageloader.core;

import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

public final class DisplayImageOptions
{
  private final int a;
  private final int b;
  private final int c;
  private final Drawable d;
  private final Drawable e;
  private final Drawable f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final ImageScaleType j;
  private final BitmapFactory.Options k;
  private final int l;
  private final boolean m;
  private final Object n;
  private final BitmapProcessor o;
  private final BitmapProcessor p;
  private final BitmapDisplayer q;
  private final Handler r;
  private final boolean s;

  private DisplayImageOptions(DisplayImageOptions.Builder paramBuilder)
  {
    this.a = DisplayImageOptions.Builder.a(paramBuilder);
    this.b = DisplayImageOptions.Builder.b(paramBuilder);
    this.c = DisplayImageOptions.Builder.c(paramBuilder);
    this.d = DisplayImageOptions.Builder.d(paramBuilder);
    this.e = DisplayImageOptions.Builder.e(paramBuilder);
    this.f = DisplayImageOptions.Builder.f(paramBuilder);
    this.g = DisplayImageOptions.Builder.g(paramBuilder);
    this.h = DisplayImageOptions.Builder.h(paramBuilder);
    this.i = DisplayImageOptions.Builder.i(paramBuilder);
    this.j = DisplayImageOptions.Builder.j(paramBuilder);
    this.k = DisplayImageOptions.Builder.k(paramBuilder);
    this.l = DisplayImageOptions.Builder.l(paramBuilder);
    this.m = DisplayImageOptions.Builder.m(paramBuilder);
    this.n = DisplayImageOptions.Builder.n(paramBuilder);
    this.o = DisplayImageOptions.Builder.o(paramBuilder);
    this.p = DisplayImageOptions.Builder.p(paramBuilder);
    this.q = DisplayImageOptions.Builder.q(paramBuilder);
    this.r = DisplayImageOptions.Builder.r(paramBuilder);
    this.s = DisplayImageOptions.Builder.s(paramBuilder);
  }

  public static DisplayImageOptions createSimple()
  {
    return new DisplayImageOptions.Builder().build();
  }

  final boolean a()
  {
    return this.s;
  }

  public final BitmapFactory.Options getDecodingOptions()
  {
    return this.k;
  }

  public final int getDelayBeforeLoading()
  {
    return this.l;
  }

  public final BitmapDisplayer getDisplayer()
  {
    return this.q;
  }

  public final Object getExtraForDownloader()
  {
    return this.n;
  }

  public final Handler getHandler()
  {
    return this.r;
  }

  public final Drawable getImageForEmptyUri(Resources paramResources)
  {
    if (this.b != 0)
      return paramResources.getDrawable(this.b);
    return this.e;
  }

  public final Drawable getImageOnFail(Resources paramResources)
  {
    if (this.c != 0)
      return paramResources.getDrawable(this.c);
    return this.f;
  }

  public final Drawable getImageOnLoading(Resources paramResources)
  {
    if (this.a != 0)
      return paramResources.getDrawable(this.a);
    return this.d;
  }

  public final ImageScaleType getImageScaleType()
  {
    return this.j;
  }

  public final BitmapProcessor getPostProcessor()
  {
    return this.p;
  }

  public final BitmapProcessor getPreProcessor()
  {
    return this.o;
  }

  public final boolean isCacheInMemory()
  {
    return this.h;
  }

  public final boolean isCacheOnDisk()
  {
    return this.i;
  }

  public final boolean isConsiderExifParams()
  {
    return this.m;
  }

  public final boolean isResetViewBeforeLoading()
  {
    return this.g;
  }

  public final boolean shouldDelayBeforeLoading()
  {
    return this.l > 0;
  }

  public final boolean shouldPostProcess()
  {
    return this.p != null;
  }

  public final boolean shouldPreProcess()
  {
    return this.o != null;
  }

  public final boolean shouldShowImageForEmptyUri()
  {
    return (this.e != null) || (this.b != 0);
  }

  public final boolean shouldShowImageOnFail()
  {
    return (this.f != null) || (this.c != 0);
  }

  public final boolean shouldShowImageOnLoading()
  {
    return (this.d != null) || (this.a != 0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DisplayImageOptions
 * JD-Core Version:    0.6.2
 */