package cn.com.smartdevices.bracelet;

import android.content.Context;
import com.xiaomi.miui.analyticstracker.AnalyticsTracker;

public final class AnalyticsTrackerManager
{
  public static final String EVENT_DYNAMIC_DETAIL_PAGE = "EventDynamicDetailPage";
  public static final String EVENT_DYNAMIC_PAGE = "EventDynamicPage";
  public static final String EVENT_PERSON_PAGE = "EventPersonPage";
  public static final String EVENT_SETTING_PAGE = "EventSettingPage";
  public static final String EVENT_STATISTIC_PAGE = "EventStatisticPage";
  private static final String a = "AnalyticsTracker";
  private static final boolean b;
  private static AnalyticsTracker c;

  public static AnalyticsTracker endSession(Context paramContext)
  {
    return null;
  }

  public static AnalyticsTracker endTimedEvent(String[] paramArrayOfString)
  {
    return null;
  }

  public static AnalyticsTracker getTracker()
  {
    if (c == null)
      c = AnalyticsTracker.getInstance();
    return c;
  }

  public static AnalyticsTracker startSession(Context paramContext, long paramLong)
  {
    return null;
  }

  public static AnalyticsTracker trackActive(long paramLong)
  {
    return null;
  }

  public static AnalyticsTracker trackTimedEvent(String paramString)
  {
    return null;
  }

  public static AnalyticsTracker trackTimedEvent(String paramString, String[] paramArrayOfString)
  {
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.AnalyticsTrackerManager
 * JD-Core Version:    0.6.2
 */