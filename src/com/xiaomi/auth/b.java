package com.xiaomi.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

final class b
  implements ServiceConnection
{
  b(Account paramAccount, Bundle paramBundle, f paramf)
  {
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      Bundle localBundle2 = com.xiaomi.account.IXiaomiAuthService.Stub.asInterface(paramIBinder).getMiCloudUserInfo(this.a, this.b);
      localObject = localBundle2;
      this.c.a(localObject);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
      {
        miui.net.IXiaomiAuthService localIXiaomiAuthService = miui.net.IXiaomiAuthService.Stub.asInterface(paramIBinder);
        try
        {
          Bundle localBundle1 = localIXiaomiAuthService.getMiCloudUserInfo(this.a, this.b);
          localObject = localBundle1;
        }
        catch (Exception localException2)
        {
          Log.e("XiaomiAuthUtil", "miui.net.IXiaomiAuthService get MiCloud user info ", localException2);
          localObject = null;
        }
      }
    }
    catch (Exception localException1)
    {
      while (true)
      {
        Log.e("XiaomiAuthUtil", "com.xiaomi.account.IXiaomiAuthService get MiCloud user info ", localException1);
        Object localObject = null;
      }
    }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.auth.b
 * JD-Core Version:    0.6.2
 */