package com.xiaomi.infra.galaxy.common.http;

public class GalaxyBackoffStrategy
{
  private static final GalaxyBackoffStrategy galaxyBackoffStrategy = new GalaxyBackoffStrategy();

  public static GalaxyBackoffStrategy getInstance()
  {
    return galaxyBackoffStrategy;
  }

  public int getBackoffPeriod(int paramInt)
  {
    int i;
    if (paramInt <= 0)
      i = 0;
    do
    {
      return i;
      i = 50 * (int)Math.pow(2.0D, paramInt - 1);
    }
    while (i >= 0);
    return 2147483647;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.GalaxyBackoffStrategy
 * JD-Core Version:    0.6.2
 */