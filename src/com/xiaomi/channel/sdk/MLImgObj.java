package com.xiaomi.channel.sdk;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class MLImgObj
{
  private static int b = 2097152;
  private final Bitmap a;
  private int c;
  private int d;
  public String filePath;
  public long mImgSize = 2097152L;

  public MLImgObj(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }

  public Bitmap getCompressBmp()
  {
    if (this.a == null)
      return null;
    int i = this.a.getWidth();
    int j = this.a.getHeight();
    long l = i * j;
    if (l <= this.mImgSize)
      return this.a;
    double d1 = Math.sqrt(l / this.mImgSize);
    return ShareUtils.compressBitmapWithNoDistortion(this.a, (int)(i / d1), (int)(j / d1), Bitmap.Config.ARGB_8888);
  }

  public Bitmap getImgBmp()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.MLImgObj
 * JD-Core Version:    0.6.2
 */