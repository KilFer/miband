package com.tencent.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class d extends DefaultConnectionKeepAliveStrategy
{
  d(c paramc)
  {
  }

  public final long getKeepAliveDuration(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    long l = super.getKeepAliveDuration(paramHttpResponse, paramHttpContext);
    if (l == -1L)
      l = 20000L;
    return l;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.d
 * JD-Core Version:    0.6.2
 */