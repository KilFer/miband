package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.Protocol;
import java.net.URI;
import java.net.URISyntaxException;

public abstract class GalaxyServiceClient
{
  protected GalaxyHttpClient client;
  protected ClientConfiguration clientConfiguration;
  protected URI endpoint;

  public GalaxyServiceClient(ClientConfiguration paramClientConfiguration, AbstractHttpClientFactory paramAbstractHttpClientFactory)
  {
    this.clientConfiguration = paramClientConfiguration;
    GalaxyHttpClient.setHttpClientFactory(paramAbstractHttpClientFactory);
    this.client = new GalaxyHttpClient(paramClientConfiguration);
  }

  public <T> T execute(BasicGalaxyRequest paramBasicGalaxyRequest, Class<T> paramClass, ExecutionContext paramExecutionContext)
  {
    paramBasicGalaxyRequest.setEndpoint(this.endpoint);
    return this.client.execute(paramBasicGalaxyRequest, paramClass, paramExecutionContext);
  }

  public ClientConfiguration getConfiguration()
  {
    return this.clientConfiguration;
  }

  public URI getEndpoint()
  {
    return this.endpoint;
  }

  public void setConfiguration(ClientConfiguration paramClientConfiguration)
  {
    this.clientConfiguration = paramClientConfiguration;
    this.client = new GalaxyHttpClient(paramClientConfiguration);
  }

  public void setEndpoint(String paramString)
  {
    if (!paramString.contains("://"))
      paramString = this.clientConfiguration.getProtocol().toString() + "://" + paramString;
    try
    {
      this.endpoint = new URI(paramString);
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalArgumentException(localURISyntaxException);
    }
  }

  public abstract void shutdown();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.GalaxyServiceClient
 * JD-Core Version:    0.6.2
 */