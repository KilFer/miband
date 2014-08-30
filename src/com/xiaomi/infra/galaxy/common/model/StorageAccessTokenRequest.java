package com.xiaomi.infra.galaxy.common.model;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.TargetAction;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.Operation;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

public class StorageAccessTokenRequest extends Request
{
  private String accessToken;
  private String appId;
  private String oauthAppId;
  private String oauthProvider;
  private String oauthVersion;

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    StorageAccessTokenRequest localStorageAccessTokenRequest;
    int i;
    label43: int j;
    label53: int m;
    label107: int n;
    label117: int i2;
    label171: int i3;
    label181: int i5;
    label235: int i6;
    label245: boolean bool4;
    do
    {
      int i7;
      do
      {
        boolean bool5;
        do
        {
          int i4;
          do
          {
            boolean bool6;
            do
            {
              int i1;
              do
              {
                boolean bool7;
                do
                {
                  int k;
                  do
                  {
                    boolean bool2;
                    do
                    {
                      do
                      {
                        return bool1;
                        bool1 = false;
                      }
                      while (paramObject == null);
                      bool2 = paramObject instanceof StorageAccessTokenRequest;
                      bool1 = false;
                    }
                    while (!bool2);
                    localStorageAccessTokenRequest = (StorageAccessTokenRequest)paramObject;
                    if (localStorageAccessTokenRequest.getAppId() != null)
                      break;
                    i = 1;
                    if (getAppId() != null)
                      break label360;
                    j = 1;
                    k = i ^ j;
                    bool1 = false;
                  }
                  while (k != 0);
                  if (localStorageAccessTokenRequest.getAppId() == null)
                    break;
                  bool7 = localStorageAccessTokenRequest.getAppId().equals(getAppId());
                  bool1 = false;
                }
                while (!bool7);
                if (localStorageAccessTokenRequest.getOauthAppId() != null)
                  break label366;
                m = 1;
                if (getOauthAppId() != null)
                  break label372;
                n = 1;
                i1 = m ^ n;
                bool1 = false;
              }
              while (i1 != 0);
              if (localStorageAccessTokenRequest.getOauthAppId() == null)
                break;
              bool6 = localStorageAccessTokenRequest.getOauthAppId().equals(getOauthAppId());
              bool1 = false;
            }
            while (!bool6);
            if (localStorageAccessTokenRequest.getAccessToken() != null)
              break label378;
            i2 = 1;
            if (getAccessToken() != null)
              break label384;
            i3 = 1;
            i4 = i2 ^ i3;
            bool1 = false;
          }
          while (i4 != 0);
          if (localStorageAccessTokenRequest.getAccessToken() == null)
            break;
          bool5 = localStorageAccessTokenRequest.getAccessToken().equals(getAccessToken());
          bool1 = false;
        }
        while (!bool5);
        if (localStorageAccessTokenRequest.getOauthProvider() != null)
          break label390;
        i5 = 1;
        if (getOauthProvider() != null)
          break label396;
        i6 = 1;
        i7 = i5 ^ i6;
        bool1 = false;
      }
      while (i7 != 0);
      if (localStorageAccessTokenRequest.getOauthProvider() == null)
        break;
      bool4 = localStorageAccessTokenRequest.getOauthProvider().equals(getOauthProvider());
      bool1 = false;
    }
    while (!bool4);
    int i8;
    if (localStorageAccessTokenRequest.getOauthVersion() == null)
    {
      i8 = 1;
      label299: if (getOauthVersion() != null)
        break label408;
    }
    label384: label390: label396: label408: for (int i9 = 1; ; i9 = 0)
    {
      int i10 = i8 ^ i9;
      bool1 = false;
      if (i10 != 0)
        break;
      if (localStorageAccessTokenRequest.getOauthVersion() != null)
      {
        boolean bool3 = localStorageAccessTokenRequest.getOauthVersion().equals(getOauthVersion());
        bool1 = false;
        if (!bool3)
          break;
      }
      return true;
      i = 0;
      break label43;
      label360: j = 0;
      break label53;
      label366: m = 0;
      break label107;
      label372: n = 0;
      break label117;
      label378: i2 = 0;
      break label171;
      i3 = 0;
      break label181;
      i5 = 0;
      break label235;
      i6 = 0;
      break label245;
      i8 = 0;
      break label299;
    }
  }

  public String getAccessToken()
  {
    return this.accessToken;
  }

  public String getAppId()
  {
    return this.appId;
  }

  public String getOauthAppId()
  {
    return this.oauthAppId;
  }

  public String getOauthProvider()
  {
    return this.oauthProvider;
  }

  public String getOauthVersion()
  {
    return this.oauthVersion;
  }

  public int hashCode()
  {
    int i;
    int k;
    label26: int n;
    label44: int i2;
    label64: int i3;
    int i4;
    if (getAppId() == null)
    {
      i = 0;
      int j = 31 * (i + 31);
      if (getOauthAppId() != null)
        break label105;
      k = 0;
      int m = 31 * (k + j);
      if (getAccessToken() != null)
        break label116;
      n = 0;
      int i1 = 31 * (n + m);
      if (getOauthProvider() != null)
        break label128;
      i2 = 0;
      i3 = 31 * (i2 + i1);
      String str = getOauthVersion();
      i4 = 0;
      if (str != null)
        break label140;
    }
    while (true)
    {
      return i3 + i4;
      i = getAppId().hashCode();
      break;
      label105: k = getOauthAppId().hashCode();
      break label26;
      label116: n = getAccessToken().hashCode();
      break label44;
      label128: i2 = getOauthProvider().hashCode();
      break label64;
      label140: i4 = getOauthVersion().hashCode();
    }
  }

  public BasicGalaxyRequest internalGetGalaxyRequest(String paramString, APILevel paramAPILevel)
  {
    BasicGalaxyRequest localBasicGalaxyRequest = new BasicGalaxyRequest(this, "Galaxy");
    TargetAction localTargetAction = new TargetAction();
    localTargetAction.setApiVersion(GalaxyVersion.getVersion());
    localTargetAction.setLevel(APILevel.User);
    localTargetAction.setOperation(Operation.Auth);
    localTargetAction.setServiceName("Galaxy");
    localBasicGalaxyRequest.addHeader("X-XiaoMi-Action", localTargetAction.format());
    super.setRequestContent(localBasicGalaxyRequest, paramString);
    return localBasicGalaxyRequest;
  }

  public void setAccessToken(String paramString)
  {
    this.accessToken = paramString;
  }

  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }

  public void setOauthAppId(String paramString)
  {
    this.oauthAppId = paramString;
  }

  public void setOauthProvider(String paramString)
  {
    this.oauthProvider = paramString;
  }

  public void setOauthVersion(String paramString)
  {
    this.oauthVersion = paramString;
  }

  public void validate()
  {
    StringUtils.isBlank(this.appId);
    StringUtils.isBlank(this.oauthAppId);
    StringUtils.isBlank(this.accessToken);
    StringUtils.isBlank(this.oauthProvider);
    StringUtils.isBlank(this.oauthVersion);
  }

  public StorageAccessTokenRequest withAccessToken(String paramString)
  {
    setAccessToken(paramString);
    return this;
  }

  public StorageAccessTokenRequest withAppId(String paramString)
  {
    setAppId(paramString);
    return this;
  }

  public StorageAccessTokenRequest withOauthAppId(String paramString)
  {
    setOauthAppId(paramString);
    return this;
  }

  public StorageAccessTokenRequest withOauthProvider(OAuthProvider paramOAuthProvider)
  {
    setOauthProvider(paramOAuthProvider.name());
    return this;
  }

  public StorageAccessTokenRequest withOauthVersion(String paramString)
  {
    setOauthVersion(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.StorageAccessTokenRequest
 * JD-Core Version:    0.6.2
 */