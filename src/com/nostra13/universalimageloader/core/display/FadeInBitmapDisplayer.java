package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;

public class FadeInBitmapDisplayer
  implements BitmapDisplayer
{
  private final int a;
  private final boolean b;
  private final boolean c;
  private final boolean d;

  public FadeInBitmapDisplayer(int paramInt)
  {
    this(paramInt, true, true, true);
  }

  public FadeInBitmapDisplayer(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramInt;
    this.b = paramBoolean1;
    this.c = paramBoolean2;
    this.d = paramBoolean3;
  }

  public static void animate(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
      localAlphaAnimation.setDuration(paramInt);
      localAlphaAnimation.setInterpolator(new DecelerateInterpolator());
      paramView.startAnimation(localAlphaAnimation);
    }
  }

  public void display(Bitmap paramBitmap, ImageAware paramImageAware, LoadedFrom paramLoadedFrom)
  {
    paramImageAware.setImageBitmap(paramBitmap);
    if (((this.b) && (paramLoadedFrom == LoadedFrom.NETWORK)) || ((this.c) && (paramLoadedFrom == LoadedFrom.DISC_CACHE)) || ((this.d) && (paramLoadedFrom == LoadedFrom.MEMORY_CACHE)))
      animate(paramImageAware.getWrappedView(), this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer
 * JD-Core Version:    0.6.2
 */