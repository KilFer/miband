package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

public class ProvideMessageForWeiboRequest extends BaseRequest
{
  public ProvideMessageForWeiboRequest()
  {
  }

  public ProvideMessageForWeiboRequest(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }

  final boolean check(Context paramContext, VersionCheckHandler paramVersionCheckHandler)
  {
    return true;
  }

  public int getType()
  {
    return 2;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.ProvideMessageForWeiboRequest
 * JD-Core Version:    0.6.2
 */