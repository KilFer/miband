package com.umeng.analytics.game;

import com.umeng.analytics.f;
import java.util.HashMap;

final class e extends f
{
  e(d paramd, String paramString)
  {
  }

  public final void a()
  {
    d.a(this.a).a(this.b);
    HashMap localHashMap = new HashMap();
    localHashMap.put("level", this.b);
    localHashMap.put("status", Integer.valueOf(0));
    if (d.a(this.a).b != null)
      localHashMap.put("user_level", d.a(this.a).b);
    d.b(this.a).a(d.c(this.a), "level", localHashMap);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.game.e
 * JD-Core Version:    0.6.2
 */