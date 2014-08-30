package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

final class e extends SimpleImageLoadingListener
{
  private Bitmap a;

  public final Bitmap a()
  {
    return this.a;
  }

  public final void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap)
  {
    this.a = paramBitmap;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.e
 * JD-Core Version:    0.6.2
 */