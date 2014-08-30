package com.tencent.stat.common;

import android.content.Context;

public class SdkProtection
{
  private static long a = -1L;

  private static long a(Context paramContext, String paramString)
  {
    return StatPreferences.getLong(paramContext, paramString, a);
  }

  private static void a(Context paramContext, String paramString, long paramLong)
  {
    StatPreferences.putLong(paramContext, paramString, paramLong);
  }

  public static boolean beginCheck(Context paramContext)
  {
    long l1 = a(paramContext, "1.0.0_begin_protection");
    long l2 = a(paramContext, "1.0.0_end__protection");
    if ((l1 > 0L) && (l2 == a))
      return false;
    if (l1 == a)
      StatPreferences.putLong(paramContext, "1.0.0_begin_protection", System.currentTimeMillis());
    return true;
  }

  public static void endCheck(Context paramContext)
  {
    if (a(paramContext, "1.0.0_end__protection") == a)
      StatPreferences.putLong(paramContext, "1.0.0_end__protection", System.currentTimeMillis());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.SdkProtection
 * JD-Core Version:    0.6.2
 */