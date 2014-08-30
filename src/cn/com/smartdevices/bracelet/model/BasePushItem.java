package cn.com.smartdevices.bracelet.model;

public abstract class BasePushItem
{
  public static final int PUSH_TYPE_DATA = 1;
  public static final int PUSH_TYPE_SYSTEM = 2;
  public static final int PUSH_TYPE_USER;
  public boolean hasRead = false;
  public int pushType = 0;

  public BasePushItem(int paramInt)
  {
    this.pushType = paramInt;
  }

  public abstract String getContent();

  public int getType()
  {
    return this.pushType;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.BasePushItem
 * JD-Core Version:    0.6.2
 */