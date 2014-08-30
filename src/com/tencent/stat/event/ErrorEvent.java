package com.tencent.stat.event;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import org.json.JSONObject;

public class ErrorEvent extends Event
{
  private String a;
  private int b;
  private int c = 100;

  public ErrorEvent(Context paramContext, int paramInt1, int paramInt2, Throwable paramThrowable)
  {
    super(paramContext, paramInt1);
    StackTraceElement[] arrayOfStackTraceElement1 = paramThrowable.getStackTrace();
    if ((arrayOfStackTraceElement1 != null) && (arrayOfStackTraceElement1.length > this.c))
    {
      StackTraceElement[] arrayOfStackTraceElement2 = new StackTraceElement[this.c];
      for (int i = 0; i < this.c; i++)
        arrayOfStackTraceElement2[i] = arrayOfStackTraceElement1[i];
      paramThrowable.setStackTrace(arrayOfStackTraceElement2);
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    paramThrowable.printStackTrace(localPrintWriter);
    this.a = localStringWriter.toString();
    this.b = paramInt2;
    localPrintWriter.close();
  }

  public ErrorEvent(Context paramContext, int paramInt, String paramString)
  {
    super(paramContext, paramInt);
    this.a = paramString;
    this.b = 0;
  }

  public EventType getType()
  {
    return EventType.ERROR;
  }

  public boolean onEncode(JSONObject paramJSONObject)
  {
    paramJSONObject.put("er", this.a);
    paramJSONObject.put("ea", this.b);
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.event.ErrorEvent
 * JD-Core Version:    0.6.2
 */