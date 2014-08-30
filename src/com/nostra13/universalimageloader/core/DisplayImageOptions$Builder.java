package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

public class DisplayImageOptions$Builder
{
  private int a = 0;
  private int b = 0;
  private int c = 0;
  private Drawable d = null;
  private Drawable e = null;
  private Drawable f = null;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private ImageScaleType j = ImageScaleType.IN_SAMPLE_POWER_OF_2;
  private BitmapFactory.Options k = new BitmapFactory.Options();
  private int l = 0;
  private boolean m = false;
  private Object n = null;
  private BitmapProcessor o = null;
  private BitmapProcessor p = null;
  private BitmapDisplayer q = DefaultConfigurationFactory.createBitmapDisplayer();
  private Handler r = null;
  private boolean s = false;

  public DisplayImageOptions$Builder()
  {
    this.k.inPurgeable = true;
    this.k.inInputShareable = true;
  }

  final Builder a(boolean paramBoolean)
  {
    this.s = true;
    return this;
  }

  public Builder bitmapConfig(Bitmap.Config paramConfig)
  {
    if (paramConfig == null)
      throw new IllegalArgumentException("bitmapConfig can't be null");
    this.k.inPreferredConfig = paramConfig;
    return this;
  }

  public DisplayImageOptions build()
  {
    return new DisplayImageOptions(this, (byte)0);
  }

  public Builder cacheInMemory()
  {
    this.h = true;
    return this;
  }

  public Builder cacheInMemory(boolean paramBoolean)
  {
    this.h = paramBoolean;
    return this;
  }

  public Builder cacheOnDisc()
  {
    return cacheOnDisk(true);
  }

  public Builder cacheOnDisc(boolean paramBoolean)
  {
    return cacheOnDisk(paramBoolean);
  }

  public Builder cacheOnDisk(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }

  public Builder cloneFrom(DisplayImageOptions paramDisplayImageOptions)
  {
    this.a = DisplayImageOptions.a(paramDisplayImageOptions);
    this.b = DisplayImageOptions.b(paramDisplayImageOptions);
    this.c = DisplayImageOptions.c(paramDisplayImageOptions);
    this.d = DisplayImageOptions.d(paramDisplayImageOptions);
    this.e = DisplayImageOptions.e(paramDisplayImageOptions);
    this.f = DisplayImageOptions.f(paramDisplayImageOptions);
    this.g = DisplayImageOptions.g(paramDisplayImageOptions);
    this.h = DisplayImageOptions.h(paramDisplayImageOptions);
    this.i = DisplayImageOptions.i(paramDisplayImageOptions);
    this.j = DisplayImageOptions.j(paramDisplayImageOptions);
    this.k = DisplayImageOptions.k(paramDisplayImageOptions);
    this.l = DisplayImageOptions.l(paramDisplayImageOptions);
    this.m = DisplayImageOptions.m(paramDisplayImageOptions);
    this.n = DisplayImageOptions.n(paramDisplayImageOptions);
    this.o = DisplayImageOptions.o(paramDisplayImageOptions);
    this.p = DisplayImageOptions.p(paramDisplayImageOptions);
    this.q = DisplayImageOptions.q(paramDisplayImageOptions);
    this.r = DisplayImageOptions.r(paramDisplayImageOptions);
    this.s = DisplayImageOptions.s(paramDisplayImageOptions);
    return this;
  }

  public Builder considerExifParams(boolean paramBoolean)
  {
    this.m = paramBoolean;
    return this;
  }

  public Builder decodingOptions(BitmapFactory.Options paramOptions)
  {
    if (paramOptions == null)
      throw new IllegalArgumentException("decodingOptions can't be null");
    this.k = paramOptions;
    return this;
  }

  public Builder delayBeforeLoading(int paramInt)
  {
    this.l = paramInt;
    return this;
  }

  public Builder displayer(BitmapDisplayer paramBitmapDisplayer)
  {
    if (paramBitmapDisplayer == null)
      throw new IllegalArgumentException("displayer can't be null");
    this.q = paramBitmapDisplayer;
    return this;
  }

  public Builder extraForDownloader(Object paramObject)
  {
    this.n = paramObject;
    return this;
  }

  public Builder handler(Handler paramHandler)
  {
    this.r = paramHandler;
    return this;
  }

  public Builder imageScaleType(ImageScaleType paramImageScaleType)
  {
    this.j = paramImageScaleType;
    return this;
  }

  public Builder postProcessor(BitmapProcessor paramBitmapProcessor)
  {
    this.p = paramBitmapProcessor;
    return this;
  }

  public Builder preProcessor(BitmapProcessor paramBitmapProcessor)
  {
    this.o = paramBitmapProcessor;
    return this;
  }

  public Builder resetViewBeforeLoading()
  {
    this.g = true;
    return this;
  }

  public Builder resetViewBeforeLoading(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }

  public Builder showImageForEmptyUri(int paramInt)
  {
    this.b = paramInt;
    return this;
  }

  public Builder showImageForEmptyUri(Drawable paramDrawable)
  {
    this.e = paramDrawable;
    return this;
  }

  public Builder showImageOnFail(int paramInt)
  {
    this.c = paramInt;
    return this;
  }

  public Builder showImageOnFail(Drawable paramDrawable)
  {
    this.f = paramDrawable;
    return this;
  }

  public Builder showImageOnLoading(int paramInt)
  {
    this.a = paramInt;
    return this;
  }

  public Builder showImageOnLoading(Drawable paramDrawable)
  {
    this.d = paramDrawable;
    return this;
  }

  public Builder showStubImage(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.DisplayImageOptions.Builder
 * JD-Core Version:    0.6.2
 */