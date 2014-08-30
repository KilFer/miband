package cn.com.smartdevices.bracelet.model;

import android.content.Context;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SportDay
  implements Serializable
{
  private static final int ISO_FIRST_DAY_OF_WEEK = 2;
  private static final int ISO_MINIMAL_DAYS_IN_FIRST_WEEK = 4;
  private static final int US_FIRST_DAY_OF_WEEK = 1;
  private static final int US_MINIMAL_DAYS_IN_FIRST_WEEK = 1;
  private static int sFirstDayOfWeek = 0;
  private static int sMinimalDaysInFirstWeek = 0;
  private static final long serialVersionUID = 1L;
  public Calendar calendar;
  public int day;
  public int mon;
  public int year;

  public SportDay()
  {
    this(Calendar.getInstance());
  }

  public SportDay(int paramInt1, int paramInt2, int paramInt3)
  {
    this.year = paramInt1;
    this.mon = paramInt2;
    this.day = paramInt3;
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.year, this.mon, this.day);
    localCalendar.setFirstDayOfWeek(sFirstDayOfWeek);
    localCalendar.setMinimalDaysInFirstWeek(sMinimalDaysInFirstWeek);
    localCalendar.setTimeZone(TimeZone.getTimeZone("GMT+" + localCalendar.get(15) / 1000 / 60 / 60));
    this.calendar = localCalendar;
  }

  public SportDay(SportDay paramSportDay)
  {
    this(paramSportDay.year, paramSportDay.mon, paramSportDay.day);
  }

  public SportDay(Calendar paramCalendar)
  {
    this.year = paramCalendar.get(1);
    this.mon = paramCalendar.get(2);
    this.day = paramCalendar.get(5);
    paramCalendar.setFirstDayOfWeek(sFirstDayOfWeek);
    paramCalendar.setMinimalDaysInFirstWeek(sMinimalDaysInFirstWeek);
    paramCalendar.setTimeZone(TimeZone.getTimeZone("GMT+" + paramCalendar.get(15) / 1000 / 60 / 60));
    this.calendar = paramCalendar;
  }

  public static SportDay fromString(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("-");
      SportDay localSportDay = new SportDay(Integer.parseInt(arrayOfString[0]), -1 + Integer.parseInt(arrayOfString[1]), Integer.parseInt(arrayOfString[2]));
      return localSportDay;
    }
    catch (Exception localException)
    {
    }
    return new SportDay();
  }

  public static Calendar toCalenday(String paramString)
  {
    Calendar localCalendar = Calendar.getInstance();
    try
    {
      String[] arrayOfString = paramString.split("-");
      int i = Integer.parseInt(arrayOfString[0]);
      int j = -1 + Integer.parseInt(arrayOfString[1]);
      int k = Integer.parseInt(arrayOfString[2]);
      localCalendar.clear();
      localCalendar.set(i, j, k);
      return localCalendar;
    }
    catch (Exception localException)
    {
    }
    return localCalendar;
  }

  public SportDay addDay(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.year, this.mon, this.day);
    localCalendar.add(6, paramInt);
    return new SportDay(localCalendar);
  }

  public SportDay addMonth(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.year, this.mon, this.day);
    localCalendar.add(2, paramInt);
    return new SportDay(localCalendar);
  }

  public SportDay addWeek(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.year, this.mon, this.day);
    localCalendar.add(3, paramInt);
    return new SportDay(localCalendar);
  }

  public SportDay addYear(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.year, this.mon, this.day);
    localCalendar.add(1, paramInt);
    return new SportDay(localCalendar);
  }

  public boolean after(SportDay paramSportDay)
  {
    if (this.year > paramSportDay.year);
    while ((this.year == paramSportDay.year) && ((this.mon > paramSportDay.mon) || ((this.mon == paramSportDay.mon) && (this.day > paramSportDay.day))))
      return true;
    return false;
  }

  public boolean before(SportDay paramSportDay)
  {
    if (this.year < paramSportDay.year);
    while ((this.year == paramSportDay.year) && ((this.mon < paramSportDay.mon) || ((this.mon == paramSportDay.mon) && (this.day < paramSportDay.day))))
      return true;
    return false;
  }

  public int compare(SportDay paramSportDay)
  {
    if (this.year > paramSportDay.year);
    do
    {
      do
      {
        return 1;
        if (this.year < paramSportDay.year)
          return -1;
      }
      while (this.mon > paramSportDay.mon);
      if (this.mon < paramSportDay.mon)
        return -1;
    }
    while (this.day > paramSportDay.day);
    if (this.day < paramSportDay.day)
      return -1;
    return 0;
  }

  public boolean equals(int paramInt1, int paramInt2, int paramInt3)
  {
    return (this.day == paramInt3) && (this.mon == paramInt2) && (this.year == paramInt1);
  }

  public boolean equals(SportDay paramSportDay)
  {
    return (this.day == paramSportDay.day) && (this.mon == paramSportDay.mon) && (this.year == paramSportDay.year);
  }

  public boolean equals(Calendar paramCalendar)
  {
    return equals(paramCalendar.get(1), paramCalendar.get(2), paramCalendar.get(5));
  }

  public String formatString()
  {
    Date localDate = new Date();
    localDate.setYear(-1900 + this.year);
    localDate.setMonth(this.mon);
    localDate.setDate(this.day);
    return new SimpleDateFormat("yyyyMMMdd").format(localDate);
  }

  public String formatStringDay(Context paramContext)
  {
    Date localDate = new Date();
    localDate.setYear(-1900 + this.year);
    localDate.setMonth(this.mon);
    localDate.setDate(this.day);
    return new SimpleDateFormat(paramContext.getString(2131492895)).format(localDate);
  }

  public String formatStringDayShort()
  {
    return 1 + this.mon + "/" + this.day;
  }

  public String getKey()
  {
    return toString();
  }

  public SportDay getMonthEndDay()
  {
    SportDay localSportDay1 = getMonthStartDay();
    SportDay localSportDay2 = null;
    for (int i = 1; ; i++)
    {
      if (i > 4);
      do
      {
        return localSportDay2;
        localSportDay2 = localSportDay1.addDay(31 - i);
      }
      while ((localSportDay2.year == this.year) && (localSportDay2.mon == this.mon));
    }
  }

  public SportDay getMonthStartDay()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.year, this.mon, this.day);
    localCalendar.set(5, 1);
    return new SportDay(localCalendar);
  }

  public int getWeek()
  {
    int i = this.calendar.get(7);
    if (i == 1)
      return 6;
    return i - 2;
  }

  public SportDay getWeekStartDay()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(this.year, this.mon, this.day);
    int i = localCalendar.get(7) - sFirstDayOfWeek;
    if (i < 0)
      i += 7;
    localCalendar.add(6, -i);
    return new SportDay(localCalendar);
  }

  public int offsetDay(SportDay paramSportDay)
  {
    Calendar localCalendar1 = this.calendar;
    Calendar localCalendar2 = paramSportDay.calendar;
    if (this.year == paramSportDay.year)
      return localCalendar1.get(6) - localCalendar2.get(6);
    Calendar localCalendar3 = (Calendar)localCalendar1.clone();
    Calendar localCalendar4 = (Calendar)localCalendar2.clone();
    localCalendar3.clear(11);
    localCalendar3.clear(12);
    localCalendar3.clear(13);
    localCalendar3.clear(14);
    localCalendar4.clear(11);
    localCalendar4.clear(12);
    localCalendar4.clear(13);
    localCalendar4.clear(14);
    return (int)((localCalendar3.getTimeInMillis() - localCalendar4.getTimeInMillis()) / 86400000L);
  }

  public int offsetMonth(SportDay paramSportDay)
  {
    if (this.year == paramSportDay.year)
      return this.mon - paramSportDay.mon;
    return 12 * (this.year - paramSportDay.year) + (this.mon - paramSportDay.mon);
  }

  public int offsetWeek(SportDay paramSportDay)
  {
    Calendar localCalendar1 = this.calendar;
    Calendar localCalendar2 = paramSportDay.calendar;
    if (this.year == paramSportDay.year)
      return localCalendar1.get(3) - localCalendar2.get(3);
    return getWeekStartDay().offsetDay(paramSportDay.getWeekStartDay()) / 7;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.year).append("-");
    if (1 + this.mon < 10)
      localStringBuilder.append(0);
    localStringBuilder.append(1 + this.mon).append("-");
    if (this.day < 10)
      localStringBuilder.append(0);
    localStringBuilder.append(this.day);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.SportDay
 * JD-Core Version:    0.6.2
 */