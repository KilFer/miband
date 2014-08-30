package com.tencent.stat.common;

import java.io.File;

final class f
{
  private static int a = -1;

  public static boolean a()
  {
    if (a == 1)
      return true;
    if (a == 0)
      return false;
    String[] arrayOfString = { "/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/" };
    for (int i = 0; ; i++)
      try
      {
        if (i < arrayOfString.length)
        {
          if (!new File(arrayOfString[i] + "su").exists())
            continue;
          a = 1;
          return true;
        }
      }
      catch (Exception localException)
      {
        a = 0;
        return false;
      }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.f
 * JD-Core Version:    0.6.2
 */