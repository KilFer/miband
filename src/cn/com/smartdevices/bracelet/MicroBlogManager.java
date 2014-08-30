package cn.com.smartdevices.bracelet;

public class MicroBlogManager extends BaseMicroBlogManager
{
  private static MicroBlogManager a = null;

  public static MicroBlogManager getInstance()
  {
    if (a == null)
      a = new MicroBlogManager();
    return a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.MicroBlogManager
 * JD-Core Version:    0.6.2
 */