package com.tencent.mm.sdk.event;

public abstract interface IEvent
{
  public static final int EVENT_SCOPE_APPLICATION = 2;
  public static final int EVENT_SCOPE_SESSION = 1;
  public static final int EVENT_SCOPE_TEMPL;

  public abstract String getId();

  public abstract String getScope();

  public abstract boolean isOrder();

  public abstract void oncomplete();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.event.IEvent
 * JD-Core Version:    0.6.2
 */