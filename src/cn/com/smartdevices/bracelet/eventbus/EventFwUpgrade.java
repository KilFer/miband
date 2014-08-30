package cn.com.smartdevices.bracelet.eventbus;

public class EventFwUpgrade
{
  public static final int FW_TYPE_PROGRESS = 1;
  public static final int FW_TYPE_START = 0;
  public static final int FW_TYPE_STOP = 2;
  private Object data = null;
  private int type = 0;

  public EventFwUpgrade(int paramInt, Object paramObject)
  {
    this.type = paramInt;
    this.data = paramObject;
  }

  public Object data()
  {
    return this.data;
  }

  public int type()
  {
    return this.type;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.eventbus.EventFwUpgrade
 * JD-Core Version:    0.6.2
 */