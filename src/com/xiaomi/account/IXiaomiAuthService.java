package com.xiaomi.account;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IInterface;

public abstract interface IXiaomiAuthService extends IInterface
{
  public abstract Bundle getMiCloudAccessToken(Account paramAccount, Bundle paramBundle);

  public abstract Bundle getMiCloudUserInfo(Account paramAccount, Bundle paramBundle);

  public abstract Bundle getSnsAccessToken(Account paramAccount, Bundle paramBundle);

  public abstract void invalidateAccessToken(Account paramAccount, Bundle paramBundle);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.IXiaomiAuthService
 * JD-Core Version:    0.6.2
 */