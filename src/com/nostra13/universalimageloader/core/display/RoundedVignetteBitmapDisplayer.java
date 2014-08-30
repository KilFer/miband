package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

public class RoundedVignetteBitmapDisplayer extends RoundedBitmapDisplayer
{
  public RoundedVignetteBitmapDisplayer(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }

  public void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    if (!(paramImageAware instanceof ImageViewAware))
      throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    paramImageAware.setImageDrawable(new RoundedVignetteBitmapDisplayer.RoundedVignetteDrawable(paramBitmap, this.cornerRadius, this.margin));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.RoundedVignetteBitmapDisplayer
 * JD-Core Version:    0.6.2
 */