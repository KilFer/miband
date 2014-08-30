package cn.com.smartdevices.bracelet.eventbus;

public class EventPersonInfoUpdate
{
  public static final String UPDATE_AVATAR = "update_avatar";
  public String type;

  public EventPersonInfoUpdate()
  {
  }

  public EventPersonInfoUpdate(String paramString)
  {
    this.type = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.eventbus.EventPersonInfoUpdate
 * JD-Core Version:    0.6.2
 */