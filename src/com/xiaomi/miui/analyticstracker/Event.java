package com.xiaomi.miui.analyticstracker;

import android.database.Cursor;
import java.util.List;

public abstract class Event
  implements Cloneable
{
  protected static final char SPLITTER = '$';
  protected static List<Dispatchable> sDispatcher;
  protected String mEventId;
  protected String mPolicy;
  protected long mTrackTime;
  protected Integer mType;

  public Event()
  {
    setTime(System.currentTimeMillis());
  }

  public static void setDispatcher(List<Dispatchable> paramList)
  {
    sDispatcher = paramList;
  }

  public Object clone()
  {
    try
    {
      Event localEvent = (Event)super.clone();
      return localEvent;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }

  public abstract void dispatch();

  public String getEventId()
  {
    return this.mEventId;
  }

  public String getPolicy()
  {
    return this.mPolicy;
  }

  public long getTrackTime()
  {
    return this.mTrackTime;
  }

  public Integer getType()
  {
    return this.mType;
  }

  public void restore(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      this.mEventId = paramCursor.getString(paramCursor.getColumnIndexOrThrow("event_id"));
      this.mTrackTime = Long.parseLong(paramCursor.getString(paramCursor.getColumnIndexOrThrow("time")));
    }
  }

  public void setPolicy(String paramString)
  {
    this.mPolicy = paramString;
  }

  public void setTime(long paramLong)
  {
    this.mTrackTime = paramLong;
  }

  public abstract void writeEvent(j paramj);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.Event
 * JD-Core Version:    0.6.2
 */