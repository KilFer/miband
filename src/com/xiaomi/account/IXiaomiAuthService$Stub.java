package com.xiaomi.account;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;

public abstract class IXiaomiAuthService$Stub extends Binder
  implements IXiaomiAuthService
{
  private static final String a = "com.xiaomi.account.IXiaomiAuthService";
  private static int b = 1;
  private static int c = 2;
  private static int d = 3;
  private static int e = 4;

  public IXiaomiAuthService$Stub()
  {
    attachInterface(this, "com.xiaomi.account.IXiaomiAuthService");
  }

  public static IXiaomiAuthService asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null)
      return null;
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.xiaomi.account.IXiaomiAuthService");
    if ((localIInterface != null) && ((localIInterface instanceof IXiaomiAuthService)))
      return (IXiaomiAuthService)localIInterface;
    return new a(paramIBinder);
  }

  public IBinder asBinder()
  {
    return this;
  }

  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
  {
    switch (paramInt1)
    {
    default:
      return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    case 1598968902:
      paramParcel2.writeString("com.xiaomi.account.IXiaomiAuthService");
      return true;
    case 1:
      paramParcel1.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
      Account localAccount4;
      Bundle localBundle6;
      if (paramParcel1.readInt() != 0)
      {
        localAccount4 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label157;
        localBundle6 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        Bundle localBundle7 = getMiCloudUserInfo(localAccount4, localBundle6);
        paramParcel2.writeNoException();
        if (localBundle7 == null)
          break label163;
        paramParcel2.writeInt(1);
        localBundle7.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        localAccount4 = null;
        break;
        localBundle6 = null;
        break label118;
        paramParcel2.writeInt(0);
      }
    case 2:
      paramParcel1.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
      Account localAccount3;
      Bundle localBundle4;
      if (paramParcel1.readInt() != 0)
      {
        localAccount3 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label258;
        localBundle4 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        Bundle localBundle5 = getMiCloudAccessToken(localAccount3, localBundle4);
        paramParcel2.writeNoException();
        if (localBundle5 == null)
          break label264;
        paramParcel2.writeInt(1);
        localBundle5.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        localAccount3 = null;
        break;
        localBundle4 = null;
        break label219;
        paramParcel2.writeInt(0);
      }
    case 3:
      label118: paramParcel1.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
      label157: label163: label219: Account localAccount2;
      label258: label264: Bundle localBundle2;
      if (paramParcel1.readInt() != 0)
      {
        localAccount2 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
        if (paramParcel1.readInt() == 0)
          break label359;
        localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);
        label320: Bundle localBundle3 = getSnsAccessToken(localAccount2, localBundle2);
        paramParcel2.writeNoException();
        if (localBundle3 == null)
          break label365;
        paramParcel2.writeInt(1);
        localBundle3.writeToParcel(paramParcel2, 1);
      }
      while (true)
      {
        return true;
        localAccount2 = null;
        break;
        label359: localBundle2 = null;
        break label320;
        label365: paramParcel2.writeInt(0);
      }
    case 4:
    }
    paramParcel1.enforceInterface("com.xiaomi.account.IXiaomiAuthService");
    Account localAccount1;
    if (paramParcel1.readInt() != 0)
    {
      localAccount1 = (Account)Account.CREATOR.createFromParcel(paramParcel1);
      if (paramParcel1.readInt() == 0)
        break label441;
    }
    label441: for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1); ; localBundle1 = null)
    {
      invalidateAccessToken(localAccount1, localBundle1);
      paramParcel2.writeNoException();
      return true;
      localAccount1 = null;
      break;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.IXiaomiAuthService.Stub
 * JD-Core Version:    0.6.2
 */