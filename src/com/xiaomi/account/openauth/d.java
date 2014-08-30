package com.xiaomi.account.openauth;

import android.os.Bundle;

final class d
  implements Runnable
{
  d(c paramc, Bundle paramBundle)
  {
  }

  public final void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("access_token", this.b.getString("extra_access_token"));
    localBundle.putString("token_type", this.b.getString("extra_token_type"));
    localBundle.putString("expires_in", String.valueOf(this.b.getInt("extra_expires_in")));
    localBundle.putString("mac_key", this.b.getString("extra_mac_key"));
    localBundle.putString("mac_algorithm", this.b.getString("extra_mac_algorithm"));
    XiaomiOAuthorize.a().onGetAccessTokenDirectly(localBundle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.d
 * JD-Core Version:    0.6.2
 */