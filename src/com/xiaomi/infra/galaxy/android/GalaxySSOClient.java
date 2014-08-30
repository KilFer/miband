package com.xiaomi.infra.galaxy.android;

import com.xiaomi.infra.galaxy.common.GalaxyClientException;
import com.xiaomi.infra.galaxy.common.http.BasicGalaxySSOClient;
import com.xiaomi.infra.galaxy.common.http.ClientConfiguration;
import com.xiaomi.infra.galaxy.common.model.GSonMarshaller;

public final class GalaxySSOClient extends BasicGalaxySSOClient
{
  public GalaxySSOClient(ClientConfiguration paramClientConfiguration)
  {
    super(paramClientConfiguration, new GalaxyServiceProxy(paramClientConfiguration), GSonMarshaller.getInstance());
  }

  private GalaxySSOClient(String paramString)
  {
    super(new GalaxyServiceProxy(new ClientConfiguration(false).withAppId(paramString)), GSonMarshaller.getInstance());
  }

  public static GalaxySSOClient createInstance(String paramString)
  {
    try
    {
      GalaxySSOClient localGalaxySSOClient = new GalaxySSOClient(paramString);
      return localGalaxySSOClient;
    }
    catch (GalaxyClientException localGalaxyClientException)
    {
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.android.GalaxySSOClient
 * JD-Core Version:    0.6.2
 */