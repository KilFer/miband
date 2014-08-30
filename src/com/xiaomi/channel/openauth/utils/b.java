package com.xiaomi.channel.openauth.utils;

import android.util.Log;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

final class b
  implements X509TrustManager
{
  private X509Certificate[] a;

  public final void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (this.a == null)
    {
      this.a = paramArrayOfX509Certificate;
      Log.v("openauth", "init at checkClientTrusted.");
    }
  }

  public final void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    if (this.a == null)
    {
      this.a = paramArrayOfX509Certificate;
      Log.v("openauth", "init at checkServerTrusted");
    }
  }

  public final X509Certificate[] getAcceptedIssuers()
  {
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.utils.b
 * JD-Core Version:    0.6.2
 */