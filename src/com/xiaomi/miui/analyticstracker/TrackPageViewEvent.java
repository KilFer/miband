package com.xiaomi.miui.analyticstracker;

import java.util.Iterator;
import java.util.List;

public class TrackPageViewEvent extends Event
{
  private static final String a = "_pageview_event_";

  public TrackPageViewEvent()
  {
    this.mType = Integer.valueOf(3);
    this.mEventId = "_pageview_event_";
  }

  public void dispatch()
  {
    if (sDispatcher != null)
    {
      Iterator localIterator = sDispatcher.iterator();
      while (localIterator.hasNext())
        ((Dispatchable)localIterator.next()).dispatchPageView(this);
    }
  }

  public void writeEvent(j paramj)
  {
    if (paramj != null)
      paramj.a(this.mType, this.mEventId, "", this.mTrackTime, Boolean.toString(false));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.TrackPageViewEvent
 * JD-Core Version:    0.6.2
 */