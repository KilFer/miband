package com.tencent.mm.sdk.event;

public final class EventPoolFactory
{
  public static EventPoolFactory.IEventPool impl = null;

  public static final EventPoolFactory.IEventPool getImpl()
  {
    return impl;
  }

  public static final void setImpl(EventPoolFactory.IEventPool paramIEventPool)
  {
    impl = paramIEventPool;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.event.EventPoolFactory
 * JD-Core Version:    0.6.2
 */