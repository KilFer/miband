package cn.com.smartdevices.bracelet.chart.util;

import cn.com.smartdevices.bracelet.DataManager;
import cn.com.smartdevices.bracelet.model.DaySportData.Summary;
import cn.com.smartdevices.bracelet.model.SportDay;
import java.util.Date;
import java.util.HashMap;

public class ChartData$DynamicData
{
  private static DynamicData m;
  private int a;
  private int b;
  private int c;
  private String d;
  private int e;
  private int f;
  private Date g;
  private Date h;
  private String i;
  private boolean j = true;
  private int k;
  private HashMap<String, ChartData.UserSleepModify> l = new HashMap();

  public static DynamicData getData()
  {
    if (m == null)
      m = new DynamicData();
    return m;
  }

  public int getCurrentMode()
  {
    return this.k;
  }

  public int getSleepDeepTime()
  {
    return this.f;
  }

  public Date getSleepStartDate()
  {
    return this.g;
  }

  public Date getSleepStopDate()
  {
    return this.h;
  }

  public int getSleepTime()
  {
    return this.e;
  }

  public String getSleepTip()
  {
    return this.i;
  }

  public int getStepCalorie()
  {
    return this.c;
  }

  public int getStepCount()
  {
    return this.a;
  }

  public int getStepDistance()
  {
    return this.b;
  }

  public String getStepTip()
  {
    return this.d;
  }

  public ChartData.UserSleepModify getUserSleepModify(SportDay paramSportDay)
  {
    String str = paramSportDay.getKey();
    ChartData.UserSleepModify localUserSleepModify;
    if (this.l.containsKey(str))
      localUserSleepModify = (ChartData.UserSleepModify)this.l.get(str);
    DataManager localDataManager;
    DaySportData.Summary localSummary;
    do
    {
      return localUserSleepModify;
      localDataManager = DataManager.getInstance();
      localSummary = localDataManager.getSummary(paramSportDay);
      localUserSleepModify = new ChartData.UserSleepModify();
    }
    while (localSummary == null);
    localUserSleepModify.sleepStart = localSummary.getUserSleepStart();
    localUserSleepModify.sleepEnd = localSummary.getUserSleepEnd();
    putUserSleepModify(paramSportDay, localUserSleepModify);
    localDataManager.removeSummary(paramSportDay);
    return localUserSleepModify;
  }

  public boolean isWeared()
  {
    return this.j;
  }

  public void putUserSleepModify(SportDay paramSportDay, ChartData.UserSleepModify paramUserSleepModify)
  {
    this.l.put(paramSportDay.getKey(), paramUserSleepModify);
  }

  public void setCurrentMode(int paramInt)
  {
    this.k = paramInt;
  }

  public void setSleepDeepTime(int paramInt)
  {
    this.f = paramInt;
  }

  public void setSleepStartDate(Date paramDate)
  {
    this.g = paramDate;
  }

  public void setSleepStopDate(Date paramDate)
  {
    this.h = paramDate;
  }

  public void setSleepTime(int paramInt)
  {
    this.e = paramInt;
  }

  public void setSleepTip(String paramString)
  {
    this.i = paramString;
  }

  public void setStepCalorie(int paramInt)
  {
    this.c = paramInt;
  }

  public void setStepCount(int paramInt)
  {
    this.a = paramInt;
  }

  public void setStepDistance(int paramInt)
  {
    this.b = paramInt;
  }

  public void setStepTip(String paramString)
  {
    this.d = paramString;
  }

  public void setWeared(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StepCount : " + this.a);
    localStringBuilder.append(", StepDistance : " + this.b);
    localStringBuilder.append(", StepCalorie : " + this.c);
    localStringBuilder.append(", SleepTime : " + this.e);
    localStringBuilder.append(", SleepDeepTime : " + this.f);
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.chart.util.ChartData.DynamicData
 * JD-Core Version:    0.6.2
 */