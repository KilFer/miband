package com.tencent.mm.sdk.channel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;

public final class MMessage$Receiver extends BroadcastReceiver
{
  public static final Map<String, MMessage.CallBack> callbacks = new HashMap();
  private final MMessage.CallBack a;

  public MMessage$Receiver()
  {
    this(null);
  }

  public MMessage$Receiver(MMessage.CallBack paramCallBack)
  {
    this.a = paramCallBack;
  }

  public static void registerCallBack(String paramString, MMessage.CallBack paramCallBack)
  {
    callbacks.put(paramString, paramCallBack);
  }

  public static void unregisterCallBack(String paramString)
  {
    callbacks.remove(paramString);
  }

  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    Log.d("MicroMsg.SDK.MMessage", "receive intent=" + paramIntent);
    if (this.a != null)
    {
      this.a.handleMessage(paramIntent);
      Log.d("MicroMsg.SDK.MMessage", "mm message self-handled");
    }
    MMessage.CallBack localCallBack;
    do
    {
      return;
      localCallBack = (MMessage.CallBack)callbacks.get(paramIntent.getAction());
    }
    while (localCallBack == null);
    localCallBack.handleMessage(paramIntent);
    Log.d("MicroMsg.SDK.MMessage", "mm message handled");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.channel.MMessage.Receiver
 * JD-Core Version:    0.6.2
 */