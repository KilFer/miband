package com.xiaomi.market.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DownloadCompleteReceiver extends BroadcastReceiver
{
  private static final String a = "MarketSDKDownloadReceiver";

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    long l;
    if ("android.intent.action.DOWNLOAD_COMPLETE".equals(paramIntent.getAction()))
    {
      l = paramIntent.getLongExtra("extra_download_id", -1L);
      Log.d("MarketSDKDownloadReceiver", "on sdk download complete : id = " + l);
      if (l != -1L);
    }
    else
    {
      return;
    }
    m.i(paramContext).a(l);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.DownloadCompleteReceiver
 * JD-Core Version:    0.6.2
 */