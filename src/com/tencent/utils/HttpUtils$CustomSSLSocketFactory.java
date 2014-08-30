package com.tencent.utils;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class HttpUtils$CustomSSLSocketFactory extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext a = SSLContext.getInstance("TLS");

  public HttpUtils$CustomSSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    try
    {
      localMyX509TrustManager = new HttpUtils.MyX509TrustManager();
      this.a.init(null, new TrustManager[] { localMyX509TrustManager }, null);
      return;
    }
    catch (Exception localException)
    {
      while (true)
        HttpUtils.MyX509TrustManager localMyX509TrustManager = null;
    }
  }

  public Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }

  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.HttpUtils.CustomSSLSocketFactory
 * JD-Core Version:    0.6.2
 */