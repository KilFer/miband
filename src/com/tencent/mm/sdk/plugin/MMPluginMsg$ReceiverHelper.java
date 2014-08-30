package com.tencent.mm.sdk.plugin;

import android.content.Intent;

public class MMPluginMsg$ReceiverHelper
{
  private int a;
  private Intent b;

  public MMPluginMsg$ReceiverHelper(Intent paramIntent)
  {
    this.a = paramIntent.getIntExtra("type", 0);
    this.b = paramIntent;
  }

  public String getMsgContent()
  {
    if (isRecvNew())
      return this.b.getStringExtra("recv_msg");
    return null;
  }

  public Integer getSendErrCode()
  {
    if (isSendRet())
      return Integer.valueOf(this.b.getIntExtra("send_err_code", 0));
    return null;
  }

  public Integer getSendErrType()
  {
    if (isSendRet())
      return Integer.valueOf(this.b.getIntExtra("send_err_type", 0));
    return null;
  }

  public Long getSendMsgId()
  {
    if (isSendRet())
      return Long.valueOf(this.b.getLongExtra("send_id", 0L));
    return null;
  }

  public boolean isRecvNew()
  {
    return this.a == 2;
  }

  public boolean isSendRet()
  {
    return this.a == 1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginMsg.ReceiverHelper
 * JD-Core Version:    0.6.2
 */