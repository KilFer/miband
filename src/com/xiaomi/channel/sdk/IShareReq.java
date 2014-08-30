package com.xiaomi.channel.sdk;

import android.os.Bundle;

public abstract interface IShareReq
{
  public abstract MLExtraInfo getJumpBackInfo();

  public abstract void parseFromBundle(Bundle paramBundle);

  public abstract Bundle toBundle();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.sdk.IShareReq
 * JD-Core Version:    0.6.2
 */