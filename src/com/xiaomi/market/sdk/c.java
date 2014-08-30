package com.xiaomi.market.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;

public class c
{
  private static final String a = "MarketConnection";
  private static final int b = 10000;
  private static final int c = 10000;
  private static final int d = 30000;
  protected static final String r = "http";
  protected boolean A;
  protected boolean B;
  protected boolean C;
  protected boolean D;
  protected boolean E;
  protected JSONObject v;
  protected URL w;
  protected h x;
  protected String y;
  protected boolean z;

  public c(String paramString)
  {
    this(paramString, false);
  }

  public c(String paramString1, String paramString2)
  {
    this(c(paramString1, paramString2), false);
  }

  public c(String paramString, boolean paramBoolean)
  {
    try
    {
      localURL = new URL(paramString);
      this.z = true;
      this.A = false;
      this.B = true;
      this.C = true;
      this.D = true;
      if (b(localURL))
        this.w = localURL;
      this.E = paramBoolean;
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (true)
      {
        Log.e("MarketConnection", "URL error: " + localMalformedURLException);
        URL localURL = null;
      }
    }
  }

  private static g a(int paramInt)
  {
    if (paramInt == 200)
      return g.I;
    Log.e("MarketConnection", "Network Error : " + paramInt);
    return g.N;
  }

