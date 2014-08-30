package cn.com.smartdevices.bracelet.analysis;

public class ActiveItem
{
  public static final int MODE_ACTIVE = 0;
  public static final int MODE_RUN = 2;
  public static final int MODE_WALK = 1;
  public int activeTime = 0;
  public int calories = 0;
  public String dateString = null;
  public int distance = 0;
  public int flag = 0;
  public int mode = 0;
  public int runtime = 0;
  public int start = 0;
  public int steps = 0;
  public int stop = 0;

  public int getActiveTime()
  {
    return this.activeTime;
  }

  public int getCalories()
  {
    return this.calories;
  }

  public String getDateString()
  {
    return this.dateString;
  }

  public int getDistance()
  {
    return this.distance;
  }

  public int getMode()
  {
    return this.mode;
  }

  public int getRuntime()
  {
    return this.runtime;
  }

  public int getStart()
  {
    return this.start;
  }

  public int getSteps()
  {
    return this.steps;
  }

  public int getStop()
  {
    return this.stop;
  }

  public void setActiveTime(int paramInt)
  {
    this.activeTime = paramInt;
  }

  public void setCalories(int paramInt)
  {
    this.calories = paramInt;
  }

  public void setDateString(String paramString)
  {
    this.dateString = paramString;
  }

  public void setDistance(int paramInt)
  {
    this.distance = paramInt;
  }

  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }

  public void setRuntime(int paramInt)
  {
    this.runtime = paramInt;
  }

  public void setStart(int paramInt)
  {
    this.start = paramInt;
  }

  public void setSteps(int paramInt)
  {
    this.steps = paramInt;
  }

  public void setStop(int paramInt)
  {
    this.stop = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.analysis.ActiveItem
 * JD-Core Version:    0.6.2
 */