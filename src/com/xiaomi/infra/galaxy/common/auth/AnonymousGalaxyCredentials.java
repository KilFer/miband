package com.xiaomi.infra.galaxy.common.auth;

public class AnonymousGalaxyCredentials
  implements GalaxyCredentials
{
  private String galaxyAppId;

  public AnonymousGalaxyCredentials(String paramString)
  {
    this.galaxyAppId = paramString;
  }

  public String getGalaxyAppId()
  {
    return this.galaxyAppId;
  }

  public String getGalaxySecretKey()
  {
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.AnonymousGalaxyCredentials
 * JD-Core Version:    0.6.2
 */