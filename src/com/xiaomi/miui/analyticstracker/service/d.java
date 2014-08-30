package com.xiaomi.miui.analyticstracker.service;

final class d
  implements b
{
  private d(DispatcherHelper paramDispatcherHelper)
  {
  }

  // ERROR //
  public final org.json.JSONArray a()
  {
    // Byte code:
    //   0: new 37	org/apache/http/impl/client/DefaultHttpClient
    //   3: dup
    //   4: invokespecial 38	org/apache/http/impl/client/DefaultHttpClient:<init>	()V
    //   7: astore_1
    //   8: ldc 40
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 12	com/xiaomi/miui/analyticstracker/service/d:a	Lcom/xiaomi/miui/analyticstracker/service/DispatcherHelper;
    //   15: invokestatic 45	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:a	(Lcom/xiaomi/miui/analyticstracker/service/DispatcherHelper;)Landroid/content/Context;
    //   18: ldc 47
    //   20: iconst_0
    //   21: invokestatic 53	com/xiaomi/miui/analyticstracker/utils/FileUtils:getFileByName	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/io/File;
    //   24: astore 22
    //   26: aload 22
    //   28: astore 5
    //   30: aload 5
    //   32: ifnull +68 -> 100
    //   35: aload 5
    //   37: invokevirtual 59	java/io/File:exists	()Z
    //   40: ifeq +60 -> 100
    //   43: aload 5
    //   45: invokestatic 63	com/xiaomi/miui/analyticstracker/utils/FileUtils:expired	(Ljava/io/File;)Z
    //   48: ifne +52 -> 100
    //   51: new 65	org/json/JSONArray
    //   54: dup
    //   55: aload 5
    //   57: invokestatic 69	com/xiaomi/miui/analyticstracker/utils/FileUtils:getFileContent	(Ljava/io/File;)Ljava/lang/String;
    //   60: invokespecial 72	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   63: astore 21
    //   65: aload 21
    //   67: areturn
    //   68: astore_3
    //   69: ldc 74
    //   71: new 76	java/lang/StringBuilder
    //   74: dup
    //   75: ldc 78
    //   77: invokespecial 79	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   80: aload_3
    //   81: invokevirtual 83	java/io/IOException:getMessage	()Ljava/lang/String;
    //   84: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 96	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   93: pop
    //   94: aconst_null
    //   95: astore 5
    //   97: goto -67 -> 30
    //   100: iconst_2
    //   101: anewarray 4	java/lang/Object
    //   104: astore 16
    //   106: aload 16
    //   108: iconst_0
    //   109: ldc 98
    //   111: aastore
    //   112: aload 16
    //   114: iconst_1
    //   115: aload_0
    //   116: getfield 12	com/xiaomi/miui/analyticstracker/service/d:a	Lcom/xiaomi/miui/analyticstracker/service/DispatcherHelper;
    //   119: invokestatic 45	com/xiaomi/miui/analyticstracker/service/DispatcherHelper:a	(Lcom/xiaomi/miui/analyticstracker/service/DispatcherHelper;)Landroid/content/Context;
    //   122: invokestatic 104	com/xiaomi/miui/analyticstracker/utils/SysUtils:getAppPackageName	(Landroid/content/Context;)Ljava/lang/String;
    //   125: aastore
    //   126: ldc 106
    //   128: aload 16
    //   130: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   133: astore_2
    //   134: aload_1
    //   135: new 114	org/apache/http/client/methods/HttpGet
    //   138: dup
    //   139: aload_2
    //   140: invokespecial 115	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   143: invokeinterface 121 2 0
    //   148: astore 17
    //   150: aload 17
    //   152: invokeinterface 127 1 0
    //   157: astore 18
    //   159: aload 18
    //   161: ifnull +56 -> 217
    //   164: sipush 200
    //   167: aload 18
    //   169: invokeinterface 133 1 0
    //   174: if_icmpne +43 -> 217
    //   177: aload 17
    //   179: invokeinterface 137 1 0
    //   184: invokestatic 142	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;)Ljava/lang/String;
    //   187: astore 19
    //   189: aload 5
    //   191: aload 19
    //   193: invokestatic 146	com/xiaomi/miui/analyticstracker/utils/FileUtils:writeFile	(Ljava/io/File;Ljava/lang/String;)V
    //   196: new 65	org/json/JSONArray
    //   199: dup
    //   200: aload 19
    //   202: invokespecial 72	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   205: astore 20
    //   207: aload 20
    //   209: areturn
    //   210: astore 15
    //   212: aload 15
    //   214: invokevirtual 149	org/apache/http/client/ClientProtocolException:printStackTrace	()V
    //   217: aconst_null
    //   218: areturn
    //   219: astore 14
    //   221: aload 14
    //   223: invokevirtual 150	java/io/IOException:printStackTrace	()V
    //   226: goto -9 -> 217
    //   229: astore 13
    //   231: aload 13
    //   233: invokevirtual 151	org/json/JSONException:printStackTrace	()V
    //   236: goto -19 -> 217
    //   239: astore 12
    //   241: aload 12
    //   243: invokevirtual 152	java/lang/NumberFormatException:printStackTrace	()V
    //   246: goto -29 -> 217
    //   249: astore 10
    //   251: ldc 74
    //   253: ldc 154
    //   255: iconst_1
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: aload_2
    //   262: aastore
    //   263: invokestatic 112	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   266: invokestatic 96	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   269: pop
    //   270: aload 10
    //   272: invokevirtual 155	java/lang/IllegalArgumentException:printStackTrace	()V
    //   275: goto -58 -> 217
    //   278: astore 9
    //   280: aload 9
    //   282: invokevirtual 156	java/lang/NullPointerException:printStackTrace	()V
    //   285: goto -68 -> 217
    //   288: astore 8
    //   290: aload 8
    //   292: invokevirtual 157	java/lang/AssertionError:printStackTrace	()V
    //   295: goto -78 -> 217
    //   298: astore 6
    //   300: ldc 74
    //   302: aload 6
    //   304: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   307: invokestatic 96	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   310: pop
    //   311: aload 6
    //   313: invokevirtual 159	java/lang/Exception:printStackTrace	()V
    //   316: goto -99 -> 217
    //
    // Exception table:
    //   from	to	target	type
    //   11	26	68	java/io/IOException
    //   35	65	210	org/apache/http/client/ClientProtocolException
    //   100	159	210	org/apache/http/client/ClientProtocolException
    //   164	207	210	org/apache/http/client/ClientProtocolException
    //   35	65	219	java/io/IOException
    //   100	159	219	java/io/IOException
    //   164	207	219	java/io/IOException
    //   35	65	229	org/json/JSONException
    //   100	159	229	org/json/JSONException
    //   164	207	229	org/json/JSONException
    //   35	65	239	java/lang/NumberFormatException
    //   100	159	239	java/lang/NumberFormatException
    //   164	207	239	java/lang/NumberFormatException
    //   35	65	249	java/lang/IllegalArgumentException
    //   100	159	249	java/lang/IllegalArgumentException
    //   164	207	249	java/lang/IllegalArgumentException
    //   35	65	278	java/lang/NullPointerException
    //   100	159	278	java/lang/NullPointerException
    //   164	207	278	java/lang/NullPointerException
    //   35	65	288	java/lang/AssertionError
    //   100	159	288	java/lang/AssertionError
    //   164	207	288	java/lang/AssertionError
    //   35	65	298	java/lang/Exception
    //   100	159	298	java/lang/Exception
    //   164	207	298	java/lang/Exception
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.service.d
 * JD-Core Version:    0.6.2
 */