package com.xiaomi.infra.galaxy.android;

import com.xiaomi.infra.galaxy.android.http.HttpAndroidClientFactory;
import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.constants.ReturnCode;
import com.xiaomi.infra.galaxy.common.http.ClientConfiguration;
import com.xiaomi.infra.galaxy.common.http.GalaxyHttpClient;
import com.xiaomi.infra.galaxy.common.http.GalaxyServiceClient;
import com.xiaomi.infra.galaxy.common.util.StringUtils;

class GalaxyServiceProxy extends GalaxyServiceClient
{
  public GalaxyServiceProxy(ClientConfiguration paramClientConfiguration)
  {
    super(paramClientConfiguration, new HttpAndroidClientFactory());
    if (StringUtils.isBlank(paramClientConfiguration.getAppId()))
      throw new GalaxyClientException(ReturnCode.APP_ID_IS_BLANK, "galaxy appId is empty");
    if (paramClientConfiguration.getMaxErrorRetry() > 3)
      paramClientConfiguration.setMaxErrorRetry(3);
    setEndpoint(paramClientConfiguration.getEndpoint());
  }

  public void setConfiguration(ClientConfiguration paramClientConfiguration)
  {
    this.clientConfiguration = paramClientConfiguration;
    this.client = new GalaxyHttpClient(paramClientConfiguration);
  }

  public void shutdown()
  {
    if (this.client.getKeepAliveHttpClient() != null)
      this.client.shutdown();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.android.GalaxyServiceProxy
 * JD-Core Version:    0.6.2
 */