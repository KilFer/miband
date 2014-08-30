package com.umeng.analytics.onlineconfig;

import java.util.Locale;
import org.json.JSONObject;
import u.aly.bj;
import u.aly.bq;

public class b extends bq
{
  public JSONObject a = null;
  boolean b = false;
  int c = -1;
  int d = -1;
  String e;
  private final String f;
  private final String g;
  private final String h;
  private final String i;
  private final String j;

  public b(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (paramJSONObject == null);
    while (true)
    {
      return;
      try
      {
        if (paramJSONObject.has("config_update"))
        {
          boolean bool = paramJSONObject.getString("config_update").toLowerCase(Locale.US).equals("no");
          if (!bool)
            break label83;
        }
        while ((this.c < 0) || (this.c > 6))
        {
          this.c = 1;
          return;
          label83: if (!paramJSONObject.has("report_policy"))
            break label156;
          this.c = paramJSONObject.getInt("report_policy");
          this.d = (1000 * paramJSONObject.optInt("report_interval"));
          this.e = paramJSONObject.optString("last_config_time");
          this.a = paramJSONObject.optJSONObject("online_params");
          this.b = true;
        }
      }
      catch (Exception localException)
      {
        while (true)
        {
          bj.e("MobclickAgent", "fail to parce online config response", localException);
          continue;
          label156: bj.e("MobclickAgent", " online config fetch no report policy");
        }
      }
    }
  }

  private void a()
  {
    if ((this.c < 0) || (this.c > 6))
      this.c = 1;
  }

  private void a(JSONObject paramJSONObject)
  {
    while (true)
    {
      try
      {
        if (!paramJSONObject.has("config_update"))
          break;
        if (paramJSONObject.getString("config_update").toLowerCase(Locale.US).equals("no"))
          return;
        if (paramJSONObject.has("report_policy"))
        {
          this.c = paramJSONObject.getInt("report_policy");
          this.d = (1000 * paramJSONObject.optInt("report_interval"));
          this.e = paramJSONObject.optString("last_config_time");
          this.a = paramJSONObject.optJSONObject("online_params");
          this.b = true;
          return;
        }
      }
      catch (Exception localException)
      {
        bj.e("MobclickAgent", "fail to parce online config response", localException);
        return;
      }
      bj.e("MobclickAgent", " online config fetch no report policy");
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.onlineconfig.b
 * JD-Core Version:    0.6.2
 */