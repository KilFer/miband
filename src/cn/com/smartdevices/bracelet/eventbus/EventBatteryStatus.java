package cn.com.smartdevices.bracelet.eventbus;

public class EventBatteryStatus
{
  public int level = 0;
  public byte status = 0;

  public EventBatteryStatus(byte paramByte, int paramInt)
  {
    this.status = paramByte;
    this.level = paramInt;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.eventbus.EventBatteryStatus
 * JD-Core Version:    0.6.2
 */