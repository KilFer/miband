package com.xiaomi.market.sdk;

final class p
  implements Runnable
{
  p(n paramn)
  {
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   4: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   7: invokestatic 27	com/xiaomi/market/sdk/m:d	(Lcom/xiaomi/market/sdk/m;)Lcom/xiaomi/market/sdk/q;
    //   10: ifnull +29 -> 39
    //   13: aload_0
    //   14: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   17: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   20: invokestatic 31	com/xiaomi/market/sdk/m:c	(Lcom/xiaomi/market/sdk/m;)Lcom/xiaomi/market/sdk/w;
    //   23: ifnull +16 -> 39
    //   26: aload_0
    //   27: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   30: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   33: invokestatic 35	com/xiaomi/market/sdk/m:e	(Lcom/xiaomi/market/sdk/m;)Ljava/io/File;
    //   36: ifnonnull +323 -> 359
    //   39: aload_0
    //   40: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   43: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   46: aload_0
    //   47: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   50: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   53: invokestatic 38	com/xiaomi/market/sdk/m:a	(Lcom/xiaomi/market/sdk/m;)Landroid/content/Context;
    //   56: invokestatic 43	com/xiaomi/market/sdk/XiaomiUpdateAgent:a	(Landroid/content/Context;)Lcom/xiaomi/market/sdk/q;
    //   59: invokestatic 46	com/xiaomi/market/sdk/m:a	(Lcom/xiaomi/market/sdk/m;Lcom/xiaomi/market/sdk/q;)V
    //   62: aload_0
    //   63: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   66: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   69: invokestatic 27	com/xiaomi/market/sdk/m:d	(Lcom/xiaomi/market/sdk/m;)Lcom/xiaomi/market/sdk/q;
    //   72: ifnonnull +4 -> 76
    //   75: return
    //   76: aload_0
    //   77: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   80: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   83: invokestatic 38	com/xiaomi/market/sdk/m:a	(Lcom/xiaomi/market/sdk/m;)Landroid/content/Context;
    //   86: invokestatic 52	com/xiaomi/market/sdk/r:j	(Landroid/content/Context;)Lcom/xiaomi/market/sdk/r;
    //   89: astore_3
    //   90: getstatic 58	com/xiaomi/market/sdk/l:aJ	[Ljava/lang/String;
    //   93: astore 4
    //   95: iconst_1
    //   96: anewarray 60	java/lang/String
    //   99: astore 5
    //   101: aload 5
    //   103: iconst_0
    //   104: aload_0
    //   105: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   108: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   111: invokestatic 27	com/xiaomi/market/sdk/m:d	(Lcom/xiaomi/market/sdk/m;)Lcom/xiaomi/market/sdk/q;
    //   114: getfield 66	com/xiaomi/market/sdk/q:packageName	Ljava/lang/String;
    //   117: aastore
    //   118: aload_3
    //   119: ldc 68
    //   121: aload 4
    //   123: ldc 70
    //   125: aload 5
    //   127: aconst_null
    //   128: aconst_null
    //   129: aconst_null
    //   130: invokevirtual 74	com/xiaomi/market/sdk/r:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   133: astore 6
    //   135: aload 6
    //   137: astore_2
    //   138: aload_2
    //   139: ifnull +399 -> 538
    //   142: aload_2
    //   143: invokeinterface 80 1 0
    //   148: ifeq +390 -> 538
    //   151: aload_0
    //   152: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   155: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   158: aload_2
    //   159: aload_2
    //   160: ldc 82
    //   162: invokeinterface 86 2 0
    //   167: invokeinterface 90 2 0
    //   172: invokestatic 93	com/xiaomi/market/sdk/m:a	(Lcom/xiaomi/market/sdk/m;J)V
    //   175: new 95	com/xiaomi/market/sdk/w
    //   178: dup
    //   179: invokespecial 96	com/xiaomi/market/sdk/w:<init>	()V
    //   182: astore 7
    //   184: aload 7
    //   186: aload_2
    //   187: aload_2
    //   188: ldc 98
    //   190: invokeinterface 86 2 0
    //   195: invokeinterface 102 2 0
    //   200: putfield 105	com/xiaomi/market/sdk/w:d	I
    //   203: aload 7
    //   205: aload_2
    //   206: aload_2
    //   207: ldc 107
    //   209: invokeinterface 86 2 0
    //   214: invokeinterface 111 2 0
    //   219: putfield 114	com/xiaomi/market/sdk/w:f	Ljava/lang/String;
    //   222: aload 7
    //   224: aload_2
    //   225: aload_2
    //   226: ldc 116
    //   228: invokeinterface 86 2 0
    //   233: invokeinterface 111 2 0
    //   238: putfield 119	com/xiaomi/market/sdk/w:g	Ljava/lang/String;
    //   241: aload 7
    //   243: aload_2
    //   244: aload_2
    //   245: ldc 121
    //   247: invokeinterface 86 2 0
    //   252: invokeinterface 111 2 0
    //   257: putfield 124	com/xiaomi/market/sdk/w:i	Ljava/lang/String;
    //   260: aload 7
    //   262: aload_2
    //   263: aload_2
    //   264: ldc 126
    //   266: invokeinterface 86 2 0
    //   271: invokeinterface 111 2 0
    //   276: putfield 128	com/xiaomi/market/sdk/w:j	Ljava/lang/String;
    //   279: aload_0
    //   280: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   283: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   286: aload 7
    //   288: invokestatic 131	com/xiaomi/market/sdk/m:a	(Lcom/xiaomi/market/sdk/m;Lcom/xiaomi/market/sdk/w;)V
    //   291: aload_2
    //   292: aload_2
    //   293: ldc 133
    //   295: invokeinterface 86 2 0
    //   300: invokeinterface 111 2 0
    //   305: astore 8
    //   307: aload 8
    //   309: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   312: istore 9
    //   314: iload 9
    //   316: ifeq +14 -> 330
    //   319: aload_2
    //   320: ifnull -245 -> 75
    //   323: aload_2
    //   324: invokeinterface 142 1 0
    //   329: return
    //   330: aload_0
    //   331: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   334: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   337: new 144	java/io/File
    //   340: dup
    //   341: aload 8
    //   343: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   346: invokestatic 150	com/xiaomi/market/sdk/m:a	(Lcom/xiaomi/market/sdk/m;Ljava/io/File;)V
    //   349: aload_2
    //   350: ifnull +9 -> 359
    //   353: aload_2
    //   354: invokeinterface 142 1 0
    //   359: aload_0
    //   360: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   363: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   366: invokestatic 31	com/xiaomi/market/sdk/m:c	(Lcom/xiaomi/market/sdk/m;)Lcom/xiaomi/market/sdk/w;
    //   369: getfield 124	com/xiaomi/market/sdk/w:i	Ljava/lang/String;
    //   372: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   375: ifne +189 -> 564
    //   378: aload_0
    //   379: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   382: aload_0
    //   383: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   386: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   389: invokestatic 35	com/xiaomi/market/sdk/m:e	(Lcom/xiaomi/market/sdk/m;)Ljava/io/File;
    //   392: invokevirtual 154	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   395: aload_0
    //   396: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   399: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   402: invokestatic 31	com/xiaomi/market/sdk/m:c	(Lcom/xiaomi/market/sdk/m;)Lcom/xiaomi/market/sdk/w;
    //   405: getfield 128	com/xiaomi/market/sdk/w:j	Ljava/lang/String;
    //   408: invokestatic 157	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   411: astore 10
    //   413: aload_0
    //   414: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   417: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   420: invokestatic 31	com/xiaomi/market/sdk/m:c	(Lcom/xiaomi/market/sdk/m;)Lcom/xiaomi/market/sdk/w;
    //   423: getfield 119	com/xiaomi/market/sdk/w:g	Ljava/lang/String;
    //   426: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   429: ifne +42 -> 471
    //   432: aload 10
    //   434: invokestatic 139	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   437: ifne +34 -> 471
    //   440: new 144	java/io/File
    //   443: dup
    //   444: aload 10
    //   446: invokespecial 147	java/io/File:<init>	(Ljava/lang/String;)V
    //   449: invokestatic 162	com/xiaomi/market/sdk/b:a	(Ljava/io/File;)Ljava/lang/String;
    //   452: aload_0
    //   453: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   456: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   459: invokestatic 31	com/xiaomi/market/sdk/m:c	(Lcom/xiaomi/market/sdk/m;)Lcom/xiaomi/market/sdk/w;
    //   462: getfield 119	com/xiaomi/market/sdk/w:g	Ljava/lang/String;
    //   465: invokestatic 166	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   468: ifeq -393 -> 75
    //   471: new 168	java/lang/StringBuilder
    //   474: dup
    //   475: ldc 170
    //   477: invokespecial 171	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   480: aload 10
    //   482: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 184	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   491: astore 11
    //   493: new 186	android/content/Intent
    //   496: dup
    //   497: ldc 188
    //   499: invokespecial 189	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   502: astore 12
    //   504: aload 12
    //   506: aload 11
    //   508: ldc 191
    //   510: invokevirtual 195	android/content/Intent:setDataAndType	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;
    //   513: pop
    //   514: aload 12
    //   516: ldc 196
    //   518: invokevirtual 200	android/content/Intent:setFlags	(I)Landroid/content/Intent;
    //   521: pop
    //   522: aload_0
    //   523: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   526: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   529: invokestatic 38	com/xiaomi/market/sdk/m:a	(Lcom/xiaomi/market/sdk/m;)Landroid/content/Context;
    //   532: aload 12
    //   534: invokevirtual 206	android/content/Context:startActivity	(Landroid/content/Intent;)V
    //   537: return
    //   538: aload_2
    //   539: ifnull -464 -> 75
    //   542: aload_2
    //   543: invokeinterface 142 1 0
    //   548: return
    //   549: astore_1
    //   550: aconst_null
    //   551: astore_2
    //   552: aload_2
    //   553: ifnull +9 -> 562
    //   556: aload_2
    //   557: invokeinterface 142 1 0
    //   562: aload_1
    //   563: athrow
    //   564: aload_0
    //   565: getfield 12	com/xiaomi/market/sdk/p:a	Lcom/xiaomi/market/sdk/n;
    //   568: invokestatic 21	com/xiaomi/market/sdk/n:a	(Lcom/xiaomi/market/sdk/n;)Lcom/xiaomi/market/sdk/m;
    //   571: invokestatic 35	com/xiaomi/market/sdk/m:e	(Lcom/xiaomi/market/sdk/m;)Ljava/io/File;
    //   574: invokevirtual 154	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   577: astore 10
    //   579: goto -166 -> 413
    //   582: astore_1
    //   583: goto -31 -> 552
    //
    // Exception table:
    //   from	to	target	type
    //   76	135	549	finally
    //   142	314	582	finally
    //   330	349	582	finally
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.p
 * JD-Core Version:    0.6.2
 */