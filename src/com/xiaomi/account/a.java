package com.xiaomi.account;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;

final class a
  implements IXiaomiAuthService
{
  private IBinder a;

  a(IBinder paramIBinder)
  {
    this.a = paramIBinder;
  }

  private static String a()
  {
    return "com.xiaomi.account.IXiaomiAuthService";
  }

  public final IBinder asBinder()
  {
    return this.a;
  }

  public final Bundle getMiCloudAccessToken(Account paramAccount, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(2, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() == 0)
              break label130;
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
      continue;
      label130: Bundle localBundle = null;
    }
  }

  public final Bundle getMiCloudUserInfo(Account paramAccount, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(1, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() == 0)
              break label130;
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
      continue;
      label130: Bundle localBundle = null;
    }
  }

  public final Bundle getSnsAccessToken(Account paramAccount, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(3, localParcel1, localParcel2, 0);
            localParcel2.readException();
            if (localParcel2.readInt() == 0)
              break label130;
            localBundle = (Bundle)Bundle.CREATOR.createFromParcel(localParcel2);
            return localBundle;
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
      continue;
      label130: Bundle localBundle = null;
    }
  }

  public final void invalidateAccessToken(Account paramAccount, Bundle paramBundle)
  {
    Parcel localParcel1 = Parcel.obtain();
    Parcel localParcel2 = Parcel.obtain();
    while (true)
    {
      try
      {
        localParcel1.writeInterfaceToken("com.xiaomi.account.IXiaomiAuthService");
        if (paramAccount != null)
        {
          localParcel1.writeInt(1);
          paramAccount.writeToParcel(localParcel1, 0);
          if (paramBundle != null)
          {
            localParcel1.writeInt(1);
            paramBundle.writeToParcel(localParcel1, 0);
            this.a.transact(4, localParcel1, localParcel2, 0);
            localParcel2.readException();
          }
        }
        else
        {
          localParcel1.writeInt(0);
          continue;
        }
      }
      finally
      {
        localParcel2.recycle();
        localParcel1.recycle();
      }
      localParcel1.writeInt(0);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.a
 * JD-Core Version:    0.6.2
 */