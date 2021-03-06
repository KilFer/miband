package com.tencent.mm.sdk.openapi;

import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class SendMessageToWX$Req extends BaseReq
{
  public static final int WXSceneSession = 0;
  public static final int WXSceneTimeline = 1;
  public WXMediaMessage message;
  public int scene;

  public SendMessageToWX$Req()
  {
  }

  public SendMessageToWX$Req(Bundle paramBundle)
  {
    fromBundle(paramBundle);
  }

  final boolean a()
  {
    if (this.message == null)
    {
      Log.e("MicroMsg.SDK.SendMessageToWX.Req", "checkArgs fail ,message is null");
      return false;
    }
    return this.message.a();
  }

  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.message = WXMediaMessage.Builder.fromBundle(paramBundle);
    this.scene = paramBundle.getInt("_wxapi_sendmessagetowx_req_scene");
  }

  public int getType()
  {
    return 2;
  }

  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putAll(WXMediaMessage.Builder.toBundle(this.message));
    paramBundle.putInt("_wxapi_sendmessagetowx_req_scene", this.scene);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.SendMessageToWX.Req
 * JD-Core Version:    0.6.2
 */