package com.xiaomi.channel.sdk;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.os.Handler;

final class a extends e
{
  a(AccountManager paramAccountManager, Activity paramActivity, Handler paramHandler, AccountManagerCallback paramAccountManagerCallback, Account paramAccount, String paramString)
  {
    super(paramAccountManager, null, paramHandler, paramAccountManagerCallback);
  }

  public final void a()
  {
    new Thread(new b(this, this.b, this.c)).run();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.a
 * JD-Core Version:    0.6.2
 */