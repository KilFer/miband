package com.umeng.analytics;

import u.aly.w;

public class ReportPolicy$d extends ReportPolicy.e
{
  private long a = 86400000L;
  private w b;

  public ReportPolicy$d(w paramw)
  {
    this.b = paramw;
  }

  public boolean a(boolean paramBoolean)
  {
    return System.currentTimeMillis() - this.b.c >= this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.ReportPolicy.d
 * JD-Core Version:    0.6.2
 */