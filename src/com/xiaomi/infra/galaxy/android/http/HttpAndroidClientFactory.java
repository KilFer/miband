package com.xiaomi.infra.galaxy.android.http;

import com.xiaomi.infra.galaxy.common.Protocol;
import com.xiaomi.infra.galaxy.common.http.AbstractHttpClientFactory;
import com.xiaomi.infra.galaxy.common.http.ClientConfiguration;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.SingleClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class HttpAndroidClientFactory extends AbstractHttpClientFactory
{
  public HttpClient createHttpClient(ClientConfiguration paramClientConfiguration)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, paramClientConfiguration.getConnectionTimeout());
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, paramClientConfiguration.getSocketTimeout());
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, true);
    HttpConnectionParams.setTcpNoDelay(localBasicHttpParams, true);
    int i = paramClientConfiguration.getSocketBufferSizeHints()[0];
    int j = paramClientConfiguration.getSocketBufferSizeHints()[1];
    if ((i > 0) || (j > 0))
      HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, Math.max(i, j));
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    if (paramClientConfiguration.getProtocol() == Protocol.HTTPS)
      localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    return new DefaultHttpClient(new SingleClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.android.http.HttpAndroidClientFactory
 * JD-Core Version:    0.6.2
 */