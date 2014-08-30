package cn.com.smartdevices.bracelet.ui;

import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.MediaScannerConnectionClient;
import android.net.Uri;
import android.os.Handler;

final class A
  implements MediaScannerConnection.MediaScannerConnectionClient
{
  A(BindWeixinActivity paramBindWeixinActivity)
  {
  }

  public final void onMediaScannerConnected()
  {
    BindWeixinActivity.l(this.a).scanFile(BindWeixinActivity.m(this.a), null);
  }

  public final void onScanCompleted(String paramString, Uri paramUri)
  {
    BindWeixinActivity.h(this.a).sendEmptyMessage(4);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.ui.A
 * JD-Core Version:    0.6.2
 */