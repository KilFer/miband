package com.tencent.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.b;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyStore;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtils
{
  private static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11)
      if (paramContext != null)
      {
        i = Proxy.getPort(paramContext);
        if (i < 0)
          i = Proxy.getDefaultPort();
      }
    String str;
    do
    {
      return i;
      return Proxy.getDefaultPort();
      str = System.getProperty("http.proxyPort");
    }
    while (TextUtils.isEmpty(str));
    try
    {
      int j = Integer.parseInt(str);
      return j;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return i;
  }

  private static int a(IOException paramIOException)
  {
    if ((paramIOException instanceof CharConversionException))
      return -20;
    if ((paramIOException instanceof MalformedInputException))
      return -21;
    if ((paramIOException instanceof UnmappableCharacterException))
      return -22;
    if ((paramIOException instanceof HttpResponseException))
      return -23;
    if ((paramIOException instanceof ClosedChannelException))
      return -24;
    if ((paramIOException instanceof ConnectionClosedException))
      return -25;
    if ((paramIOException instanceof EOFException))
      return -26;
    if ((paramIOException instanceof FileLockInterruptionException))
      return -27;
    if ((paramIOException instanceof FileNotFoundException))
      return -28;
    if ((paramIOException instanceof HttpRetryException))
      return -29;
    if ((paramIOException instanceof ConnectTimeoutException))
      return -7;
    if ((paramIOException instanceof SocketTimeoutException))
      return -8;
    if ((paramIOException instanceof InvalidPropertiesFormatException))
      return -30;
    if ((paramIOException instanceof MalformedChunkCodingException))
      return -31;
    if ((paramIOException instanceof MalformedURLException))
      return -3;
    if ((paramIOException instanceof NoHttpResponseException))
      return -32;
    if ((paramIOException instanceof InvalidClassException))
      return -33;
    if ((paramIOException instanceof InvalidObjectException))
      return -34;
    if ((paramIOException instanceof NotActiveException))
      return -35;
    if ((paramIOException instanceof NotSerializableException))
      return -36;
    if ((paramIOException instanceof OptionalDataException))
      return -37;
    if ((paramIOException instanceof StreamCorruptedException))
      return -38;
    if ((paramIOException instanceof WriteAbortedException))
      return -39;
    if ((paramIOException instanceof ProtocolException))
      return -40;
    if ((paramIOException instanceof SSLHandshakeException))
      return -41;
    if ((paramIOException instanceof SSLKeyException))
      return -42;
    if ((paramIOException instanceof SSLPeerUnverifiedException))
      return -43;
    if ((paramIOException instanceof SSLProtocolException))
      return -44;
    if ((paramIOException instanceof BindException))
      return -45;
    if ((paramIOException instanceof ConnectException))
      return -46;
    if ((paramIOException instanceof NoRouteToHostException))
      return -47;
    if ((paramIOException instanceof PortUnreachableException))
      return -48;
    if ((paramIOException instanceof SyncFailedException))
      return -49;
    if ((paramIOException instanceof UTFDataFormatException))
      return -50;
    if ((paramIOException instanceof UnknownHostException))
      return -51;
    if ((paramIOException instanceof UnknownServiceException))
      return -52;
    if ((paramIOException instanceof UnsupportedEncodingException))
      return -53;
    if ((paramIOException instanceof ZipException))
      return -54;
    return -2;
  }

  private static String a(HttpResponse paramHttpResponse)
  {
    InputStream localInputStream = paramHttpResponse.getEntity().getContent();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    Header localHeader = paramHttpResponse.getFirstHeader("Content-Encoding");
    if ((localHeader != null) && (localHeader.getValue().toLowerCase().indexOf("gzip") >= 0));
    for (Object localObject = new GZIPInputStream(localInputStream); ; localObject = localInputStream)
    {
      byte[] arrayOfByte = new byte[512];
      while (true)
      {
        int i = ((InputStream)localObject).read(arrayOfByte);
        if (i == -1)
          break;
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      return new String(localByteArrayOutputStream.toByteArray());
    }
  }

  private static void a(Context paramContext, QQToken paramQQToken, String paramString)
  {
    if ((paramString.indexOf("add_share") >= 0) || (paramString.indexOf("upload_pic") >= 0) || (paramString.indexOf("add_topic") >= 0) || (paramString.indexOf("set_user_face") >= 0) || (paramString.indexOf("add_t") >= 0) || (paramString.indexOf("add_pic_t") >= 0) || (paramString.indexOf("add_pic_url") >= 0) || (paramString.indexOf("add_video") >= 0))
      a.a(paramContext, paramQQToken, "requireApi", new String[] { paramString });
  }

  private static String b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        if (TextUtils.isEmpty(str))
          str = Proxy.getDefaultHost();
        return str;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }

  public static String encodePostBody(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramBundle.size();
    Iterator localIterator = paramBundle.keySet().iterator();
    int j = -1;
    while (true)
    {
      int k;
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        k = j + 1;
        Object localObject = paramBundle.get(str);
        if ((localObject instanceof String))
        {
          localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"\r\n" + "\r\n" + (String)localObject);
          if (k < i - 1)
            localStringBuilder.append("\r\n--" + paramString + "\r\n");
          j = k;
        }
      }
      else
      {
        return localStringBuilder.toString();
        j = k;
      }
    }
  }

  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null)
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      if (((localObject instanceof String)) || ((localObject instanceof String[])))
      {
        if ((localObject instanceof String[]))
        {
          label85: String[] arrayOfString;
          int j;
          if (i != 0)
          {
            i = 0;
            localStringBuilder.append(URLEncoder.encode(str) + "=");
            arrayOfString = (String[])paramBundle.getStringArray(str);
            j = 0;
            label128: if (j < arrayOfString.length)
            {
              if (j != 0)
                break label171;
              localStringBuilder.append(URLEncoder.encode(arrayOfString[j]));
            }
          }
          while (true)
          {
            j++;
            break label128;
            break;
            localStringBuilder.append("&");
            break label85;
            label171: localStringBuilder.append(URLEncoder.encode("," + arrayOfString[j]));
          }
        }
        if (i != 0)
          i = 0;
        while (true)
        {
          localStringBuilder.append(URLEncoder.encode(str) + "=" + URLEncoder.encode(paramBundle.getString(str)));
          break;
          localStringBuilder.append("&");
        }
      }
    }
    return localStringBuilder.toString();
  }

  public static HttpClient getHttpClient(Context paramContext, String paramString1, String paramString2)
  {
    SchemeRegistry localSchemeRegistry = new SchemeRegistry();
    localSchemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    if (Build.VERSION.SDK_INT < 16);
    while (true)
    {
      try
      {
        KeyStore localKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        localKeyStore.load(null, null);
        HttpUtils.CustomSSLSocketFactory localCustomSSLSocketFactory = new HttpUtils.CustomSSLSocketFactory(localKeyStore);
        localCustomSSLSocketFactory.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        localSchemeRegistry.register(new Scheme("https", localCustomSSLSocketFactory, 443));
        BasicHttpParams localBasicHttpParams = new BasicHttpParams();
        int i = OpenConfig.getInstance(paramContext, paramString1).getInt("Common_HttpConnectionTimeout");
        if (i == 0)
          i = 15000;
        HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, i);
        int j = OpenConfig.getInstance(paramContext, paramString1).getInt("Common_SocketConnectionTimeout");
        if (j == 0)
          j = 30000;
        HttpConnectionParams.setSoTimeout(localBasicHttpParams, j);
        HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
        HttpProtocolParams.setUserAgent(localBasicHttpParams, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(localBasicHttpParams, localSchemeRegistry), localBasicHttpParams);
        HttpUtils.NetworkProxy localNetworkProxy = getProxy(paramContext);
        if (localNetworkProxy != null)
        {
          HttpHost localHttpHost = new HttpHost(localNetworkProxy.host, localNetworkProxy.port);
          localDefaultHttpClient.getParams().setParameter("http.route.default-proxy", localHttpHost);
        }
        return localDefaultHttpClient;
      }
      catch (Exception localException)
      {
        localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        continue;
      }
      localSchemeRegistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
    }
  }

  public static HttpUtils.NetworkProxy getProxy(Context paramContext)
  {
    if (paramContext == null)
      return null;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return null;
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return null;
    if (localNetworkInfo.getType() == 0)
    {
      String str;
      if (Build.VERSION.SDK_INT < 11)
        if (paramContext != null)
        {
          str = Proxy.getHost(paramContext);
          if (TextUtils.isEmpty(str))
            str = Proxy.getDefaultHost();
        }
      while (true)
      {
        int i = a(paramContext);
        if ((TextUtils.isEmpty(str)) || (i < 0))
          break;
        return new HttpUtils.NetworkProxy(str, i, (byte)0);
        str = Proxy.getDefaultHost();
        continue;
        str = System.getProperty("http.proxyHost");
      }
    }
    return null;
  }

  public static Util.Statistic openUrl2(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    if (paramContext != null)
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager != null)
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
        if ((localNetworkInfo == null) || (!localNetworkInfo.isAvailable()))
          throw new HttpUtils.NetworkUnavailableException("network unavailable");
      }
    }
    Bundle localBundle1;
    HttpClient localHttpClient;
    String str5;
    label152: Object localObject1;
    int i;
    if (paramBundle != null)
    {
      localBundle1 = new Bundle(paramBundle);
      String str1 = localBundle1.getString("appid_for_getting_config");
      localBundle1.remove("appid_for_getting_config");
      localHttpClient = getHttpClient(paramContext, str1, paramString1);
      if (!paramString2.equals("GET"))
        break label286;
      String str4 = encodeUrl(localBundle1);
      int n = 0 + str4.length();
      if (paramString1.indexOf("?") != -1)
        break label261;
      str5 = paramString1 + "?";
      HttpGet localHttpGet = new HttpGet(str5 + str4);
      localHttpGet.addHeader("Accept-Encoding", "gzip");
      localObject1 = localHttpGet;
      i = n;
    }
    int j;
    while (true)
    {
      HttpResponse localHttpResponse = localHttpClient.execute((HttpUriRequest)localObject1);
      j = localHttpResponse.getStatusLine().getStatusCode();
      if (j != 200)
        break label694;
      return new Util.Statistic(a(localHttpResponse), i);
      localBundle1 = new Bundle();
      break;
      label261: str5 = paramString1 + "&";
      break label152;
      label286: boolean bool = paramString2.equals("POST");
      i = 0;
      localObject1 = null;
      if (bool)
      {
        HttpPost localHttpPost = new HttpPost(paramString1);
        localHttpPost.addHeader("Accept-Encoding", "gzip");
        Bundle localBundle2 = new Bundle();
        Iterator localIterator1 = localBundle1.keySet().iterator();
        while (localIterator1.hasNext())
        {
          String str3 = (String)localIterator1.next();
          Object localObject2 = localBundle1.get(str3);
          if ((localObject2 instanceof byte[]))
            localBundle2.putByteArray(str3, (byte[])localObject2);
        }
        if (!localBundle1.containsKey("method"))
          localBundle1.putString("method", paramString2);
        localHttpPost.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
        localHttpPost.setHeader("Connection", "Keep-Alive");
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        localByteArrayOutputStream.write("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
        localByteArrayOutputStream.write(encodePostBody(localBundle1, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
        if (!localBundle2.isEmpty())
        {
          int k = localBundle2.size();
          localByteArrayOutputStream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
          Iterator localIterator2 = localBundle2.keySet().iterator();
          int m = -1;
          while (localIterator2.hasNext())
          {
            String str2 = (String)localIterator2.next();
            m++;
            localByteArrayOutputStream.write(("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
            localByteArrayOutputStream.write("Content-Type: content/unknown\r\n\r\n".getBytes());
            byte[] arrayOfByte2 = localBundle2.getByteArray(str2);
            if (arrayOfByte2 != null)
              localByteArrayOutputStream.write(arrayOfByte2);
            if (m < k - 1)
              localByteArrayOutputStream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n".getBytes());
          }
        }
        localByteArrayOutputStream.write("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n".getBytes());
        byte[] arrayOfByte1 = localByteArrayOutputStream.toByteArray();
        i = 0 + arrayOfByte1.length;
        localByteArrayOutputStream.close();
        localHttpPost.setEntity(new ByteArrayEntity(arrayOfByte1));
        localObject1 = localHttpPost;
      }
    }
    label694: throw new HttpUtils.HttpStatusException("http status code error:" + j);
  }

  public static JSONObject request(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2)
  {
    com.tencent.a.a.c.a("openSDK_LOG", "OpenApi request");
    String str2;
    String str1;
    if (!paramString1.toLowerCase().startsWith("http"))
    {
      str2 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString1;
      str1 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString1;
    }
    while (true)
    {
      a(paramContext, paramQQToken, paramString1);
      Object localObject1 = null;
      long l1 = SystemClock.elapsedRealtime();
      int i = OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getInt("Common_HttpRetryCount");
      Log.d("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + i + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
      if (i == 0)
        i = 3;
      Log.d("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + i + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
      long l2 = l1;
      int j = 0;
      while (true)
      {
        j++;
        try
        {
          Util.Statistic localStatistic = openUrl2(paramContext, str2, paramString2, paramBundle);
          JSONObject localJSONObject = Util.parseJson(localStatistic.response);
          Object localObject3 = localJSONObject;
          try
          {
            int i4 = ((JSONObject)localObject3).getInt("ret");
            i3 = i4;
            long l7 = localStatistic.reqSize;
            l4 = localStatistic.rspSize;
            m = i3;
            l6 = l7;
            b.a().a(paramContext, str1, l2, l6, l4, m, paramQQToken.getAppId());
            return localObject3;
          }
          catch (JSONException localJSONException2)
          {
            while (true)
              int i3 = -4;
          }
          catch (ConnectTimeoutException localConnectTimeoutException2)
          {
            while (true)
            {
              localObject1 = localObject3;
              localObject2 = localConnectTimeoutException2;
              ((ConnectTimeoutException)localObject2).printStackTrace();
              l3 = 0L;
              l4 = 0L;
              if (j >= i)
                break label383;
              l2 = SystemClock.elapsedRealtime();
              k = -7;
              if (j < i)
                break;
              long l5 = l3;
              int m = k;
              localObject3 = localObject1;
              long l6 = l5;
            }
            b.a().a(paramContext, str1, l2, 0L, 0L, -7, paramQQToken.getAppId());
            throw ((Throwable)localObject2);
          }
          catch (SocketTimeoutException localSocketTimeoutException2)
          {
            while (true)
            {
              label383: localObject1 = localObject3;
              localObject4 = localSocketTimeoutException2;
              ((SocketTimeoutException)localObject4).printStackTrace();
              long l3 = 0L;
              long l4 = 0L;
              if (j >= i)
                break;
              l2 = SystemClock.elapsedRealtime();
              int k = -8;
            }
            b.a().a(paramContext, str1, l2, 0L, 0L, -8, paramQQToken.getAppId());
            throw ((Throwable)localObject4);
          }
        }
        catch (HttpUtils.HttpStatusException localHttpStatusException)
        {
          localHttpStatusException.printStackTrace();
          String str3 = localHttpStatusException.getMessage();
          try
          {
            int i2 = Integer.parseInt(str3.replace("http status code error:", ""));
            i1 = i2;
            b.a().a(paramContext, str1, l2, 0L, 0L, i1, paramQQToken.getAppId());
            throw localHttpStatusException;
          }
          catch (Exception localException)
          {
            while (true)
            {
              localException.printStackTrace();
              int i1 = -9;
            }
          }
        }
        catch (HttpUtils.NetworkUnavailableException localNetworkUnavailableException)
        {
          localNetworkUnavailableException.printStackTrace();
          throw localNetworkUnavailableException;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          b.a().a(paramContext, str1, l2, 0L, 0L, -3, paramQQToken.getAppId());
          throw localMalformedURLException;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          int n = a(localIOException);
          b.a().a(paramContext, str1, l2, 0L, 0L, n, paramQQToken.getAppId());
          throw localIOException;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          b.a().a(paramContext, str1, l2, 0L, 0L, -4, paramQQToken.getAppId());
          throw localJSONException1;
        }
        catch (SocketTimeoutException localSocketTimeoutException1)
        {
          while (true)
            Object localObject4 = localSocketTimeoutException1;
        }
        catch (ConnectTimeoutException localConnectTimeoutException1)
        {
          while (true)
            Object localObject2 = localConnectTimeoutException1;
        }
      }
      str1 = paramString1;
      str2 = paramString1;
    }
  }

  public static void requestAsync(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener)
  {
    com.tencent.a.a.c.a("openSDK_LOG", "OpenApi requestAsync");
    new c(paramQQToken, paramContext, paramString1, paramBundle, paramString2, paramIRequestListener).start();
  }

  public static JSONObject upload(QQToken paramQQToken, Context paramContext, String paramString, Bundle paramBundle)
  {
    String str2;
    String str1;
    if (!paramString.toLowerCase().startsWith("http"))
    {
      str2 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString;
      str1 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString;
    }
    while (true)
    {
      a(paramContext, paramQQToken, paramString);
      Object localObject1 = null;
      long l1 = SystemClock.elapsedRealtime();
      int i = OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getInt("Common_HttpRetryCount");
      Log.d("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + i + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
      if (i == 0)
        i = 3;
      Log.d("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + i + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
      long l2 = l1;
      int j = 0;
      while (true)
      {
        j++;
        try
        {
          Util.Statistic localStatistic = Util.upload(paramContext, str2, paramBundle);
          JSONObject localJSONObject = Util.parseJson(localStatistic.response);
          Object localObject3 = localJSONObject;
          try
          {
            int i4 = ((JSONObject)localObject3).getInt("ret");
            i3 = i4;
            long l7 = localStatistic.reqSize;
            l4 = localStatistic.rspSize;
            m = i3;
            l6 = l7;
            b.a().a(paramContext, str1, l2, l6, l4, m, paramQQToken.getAppId());
            return localObject3;
          }
          catch (JSONException localJSONException2)
          {
            while (true)
              int i3 = -4;
          }
          catch (ConnectTimeoutException localConnectTimeoutException2)
          {
            while (true)
            {
              localObject1 = localObject3;
              localObject2 = localConnectTimeoutException2;
              ((ConnectTimeoutException)localObject2).printStackTrace();
              l3 = 0L;
              l4 = 0L;
              if (j >= i)
                break label372;
              l2 = SystemClock.elapsedRealtime();
              k = -7;
              if (j < i)
                break;
              long l5 = l3;
              int m = k;
              localObject3 = localObject1;
              long l6 = l5;
            }
            b.a().a(paramContext, str1, l2, 0L, 0L, -7, paramQQToken.getAppId());
            throw ((Throwable)localObject2);
          }
          catch (SocketTimeoutException localSocketTimeoutException2)
          {
            while (true)
            {
              label372: localObject1 = localObject3;
              localObject4 = localSocketTimeoutException2;
              ((SocketTimeoutException)localObject4).printStackTrace();
              long l3 = 0L;
              long l4 = 0L;
              if (j >= i)
                break;
              l2 = SystemClock.elapsedRealtime();
              int k = -8;
            }
            b.a().a(paramContext, str1, l2, 0L, 0L, -8, paramQQToken.getAppId());
            throw ((Throwable)localObject4);
          }
        }
        catch (HttpUtils.HttpStatusException localHttpStatusException)
        {
          localHttpStatusException.printStackTrace();
          String str3 = localHttpStatusException.getMessage();
          try
          {
            int i2 = Integer.parseInt(str3.replace("http status code error:", ""));
            i1 = i2;
            b.a().a(paramContext, str1, l2, 0L, 0L, i1, paramQQToken.getAppId());
            throw localHttpStatusException;
          }
          catch (Exception localException)
          {
            while (true)
            {
              localException.printStackTrace();
              int i1 = -9;
            }
          }
        }
        catch (HttpUtils.NetworkUnavailableException localNetworkUnavailableException)
        {
          localNetworkUnavailableException.printStackTrace();
          throw localNetworkUnavailableException;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          b.a().a(paramContext, str1, l2, 0L, 0L, -3, paramQQToken.getAppId());
          throw localMalformedURLException;
        }
        catch (IOException localIOException)
        {
          localIOException.printStackTrace();
          int n = a(localIOException);
          b.a().a(paramContext, str1, l2, 0L, 0L, n, paramQQToken.getAppId());
          throw localIOException;
        }
        catch (JSONException localJSONException1)
        {
          localJSONException1.printStackTrace();
          b.a().a(paramContext, str1, l2, 0L, 0L, -4, paramQQToken.getAppId());
          throw localJSONException1;
        }
        catch (SocketTimeoutException localSocketTimeoutException1)
        {
          while (true)
            Object localObject4 = localSocketTimeoutException1;
        }
        catch (ConnectTimeoutException localConnectTimeoutException1)
        {
          while (true)
            Object localObject2 = localConnectTimeoutException1;
        }
      }
      str1 = paramString;
      str2 = paramString;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.HttpUtils
 * JD-Core Version:    0.6.2
 */