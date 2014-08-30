package com.xiaomi.market.sdk;

import android.util.Log;

public class Patcher
{
  private static final String a = "MarketPatcher";
  private static final String b = "sdk_patcher_jni";

  public static int a(String paramString1, String paramString2, String paramString3)
  {
    return new Patcher().applyPatch(paramString1, paramString2, paramString3);
  }

  public static boolean o()
  {
    try
    {
      System.loadLibrary("sdk_patcher_jni");
      return true;
    }
    catch (Throwable localThrowable)
    {
      Log.e("MarketPatcher", "load patcher library failed : " + localThrowable.toString());
    }
    return false;
  }

  public native int applyPatch(String paramString1, String paramString2, String paramString3);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.Patcher
 * JD-Core Version:    0.6.2
 */