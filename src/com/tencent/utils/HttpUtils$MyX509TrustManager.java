package com.tencent.utils;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HttpUtils$MyX509TrustManager
  implements X509TrustManager
{
  private X509TrustManager a;

  HttpUtils$MyX509TrustManager()
  {
    try
    {
      KeyStore localKeyStore2 = KeyStore.getInstance("JKS");
      localKeyStore1 = localKeyStore2;
      if (localKeyStore1 != null)
      {
        localKeyStore1.load(new FileInputStream("trustedCerts"), "passphrase".toCharArray());
        TrustManagerFactory localTrustManagerFactory2 = TrustManagerFactory.getInstance("SunX509", "SunJSSE");
        localTrustManagerFactory2.init(localKeyStore1);
        arrayOfTrustManager = localTrustManagerFactory2.getTrustManagers();
        i = 0;
        if (i >= arrayOfTrustManager.length)
          break label126;
        if (!(arrayOfTrustManager[i] instanceof X509TrustManager))
          break label120;
        this.a = ((X509TrustManager)arrayOfTrustManager[i]);
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        int i;
        KeyStore localKeyStore1 = null;
        continue;
        TrustManagerFactory localTrustManagerFactory1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        localTrustManagerFactory1.init(null);
        TrustManager[] arrayOfTrustManager = localTrustManagerFactory1.getTrustManagers();
        continue;
        label120: i++;
      }
    }
    label126: throw new Exception("Couldn't initialize");
  }

  public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    try
    {
      this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException localCertificateException)
    {
    }
  }

  public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
  {
    try
    {
      this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      return;
    }
    catch (CertificateException localCertificateException)
    {
    }
  }

  public X509Certificate[] getAcceptedIssuers()
  {
    return this.a.getAcceptedIssuers();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.HttpUtils.MyX509TrustManager
 * JD-Core Version:    0.6.2
 */