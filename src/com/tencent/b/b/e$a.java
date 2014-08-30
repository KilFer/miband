package com.tencent.b.b;

import android.location.Location;

public final class e$a
  implements Cloneable
{
  private Location a = null;
  private long b = 0L;
  private int c = 0;

  public e$a(e parame, Location paramLocation, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    if (paramLocation != null)
    {
      this.a = new Location(paramLocation);
      this.c = paramInt2;
      this.b = paramLong;
    }
  }

  public final boolean a()
  {
    if (this.a == null);
    while (((this.c > 0) && (this.c < 3)) || (System.currentTimeMillis() - this.b > 30000L))
      return false;
    return true;
  }

  public final Location b()
  {
    return this.a;
  }

  public final Object clone()
  {
    try
    {
      locala = (a)super.clone();
      if (this.a != null)
        locala.a = new Location(this.a);
      return locala;
    }
    catch (Exception localException)
    {
      while (true)
        a locala = null;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.e.a
 * JD-Core Version:    0.6.2
 */