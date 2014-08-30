package com.xiaomi.infra.galaxy.common.http;

import com.xiaomi.infra.galaxy.common.GalaxyVersion;
import com.xiaomi.infra.galaxy.common.Protocol;
import com.xiaomi.infra.galaxy.common.util.StringUtils;
import java.io.InputStream;

public class ClientConfiguration
{
  public static final int DEFAULT_MAX_CONNECTIONS = 50;
  public static final int DEFAULT_MAX_RETRIES = 3;
  public static final int DEFAULT_SOCKET_TIMEOUT = 50000;
  public static final String DEFAULT_USER_AGENT = GalaxyVersion.getUserAgent();
  private String appId;
  private int connectionTimeout = 50000;
  private String endpoint = "https://sds.api.xiaomi.com";
  private final boolean keepAlive;
  private int maxConnections = 50;
  private int maxErrorRetry = 3;
  private Protocol protocol = Protocol.HTTPS;
  private String proxyDomain = null;
  private String proxyHost = null;
  private String proxyPassword = null;
  private int proxyPort = -1;
  private String proxyUsername = null;
  private String proxyWorkstation = null;
  private int socketReceiveBufferSizeHint = 0;
  private int socketSendBufferSizeHint = 0;
  private int socketTimeout = 50000;
  private InputStream trustStore;
  private String trustStorePassword;
  private String userAgent = DEFAULT_USER_AGENT;

  public ClientConfiguration(ClientConfiguration paramClientConfiguration, boolean paramBoolean)
  {
    this.connectionTimeout = paramClientConfiguration.connectionTimeout;
    this.maxConnections = paramClientConfiguration.maxConnections;
    this.maxErrorRetry = paramClientConfiguration.maxErrorRetry;
    this.protocol = paramClientConfiguration.protocol;
    this.proxyDomain = paramClientConfiguration.proxyDomain;
    this.proxyHost = paramClientConfiguration.proxyHost;
    this.proxyPassword = paramClientConfiguration.proxyPassword;
    this.proxyPort = paramClientConfiguration.proxyPort;
    this.proxyUsername = paramClientConfiguration.proxyUsername;
    this.proxyWorkstation = paramClientConfiguration.proxyWorkstation;
    this.socketTimeout = paramClientConfiguration.socketTimeout;
    this.userAgent = paramClientConfiguration.userAgent;
    this.socketReceiveBufferSizeHint = paramClientConfiguration.socketReceiveBufferSizeHint;
    this.socketSendBufferSizeHint = paramClientConfiguration.socketSendBufferSizeHint;
    this.appId = paramClientConfiguration.appId;
    this.trustStore = paramClientConfiguration.trustStore;
    this.trustStorePassword = paramClientConfiguration.trustStorePassword;
    this.endpoint = paramClientConfiguration.endpoint;
    this.keepAlive = paramBoolean;
  }

  public ClientConfiguration(boolean paramBoolean)
  {
    this.keepAlive = paramBoolean;
  }

  public String getAppId()
  {
    return this.appId;
  }

  public int getConnectionTimeout()
  {
    return this.connectionTimeout;
  }

  public String getEndpoint()
  {
    return this.endpoint;
  }

  public int getMaxConnections()
  {
    return this.maxConnections;
  }

  public int getMaxErrorRetry()
  {
    return this.maxErrorRetry;
  }

  public Protocol getProtocol()
  {
    return this.protocol;
  }

  public String getProxyDomain()
  {
    return this.proxyDomain;
  }

  public String getProxyHost()
  {
    return this.proxyHost;
  }

  public String getProxyPassword()
  {
    return this.proxyPassword;
  }

  public int getProxyPort()
  {
    return this.proxyPort;
  }

  public String getProxyUsername()
  {
    return this.proxyUsername;
  }

  public String getProxyWorkstation()
  {
    return this.proxyWorkstation;
  }

