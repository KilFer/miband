package de.greenrobot.event;

public final class NoSubscriberEvent
{
  public final EventBus eventBus;
  public final Object originalEvent;

  public NoSubscriberEvent(EventBus paramEventBus, Object paramObject)
  {
    this.eventBus = paramEventBus;
    this.originalEvent = paramObject;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.NoSubscriberEvent
 * JD-Core Version:    0.6.2
 */