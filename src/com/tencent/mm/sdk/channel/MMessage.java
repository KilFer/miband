package com.tencent.mm.sdk.channel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.Log;

public class MMessage
{
  public static void send(Context paramContext, String paramString1, String paramString2)
  {
    send(paramContext, paramString1, "com.tencent.mm.sdk.channel.Intent.ACTION_MESSAGE", paramString2);
  }

  public static void send(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    send(paramContext, paramString1, paramString2, paramString3, null);
  }

  public static boolean send(Context paramContext, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    String str1 = paramString1 + ".permission.MM_MESSAGE";
    Intent localIntent = new Intent(paramString2);
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    String str2 = paramContext.getPackageName();
    localIntent.putExtra("_mmessage_sdkVersion", 553910273);
    localIntent.putExtra("_mmessage_appPackage", str2);
    localIntent.putExtra("_mmessage_content", paramString3);
    localIntent.putExtra("_mmessage_checksum", a.a(paramString3, str2));
    paramContext.sendBroadcast(localIntent, str1);
    Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + localIntent + ", perm=" + str1);
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.channel.MMessage
 * JD-Core Version:    0.6.2
 */