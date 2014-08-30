package com.tencent.stat.common;

import android.util.Log;
import com.tencent.stat.StatConfig;

public final class StatLogger
{
  private String a = "default";
  private boolean b = true;
  private int c = 2;

  public StatLogger()
  {
  }

  public StatLogger(String paramString)
  {
    this.a = paramString;
  }

  private String a()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null);
    while (true)
    {
      return null;
      int i = arrayOfStackTraceElement.length;
      for (int j = 0; j < i; j++)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
        if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (!localStackTraceElement.getClassName().equals(getClass().getName())))
          return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + "]";
      }
    }
  }

  public final void d(Object paramObject)
  {
    if (isDebugEnable())
      debug(paramObject);
  }

  public final void debug(Object paramObject)
  {
    String str1;
    if (this.c <= 3)
    {
      str1 = a();
      if (str1 != null)
        break label32;
    }
    label32: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.d(this.a, str2);
      return;
    }
  }

  public final void e(Exception paramException)
  {
    if (StatConfig.isDebugEnable())
      error(paramException);
  }

  public final void e(Object paramObject)
  {
    if (isDebugEnable())
      error(paramObject);
  }

  public final void error(Exception paramException)
  {
    if (this.c <= 6)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      String str = a();
      StackTraceElement[] arrayOfStackTraceElement = paramException.getStackTrace();
      if (str != null)
        localStringBuffer.append(str + " - " + paramException + "\r\n");
      while ((arrayOfStackTraceElement != null) && (arrayOfStackTraceElement.length > 0))
      {
        int i = arrayOfStackTraceElement.length;
        for (int j = 0; j < i; j++)
        {
          StackTraceElement localStackTraceElement = arrayOfStackTraceElement[j];
          if (localStackTraceElement != null)
            localStringBuffer.append("[ " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + " ]\r\n");
        }
        localStringBuffer.append(paramException + "\r\n");
      }
      Log.e(this.a, localStringBuffer.toString());
    }
  }

  public final void error(Object paramObject)
  {
    String str1;
    if (this.c <= 6)
    {
      str1 = a();
      if (str1 != null)
        break label33;
    }
    label33: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.e(this.a, str2);
      return;
    }
  }

  public final int getLogLevel()
  {
    return this.c;
  }

  public final void i(Object paramObject)
  {
    if (isDebugEnable())
      info(paramObject);
  }

  public final void info(Object paramObject)
  {
    String str1;
    if (this.c <= 4)
    {
      str1 = a();
      if (str1 != null)
        break label32;
    }
    label32: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.i(this.a, str2);
      return;
    }
  }

  public final boolean isDebugEnable()
  {
    return this.b;
  }

  public final void setDebugEnable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public final void setLogLevel(int paramInt)
  {
    this.c = paramInt;
  }

  public final void setTag(String paramString)
  {
    this.a = paramString;
  }

  public final void v(Object paramObject)
  {
    if (isDebugEnable())
      verbose(paramObject);
  }

  public final void verbose(Object paramObject)
  {
    String str1;
    if (this.c <= 2)
    {
      str1 = a();
      if (str1 != null)
        break label32;
    }
    label32: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.v(this.a, str2);
      return;
    }
  }

  public final void w(Object paramObject)
  {
    if (isDebugEnable())
      warn(paramObject);
  }

  public final void warn(Object paramObject)
  {
    String str1;
    if (this.c <= 5)
    {
      str1 = a();
      if (str1 != null)
        break label32;
    }
    label32: for (String str2 = paramObject.toString(); ; str2 = str1 + " - " + paramObject)
    {
      Log.w(this.a, str2);
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.StatLogger
 * JD-Core Version:    0.6.2
 */