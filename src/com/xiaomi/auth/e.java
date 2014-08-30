package com.xiaomi.auth;

import android.accounts.Account;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;

final class e
  implements ServiceConnection
{
  e(Context paramContext, Account paramAccount, Bundle paramBundle)
  {
  }

  // ERROR //
  public final void onServiceConnected(ComponentName paramComponentName, android.os.IBinder paramIBinder)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 35	com/xiaomi/account/IXiaomiAuthService$Stub:asInterface	(Landroid/os/IBinder;)Lcom/xiaomi/account/IXiaomiAuthService;
    //   4: aload_0
    //   5: getfield 18	com/xiaomi/auth/e:b	Landroid/accounts/Account;
    //   8: aload_0
    //   9: getfield 20	com/xiaomi/auth/e:c	Landroid/os/Bundle;
    //   12: invokeinterface 41 3 0
    //   17: aload_0
    //   18: getfield 16	com/xiaomi/auth/e:a	Landroid/content/Context;
    //   21: aload_0
    //   22: invokevirtual 47	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   25: return
    //   26: astore 6
    //   28: aload_2
    //   29: invokestatic 52	miui/net/IXiaomiAuthService$Stub:asInterface	(Landroid/os/IBinder;)Lmiui/net/IXiaomiAuthService;
    //   32: astore 7
    //   34: aload 7
    //   36: aload_0
    //   37: getfield 18	com/xiaomi/auth/e:b	Landroid/accounts/Account;
    //   40: aload_0
    //   41: getfield 20	com/xiaomi/auth/e:c	Landroid/os/Bundle;
    //   44: invokeinterface 55 3 0
    //   49: aload_0
    //   50: getfield 16	com/xiaomi/auth/e:a	Landroid/content/Context;
    //   53: aload_0
    //   54: invokevirtual 47	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   57: return
    //   58: astore 8
    //   60: ldc 57
    //   62: ldc 59
    //   64: aload 8
    //   66: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   69: pop
    //   70: goto -21 -> 49
    //   73: astore 5
    //   75: aload_0
    //   76: getfield 16	com/xiaomi/auth/e:a	Landroid/content/Context;
    //   79: aload_0
    //   80: invokevirtual 47	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   83: aload 5
    //   85: athrow
    //   86: astore_3
    //   87: ldc 57
    //   89: ldc 67
    //   91: aload_3
    //   92: invokestatic 65	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   95: pop
    //   96: aload_0
    //   97: getfield 16	com/xiaomi/auth/e:a	Landroid/content/Context;
    //   100: aload_0
    //   101: invokevirtual 47	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   104: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	17	26	java/lang/SecurityException
    //   34	49	58	java/lang/Exception
    //   0	17	73	finally
    //   28	34	73	finally
    //   34	49	73	finally
    //   60	70	73	finally
    //   87	96	73	finally
    //   0	17	86	java/lang/Exception
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.auth.e
 * JD-Core Version:    0.6.2
 */