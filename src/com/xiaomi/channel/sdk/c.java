package com.xiaomi.channel.sdk;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.app.Activity;
import android.os.Handler;

final class c extends e
{
  c(AccountManager paramAccountManager, Activity paramActivity, Handler paramHandler, AccountManagerCallback paramAccountManagerCallback, Account paramAccount, String paramString)
  {
    super(paramAccountManager, null, paramHandler, paramAccountManagerCallback);
  }

  public final void a()
  {
    new Thread(new d(this, this.b, this.c)).run();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.c
 * JD-Core Version:    0.6.2
 */