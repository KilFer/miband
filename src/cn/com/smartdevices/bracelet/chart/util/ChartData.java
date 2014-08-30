package cn.com.smartdevices.bracelet.chart.util;

import android.content.Context;
import java.text.DecimalFormat;

public final class ChartData
{
  public static final String ACTION_DYNAMIC_VIEW = "DynamicView";
  public static final int HOURS = 24;
  public static final int HOUR_MINUTES = 60;
  public static final String KEY_ACTION = "Action";
  public static final String KEY_DYNAMIC_ACTIVE_TIME = "DynamicActiveTime";
  public static final String KEY_DYNAMIC_ACTIVITY_MODE = "DynamicActivityMode";
  public static final String KEY_DYNAMIC_ACTIVITY_SUB_TITLE = "DynamicActivitySubTitle";
  public static final String KEY_DYNAMIC_COMPLETE_GOAL = "RefCompleteGoal";
  public static final String KEY_DYNAMIC_END_TIME = "DynamicEndTime";
  public static final String KEY_DYNAMIC_START_TIME = "DynamicStartTime";
  public static final String KEY_DYNAMIC_STEP = "DynamicStep";
  public static final String KEY_DYNAMIC_STEP_DISTANCE = "DynamicStepDistance";
  public static final String KEY_SHARE_TYPE = "SHARE_TYPE";
  public static final int MINUTES = 1440;
  public static final String MODE = "Mode";
  public static final int MODE_NONE = 0;
  public static final int MODE_SLEEP = 16;
  public static final int MODE_STEP = 1;
  private static final boolean a;

  public static String[] formatDistance(Context paramContext, int paramInt)
  {
    String[] arrayOfString = new String[2];
    float f = paramInt;
    if (paramInt >= 1000)
    {
      arrayOfString[0] = new DecimalFormat("#.#").format(f / 1000.0F);
      arrayOfString[1] = paramContext.getString(2131492924);
      return arrayOfString;
    }
    arrayOfString[0] = String.valueOf(paramInt);
    arrayOfString[1] = paramContext.getString(2131492925);
    return arrayOfString;
  }

  public static String formatTime(int paramInt)
  {
    String[] arrayOfString = formatTimeHourMin(paramInt);
    return arrayOfString[0] + ":" + arrayOfString[1];
  }

  public static String[] formatTimeHourMin(int paramInt)
  {
    if (paramInt < 0)
      paramInt += 1440;
    int i = paramInt / 60;
    int j = paramInt % 60;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(i);
    arrayOfString[1] = String.valueOf(j);
    if (i < 10)
      arrayOfString[0] = ("0" + arrayOfString[0]);
    if (j < 10)
      arrayOfString[1] = ("0" + arrayOfString[1]);
    return arrayOfString;
  }

  public static String[] formatTimeHourMinLong(int paramInt)
  {
    int i = paramInt / 60;
    int j = paramInt % 60;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(i);
    arrayOfString[1] = String.valueOf(j);
    if (j < 10)
      arrayOfString[1] = ("0" + arrayOfString[1]);
    return arrayOfString;
  }

  public static CharSequence formatTimeLength(Context paramContext, int paramInt1, int paramInt2)
  {
    String[] arrayOfString = formatTimeLengthHourMin(paramInt1);
    ChartUtil.getDensity();
    if (!arrayOfString[0].equals("0"))
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = arrayOfString[0];
      arrayOfObject2[1] = arrayOfString[1];
      return paramContext.getString(2131493153, arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = arrayOfString[1];
    return paramContext.getString(2131493154, arrayOfObject1);
  }

  public static String formatTimeLength(Context paramContext, int paramInt)
  {
    String[] arrayOfString = formatTimeLengthHourMin(paramInt);
    if (!arrayOfString[0].equals("0"))
    {
      Object[] arrayOfObject2 = new Object[2];
      arrayOfObject2[0] = arrayOfString[0];
      arrayOfObject2[1] = arrayOfString[1];
      return paramContext.getString(2131493153, arrayOfObject2);
    }
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = arrayOfString[1];
    return paramContext.getString(2131493154, arrayOfObject1);
  }

  public static String[] formatTimeLengthHourMin(int paramInt)
  {
    int i = paramInt / 60;
    int j = paramInt % 60;
    String[] arrayOfString = new String[2];
    arrayOfString[0] = String.valueOf(i);
    arrayOfString[1] = String.valueOf(j);
    if ((i > 0) && (j < 10))
      arrayOfString[1] = ("0" + arrayOfString[1]);
    return arrayOfString;
  }

  public static String formatTimeLengthLong(Context paramContext, int paramInt)
  {
    String[] arrayOfString = formatTimeHourMinLong(paramInt);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = arrayOfString[0];
    arrayOfObject[1] = arrayOfString[1];
    return paramContext.getString(2131493153, arrayOfObject);
  }

  public static ChartData.DynamicData getDynamicData()
  {
    return ChartData.DynamicData.getData();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.ChartData
 * JD-Core Version:    0.6.2
 */