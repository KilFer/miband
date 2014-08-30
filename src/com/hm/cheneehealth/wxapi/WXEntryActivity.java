package com.hm.cheneehealth.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.sdk.openapi.BaseReq;
import com.tencent.mm.sdk.openapi.BaseResp;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.sdk.openapi.ShowMessageFromWX.Req;
import com.tencent.mm.sdk.openapi.WXAPIFactory;
import com.tencent.mm.sdk.openapi.WXAppExtendObject;
import com.tencent.mm.sdk.openapi.WXMediaMessage;

public class WXEntryActivity extends Activity
  implements IWXAPIEventHandler
{
  private static final int a = 553779201;
  private TextView b;
  private IWXAPI c;

  private void a(ShowMessageFromWX.Req paramReq)
  {
    Log.d("chenee", "goto show............... msg");
    WXMediaMessage localWXMediaMessage = paramReq.message;
    WXAppExtendObject localWXAppExtendObject = (WXAppExtendObject)localWXMediaMessage.mediaObject;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("---extInfo(uid): ");
    localStringBuffer.append(localWXAppExtendObject.extInfo);
    localStringBuffer.append("\n");
    localStringBuffer.append("---description: ");
    localStringBuffer.append(localWXMediaMessage.description);
    localStringBuffer.append("\n");
    localStringBuffer.append("---filePath: ");
    localStringBuffer.append(localWXAppExtendObject.filePath);
    this.b.setText(localWXMediaMessage.title + "\n" + localStringBuffer.toString());
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903067);
    this.c = WXAPIFactory.createWXAPI(this, "wx28e2610e92fbe111", false);
    ((Button)findViewById(2131165337)).setOnClickListener(new a(this));
    ((Button)findViewById(2131165338)).setOnClickListener(new b(this));
    this.b = ((TextView)findViewById(2131165336));
    this.c.handleIntent(getIntent(), this);
    Log.d("chenee", "on create......");
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    this.c.handleIntent(paramIntent, this);
  }

  public void onReq(BaseReq paramBaseReq)
  {
    switch (paramBaseReq.getType())
    {
    default:
      return;
    case 3:
      Log.d("chenee", "never come here ??????");
      return;
    case 4:
    }
    ShowMessageFromWX.Req localReq = (ShowMessageFromWX.Req)paramBaseReq;
    Log.d("chenee", "goto show............... msg");
    WXMediaMessage localWXMediaMessage = localReq.message;
    WXAppExtendObject localWXAppExtendObject = (WXAppExtendObject)localWXMediaMessage.mediaObject;
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("---extInfo(uid): ");
    localStringBuffer.append(localWXAppExtendObject.extInfo);
    localStringBuffer.append("\n");
    localStringBuffer.append("---description: ");
    localStringBuffer.append(localWXMediaMessage.description);
    localStringBuffer.append("\n");
    localStringBuffer.append("---filePath: ");
    localStringBuffer.append(localWXAppExtendObject.filePath);
    this.b.setText(localWXMediaMessage.title + "\n" + localStringBuffer.toString());
  }

  public void onResp(BaseResp paramBaseResp)
  {
    String str;
    switch (paramBaseResp.errCode)
    {
    case -3:
    case -1:
    default:
      str = "发送返回";
    case 0:
    case -2:
    case -4:
    }
    while (true)
    {
      Toast.makeText(this, str, 1).show();
      Log.d("chenee", "onResp..............." + str);
      finish();
      return;
      str = "发送成功!";
      continue;
      str = "发送取消";
      continue;
      str = "发送被拒绝";
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.hm.cheneehealth.wxapi.WXEntryActivity
 * JD-Core Version:    0.6.2
 */