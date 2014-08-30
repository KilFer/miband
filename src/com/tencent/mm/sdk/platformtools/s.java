package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

final class s
{
  private static int a = 10000;
  private static int b = 10000;
  private TelephonyManager c;
  private int d;
  private PhoneStateListener e = new t(this);

  // ERROR //
  public static java.util.List<PhoneUtil.CellInfo> b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 40
    //   3: invokevirtual 46	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   6: checkcast 48	android/telephony/TelephonyManager
    //   9: astore_1
    //   10: new 50	java/util/LinkedList
    //   13: dup
    //   14: invokespecial 51	java/util/LinkedList:<init>	()V
    //   17: astore_2
    //   18: ldc 53
    //   20: astore_3
    //   21: ldc 55
    //   23: astore 4
    //   25: aload_1
    //   26: invokevirtual 59	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   29: astore 6
    //   31: aload 6
    //   33: ifnull +177 -> 210
    //   36: aload 6
    //   38: ldc 55
    //   40: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifne +167 -> 210
    //   46: aload 6
    //   48: iconst_0
    //   49: iconst_3
    //   50: invokevirtual 69	java/lang/String:substring	(II)Ljava/lang/String;
    //   53: astore_3
    //   54: aload 6
    //   56: iconst_3
    //   57: iconst_5
    //   58: invokevirtual 69	java/lang/String:substring	(II)Ljava/lang/String;
    //   61: astore 37
    //   63: aload 37
    //   65: astore 8
    //   67: aload_1
    //   68: invokevirtual 73	android/telephony/TelephonyManager:getPhoneType	()I
    //   71: iconst_2
    //   72: if_icmpne +488 -> 560
    //   75: aload_1
    //   76: invokevirtual 77	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   79: checkcast 79	android/telephony/cdma/CdmaCellLocation
    //   82: astore 32
    //   84: aload 32
    //   86: ifnull +122 -> 208
    //   89: getstatic 18	com/tencent/mm/sdk/platformtools/s:b	I
    //   92: getstatic 16	com/tencent/mm/sdk/platformtools/s:a	I
    //   95: if_icmpne +173 -> 268
    //   98: ldc 55
    //   100: astore 33
    //   102: aload 32
    //   104: invokevirtual 82	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   107: iconst_m1
    //   108: if_icmpeq +100 -> 208
    //   111: aload 32
    //   113: invokevirtual 85	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   116: iconst_m1
    //   117: if_icmpeq +91 -> 208
    //   120: aload 32
    //   122: invokevirtual 88	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   125: iconst_m1
    //   126: if_icmpeq +82 -> 208
    //   129: aload_2
    //   130: new 90	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo
    //   133: dup
    //   134: aload_3
    //   135: aload 8
    //   137: ldc 55
    //   139: ldc 55
    //   141: aload 33
    //   143: ldc 92
    //   145: new 94	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   152: aload 32
    //   154: invokevirtual 82	android/telephony/cdma/CdmaCellLocation:getBaseStationId	()I
    //   157: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   160: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: new 94	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   170: aload 32
    //   172: invokevirtual 85	android/telephony/cdma/CdmaCellLocation:getNetworkId	()I
    //   175: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: new 94	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   188: aload 32
    //   190: invokevirtual 88	android/telephony/cdma/CdmaCellLocation:getSystemId	()I
    //   193: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   196: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokespecial 105	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   202: invokeinterface 110 2 0
    //   207: pop
    //   208: aload_2
    //   209: areturn
    //   210: aload_1
    //   211: invokevirtual 113	android/telephony/TelephonyManager:getSimOperator	()Ljava/lang/String;
    //   214: astore 7
    //   216: aload 7
    //   218: ifnull +34 -> 252
    //   221: aload 7
    //   223: ldc 55
    //   225: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   228: ifne +24 -> 252
    //   231: aload 7
    //   233: iconst_0
    //   234: iconst_3
    //   235: invokevirtual 69	java/lang/String:substring	(II)Ljava/lang/String;
    //   238: astore_3
    //   239: aload 7
    //   241: iconst_3
    //   242: iconst_5
    //   243: invokevirtual 69	java/lang/String:substring	(II)Ljava/lang/String;
    //   246: astore 36
    //   248: aload 36
    //   250: astore 4
    //   252: aload 4
    //   254: astore 8
    //   256: goto -189 -> 67
    //   259: astore 5
    //   261: aload 5
    //   263: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   266: aload_2
    //   267: areturn
    //   268: new 94	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   275: getstatic 18	com/tencent/mm/sdk/platformtools/s:b	I
    //   278: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   284: astore 35
    //   286: aload 35
    //   288: astore 33
    //   290: goto -188 -> 102
    //   293: astore 21
    //   295: aload_1
    //   296: invokevirtual 77	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   299: checkcast 118	android/telephony/gsm/GsmCellLocation
    //   302: astore 28
    //   304: aload 28
    //   306: ifnull +73 -> 379
    //   309: aload 28
    //   311: invokevirtual 121	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   314: istore 29
    //   316: aload 28
    //   318: invokevirtual 124	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   321: istore 30
    //   323: iload 30
    //   325: ldc 125
    //   327: if_icmpge +52 -> 379
    //   330: iload 30
    //   332: iconst_m1
    //   333: if_icmpeq +46 -> 379
    //   336: iload 29
    //   338: iconst_m1
    //   339: if_icmpeq +40 -> 379
    //   342: aload_2
    //   343: new 90	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo
    //   346: dup
    //   347: aload_3
    //   348: aload 8
    //   350: iload 30
    //   352: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   355: iload 29
    //   357: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   360: ldc 55
    //   362: ldc 131
    //   364: ldc 55
    //   366: ldc 55
    //   368: ldc 55
    //   370: invokespecial 105	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   373: invokeinterface 110 2 0
    //   378: pop
    //   379: aload_1
    //   380: invokevirtual 135	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   383: astore 23
    //   385: aload 23
    //   387: ifnull -179 -> 208
    //   390: aload 23
    //   392: invokeinterface 138 1 0
    //   397: ifle -189 -> 208
    //   400: aload 23
    //   402: invokeinterface 142 1 0
    //   407: astore 24
    //   409: aload 24
    //   411: invokeinterface 148 1 0
    //   416: ifeq -208 -> 208
    //   419: aload 24
    //   421: invokeinterface 152 1 0
    //   426: checkcast 154	android/telephony/NeighboringCellInfo
    //   429: astore 25
    //   431: aload 25
    //   433: invokevirtual 155	android/telephony/NeighboringCellInfo:getCid	()I
    //   436: iconst_m1
    //   437: if_icmpeq -28 -> 409
    //   440: aload 25
    //   442: invokevirtual 156	android/telephony/NeighboringCellInfo:getLac	()I
    //   445: ldc 125
    //   447: if_icmpgt -38 -> 409
    //   450: aload 25
    //   452: invokevirtual 156	android/telephony/NeighboringCellInfo:getLac	()I
    //   455: iconst_m1
    //   456: if_icmpeq -47 -> 409
    //   459: new 94	java/lang/StringBuilder
    //   462: dup
    //   463: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   466: bipush 143
    //   468: aload 25
    //   470: invokevirtual 159	android/telephony/NeighboringCellInfo:getRssi	()I
    //   473: iconst_1
    //   474: ishl
    //   475: iadd
    //   476: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   479: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: astore 26
    //   484: aload_2
    //   485: new 90	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo
    //   488: dup
    //   489: aload_3
    //   490: aload 8
    //   492: new 94	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   499: aload 25
    //   501: invokevirtual 156	android/telephony/NeighboringCellInfo:getLac	()I
    //   504: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   507: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: new 94	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   517: aload 25
    //   519: invokevirtual 155	android/telephony/NeighboringCellInfo:getCid	()I
    //   522: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   525: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: aload 26
    //   530: ldc 131
    //   532: ldc 55
    //   534: ldc 55
    //   536: ldc 55
    //   538: invokespecial 105	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   541: invokeinterface 110 2 0
    //   546: pop
    //   547: goto -138 -> 409
    //   550: astore 22
    //   552: aload 22
    //   554: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   557: goto -178 -> 379
    //   560: aload_1
    //   561: invokevirtual 77	android/telephony/TelephonyManager:getCellLocation	()Landroid/telephony/CellLocation;
    //   564: checkcast 118	android/telephony/gsm/GsmCellLocation
    //   567: astore 15
    //   569: aload 15
    //   571: ifnull +86 -> 657
    //   574: aload 15
    //   576: invokevirtual 121	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   579: istore 16
    //   581: aload 15
    //   583: invokevirtual 124	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   586: istore 17
    //   588: iload 17
    //   590: ldc 125
    //   592: if_icmpge +65 -> 657
    //   595: iload 17
    //   597: iconst_m1
    //   598: if_icmpeq +59 -> 657
    //   601: iload 16
    //   603: iconst_m1
    //   604: if_icmpeq +53 -> 657
    //   607: getstatic 18	com/tencent/mm/sdk/platformtools/s:b	I
    //   610: getstatic 16	com/tencent/mm/sdk/platformtools/s:a	I
    //   613: if_icmpne +254 -> 867
    //   616: ldc 55
    //   618: astore 18
    //   620: aload_2
    //   621: new 90	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo
    //   624: dup
    //   625: aload_3
    //   626: aload 8
    //   628: iload 17
    //   630: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   633: iload 16
    //   635: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   638: aload 18
    //   640: ldc 131
    //   642: ldc 55
    //   644: ldc 55
    //   646: ldc 55
    //   648: invokespecial 105	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   651: invokeinterface 110 2 0
    //   656: pop
    //   657: aload_1
    //   658: invokevirtual 135	android/telephony/TelephonyManager:getNeighboringCellInfo	()Ljava/util/List;
    //   661: astore 10
    //   663: aload 10
    //   665: ifnull -457 -> 208
    //   668: aload 10
    //   670: invokeinterface 138 1 0
    //   675: ifle -467 -> 208
    //   678: aload 10
    //   680: invokeinterface 142 1 0
    //   685: astore 11
    //   687: aload 11
    //   689: invokeinterface 148 1 0
    //   694: ifeq -486 -> 208
    //   697: aload 11
    //   699: invokeinterface 152 1 0
    //   704: checkcast 154	android/telephony/NeighboringCellInfo
    //   707: astore 12
    //   709: aload 12
    //   711: invokevirtual 155	android/telephony/NeighboringCellInfo:getCid	()I
    //   714: iconst_m1
    //   715: if_icmpeq -28 -> 687
    //   718: aload 12
    //   720: invokevirtual 156	android/telephony/NeighboringCellInfo:getLac	()I
    //   723: ldc 125
    //   725: if_icmpgt -38 -> 687
    //   728: new 94	java/lang/StringBuilder
    //   731: dup
    //   732: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   735: bipush 143
    //   737: aload 12
    //   739: invokevirtual 159	android/telephony/NeighboringCellInfo:getRssi	()I
    //   742: iconst_1
    //   743: ishl
    //   744: iadd
    //   745: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: astore 13
    //   753: ldc 161
    //   755: new 94	java/lang/StringBuilder
    //   758: dup
    //   759: ldc 163
    //   761: invokespecial 166	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   764: aload 12
    //   766: invokevirtual 156	android/telephony/NeighboringCellInfo:getLac	()I
    //   769: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   772: ldc 168
    //   774: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: aload 12
    //   779: invokevirtual 155	android/telephony/NeighboringCellInfo:getCid	()I
    //   782: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   785: ldc 173
    //   787: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: aload 13
    //   792: invokevirtual 171	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 179	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   801: aload_2
    //   802: new 90	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo
    //   805: dup
    //   806: aload_3
    //   807: aload 8
    //   809: new 94	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   816: aload 12
    //   818: invokevirtual 156	android/telephony/NeighboringCellInfo:getLac	()I
    //   821: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   824: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: new 94	java/lang/StringBuilder
    //   830: dup
    //   831: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   834: aload 12
    //   836: invokevirtual 155	android/telephony/NeighboringCellInfo:getCid	()I
    //   839: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   842: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   845: aload 13
    //   847: ldc 131
    //   849: ldc 55
    //   851: ldc 55
    //   853: ldc 55
    //   855: invokespecial 105	com/tencent/mm/sdk/platformtools/PhoneUtil$CellInfo:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   858: invokeinterface 110 2 0
    //   863: pop
    //   864: goto -177 -> 687
    //   867: new 94	java/lang/StringBuilder
    //   870: dup
    //   871: invokespecial 95	java/lang/StringBuilder:<init>	()V
    //   874: getstatic 18	com/tencent/mm/sdk/platformtools/s:b	I
    //   877: invokevirtual 99	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   880: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: astore 20
    //   885: aload 20
    //   887: astore 18
    //   889: goto -269 -> 620
    //   892: astore 9
    //   894: aload 9
    //   896: invokevirtual 116	java/lang/Exception:printStackTrace	()V
    //   899: goto -242 -> 657
    //
    // Exception table:
    //   from	to	target	type
    //   25	31	259	java/lang/Exception
    //   36	63	259	java/lang/Exception
    //   210	216	259	java/lang/Exception
    //   221	248	259	java/lang/Exception
    //   75	84	293	java/lang/Exception
    //   89	98	293	java/lang/Exception
    //   102	208	293	java/lang/Exception
    //   268	286	293	java/lang/Exception
    //   295	304	550	java/lang/Exception
    //   309	323	550	java/lang/Exception
    //   342	379	550	java/lang/Exception
    //   560	569	892	java/lang/Exception
    //   574	588	892	java/lang/Exception
    //   607	616	892	java/lang/Exception
    //   620	657	892	java/lang/Exception
    //   867	885	892	java/lang/Exception
  }

  public final void a(Context paramContext)
  {
    this.c = ((TelephonyManager)paramContext.getSystemService("phone"));
    this.c.listen(this.e, 256);
    this.d = this.c.getPhoneType();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.s
 * JD-Core Version:    0.6.2
 */