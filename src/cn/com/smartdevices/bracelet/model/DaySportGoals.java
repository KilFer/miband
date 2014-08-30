package cn.com.smartdevices.bracelet.model;

public class DaySportGoals
{
  public int goalSleepTime = -1;
  public int goalStepsCount = -1;

  public int getGoalStepsCount()
  {
    return this.goalStepsCount;
  }

  public boolean isValid()
  {
    return this.goalStepsCount > 0;
  }

  public String toString()
  {
    return "Day sport goal: goalStep" + this.goalStepsCount + ", goalTime:" + this.goalSleepTime;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.DaySportGoals
 * JD-Core Version:    0.6.2
 */