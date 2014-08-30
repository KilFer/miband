package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.StatAppMonitor;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONObject;

public class MonitorStatEvent extends Event
{
  private static String b = null;
  private static String c = null;
  private StatAppMonitor a = null;

  public MonitorStatEvent(Context paramContext, int paramInt, StatAppMonitor paramStatAppMonitor)
  {
    super(paramContext, paramInt);
    this.a = paramStatAppMonitor;
  }

  public EventType getType()
  {
    return EventType.MONITOR_STAT;
  }

  public boolean onEncode(JSONObject paramJSONObject)
  {
    if (this.a == null)
      return false;
    paramJSONObject.put("na", this.a.getInterfaceName());
    paramJSONObject.put("rq", this.a.getReqSize());
    paramJSONObject.put("rp", this.a.getRespSize());
    paramJSONObject.put("rt", this.a.getResultType());
    paramJSONObject.put("tm", this.a.getMillisecondsConsume());
    paramJSONObject.put("rc", this.a.getReturnCode());
    paramJSONObject.put("sp", this.a.getSampling());
    if (c == null)
      c = StatCommonHelper.getAppVersion(this.ctx);
    StatCommonHelper.jsonPut(paramJSONObject, "av", c);
    if (b == null)
      b = StatCommonHelper.getSimOperator(this.ctx);
    StatCommonHelper.jsonPut(paramJSONObject, "op", b);
    paramJSONObject.put("cn", StatCommonHelper.getLinkedWay(this.ctx));
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.event.MonitorStatEvent
 * JD-Core Version:    0.6.2
 */