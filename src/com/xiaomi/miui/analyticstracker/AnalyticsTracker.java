package com.xiaomi.miui.analyticstracker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.miui.analyticstracker.utils.SysUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AnalyticsTracker
{
  private static final String a = "XIAOMIANALYTICS";
  private static final AnalyticsTracker b = new AnalyticsTracker();
  private static final String c = "_timed_event_";
  private static final String d = "_timed_event_id_";
  private static final String e = "_event_default_param_";
  private static final String f = "_active_";
  private static final String g = "imei";
  private static final String h = "rom_version";
  private static final String i = "model";
  private static final String j = "app_version";
  private static final String k = "_client_id_";
  private static final long l;
  private d m = null;
  private boolean n = false;
  private Context o = null;
  private List<TrackEvent> p = null;
  private int q = 0;
  private String r = null;

  private boolean a()
  {
    if ((this.m == null) || (this.o == null))
    {
      Log.i("XIAOMIANALYTICS", "method: startSession should be called before tracking events");
      return false;
    }
    return true;
  }

  public static AnalyticsTracker getInstance()
  {
    return b;
  }

  public void endSession()
  {
    try
    {
      if (this.q > 0)
      {
        int i1 = -1 + this.q;
        this.q = i1;
        if (i1 == 0)
        {
          boolean bool = a();
          if (bool)
            break label37;
        }
      }
      while (true)
      {
        return;
        label37: Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.o.getPackageName();
        Log.i("XIAOMIANALYTICS", String.format("end session(%s)", arrayOfObject));
        this.o = null;
        this.m.a();
        this.m = null;
        this.p.clear();
        this.p = null;
      }
    }
    finally
    {
    }
  }

  public void endTimedEvent(String paramString)
  {
    if (this.p == null)
      Log.i("XIAOMIANALYTICS", "there is no timed event");
    while (true)
    {
      return;
      Iterator localIterator = this.p.iterator();
      while (localIterator.hasNext())
      {
        TrackEvent localTrackEvent = (TrackEvent)localIterator.next();
        if (paramString.equals(localTrackEvent.getEventId()))
        {
          long l1 = System.currentTimeMillis();
          HashMap localHashMap = new HashMap();
          localHashMap.put("_timed_event_id_", paramString);
          trackEvent("_timed_event_", localHashMap, l1 - localTrackEvent.getTrackTime());
          localIterator.remove();
        }
      }
      for (int i1 = 1; i1 == 0; i1 = 0)
      {
        Log.i("XIAOMIANALYTICS", String.format("the ended event (%s) is not timed", new Object[] { paramString }));
        return;
      }
    }
  }

  public void onTrackPageView()
  {
    if (!a())
      return;
    this.m.a(new TrackPageViewEvent());
  }

  public void setUseHttps(boolean paramBoolean)
  {
    if (paramBoolean != this.n)
      this.n = paramBoolean;
  }

  public void setUserKey(String paramString)
  {
    this.r = paramString;
  }

  public void startSession(Context paramContext)
  {
    if (paramContext != null);
    try
    {
      int i1 = this.q;
      this.q = (i1 + 1);
      if (i1 == 0)
      {
        this.o = paramContext.getApplicationContext();
        this.m = new d();
        this.m.a(this.o);
        this.p = Collections.synchronizedList(new ArrayList());
        this.r = SysUtils.getIMEI(this.o);
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.o.getPackageName();
        Log.i("XIAOMIANALYTICS", String.format("start session(%s)", arrayOfObject));
      }
      return;
    }
    finally
    {
    }
  }

  public void trackActive()
  {
    trackActive(SysUtils.getIMEI(this.o));
  }

  public void trackActive(String paramString)
  {
    trackTimedEvent("_active_", new b(this, paramString), false, 0L);
  }

  public void trackError(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString3)))
      Log.i("XIAOMIANALYTICS", "the id or error class of loged event is null or empty");
    while (!a())
      return;
    if (paramString2 == null)
      paramString2 = "";
    this.m.a(new LogEvent(paramString1, paramString2, paramString3));
  }

  public void trackEvent(String paramString)
  {
    trackTimedEvent(paramString, null, false, 0L);
  }

  public void trackEvent(String paramString, long paramLong)
  {
    trackTimedEvent(paramString, null, false, paramLong);
  }

  public void trackEvent(String paramString, Object paramObject)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("_event_default_param_", paramObject.toString());
    trackEvent(paramString, localHashMap);
  }

  public void trackEvent(String paramString, Map<String, String> paramMap)
  {
    trackTimedEvent(paramString, paramMap, false, 0L);
  }

  public void trackEvent(String paramString, Map<String, String> paramMap, long paramLong)
  {
    trackTimedEvent(paramString, paramMap, false, paramLong);
  }

  public void trackTimedEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    trackTimedEvent(paramString, paramMap, paramBoolean, 0L);
  }

  public void trackTimedEvent(String paramString, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    if (TextUtils.isEmpty(paramString))
      Log.i("XIAOMIANALYTICS", "the id of tracked event is null or empty");
    while (true)
    {
      return;
      if (!a())
        continue;
      try
      {
        str1 = SysUtils.getIMEI(this.o);
        if (TextUtils.isEmpty(str1))
        {
          str2 = "null";
          if (paramMap == null)
            localObject = new HashMap();
        }
      }
      catch (Exception localException1)
      {
        while (true)
        {
          String str1;
          try
          {
            ((Map)localObject).put("imei", str2);
            ((Map)localObject).put("rom_version", SysUtils.getRomVersion(this.o));
            ((Map)localObject).put("model", SysUtils.getModel(this.o));
            ((Map)localObject).put("app_version", SysUtils.getAppVersion(this.o));
            if ((this.r != null) && (!this.r.equals(str2)) && (!((Map)localObject).containsKey("_client_id_")))
              ((Map)localObject).put("_client_id_", this.r);
            TrackEvent localTrackEvent = new TrackEvent(paramString, (Map)localObject, paramLong);
            this.m.a(localTrackEvent);
            if (!paramBoolean)
              break;
            this.p.add(localTrackEvent);
            return;
            localException1 = localException1;
            Exception localException2 = localException1;
            localObject = paramMap;
            Log.e("XIAOMIANALYTICS", localException2.getMessage());
            continue;
          }
          catch (Exception localException3)
          {
            continue;
          }
          Object localObject = paramMap;
          continue;
          String str2 = str1;
        }
      }
    }
  }

  public void trackTimedEvent(String paramString, boolean paramBoolean)
  {
    trackTimedEvent(paramString, null, paramBoolean, 0L);
  }

  public void trackTimedEvent(String paramString, boolean paramBoolean, long paramLong)
  {
    trackTimedEvent(paramString, null, paramBoolean, 0L);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.AnalyticsTracker
 * JD-Core Version:    0.6.2
 */