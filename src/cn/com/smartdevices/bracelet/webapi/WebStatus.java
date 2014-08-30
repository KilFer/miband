package cn.com.smartdevices.bracelet.webapi;

public class WebStatus
{
  public static final int CODE_AUTH_INVALID = 0;
  public static final int CODE_LIKED = 666;
  public static final int CODE_NONE = -1;
  public static final int CODE_OK = 1;
  public static final int CODE_PARSE_FAILED = 2;
  public int code = -1;
  public String message = "";

  public boolean equals(Object paramObject)
  {
    return ((WebStatus)paramObject).code == this.code;
  }

  public boolean isAuthInvalid()
  {
    return this.code == 0;
  }

  public boolean success()
  {
    return this.code == 1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.webapi.WebStatus
 * JD-Core Version:    0.6.2
 */