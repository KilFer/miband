package com.edmodo.cropper.util;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.view.View;

public class ImageViewUtil
{
  private static Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    double d1 = (1.0D / 0.0D);
    double d2 = (1.0D / 0.0D);
    if (paramInt3 < paramInt1)
      d1 = paramInt3 / paramInt1;
    if (paramInt4 < paramInt2)
      d2 = paramInt4 / paramInt2;
    double d4;
    double d5;
    int i;
    int j;
    if ((d1 != (1.0D / 0.0D)) || (d2 != (1.0D / 0.0D)))
      if (d1 <= d2)
      {
        double d6 = paramInt3;
        double d7 = d6 * paramInt2 / paramInt1;
        d4 = d6;
        d5 = d7;
        if (d4 != paramInt3)
          break label174;
        i = 0;
        j = (int)Math.round((paramInt4 - d5) / 2.0D);
      }
    while (true)
    {
      return new Rect(i, j, i + (int)Math.ceil(d4), j + (int)Math.ceil(d5));
      double d3 = paramInt4;
      d4 = d3 * paramInt1 / paramInt2;
      d5 = d3;
      break;
      double d8 = paramInt2;
      d4 = paramInt1;
      d5 = d8;
      break;
      label174: if (d5 == paramInt4)
      {
        i = (int)Math.round((paramInt3 - d4) / 2.0D);
        j = 0;
      }
      else
      {
        i = (int)Math.round((paramInt3 - d4) / 2.0D);
        j = (int)Math.round((paramInt4 - d5) / 2.0D);
      }
    }
  }

  public static Rect getBitmapRectCenterInside(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static Rect getBitmapRectCenterInside(Bitmap paramBitmap, View paramView)
  {
    return a(paramBitmap.getWidth(), paramBitmap.getHeight(), paramView.getWidth(), paramView.getHeight());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.edmodo.cropper.util.ImageViewUtil
 * JD-Core Version:    0.6.2
 */