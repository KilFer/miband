package com.xiaomi.miui.analyticstracker.service;

import com.xiaomi.miui.analyticstracker.Event;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class LastPolicy extends Policy
{
  public static final String TAG = "last";
  private Map<String, Event> a = new HashMap();

  public void end()
  {
    Iterator localIterator = this.a.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((Event)this.a.get(str)).dispatch();
    }
    this.a.clear();
  }

  public void execute(Event paramEvent)
  {
    this.a.put(paramEvent.getEventId(), paramEvent);
  }

  public void prepare()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.LastPolicy
 * JD-Core Version:    0.6.2
 */