package com.xiaomi.channel.sdk;

import android.accounts.Account;
import android.os.Bundle;

final class d
  implements Runnable
{
  d(c paramc, Account paramAccount, String paramString)
  {
  }

  public final void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("authtoken", AccountManager.a(c.a(this.a), this.b.name, this.c));
    localBundle.putString("authAccount", this.b.name);
    c.a(this.a, localBundle);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.d
 * JD-Core Version:    0.6.2
 */