  // ERROR //
  private g a(String paramString1, String paramString2, boolean paramBoolean, i parami)
  {
    // Byte code:
    //   0: new 106	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 107	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: aload_1
    //   12: invokevirtual 111	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   15: pop
    //   16: aload 5
    //   18: invokevirtual 115	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   21: astore 7
    //   23: aload 7
    //   25: invokeinterface 121 1 0
    //   30: ifne +11 -> 41
    //   33: getstatic 124	com/xiaomi/market/sdk/g:K	Lcom/xiaomi/market/sdk/g;
    //   36: astore 22
    //   38: aload 22
    //   40: areturn
    //   41: aload 7
    //   43: invokeinterface 128 1 0
    //   48: checkcast 130	java/lang/String
    //   51: astore 8
    //   53: getstatic 134	com/xiaomi/market/sdk/s:a	Z
    //   56: ifeq +26 -> 82
    //   59: ldc 8
    //   61: new 68	java/lang/StringBuilder
    //   64: dup
    //   65: ldc 136
    //   67: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload 8
    //   72: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 141	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   81: pop
    //   82: new 47	java/net/URL
    //   85: dup
    //   86: aload 8
    //   88: invokespecial 49	java/net/URL:<init>	(Ljava/lang/String;)V
    //   91: astore 9
    //   93: aload 9
    //   95: invokevirtual 145	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   98: checkcast 147	java/net/HttpURLConnection
    //   101: astore 15
    //   103: aload 15
    //   105: sipush 10000
    //   108: invokevirtual 151	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   111: invokestatic 156	com/xiaomi/market/sdk/XiaomiUpdateAgent:a	()Landroid/content/Context;
    //   114: invokestatic 159	com/xiaomi/market/sdk/s:c	(Landroid/content/Context;)Z
    //   117: ifeq +235 -> 352
    //   120: aload 15
    //   122: sipush 10000
    //   125: invokevirtual 162	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   128: iload_3
    //   129: ifeq +293 -> 422
    //   132: aload 15
    //   134: ldc 164
    //   136: invokevirtual 167	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   139: aload 15
    //   141: iconst_0
    //   142: invokevirtual 171	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   145: aload_0
    //   146: aload 15
    //   148: invokevirtual 174	com/xiaomi/market/sdk/c:a	(Ljava/net/HttpURLConnection;)Ljava/net/HttpURLConnection;
    //   151: astore 20
    //   153: aload 20
    //   155: astore 13
    //   157: aload 13
    //   159: invokevirtual 177	java/net/HttpURLConnection:connect	()V
    //   162: iload_3
    //   163: ifne +59 -> 222
    //   166: aload_2
    //   167: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifne +52 -> 222
    //   173: aload 13
    //   175: invokevirtual 187	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   178: astore 31
    //   180: aload 31
    //   182: aload_2
    //   183: invokevirtual 191	java/lang/String:getBytes	()[B
    //   186: invokevirtual 197	java/io/OutputStream:write	([B)V
    //   189: getstatic 134	com/xiaomi/market/sdk/s:a	Z
    //   192: ifeq +25 -> 217
    //   195: ldc 8
    //   197: new 68	java/lang/StringBuilder
    //   200: dup
    //   201: ldc 199
    //   203: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   206: aload_2
    //   207: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 141	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   216: pop
    //   217: aload 31
    //   219: invokevirtual 202	java/io/OutputStream:close	()V
    //   222: aload 13
    //   224: invokevirtual 206	java/net/HttpURLConnection:getResponseCode	()I
    //   227: istore 21
    //   229: iload 21
    //   231: sipush 200
    //   234: if_icmpne +249 -> 483
    //   237: getstatic 91	com/xiaomi/market/sdk/g:I	Lcom/xiaomi/market/sdk/g;
    //   240: astore 22
    //   242: getstatic 91	com/xiaomi/market/sdk/g:I	Lcom/xiaomi/market/sdk/g;
    //   245: astore 23
    //   247: aload 22
    //   249: aload 23
    //   251: if_acmpne +60 -> 311
    //   254: aload 4
    //   256: ifnull +55 -> 311
    //   259: new 208	java/io/BufferedInputStream
    //   262: dup
    //   263: aload 13
    //   265: invokevirtual 212	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   268: sipush 8192
    //   271: invokespecial 215	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   274: astore 24
    //   276: sipush 1024
    //   279: newarray byte
    //   281: astore 28
    //   283: aload 24
    //   285: aload 28
    //   287: iconst_0
    //   288: sipush 1024
    //   291: invokevirtual 219	java/io/BufferedInputStream:read	([BII)I
    //   294: istore 29
    //   296: iload 29
    //   298: ifgt +216 -> 514
    //   301: aload 4
    //   303: invokevirtual 224	com/xiaomi/market/sdk/i:flush	()V
    //   306: aload 24
    //   308: invokevirtual 225	java/io/BufferedInputStream:close	()V
    //   311: aload 13
    //   313: ifnull -275 -> 38
    //   316: aload 13
    //   318: invokevirtual 228	java/net/HttpURLConnection:disconnect	()V
    //   321: aload 22
    //   323: areturn
    //   324: astore 33
    //   326: ldc 8
    //   328: new 68	java/lang/StringBuilder
    //   331: dup
    //   332: ldc 230
    //   334: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   337: aload 33
    //   339: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   342: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   345: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   348: pop
    //   349: goto -326 -> 23
    //   352: aload 15
    //   354: sipush 30000
    //   357: invokevirtual 162	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   360: goto -232 -> 128
    //   363: astore 17
    //   365: aload 15
    //   367: astore 11
    //   369: aload 17
    //   371: astore 10
    //   373: ldc 8
    //   375: new 68	java/lang/StringBuilder
    //   378: dup
    //   379: ldc 232
    //   381: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   384: aload 9
    //   386: invokevirtual 235	java/net/URL:getHost	()Ljava/lang/String;
    //   389: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: ldc 237
    //   394: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload 10
    //   399: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   408: pop
    //   409: aload 11
    //   411: ifnull -388 -> 23
    //   414: aload 11
    //   416: invokevirtual 228	java/net/HttpURLConnection:disconnect	()V
    //   419: goto -396 -> 23
    //   422: aload 15
    //   424: ldc 239
    //   426: invokevirtual 167	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   429: aload 15
    //   431: iconst_1
    //   432: invokevirtual 171	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   435: goto -290 -> 145
    //   438: astore 16
    //   440: aload 15
    //   442: astore 13
    //   444: aload 16
    //   446: astore 12
    //   448: aload 13
    //   450: ifnull +8 -> 458
    //   453: aload 13
    //   455: invokevirtual 228	java/net/HttpURLConnection:disconnect	()V
    //   458: aload 12
    //   460: athrow
    //   461: astore 18
    //   463: aload 18
    //   465: getfield 242	com/xiaomi/market/sdk/d:F	Lcom/xiaomi/market/sdk/g;
    //   468: astore 19
    //   470: aload 15
    //   472: ifnull +8 -> 480
    //   475: aload 15
    //   477: invokevirtual 228	java/net/HttpURLConnection:disconnect	()V
    //   480: aload 19
    //   482: areturn
    //   483: ldc 8
    //   485: new 68	java/lang/StringBuilder
    //   488: dup
    //   489: ldc 93
    //   491: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   494: iload 21
    //   496: invokevirtual 96	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   499: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   505: pop
    //   506: getstatic 99	com/xiaomi/market/sdk/g:N	Lcom/xiaomi/market/sdk/g;
    //   509: astore 22
    //   511: goto -269 -> 242
    //   514: aload 4
    //   516: aload 28
    //   518: iconst_0
    //   519: iload 29
    //   521: invokevirtual 245	com/xiaomi/market/sdk/i:write	([BII)V
    //   524: goto -241 -> 283
    //   527: astore 26
    //   529: ldc 8
    //   531: new 68	java/lang/StringBuilder
    //   534: dup
    //   535: ldc 232
    //   537: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   540: aload 9
    //   542: invokevirtual 235	java/net/URL:getHost	()Ljava/lang/String;
    //   545: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: ldc 247
    //   550: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload 26
    //   555: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   558: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   561: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   564: pop
    //   565: aload 4
    //   567: invokevirtual 250	com/xiaomi/market/sdk/i:reset	()V
    //   570: aload 24
    //   572: ifnull +8 -> 580
    //   575: aload 24
    //   577: invokevirtual 225	java/io/BufferedInputStream:close	()V
    //   580: aload 13
    //   582: ifnull -559 -> 23
    //   585: aload 13
    //   587: invokevirtual 228	java/net/HttpURLConnection:disconnect	()V
    //   590: goto -567 -> 23
    //   593: astore 25
    //   595: aconst_null
    //   596: astore 24
    //   598: aload 24
    //   600: ifnull +8 -> 608
    //   603: aload 24
    //   605: invokevirtual 225	java/io/BufferedInputStream:close	()V
    //   608: aload 25
    //   610: athrow
    //   611: astore 10
    //   613: aload 13
    //   615: astore 11
    //   617: goto -244 -> 373
    //   620: astore 12
    //   622: aconst_null
    //   623: astore 13
    //   625: goto -177 -> 448
    //   628: astore 12
    //   630: goto -182 -> 448
    //   633: astore 12
    //   635: aload 11
    //   637: astore 13
    //   639: goto -191 -> 448
    //   642: astore 10
    //   644: aconst_null
    //   645: astore 11
    //   647: goto -274 -> 373
    //   650: astore 25
    //   652: goto -54 -> 598
    //   655: astore 26
    //   657: aconst_null
    //   658: astore 24
    //   660: goto -131 -> 529
    //
    // Exception table:
    //   from	to	target	type
    //   82	93	324	java/net/MalformedURLException
    //   103	128	363	java/lang/Exception
    //   132	145	363	java/lang/Exception
    //   145	153	363	java/lang/Exception
    //   352	360	363	java/lang/Exception
    //   422	435	363	java/lang/Exception
    //   463	470	363	java/lang/Exception
    //   103	128	438	finally
    //   132	145	438	finally
    //   145	153	438	finally
    //   352	360	438	finally
    //   422	435	438	finally
    //   463	470	438	finally
    //   145	153	461	com/xiaomi/market/sdk/d
    //   276	283	527	java/lang/Exception
    //   283	296	527	java/lang/Exception
    //   301	306	527	java/lang/Exception
    //   514	524	527	java/lang/Exception
    //   259	276	593	finally
    //   157	162	611	java/lang/Exception
    //   166	217	611	java/lang/Exception
    //   217	222	611	java/lang/Exception
    //   222	229	611	java/lang/Exception
    //   237	242	611	java/lang/Exception
    //   242	247	611	java/lang/Exception
    //   306	311	611	java/lang/Exception
    //   483	511	611	java/lang/Exception
    //   575	580	611	java/lang/Exception
    //   603	608	611	java/lang/Exception
    //   608	611	611	java/lang/Exception
    //   93	103	620	finally
    //   157	162	628	finally
    //   166	217	628	finally
    //   217	222	628	finally
    //   222	229	628	finally
    //   237	242	628	finally
    //   242	247	628	finally
    //   306	311	628	finally
    //   483	511	628	finally
    //   575	580	628	finally
    //   603	608	628	finally
    //   608	611	628	finally
    //   373	409	633	finally
    //   93	103	642	java/lang/Exception
    //   276	283	650	finally
    //   283	296	650	finally
    //   301	306	650	finally
    //   514	524	650	finally
    //   529	570	650	finally
    //   259	276	655	java/lang/Exception
  }

