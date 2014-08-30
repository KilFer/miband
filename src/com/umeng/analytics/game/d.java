package com.umeng.analytics.game;

import android.content.Context;
import com.umeng.analytics.Gender;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.c;
import java.util.HashMap;
import u.aly.bj;

final class d
  implements c
{
  private com.umeng.analytics.d a = MobclickAgent.getAgent();
  private b b = null;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final String h;
  private final String i;
  private final String j;
  private final String k;
  private final String l;
  private final String m;
  private final String n;
  private final String o;
  private final String p;
  private final String q;
  private final String r;
  private final String s;
  private final String t;
  private final String u;
  private final String v;
  private final String w;
  private Context x;

  public d()
  {
    this.a.a(1);
    a.a = true;
  }

  private void a(String paramString, int paramInt)
  {
    if (this.x == null)
    {
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    com.umeng.analytics.e.a(new f(this, paramString, paramInt));
  }

  static void a(String paramString1, int paramInt, Gender paramGender, String paramString2)
  {
    com.umeng.analytics.AnalyticsConfig.sId = paramString1;
    com.umeng.analytics.AnalyticsConfig.sAge = paramInt;
    com.umeng.analytics.AnalyticsConfig.sGender = paramGender;
    com.umeng.analytics.AnalyticsConfig.sSource = paramString2;
  }

  static void a(boolean paramBoolean)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Boolean.valueOf(paramBoolean);
    bj.c("MobclickAgent", String.format("Trace sleep time : %b", arrayOfObject));
    a.a = paramBoolean;
  }

  public final void a()
  {
    bj.c("MobclickAgent", "App resume from background");
    if (this.x == null)
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
    while (!a.a)
      return;
    this.b.b();
  }

  final void a(double paramDouble1, double paramDouble2, int paramInt)
  {
    if (this.x == null)
    {
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("cash", Long.valueOf(()(paramDouble1 * 100.0D)));
    localHashMap.put("coin", Long.valueOf(()(paramDouble2 * 100.0D)));
    localHashMap.put("source", Integer.valueOf(paramInt));
    if (this.b.b != null)
      localHashMap.put("user_level", this.b.b);
    if (this.b.a != null)
      localHashMap.put("level", this.b.a);
    this.a.a(this.x, "pay", localHashMap);
  }

  final void a(double paramDouble, int paramInt)
  {
    if (this.x == null)
    {
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("coin", Long.valueOf(()(100.0D * paramDouble)));
    localHashMap.put("bonus_source", Integer.valueOf(paramInt));
    if (this.b.b != null)
      localHashMap.put("user_level", this.b.b);
    if (this.b.a != null)
      localHashMap.put("level", this.b.a);
    this.a.a(this.x, "bonus", localHashMap);
  }

  final void a(double paramDouble1, String paramString, int paramInt1, double paramDouble2, int paramInt2)
  {
    a(paramDouble1, paramDouble2 * paramInt1, paramInt2);
    a(paramString, paramInt1, paramDouble2);
  }

  final void a(Context paramContext)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "Context is null, can't init GameAgent");
      return;
    }
    this.x = paramContext.getApplicationContext();
    this.a.a(this);
    this.b = new b(this.x);
  }

  final void a(String paramString)
  {
    this.b.b = paramString;
  }

  final void a(String paramString, int paramInt, double paramDouble)
  {
    if (this.x == null)
    {
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("item", paramString);
    localHashMap.put("amount", Integer.valueOf(paramInt));
    localHashMap.put("coin", Long.valueOf(()(100.0D * (paramDouble * paramInt))));
    if (this.b.b != null)
      localHashMap.put("user_level", this.b.b);
    if (this.b.a != null)
      localHashMap.put("level", this.b.a);
    this.a.a(this.x, "buy", localHashMap);
  }

  final void a(String paramString, int paramInt1, double paramDouble, int paramInt2)
  {
    a(paramDouble * paramInt1, paramInt2);
    a(paramString, paramInt1, paramDouble);
  }

  public final void b()
  {
    if (this.x == null)
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
    while (!a.a)
      return;
    this.b.a();
  }

  final void b(String paramString)
  {
    if (this.x == null)
    {
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    this.b.a = paramString;
    com.umeng.analytics.e.a(new e(this, paramString));
  }

  final void b(String paramString, int paramInt, double paramDouble)
  {
    if (this.x == null)
    {
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("item", paramString);
    localHashMap.put("amount", Integer.valueOf(paramInt));
    localHashMap.put("coin", Long.valueOf(()(100.0D * (paramDouble * paramInt))));
    if (this.b.b != null)
      localHashMap.put("user_level", this.b.b);
    if (this.b.a != null)
      localHashMap.put("level", this.b.a);
    this.a.a(this.x, "use", localHashMap);
  }

  final void c(String paramString)
  {
    if (this.x == null)
    {
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    a(paramString, 1);
  }

  final void d(String paramString)
  {
    if (this.x == null)
    {
      bj.b("MobclickAgent", "UMGameAgent.init(Context) should be called before any game api");
      return;
    }
    a(paramString, -1);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.game.d
 * JD-Core Version:    0.6.2
 */