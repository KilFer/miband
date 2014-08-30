package com.nostra13.universalimageloader.core.decode;

import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;

public class ImageDecodingInfo
{
  private final String a;
  private final String b;
  private final String c;
  private final ImageSize d;
  private final ImageScaleType e;
  private final ViewScaleType f;
  private final ImageDownloader g;
  private final Object h;
  private final boolean i;
  private final BitmapFactory.Options j;

  public ImageDecodingInfo(String paramString1, String paramString2, String paramString3, ImageSize paramImageSize, ViewScaleType paramViewScaleType, ImageDownloader paramImageDownloader, DisplayImageOptions paramDisplayImageOptions)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.d = paramImageSize;
    this.e = paramDisplayImageOptions.getImageScaleType();
    this.f = paramViewScaleType;
    this.g = paramImageDownloader;
    this.h = paramDisplayImageOptions.getExtraForDownloader();
    this.i = paramDisplayImageOptions.isConsiderExifParams();
    this.j = new BitmapFactory.Options();
    BitmapFactory.Options localOptions1 = paramDisplayImageOptions.getDecodingOptions();
    BitmapFactory.Options localOptions2 = this.j;
    localOptions2.inDensity = localOptions1.inDensity;
    localOptions2.inDither = localOptions1.inDither;
    localOptions2.inInputShareable = localOptions1.inInputShareable;
    localOptions2.inJustDecodeBounds = localOptions1.inJustDecodeBounds;
    localOptions2.inPreferredConfig = localOptions1.inPreferredConfig;
    localOptions2.inPurgeable = localOptions1.inPurgeable;
    localOptions2.inSampleSize = localOptions1.inSampleSize;
    localOptions2.inScaled = localOptions1.inScaled;
    localOptions2.inScreenDensity = localOptions1.inScreenDensity;
    localOptions2.inTargetDensity = localOptions1.inTargetDensity;
    localOptions2.inTempStorage = localOptions1.inTempStorage;
    if (Build.VERSION.SDK_INT >= 10)
      localOptions2.inPreferQualityOverSpeed = localOptions1.inPreferQualityOverSpeed;
    if (Build.VERSION.SDK_INT >= 11)
    {
      localOptions2.inBitmap = localOptions1.inBitmap;
      localOptions2.inMutable = localOptions1.inMutable;
    }
  }

  private void a(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inDensity = paramOptions1.inDensity;
    paramOptions2.inDither = paramOptions1.inDither;
    paramOptions2.inInputShareable = paramOptions1.inInputShareable;
    paramOptions2.inJustDecodeBounds = paramOptions1.inJustDecodeBounds;
    paramOptions2.inPreferredConfig = paramOptions1.inPreferredConfig;
    paramOptions2.inPurgeable = paramOptions1.inPurgeable;
    paramOptions2.inSampleSize = paramOptions1.inSampleSize;
    paramOptions2.inScaled = paramOptions1.inScaled;
    paramOptions2.inScreenDensity = paramOptions1.inScreenDensity;
    paramOptions2.inTargetDensity = paramOptions1.inTargetDensity;
    paramOptions2.inTempStorage = paramOptions1.inTempStorage;
    if (Build.VERSION.SDK_INT >= 10)
      paramOptions2.inPreferQualityOverSpeed = paramOptions1.inPreferQualityOverSpeed;
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramOptions2.inBitmap = paramOptions1.inBitmap;
      paramOptions2.inMutable = paramOptions1.inMutable;
    }
  }

  private static void b(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inPreferQualityOverSpeed = paramOptions1.inPreferQualityOverSpeed;
  }

  private static void c(BitmapFactory.Options paramOptions1, BitmapFactory.Options paramOptions2)
  {
    paramOptions2.inBitmap = paramOptions1.inBitmap;
    paramOptions2.inMutable = paramOptions1.inMutable;
  }

  public BitmapFactory.Options getDecodingOptions()
  {
    return this.j;
  }

  public ImageDownloader getDownloader()
  {
    return this.g;
  }

  public Object getExtraForDownloader()
  {
    return this.h;
  }

  public String getImageKey()
  {
    return this.a;
  }

  public ImageScaleType getImageScaleType()
  {
    return this.e;
  }

  public String getImageUri()
  {
    return this.b;
  }

  public String getOriginalImageUri()
  {
    return this.c;
  }

  public ImageSize getTargetSize()
  {
    return this.d;
  }

  public ViewScaleType getViewScaleType()
  {
    return this.f;
  }

  public boolean shouldConsiderExifParams()
  {
    return this.i;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.decode.ImageDecodingInfo
 * JD-Core Version:    0.6.2
 */