package de.greenrobot.event;

import java.util.ArrayList;
import java.util.List;

class EventBus$1 extends ThreadLocal<List<Object>>
{
  EventBus$1(EventBus paramEventBus)
  {
  }

  protected List<Object> initialValue()
  {
    return new ArrayList();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.event.EventBus.1
 * JD-Core Version:    0.6.2
 */