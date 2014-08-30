package com.tencent.mm.sdk.platformtools;

public abstract class ObserverPool$Listener
{
  private final int a;

  public ObserverPool$Listener()
  {
    this.a = 0;
  }

  public ObserverPool$Listener(int paramInt)
  {
    this.a = paramInt;
  }

  public abstract boolean callback(ObserverPool.Event paramEvent);

  public int getPriority()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ObserverPool.Listener
 * JD-Core Version:    0.6.2
 */