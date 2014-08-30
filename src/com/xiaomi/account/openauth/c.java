package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.xiaomi.auth.XiaomiAuthUtil;

final class c
  implements Runnable
{
  c(Activity paramActivity, long paramLong, String paramString1, String paramString2, Bundle paramBundle, int paramInt, Account[] paramArrayOfAccount)
  {
  }

  public final void run()
  {
    if (!XiaomiAuthUtil.isServiceSupport(this.a))
    {
      AuthorizeHelper.startAuthorizeActivityForResult(this.a, this.b, this.c, this.d, this.e.getString("scope"), this.e.getString("state"), this.f);
      return;
    }
    Bundle localBundle1 = new Bundle();
    localBundle1.putString("extra_client_id", String.valueOf(this.b));
    localBundle1.putString("extra_redirect_uri", this.c);
    localBundle1.putString("extra_response_type", this.d);
    if (this.e != null)
      localBundle1.putAll(this.e);
    Bundle localBundle2 = XiaomiAuthUtil.getAccessToken(this.a, this.g[0], localBundle1);
    if ((localBundle2.getInt("extra_error_code") == 0) && (XiaomiOAuthorize.a() != null))
    {
      this.a.runOnUiThread(new d(this, localBundle2));
      return;
    }
    if (localBundle2.getInt("extra_error_code") == -1001)
    {
      Intent localIntent = (Intent)localBundle2.getParcelable("extra_intent");
      this.a.startActivityForResult(localIntent, this.f);
      return;
    }
    AuthorizeHelper.startAuthorizeActivityForResult(this.a, this.b, this.c, this.d, this.e.getString("scope"), this.e.getString("state"), this.f);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.c
 * JD-Core Version:    0.6.2
 */