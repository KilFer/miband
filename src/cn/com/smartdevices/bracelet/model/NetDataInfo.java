package cn.com.smartdevices.bracelet.model;

public class NetDataInfo
{
  public static final int DATA_HAVE = 2;
  public static final int DATA_NONE = 1;
  public static final int DATA_UNKNOW;
  public int dataState = 0;
  public String startDate = null;
  public String stopDate = null;

  public boolean hasData()
  {
    return this.dataState == 2;
  }

  public boolean isUnknow()
  {
    return this.dataState == 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.NetDataInfo
 * JD-Core Version:    0.6.2
 */