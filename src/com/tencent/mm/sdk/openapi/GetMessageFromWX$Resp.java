package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class GetMessageFromWX$Resp extends BaseResp
{
  public WXMediaMessage message;

  public GetMessageFromWX$Resp()
  {
  }

  public GetMessageFromWX$Resp(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }

  final boolean a()
  {
    if (this.message == null)
    {
      Log.e("MicroMsg.SDK.GetMessageFromWX.Resp", "checkArgs fail, message is null");
      return false;
    }
    return this.message.a();
  }

  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
  }

  public int getType()
  {
    return 3;
  }

  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.GetMessageFromWX.Resp
 * JD-Core Version:    0.6.2
 */