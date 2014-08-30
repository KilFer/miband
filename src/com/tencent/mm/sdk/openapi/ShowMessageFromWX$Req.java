package com.tencent.mm.sdk.openapi;

import android.os.Bundle;

public class ShowMessageFromWX$Req extends BaseReq
{
  public WXMediaMessage message;

  public ShowMessageFromWX$Req()
  {
  }

  public ShowMessageFromWX$Req(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }

  final boolean a()
  {
    if (this.message == null)
      return false;
    return this.message.a();
  }

  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
  }

  public int getType()
  {
    return 4;
  }

  public void toBundle(Bundle paramBundle)
  {
    Bundle localBundle = WXMediaMessage.Builder.toBundle(this.message);
    super.toBundle(localBundle);
    paramBundle.putAll(localBundle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.ShowMessageFromWX.Req
 * JD-Core Version:    0.6.2
 */