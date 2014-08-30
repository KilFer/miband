package com.umeng.analytics;

import u.aly.w;

public class ReportPolicy$b extends ReportPolicy.e
{
  private long a = 10000L;
  private long b;
  private w c;

  public ReportPolicy$b(w paramw, long paramLong)
  {
    this.c = paramw;
    if (paramLong < this.a)
      paramLong = this.a;
    this.b = paramLong;
  }

  public long a()
  {
    return this.b;
  }

  public boolean a(boolean paramBoolean)
  {
    return System.currentTimeMillis() - this.c.c >= this.b;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.ReportPolicy.b
 * JD-Core Version:    0.6.2
 */