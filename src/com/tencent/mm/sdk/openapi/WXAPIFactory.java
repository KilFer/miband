package com.tencent.mm.sdk.openapi;

import android.content.Context;

public class WXAPIFactory
{
  private static WXAPIFactory a = null;

  public static IWXAPI createWXAPI(Context paramContext, String paramString)
  {
    if (a == null)
      a = new WXAPIFactory();
    return new a(paramContext, paramString);
  }

  public static IWXAPI createWXAPI(Context paramContext, String paramString, boolean paramBoolean)
  {
    if (a == null)
      a = new WXAPIFactory();
    return new a(paramContext, paramString, paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.openapi.WXAPIFactory
 * JD-Core Version:    0.6.2
 */