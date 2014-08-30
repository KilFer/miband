package cn.com.smartdevices.bracelet.model;

public class DayStepRecord
{
  public String date = "";
  public int steps = -1;

  public boolean isValid()
  {
    return (this.steps != -1) && (this.date != null) && (this.date.length() > 0);
  }

  public String toString()
  {
    if (!isValid())
      return "no day step record!";
    return this.date + ":" + this.steps;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.DayStepRecord
 * JD-Core Version:    0.6.2
 */