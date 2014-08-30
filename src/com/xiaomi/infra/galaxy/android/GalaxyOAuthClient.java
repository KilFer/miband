package com.xiaomi.infra.galaxy.android;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.http.BasicGalaxyOAuthClient;
import com.xiaomi.infra.galaxy.common.http.ClientConfiguration;
import com.xiaomi.infra.galaxy.common.model.GSonMarshaller;

public final class GalaxyOAuthClient extends BasicGalaxyOAuthClient
{
  public GalaxyOAuthClient(ClientConfiguration paramClientConfiguration)
  {
    super(paramClientConfiguration, new GalaxyServiceProxy(paramClientConfiguration), GSonMarshaller.getInstance());
  }

  private GalaxyOAuthClient(String paramString)
  {
    super(new GalaxyServiceProxy(new ClientConfiguration(false).withAppId(paramString)), GSonMarshaller.getInstance());
  }

  public static GalaxyOAuthClient createInstance(String paramString)
  {
    try
    {
      GalaxyOAuthClient localGalaxyOAuthClient = new GalaxyOAuthClient(paramString);
      return localGalaxyOAuthClient;
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.android.GalaxyOAuthClient
 * JD-Core Version:    0.6.2
 */