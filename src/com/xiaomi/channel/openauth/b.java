package com.xiaomi.channel.openauth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

final class b
  implements Runnable
{
  b(Activity paramActivity, APP2SDKReceiver paramAPP2SDKReceiver, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
  }

  public final void run()
  {
    this.a.unregisterReceiver(this.b);
    Intent localIntent = AuthorizeHelper.a(this.a);
    AuthorizeHelper.a();
    Bundle localBundle = new Bundle();
    localBundle.putString("client_id", String.valueOf(this.c));
    localBundle.putString("redirect_uri", this.d);
    localBundle.putString("response_type", this.e);
    localBundle.putString("scope", this.f);
    localBundle.putString("state", this.g);
    localIntent.putExtra("url_param", localBundle);
    this.a.startActivityForResult(localIntent, this.h);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.b
 * JD-Core Version:    0.6.2
 */