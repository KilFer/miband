package com.umeng.analytics.onlineconfig;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import org.json.JSONObject;
import u.aly.bj;
import u.aly.bo;

public class a$b extends bo
  implements Runnable
{
  private Context a;

  public a$b(a parama, Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }

  private void b()
  {
    JSONObject localJSONObject = a.a(this.b, this.a);
    a.a locala = new a.a(this.b, localJSONObject);
    String[] arrayOfString = com.umeng.analytics.a.g;
    int i = 0;
    b localb = null;
    while (true)
    {
      if (i >= arrayOfString.length);
      do
      {
        if (localb != null)
          break;
        a.a(this.b, null);
        return;
        locala.a(arrayOfString[i]);
        localb = (b)a(locala, b.class);
      }
      while (localb != null);
      i++;
    }
    if (localb.b)
    {
      if (a.a(this.b) != null)
        a.a(this.b).a(localb.c, localb.d);
      a.a(this.b, this.a, localb);
      a.b(this.b, this.a, localb);
      a.a(this.b, localb.a);
      return;
    }
    a.a(this.b, null);
  }

  public boolean a()
  {
    return false;
  }

  public void run()
  {
    if ((!AnalyticsConfig.UPDATE_IN_MAIN_PROCESS) || (com.umeng.analytics.b.a(this.a)))
    {
      try
      {
        JSONObject localJSONObject = a.a(this.b, this.a);
        a.a locala = new a.a(this.b, localJSONObject);
        String[] arrayOfString = com.umeng.analytics.a.g;
        int i = 0;
        b localb = null;
        while (true)
        {
          if (i >= arrayOfString.length);
          do
          {
            if (localb != null)
              break;
            a.a(this.b, null);
            return;
            locala.a(arrayOfString[i]);
            localb = (b)a(locala, b.class);
          }
          while (localb != null);
          i++;
        }
        if (localb.b)
        {
          if (a.a(this.b) != null)
            a.a(this.b).a(localb.c, localb.d);
          a.a(this.b, this.a, localb);
          a.b(this.b, this.a, localb);
          a.a(this.b, localb.a);
          return;
        }
      }
      catch (Exception localException)
      {
        a.a(this.b, null);
        bj.c("MobclickAgent", "reques update error", localException);
        return;
      }
      a.a(this.b, null);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.onlineconfig.a.b
 * JD-Core Version:    0.6.2
 */