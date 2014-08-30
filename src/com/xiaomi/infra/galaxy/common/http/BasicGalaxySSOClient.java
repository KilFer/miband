package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.auth.BasicGalaxyCredentials;
import com.xiaomi.infra.galaxy.common.auth.MiSSOSigner;
import com.xiaomi.infra.galaxy.common.auth.MiSSOToken;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

public class BasicGalaxySSOClient extends GalaxyClient
{
  private MiSSOSigner miSSOSigner = MiSSOSigner.getInstance();
  private MiSSOToken ssoToken;

  public BasicGalaxySSOClient(ClientConfiguration paramClientConfiguration, GalaxyServiceClient paramGalaxyServiceClient, GalaxyMarshaller paramGalaxyMarshaller)
  {
    super(paramClientConfiguration, paramGalaxyServiceClient, paramGalaxyMarshaller);
  }

  public BasicGalaxySSOClient(GalaxyServiceClient paramGalaxyServiceClient, GalaxyMarshaller paramGalaxyMarshaller)
  {
  }

  protected <X> X invoke(BasicGalaxyRequest paramBasicGalaxyRequest, Class<X> paramClass)
  {
    paramBasicGalaxyRequest.addHeader("X-XiaoMi-Appid", this.clientConfiguration.getAppId());
    ExecutionContext localExecutionContext = new ExecutionContext();
    localExecutionContext.setMarshaller(this.marshaller);
    if ((this.ssoToken == null) || (StringUtils.isBlank(this.ssoToken.getUserId())) || (StringUtils.isBlank(this.ssoToken.getServiceToken())))
      paramBasicGalaxyRequest.addHeader("X-XiaoMi-Access-Method", "anonymous");
    while (true)
    {
      return this.serviceClient.execute(paramBasicGalaxyRequest, paramClass, localExecutionContext);
      BasicGalaxyCredentials localBasicGalaxyCredentials = new BasicGalaxyCredentials("", this.ssoToken.getSecurity());
      localExecutionContext.setSigner(this.miSSOSigner);
      localExecutionContext.setCredentials(localBasicGalaxyCredentials);
      paramBasicGalaxyRequest.addHeader("X-XiaoMi-Access-Method", "misso");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("userId=").append(this.ssoToken.getUserId()).append("; ");
      localStringBuilder.append("serviceToken=").append(this.ssoToken.getServiceToken());
      paramBasicGalaxyRequest.addHeader("Cookie", localStringBuilder.toString());
    }
  }

  public void setSSOToken(MiSSOToken paramMiSSOToken)
  {
    this.ssoToken = paramMiSSOToken;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.BasicGalaxySSOClient
 * JD-Core Version:    0.6.2
 */