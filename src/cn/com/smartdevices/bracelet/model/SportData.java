package cn.com.smartdevices.bracelet.model;

import java.io.Serializable;

public class SportData
  implements Serializable, Cloneable
{
  private static final long serialVersionUID = 1L;
  private int activity;
  private int mode;
  private int step;
  private int timeIndex = 0;

  public SportData(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mode = paramInt1;
    this.activity = paramInt2;
    this.step = paramInt3;
  }

  public SportData(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.timeIndex = paramInt1;
    this.mode = paramInt2;
    this.activity = paramInt3;
    this.step = paramInt4;
  }

  public SportData copy()
  {
    return (SportData)clone();
  }

  public int getActivity()
  {
    return this.activity;
  }

  public int getSportMode()
  {
    return this.mode;
  }

  public int getStep()
  {
    return this.step;
  }

  public int getTimeIndex()
  {
    return this.timeIndex;
  }

  public void setActivity(int paramInt)
  {
    this.activity = paramInt;
  }

  public void setMode(int paramInt)
  {
    this.mode = paramInt;
  }

  public void setStep(int paramInt)
  {
    this.step = paramInt;
  }

  public String toString()
  {
    return "<" + this.timeIndex + ":" + this.mode + ":" + this.activity + ":" + this.step + ">";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.SportData
 * JD-Core Version:    0.6.2
 */