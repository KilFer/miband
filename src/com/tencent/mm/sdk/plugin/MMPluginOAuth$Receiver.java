package com.tencent.mm.sdk.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public class MMPluginOAuth$Receiver extends BroadcastReceiver
{
  private static final Map<String, MMPluginOAuth> a = new HashMap();
  private final MMPluginOAuth b;

  public MMPluginOAuth$Receiver()
  {
    this(null);
  }

  public MMPluginOAuth$Receiver(MMPluginOAuth paramMMPluginOAuth)
  {
    this.b = paramMMPluginOAuth;
  }

  public static void register(String paramString, MMPluginOAuth paramMMPluginOAuth)
  {
    a.put(paramString, paramMMPluginOAuth);
  }

  public static void unregister(String paramString)
  {
    a.remove(paramString);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("MicroMsg.SDK.MMPluginOAuth", "receive oauth result");
    String str1 = paramIntent.getStringExtra("com.tencent.mm.sdk.plugin.Intent.REQUEST_TOKEN");
    String str2 = paramIntent.getStringExtra("com.tencent.mm.sdk.plugin.Intent.ACCESS_TOKEN");
    MMPluginOAuth localMMPluginOAuth;
    if (this.b != null)
      localMMPluginOAuth = this.b;
    while (true)
    {
      new Handler().post(new b(this, localMMPluginOAuth, str2));
      return;
      localMMPluginOAuth = (MMPluginOAuth)a.get(str1);
      if (localMMPluginOAuth == null)
      {
        Log.e("MicroMsg.SDK.MMPluginOAuth", "oauth unregistered, request token = " + str1);
        return;
      }
      unregister(MMPluginOAuth.a(localMMPluginOAuth));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.plugin.MMPluginOAuth.Receiver
 * JD-Core Version:    0.6.2
 */