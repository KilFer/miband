package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;

public final class SystemProperty
{
  private static final HashMap<String, String> a = new HashMap();

  public static String getProperty(String paramString)
  {
    return (String)a.get(paramString);
  }

  public static void setProperty(String paramString1, String paramString2)
  {
    a.put(paramString1, paramString2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.SystemProperty
 * JD-Core Version:    0.6.2
 */