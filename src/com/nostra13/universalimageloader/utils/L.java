package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

public final class L
{
  private static final String a = "%1$s\n%2$s";
  private static volatile boolean b = false;
  private static volatile boolean c = true;

  private static void a(int paramInt, Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    if (!c)
      return;
    if (paramArrayOfObject.length > 0);
    for (String str = String.format(paramString, paramArrayOfObject); ; str = paramString)
    {
      if (paramThrowable == null);
      while (true)
      {
        Log.println(paramInt, ImageLoader.TAG, str);
        return;
        if (str == null)
          str = paramThrowable.getMessage();
        str = String.format("%1$s\n%2$s", new Object[] { str, Log.getStackTraceString(paramThrowable) });
      }
    }
  }

  public static void d(String paramString, Object[] paramArrayOfObject)
  {
    if (b)
      a(3, null, paramString, paramArrayOfObject);
  }

  public static void disableLogging()
  {
    c = false;
  }

  public static void e(String paramString, Object[] paramArrayOfObject)
  {
    a(6, null, paramString, paramArrayOfObject);
  }

  public static void e(Throwable paramThrowable)
  {
    a(6, paramThrowable, null, new Object[0]);
  }

  public static void e(Throwable paramThrowable, String paramString, Object[] paramArrayOfObject)
  {
    a(6, paramThrowable, paramString, paramArrayOfObject);
  }

  public static void enableLogging()
  {
    c = true;
  }

  public static void i(String paramString, Object[] paramArrayOfObject)
  {
    a(4, null, paramString, paramArrayOfObject);
  }

  public static void w(String paramString, Object[] paramArrayOfObject)
  {
    a(5, null, paramString, paramArrayOfObject);
  }

  public static void writeDebugLogs(boolean paramBoolean)
  {
    b = paramBoolean;
  }

  public static void writeLogs(boolean paramBoolean)
  {
    c = paramBoolean;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.L
 * JD-Core Version:    0.6.2
 */