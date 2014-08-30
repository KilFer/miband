package cn.com.smartdevices.bracelet.model;

public class DaySportData$SummaryEntity
  implements DaySportData.Summary
{
  private int daySportGoal = 8000;
  private int sleep;
  private int sleepDeepTime;
  private long sleepRiseTime;
  private int sleepShallowTime;
  private long sleepStartTime;
  private int sleepWakeTime;
  private int stepActiveTime;
  private int stepCalorie;
  private int stepContinueTime;
  private int stepDistance;
  private int stepRunTime;
  private int stepWalkTime;
  private int steps;
  private int userSleepEnd;
  private int userSleepStart;

  public int getDayStepGoal()
  {
    return this.daySportGoal;
  }

  public int getSleep()
  {
    return this.sleep;
  }

  public int getSleepDeepTime()
  {
    return this.sleepDeepTime;
  }

  public long getSleepRiseTime()
  {
    return this.sleepRiseTime;
  }

  public int getSleepShallowTime()
  {
    return this.sleepShallowTime;
  }

  public long getSleepStartTime()
  {
    return this.sleepStartTime;
  }

  public int getSleepWakeTime()
  {
    return this.sleepWakeTime;
  }

  public int getStepActiveTime()
  {
    return this.stepActiveTime;
  }

  public int getStepCalorie()
  {
    return this.stepCalorie;
  }

  public int getStepContinueTime()
  {
    return this.stepContinueTime;
  }

  public int getStepDistance()
  {
    return this.stepDistance;
  }

  public int getStepRunTime()
  {
    return this.stepRunTime;
  }

  public int getStepWalkTime()
  {
    return this.stepWalkTime;
  }

  public int getSteps()
  {
    return this.steps;
  }

  public int getUserSleepEnd()
  {
    return this.userSleepEnd;
  }

  public int getUserSleepStart()
  {
    return this.userSleepStart;
  }

  public boolean isEmpty()
  {
    return false;
  }

  public void setDayStepGoal(int paramInt)
  {
    this.daySportGoal = paramInt;
  }

  public void setSleep(int paramInt)
  {
    this.sleep = paramInt;
  }

  public void setSleepDeepTime(int paramInt)
  {
    this.sleepDeepTime = paramInt;
  }

  public void setSleepRiseTime(long paramLong)
  {
    this.sleepRiseTime = paramLong;
  }

  public void setSleepShallowTime(int paramInt)
  {
    this.sleepShallowTime = paramInt;
  }

  public void setSleepStartTime(long paramLong)
  {
    this.sleepStartTime = paramLong;
  }

  public void setSleepWakeTime(int paramInt)
  {
    this.sleepWakeTime = paramInt;
  }

  public void setStepActiveTime(int paramInt)
  {
    this.stepActiveTime = paramInt;
  }

  public void setStepCalorie(int paramInt)
  {
    this.stepCalorie = paramInt;
  }

  public void setStepContinueTime(int paramInt)
  {
    this.stepContinueTime = paramInt;
  }

  public void setStepDistance(int paramInt)
  {
    this.stepDistance = paramInt;
  }

  public void setStepRunTime(int paramInt)
  {
    this.stepRunTime = paramInt;
  }

  public void setStepWalkTime(int paramInt)
  {
    this.stepWalkTime = paramInt;
  }

  public void setSteps(int paramInt)
  {
    this.steps = paramInt;
  }

  public void setUserSleepEnd(int paramInt)
  {
    this.userSleepEnd = paramInt;
  }

  public void setUserSleepStart(int paramInt)
  {
    this.userSleepStart = paramInt;
  }

  public String toString()
  {
    return "Steps: " + this.steps + " , Sleep : " + this.sleep;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.DaySportData.SummaryEntity
 * JD-Core Version:    0.6.2
 */