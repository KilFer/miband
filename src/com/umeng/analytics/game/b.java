package com.umeng.analytics.game;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import u.aly.s;
import u.aly.u;

public class b
{
  public String a;
  public String b;
  private Context c;
  private final String d;
  private final String e;
  private final String f;
  private final String g;
  private c h = null;

  public b(Context paramContext)
  {
    this.c = paramContext;
  }

  public c a(String paramString)
  {
    this.h = new c(paramString);
    this.h.a();
    return this.h;
  }

  public void a()
  {
    if (this.h != null)
    {
      this.h.b();
      SharedPreferences.Editor localEditor = this.c.getSharedPreferences("um_g_cache", 0).edit();
      localEditor.putString("single_level", s.a(this.h));
      localEditor.putString("stat_player_level", this.b);
      localEditor.putString("stat_game_level", this.a);
      localEditor.commit();
    }
  }

  public c b(String paramString)
  {
    if (this.h != null)
    {
      this.h.d();
      if (this.h.a(paramString))
      {
        c localc = this.h;
        this.h = null;
        return localc;
      }
    }
    return null;
  }

  public void b()
  {
    SharedPreferences localSharedPreferences = u.a(this.c, "um_g_cache");
    String str = localSharedPreferences.getString("single_level", null);
    if (str != null)
    {
      this.h = ((c)s.a(str));
      if (this.h != null)
        this.h.c();
    }
    if (this.b == null)
      this.b = localSharedPreferences.getString("stat_player_level", null);
    if (this.a == null)
      this.a = localSharedPreferences.getString("stat_game_level", null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.game.b
 * JD-Core Version:    0.6.2
 */