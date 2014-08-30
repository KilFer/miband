package com.xiaomi.infra.galaxy.common.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class AbstractHttpClientFactory$TrustingX509TrustManager
  implements X509TrustManager
{
  private static final X509Certificate[] X509_CERTIFICATES = new X509Certificate[0];

  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public X509Certificate[] getAcceptedIssuers()
  {
    return X509_CERTIFICATES;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.http.AbstractHttpClientFactory.TrustingX509TrustManager
 * JD-Core Version:    0.6.2
 */