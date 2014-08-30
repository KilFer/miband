package com.tencent.mm.sdk.event;

public abstract class IListener
{
  private final int a;

  public IListener(int paramInt)
  {
    this.a = paramInt;
  }

  public abstract boolean callback(IEvent paramIEvent);

  public int getPriority()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.event.IListener
 * JD-Core Version:    0.6.2
 */