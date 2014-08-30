package com.umeng.analytics;

import u.aly.q;

public class ReportPolicy$c extends ReportPolicy.e
{
  private final int a;
  private q b;

  public ReportPolicy$c(q paramq, int paramInt)
  {
    this.a = paramInt;
    this.b = paramq;
  }

  public boolean a(boolean paramBoolean)
  {
    return this.b.b() > this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.umeng.analytics.ReportPolicy.c
 * JD-Core Version:    0.6.2
 */