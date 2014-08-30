package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public final class SimpleBitmapDisplayer
  implements BitmapDisplayer
{
  public final void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    paramImageAware.setImageBitmap(paramBitmap);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.SimpleBitmapDisplayer
 * JD-Core Version:    0.6.2
 */