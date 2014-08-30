package com.xiaomi.miui.analyticstracker;

import android.content.Context;

public abstract interface Dispatchable
{
  public abstract void dispatchEvent(TrackEvent paramTrackEvent);

  public abstract void dispatchLog(LogEvent paramLogEvent);

  public abstract void dispatchPageView(TrackPageViewEvent paramTrackPageViewEvent);

  public abstract void start(Context paramContext, String paramString);

  public abstract void stop();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.Dispatchable
 * JD-Core Version:    0.6.2
 */