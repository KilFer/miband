package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;
import com.sina.weibo.sdk.api.WeiboMultiMessage;

public class ProvideMultiMessageForWeiboResponse extends BaseResponse
{
  public WeiboMultiMessage multiMessage;

  public ProvideMultiMessageForWeiboResponse()
  {
  }

  public ProvideMultiMessageForWeiboResponse(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }

  final boolean check(Context paramContext, VersionCheckHandler paramVersionCheckHandler)
  {
    if (this.multiMessage == null);
    do
    {
      return false;
      if (paramVersionCheckHandler == null)
        break;
      paramVersionCheckHandler.setPackageName(this.reqPackageName);
    }
    while (!paramVersionCheckHandler.check(paramContext, this.multiMessage));
    return this.multiMessage.checkArgs();
  }

  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.multiMessage = new WeiboMultiMessage(paramBundle);
  }

  public int getType()
  {
    return 2;
  }

  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putAll(this.multiMessage.toBundle(paramBundle));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.ProvideMultiMessageForWeiboResponse
 * JD-Core Version:    0.6.2
 */