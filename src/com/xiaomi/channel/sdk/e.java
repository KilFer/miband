package com.xiaomi.channel.sdk;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

abstract class e extends FutureTask<Bundle>
  implements AccountManagerFuture<Bundle>
{
  private Handler a;
  private AccountManagerCallback<Bundle> b;
  private Activity c;

  public e(Activity paramActivity, Handler paramHandler, AccountManagerCallback<Bundle> paramAccountManagerCallback)
  {
    super(new f(paramActivity));
  }

  private Bundle a(long paramLong, TimeUnit paramTimeUnit)
  {
    return a(Long.valueOf(paramLong), paramTimeUnit);
  }

  // ERROR //
  private Bundle a(Long paramLong, TimeUnit paramTimeUnit)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 50	com/xiaomi/channel/sdk/e:isDone	()Z
    //   4: ifne +10 -> 14
    //   7: aload_0
    //   8: getfield 20	com/xiaomi/channel/sdk/e:d	Lcom/xiaomi/channel/sdk/AccountManager;
    //   11: invokestatic 54	com/xiaomi/channel/sdk/AccountManager:a	(Lcom/xiaomi/channel/sdk/AccountManager;)V
    //   14: aload_1
    //   15: ifnonnull +21 -> 36
    //   18: aload_0
    //   19: invokevirtual 58	com/xiaomi/channel/sdk/e:get	()Ljava/lang/Object;
    //   22: checkcast 60	android/os/Bundle
    //   25: astore 14
    //   27: aload_0
    //   28: iconst_1
    //   29: invokevirtual 64	com/xiaomi/channel/sdk/e:cancel	(Z)Z
    //   32: pop
    //   33: aload 14
    //   35: areturn
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 68	java/lang/Long:longValue	()J
    //   41: aload_2
    //   42: invokevirtual 71	com/xiaomi/channel/sdk/e:get	(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;
    //   45: checkcast 60	android/os/Bundle
    //   48: astore 12
    //   50: aload_0
    //   51: iconst_1
    //   52: invokevirtual 64	com/xiaomi/channel/sdk/e:cancel	(Z)Z
    //   55: pop
    //   56: aload 12
    //   58: areturn
    //   59: astore 11
    //   61: new 73	android/accounts/OperationCanceledException
    //   64: dup
    //   65: invokespecial 76	android/accounts/OperationCanceledException:<init>	()V
    //   68: athrow
    //   69: astore 5
    //   71: aload_0
    //   72: iconst_1
    //   73: invokevirtual 64	com/xiaomi/channel/sdk/e:cancel	(Z)Z
    //   76: pop
    //   77: aload 5
    //   79: athrow
    //   80: astore 9
    //   82: aload_0
    //   83: iconst_1
    //   84: invokevirtual 64	com/xiaomi/channel/sdk/e:cancel	(Z)Z
    //   87: pop
    //   88: new 73	android/accounts/OperationCanceledException
    //   91: dup
    //   92: invokespecial 76	android/accounts/OperationCanceledException:<init>	()V
    //   95: athrow
    //   96: astore 7
    //   98: aload_0
    //   99: iconst_1
    //   100: invokevirtual 64	com/xiaomi/channel/sdk/e:cancel	(Z)Z
    //   103: pop
    //   104: goto -16 -> 88
    //   107: astore_3
    //   108: aload_3
    //   109: invokevirtual 80	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   112: astore 4
    //   114: aload 4
    //   116: instanceof 82
    //   119: ifeq +9 -> 128
    //   122: aload 4
    //   124: checkcast 82	java/io/IOException
    //   127: athrow
    //   128: aload 4
    //   130: instanceof 84
    //   133: ifeq +13 -> 146
    //   136: new 86	android/accounts/AuthenticatorException
    //   139: dup
    //   140: aload 4
    //   142: invokespecial 89	android/accounts/AuthenticatorException:<init>	(Ljava/lang/Throwable;)V
    //   145: athrow
    //   146: aload 4
    //   148: instanceof 86
    //   151: ifeq +9 -> 160
    //   154: aload 4
    //   156: checkcast 86	android/accounts/AuthenticatorException
    //   159: athrow
    //   160: aload 4
    //   162: instanceof 91
    //   165: ifeq +9 -> 174
    //   168: aload 4
    //   170: checkcast 91	java/lang/RuntimeException
    //   173: athrow
    //   174: aload 4
    //   176: instanceof 93
    //   179: ifeq +9 -> 188
    //   182: aload 4
    //   184: checkcast 93	java/lang/Error
    //   187: athrow
    //   188: new 95	java/lang/IllegalStateException
    //   191: dup
    //   192: aload 4
    //   194: invokespecial 96	java/lang/IllegalStateException:<init>	(Ljava/lang/Throwable;)V
    //   197: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   18	27	59	java/util/concurrent/CancellationException
    //   36	50	59	java/util/concurrent/CancellationException
    //   18	27	69	finally
    //   36	50	69	finally
    //   61	69	69	finally
    //   108	128	69	finally
    //   128	146	69	finally
    //   146	160	69	finally
    //   160	174	69	finally
    //   174	188	69	finally
    //   188	198	69	finally
    //   18	27	80	java/util/concurrent/TimeoutException
    //   36	50	80	java/util/concurrent/TimeoutException
    //   18	27	96	java/lang/InterruptedException
    //   36	50	96	java/lang/InterruptedException
    //   18	27	107	java/util/concurrent/ExecutionException
    //   36	50	107	java/util/concurrent/ExecutionException
  }

  private Bundle c()
  {
    return a(null, null);
  }

  public abstract void a();

  public final AccountManagerFuture<Bundle> b()
  {
    try
    {
      a();
      return this;
    }
    catch (RemoteException localRemoteException)
    {
      setException(localRemoteException);
    }
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.e
 * JD-Core Version:    0.6.2
 */