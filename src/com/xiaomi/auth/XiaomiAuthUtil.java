package com.xiaomi.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;

public class XiaomiAuthUtil
{
  private static final String a = "XiaomiAuthUtil";

  private static void a(Context paramContext)
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != null) && (localLooper == paramContext.getMainLooper()))
      throw new IllegalStateException("calling this from your main thread can lead to deadlock");
  }

  public static Bundle getAccessToken(Context paramContext, Account paramAccount, Bundle paramBundle)
  {
    a(paramContext);
    f localf = new f();
    c localc = new c(paramAccount, paramBundle, localf);
    if (paramContext.bindService(new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE"), localc, 1))
      try
      {
        Bundle localBundle2 = (Bundle)localf.get();
        return localBundle2;
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      finally
      {
        paramContext.unbindService(localc);
      }
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("extra_error_code", -1000);
    localBundle1.putString("extra_error_description", "cannot connect to auth service");
    paramContext.unbindService(localc);
    return localBundle1;
  }

  public static Bundle getSNSInfo(Context paramContext, Account paramAccount, Bundle paramBundle)
  {
    a(paramContext);
    f localf = new f();
    d locald = new d(paramAccount, paramBundle, localf);
    if (paramContext.bindService(new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE"), locald, 1))
      try
      {
        Bundle localBundle2 = (Bundle)localf.get();
        return localBundle2;
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      finally
      {
        paramContext.unbindService(locald);
      }
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("extra_error_code", -1000);
    localBundle1.putString("extra_error_description", "cannot connect to auth service");
    paramContext.unbindService(locald);
    return localBundle1;
  }

  public static Bundle getXiaomiUserInfo(Context paramContext, Account paramAccount, Bundle paramBundle)
  {
    a(paramContext);
    f localf = new f();
    b localb = new b(paramAccount, paramBundle, localf);
    if (paramContext.bindService(new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE"), localb, 1))
      try
      {
        Bundle localBundle2 = (Bundle)localf.get();
        return localBundle2;
      }
      catch (InterruptedException localInterruptedException)
      {
        Thread.currentThread().interrupt();
        return null;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      finally
      {
        paramContext.unbindService(localb);
      }
    Bundle localBundle1 = new Bundle();
    localBundle1.putInt("extra_error_code", -1000);
    localBundle1.putString("extra_error_description", "cannot connect to auth service");
    paramContext.unbindService(localb);
    return localBundle1;
  }

  public static boolean invalidateAccessToken(Context paramContext, Account paramAccount, Bundle paramBundle)
  {
    e locale = new e(paramContext, paramAccount, paramBundle);
    return paramContext.bindService(new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE"), locale, 1);
  }

  public static boolean isServiceSupport(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.XIAOMI_ACCOUNT_AUTHORIZE");
    a locala = new a();
    try
    {
      boolean bool = paramContext.bindService(localIntent, locala, 1);
      return bool;
    }
    finally
    {
      paramContext.unbindService(locala);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.auth.XiaomiAuthUtil
 * JD-Core Version:    0.6.2
 */