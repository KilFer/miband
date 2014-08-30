package com.xiaomi.channel.openauth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class APP2SDKReceiver extends BroadcastReceiver
{
  public static String AUTH_ACTION_NAME = "com.xiaomi.openauth.action.APP2SDK";
  public static List<String> availableApp = new ArrayList();

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(paramIntent.getStringExtra("pkg")))
      availableApp.add(paramIntent.getStringExtra("pkg"));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.APP2SDKReceiver
 * JD-Core Version:    0.6.2
 */