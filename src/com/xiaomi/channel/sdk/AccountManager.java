package com.xiaomi.channel.sdk;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AccountManager
{
  public static final String KEY_ACCOUNT_NAME = "authAccount";
  public static final String KEY_AUTHTOKEN = "authtoken";
  private static final String a = "service_token_pref";
  private static AccountManager b;
  private Context c;

  public AccountManager(Context paramContext)
  {
    this.c = paramContext;
  }

  private String a(String paramString1, String paramString2)
  {
    String str = this.c.getSharedPreferences("service_token_pref", 0).getString(paramString2 + paramString1, null);
    if (TextUtils.isEmpty(str))
    {
      str = c(paramString1, paramString2);
      if (!TextUtils.isEmpty(str))
      {
        SharedPreferences.Editor localEditor = this.c.getSharedPreferences("service_token_pref", 0).edit();
        localEditor.putString(paramString2 + paramString1, str);
        localEditor.commit();
      }
    }
    return str;
  }

  private void a()
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != null) && (localLooper == this.c.getMainLooper()))
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("calling this from your main thread can lead to deadlock");
      Log.e("miliao_sdk_log", "calling this from your main thread can lead to deadlock and/or ANRs", localIllegalStateException);
      if (this.c.getApplicationInfo().targetSdkVersion >= 8)
        throw localIllegalStateException;
    }
  }

  private String b(String paramString1, String paramString2)
  {
    return this.c.getSharedPreferences("service_token_pref", 0).getString(paramString2 + paramString1, null);
  }

  private String c(String paramString1, String paramString2)
  {
    Uri localUri = Uri.parse("content://com.xiaomi.channel.providers.AccountProvider/getAuthToken");
    Log.v("miliao_sdk_log", "get auth token from miliao...");
    Cursor localCursor = this.c.getContentResolver().query(localUri, new String[] { "code", "token" }, null, new String[] { paramString1, paramString2 }, null);
    if (localCursor != null);
    try
    {
      int i;
      if (localCursor.moveToFirst())
        i = localCursor.getInt(0);
      switch (i)
      {
      default:
        localObject1 = null;
        if (localCursor != null)
        {
          boolean bool1 = localCursor.isClosed();
          localObject1 = null;
          if (!bool1)
            localCursor.close();
        }
        return localObject1;
      case 10001:
      }
      String str = localCursor.getString(1);
      localObject1 = str;
      return localObject1;
    }
    catch (Exception localException)
    {
      boolean bool2;
      do
      {
        do
        {
          Log.e("miliao_sdk_log", localException.toString());
          localObject1 = null;
        }
        while (localCursor == null);
        bool2 = localCursor.isClosed();
        Object localObject1 = null;
      }
      while (bool2);
      localCursor.close();
      return null;
    }
    finally
    {
      if ((localCursor != null) && (!localCursor.isClosed()))
        localCursor.close();
    }
  }

  public static AccountManager get(Context paramContext)
  {
    try
    {
      if (b == null)
        b = new AccountManager(paramContext);
      AccountManager localAccountManager = b;
      return localAccountManager;
    }
    finally
    {
    }
  }

  public AccountManagerFuture<Bundle> addAccount(String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle, Activity paramActivity, AccountManagerCallback<Bundle> paramAccountManagerCallback, Handler paramHandler)
  {
    return null;
  }

  public Account[] getAccountsByType(String paramString)
  {
    Uri localUri = Uri.parse("content://com.xiaomi.channel.providers.AccountProvider/getAccount");
    Cursor localCursor = this.c.getContentResolver().query(localUri, new String[] { "code", "name" }, null, null, null);
    if (localCursor != null);
    try
    {
      if (localCursor.moveToFirst())
      {
        int i = localCursor.getInt(0);
        switch (i)
        {
        default:
        case 10001:
        }
      }
      String str;
      do
      {
        if ((localCursor != null) && (!localCursor.isClosed()))
          localCursor.close();
        arrayOfAccount = new Account[0];
        return arrayOfAccount;
        str = localCursor.getString(1);
      }
      while (TextUtils.isEmpty(str));
      Account[] arrayOfAccount = new Account[1];
      arrayOfAccount[0] = new Account(str, paramString);
      return arrayOfAccount;
    }
    catch (Exception localException)
    {
      while (true)
      {
        Log.e("miliao_sdk_log", localException.toString());
        if ((localCursor != null) && (!localCursor.isClosed()))
          localCursor.close();
      }
    }
    finally
    {
      if ((localCursor != null) && (!localCursor.isClosed()))
        localCursor.close();
    }
  }

  public AccountManagerFuture<Bundle> getAuthToken(Account paramAccount, String paramString, Bundle paramBundle, Activity paramActivity, AccountManagerCallback<Bundle> paramAccountManagerCallback, Handler paramHandler)
  {
    return new a(this, null, paramHandler, paramAccountManagerCallback, paramAccount, paramString).b();
  }

  public AccountManagerFuture<Bundle> getAuthToken(Account paramAccount, String paramString, Bundle paramBundle, boolean paramBoolean, AccountManagerCallback<Bundle> paramAccountManagerCallback, Handler paramHandler)
  {
    return new c(this, null, paramHandler, paramAccountManagerCallback, paramAccount, paramString).b();
  }

  public void invalidateAuthToken(String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = this.c.getSharedPreferences("service_token_pref", 0);
    Map localMap = localSharedPreferences.getAll();
    Iterator localIterator;
    if (localMap != null)
      localIterator = localMap.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        android.accounts.AccountManager.get(this.c).invalidateAuthToken(paramString1, paramString2);
        return;
      }
      String str = (String)localIterator.next();
      Object localObject = localMap.get(str);
      if ((localObject != null) && ((localObject instanceof String)) && (((String)localObject).equals(paramString2)))
      {
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        localEditor.remove(str);
        localEditor.commit();
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.AccountManager
 * JD-Core Version:    0.6.2
 */