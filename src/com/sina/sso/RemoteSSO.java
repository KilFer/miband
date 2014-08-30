package com.sina.sso;

import android.os.IInterface;

public abstract interface RemoteSSO extends IInterface
{
  public abstract String getActivityName();

  public abstract String getLoginUserName();

  public abstract String getPackageName();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.sso.RemoteSSO
 * JD-Core Version:    0.6.2
 */