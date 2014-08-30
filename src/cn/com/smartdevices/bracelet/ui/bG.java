package cn.com.smartdevices.bracelet.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

final class bG extends SimpleImageLoadingListener
{
  bG(ShowImageActivity paramShowImageActivity)
  {
  }

  public final void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap)
  {
    ShowImageActivity.a(this.a, paramBitmap);
    ShowImageActivity.a(this.a).setImageBitmap(paramBitmap);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.bG
 * JD-Core Version:    0.6.2
 */