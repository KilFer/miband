package com.xiaomi.miui.analyticstracker.service;

import android.content.Context;
import com.xiaomi.miui.analyticstracker.Dispatchable;
import com.xiaomi.miui.analyticstracker.Event;
import com.xiaomi.miui.analyticstracker.LogEvent;
import com.xiaomi.miui.analyticstracker.TrackEvent;
import com.xiaomi.miui.analyticstracker.TrackPageViewEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class XiaomiDispatcher
  implements Dispatchable
{
  public static final String TAG = "xiaomi";
  private static final String c = "_event_id_";
  private static final String d = "_event_type_";
  private static final String e = "_event_value_";
  private static final String f = "_event_track_time_";
  private static final String g = "_app_package_";
  private static final String h = "_log_event_class_";
  private static final String i = "_log_event_message_";
  private XiaomiServer a = XiaomiServer.getInstance();
  private String b;

  private Map<String, Object> a(Event paramEvent)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("_event_id_", paramEvent.getEventId());
    localHashMap.put("_event_type_", paramEvent.getType());
    localHashMap.put("_event_track_time_", Long.valueOf(paramEvent.getTrackTime()));
    localHashMap.put("_app_package_", this.b);
    return localHashMap;
  }

  public void dispatchEvent(TrackEvent paramTrackEvent)
  {
    if (this.a != null)
    {
      Map localMap1 = a(paramTrackEvent);
      Map localMap2 = paramTrackEvent.getParam();
      if (localMap2 != null)
      {
        Iterator localIterator = localMap2.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localMap1.put(str, localMap2.get(str));
        }
      }
      localMap1.put("_event_value_", Long.valueOf(paramTrackEvent.getValue()));
      this.a.send(localMap1);
    }
  }

  public void dispatchLog(LogEvent paramLogEvent)
  {
    if (this.a != null)
    {
      Map localMap = a(paramLogEvent);
      localMap.put("_log_event_class_", paramLogEvent.getErrorClass());
      localMap.put("_log_event_message_", paramLogEvent.getMessage());
      this.a.send(localMap);
    }
  }

  public void dispatchPageView(TrackPageViewEvent paramTrackPageViewEvent)
  {
    if (this.a != null)
    {
      Map localMap = a(paramTrackPageViewEvent);
      this.a.send(localMap);
    }
  }

  public void start(Context paramContext, String paramString)
  {
    this.a.init();
    this.b = paramString;
  }

  public void stop()
  {
    this.a.close();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.XiaomiDispatcher
 * JD-Core Version:    0.6.2
 */