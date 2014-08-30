package com.xiaomi.infra.galaxy.common.model;

public class QQSatRequest extends StorageAccessTokenRequest
{
  public static final String OAUTHTYPE_OPEN = "open";
  public static final String OAUTHTYPE_WEIBO = "weibo";
  private String oauthType;
  private String openid;

  public QQSatRequest()
  {
    setOauthProvider(null);
  }

  public String getOauthType()
  {
    return this.oauthType;
  }

  public String getOpenid()
  {
    return this.openid;
  }

  public void setOauthProvider(String paramString)
  {
    super.setOauthProvider(OAuthProvider.QQ.name());
  }

  public void setOauthType(String paramString)
  {
    this.oauthType = paramString;
  }

  public void setOpenid(String paramString)
  {
    this.openid = paramString;
  }

  public StorageAccessTokenRequest withOauthProvider(OAuthProvider paramOAuthProvider)
  {
    setOauthProvider(OAuthProvider.QQ.name());
    return this;
  }

  public QQSatRequest withOauthType(String paramString)
  {
    setOauthType(paramString);
    return this;
  }

  public QQSatRequest withOpenid(String paramString)
  {
    setOpenid(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.QQSatRequest
 * JD-Core Version:    0.6.2
 */