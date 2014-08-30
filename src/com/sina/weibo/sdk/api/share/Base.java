package com.sina.weibo.sdk.api.share;

import android.content.Context;
import android.os.Bundle;

public abstract class Base
{
  public String transaction;

  abstract boolean check(Context paramContext, VersionCheckHandler paramVersionCheckHandler);

  public abstract void fromBundle(Bundle paramBundle);

  public abstract int getType();

  public abstract void toBundle(Bundle paramBundle);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.sina.weibo.sdk.api.share.Base
 * JD-Core Version:    0.6.2
 */