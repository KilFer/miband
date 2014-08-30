package com.xiaomi.miui.analyticstracker.service;

import com.xiaomi.miui.analyticstracker.Event;
import com.xiaomi.miui.analyticstracker.TrackEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountPolicy extends Policy
{
  public static final String TAG = "count";
  private static final String a = "CountPolicyEvent";
  private Map<String, Integer> b = new HashMap();

  public void end()
  {
    Iterator localIterator = this.b.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      HashMap localHashMap = new HashMap();
      localHashMap.put("CountPolicyEvent", "counts");
      new TrackEvent(str, localHashMap, ((Integer)this.b.get(str)).intValue()).dispatch();
    }
    this.b.clear();
  }

  public void execute(Event paramEvent)
  {
    Integer localInteger1 = (Integer)this.b.get(paramEvent.getEventId());
    if (localInteger1 == null);
    for (Integer localInteger2 = new Integer(1); ; localInteger2 = Integer.valueOf(1 + localInteger1.intValue()))
    {
      this.b.put(paramEvent.getEventId(), localInteger2);
      return;
    }
  }

  public void prepare()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.CountPolicy
 * JD-Core Version:    0.6.2
 */