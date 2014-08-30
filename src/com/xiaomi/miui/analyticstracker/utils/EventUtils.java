package com.xiaomi.miui.analyticstracker.utils;

import android.content.Context;
import java.io.File;

public class EventUtils
{
  public static final String COLUMN_ID = "event_id";
  public static final String COLUMN_PARAM = "param";
  public static final String COLUMN_TIME = "time";
  public static final String COLUMN_TYPE = "type";
  public static final String COLUMN_VALUE = "value";
  public static final int DEFAULT_MAXSAVE = 7;
  public static final String FIRST_DATE = "first_date";
  public static final int TYPE_EVENT = 2;
  public static final int TYPE_LOG = 1;
  public static final int TYPE_TRACKPAGEVIEW = 3;

  public static void deleteDatabaseFile(Context paramContext, String paramString)
  {
    paramContext.deleteDatabase(paramString);
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramContext.getDatabasePath(paramString).getAbsolutePath();
    File localFile = new File(String.format("%s-journal", arrayOfObject));
    if (localFile.exists())
      localFile.delete();
  }

  public static boolean enableWrite(Context paramContext)
  {
    return true;
  }

  public static int getDatabaseIndexFromTime(long paramLong)
  {
    return getDay(paramLong) % 7;
  }

  public static String getDatabaseName()
  {
    return getDatabaseName(getDay(System.currentTimeMillis()) % 7);
  }

  public static String getDatabaseName(int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    return String.format("analytics_%d.db", arrayOfObject);
  }

  public static int getDay(long paramLong)
  {
    return (int)(paramLong / 86400000L);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.utils.EventUtils
 * JD-Core Version:    0.6.2
 */