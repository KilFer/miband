package com.umeng.analytics.game;

import java.util.HashMap;
import u.aly.bj;

final class f extends com.umeng.analytics.f
{
  f(d paramd, String paramString, int paramInt)
  {
  }

  public final void a()
  {
    c localc = d.a(this.a).b(this.b);
    if (localc != null)
    {
      long l = localc.e();
      if (l <= 0L)
      {
        bj.c("MobclickAgent", "level duration is 0");
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("level", this.b);
      localHashMap.put("status", Integer.valueOf(this.c));
      localHashMap.put("duration", Long.valueOf(l));
      if (d.a(this.a).b != null)
        localHashMap.put("user_level", d.a(this.a).b);
      d.b(this.a).a(d.c(this.a), "level", localHashMap);
      return;
    }
    bj.e("MobclickAgent", String.format("finishLevel(or failLevel) called before startLevel", new Object[0]));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.game.f
 * JD-Core Version:    0.6.2
 */