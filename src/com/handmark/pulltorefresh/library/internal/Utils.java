package com.handmark.pulltorefresh.library.internal;

import android.util.Log;

public class Utils
{
  private static String a = "PullToRefresh";

  public static void warnDeprecation(String paramString1, String paramString2)
  {
    Log.w("PullToRefresh", "You're using the deprecated " + paramString1 + " attr, please switch over to " + paramString2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.handmark.pulltorefresh.library.internal.Utils
 * JD-Core Version:    0.6.2
 */