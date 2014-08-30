package com.xiaomi.infra.galaxy.common.auth;

public class AppSecretCredentials
  implements GalaxyCredentials
{
  private final String appId;
  private final String secretToken;

  public AppSecretCredentials(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("appId cannot be null.");
    if (paramString2 == null)
      throw new IllegalArgumentException("Secret token cannot be null.");
    this.appId = paramString1;
    this.secretToken = paramString2;
  }

  public String getGalaxyAppId()
  {
    return this.appId;
  }

  public String getGalaxySecretKey()
  {
    return this.secretToken;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.AppSecretCredentials
 * JD-Core Version:    0.6.2
 */