package com.tencent.mm.sdk.plugin;

import android.content.Context;

public class MMPluginUtil
{
  public static IMMPluginAPI queryPluginMgr(Context paramContext)
  {
    return new MMPluginAPIImpl(paramContext);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginUtil
 * JD-Core Version:    0.6.2
 */