package com.tencent.mm.sdk.platformtools;

import android.content.Context;

public final class MMApplicationContext
{
  private static Context a = null;
  private static String b = "com.tencent.mm";

  public static Context getContext()
  {
    return a;
  }

  public static String getDefaultPreferencePath()
  {
    return b + "_preferences";
  }

  public static String getPackageName()
  {
    return b;
  }

  public static void setContext(Context paramContext)
  {
    a = paramContext;
    b = paramContext.getPackageName();
    Log.d("MicroMsg.MMApplicationContext", "setup application context for package: " + b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMApplicationContext
 * JD-Core Version:    0.6.2
 */