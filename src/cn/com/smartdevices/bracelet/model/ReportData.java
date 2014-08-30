package cn.com.smartdevices.bracelet.model;

import cn.com.smartdevices.bracelet.Utils;
import cn.com.smartdevices.bracelet.analysis.StepsInfo;
import com.google.gson.Gson;

public class ReportData
{
  public int calories = 0;
  public int continueDays = 0;
  public int distance = 0;
  public int maxContinueDays = 0;
  public int maxDateStep = 0;
  public String maxDateStr = "";
  public int steps = 0;
  public String timeFrom = "";
  public String timeTo = "";
  public int todayComplete = 0;
  public String type = "SHARE_TYPE_LAST_WEEK";

  public static ReportData fromJsonStr(String paramString)
  {
    return (ReportData)Utils.getGson().fromJson(paramString, ReportData.class);
  }

  public int getCalories()
  {
    return this.calories;
  }

  public int getContinueDays()
  {
    return this.continueDays;
  }

  public int getDistance()
  {
    return this.distance;
  }

  public int getMaxContinueDays()
  {
    return this.maxContinueDays;
  }

  public int getMaxDateStep()
  {
    return this.maxDateStep;
  }

  public String getMaxDateStr()
  {
    return this.maxDateStr;
  }

  public int getSteps()
  {
    return this.steps;
  }

  public String getTimeFrom()
  {
    return this.timeFrom;
  }

  public String getTimeTo()
  {
    return this.timeTo;
  }

  public int getTodayComplete()
  {
    return this.todayComplete;
  }

  public String getType()
  {
    return this.type;
  }

  public boolean isValid()
  {
    return this.steps != 0;
  }

  public void setCalories(int paramInt)
  {
    this.calories = paramInt;
  }

  public void setContinueDays(int paramInt)
  {
    this.continueDays = paramInt;
  }

  public void setDistance(int paramInt)
  {
    this.distance = paramInt;
  }

  public void setMaxContinueDays(int paramInt)
  {
    this.maxContinueDays = paramInt;
  }

  public void setMaxDateStep(int paramInt)
  {
    this.maxDateStep = paramInt;
  }

  public void setMaxDateStr(String paramString)
  {
    this.maxDateStr = paramString;
  }

  public void setSteps(int paramInt)
  {
    this.steps = paramInt;
  }

  public void setStepsInfo(StepsInfo paramStepsInfo)
  {
    this.steps = paramStepsInfo.getStepsCount();
    this.distance = paramStepsInfo.getDistance();
    this.calories = paramStepsInfo.getCalories();
  }

  public void setTimeFrom(String paramString)
  {
    this.timeFrom = paramString;
  }

  public void setTimeTo(String paramString)
  {
    this.timeTo = paramString;
  }

  public void setTodayComplete(int paramInt)
  {
    this.todayComplete = paramInt;
  }

  public void setType(String paramString)
  {
  }

  public String toJsonStr()
  {
    return Utils.getGson().toJson(this);
  }

  public String toString()
  {
    return "report data:\nsteps:" + this.steps + "\ndistance:" + this.distance + "\ncalories:" + this.calories + "\ntimeFrom:" + this.timeFrom + "\ntimeTo:" + this.timeTo + "\nmaxDateStr:" + this.maxDateStr + "\nmaxDateStep:" + this.maxDateStep + "\ncontinueDays:" + this.continueDays + "\nmaxContinueDays:" + this.maxContinueDays + "\ntodayComplete:" + this.todayComplete + "\n";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.ReportData
 * JD-Core Version:    0.6.2
 */