  private void a(URL paramURL)
  {
    this.z = true;
    this.A = false;
    this.B = true;
    this.C = true;
    this.D = true;
    if (b(paramURL))
      this.w = paramURL;
  }

  public static String c(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
      return paramString2;
    if (TextUtils.isEmpty(paramString2))
      return paramString1;
    if (paramString1.charAt(-1 + paramString1.length()) == '/')
      paramString1 = paramString1.substring(0, -1 + paramString1.length());
    if (paramString2.charAt(0) == '/')
      paramString2 = paramString2.substring(1);
    return paramString1 + "/" + paramString2;
  }

  // ERROR //
  protected g a(i parami)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 64	com/xiaomi/market/sdk/c:w	Ljava/net/URL;
    //   4: ifnonnull +11 -> 15
    //   7: getstatic 275	com/xiaomi/market/sdk/g:J	Lcom/xiaomi/market/sdk/g;
    //   10: astore 11
    //   12: aload 11
    //   14: areturn
    //   15: invokestatic 156	com/xiaomi/market/sdk/XiaomiUpdateAgent:a	()Landroid/content/Context;
    //   18: invokestatic 277	com/xiaomi/market/sdk/s:b	(Landroid/content/Context;)Z
    //   21: ifne +7 -> 28
    //   24: getstatic 124	com/xiaomi/market/sdk/g:K	Lcom/xiaomi/market/sdk/g;
    //   27: areturn
    //   28: aload_0
    //   29: getfield 279	com/xiaomi/market/sdk/c:x	Lcom/xiaomi/market/sdk/h;
    //   32: ifnonnull +20 -> 52
    //   35: aload_0
    //   36: invokevirtual 283	java/lang/Object:getClass	()Ljava/lang/Class;
    //   39: pop
    //   40: aload_0
    //   41: new 285	com/xiaomi/market/sdk/h
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 288	com/xiaomi/market/sdk/h:<init>	(Lcom/xiaomi/market/sdk/c;)V
    //   49: putfield 279	com/xiaomi/market/sdk/c:x	Lcom/xiaomi/market/sdk/h;
    //   52: aload_0
    //   53: getfield 279	com/xiaomi/market/sdk/c:x	Lcom/xiaomi/market/sdk/h;
    //   56: pop
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 279	com/xiaomi/market/sdk/c:x	Lcom/xiaomi/market/sdk/h;
    //   62: invokevirtual 291	com/xiaomi/market/sdk/c:a	(Lcom/xiaomi/market/sdk/h;)Lcom/xiaomi/market/sdk/h;
    //   65: astore 4
    //   67: aload_0
    //   68: getfield 64	com/xiaomi/market/sdk/c:w	Ljava/net/URL;
    //   71: invokevirtual 292	java/net/URL:toString	()Ljava/lang/String;
    //   74: astore 5
    //   76: aload_0
    //   77: getfield 53	com/xiaomi/market/sdk/c:A	Z
    //   80: ifeq +68 -> 148
    //   83: aload 4
    //   85: invokevirtual 294	com/xiaomi/market/sdk/h:isEmpty	()Z
    //   88: ifne +60 -> 148
    //   91: aload_0
    //   92: getfield 64	com/xiaomi/market/sdk/c:w	Ljava/net/URL;
    //   95: invokevirtual 297	java/net/URL:getQuery	()Ljava/lang/String;
    //   98: astore 16
    //   100: aload_0
    //   101: getfield 64	com/xiaomi/market/sdk/c:w	Ljava/net/URL;
    //   104: invokevirtual 292	java/net/URL:toString	()Ljava/lang/String;
    //   107: astore 17
    //   109: aload 16
    //   111: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifeq +171 -> 285
    //   117: new 68	java/lang/StringBuilder
    //   120: dup
    //   121: aload 17
    //   123: invokestatic 269	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   129: ldc_w 299
    //   132: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload 4
    //   137: invokevirtual 300	com/xiaomi/market/sdk/h:toString	()Ljava/lang/String;
    //   140: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore 5
    //   148: aload_0
    //   149: aload 5
    //   151: aload 4
    //   153: invokevirtual 303	com/xiaomi/market/sdk/c:a	(Ljava/lang/String;Lcom/xiaomi/market/sdk/h;)Ljava/lang/String;
    //   156: astore 7
    //   158: getstatic 134	com/xiaomi/market/sdk/s:a	Z
    //   161: ifeq +27 -> 188
    //   164: ldc 8
    //   166: new 68	java/lang/StringBuilder
    //   169: dup
    //   170: ldc_w 305
    //   173: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: aload 7
    //   178: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 141	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   187: pop
    //   188: ldc_w 307
    //   191: astore 8
    //   193: aload_0
    //   194: getfield 53	com/xiaomi/market/sdk/c:A	Z
    //   197: ifne +10 -> 207
    //   200: aload 4
    //   202: invokevirtual 300	com/xiaomi/market/sdk/h:toString	()Ljava/lang/String;
    //   205: astore 8
    //   207: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   210: lstore 9
    //   212: aload_0
    //   213: aload 7
    //   215: aload 8
    //   217: aload_0
    //   218: getfield 53	com/xiaomi/market/sdk/c:A	Z
    //   221: aload_1
    //   222: invokespecial 315	com/xiaomi/market/sdk/c:a	(Ljava/lang/String;Ljava/lang/String;ZLcom/xiaomi/market/sdk/i;)Lcom/xiaomi/market/sdk/g;
    //   225: astore 11
    //   227: getstatic 134	com/xiaomi/market/sdk/s:a	Z
    //   230: ifeq -218 -> 12
    //   233: invokestatic 313	java/lang/System:currentTimeMillis	()J
    //   236: lstore 12
    //   238: ldc 8
    //   240: new 68	java/lang/StringBuilder
    //   243: dup
    //   244: ldc_w 317
    //   247: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: lload 12
    //   252: lload 9
    //   254: lsub
    //   255: invokevirtual 320	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   258: ldc_w 322
    //   261: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 7
    //   266: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 141	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   275: pop
    //   276: aload 11
    //   278: areturn
    //   279: astore_3
    //   280: aload_3
    //   281: getfield 242	com/xiaomi/market/sdk/d:F	Lcom/xiaomi/market/sdk/g;
    //   284: areturn
    //   285: new 68	java/lang/StringBuilder
    //   288: dup
    //   289: aload 17
    //   291: invokestatic 269	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   294: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   297: ldc_w 324
    //   300: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 4
    //   305: invokevirtual 300	com/xiaomi/market/sdk/h:toString	()Ljava/lang/String;
    //   308: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   314: astore 5
    //   316: goto -168 -> 148
    //   319: astore 6
    //   321: aload 6
    //   323: getfield 242	com/xiaomi/market/sdk/d:F	Lcom/xiaomi/market/sdk/g;
    //   326: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   57	67	279	com/xiaomi/market/sdk/d
    //   148	158	319	com/xiaomi/market/sdk/d
  }

  protected h a(h paramh)
  {
    return paramh;
  }

  protected String a(String paramString, h paramh)
  {
    return paramString;
  }

  protected HttpURLConnection a(HttpURLConnection paramHttpURLConnection)
  {
    return paramHttpURLConnection;
  }

  public void a(boolean paramBoolean)
  {
    this.A = paramBoolean;
  }

  // ERROR //
  public g b(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +11 -> 12
    //   4: new 331	java/lang/IllegalArgumentException
    //   7: dup
    //   8: invokespecial 332	java/lang/IllegalArgumentException:<init>	()V
    //   11: athrow
    //   12: new 334	com/xiaomi/market/sdk/e
    //   15: dup
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 337	com/xiaomi/market/sdk/e:<init>	(Lcom/xiaomi/market/sdk/c;Ljava/io/File;)V
    //   21: astore_2
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 339	com/xiaomi/market/sdk/c:a	(Lcom/xiaomi/market/sdk/i;)Lcom/xiaomi/market/sdk/g;
    //   27: astore_3
    //   28: aload_2
    //   29: invokevirtual 340	com/xiaomi/market/sdk/e:close	()V
    //   32: aload_3
    //   33: getstatic 91	com/xiaomi/market/sdk/g:I	Lcom/xiaomi/market/sdk/g;
    //   36: if_acmpeq +31 -> 67
    //   39: ldc 8
    //   41: new 68	java/lang/StringBuilder
    //   44: dup
    //   45: ldc_w 342
    //   48: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   51: aload_3
    //   52: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   61: pop
    //   62: aload_1
    //   63: invokevirtual 347	java/io/File:delete	()Z
    //   66: pop
    //   67: aload_3
    //   68: areturn
    //   69: astore 7
    //   71: ldc 8
    //   73: new 68	java/lang/StringBuilder
    //   76: dup
    //   77: ldc_w 349
    //   80: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: aload 7
    //   85: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   88: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   94: pop
    //   95: aload 7
    //   97: athrow
    //   98: astore 4
    //   100: aload_3
    //   101: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   12	22	69	java/io/FileNotFoundException
    //   28	67	98	java/io/IOException
  }

  public void b(boolean paramBoolean)
  {
    this.z = paramBoolean;
  }

  protected boolean b(URL paramURL)
  {
    if (paramURL == null);
    while (!TextUtils.equals(paramURL.getProtocol(), "http"))
      return false;
    return true;
  }

  public void c(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }

  public void d(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }

  public JSONObject e()
  {
    return this.v;
  }

  public void e(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }

  public String f()
  {
    return this.y;
  }

  public h g()
  {
    return this.x;
  }

  // ERROR //
  public g h()
  {
    // Byte code:
    //   0: new 370	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 371	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: new 373	com/xiaomi/market/sdk/f
    //   12: dup
    //   13: aload_0
    //   14: aload_1
    //   15: invokespecial 376	com/xiaomi/market/sdk/f:<init>	(Lcom/xiaomi/market/sdk/c;Ljava/io/ByteArrayOutputStream;)V
    //   18: invokevirtual 339	com/xiaomi/market/sdk/c:a	(Lcom/xiaomi/market/sdk/i;)Lcom/xiaomi/market/sdk/g;
    //   21: astore_2
    //   22: aload_2
    //   23: getstatic 91	com/xiaomi/market/sdk/g:I	Lcom/xiaomi/market/sdk/g;
    //   26: if_acmpne +24 -> 50
    //   29: aload_0
    //   30: new 378	org/json/JSONObject
    //   33: dup
    //   34: aload_1
    //   35: invokevirtual 379	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   38: invokespecial 380	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   41: putfield 359	com/xiaomi/market/sdk/c:v	Lorg/json/JSONObject;
    //   44: aload_1
    //   45: invokevirtual 381	java/io/ByteArrayOutputStream:close	()V
    //   48: aload_2
    //   49: areturn
    //   50: ldc 8
    //   52: new 68	java/lang/StringBuilder
    //   55: dup
    //   56: ldc_w 342
    //   59: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_2
    //   63: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   72: pop
    //   73: goto -29 -> 44
    //   76: astore 5
    //   78: ldc 8
    //   80: new 68	java/lang/StringBuilder
    //   83: dup
    //   84: ldc_w 383
    //   87: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   90: aload 5
    //   92: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 85	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   101: pop
    //   102: getstatic 386	com/xiaomi/market/sdk/g:O	Lcom/xiaomi/market/sdk/g;
    //   105: astore 7
    //   107: aload_1
    //   108: invokevirtual 381	java/io/ByteArrayOutputStream:close	()V
    //   111: aload 7
    //   113: areturn
    //   114: astore 8
    //   116: aload 7
    //   118: areturn
    //   119: astore_3
    //   120: aload_1
    //   121: invokevirtual 381	java/io/ByteArrayOutputStream:close	()V
    //   124: aload_3
    //   125: athrow
    //   126: astore 4
    //   128: goto -4 -> 124
    //   131: astore 10
    //   133: aload_2
    //   134: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   22	44	76	org/json/JSONException
    //   50	73	76	org/json/JSONException
    //   107	111	114	java/io/IOException
    //   22	44	119	finally
    //   50	73	119	finally
    //   78	107	119	finally
    //   120	124	126	java/io/IOException
    //   44	48	131	java/io/IOException
  }

  public g i()
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    g localg = a(new f(this, localByteArrayOutputStream));
    if (localg == g.I)
      this.y = localByteArrayOutputStream.toString();
    try
    {
      while (true)
      {
        localByteArrayOutputStream.close();
        return localg;
        Log.e("MarketConnection", "Connection failed : " + localg);
      }
    }
    catch (IOException localIOException)
    {
    }
    return localg;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.c
 * JD-Core Version:    0.6.2
 */