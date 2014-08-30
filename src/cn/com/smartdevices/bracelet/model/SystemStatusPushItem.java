package cn.com.smartdevices.bracelet.model;

public class SystemStatusPushItem extends BasePushItem
{
  public MicroBlogItem item = new MicroBlogItem();

  public SystemStatusPushItem()
  {
    super(2);
  }

  public String getContent()
  {
    return this.item.shareContent.message;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.SystemStatusPushItem
 * JD-Core Version:    0.6.2
 */