package com.xiaomi.infra.galaxy.common.auth;

public class MiSSOToken
{
  private String security;
  private String serviceToken;
  private String userId;

  public MiSSOToken(String paramString1, String paramString2, String paramString3)
  {
    this.userId = paramString1;
    this.serviceToken = paramString2;
    this.security = paramString3;
  }

  public String getSecurity()
  {
    return this.security;
  }

  public String getServiceToken()
  {
    return this.serviceToken;
  }

  public String getUserId()
  {
    return this.userId;
  }

  public void setSecurity(String paramString)
  {
    this.security = paramString;
  }

  public void setServiceToken(String paramString)
  {
    this.serviceToken = paramString;
  }

  public void setUserId(String paramString)
  {
    this.userId = paramString;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.MiSSOToken
 * JD-Core Version:    0.6.2
 */