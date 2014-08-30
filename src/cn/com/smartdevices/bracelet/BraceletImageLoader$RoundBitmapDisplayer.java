package cn.com.smartdevices.bracelet;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import cn.com.smartdevices.bracelet.view.Util;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.display.BitmapDisplayer;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;

public class BraceletImageLoader$RoundBitmapDisplayer
  implements BitmapDisplayer
{
  public BraceletImageLoader$RoundBitmapDisplayer(BraceletImageLoader paramBraceletImageLoader)
  {
  }

  public void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    if (!(paramImageAware instanceof ImageViewAware))
      throw new IllegalArgumentException("ImageAware should wrap ImageView. ImageViewAware is expected.");
    Bitmap localBitmap = Util.clipToRoundBitmap(paramBitmap);
    ImageView localImageView = (ImageView)paramImageAware.getWrappedView();
    if ((localBitmap == null) || (localImageView == null))
      return;
    localImageView.setBackground(new BitmapDrawable(localImageView.getResources(), localBitmap));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.BraceletImageLoader.RoundBitmapDisplayer
 * JD-Core Version:    0.6.2
 */