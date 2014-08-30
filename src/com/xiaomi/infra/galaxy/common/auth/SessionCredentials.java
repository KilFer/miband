package com.xiaomi.infra.galaxy.common.auth;

import com.xiaomi.infra.galaxy.common.SessionExpiredException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.StorageAccessTokenResult;

public class SessionCredentials
  implements GalaxyCredentials
{
  private final String appId;
  private StorageAccessTokenResult storageAccessTokenResult;

  public SessionCredentials(String paramString)
  {
    if (paramString == null)
      throw new IllegalArgumentException("appId cannot be null.");
    this.appId = paramString;
  }

  public String getGalaxyAppId()
  {
    return this.appId;
  }

  public String getGalaxySecretKey()
  {
    if (this.storageAccessTokenResult == null)
      return "";
    if (System.currentTimeMillis() >= this.storageAccessTokenResult.getExpiresIn())
      throw new SessionExpiredException(ReturnCode.STORAGEACCESS_TOKEN_IS_EXPIRED, "storage access token is expired, you should get a new one from galaxy server");
    return this.storageAccessTokenResult.getStorageAccessToken();
  }

  public StorageAccessTokenResult getStorageAccessTokenResult()
  {
    return this.storageAccessTokenResult;
  }

  public void setStorageAccessTokenResult(StorageAccessTokenResult paramStorageAccessTokenResult)
  {
    this.storageAccessTokenResult = paramStorageAccessTokenResult;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.auth.SessionCredentials
 * JD-Core Version:    0.6.2
 */