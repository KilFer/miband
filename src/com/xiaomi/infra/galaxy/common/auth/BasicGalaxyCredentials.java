package com.xiaomi.infra.galaxy.common.auth;

public class BasicGalaxyCredentials
  implements GalaxyCredentials
{
  private final String appId;
  private final String secretKey;

  public BasicGalaxyCredentials(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("appId cannot be null.");
    if (paramString2 == null)
      throw new IllegalArgumentException("Secret key cannot be null.");
    this.appId = paramString1;
    this.secretKey = paramString2;
  }

  public String getGalaxyAppId()
  {
    return this.appId;
  }

  public String getGalaxySecretKey()
  {
    return this.secretKey;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.BasicGalaxyCredentials
 * JD-Core Version:    0.6.2
 */