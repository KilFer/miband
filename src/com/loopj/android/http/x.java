package com.loopj.android.http;

import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class x
  implements X509TrustManager
{
  x(MySSLSocketFactory paramMySSLSocketFactory)
  {
  }

  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
  }

  public final X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.x
 * JD-Core Version:    0.6.2
 */