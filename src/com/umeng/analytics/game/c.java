package com.umeng.analytics.game;

import java.io.Serializable;

final class c
  implements Serializable
{
  private static final long a = 20140327L;
  private String b;
  private long c;
  private long d;

  public c(String paramString)
  {
    this.b = paramString;
  }

  private String f()
  {
    return this.b;
  }

  public final void a()
  {
    this.d = System.currentTimeMillis();
  }

  public final boolean a(String paramString)
  {
    return this.b.equals(paramString);
  }

  public final void b()
  {
    this.c += System.currentTimeMillis() - this.d;
    this.d = 0L;
  }

  public final void c()
  {
    this.d = System.currentTimeMillis();
  }

  public final void d()
  {
    b();
  }

  public final long e()
  {
    return this.c;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.game.c
 * JD-Core Version:    0.6.2
 */