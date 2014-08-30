package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.Env;
import com.tencent.stat.common.SdkProtection;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.common.User;
import com.tencent.stat.event.AdditionEvent;
import com.tencent.stat.event.CustomEvent;
import com.tencent.stat.event.CustomEvent.Key;
import com.tencent.stat.event.ErrorEvent;
import com.tencent.stat.event.MonitorStatEvent;
import com.tencent.stat.event.PageView;
import com.tencent.stat.event.SessionEnv;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class StatService
{
  private static Handler a;
  private static Map<CustomEvent.Key, Long> b = new WeakHashMap();
  private static volatile long c = 0L;
  private static volatile long d = 0L;
  private static volatile int e = 0;
  private static volatile String f = "";
  private static volatile String g = "";
  private static Map<String, Long> h = new WeakHashMap();
  private static StatLogger i = StatCommonHelper.getLogger();
  private static Thread.UncaughtExceptionHandler j = null;
  private static boolean k = true;

  static int a(Context paramContext, boolean paramBoolean)
  {
    int m = 1;
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (l - c >= StatConfig.getSessionTimoutMillis()));
    for (int n = m; ; n = 0)
    {
      c = l;
      if (d == 0L)
        d = StatCommonHelper.getTomorrowStartMilliseconds();
      if (l >= d)
      {
        d = StatCommonHelper.getTomorrowStartMilliseconds();
        if (StatStore.getInstance(paramContext).getUser(paramContext).getType() != m)
          StatStore.getInstance(paramContext).getUser(paramContext).setType(m);
        StatConfig.b(0);
        n = m;
      }
      if (k);
      while (true)
      {
        if (m != 0)
        {
          if (StatConfig.e() >= StatConfig.getMaxDaySessionNumbers())
            break label186;
          if (c(paramContext) != null)
          {
            i.d("start new session.");
            e = StatCommonHelper.getNextSessionID();
            StatConfig.a(0);
            StatConfig.d();
            c(paramContext).post(new h(new SessionEnv(paramContext, e, c())));
          }
        }
        while (true)
        {
          if (k)
          {
            SdkProtection.endCheck(paramContext);
            k = false;
          }
          return e;
          label186: i.e("Exceed StatConfig.getMaxDaySessionNumbers().");
        }
        m = n;
      }
    }
  }

  private static void a(Context paramContext)
  {
    if (paramContext == null);
    while (true)
    {
      return;
      if (a == null)
      {
        long l = StatPreferences.getLong(paramContext, StatConfig.c, 0L);
        if (StatCommonHelper.getSDKLongVersion("1.0.0") <= l)
          StatConfig.setEnableStatService(false);
        for (int m = 0; m != 0; m = 1)
        {
          if (SdkProtection.beginCheck(paramContext))
            break label73;
          i.error("ooh, Compatibility problem was found in this device!");
          i.error("If you are on debug mode, please delete apk and try again.");
          StatConfig.setEnableStatService(false);
          return;
        }
      }
    }
    label73: StatStore.getInstance(paramContext);
    HandlerThread localHandlerThread = new HandlerThread("StatService");
    localHandlerThread.start();
    c.a(paramContext);
    a = new Handler(localHandlerThread.getLooper());
    j = Thread.getDefaultUncaughtExceptionHandler();
    if (StatConfig.isAutoExceptionCaught())
      Thread.setDefaultUncaughtExceptionHandler(new f(paramContext.getApplicationContext()));
    while (true)
    {
      if ((StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) && (StatCommonHelper.isNetworkAvailable(paramContext)))
        StatStore.getInstance(paramContext).a(-1);
      i.d("Init MTA StatService success.");
      return;
      i.warn("MTA SDK AutoExceptionCaught is disable");
    }
  }

  private static void a(Context paramContext, Throwable paramThrowable)
  {
    try
    {
      if (!StatConfig.isEnableStatService())
        return;
      if (paramContext == null)
      {
        i.error("The Context of StatService.reportSdkSelfException() can not be null!");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      i.e("reportSdkSelfException error: " + localThrowable);
      return;
    }
    ErrorEvent localErrorEvent = new ErrorEvent(paramContext, a(paramContext, false), 99, paramThrowable);
    if (c(paramContext) != null)
      c(paramContext).post(new h(localErrorEvent));
  }

  private static void a(Context paramContext, Map<String, ?> paramMap)
  {
    if (!StatConfig.isEnableStatService());
    while (true)
    {
      return;
      if (paramContext == null)
      {
        i.error("The Context of StatService.sendAdditionEvent() can not be null!");
        return;
      }
      try
      {
        AdditionEvent localAdditionEvent = new AdditionEvent(paramContext, a(paramContext, false), null);
        if (c(paramContext) != null)
        {
          c(paramContext).post(new h(localAdditionEvent));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
      }
    }
  }

  private static boolean a(String paramString)
  {
    return (paramString == null) || (paramString.length() == 0);
  }

  private static boolean b(Context paramContext)
  {
    long l = StatPreferences.getLong(paramContext, StatConfig.c, 0L);
    if (StatCommonHelper.getSDKLongVersion("1.0.0") <= l)
    {
      StatConfig.setEnableStatService(false);
      return false;
    }
    return true;
  }

  private static Handler c(Context paramContext)
  {
    if ((paramContext != null) && (a == null))
    {
      long l = StatPreferences.getLong(paramContext, StatConfig.c, 0L);
      if (StatCommonHelper.getSDKLongVersion("1.0.0") > l)
        break label70;
      StatConfig.setEnableStatService(false);
    }
    label70: for (int m = 0; ; m = 1)
    {
      if (m != 0)
      {
        if (SdkProtection.beginCheck(paramContext))
          break;
        i.error("ooh, Compatibility problem was found in this device!");
        i.error("If you are on debug mode, please delete apk and try again.");
        StatConfig.setEnableStatService(false);
      }
      return a;
    }
    StatStore.getInstance(paramContext);
    HandlerThread localHandlerThread = new HandlerThread("StatService");
    localHandlerThread.start();
    c.a(paramContext);
    a = new Handler(localHandlerThread.getLooper());
    j = Thread.getDefaultUncaughtExceptionHandler();
    if (StatConfig.isAutoExceptionCaught())
      Thread.setDefaultUncaughtExceptionHandler(new f(paramContext.getApplicationContext()));
    while (true)
    {
      if ((StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) && (StatCommonHelper.isNetworkAvailable(paramContext)))
        StatStore.getInstance(paramContext).a(-1);
      i.d("Init MTA StatService success.");
      break;
      i.warn("MTA SDK AutoExceptionCaught is disable");
    }
  }

  private static JSONObject c()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      if (StatConfig.b.d != 0)
        localJSONObject2.put("v", StatConfig.b.d);
      localJSONObject1.put(Integer.toString(StatConfig.b.a), localJSONObject2);
      JSONObject localJSONObject3 = new JSONObject();
      if (StatConfig.a.d != 0)
        localJSONObject3.put("v", StatConfig.a.d);
      localJSONObject1.put(Integer.toString(StatConfig.a.a), localJSONObject3);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      i.e(localJSONException);
    }
    return localJSONObject1;
  }

  public static void commitEvents(Context paramContext, int paramInt)
  {
    if (!StatConfig.isEnableStatService())
      return;
    if (paramContext == null)
    {
      i.error("The Context of StatService.commitEvents() can not be null!");
      return;
    }
    if ((paramInt < -1) || (paramInt == 0))
    {
      i.error("The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.");
      return;
    }
    try
    {
      StatStore.getInstance(paramContext).a(paramInt);
      return;
    }
    catch (Throwable localThrowable)
    {
      a(paramContext, localThrowable);
    }
  }

  private static void d(Context paramContext)
  {
    if (c(paramContext) != null)
    {
      i.d("start new session.");
      e = StatCommonHelper.getNextSessionID();
      StatConfig.a(0);
      StatConfig.d();
      c(paramContext).post(new h(new SessionEnv(paramContext, e, c())));
    }
  }

  public static void onPause(Context paramContext)
  {
    if (!StatConfig.isEnableStatService())
      return;
    if (paramContext == null)
    {
      i.error("The Context of StatService.onPause() can not be null!");
      return;
    }
    String str;
    try
    {
      str = StatCommonHelper.getActivityName(paramContext);
      Long localLong1 = (Long)h.remove(str);
      if (localLong1 != null)
      {
        Long localLong2 = Long.valueOf((System.currentTimeMillis() - localLong1.longValue()) / 1000L);
        if (localLong2.longValue() == 0L)
          localLong2 = Long.valueOf(1L);
        if (g.equals(str) == true)
          g = "-";
        PageView localPageView = new PageView(paramContext, g, a(paramContext, false), localLong2);
        if (!localPageView.getPageId().equals(f))
          i.warn("Invalid invocation since previous onResume on diff page.");
        if (c(paramContext) != null)
          c(paramContext).post(new h(localPageView));
        g = str;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      a(paramContext, localThrowable);
      return;
    }
    i.e("Starttime for PageID:" + str + " not found, lost onResume()?");
  }

  public static void onResume(Context paramContext)
  {
    if (!StatConfig.isEnableStatService());
    String str;
    do
    {
      return;
      if (paramContext == null)
      {
        i.error("The Context of StatService.onResume() can not be null!");
        return;
      }
      try
      {
        if (h.size() >= StatConfig.getMaxParallelTimmingEvents())
        {
          i.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
        return;
      }
      str = StatCommonHelper.getActivityName(paramContext);
      f = str;
    }
    while (str == null);
    if (h.containsKey(f))
    {
      i.e("Duplicate PageID : " + f + ", onResume() repeated?");
      return;
    }
    h.put(f, Long.valueOf(System.currentTimeMillis()));
    a(paramContext, true);
  }

  public static void reportAppMonitorStat(Context paramContext, StatAppMonitor paramStatAppMonitor)
  {
    if (!StatConfig.isEnableStatService());
    while (true)
    {
      return;
      if (paramContext == null)
      {
        i.error("The Context of StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      if (paramStatAppMonitor == null)
      {
        i.error("The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      if (paramStatAppMonitor.getInterfaceName() == null)
      {
        i.error("The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!");
        return;
      }
      try
      {
        MonitorStatEvent localMonitorStatEvent = new MonitorStatEvent(paramContext, a(paramContext, false), paramStatAppMonitor);
        if (c(paramContext) != null)
        {
          c(paramContext).post(new h(localMonitorStatEvent));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
      }
    }
  }

  public static void reportError(Context paramContext, String paramString)
  {
    if (!StatConfig.isEnableStatService());
    while (true)
    {
      return;
      if (paramContext == null)
      {
        i.error("The Context of StatService.reportError() can not be null!");
        return;
      }
      if (a(paramString))
      {
        i.error("Error message in StatService.reportError() is empty.");
        return;
      }
      try
      {
        ErrorEvent localErrorEvent = new ErrorEvent(paramContext, a(paramContext, false), paramString);
        if (c(paramContext) != null)
        {
          c(paramContext).post(new h(localErrorEvent));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
      }
    }
  }

  public static void reportException(Context paramContext, Throwable paramThrowable)
  {
    if (!StatConfig.isEnableStatService());
    ErrorEvent localErrorEvent;
    do
    {
      return;
      if (paramContext == null)
      {
        i.error("The Context of StatService.reportException() can not be null!");
        return;
      }
      if (paramThrowable == null)
      {
        i.error("The Throwable error message of StatService.reportException() can not be null!");
        return;
      }
      localErrorEvent = new ErrorEvent(paramContext, a(paramContext, false), 1, paramThrowable);
    }
    while (c(paramContext) == null);
    c(paramContext).post(new h(localErrorEvent));
  }

  public static void reportQQ(Context paramContext, String paramString)
  {
    if (paramString == null)
      paramString = "";
    if (!StatConfig.d.equals(paramString))
    {
      StatConfig.d = paramString;
      if (StatConfig.isEnableStatService())
      {
        if (paramContext != null)
          break label41;
        i.error("The Context of StatService.sendAdditionEvent() can not be null!");
      }
    }
    while (true)
    {
      return;
      try
      {
        label41: AdditionEvent localAdditionEvent = new AdditionEvent(paramContext, a(paramContext, false), null);
        if (c(paramContext) != null)
        {
          c(paramContext).post(new h(localAdditionEvent));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
      }
    }
  }

  public static void setEnvAttributes(Context paramContext, Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() > 512))
    {
      i.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
      return;
    }
    try
    {
      Env.appendEnvAttr(paramContext, paramMap);
      return;
    }
    catch (JSONException localJSONException)
    {
      i.e(localJSONException);
    }
  }

  public static void startNewSession(Context paramContext)
  {
    if (!StatConfig.isEnableStatService())
      return;
    if (paramContext == null)
    {
      i.error("The Context of StatService.startNewSession() can not be null!");
      return;
    }
    try
    {
      c = 0L;
      a(paramContext, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      a(paramContext, localThrowable);
    }
  }

  public static boolean startStatService(Context paramContext, String paramString1, String paramString2)
  {
    if (!StatConfig.isEnableStatService())
    {
      i.error("MTA StatService is disable.");
      return false;
    }
    i.d("MTA SDK version, current: " + "1.0.0" + " ,required: " + paramString2);
    if ((paramContext == null) || (paramString2 == null))
    {
      i.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
      StatConfig.setEnableStatService(false);
      throw new MtaSDkException("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
    }
    if (StatCommonHelper.getSDKLongVersion("1.0.0") < StatCommonHelper.getSDKLongVersion(paramString2))
    {
      String str2 = "MTA SDK version conflicted, current: " + "1.0.0" + ",required: " + paramString2;
      String str3 = str2 + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
      i.error(str3);
      StatConfig.setEnableStatService(false);
      throw new MtaSDkException(str3);
    }
    try
    {
      String str1 = StatConfig.getInstallChannel(paramContext);
      if ((str1 == null) || (str1.length() == 0))
        StatConfig.setInstallChannel("-");
      StatConfig.setAppKey(paramContext, paramString1);
      c(paramContext);
      return true;
    }
    catch (Throwable localThrowable)
    {
      i.e(localThrowable);
    }
    return false;
  }

  public static void stopSession()
  {
    c = 0L;
  }

  public static void trackCustomBeginEvent(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    if (!StatConfig.isEnableStatService())
      return;
    if (paramContext == null)
    {
      i.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
      return;
    }
    if (a(paramString))
    {
      i.error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
      return;
    }
    CustomEvent.Key localKey;
    try
    {
      CustomEvent localCustomEvent = new CustomEvent(paramContext, a(paramContext, false), paramString);
      localCustomEvent.setArgs(paramArrayOfString);
      localKey = localCustomEvent.getKey();
      if (b.containsKey(localKey))
      {
        i.error("Duplicate CustomEvent key: " + localKey.toString() + ", trackCustomBeginEvent() repeated?");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      a(paramContext, localThrowable);
      return;
    }
    if (b.size() <= StatConfig.getMaxParallelTimmingEvents())
    {
      b.put(localKey, Long.valueOf(System.currentTimeMillis()));
      return;
    }
    i.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
  }

  public static void trackCustomBeginKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    if (!StatConfig.isEnableStatService())
      return;
    if (paramContext == null)
    {
      i.error("The Context of StatService.trackCustomBeginEvent() can not be null!");
      return;
    }
    if (a(paramString))
    {
      i.error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
      return;
    }
    CustomEvent.Key localKey;
    try
    {
      CustomEvent localCustomEvent = new CustomEvent(paramContext, a(paramContext, false), paramString);
      localCustomEvent.setProperties(paramProperties);
      localKey = localCustomEvent.getKey();
      if (b.containsKey(localKey))
      {
        i.error("Duplicate CustomEvent key: " + localKey.toString() + ", trackCustomBeginKVEvent() repeated?");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      a(paramContext, localThrowable);
      return;
    }
    if (b.size() <= StatConfig.getMaxParallelTimmingEvents())
    {
      b.put(localKey, Long.valueOf(System.currentTimeMillis()));
      return;
    }
    i.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
  }

  public static void trackCustomEndEvent(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    if (!StatConfig.isEnableStatService())
      return;
    if (paramContext == null)
    {
      i.error("The Context of StatService.trackCustomEndEvent() can not be null!");
      return;
    }
    if (a(paramString))
    {
      i.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
      return;
    }
    CustomEvent localCustomEvent;
    while (true)
    {
      Long localLong2;
      try
      {
        localCustomEvent = new CustomEvent(paramContext, a(paramContext, false), paramString);
        localCustomEvent.setArgs(paramArrayOfString);
        Long localLong1 = (Long)b.remove(localCustomEvent.getKey());
        if (localLong1 == null)
          break label166;
        localLong2 = Long.valueOf((System.currentTimeMillis() - localLong1.longValue()) / 1000L);
        if (localLong2.longValue() == 0L)
        {
          l = 1L;
          localCustomEvent.setDuration(Long.valueOf(l).longValue());
          if (c(paramContext) == null)
            break;
          c(paramContext).post(new h(localCustomEvent));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
        return;
      }
      long l = localLong2.longValue();
    }
    label166: i.error("No start time found for custom event: " + localCustomEvent.getKey().toString() + ", lost trackCustomBeginEvent()?");
  }

  public static void trackCustomEndKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    if (!StatConfig.isEnableStatService())
      return;
    if (paramContext == null)
    {
      i.error("The Context of StatService.trackCustomEndEvent() can not be null!");
      return;
    }
    if (a(paramString))
    {
      i.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
      return;
    }
    CustomEvent localCustomEvent;
    while (true)
    {
      Long localLong2;
      try
      {
        localCustomEvent = new CustomEvent(paramContext, a(paramContext, false), paramString);
        localCustomEvent.setProperties(paramProperties);
        Long localLong1 = (Long)b.remove(localCustomEvent.getKey());
        if (localLong1 == null)
          break label166;
        localLong2 = Long.valueOf((System.currentTimeMillis() - localLong1.longValue()) / 1000L);
        if (localLong2.longValue() == 0L)
        {
          l = 1L;
          localCustomEvent.setDuration(Long.valueOf(l).longValue());
          if (c(paramContext) == null)
            break;
          c(paramContext).post(new h(localCustomEvent));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
        return;
      }
      long l = localLong2.longValue();
    }
    label166: i.error("No start time found for custom event: " + localCustomEvent.getKey().toString() + ", lost trackCustomBeginKVEvent()?");
  }

  public static void trackCustomEvent(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    if (!StatConfig.isEnableStatService());
    while (true)
    {
      return;
      if (paramContext == null)
      {
        i.error("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        i.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      try
      {
        CustomEvent localCustomEvent = new CustomEvent(paramContext, a(paramContext, false), paramString);
        localCustomEvent.setArgs(paramArrayOfString);
        if (c(paramContext) != null)
        {
          c(paramContext).post(new h(localCustomEvent));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
      }
    }
  }

  public static void trackCustomKVEvent(Context paramContext, String paramString, Properties paramProperties)
  {
    if (!StatConfig.isEnableStatService());
    while (true)
    {
      return;
      if (paramContext == null)
      {
        i.error("The Context of StatService.trackCustomEvent() can not be null!");
        return;
      }
      if (a(paramString))
      {
        i.error("The event_id of StatService.trackCustomEvent() can not be null or empty.");
        return;
      }
      try
      {
        CustomEvent localCustomEvent = new CustomEvent(paramContext, a(paramContext, false), paramString);
        localCustomEvent.setProperties(paramProperties);
        if (c(paramContext) != null)
        {
          c(paramContext).post(new h(localCustomEvent));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        a(paramContext, localThrowable);
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.StatService
 * JD-Core Version:    0.6.2
 */