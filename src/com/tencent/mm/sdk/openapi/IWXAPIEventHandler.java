package com.tencent.mm.sdk.openapi;

public abstract interface IWXAPIEventHandler
{
  public abstract void onReq(BaseReq paramBaseReq);

  public abstract void onResp(BaseResp paramBaseResp);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.IWXAPIEventHandler
 * JD-Core Version:    0.6.2
 */