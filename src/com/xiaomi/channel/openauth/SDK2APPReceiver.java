package com.xiaomi.channel.openauth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public class SDK2APPReceiver extends BroadcastReceiver
{
  public static String AUTH_ACTION_NAME = "com.xiaomi.openauth.action.SDK2APP";

  private static String a(String paramString)
  {
    String str = null;
    String[] arrayOfString1 = paramString.split(";");
    int i = arrayOfString1.length;
    for (int j = 0; ; j++)
    {
      if (j >= i)
        return str;
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if ((arrayOfString2.length == 2) && (arrayOfString2[0].trim().equals("userId")))
        str = arrayOfString2[1].trim();
    }
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    CookieSyncManager.createInstance(paramContext);
    String str1 = CookieManager.getInstance().getCookie("https://account.xiaomi.com");
    String str2;
    Object localObject;
    String[] arrayOfString1;
    int i;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("userId=")) && (str1.contains("passToken=")))
    {
      str2 = paramIntent.getStringExtra("user_id");
      if (!TextUtils.isEmpty(str2))
      {
        localObject = null;
        arrayOfString1 = str1.split(";");
        i = arrayOfString1.length;
      }
    }
    for (int j = 0; ; j++)
    {
      if (j >= i)
      {
        if (str2.equals(localObject))
        {
          Intent localIntent = new Intent(APP2SDKReceiver.AUTH_ACTION_NAME);
          localIntent.putExtra("pkg", paramContext.getPackageName());
          paramContext.sendBroadcast(localIntent);
        }
        return;
      }
      String[] arrayOfString2 = arrayOfString1[j].split("=");
      if ((arrayOfString2.length == 2) && (arrayOfString2[0].trim().equals("userId")))
        localObject = arrayOfString2[1].trim();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.SDK2APPReceiver
 * JD-Core Version:    0.6.2
 */