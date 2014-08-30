package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.auth.GalaxyCredentials;
import com.xiaomi.infra.galaxy.common.auth.Signer;
import com.xiaomi.infra.galaxy.common.model.GalaxyMarshaller;

public class ExecutionContext
{
  private String contextUserAgent;
  private GalaxyCredentials credentials;
  private GalaxyMarshaller marshaller;
  private Signer signer;

  public String getContextUserAgent()
  {
    return this.contextUserAgent;
  }

  public GalaxyCredentials getCredentials()
  {
    return this.credentials;
  }

  public GalaxyMarshaller getMarshaller()
  {
    return this.marshaller;
  }

  public Signer getSigner()
  {
    return this.signer;
  }

  public void setContextUserAgent(String paramString)
  {
    this.contextUserAgent = paramString;
  }

  public void setCredentials(GalaxyCredentials paramGalaxyCredentials)
  {
    this.credentials = paramGalaxyCredentials;
  }

  public void setMarshaller(GalaxyMarshaller paramGalaxyMarshaller)
  {
    this.marshaller = paramGalaxyMarshaller;
  }

  public void setSigner(Signer paramSigner)
  {
    this.signer = paramSigner;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.ExecutionContext
 * JD-Core Version:    0.6.2
 */