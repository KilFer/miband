package cn.com.smartdevices.bracelet.model;

public class LoginData
{
  public String security = null;
  public long uid = -1L;

  public boolean isValid()
  {
    return (this.uid != -1L) && (this.security != null);
  }

  public String toString()
  {
    return "LoginData: uid:" + this.uid + ", security:" + this.security;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.model.LoginData
 * JD-Core Version:    0.6.2
 */