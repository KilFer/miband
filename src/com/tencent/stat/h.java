package com.tencent.stat;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.event.Event;
import com.tencent.stat.event.EventType;

final class h
  implements Runnable
{
  private Event a;
  private StatReportStrategy b = null;

  public h(Event paramEvent)
  {
    this.a = paramEvent;
    this.b = StatConfig.getStatSendStrategy();
  }

  private void a()
  {
    if (StatStore.getInstance().getNumStoredEvents() > 0)
    {
      StatStore.getInstance().b(this.a, null);
      StatStore.getInstance().a(-1);
      return;
    }
    a(true);
  }

  private void a(boolean paramBoolean)
  {
    i locali = null;
    if (paramBoolean)
      locali = new i(this);
    c.b().a(this.a, locali);
  }

  public final void run()
  {
    if (!StatConfig.isEnableStatService());
    Context localContext;
    do
      while (true)
      {
        return;
        if ((this.a.getType() != EventType.ERROR) && (this.a.toJsonString().length() > StatConfig.getMaxReportEventLength()))
        {
          StatService.a().e("Event length exceed StatConfig.getMaxReportEventLength(): " + StatConfig.getMaxReportEventLength());
          return;
        }
        if (StatConfig.getMaxSessionStatReportCount() > 0)
        {
          if (StatConfig.getCurSessionStatReportCount() >= StatConfig.getMaxSessionStatReportCount())
          {
            StatService.a().e("Times for reporting events has reached the limit of StatConfig.getMaxSessionStatReportCount() in current session.");
            return;
          }
          StatConfig.c();
        }
        StatService.a().i("Lauch stat task in thread:" + Thread.currentThread().getName());
        localContext = this.a.getContext();
        if (!StatCommonHelper.isNetworkAvailable(localContext))
        {
          StatStore.getInstance(localContext).b(this.a, null);
          return;
        }
        if ((StatConfig.isEnableSmartReporting()) && (this.b != StatReportStrategy.ONLY_WIFI_NO_CACHE) && (StatCommonHelper.isWifiNet(localContext)))
          this.b = StatReportStrategy.INSTANT;
        switch (g.a[this.b.ordinal()])
        {
        default:
          StatService.a().error("Invalid stat strategy:" + StatConfig.getStatSendStrategy());
          return;
        case 1:
          a();
          return;
        case 2:
          if (StatCommonHelper.isWiFiActive(localContext))
          {
            a();
            return;
          }
          StatStore.getInstance(localContext).b(this.a, null);
          return;
        case 3:
        case 4:
          StatStore.getInstance(localContext).b(this.a, null);
          return;
        case 5:
          if (StatStore.getInstance(this.a.getContext()) != null)
          {
            StatStore.getInstance(localContext).b(this.a, new j(this));
            return;
          }
          break;
        case 6:
          try
          {
            StatStore.getInstance(localContext).b(this.a, null);
            Long localLong1 = Long.valueOf(StatPreferences.getLong(localContext, "last_period_ts", 0L));
            Long localLong2 = Long.valueOf(System.currentTimeMillis());
            if (Long.valueOf(Long.valueOf(localLong2.longValue() - localLong1.longValue()).longValue() / 60000L).longValue() > StatConfig.getSendPeriodMinutes())
            {
              StatStore.getInstance(localContext).a(-1);
              StatPreferences.putLong(localContext, "last_period_ts", localLong2.longValue());
              return;
            }
          }
          catch (Exception localException)
          {
            StatService.a().e(localException);
            return;
          }
        case 7:
        }
      }
    while (!StatCommonHelper.isWiFiActive(localContext));
    a(false);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.h
 * JD-Core Version:    0.6.2
 */