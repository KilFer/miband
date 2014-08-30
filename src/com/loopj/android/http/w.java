package com.loopj.android.http;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.impl.client.DefaultRedirectHandler;
import org.apache.http.protocol.HttpContext;

final class w extends DefaultRedirectHandler
{
  private static final String a = "http.protocol.redirect-locations";
  private final boolean b;

  public w(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  // ERROR //
  public final java.net.URI getLocationURI(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +13 -> 14
    //   4: new 23	java/lang/IllegalArgumentException
    //   7: dup
    //   8: ldc 25
    //   10: invokespecial 28	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_1
    //   15: ldc 30
    //   17: invokeinterface 36 2 0
    //   22: astore_3
    //   23: aload_3
    //   24: ifnonnull +37 -> 61
    //   27: new 38	org/apache/http/ProtocolException
    //   30: dup
    //   31: new 40	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 42
    //   37: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_1
    //   41: invokeinterface 47 1 0
    //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   49: ldc 53
    //   51: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 61	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;)V
    //   60: athrow
    //   61: aload_3
    //   62: invokeinterface 66 1 0
    //   67: ldc 68
    //   69: ldc 70
    //   71: invokevirtual 76	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 4
    //   76: new 78	java/net/URI
    //   79: dup
    //   80: aload 4
    //   82: invokespecial 79	java/net/URI:<init>	(Ljava/lang/String;)V
    //   85: astore 5
    //   87: aload_1
    //   88: invokeinterface 83 1 0
    //   93: astore 6
    //   95: aload 5
    //   97: invokevirtual 87	java/net/URI:isAbsolute	()Z
    //   100: ifne +333 -> 433
    //   103: aload 6
    //   105: ldc 89
    //   107: invokeinterface 95 2 0
    //   112: ifeq +62 -> 174
    //   115: new 38	org/apache/http/ProtocolException
    //   118: dup
    //   119: new 40	java/lang/StringBuilder
    //   122: dup
    //   123: ldc 97
    //   125: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload 5
    //   130: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   133: ldc 99
    //   135: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokespecial 61	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;)V
    //   144: athrow
    //   145: astore 16
    //   147: new 38	org/apache/http/ProtocolException
    //   150: dup
    //   151: new 40	java/lang/StringBuilder
    //   154: dup
    //   155: ldc 101
    //   157: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: aload 4
    //   162: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aload 16
    //   170: invokespecial 104	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: athrow
    //   174: aload_2
    //   175: ldc 106
    //   177: invokeinterface 112 2 0
    //   182: checkcast 114	org/apache/http/HttpHost
    //   185: astore 12
    //   187: aload 12
    //   189: ifnonnull +13 -> 202
    //   192: new 116	java/lang/IllegalStateException
    //   195: dup
    //   196: ldc 118
    //   198: invokespecial 119	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   201: athrow
    //   202: aload_2
    //   203: ldc 121
    //   205: invokeinterface 112 2 0
    //   210: checkcast 123	org/apache/http/HttpRequest
    //   213: astore 13
    //   215: new 78	java/net/URI
    //   218: dup
    //   219: aload 13
    //   221: invokeinterface 127 1 0
    //   226: invokeinterface 132 1 0
    //   231: invokespecial 79	java/net/URI:<init>	(Ljava/lang/String;)V
    //   234: aload 12
    //   236: iconst_1
    //   237: invokestatic 138	org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;Lorg/apache/http/HttpHost;Z)Ljava/net/URI;
    //   240: aload 5
    //   242: invokestatic 142	org/apache/http/client/utils/URIUtils:resolve	(Ljava/net/URI;Ljava/net/URI;)Ljava/net/URI;
    //   245: astore 15
    //   247: aload 15
    //   249: astore 7
    //   251: aload 6
    //   253: ldc 144
    //   255: invokeinterface 147 2 0
    //   260: ifeq +170 -> 430
    //   263: aload_2
    //   264: ldc 8
    //   266: invokeinterface 112 2 0
    //   271: checkcast 149	org/apache/http/impl/client/RedirectLocations
    //   274: astore 8
    //   276: aload 8
    //   278: ifnonnull +22 -> 300
    //   281: new 149	org/apache/http/impl/client/RedirectLocations
    //   284: dup
    //   285: invokespecial 150	org/apache/http/impl/client/RedirectLocations:<init>	()V
    //   288: astore 8
    //   290: aload_2
    //   291: ldc 8
    //   293: aload 8
    //   295: invokeinterface 154 3 0
    //   300: aload 7
    //   302: invokevirtual 157	java/net/URI:getFragment	()Ljava/lang/String;
    //   305: ifnull +111 -> 416
    //   308: aload 7
    //   310: new 114	org/apache/http/HttpHost
    //   313: dup
    //   314: aload 7
    //   316: invokevirtual 160	java/net/URI:getHost	()Ljava/lang/String;
    //   319: aload 7
    //   321: invokevirtual 164	java/net/URI:getPort	()I
    //   324: aload 7
    //   326: invokevirtual 167	java/net/URI:getScheme	()Ljava/lang/String;
    //   329: invokespecial 170	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   332: iconst_1
    //   333: invokestatic 138	org/apache/http/client/utils/URIUtils:rewriteURI	(Ljava/net/URI;Lorg/apache/http/HttpHost;Z)Ljava/net/URI;
    //   336: astore 11
    //   338: aload 11
    //   340: astore 9
    //   342: aload 8
    //   344: aload 9
    //   346: invokevirtual 174	org/apache/http/impl/client/RedirectLocations:contains	(Ljava/net/URI;)Z
    //   349: ifeq +74 -> 423
    //   352: new 176	org/apache/http/client/CircularRedirectException
    //   355: dup
    //   356: new 40	java/lang/StringBuilder
    //   359: dup
    //   360: ldc 178
    //   362: invokespecial 43	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   365: aload 9
    //   367: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   370: ldc 180
    //   372: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokespecial 181	org/apache/http/client/CircularRedirectException:<init>	(Ljava/lang/String;)V
    //   381: athrow
    //   382: astore 14
    //   384: new 38	org/apache/http/ProtocolException
    //   387: dup
    //   388: aload 14
    //   390: invokevirtual 184	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   393: aload 14
    //   395: invokespecial 104	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   398: athrow
    //   399: astore 10
    //   401: new 38	org/apache/http/ProtocolException
    //   404: dup
    //   405: aload 10
    //   407: invokevirtual 184	java/net/URISyntaxException:getMessage	()Ljava/lang/String;
    //   410: aload 10
    //   412: invokespecial 104	org/apache/http/ProtocolException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   415: athrow
    //   416: aload 7
    //   418: astore 9
    //   420: goto -78 -> 342
    //   423: aload 8
    //   425: aload 9
    //   427: invokevirtual 188	org/apache/http/impl/client/RedirectLocations:add	(Ljava/net/URI;)V
    //   430: aload 7
    //   432: areturn
    //   433: aload 5
    //   435: astore 7
    //   437: goto -186 -> 251
    //
    // Exception table:
    //   from	to	target	type
    //   76	87	145	java/net/URISyntaxException
    //   215	247	382	java/net/URISyntaxException
    //   308	338	399	java/net/URISyntaxException
  }

  public final boolean isRedirectRequested(HttpResponse paramHttpResponse, HttpContext paramHttpContext)
  {
    if (!this.b)
      return false;
    if (paramHttpResponse == null)
      throw new IllegalArgumentException("HTTP response may not be null");
    switch (paramHttpResponse.getStatusLine().getStatusCode())
    {
    case 304:
    case 305:
    case 306:
    default:
      return false;
    case 301:
    case 302:
    case 303:
    case 307:
    }
    return true;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.w
 * JD-Core Version:    0.6.2
 */