package com.sina.weibo.sdk.api.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class WeiboDownloader$2
  implements DialogInterface.OnClickListener
{
  WeiboDownloader$2(IWeiboDownloadListener paramIWeiboDownloadListener)
  {
  }

  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.val$listener != null)
      this.val$listener.onCancel();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.WeiboDownloader.2
 * JD-Core Version:    0.6.2
 */