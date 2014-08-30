package com.tencent.mm.sdk.openapi;

import android.content.Intent;

public abstract interface IWXAPI
{
  public abstract int getWXAppSupportAPI();

  public abstract boolean handleIntent(Intent paramIntent, IWXAPIEventHandler paramIWXAPIEventHandler);

  public abstract boolean isWXAppInstalled();

  public abstract boolean isWXAppSupportAPI();

  public abstract boolean openWXApp();

  public abstract boolean registerApp(String paramString);

  public abstract boolean sendReq(BaseReq paramBaseReq);

  public abstract boolean sendResp(BaseResp paramBaseResp);

  public abstract void unregisterApp();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.IWXAPI
 * JD-Core Version:    0.6.2
 */