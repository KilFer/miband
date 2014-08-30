package cn.com.smartdevices.bracelet.model;

import android.content.Context;
import android.content.res.Resources;
import com.google.gson.Gson;
import java.util.Calendar;

public class AlarmClockItem
{
  public static final int ALARM_CUSTOM = -1;
  public static final int ALARM_EVERY_DAY;
  public static int ALARM_FRI;
  public static int ALARM_MON;
  public static final int ALARM_MON_2_FRI;
  public static final int ALARM_MON_2_SAT;
  public static int ALARM_ONCE;
  public static int ALARM_SAT;
  public static int ALARM_SUN;
  public static int ALARM_THU;
  public static int ALARM_TUE;
  public static int ALARM_WED;
  public static int MAX_COUNT = 3;
  public static int[] WEEK_MASK = arrayOfInt;
  public Calendar calendar;
  private boolean enabled = true;
  private boolean isUpdate = false;
  private int mDays = 0;
  public int mSmartWakeupDuration = 0;

  static
  {
    ALARM_ONCE = 0;
    ALARM_MON = 1;
    ALARM_TUE = 2;
    ALARM_WED = 4;
    ALARM_THU = 8;
    ALARM_FRI = 16;
    ALARM_SAT = 32;
    ALARM_SUN = 64;
    ALARM_EVERY_DAY = ALARM_MON | ALARM_TUE | ALARM_WED | ALARM_THU | ALARM_FRI | ALARM_SAT | ALARM_SUN;
    ALARM_MON_2_SAT = ALARM_MON | ALARM_TUE | ALARM_WED | ALARM_THU | ALARM_FRI | ALARM_SAT;
    ALARM_MON_2_FRI = ALARM_MON | ALARM_TUE | ALARM_WED | ALARM_THU | ALARM_FRI;
    int[] arrayOfInt = new int[7];
    arrayOfInt[0] = ALARM_MON;
    arrayOfInt[1] = ALARM_TUE;
    arrayOfInt[2] = ALARM_WED;
    arrayOfInt[3] = ALARM_THU;
    arrayOfInt[4] = ALARM_FRI;
    arrayOfInt[5] = ALARM_SAT;
    arrayOfInt[6] = ALARM_SUN;
  }

  public AlarmClockItem()
  {
    setCalendar(Calendar.getInstance());
    set(ALARM_MON_2_FRI, 8, 0, false);
  }

  public static AlarmClockItem fromJson(String paramString)
  {
    return (AlarmClockItem)new Gson().fromJson(paramString, AlarmClockItem.class);
  }

  public Calendar getCalendar()
  {
    if (this.calendar == null)
    {
      this.calendar = Calendar.getInstance();
      this.calendar.set(11, 8);
      this.calendar.set(12, 0);
      setDuration(0);
      setDays(0);
      setUpdate(false);
    }
    return this.calendar;
  }

  public int getCoded()
  {
    return this.mDays;
  }

  public int getDays()
  {
    return this.mDays;
  }

  public int getDuration()
  {
    return this.mSmartWakeupDuration;
  }

  public int getHour()
  {
    return getCalendar().get(11);
  }

  public int getMinute()
  {
    return getCalendar().get(12);
  }

  public boolean isEnabled()
  {
    return this.enabled;
  }

  public boolean isSmartWakeup()
  {
    return getDuration() > 0;
  }

  public boolean isUpdate()
  {
    return this.isUpdate;
  }

  public void set(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    this.mDays = paramInt1;
    getCalendar().set(11, paramInt2);
    getCalendar().set(12, paramInt3);
    this.enabled = paramBoolean;
  }

  public void set(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    set(this.mDays, paramInt1, paramInt2, paramBoolean);
  }

  public void setCalendar(Calendar paramCalendar)
  {
    this.calendar = paramCalendar;
  }

  public void setDays(int paramInt)
  {
    this.mDays = paramInt;
  }

  public void setDuration(int paramInt)
  {
    this.mSmartWakeupDuration = paramInt;
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.enabled = paramBoolean;
  }

  public void setUpdate(boolean paramBoolean)
  {
    this.isUpdate = paramBoolean;
  }

  public String toJson()
  {
    return new Gson().toJson(this);
  }

  public String toTimeString()
  {
    return toTimeString(false);
  }

  public String toTimeString(boolean paramBoolean)
  {
    int i = 12;
    int j = getCalendar().get(11);
    int k = getCalendar().get(i);
    int m;
    if (!paramBoolean)
    {
      m = getCalendar().get(10);
      if (m != 0);
    }
    while (true)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      Object localObject1;
      label76: StringBuilder localStringBuilder2;
      if (i < 10)
      {
        localObject1 = "0" + i;
        localStringBuilder2 = localStringBuilder1.append(localObject1).append(":");
        if (k >= 10)
          break label142;
      }
      label142: for (Object localObject2 = "0" + k; ; localObject2 = Integer.valueOf(k))
      {
        return localObject2;
        i = m;
        break;
        localObject1 = Integer.valueOf(i);
        break label76;
      }
      i = j;
    }
  }

  public String toWeekString(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.mDays == ALARM_ONCE)
      return paramContext.getString(2131492908);
    if (this.mDays == ALARM_EVERY_DAY)
      return paramContext.getString(2131493018);
    if (this.mDays == ALARM_MON_2_FRI)
      return paramContext.getString(2131493019);
    if (this.mDays == ALARM_MON_2_SAT)
      return paramContext.getString(2131493020);
    int i = this.mDays;
    int j = 0;
    Object localObject;
    String[] arrayOfString;
    label116: int k;
    int m;
    if (i <= 0)
    {
      localObject = paramContext.getResources().getStringArray(2131558401);
      arrayOfString = paramContext.getResources().getStringArray(2131558400);
      if (j <= 1)
        break label180;
      k = 0;
      m = j;
    }
    while (true)
    {
      if (k >= 7)
      {
        if ((localStringBuilder.length() > 0) && (j > 1))
          localStringBuilder.insert(0, paramContext.getResources().getString(2131493189));
        return localStringBuilder.toString();
        if ((i & 0x1) == 1)
          j++;
        i >>= 1;
        break;
        label180: localObject = arrayOfString;
        break label116;
      }
      if ((this.mDays & 1 << k) != 0)
      {
        localStringBuilder.append(localObject[k]);
        m--;
        if (m > 0)
          localStringBuilder.append(" ");
      }
      k++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.AlarmClockItem
 * JD-Core Version:    0.6.2
 */