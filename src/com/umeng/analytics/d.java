package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.umeng.analytics.onlineconfig.UmengOnlineConfigureListener;
import com.umeng.analytics.onlineconfig.a;
import java.util.HashMap;
import java.util.Map;
import u.aly.ac;
import u.aly.bj;
import u.aly.k;
import u.aly.t;
import u.aly.u;
import u.aly.v;
import u.aly.z;

public class d
  implements t
{
  private final a a = new a();
  private Context b = null;
  private c c;
  private u.aly.m d = new u.aly.m();
  private z e = new z();
  private v f = new v();
  private u.aly.n g;
  private k h;
  private boolean i = false;

  d()
  {
    this.d.a(this);
  }

  private void f(Context paramContext)
  {
    if (!this.i)
    {
      this.b = paramContext.getApplicationContext();
      this.g = new u.aly.n(this.b);
      this.h = k.a(this.b);
      this.i = true;
    }
  }

  private void g(Context paramContext)
  {
    this.f.c(paramContext);
    if (this.c != null)
      this.c.a();
  }

  private void h(Context paramContext)
  {
    this.f.d(paramContext);
    this.e.a(paramContext);
    if (this.c != null)
      this.c.b();
    this.h.b();
  }

  public void a(int paramInt)
  {
    AnalyticsConfig.mVerticalType = paramInt;
  }

  final void a(Context paramContext)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    this.a.a(paramContext);
    try
    {
      k.a(paramContext).a(this.a);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  final void a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
      return;
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in reportError");
      return;
    }
    try
    {
      if (!this.i)
        f(paramContext);
      this.h.a(new ac(paramString).a(false));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  final void a(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      e.a(new n(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  public void a(Context paramContext, String paramString1, String paramString2, long paramLong, int paramInt)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      this.g.a(paramString1, paramString2, paramLong, paramInt);
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  public void a(Context paramContext, String paramString, HashMap<String, Object> paramHashMap)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      this.g.a(paramString, paramHashMap);
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  final void a(Context paramContext, String paramString1, HashMap<String, Object> paramHashMap, String paramString2)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      e.a(new p(this, paramString1, paramHashMap, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  final void a(Context paramContext, String paramString, Map<String, Object> paramMap, long paramLong)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      this.g.a(paramString, paramMap, paramLong);
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  final void a(Context paramContext, Throwable paramThrowable)
  {
    if ((paramContext == null) || (paramThrowable == null))
      return;
    try
    {
      if (!this.i)
        f(paramContext);
      this.h.a(new ac(paramThrowable).a(false));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  public void a(c paramc)
  {
    this.c = paramc;
  }

  final void a(UmengOnlineConfigureListener paramUmengOnlineConfigureListener)
  {
    this.a.a(paramUmengOnlineConfigureListener);
  }

  final void a(String paramString)
  {
    if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN);
    try
    {
      this.e.a(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public void a(String paramString1, String paramString2)
  {
    AnalyticsConfig.mWrapperType = paramString1;
    AnalyticsConfig.mWrapperVersion = paramString2;
  }

  public void a(Throwable paramThrowable)
  {
    try
    {
      this.e.a();
      if (this.b != null)
      {
        if ((paramThrowable != null) && (this.h != null))
          this.h.b(new ac(paramThrowable));
        h(this.b);
        u.a(this.b).edit().commit();
      }
      e.a();
      return;
    }
    catch (Exception localException)
    {
      bj.a("MobclickAgent", "Exception in onAppCrash", localException);
    }
  }

  final void b(Context paramContext)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in onResume");
      return;
    }
    if (AnalyticsConfig.ACTIVITY_DURATION_OPEN)
      this.e.a(paramContext.getClass().getName());
    try
    {
      if (!this.i)
        f(paramContext);
      e.a(new l(this, paramContext));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "Exception occurred in Mobclick.onResume(). ", localException);
    }
  }

  final void b(String paramString)
  {
    if (!AnalyticsConfig.ACTIVITY_DURATION_OPEN);
    try
    {
      this.e.b(paramString);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  final void b(String paramString1, String paramString2)
  {
    try
    {
      e.a(new o(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  final void c(Context paramContext)
  {
    if (paramContext == null)
    {
      bj.b("MobclickAgent", "unexpected null context in onPause");
      return;
    }
    if (AnalyticsConfig.ACTIVITY_DURATION_OPEN)
      this.e.b(paramContext.getClass().getName());
    try
    {
      if (!this.i)
        f(paramContext);
      e.a(new m(this, paramContext));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "Exception occurred in Mobclick.onRause(). ", localException);
    }
  }

  final void c(String paramString1, String paramString2)
  {
    try
    {
      e.a(new q(this, paramString1, paramString2));
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  final void d(Context paramContext)
  {
    try
    {
      if (!this.i)
        f(paramContext);
      this.h.a();
      return;
    }
    catch (Exception localException)
    {
      bj.b("MobclickAgent", "", localException);
    }
  }

  final void e(Context paramContext)
  {
    try
    {
      this.e.a();
      h(paramContext);
      u.a(paramContext).edit().commit();
      e.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.d
 * JD-Core Version:    0.6.2
 */