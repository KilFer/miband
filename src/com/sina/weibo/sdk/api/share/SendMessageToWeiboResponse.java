package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

public class SendMessageToWeiboResponse extends BaseResponse
{
  public SendMessageToWeiboResponse()
  {
  }

  public SendMessageToWeiboResponse(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }

  final boolean check(Context paramContext, VersionCheckHandler paramVersionCheckHandler)
  {
    return true;
  }

  public int getType()
  {
    return 1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.SendMessageToWeiboResponse
 * JD-Core Version:    0.6.2
 */