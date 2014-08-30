package com.nostra13.universalimageloader.utils;

import android.opengl.GLES10;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public final class ImageSizeUtils
{
  private static final int a = 2048;
  private static ImageSize b = new ImageSize(i, i);

  static
  {
    int[] arrayOfInt = new int[1];
    GLES10.glGetIntegerv(3379, arrayOfInt, 0);
    int i = Math.max(arrayOfInt[0], 2048);
  }

  public static int computeImageSampleSize(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int i = paramImageSize1.getWidth();
    int j = paramImageSize1.getHeight();
    int k = paramImageSize2.getWidth();
    int m = paramImageSize2.getHeight();
    int n = i / k;
    int i1 = j / m;
    int i2;
    switch (a.a[paramViewScaleType.ordinal()])
    {
    default:
      i2 = 1;
    case 1:
    case 2:
    }
    while (i2 <= 0)
    {
      return 1;
      if (paramBoolean)
      {
        int i5 = j;
        int i6 = i;
        i2 = 1;
        while ((i6 / 2 >= k) || (i5 / 2 >= m))
        {
          i6 /= 2;
          i5 /= 2;
          i2 <<= 1;
        }
      }
      i2 = Math.max(n, i1);
      continue;
      if (paramBoolean)
      {
        int i3 = j;
        int i4 = i;
        i2 = 1;
        while ((i4 / 2 >= k) && (i3 / 2 >= m))
        {
          i4 /= 2;
          i3 /= 2;
          i2 <<= 1;
        }
      }
      else
      {
        i2 = Math.min(n, i1);
      }
    }
    return i2;
  }

  public static float computeImageScale(ImageSize paramImageSize1, ImageSize paramImageSize2, ViewScaleType paramViewScaleType, boolean paramBoolean)
  {
    int i = paramImageSize1.getWidth();
    int j = paramImageSize1.getHeight();
    int k = paramImageSize2.getWidth();
    int m = paramImageSize2.getHeight();
    float f1 = i / k;
    float f2 = j / m;
    int i1;
    if (((paramViewScaleType == ViewScaleType.FIT_INSIDE) && (f1 >= f2)) || ((paramViewScaleType == ViewScaleType.CROP) && (f1 < f2)))
      i1 = (int)(j / f1);
    int n;
    for (int i2 = k; ; i2 = n)
    {
      float f3 = 1.0F;
      if (((!paramBoolean) && (i2 < i) && (i1 < j)) || ((paramBoolean) && (i2 != i) && (i1 != j)))
        f3 = i2 / i;
      return f3;
      n = (int)(i / f2);
      i1 = m;
    }
  }

  public static int computeMinImageSampleSize(ImageSize paramImageSize)
  {
    int i = paramImageSize.getWidth();
    int j = paramImageSize.getHeight();
    int k = b.getWidth();
    int m = b.getHeight();
    return Math.max((int)Math.ceil(i / k), (int)Math.ceil(j / m));
  }

  public static ImageSize defineTargetSizeForView(ImageAware paramImageAware, ImageSize paramImageSize)
  {
    int i = paramImageAware.getWidth();
    if (i <= 0)
      i = paramImageSize.getWidth();
    int j = paramImageAware.getHeight();
    if (j <= 0)
      j = paramImageSize.getHeight();
    return new ImageSize(i, j);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.ImageSizeUtils
 * JD-Core Version:    0.6.2
 */