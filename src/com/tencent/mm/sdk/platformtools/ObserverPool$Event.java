package com.tencent.mm.sdk.platformtools;

import android.os.Bundle;
import junit.framework.Assert;

public class ObserverPool$Event
{
  public static final int FLAG_ORDER_EXE = 1;
  private final String a;
  private int b;
  public final Bundle data = new Bundle();

  public ObserverPool$Event(String paramString)
  {
    Assert.assertNotNull(paramString);
    this.a = paramString;
  }

  public int getFlag()
  {
    return this.b;
  }

  public String getId()
  {
    return this.a;
  }

  public void onComplete()
  {
  }

  public Event setFlag(int paramInt)
  {
    this.b = paramInt;
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ObserverPool.Event
 * JD-Core Version:    0.6.2
 */