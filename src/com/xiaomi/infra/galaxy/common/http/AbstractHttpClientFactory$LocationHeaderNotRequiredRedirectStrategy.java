package com.xiaomi.infra.galaxy.common.http;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.impl.client.DefaultRedirectStrategy;
import org.apache.http.protocol.HttpContext;

public final class AbstractHttpClientFactory$LocationHeaderNotRequiredRedirectStrategy extends DefaultRedirectStrategy
{
  public AbstractHttpClientFactory$LocationHeaderNotRequiredRedirectStrategy(AbstractHttpClientFactory paramAbstractHttpClientFactory)
  {
  }

  public final boolean isRedirected(HttpRequest paramHttpRequest, HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    int i = paramHttpResponse.getStatusLine().getStatusCode();
    if ((paramHttpResponse.getFirstHeader("location") == null) && (i == 301))
      return false;
    return super.isRedirected(paramHttpRequest, paramHttpResponse, paramHttpContext);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.AbstractHttpClientFactory.LocationHeaderNotRequiredRedirectStrategy
 * JD-Core Version:    0.6.2
 */