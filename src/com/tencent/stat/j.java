package com.tencent.stat;

final class j
  implements b
{
  j(h paramh)
  {
  }

  public final void a()
  {
    if (StatStore.getInstance().getNumStoredEvents() >= StatConfig.getMaxBatchReportCount())
      StatStore.getInstance().a(StatConfig.getMaxBatchReportCount());
  }

  public final void b()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.j
 * JD-Core Version:    0.6.2
 */