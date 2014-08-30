package com.xiaomi.miui.analyticstracker;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;

public class LogEvent extends Event
{
  private String a;
  private String b;

  public LogEvent()
  {
    this.mType = Integer.valueOf(1);
    this.a = "";
    this.b = "";
  }

  public LogEvent(String paramString1, String paramString2, String paramString3)
  {
    this.mType = Integer.valueOf(1);
    this.mEventId = paramString1;
    this.a = paramString2;
    this.b = paramString3;
  }

  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.a);
    localStringBuilder.append('$');
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }

  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split("\\$");
      if (arrayOfString.length > 1)
      {
        this.a = arrayOfString[0];
        this.b = arrayOfString[1];
      }
    }
  }

  public void dispatch()
  {
    if (sDispatcher != null)
    {
      Iterator localIterator = sDispatcher.iterator();
      while (localIterator.hasNext())
        ((Dispatchable)localIterator.next()).dispatchLog(this);
    }
  }

  public String getErrorClass()
  {
    return this.b;
  }

  public String getMessage()
  {
    return this.a;
  }

  public void restore(Cursor paramCursor)
  {
    super.restore(paramCursor);
    if (paramCursor != null)
    {
      String str = paramCursor.getString(paramCursor.getColumnIndexOrThrow("param"));
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\$");
        if (arrayOfString.length > 1)
        {
          this.a = arrayOfString[0];
          this.b = arrayOfString[1];
        }
      }
    }
  }

  public void writeEvent(j paramj)
  {
    if (paramj != null)
    {
      Integer localInteger = this.mType;
      String str = this.mEventId;
      StringBuilder localStringBuilder = new StringBuilder(this.a);
      localStringBuilder.append('$');
      localStringBuilder.append(this.b);
      paramj.a(localInteger, str, localStringBuilder.toString(), this.mTrackTime, Boolean.toString(false));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.LogEvent
 * JD-Core Version:    0.6.2
 */