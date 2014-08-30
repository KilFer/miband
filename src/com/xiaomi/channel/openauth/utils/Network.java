package com.xiaomi.channel.openauth.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Network
{
  public static final String CMWAP_GATEWAY = "10.0.0.172";
  public static final String CMWAP_HEADER_HOST_KEY = "X-Online-Host";
  public static final int CMWAP_PORT = 80;
  public static final int CONNECTION_TIMEOUT = 10000;
  public static final Pattern ContentTypePattern_Charset = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  public static final Pattern ContentTypePattern_MimeType;
  public static final Pattern ContentTypePattern_XmlEncoding = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);
  public static final String NETWORK_TYPE_3GNET = "3gnet";
  public static final String NETWORK_TYPE_3GWAP = "3gwap";
  public static final String NETWORK_TYPE_CHINATELECOM = "#777";
  public static final String NETWORK_TYPE_WIFI = "wifi";
  public static final int READ_TIMEOUT = 15000;
  public static final String RESPONSE_BODY = "RESPONSE_BODY";
  public static final String RESPONSE_CODE = "RESPONSE_CODE";
  public static final String USER_AGENT = "User-Agent";
  public static final String UserAgent_PC_Chrome = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.464.0 Safari/534.3";
  public static final String UserAgent_PC_Chrome_6_0_464_0 = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.3 (KHTML, like Gecko) Chrome/6.0.464.0 Safari/534.3";
  private static final String a = "com.xiaomi.common.Network";
  private static HostnameVerifier b = new a();
  private static TrustManager c = new b();

  static
  {
    ContentTypePattern_MimeType = Pattern.compile("([^\\s;]+)(.*)");
  }

  public static void beginDownloadFile(String paramString, OutputStream paramOutputStream, Context paramContext, boolean paramBoolean, Network.PostDownloadHandler paramPostDownloadHandler)
  {
    new c(paramString, paramOutputStream, paramPostDownloadHandler, paramBoolean, paramContext).execute(new Void[0]);
  }

  public static void beginDownloadFile(String paramString, OutputStream paramOutputStream, Network.PostDownloadHandler paramPostDownloadHandler)
  {
    new c(paramString, paramOutputStream, paramPostDownloadHandler).execute(new Void[0]);
  }

  public static String doHttpPost(Context paramContext, String paramString, List<NameValuePair> paramList)
  {
    return doHttpPost(paramContext, paramString, paramList, null, null, null, null);
  }

  // ERROR //
  public static String doHttpPost(Context paramContext, String paramString1, List<NameValuePair> paramList, Map<String, String> paramMap, Network.HttpHeaderInfo paramHttpHeaderInfo, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +13 -> 17
    //   7: new 121	java/lang/IllegalArgumentException
    //   10: dup
    //   11: ldc 123
    //   13: invokespecial 126	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   16: athrow
    //   17: getstatic 61	com/xiaomi/channel/openauth/utils/Network:b	Ljavax/net/ssl/HostnameVerifier;
    //   20: invokestatic 132	javax/net/ssl/HttpsURLConnection:setDefaultHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   23: aload_0
    //   24: new 134	java/net/URL
    //   27: dup
    //   28: aload_1
    //   29: invokespecial 135	java/net/URL:<init>	(Ljava/lang/String;)V
    //   32: invokestatic 139	com/xiaomi/channel/openauth/utils/Network:getHttpUrlConnection	(Landroid/content/Context;Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   35: astore 7
    //   37: aload 7
    //   39: sipush 10000
    //   42: invokevirtual 145	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   45: aload 7
    //   47: sipush 15000
    //   50: invokevirtual 148	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   53: aload 7
    //   55: ldc 150
    //   57: invokevirtual 153	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   60: iconst_1
    //   61: anewarray 155	javax/net/ssl/TrustManager
    //   64: astore 8
    //   66: aload 8
    //   68: iconst_0
    //   69: getstatic 66	com/xiaomi/channel/openauth/utils/Network:c	Ljavax/net/ssl/TrustManager;
    //   72: aastore
    //   73: ldc 157
    //   75: invokestatic 163	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   78: astore 32
    //   80: aload 32
    //   82: astore 10
    //   84: aload 10
    //   86: aconst_null
    //   87: aload 8
    //   89: new 165	java/security/SecureRandom
    //   92: dup
    //   93: invokespecial 166	java/security/SecureRandom:<init>	()V
    //   96: invokevirtual 170	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   99: aload 10
    //   101: invokevirtual 174	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   104: astore 12
    //   106: aload 7
    //   108: checkcast 128	javax/net/ssl/HttpsURLConnection
    //   111: aload 12
    //   113: invokevirtual 178	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   116: aload 5
    //   118: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   121: ifne +12 -> 133
    //   124: aload 7
    //   126: ldc 41
    //   128: aload 5
    //   130: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload 6
    //   135: ifnull +12 -> 147
    //   138: aload 7
    //   140: ldc 184
    //   142: aload 6
    //   144: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_3
    //   148: ifnull +26 -> 174
    //   151: aload_3
    //   152: invokeinterface 190 1 0
    //   157: invokeinterface 196 1 0
    //   162: astore 28
    //   164: aload 28
    //   166: invokeinterface 202 1 0
    //   171: ifne +58 -> 229
    //   174: aload_2
    //   175: invokestatic 206	com/xiaomi/channel/openauth/utils/Network:fromParamListToString	(Ljava/util/List;)Ljava/lang/String;
    //   178: astore 13
    //   180: aload 13
    //   182: ifnonnull +80 -> 262
    //   185: new 121	java/lang/IllegalArgumentException
    //   188: dup
    //   189: ldc 208
    //   191: invokespecial 126	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   194: athrow
    //   195: astore 30
    //   197: aconst_null
    //   198: astore 10
    //   200: aload 30
    //   202: astore 31
    //   204: aload 31
    //   206: invokevirtual 211	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   209: goto -110 -> 99
    //   212: astore 9
    //   214: aconst_null
    //   215: astore 10
    //   217: aload 9
    //   219: astore 11
    //   221: aload 11
    //   223: invokevirtual 212	java/security/KeyManagementException:printStackTrace	()V
    //   226: goto -127 -> 99
    //   229: aload 28
    //   231: invokeinterface 216 1 0
    //   236: checkcast 218	java/lang/String
    //   239: astore 29
    //   241: aload 7
    //   243: aload 29
    //   245: aload_3
    //   246: aload 29
    //   248: invokeinterface 222 2 0
    //   253: checkcast 218	java/lang/String
    //   256: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: goto -95 -> 164
    //   262: aload 7
    //   264: iconst_1
    //   265: invokevirtual 226	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   268: aload 13
    //   270: invokevirtual 230	java/lang/String:getBytes	()[B
    //   273: astore 14
    //   275: aload 7
    //   277: invokevirtual 234	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   280: aload 14
    //   282: iconst_0
    //   283: aload 14
    //   285: arraylength
    //   286: invokevirtual 240	java/io/OutputStream:write	([BII)V
    //   289: aload 7
    //   291: invokevirtual 234	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   294: invokevirtual 243	java/io/OutputStream:flush	()V
    //   297: aload 7
    //   299: invokevirtual 234	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   302: invokevirtual 246	java/io/OutputStream:close	()V
    //   305: aload 7
    //   307: invokevirtual 250	java/net/HttpURLConnection:getResponseCode	()I
    //   310: istore 15
    //   312: ldc 48
    //   314: new 252	java/lang/StringBuilder
    //   317: dup
    //   318: ldc 254
    //   320: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   323: iload 15
    //   325: invokevirtual 259	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 269	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   334: pop
    //   335: aload 4
    //   337: ifnull +87 -> 424
    //   340: aload 4
    //   342: iload 15
    //   344: putfield 274	com/xiaomi/channel/openauth/utils/Network$HttpHeaderInfo:ResponseCode	I
    //   347: aload 4
    //   349: getfield 278	com/xiaomi/channel/openauth/utils/Network$HttpHeaderInfo:AllHeaders	Ljava/util/Map;
    //   352: ifnonnull +15 -> 367
    //   355: aload 4
    //   357: new 280	java/util/HashMap
    //   360: dup
    //   361: invokespecial 281	java/util/HashMap:<init>	()V
    //   364: putfield 278	com/xiaomi/channel/openauth/utils/Network$HttpHeaderInfo:AllHeaders	Ljava/util/Map;
    //   367: iconst_0
    //   368: istore 24
    //   370: aload 7
    //   372: iload 24
    //   374: invokevirtual 285	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   377: astore 25
    //   379: aload 7
    //   381: iload 24
    //   383: invokevirtual 288	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   386: astore 26
    //   388: aload 25
    //   390: ifnonnull +8 -> 398
    //   393: aload 26
    //   395: ifnull +29 -> 424
    //   398: aload 4
    //   400: getfield 278	com/xiaomi/channel/openauth/utils/Network$HttpHeaderInfo:AllHeaders	Ljava/util/Map;
    //   403: aload 25
    //   405: aload 26
    //   407: invokeinterface 292 3 0
    //   412: pop
    //   413: iconst_1
    //   414: iload 24
    //   416: iconst_1
    //   417: iadd
    //   418: iadd
    //   419: istore 24
    //   421: goto -51 -> 370
    //   424: new 294	java/io/BufferedReader
    //   427: dup
    //   428: new 296	java/io/InputStreamReader
    //   431: dup
    //   432: new 298	com/xiaomi/channel/openauth/utils/Network$DoneHandlerInputStream
    //   435: dup
    //   436: aload 7
    //   438: invokevirtual 302	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   441: invokespecial 305	com/xiaomi/channel/openauth/utils/Network$DoneHandlerInputStream:<init>	(Ljava/io/InputStream;)V
    //   444: invokespecial 306	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   447: invokespecial 309	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   450: astore 17
    //   452: aload 17
    //   454: invokevirtual 312	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   457: astore 18
    //   459: new 314	java/lang/StringBuffer
    //   462: dup
    //   463: invokespecial 315	java/lang/StringBuffer:<init>	()V
    //   466: astore 19
    //   468: ldc_w 317
    //   471: invokestatic 323	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   474: astore 20
    //   476: aload 18
    //   478: ifnonnull +18 -> 496
    //   481: aload 19
    //   483: invokevirtual 324	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   486: astore 23
    //   488: aload 17
    //   490: invokevirtual 325	java/io/BufferedReader:close	()V
    //   493: aload 23
    //   495: areturn
    //   496: aload 19
    //   498: aload 18
    //   500: invokevirtual 328	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   503: pop
    //   504: aload 19
    //   506: aload 20
    //   508: invokevirtual 328	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   511: pop
    //   512: aload 17
    //   514: invokevirtual 312	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   517: astore 18
    //   519: goto -43 -> 476
    //   522: astore 11
    //   524: goto -303 -> 221
    //   527: astore 31
    //   529: goto -325 -> 204
    //
    // Exception table:
    //   from	to	target	type
    //   73	80	195	java/security/NoSuchAlgorithmException
    //   73	80	212	java/security/KeyManagementException
    //   84	99	522	java/security/KeyManagementException
    //   84	99	527	java/security/NoSuchAlgorithmException
  }

  public static JSONObject doHttpPostWithResponseStatus(Context paramContext, String paramString1, List<NameValuePair> paramList, Map<String, String> paramMap, String paramString2, String paramString3)
  {
    if (paramContext == null)
      throw new IllegalArgumentException("context");
    if (TextUtils.isEmpty(paramString1))
      throw new IllegalArgumentException("url");
    JSONObject localJSONObject = new JSONObject();
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 10000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 15000);
    if (!TextUtils.isEmpty(paramString2))
      HttpProtocolParams.setUserAgent(localBasicHttpParams, paramString2);
    if (!TextUtils.isEmpty(paramString3))
      localBasicHttpParams.setParameter("Cookie", paramString3);
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient(localBasicHttpParams);
    try
    {
      HttpPost localHttpPost;
      if (isCmwap(paramContext))
      {
        URL localURL = new URL(paramString1);
        String str1 = getCMWapUrl(localURL);
        String str2 = localURL.getHost();
        localHttpPost = new HttpPost(str1);
        localHttpPost.addHeader("X-Online-Host", str2);
      }
      while (true)
      {
        if ((paramList != null) && (paramList.size() != 0))
          localHttpPost.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
        HttpResponse localHttpResponse = localDefaultHttpClient.execute(localHttpPost);
        String str3 = "";
        int i = localHttpResponse.getStatusLine().getStatusCode();
        HttpEntity localHttpEntity = localHttpResponse.getEntity();
        if (localHttpEntity != null)
          str3 = EntityUtils.toString(localHttpEntity);
        localJSONObject.put("RESPONSE_CODE", i);
        localJSONObject.put("RESPONSE_BODY", str3);
        return localJSONObject;
        localHttpPost = new HttpPost(paramString1);
      }
    }
    catch (ParseException localParseException)
    {
      Log.e("com.xiaomi.common.Network", "doHttpPostWithResponseStatus", localParseException);
      return localJSONObject;
    }
    catch (IOException localIOException)
    {
      Log.e("com.xiaomi.common.Network", "doHttpPostWithResponseStatus", localIOException);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      Log.e("com.xiaomi.common.Network", "doHttpPostWithResponseStatus", localJSONException);
      return localJSONObject;
    }
    finally
    {
      if ((!localJSONObject.has("RESPONSE_CODE")) || (!localJSONObject.has("RESPONSE_BODY")))
      {
        localJSONObject.remove("RESPONSE_CODE");
        localJSONObject.remove("RESPONSE_BODY");
      }
    }
  }

  public static boolean downloadFile(String paramString, OutputStream paramOutputStream)
  {
    return downloadFile(paramString, paramOutputStream, false, null);
  }

  public static boolean downloadFile(String paramString, OutputStream paramOutputStream, Context paramContext)
  {
    while (true)
    {
      int j;
      byte[] arrayOfByte;
      int i;
      try
      {
        URL localURL1 = new URL(paramString);
        HttpURLConnection localHttpURLConnection;
        if (isCmwap(paramContext))
        {
          HttpURLConnection.setFollowRedirects(false);
          String str1 = getCMWapUrl(localURL1);
          String str2 = localURL1.getHost();
          localHttpURLConnection = (HttpURLConnection)new URL(str1).openConnection();
          localHttpURLConnection.setRequestProperty("X-Online-Host", str2);
          j = localHttpURLConnection.getResponseCode();
          break label263;
          localHttpURLConnection.setConnectTimeout(10000);
          localHttpURLConnection.setReadTimeout(15000);
          localHttpURLConnection.connect();
          InputStream localInputStream = localHttpURLConnection.getInputStream();
          arrayOfByte = new byte[1024];
          i = localInputStream.read(arrayOfByte);
          if (i <= 0)
          {
            localInputStream.close();
            paramOutputStream.close();
            return true;
            String str3 = localHttpURLConnection.getHeaderField("location");
            if (TextUtils.isEmpty(str3))
              continue;
            URL localURL2 = new URL(str3);
            String str4 = getCMWapUrl(localURL2);
            String str5 = localURL2.getHost();
            localHttpURLConnection = (HttpURLConnection)new URL(str4).openConnection();
            localHttpURLConnection.setRequestProperty("X-Online-Host", str5);
            j = localHttpURLConnection.getResponseCode();
            break label263;
          }
        }
        else
        {
          localHttpURLConnection = (HttpURLConnection)localURL1.openConnection();
          HttpURLConnection.setFollowRedirects(true);
          continue;
        }
      }
      catch (IOException localIOException)
      {
        Log.e("com.xiaomi.common.Network", "error while download file" + localIOException);
        return false;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
      continue;
      label263: if (j >= 300)
        if (j < 400);
    }
  }

  // ERROR //
  public static boolean downloadFile(String paramString, OutputStream paramOutputStream, boolean paramBoolean, Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 134	java/net/URL
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 135	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: invokevirtual 460	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   14: checkcast 141	java/net/HttpURLConnection
    //   17: astore 13
    //   19: aload 13
    //   21: sipush 10000
    //   24: invokevirtual 145	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   27: aload 13
    //   29: sipush 15000
    //   32: invokevirtual 148	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   35: iconst_1
    //   36: invokestatic 456	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   39: aload 13
    //   41: invokevirtual 463	java/net/HttpURLConnection:connect	()V
    //   44: aload 13
    //   46: invokevirtual 302	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   49: astore 14
    //   51: aload 14
    //   53: astore 4
    //   55: sipush 1024
    //   58: newarray byte
    //   60: astore 15
    //   62: aload 4
    //   64: aload 15
    //   66: invokevirtual 469	java/io/InputStream:read	([B)I
    //   69: istore 16
    //   71: iload 16
    //   73: iconst_m1
    //   74: if_icmpne +35 -> 109
    //   77: iconst_0
    //   78: istore 18
    //   80: iload 18
    //   82: ifeq +61 -> 143
    //   85: iconst_0
    //   86: istore 19
    //   88: aload 4
    //   90: ifnull +8 -> 98
    //   93: aload 4
    //   95: invokevirtual 470	java/io/InputStream:close	()V
    //   98: aload_1
    //   99: ifnull +7 -> 106
    //   102: aload_1
    //   103: invokevirtual 246	java/io/OutputStream:close	()V
    //   106: iload 19
    //   108: ireturn
    //   109: aload_1
    //   110: aload 15
    //   112: iconst_0
    //   113: iload 16
    //   115: invokevirtual 240	java/io/OutputStream:write	([BII)V
    //   118: iload_2
    //   119: ifeq -57 -> 62
    //   122: aload_3
    //   123: ifnull -61 -> 62
    //   126: aload_3
    //   127: invokestatic 484	com/xiaomi/channel/openauth/utils/Network:isWifi	(Landroid/content/Context;)Z
    //   130: istore 17
    //   132: iload 17
    //   134: ifne -72 -> 62
    //   137: iconst_1
    //   138: istore 18
    //   140: goto -60 -> 80
    //   143: iconst_1
    //   144: istore 19
    //   146: goto -58 -> 88
    //   149: astore 8
    //   151: aconst_null
    //   152: astore 9
    //   154: ldc 48
    //   156: new 252	java/lang/StringBuilder
    //   159: dup
    //   160: ldc_w 476
    //   163: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: aload 8
    //   168: invokevirtual 479	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   171: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 481	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   177: pop
    //   178: aload 9
    //   180: ifnull +8 -> 188
    //   183: aload 9
    //   185: invokevirtual 470	java/io/InputStream:close	()V
    //   188: aload_1
    //   189: ifnull +7 -> 196
    //   192: aload_1
    //   193: invokevirtual 246	java/io/OutputStream:close	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore 5
    //   200: aload 4
    //   202: ifnull +8 -> 210
    //   205: aload 4
    //   207: invokevirtual 470	java/io/InputStream:close	()V
    //   210: aload_1
    //   211: ifnull +7 -> 218
    //   214: aload_1
    //   215: invokevirtual 246	java/io/OutputStream:close	()V
    //   218: aload 5
    //   220: athrow
    //   221: astore 21
    //   223: goto -125 -> 98
    //   226: astore 20
    //   228: iload 19
    //   230: ireturn
    //   231: astore 12
    //   233: goto -45 -> 188
    //   236: astore 11
    //   238: goto -42 -> 196
    //   241: astore 7
    //   243: goto -33 -> 210
    //   246: astore 6
    //   248: goto -30 -> 218
    //   251: astore 5
    //   253: aload 9
    //   255: astore 4
    //   257: goto -57 -> 200
    //   260: astore 8
    //   262: aload 4
    //   264: astore 9
    //   266: goto -112 -> 154
    //
    // Exception table:
    //   from	to	target	type
    //   3	51	149	java/io/IOException
    //   3	51	198	finally
    //   55	62	198	finally
    //   62	71	198	finally
    //   109	118	198	finally
    //   126	132	198	finally
    //   93	98	221	java/io/IOException
    //   102	106	226	java/io/IOException
    //   183	188	231	java/io/IOException
    //   192	196	236	java/io/IOException
    //   205	210	241	java/io/IOException
    //   214	218	246	java/io/IOException
    //   154	178	251	finally
    //   55	62	260	java/io/IOException
    //   62	71	260	java/io/IOException
    //   109	118	260	java/io/IOException
    //   126	132	260	java/io/IOException
  }

  public static String downloadXml(Context paramContext, URL paramURL)
  {
    return downloadXml(paramContext, paramURL, false, null, "UTF-8", null);
  }

  public static String downloadXml(Context paramContext, URL paramURL, String paramString1, String paramString2, Map<String, String> paramMap, Network.HttpHeaderInfo paramHttpHeaderInfo)
  {
    InputStream localInputStream = null;
    try
    {
      localInputStream = downloadXmlAsStream(paramContext, paramURL, paramString1, paramString2, paramMap, paramHttpHeaderInfo);
      localStringBuilder = new StringBuilder(1024);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream, "UTF-8"), 1024);
      str = localBufferedReader.readLine();
      if (str == null)
        if (localInputStream == null);
    }
    finally
    {
      try
      {
        while (true)
        {
          StringBuilder localStringBuilder;
          String str;
          localInputStream.close();
          return localStringBuilder.toString();
          localStringBuilder.append(str);
          localStringBuilder.append("\r\n");
        }
        localObject = finally;
        if (localInputStream != null);
        try
        {
          localInputStream.close();
          throw localObject;
        }
        catch (IOException localIOException1)
        {
          while (true)
            Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + localIOException1.toString());
        }
      }
      catch (IOException localIOException2)
      {
        while (true)
          Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + localIOException2.toString());
      }
    }
  }

  public static String downloadXml(Context paramContext, URL paramURL, boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    InputStream localInputStream = null;
    try
    {
      localInputStream = downloadXmlAsStream(paramContext, paramURL, paramString1, paramString3);
      localStringBuilder = new StringBuilder(1024);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localInputStream, paramString2), 1024);
      str = localBufferedReader.readLine();
      if (str == null)
        if (localInputStream == null);
    }
    finally
    {
      try
      {
        while (true)
        {
          StringBuilder localStringBuilder;
          String str;
          localInputStream.close();
          return localStringBuilder.toString();
          localStringBuilder.append(str);
          localStringBuilder.append("\r\n");
        }
        localObject = finally;
        if (localInputStream != null);
        try
        {
          localInputStream.close();
          throw localObject;
        }
        catch (IOException localIOException1)
        {
          while (true)
            Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + localIOException1.toString());
        }
      }
      catch (IOException localIOException2)
      {
        while (true)
          Log.e("com.xiaomi.common.Network", "Failed to close responseStream" + localIOException2.toString());
      }
    }
  }

  public static InputStream downloadXmlAsStream(Context paramContext, URL paramURL)
  {
    return downloadXmlAsStream(paramContext, paramURL, null, null, null, null);
  }

  public static InputStream downloadXmlAsStream(Context paramContext, URL paramURL, String paramString1, String paramString2)
  {
    return downloadXmlAsStream(paramContext, paramURL, paramString1, paramString2, null, null);
  }

  // ERROR //
  public static InputStream downloadXmlAsStream(Context paramContext, URL paramURL, String paramString1, String paramString2, Map<String, String> paramMap, Network.HttpHeaderInfo paramHttpHeaderInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +14 -> 15
    //   4: new 121	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc_w 338
    //   11: invokespecial 126	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   14: athrow
    //   15: aload_1
    //   16: ifnonnull +13 -> 29
    //   19: new 121	java/lang/IllegalArgumentException
    //   22: dup
    //   23: ldc 123
    //   25: invokespecial 126	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   28: athrow
    //   29: getstatic 61	com/xiaomi/channel/openauth/utils/Network:b	Ljavax/net/ssl/HostnameVerifier;
    //   32: invokestatic 132	javax/net/ssl/HttpsURLConnection:setDefaultHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   35: iconst_1
    //   36: invokestatic 456	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   39: aload_0
    //   40: aload_1
    //   41: invokestatic 139	com/xiaomi/channel/openauth/utils/Network:getHttpUrlConnection	(Landroid/content/Context;Ljava/net/URL;)Ljava/net/HttpURLConnection;
    //   44: astore 6
    //   46: aload 6
    //   48: sipush 10000
    //   51: invokevirtual 145	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   54: aload 6
    //   56: sipush 15000
    //   59: invokevirtual 148	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   62: iconst_1
    //   63: anewarray 155	javax/net/ssl/TrustManager
    //   66: astore 7
    //   68: aload 7
    //   70: iconst_0
    //   71: getstatic 66	com/xiaomi/channel/openauth/utils/Network:c	Ljavax/net/ssl/TrustManager;
    //   74: aastore
    //   75: ldc 157
    //   77: invokestatic 163	javax/net/ssl/SSLContext:getInstance	(Ljava/lang/String;)Ljavax/net/ssl/SSLContext;
    //   80: astore 20
    //   82: aload 20
    //   84: astore 9
    //   86: aload 9
    //   88: aconst_null
    //   89: aload 7
    //   91: new 165	java/security/SecureRandom
    //   94: dup
    //   95: invokespecial 166	java/security/SecureRandom:<init>	()V
    //   98: invokevirtual 170	javax/net/ssl/SSLContext:init	([Ljavax/net/ssl/KeyManager;[Ljavax/net/ssl/TrustManager;Ljava/security/SecureRandom;)V
    //   101: aload 9
    //   103: invokevirtual 174	javax/net/ssl/SSLContext:getSocketFactory	()Ljavax/net/ssl/SSLSocketFactory;
    //   106: astore 11
    //   108: aload 6
    //   110: checkcast 128	javax/net/ssl/HttpsURLConnection
    //   113: aload 11
    //   115: invokevirtual 178	javax/net/ssl/HttpsURLConnection:setSSLSocketFactory	(Ljavax/net/ssl/SSLSocketFactory;)V
    //   118: aload_2
    //   119: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   122: ifne +11 -> 133
    //   125: aload 6
    //   127: ldc 41
    //   129: aload_2
    //   130: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   133: aload_3
    //   134: ifnull +11 -> 145
    //   137: aload 6
    //   139: ldc 184
    //   141: aload_3
    //   142: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload 4
    //   147: ifnull +27 -> 174
    //   150: aload 4
    //   152: invokeinterface 190 1 0
    //   157: invokeinterface 196 1 0
    //   162: astore 16
    //   164: aload 16
    //   166: invokeinterface 202 1 0
    //   171: ifne +166 -> 337
    //   174: aload 5
    //   176: ifnull +195 -> 371
    //   179: aload_1
    //   180: invokevirtual 517	java/net/URL:getProtocol	()Ljava/lang/String;
    //   183: ldc_w 519
    //   186: invokevirtual 523	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   189: ifne +16 -> 205
    //   192: aload_1
    //   193: invokevirtual 517	java/net/URL:getProtocol	()Ljava/lang/String;
    //   196: ldc_w 525
    //   199: invokevirtual 523	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +169 -> 371
    //   205: aload 5
    //   207: aload 6
    //   209: invokevirtual 250	java/net/HttpURLConnection:getResponseCode	()I
    //   212: putfield 274	com/xiaomi/channel/openauth/utils/Network$HttpHeaderInfo:ResponseCode	I
    //   215: aload 5
    //   217: getfield 278	com/xiaomi/channel/openauth/utils/Network$HttpHeaderInfo:AllHeaders	Ljava/util/Map;
    //   220: ifnonnull +15 -> 235
    //   223: aload 5
    //   225: new 280	java/util/HashMap
    //   228: dup
    //   229: invokespecial 281	java/util/HashMap:<init>	()V
    //   232: putfield 278	com/xiaomi/channel/openauth/utils/Network$HttpHeaderInfo:AllHeaders	Ljava/util/Map;
    //   235: iconst_0
    //   236: istore 12
    //   238: aload 6
    //   240: iload 12
    //   242: invokevirtual 285	java/net/HttpURLConnection:getHeaderFieldKey	(I)Ljava/lang/String;
    //   245: astore 13
    //   247: aload 6
    //   249: iload 12
    //   251: invokevirtual 288	java/net/HttpURLConnection:getHeaderField	(I)Ljava/lang/String;
    //   254: astore 14
    //   256: aload 13
    //   258: ifnonnull +8 -> 266
    //   261: aload 14
    //   263: ifnull +108 -> 371
    //   266: aload 13
    //   268: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   271: ifne +26 -> 297
    //   274: aload 14
    //   276: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifne +18 -> 297
    //   282: aload 5
    //   284: getfield 278	com/xiaomi/channel/openauth/utils/Network$HttpHeaderInfo:AllHeaders	Ljava/util/Map;
    //   287: aload 13
    //   289: aload 14
    //   291: invokeinterface 292 3 0
    //   296: pop
    //   297: iinc 12 1
    //   300: goto -62 -> 238
    //   303: astore 18
    //   305: aconst_null
    //   306: astore 9
    //   308: aload 18
    //   310: astore 19
    //   312: aload 19
    //   314: invokevirtual 211	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   317: goto -216 -> 101
    //   320: astore 8
    //   322: aconst_null
    //   323: astore 9
    //   325: aload 8
    //   327: astore 10
    //   329: aload 10
    //   331: invokevirtual 212	java/security/KeyManagementException:printStackTrace	()V
    //   334: goto -233 -> 101
    //   337: aload 16
    //   339: invokeinterface 216 1 0
    //   344: checkcast 218	java/lang/String
    //   347: astore 17
    //   349: aload 6
    //   351: aload 17
    //   353: aload 4
    //   355: aload 17
    //   357: invokeinterface 222 2 0
    //   362: checkcast 218	java/lang/String
    //   365: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   368: goto -204 -> 164
    //   371: new 298	com/xiaomi/channel/openauth/utils/Network$DoneHandlerInputStream
    //   374: dup
    //   375: aload 6
    //   377: invokevirtual 302	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   380: invokespecial 305	com/xiaomi/channel/openauth/utils/Network$DoneHandlerInputStream:<init>	(Ljava/io/InputStream;)V
    //   383: areturn
    //   384: astore 10
    //   386: goto -57 -> 329
    //   389: astore 19
    //   391: goto -79 -> 312
    //
    // Exception table:
    //   from	to	target	type
    //   75	82	303	java/security/NoSuchAlgorithmException
    //   75	82	320	java/security/KeyManagementException
    //   86	101	384	java/security/KeyManagementException
    //   86	101	389	java/security/NoSuchAlgorithmException
  }

  public static InputStream downloadXmlAsStreamWithoutRedirect(URL paramURL, String paramString1, String paramString2)
  {
    HttpURLConnection.setFollowRedirects(false);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(10000);
    localHttpURLConnection.setReadTimeout(15000);
    if (!TextUtils.isEmpty(paramString1))
      localHttpURLConnection.setRequestProperty("User-Agent", paramString1);
    if (paramString2 != null)
      localHttpURLConnection.setRequestProperty("Cookie", paramString2);
    int i = localHttpURLConnection.getResponseCode();
    if ((i < 300) || (i >= 400));
    for (InputStream localInputStream = localHttpURLConnection.getInputStream(); ; localInputStream = null)
      return new Network.DoneHandlerInputStream(localInputStream);
  }

  public static String fromParamListToString(List<NameValuePair> paramList)
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    if (!localIterator.hasNext())
      if (localStringBuffer1.length() <= 0)
        break label178;
    label178: for (StringBuffer localStringBuffer2 = localStringBuffer1.deleteCharAt(-1 + localStringBuffer1.length()); ; localStringBuffer2 = localStringBuffer1)
      while (true)
      {
        return localStringBuffer2.toString();
        NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
        try
        {
          if (localNameValuePair.getValue() == null)
            break;
          localStringBuffer1.append(URLEncoder.encode(localNameValuePair.getName(), "UTF-8"));
          localStringBuffer1.append("=");
          localStringBuffer1.append(URLEncoder.encode(localNameValuePair.getValue(), "UTF-8"));
          localStringBuffer1.append("&");
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          Log.d("com.xiaomi.common.Network", "Failed to convert from param list to string: " + localUnsupportedEncodingException.toString());
          Log.d("com.xiaomi.common.Network", "pair: " + localNameValuePair.toString());
          return null;
        }
      }
  }

  public static String getActiveConnPoint(Context paramContext)
  {
    if (isWIFIConnected(paramContext))
      return "wifi";
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return "";
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return "";
    return localNetworkInfo.getExtraInfo();
  }

  public static String getActiveNetworkName(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return "null";
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return "null";
    if (TextUtils.isEmpty(localNetworkInfo.getSubtypeName()))
      return localNetworkInfo.getTypeName();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localNetworkInfo.getTypeName();
    arrayOfObject[1] = localNetworkInfo.getSubtypeName();
    return String.format("%s-%s", arrayOfObject);
  }

  public static int getActiveNetworkType(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return -1;
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return -1;
    return localNetworkInfo.getType();
  }

  public static String getCMWapUrl(URL paramURL)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramURL.getProtocol()).append("://10.0.0.172").append(paramURL.getPath());
    if (!TextUtils.isEmpty(paramURL.getQuery()))
      localStringBuilder.append("?").append(paramURL.getQuery());
    return localStringBuilder.toString();
  }

  public static Network.HttpHeaderInfo getHttpHeaderInfo(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      URL localURL = new URL(paramString1);
      if ((!localURL.getProtocol().equals("http")) && (!localURL.getProtocol().equals("https")))
        return null;
      HttpURLConnection.setFollowRedirects(false);
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)localURL.openConnection();
      if (paramString1.indexOf("wap") == -1)
      {
        localHttpURLConnection.setConnectTimeout(5000);
        localHttpURLConnection.setReadTimeout(5000);
      }
      while (true)
      {
        if (!TextUtils.isEmpty(paramString2))
          localHttpURLConnection.setRequestProperty("User-Agent", paramString2);
        if (paramString3 != null)
          localHttpURLConnection.setRequestProperty("Cookie", paramString3);
        localHttpHeaderInfo = new Network.HttpHeaderInfo();
        localHttpHeaderInfo.ResponseCode = localHttpURLConnection.getResponseCode();
        localHttpHeaderInfo.UserAgent = paramString2;
        i = 0;
        String str1 = localHttpURLConnection.getHeaderFieldKey(i);
        String str2 = localHttpURLConnection.getHeaderField(i);
        if ((str1 == null) && (str2 == null))
          break;
        if ((str1 != null) && (str1.equals("content-type")))
          localHttpHeaderInfo.ContentType = str2;
        if ((str1 == null) || (!str1.equals("location")))
          break label315;
        URI localURI = new URI(str2);
        if (!localURI.isAbsolute())
          localURI = new URI(paramString1).resolve(localURI);
        localHttpHeaderInfo.realUrl = localURI.toString();
        break label315;
        localHttpURLConnection.setConnectTimeout(15000);
        localHttpURLConnection.setReadTimeout(15000);
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Network.HttpHeaderInfo localHttpHeaderInfo;
      Log.e("com.xiaomi.common.Network", "Failed to transform URL", localMalformedURLException);
      return null;
      return localHttpHeaderInfo;
    }
    catch (IOException localIOException)
    {
      while (true)
        Log.e("com.xiaomi.common.Network", "Failed to get mime type", localIOException);
    }
    catch (URISyntaxException localURISyntaxException)
    {
      while (true)
      {
        int i;
        Log.e("com.xiaomi.common.Network", "Failed to parse URI", localURISyntaxException);
        continue;
        label315: i++;
      }
    }
  }

  public static InputStream getHttpPostAsStream(URL paramURL, String paramString1, Map<String, String> paramMap, String paramString2, String paramString3)
  {
    if (paramURL == null)
      throw new IllegalArgumentException("url");
    HttpURLConnection.setFollowRedirects(true);
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)paramURL.openConnection();
    localHttpURLConnection.setConnectTimeout(5000);
    localHttpURLConnection.setReadTimeout(15000);
    localHttpURLConnection.setRequestMethod("POST");
    localHttpURLConnection.setDoOutput(true);
    if (!TextUtils.isEmpty(paramString2))
      localHttpURLConnection.setRequestProperty("User-Agent", paramString2);
    if (!TextUtils.isEmpty(paramString3))
      localHttpURLConnection.setRequestProperty("Cookie", paramString3);
    localHttpURLConnection.getOutputStream().write(paramString1.getBytes());
    localHttpURLConnection.getOutputStream().flush();
    localHttpURLConnection.getOutputStream().close();
    paramMap.put("ResponseCode", localHttpURLConnection.getResponseCode());
    for (int i = 0; ; i++)
    {
      String str1 = localHttpURLConnection.getHeaderFieldKey(i);
      String str2 = localHttpURLConnection.getHeaderField(i);
      if ((str1 == null) && (str2 == null))
        break;
      paramMap.put(str1, str2);
    }
    return localHttpURLConnection.getInputStream();
  }

  public static HttpURLConnection getHttpUrlConnection(Context paramContext, URL paramURL)
  {
    if (isCtwap(paramContext))
      return (HttpURLConnection)paramURL.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80)));
    if (!isCmwap(paramContext))
      return (HttpURLConnection)paramURL.openConnection();
    String str = paramURL.getHost();
    HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(getCMWapUrl(paramURL)).openConnection();
    localHttpURLConnection.addRequestProperty("X-Online-Host", str);
    return localHttpURLConnection;
  }

  public static boolean hasNetwork(Context paramContext)
  {
    return getActiveNetworkType(paramContext) >= 0;
  }

  public static boolean isCmwap(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso()));
    String str;
    do
    {
      NetworkInfo localNetworkInfo;
      do
      {
        ConnectivityManager localConnectivityManager;
        do
        {
          return false;
          localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
        }
        while (localConnectivityManager == null);
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      }
      while (localNetworkInfo == null);
      str = localNetworkInfo.getExtraInfo();
    }
    while ((TextUtils.isEmpty(str)) || (str.length() < 3) || (str.contains("ctwap")));
    return str.regionMatches(true, -3 + str.length(), "wap", 0, 3);
  }

  public static boolean isCtwap(Context paramContext)
  {
    if (!"CN".equalsIgnoreCase(((TelephonyManager)paramContext.getSystemService("phone")).getSimCountryIso()))
      return false;
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return false;
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return false;
    String str = localNetworkInfo.getExtraInfo();
    if ((TextUtils.isEmpty(str)) || (str.length() < 3))
      return false;
    return str.contains("ctwap");
  }

  public static boolean isWIFIConnected(Context paramContext)
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localConnectivityManager == null)
      return false;
    NetworkInfo localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
    if (localNetworkInfo == null)
      return false;
    return 1 == localNetworkInfo.getType();
  }

  public static boolean isWifi(Context paramContext)
  {
    return getActiveNetworkType(paramContext) == 1;
  }

  // ERROR //
  public static String tryDetectCharsetEncoding(URL paramURL, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aload_0
    //   3: ifnonnull +13 -> 16
    //   6: new 121	java/lang/IllegalArgumentException
    //   9: dup
    //   10: ldc 123
    //   12: invokespecial 126	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   15: athrow
    //   16: iconst_1
    //   17: invokestatic 456	java/net/HttpURLConnection:setFollowRedirects	(Z)V
    //   20: aload_0
    //   21: invokevirtual 460	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   24: checkcast 141	java/net/HttpURLConnection
    //   27: astore_3
    //   28: aload_3
    //   29: sipush 5000
    //   32: invokevirtual 145	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   35: aload_3
    //   36: sipush 15000
    //   39: invokevirtual 148	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   42: aload_1
    //   43: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +10 -> 56
    //   49: aload_3
    //   50: ldc 41
    //   52: aload_1
    //   53: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_3
    //   57: invokevirtual 722	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   60: astore 4
    //   62: aload 4
    //   64: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +328 -> 395
    //   70: getstatic 83	com/xiaomi/channel/openauth/utils/Network:ContentTypePattern_Charset	Ljava/util/regex/Pattern;
    //   73: aload 4
    //   75: invokevirtual 726	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   78: astore 5
    //   80: aload 5
    //   82: invokevirtual 731	java/util/regex/Matcher:matches	()Z
    //   85: ifeq +304 -> 389
    //   88: aload 5
    //   90: invokevirtual 734	java/util/regex/Matcher:groupCount	()I
    //   93: iconst_3
    //   94: if_icmplt +295 -> 389
    //   97: aload 5
    //   99: iconst_2
    //   100: invokevirtual 737	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   103: astore 6
    //   105: aload 6
    //   107: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   110: ifne +279 -> 389
    //   113: ldc 48
    //   115: new 252	java/lang/StringBuilder
    //   118: dup
    //   119: ldc_w 739
    //   122: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload 6
    //   127: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 742	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   136: pop
    //   137: aload 6
    //   139: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   142: ifeq +134 -> 276
    //   145: getstatic 76	com/xiaomi/channel/openauth/utils/Network:ContentTypePattern_MimeType	Ljava/util/regex/Pattern;
    //   148: aload 4
    //   150: invokevirtual 726	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   153: astore 7
    //   155: aload 7
    //   157: invokevirtual 731	java/util/regex/Matcher:matches	()Z
    //   160: ifeq +116 -> 276
    //   163: aload 7
    //   165: invokevirtual 734	java/util/regex/Matcher:groupCount	()I
    //   168: iconst_2
    //   169: if_icmplt +107 -> 276
    //   172: aload 7
    //   174: iconst_1
    //   175: invokevirtual 737	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   178: astore 8
    //   180: aload 8
    //   182: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   185: ifne +91 -> 276
    //   188: aload 8
    //   190: invokevirtual 745	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   193: astore 9
    //   195: aload 9
    //   197: ldc_w 747
    //   200: invokevirtual 750	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   203: ifeq +73 -> 276
    //   206: aload 9
    //   208: ldc_w 752
    //   211: invokevirtual 750	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   214: ifne +14 -> 228
    //   217: aload 9
    //   219: ldc_w 754
    //   222: invokevirtual 757	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   225: ifeq +51 -> 276
    //   228: new 298	com/xiaomi/channel/openauth/utils/Network$DoneHandlerInputStream
    //   231: dup
    //   232: aload_3
    //   233: invokevirtual 302	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   236: invokespecial 305	com/xiaomi/channel/openauth/utils/Network$DoneHandlerInputStream:<init>	(Ljava/io/InputStream;)V
    //   239: astore 10
    //   241: new 294	java/io/BufferedReader
    //   244: dup
    //   245: new 296	java/io/InputStreamReader
    //   248: dup
    //   249: aload 10
    //   251: invokespecial 306	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   254: invokespecial 309	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   257: astore 11
    //   259: aload 11
    //   261: invokevirtual 312	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   264: astore 13
    //   266: aload 13
    //   268: ifnonnull +11 -> 279
    //   271: aload 10
    //   273: invokevirtual 470	java/io/InputStream:close	()V
    //   276: aload 6
    //   278: areturn
    //   279: aload 13
    //   281: invokevirtual 760	java/lang/String:trim	()Ljava/lang/String;
    //   284: astore 14
    //   286: aload 14
    //   288: invokevirtual 708	java/lang/String:length	()I
    //   291: ifeq -32 -> 259
    //   294: getstatic 87	com/xiaomi/channel/openauth/utils/Network:ContentTypePattern_XmlEncoding	Ljava/util/regex/Pattern;
    //   297: aload 14
    //   299: invokevirtual 726	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   302: astore 15
    //   304: aload 15
    //   306: invokevirtual 731	java/util/regex/Matcher:matches	()Z
    //   309: ifeq -38 -> 271
    //   312: aload 15
    //   314: invokevirtual 734	java/util/regex/Matcher:groupCount	()I
    //   317: iconst_3
    //   318: if_icmplt -47 -> 271
    //   321: aload 15
    //   323: iconst_2
    //   324: invokevirtual 737	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   327: astore 16
    //   329: aload 16
    //   331: invokestatic 119	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   334: ifne -63 -> 271
    //   337: ldc 48
    //   339: new 252	java/lang/StringBuilder
    //   342: dup
    //   343: ldc_w 762
    //   346: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: aload 16
    //   351: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 742	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   360: pop
    //   361: aload 16
    //   363: astore 6
    //   365: goto -94 -> 271
    //   368: astore 12
    //   370: aload_2
    //   371: ifnull +7 -> 378
    //   374: aload_2
    //   375: invokevirtual 470	java/io/InputStream:close	()V
    //   378: aload 12
    //   380: athrow
    //   381: astore 12
    //   383: aload 10
    //   385: astore_2
    //   386: goto -16 -> 370
    //   389: aconst_null
    //   390: astore 6
    //   392: goto -255 -> 137
    //   395: aconst_null
    //   396: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   228	241	368	finally
    //   241	259	381	finally
    //   259	266	381	finally
    //   279	361	381	finally
  }

  // ERROR //
  public static String uploadFile(String paramString1, java.io.File paramFile, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_1
    //   3: invokevirtual 769	java/io/File:exists	()Z
    //   6: ifne +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_1
    //   12: invokevirtual 770	java/io/File:getName	()Ljava/lang/String;
    //   15: astore 4
    //   17: new 134	java/net/URL
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 135	java/net/URL:<init>	(Ljava/lang/String;)V
    //   25: invokevirtual 460	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   28: checkcast 141	java/net/HttpURLConnection
    //   31: astore 10
    //   33: aload 10
    //   35: sipush 15000
    //   38: invokevirtual 148	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   41: aload 10
    //   43: sipush 10000
    //   46: invokevirtual 145	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   49: aload 10
    //   51: iconst_1
    //   52: invokevirtual 773	java/net/HttpURLConnection:setDoInput	(Z)V
    //   55: aload 10
    //   57: iconst_1
    //   58: invokevirtual 226	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   61: aload 10
    //   63: iconst_0
    //   64: invokevirtual 776	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   67: aload 10
    //   69: ldc 150
    //   71: invokevirtual 153	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   74: aload 10
    //   76: ldc_w 778
    //   79: ldc_w 780
    //   82: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 10
    //   87: ldc_w 782
    //   90: ldc_w 784
    //   93: invokevirtual 182	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload 10
    //   98: bipush 77
    //   100: aload 4
    //   102: invokevirtual 708	java/lang/String:length	()I
    //   105: iadd
    //   106: aload_1
    //   107: invokevirtual 787	java/io/File:length	()J
    //   110: l2i
    //   111: iadd
    //   112: aload_2
    //   113: invokevirtual 708	java/lang/String:length	()I
    //   116: iadd
    //   117: invokevirtual 790	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   120: new 792	java/io/DataOutputStream
    //   123: dup
    //   124: aload 10
    //   126: invokevirtual 234	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   129: invokespecial 795	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   132: astore 11
    //   134: aload 11
    //   136: ldc_w 797
    //   139: invokevirtual 800	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   142: aload 11
    //   144: new 252	java/lang/StringBuilder
    //   147: dup
    //   148: ldc_w 802
    //   151: invokespecial 255	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload_2
    //   155: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 804
    //   161: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload_1
    //   165: invokevirtual 770	java/io/File:getName	()Ljava/lang/String;
    //   168: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: ldc_w 806
    //   174: invokevirtual 505	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokevirtual 800	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   183: aload 11
    //   185: ldc_w 507
    //   188: invokevirtual 800	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   191: new 808	java/io/FileInputStream
    //   194: dup
    //   195: aload_1
    //   196: invokespecial 811	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   199: astore 12
    //   201: sipush 1024
    //   204: newarray byte
    //   206: astore 13
    //   208: aload 12
    //   210: aload 13
    //   212: invokevirtual 812	java/io/FileInputStream:read	([B)I
    //   215: istore 14
    //   217: iload 14
    //   219: iconst_m1
    //   220: if_icmpne +138 -> 358
    //   223: aload 11
    //   225: ldc_w 507
    //   228: invokevirtual 800	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   231: aload 11
    //   233: ldc_w 814
    //   236: invokevirtual 800	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   239: aload 11
    //   241: ldc_w 816
    //   244: invokevirtual 800	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   247: aload 11
    //   249: ldc_w 814
    //   252: invokevirtual 800	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   255: aload 11
    //   257: ldc_w 507
    //   260: invokevirtual 800	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   263: aload 11
    //   265: invokevirtual 817	java/io/DataOutputStream:flush	()V
    //   268: new 314	java/lang/StringBuffer
    //   271: dup
    //   272: invokespecial 315	java/lang/StringBuffer:<init>	()V
    //   275: astore 15
    //   277: new 294	java/io/BufferedReader
    //   280: dup
    //   281: new 296	java/io/InputStreamReader
    //   284: dup
    //   285: new 298	com/xiaomi/channel/openauth/utils/Network$DoneHandlerInputStream
    //   288: dup
    //   289: aload 10
    //   291: invokevirtual 302	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   294: invokespecial 305	com/xiaomi/channel/openauth/utils/Network$DoneHandlerInputStream:<init>	(Ljava/io/InputStream;)V
    //   297: invokespecial 306	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   300: invokespecial 309	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   303: astore 16
    //   305: aload 16
    //   307: invokevirtual 312	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   310: astore 17
    //   312: aload 17
    //   314: ifnonnull +103 -> 417
    //   317: aload 15
    //   319: invokevirtual 324	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   322: astore 18
    //   324: aload 12
    //   326: invokevirtual 818	java/io/FileInputStream:close	()V
    //   329: aload 11
    //   331: invokevirtual 819	java/io/DataOutputStream:close	()V
    //   334: aload 16
    //   336: invokevirtual 325	java/io/BufferedReader:close	()V
    //   339: aload 18
    //   341: areturn
    //   342: astore 19
    //   344: ldc 48
    //   346: ldc_w 821
    //   349: aload 19
    //   351: invokestatic 447	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   354: pop
    //   355: aload 18
    //   357: areturn
    //   358: aload 11
    //   360: aload 13
    //   362: iconst_0
    //   363: iload 14
    //   365: invokevirtual 822	java/io/DataOutputStream:write	([BII)V
    //   368: aload 11
    //   370: invokevirtual 817	java/io/DataOutputStream:flush	()V
    //   373: goto -165 -> 208
    //   376: astore 5
    //   378: aload 11
    //   380: astore 6
    //   382: aload 12
    //   384: astore 7
    //   386: aload 7
    //   388: ifnull +8 -> 396
    //   391: aload 7
    //   393: invokevirtual 818	java/io/FileInputStream:close	()V
    //   396: aload 6
    //   398: ifnull +8 -> 406
    //   401: aload 6
    //   403: invokevirtual 819	java/io/DataOutputStream:close	()V
    //   406: aload_3
    //   407: ifnull +7 -> 414
    //   410: aload_3
    //   411: invokevirtual 325	java/io/BufferedReader:close	()V
    //   414: aload 5
    //   416: athrow
    //   417: aload 15
    //   419: aload 17
    //   421: invokevirtual 328	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   424: pop
    //   425: goto -120 -> 305
    //   428: astore 5
    //   430: aload 16
    //   432: astore_3
    //   433: aload 11
    //   435: astore 6
    //   437: aload 12
    //   439: astore 7
    //   441: goto -55 -> 386
    //   444: astore 8
    //   446: ldc 48
    //   448: ldc_w 821
    //   451: aload 8
    //   453: invokestatic 447	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   456: pop
    //   457: goto -43 -> 414
    //   460: astore 5
    //   462: aconst_null
    //   463: astore_3
    //   464: aconst_null
    //   465: astore 6
    //   467: aconst_null
    //   468: astore 7
    //   470: goto -84 -> 386
    //   473: astore 5
    //   475: aload 11
    //   477: astore 6
    //   479: aconst_null
    //   480: astore_3
    //   481: aconst_null
    //   482: astore 7
    //   484: goto -98 -> 386
    //
    // Exception table:
    //   from	to	target	type
    //   324	339	342	java/io/IOException
    //   201	208	376	finally
    //   208	217	376	finally
    //   223	305	376	finally
    //   358	373	376	finally
    //   305	312	428	finally
    //   317	324	428	finally
    //   417	425	428	finally
    //   391	396	444	java/io/IOException
    //   401	406	444	java/io/IOException
    //   410	414	444	java/io/IOException
    //   17	134	460	finally
    //   134	201	473	finally
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.utils.Network
 * JD-Core Version:    0.6.2
 */