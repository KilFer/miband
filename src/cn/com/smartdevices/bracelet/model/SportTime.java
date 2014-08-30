package cn.com.smartdevices.bracelet.model;

public class SportTime
{
  int day;
  int hour;
  int min;
  int mon;
  int year;

  public SportTime(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.year = paramInt1;
    this.mon = paramInt2;
    this.day = paramInt3;
    this.hour = paramInt4;
    this.min = paramInt5;
  }

  public String toString()
  {
    return "20" + this.year + "年" + this.mon + "月" + this.day + "日" + this.hour + "时" + this.min + "分";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.SportTime
 * JD-Core Version:    0.6.2
 */