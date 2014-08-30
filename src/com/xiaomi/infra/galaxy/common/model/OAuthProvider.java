package com.xiaomi.infra.galaxy.common.model;

public enum OAuthProvider
{
  private String value;

  static
  {
    Sina = new OAuthProvider("Sina", 1, "Sina");
    QQ = new OAuthProvider("QQ", 2, "QQ");
    Renren = new OAuthProvider("Renren", 3, "Renren");
    ServerAuth = new OAuthProvider("ServerAuth", 4, "ServerAuth");
    OAuthProvider[] arrayOfOAuthProvider = new OAuthProvider[5];
    arrayOfOAuthProvider[0] = XiaoMi;
    arrayOfOAuthProvider[1] = Sina;
    arrayOfOAuthProvider[2] = QQ;
    arrayOfOAuthProvider[3] = Renren;
    arrayOfOAuthProvider[4] = ServerAuth;
  }

  private OAuthProvider(String paramString)
  {
    this.value = paramString;
  }

  public static OAuthProvider fromValue(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString)))
      throw new IllegalArgumentException("Value cannot be null or empty!");
    if ("XiaoMi".equals(paramString))
      return XiaoMi;
    if ("Sina".equals(paramString))
      return Sina;
    if ("QQ".equals(paramString))
      return QQ;
    if ("Renren".equals(paramString))
      return Renren;
    if ("ServerAuth".equals(paramString))
      return ServerAuth;
    throw new IllegalArgumentException("Cannot create enum from " + paramString + " value!");
  }

  public final String toString()
  {
    return this.value;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.OAuthProvider
 * JD-Core Version:    0.6.2
 */