  public int[] getSocketBufferSizeHints()
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.socketSendBufferSizeHint;
    arrayOfInt[1] = this.socketReceiveBufferSizeHint;
    return arrayOfInt;
  }

  public int getSocketTimeout()
  {
    return this.socketTimeout;
  }

  public InputStream getTrustStore()
  {
    return this.trustStore;
  }

  public String getTrustStorePassword()
  {
    return this.trustStorePassword;
  }

  public String getUserAgent()
  {
    return this.userAgent;
  }

  public boolean isKeepAlive()
  {
    return this.keepAlive;
  }

  public void setAppId(String paramString)
  {
    this.appId = paramString;
  }

  public void setConnectionTimeout(int paramInt)
  {
    this.connectionTimeout = paramInt;
  }

  public void setEndpoint(String paramString)
  {
    this.endpoint = paramString;
    if (StringUtils.isNotBlank(paramString))
    {
      if (paramString.regionMatches(true, 0, "https://", 0, 8))
        this.protocol = Protocol.HTTPS;
      if (paramString.regionMatches(true, 0, "http://", 0, 7))
        this.protocol = Protocol.HTTP;
    }
  }

  public void setMaxConnections(int paramInt)
  {
    this.maxConnections = paramInt;
  }

  public void setMaxErrorRetry(int paramInt)
  {
    this.maxErrorRetry = paramInt;
  }

  public void setProtocol(Protocol paramProtocol)
  {
    if (StringUtils.isNotBlank(this.endpoint))
    {
      if (this.endpoint.regionMatches(true, 0, "https://", 0, 8))
      {
        this.protocol = Protocol.HTTPS;
        return;
      }
      if (this.endpoint.regionMatches(true, 0, "http://", 0, 7))
      {
        this.protocol = Protocol.HTTP;
        return;
      }
    }
    this.protocol = paramProtocol;
  }

  public void setProxyDomain(String paramString)
  {
    this.proxyDomain = paramString;
  }

  public void setProxyHost(String paramString)
  {
    this.proxyHost = paramString;
  }

  public void setProxyPassword(String paramString)
  {
    this.proxyPassword = paramString;
  }

  public void setProxyPort(int paramInt)
  {
    this.proxyPort = paramInt;
  }

  public void setProxyUsername(String paramString)
  {
    this.proxyUsername = paramString;
  }

  public void setProxyWorkstation(String paramString)
  {
    this.proxyWorkstation = paramString;
  }

  public void setSocketBufferSizeHints(int paramInt1, int paramInt2)
  {
    this.socketSendBufferSizeHint = paramInt1;
    this.socketReceiveBufferSizeHint = paramInt2;
  }

  public void setSocketTimeout(int paramInt)
  {
    this.socketTimeout = paramInt;
  }

  public void setTrustStore(InputStream paramInputStream)
  {
    this.trustStore = paramInputStream;
  }

  public void setTrustStorePassword(String paramString)
  {
    this.trustStorePassword = paramString;
  }

  public void setUserAgent(String paramString)
  {
    this.userAgent = paramString;
  }

  public ClientConfiguration withAppId(String paramString)
  {
    setAppId(paramString);
    return this;
  }

  public ClientConfiguration withConnectionTimeout(int paramInt)
  {
    setConnectionTimeout(paramInt);
    return this;
  }

  public ClientConfiguration withMaxConnections(int paramInt)
  {
    setMaxConnections(paramInt);
    return this;
  }

  public ClientConfiguration withMaxErrorRetry(int paramInt)
  {
    setMaxErrorRetry(paramInt);
    return this;
  }

  public ClientConfiguration withProtocol(Protocol paramProtocol)
  {
    setProtocol(paramProtocol);
    return this;
  }

  public ClientConfiguration withProxyDomain(String paramString)
  {
    setProxyDomain(paramString);
    return this;
  }

  public ClientConfiguration withProxyHost(String paramString)
  {
    setProxyHost(paramString);
    return this;
  }

  public ClientConfiguration withProxyPassword(String paramString)
  {
    setProxyPassword(paramString);
    return this;
  }

  public ClientConfiguration withProxyPort(int paramInt)
  {
    setProxyPort(paramInt);
    return this;
  }

  public ClientConfiguration withProxyUsername(String paramString)
  {
    setProxyUsername(paramString);
    return this;
  }

  public ClientConfiguration withProxyWorkstation(String paramString)
  {
    setProxyWorkstation(paramString);
    return this;
  }

  public ClientConfiguration withSocketBufferSizeHints(int paramInt1, int paramInt2)
  {
    setSocketBufferSizeHints(paramInt1, paramInt2);
    return this;
  }

  public ClientConfiguration withSocketTimeout(int paramInt)
  {
    setSocketTimeout(paramInt);
    return this;
  }

  public ClientConfiguration withUserAgent(String paramString)
  {
    setUserAgent(paramString);
    return this;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.ClientConfiguration
 * JD-Core Version:    0.6.2
 */