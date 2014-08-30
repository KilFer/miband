package com.xiaomi.infra.galaxy.common.model;

public class MiSatRequest extends StorageAccessTokenRequest
{
  private String macAlgorithm;
  private String macKey;

  public MiSatRequest()
  {
    setOauthProvider(null);
  }

  public String getMacAlgorithm()
  {
    return this.macAlgorithm;
  }

  public String getMacKey()
  {
    return this.macKey;
  }

  public void setMacAlgorithm(String paramString)
  {
    this.macAlgorithm = paramString;
  }

  public void setMacKey(String paramString)
  {
    this.macKey = paramString;
  }

  public void setOauthProvider(String paramString)
  {
    super.setOauthProvider(OAuthProvider.XiaoMi.name());
  }

  public MiSatRequest withMacAlgorithm(String paramString)
  {
    setMacAlgorithm(paramString);
    return this;
  }

  public MiSatRequest withMacKey(String paramString)
  {
    setMacKey(paramString);
    return this;
  }

  public StorageAccessTokenRequest withOauthProvider(OAuthProvider paramOAuthProvider)
  {
    setOauthProvider(OAuthProvider.XiaoMi.name());
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.MiSatRequest
 * JD-Core Version:    0.6.2
 */