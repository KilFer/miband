package com.xiaomi.infra.galaxy.common.http;

import org.apache.http.client.HttpClient;

public abstract class AbstractHttpClientFactory
{
  public abstract HttpClient createHttpClient(ClientConfiguration paramClientConfiguration);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.AbstractHttpClientFactory
 * JD-Core Version:    0.6.2
 */