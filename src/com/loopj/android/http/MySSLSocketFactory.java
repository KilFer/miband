package com.loopj.android.http;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public class MySSLSocketFactory extends org.apache.http.conn.ssl.SSLSocketFactory
{
  private SSLContext a = SSLContext.getInstance("TLS");

  public MySSLSocketFactory(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    x localx = new x(this);
    this.a.init(null, new TrustManager[] { localx }, null);
  }

  public static org.apache.http.conn.ssl.SSLSocketFactory getFixedSocketFactory()
  {
    try
    {
      MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(getKeystore());
      localMySSLSocketFactory.setHostnameVerifier(org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      return localMySSLSocketFactory;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();
  }

  // ERROR //
  public static KeyStore getKeystore()
  {
    // Byte code:
    //   0: invokestatic 61	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   3: invokestatic 64	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   6: astore_3
    //   7: aload_3
    //   8: astore_1
    //   9: aload_1
    //   10: aconst_null
    //   11: aconst_null
    //   12: invokevirtual 68	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   15: aload_1
    //   16: areturn
    //   17: astore_0
    //   18: aconst_null
    //   19: astore_1
    //   20: aload_0
    //   21: astore_2
    //   22: aload_2
    //   23: invokevirtual 52	java/lang/Throwable:printStackTrace	()V
    //   26: aload_1
    //   27: areturn
    //   28: astore_2
    //   29: goto -7 -> 22
    //
    // Exception table:
    //   from	to	target	type
    //   0	7	17	java/lang/Throwable
    //   9	15	28	java/lang/Throwable
  }

  // ERROR //
  public static KeyStore getKeystoreOfCA(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: ldc 78
    //   4: invokestatic 83	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   7: astore 14
    //   9: new 85	java/io/BufferedInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 88	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore 5
    //   19: aload 14
    //   21: aload 5
    //   23: invokevirtual 92	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   26: astore 15
    //   28: aload 15
    //   30: astore 6
    //   32: aload 5
    //   34: invokevirtual 97	java/io/InputStream:close	()V
    //   37: invokestatic 61	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   40: astore 7
    //   42: aload 7
    //   44: invokestatic 64	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   47: astore 11
    //   49: aload 11
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 68	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   56: aload 11
    //   58: ldc 99
    //   60: aload 6
    //   62: invokevirtual 103	java/security/KeyStore:setCertificateEntry	(Ljava/lang/String;Ljava/security/cert/Certificate;)V
    //   65: aload 11
    //   67: areturn
    //   68: astore 4
    //   70: aconst_null
    //   71: astore 5
    //   73: aload 4
    //   75: invokevirtual 104	java/security/cert/CertificateException:printStackTrace	()V
    //   78: aload 5
    //   80: ifnull +98 -> 178
    //   83: aload 5
    //   85: invokevirtual 97	java/io/InputStream:close	()V
    //   88: aconst_null
    //   89: astore 6
    //   91: goto -54 -> 37
    //   94: astore 13
    //   96: aload 13
    //   98: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   101: aconst_null
    //   102: astore 6
    //   104: goto -67 -> 37
    //   107: astore_2
    //   108: aload_1
    //   109: ifnull +7 -> 116
    //   112: aload_1
    //   113: invokevirtual 97	java/io/InputStream:close	()V
    //   116: aload_2
    //   117: athrow
    //   118: astore_3
    //   119: aload_3
    //   120: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   123: goto -7 -> 116
    //   126: astore 16
    //   128: aload 16
    //   130: invokevirtual 105	java/io/IOException:printStackTrace	()V
    //   133: goto -96 -> 37
    //   136: astore 8
    //   138: aconst_null
    //   139: astore 9
    //   141: aload 8
    //   143: astore 10
    //   145: aload 10
    //   147: invokevirtual 106	java/lang/Exception:printStackTrace	()V
    //   150: aload 9
    //   152: areturn
    //   153: astore 12
    //   155: aload 11
    //   157: astore 9
    //   159: aload 12
    //   161: astore 10
    //   163: goto -18 -> 145
    //   166: astore_2
    //   167: aload 5
    //   169: astore_1
    //   170: goto -62 -> 108
    //   173: astore 4
    //   175: goto -102 -> 73
    //   178: aconst_null
    //   179: astore 6
    //   181: goto -144 -> 37
    //
    // Exception table:
    //   from	to	target	type
    //   2	19	68	java/security/cert/CertificateException
    //   83	88	94	java/io/IOException
    //   2	19	107	finally
    //   112	116	118	java/io/IOException
    //   32	37	126	java/io/IOException
    //   42	49	136	java/lang/Exception
    //   49	65	153	java/lang/Exception
    //   19	28	166	finally
    //   73	78	166	finally
    //   19	28	173	java/security/cert/CertificateException
  }

  public static DefaultHttpClient getNewHttpClient(KeyStore paramKeyStore)
  {
    try
    {
      MySSLSocketFactory localMySSLSocketFactory = new MySSLSocketFactory(paramKeyStore);
      SchemeRegistry localSchemeRegistry = new SchemeRegistry();
      localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
      localSchemeRegistry.register(new Scheme("https", localMySSLSocketFactory, 443));
      BasicHttpParams localBasicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
      DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
      return localDefaultHttpClient;
    }
    catch (Exception localException)
    {
    }
    return new DefaultHttpClient();
  }

  public Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }

  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }

  public void fixHttpsURLConnection()
  {
    HttpsURLConnection.setDefaultSSLSocketFactory(this.a.getSocketFactory());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.MySSLSocketFactory
 * JD-Core Version:    0.6.2
 */