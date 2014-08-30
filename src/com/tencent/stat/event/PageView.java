package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.common.StatCommonHelper;
import org.json.JSONObject;

public class PageView extends Event
{
  private Long a = null;
  private String b;
  private String c;

  public PageView(Context paramContext, String paramString, int paramInt, Long paramLong)
  {
    super(paramContext, paramInt);
    this.c = paramString;
    this.b = StatCommonHelper.getActivityName(paramContext);
    this.a = paramLong;
  }

  public String getPageId()
  {
    return this.b;
  }

  public EventType getType()
  {
    return EventType.PAGE_VIEW;
  }

  public boolean onEncode(JSONObject paramJSONObject)
  {
    paramJSONObject.put("pi", this.b);
    StatCommonHelper.jsonPut(paramJSONObject, "rf", this.c);
    if (this.a != null)
      paramJSONObject.put("du", this.a);
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.event.PageView
 * JD-Core Version:    0.6.2
 */