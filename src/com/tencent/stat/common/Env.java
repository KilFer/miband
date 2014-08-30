package com.tencent.stat.common;

import android.content.Context;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public class Env
{
  private static a a;
  private static JSONObject d = null;
  private Integer b = null;
  private String c = null;

  public Env(Context paramContext)
  {
    if (a == null)
      a = new a(paramContext.getApplicationContext(), (byte)0);
    this.b = StatCommonHelper.getTelephonyNetworkType(paramContext.getApplicationContext());
    this.c = StatCommonHelper.getLinkedWay(paramContext);
  }

  private static a a(Context paramContext)
  {
    if (a == null)
      a = new a(paramContext.getApplicationContext(), (byte)0);
    return a;
  }

  public static void appendEnvAttr(Context paramContext, Map<String, String> paramMap)
  {
    if (paramMap == null);
    while (true)
    {
      return;
      if (d == null)
        d = new JSONObject();
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        d.put((String)localEntry.getKey(), localEntry.getValue());
      }
    }
  }

  public void encode(JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = new JSONObject();
    if (a != null)
      a.a(localJSONObject);
    StatCommonHelper.jsonPut(localJSONObject, "cn", this.c);
    if (this.b != null)
      localJSONObject.put("tn", this.b);
    paramJSONObject.put("ev", localJSONObject);
    if ((d != null) && (d.length() > 0))
      paramJSONObject.put("eva", d);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.Env
 * JD-Core Version:    0.6.2
 */