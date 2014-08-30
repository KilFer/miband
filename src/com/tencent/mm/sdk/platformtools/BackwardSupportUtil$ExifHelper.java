package com.tencent.mm.sdk.platformtools;

import android.media.ExifInterface;
import java.io.IOException;

public class BackwardSupportUtil$ExifHelper
{
  public static int getExifOrientation(String paramString)
  {
    try
    {
      localExifInterface = new ExifInterface(paramString);
      int i;
      if (localExifInterface != null)
      {
        i = localExifInterface.getAttributeInt("Orientation", -1);
        if (i == -1);
      }
      switch (i)
      {
      case 4:
      case 5:
      case 7:
      default:
        return 0;
      case 6:
      case 3:
      case 8:
      }
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        Log.e("MicroMsg.SDK.BackwardSupportUtil", "cannot read exif" + localIOException);
        ExifInterface localExifInterface = null;
      }
      return 90;
    }
    return 180;
    return 270;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper
 * JD-Core Version:    0.6.2
 */