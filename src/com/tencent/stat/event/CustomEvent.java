package com.tencent.stat.event;

import android.content.Context;
import java.util.Properties;
import org.json.JSONArray;
import org.json.JSONObject;

public class CustomEvent extends Event
{
  private long a = -1L;
  protected CustomEvent.Key key = new CustomEvent.Key();

  public CustomEvent(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    this.key.a = paramString;
  }

  public CustomEvent.Key getKey()
  {
    return this.key;
  }

  public EventType getType()
  {
    return EventType.CUSTOM;
  }

  public boolean onEncode(JSONObject paramJSONObject)
  {
    paramJSONObject.put("ei", this.key.a);
    if (this.a > 0L)
      paramJSONObject.put("du", this.a);
    if (this.key.b != null)
    {
      JSONArray localJSONArray = new JSONArray();
      String[] arrayOfString = this.key.b;
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
        localJSONArray.put(arrayOfString[j]);
      paramJSONObject.put("ar", localJSONArray);
    }
    if (this.key.c != null)
      paramJSONObject.put("kv", new JSONObject(this.key.c));
    return true;
  }

  public void setArgs(String[] paramArrayOfString)
  {
    this.key.b = paramArrayOfString;
  }

  public void setDuration(long paramLong)
  {
    this.a = paramLong;
  }

  public void setProperties(Properties paramProperties)
  {
    this.key.c = paramProperties;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.event.CustomEvent
 * JD-Core Version:    0.6.2
 */