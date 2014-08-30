package cn.com.smartdevices.bracelet;

public class FriendsManager
{
  private static FriendsManager a = null;

  public static FriendsManager getInstance()
  {
    if (a == null)
      a = new FriendsManager();
    return a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.FriendsManager
 * JD-Core Version:    0.6.2
 */