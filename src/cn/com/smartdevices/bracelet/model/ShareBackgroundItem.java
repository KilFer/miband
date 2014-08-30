package cn.com.smartdevices.bracelet.model;

public class ShareBackgroundItem
{
  public String reachedBgUrl = "";
  public String unReachedBgUrl = "";

  public boolean equals(Object paramObject)
  {
    ShareBackgroundItem localShareBackgroundItem = (ShareBackgroundItem)paramObject;
    return (localShareBackgroundItem.reachedBgUrl.equalsIgnoreCase(this.reachedBgUrl)) && (localShareBackgroundItem.unReachedBgUrl.equalsIgnoreCase(this.unReachedBgUrl));
  }

  public boolean isValid()
  {
    return (this.reachedBgUrl != null) && (this.reachedBgUrl.length() > 0) && (this.reachedBgUrl.startsWith("http://")) && (this.unReachedBgUrl != null) && (this.unReachedBgUrl.length() > 0) && (this.unReachedBgUrl.startsWith("http://"));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.ShareBackgroundItem
 * JD-Core Version:    0.6.2
 */