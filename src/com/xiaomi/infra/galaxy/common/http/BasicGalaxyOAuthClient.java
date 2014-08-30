package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.SessionExpiredException;
import com.xiaomi.infra.galaxy.common.auth.AnonymousGalaxyCredentials;
import com.xiaomi.infra.galaxy.common.auth.Galaxy4Signer;
import com.xiaomi.infra.galaxy.common.auth.SessionCredentials;
import com.xiaomi.infra.galaxy.common.constants.APILevel;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.model.MiSatRequest;
import com.xiaomi.infra.galaxy.common.model.OAuthProvider;
import com.xiaomi.infra.galaxy.common.model.QQSatRequest;
import com.xiaomi.infra.galaxy.common.model.StorageAccessTokenRequest;
import com.xiaomi.infra.galaxy.common.model.StorageAccessTokenResult;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BasicGalaxyOAuthClient extends GalaxyClient
{
  private static final Log log = LogFactory.getLog(BasicGalaxyOAuthClient.class);
  private SessionCredentials sessionCredentials;
  private Galaxy4Signer signer;

  public BasicGalaxyOAuthClient(ClientConfiguration paramClientConfiguration, GalaxyServiceClient paramGalaxyServiceClient, GalaxyMarshaller paramGalaxyMarshaller)
  {
    super(paramClientConfiguration, paramGalaxyServiceClient, paramGalaxyMarshaller);
    this.sessionCredentials = new SessionCredentials(paramClientConfiguration.getAppId());
    this.signer = new Galaxy4Signer();
    this.signer.setServiceName("Galaxy");
    paramGalaxyServiceClient.setConfiguration(paramClientConfiguration);
  }

  public BasicGalaxyOAuthClient(GalaxyServiceClient paramGalaxyServiceClient, GalaxyMarshaller paramGalaxyMarshaller)
  {
  }

  public StorageAccessTokenResult getStorageAccessTokenResult()
  {
    if (this.sessionCredentials != null)
      return this.sessionCredentials.getStorageAccessTokenResult();
    return null;
  }

  public boolean getstorageAccessToken(StorageAccessTokenRequest paramStorageAccessTokenRequest)
  {
    while (true)
    {
      String str1;
      BasicGalaxyRequest localBasicGalaxyRequest;
      boolean bool;
      OAuthProvider localOAuthProvider;
      try
      {
        str1 = this.clientConfiguration.getAppId();
        try
        {
          if (StringUtils.isBlank(paramStorageAccessTokenRequest.getAppId()))
          {
            log.info("storage access token request's appId is null");
            paramStorageAccessTokenRequest.setAppId(str1);
            localBasicGalaxyRequest = paramStorageAccessTokenRequest.getGalaxyRequest(this.marshaller.marshall(paramStorageAccessTokenRequest), APILevel.User);
            localBasicGalaxyRequest.addParameter("appid", paramStorageAccessTokenRequest.getAppId());
            if (StringUtils.isBlank(paramStorageAccessTokenRequest.getAccessToken()))
            {
              log.error("storage access token request's access token is null");
              bool = false;
              return bool;
            }
          }
          else
          {
            this.clientConfiguration.setAppId(paramStorageAccessTokenRequest.getAppId());
            continue;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          log.error("get storage access token failed!", localException);
          this.clientConfiguration.setAppId(str1);
          bool = false;
          continue;
          localBasicGalaxyRequest.addParameter("accessToken", paramStorageAccessTokenRequest.getAccessToken());
          if (StringUtils.isBlank(paramStorageAccessTokenRequest.getOauthAppId()))
          {
            log.error("storage access token request's oauth appId is null");
            bool = false;
            continue;
          }
          localBasicGalaxyRequest.addParameter("oauth_appid", paramStorageAccessTokenRequest.getOauthAppId());
          if (paramStorageAccessTokenRequest.getOauthVersion() != null)
            break label281;
        }
        str2 = "";
        localBasicGalaxyRequest.addParameter("oauth_version", str2);
        localOAuthProvider = OAuthProvider.fromValue(paramStorageAccessTokenRequest.getOauthProvider());
        if (localOAuthProvider != OAuthProvider.QQ)
          break label352;
        if ((paramStorageAccessTokenRequest instanceof QQSatRequest))
          break label290;
        this.clientConfiguration.setAppId(str1);
        throw new GalaxyClientException(ReturnCode.OAUTH_ACCESSTOKEN_IS_INVALID, "should use " + QQSatRequest.class.getName() + " class with qq oauth ");
      }
      finally
      {
      }
      label281: String str2 = paramStorageAccessTokenRequest.getOauthVersion();
      continue;
      label290: localBasicGalaxyRequest.addParameter("oauth_qq_openid", ((QQSatRequest)paramStorageAccessTokenRequest).getOpenid());
      localBasicGalaxyRequest.addParameter("oauth_qq_oauth_type", ((QQSatRequest)paramStorageAccessTokenRequest).getOauthType());
      while (true)
      {
        if (!StringUtils.isBlank(paramStorageAccessTokenRequest.getOauthProvider()))
          break label442;
        this.clientConfiguration.setAppId(str1);
        log.error("storage access token request's oauth provider is null");
        bool = false;
        break;
        label352: if (localOAuthProvider == OAuthProvider.XiaoMi)
        {
          if (!(paramStorageAccessTokenRequest instanceof MiSatRequest))
          {
            this.clientConfiguration.setAppId(str1);
            throw new GalaxyClientException(ReturnCode.OAUTH_ACCESSTOKEN_IS_INVALID, "should use " + MiSatRequest.class.getName() + " class with xiaomi oauth ");
          }
          localBasicGalaxyRequest.addParameter("oauth_xiaomi_mackey", ((MiSatRequest)paramStorageAccessTokenRequest).getMacKey());
          localBasicGalaxyRequest.addParameter("oauht_xiaomi_mac_algorithm", ((MiSatRequest)paramStorageAccessTokenRequest).getMacAlgorithm());
        }
      }
      label442: localBasicGalaxyRequest.addParameter("oauth_provider", paramStorageAccessTokenRequest.getOauthProvider());
      localBasicGalaxyRequest.addHeader("X-XiaoMi-Appid", paramStorageAccessTokenRequest.getAppId());
      ExecutionContext localExecutionContext = new ExecutionContext();
      localExecutionContext.setSigner(this.signer);
      localExecutionContext.setCredentials(new AnonymousGalaxyCredentials(paramStorageAccessTokenRequest.getAppId()));
      localExecutionContext.setMarshaller(this.marshaller);
      StorageAccessTokenResult localStorageAccessTokenResult = (StorageAccessTokenResult)this.serviceClient.execute(localBasicGalaxyRequest, StorageAccessTokenResult.class, localExecutionContext);
      if (localStorageAccessTokenResult.getCode() != 1)
      {
        this.clientConfiguration.setAppId(str1);
        bool = false;
      }
      else
      {
        this.sessionCredentials.setStorageAccessTokenResult(localStorageAccessTokenResult);
        bool = true;
      }
    }
  }

  protected <X> X invoke(BasicGalaxyRequest paramBasicGalaxyRequest, Class<X> paramClass)
  {
    paramBasicGalaxyRequest.addHeader("X-XiaoMi-Appid", this.sessionCredentials.getGalaxyAppId());
    ExecutionContext localExecutionContext = new ExecutionContext();
    localExecutionContext.setSigner(this.signer);
    localExecutionContext.setMarshaller(this.marshaller);
    if (isLogin())
      localExecutionContext.setCredentials(this.sessionCredentials);
    while (true)
    {
      return this.serviceClient.execute(paramBasicGalaxyRequest, paramClass, localExecutionContext);
      localExecutionContext.setCredentials(new AnonymousGalaxyCredentials(this.clientConfiguration.getAppId()));
    }
  }

  public boolean isLogin()
  {
    if (this.sessionCredentials == null);
    while (true)
    {
      return false;
      try
      {
        String str = this.sessionCredentials.getGalaxySecretKey();
        if (!StringUtils.isBlank(str))
          return true;
      }
      catch (SessionExpiredException localSessionExpiredException)
      {
        logout();
      }
    }
    return false;
  }

  public void logout()
  {
    try
    {
      if (this.sessionCredentials != null)
        this.sessionCredentials.setStorageAccessTokenResult(null);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void setStorageAccessTokenResult(StorageAccessTokenResult paramStorageAccessTokenResult)
  {
    try
    {
      if (this.sessionCredentials != null)
        this.sessionCredentials.setStorageAccessTokenResult(paramStorageAccessTokenResult);
      while (true)
      {
        return;
        this.sessionCredentials = new SessionCredentials(this.clientConfiguration.getAppId());
      }
    }
    finally
    {
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.BasicGalaxyOAuthClient
 * JD-Core Version:    0.6.2
 */