package com.tencent.stat.event;

import android.content.Context;
import com.tencent.stat.common.Env;
import com.tencent.stat.common.User;
import org.json.JSONObject;

public class SessionEnv extends Event
{
  private Env a;
  private JSONObject b = null;

  public SessionEnv(Context paramContext, int paramInt, JSONObject paramJSONObject)
  {
    super(paramContext, paramInt);
    this.a = new Env(paramContext);
    this.b = paramJSONObject;
  }

  public EventType getType()
  {
    return EventType.SESSION_ENV;
  }

  public boolean onEncode(JSONObject paramJSONObject)
  {
    paramJSONObject.put("ut", this.user.getType());
    if (this.b != null)
      paramJSONObject.put("cfg", this.b);
    this.a.encode(paramJSONObject);
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.event.SessionEnv
 * JD-Core Version:    0.6.2
 */