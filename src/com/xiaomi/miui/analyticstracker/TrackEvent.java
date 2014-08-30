package com.xiaomi.miui.analyticstracker;

import android.database.Cursor;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TrackEvent extends Event
{
  private Map<String, String> a;
  private long b;

  public TrackEvent()
  {
    this.mType = Integer.valueOf(2);
    this.a = null;
    this.b = 0L;
  }

  public TrackEvent(String paramString, Map<String, String> paramMap, long paramLong)
  {
    this.mType = Integer.valueOf(2);
    this.mEventId = paramString;
    this.a = paramMap;
    this.b = paramLong;
  }

  private static String a(Map<String, String> paramMap)
  {
    String str1 = "";
    if (paramMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append(str2);
        localStringBuilder.append('$');
        localStringBuilder.append((String)paramMap.get(str2));
        localStringBuilder.append('$');
      }
      str1 = localStringBuilder.toString();
    }
    return str1;
  }

  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.a = new HashMap();
      String[] arrayOfString = paramString.split("\\$");
      for (int i = 0; i < -1 + arrayOfString.length; i += 2)
        this.a.put(arrayOfString[i], arrayOfString[(i + 1)]);
    }
  }

  public void dispatch()
  {
    if (sDispatcher != null)
    {
      Iterator localIterator = sDispatcher.iterator();
      while (localIterator.hasNext())
        ((Dispatchable)localIterator.next()).dispatchEvent(this);
    }
  }

  public Map<String, String> getParam()
  {
    return this.a;
  }

  public long getValue()
  {
    return this.b;
  }

  public void restore(Cursor paramCursor)
  {
    super.restore(paramCursor);
    if (paramCursor != null)
    {
      this.b = Long.parseLong(paramCursor.getString(paramCursor.getColumnIndexOrThrow("value")));
      String str = paramCursor.getString(paramCursor.getColumnIndexOrThrow("param"));
      if (!TextUtils.isEmpty(str))
      {
        this.a = new HashMap();
        String[] arrayOfString = str.split("\\$");
        for (int i = 0; i < -1 + arrayOfString.length; i += 2)
          this.a.put(arrayOfString[i], arrayOfString[(i + 1)]);
      }
    }
  }

  public void writeEvent(j paramj)
  {
    if (paramj != null)
    {
      Integer localInteger = this.mType;
      String str1 = this.mEventId;
      Map localMap = this.a;
      String str2 = "";
      if (localMap != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          localStringBuilder.append(str3);
          localStringBuilder.append('$');
          localStringBuilder.append((String)localMap.get(str3));
          localStringBuilder.append('$');
        }
        str2 = localStringBuilder.toString();
      }
      paramj.a(localInteger, str1, str2, this.mTrackTime, this.b);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.TrackEvent
 * JD-Core Version:    0.6.2
 */