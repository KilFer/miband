package com.xiaomi.account.openauth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class XiaomiOAuthorize
{
  private static final String a = "code";
  private static final String b = "token";
  private static XiaomiOAuthorize.OnOAuthInterface c;
  private static ThreadPoolExecutor d = new ThreadPoolExecutor(1, 5, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());

  private static void a(Activity paramActivity, long paramLong, String paramString1, String paramString2, Bundle paramBundle, int paramInt)
  {
    Account[] arrayOfAccount = AccountManager.get(paramActivity).getAccountsByType("com.xiaomi");
    if (arrayOfAccount.length > 0)
    {
      c localc = new c(paramActivity, paramLong, paramString1, paramString2, paramBundle, paramInt, arrayOfAccount);
      d.execute(localc);
      return;
    }
    AuthorizeHelper.startAuthorizeActivityForResult(paramActivity, paramLong, paramString1, paramString2, paramBundle.getString("scope"), paramBundle.getString("state"), paramInt);
  }

  public static void setOnOAuthInterface(XiaomiOAuthorize.OnOAuthInterface paramOnOAuthInterface)
  {
    c = paramOnOAuthInterface;
  }

  public static void startGetAccessToken(Activity paramActivity, long paramLong, String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null);
    for (Bundle localBundle = new Bundle(); ; localBundle = paramBundle)
    {
      a(paramActivity, paramLong, paramString, "token", localBundle, paramInt);
      return;
    }
  }

  public static void startGetOAuthCode(Activity paramActivity, long paramLong, String paramString, Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null);
    for (Bundle localBundle = new Bundle(); ; localBundle = paramBundle)
    {
      a(paramActivity, paramLong, paramString, "code", localBundle, paramInt);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.XiaomiOAuthorize
 * JD-Core Version:    0.6.2
 */