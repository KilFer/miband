package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class KVConfig
{
  private static boolean a = false;

  private static void a(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() <= 0))
      Log.v("MicroMsg.SDK.KVConfig", "empty values");
    while (true)
    {
      return;
      Iterator localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Log.v("MicroMsg.SDK.KVConfig", "key=" + (String)localEntry.getKey() + " value=" + (String)localEntry.getValue());
      }
    }
  }

  private static void a(Map<String, String> paramMap, String paramString, Node paramNode, int paramInt)
  {
    int i = 0;
    if (paramNode.getNodeName().equals("#text"))
      paramMap.put(paramString, paramNode.getNodeValue());
    while (true)
    {
      return;
      if (paramNode.getNodeName().equals("#cdata-section"))
      {
        paramMap.put(paramString, paramNode.getNodeValue());
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder().append(paramString).append(".").append(paramNode.getNodeName());
      if (paramInt > 0);
      String str;
      for (Object localObject = Integer.valueOf(paramInt); ; localObject = "")
      {
        str = localObject;
        paramMap.put(str, paramNode.getNodeValue());
        NamedNodeMap localNamedNodeMap = paramNode.getAttributes();
        if (localNamedNodeMap == null)
          break;
        for (int k = 0; k < localNamedNodeMap.getLength(); k++)
        {
          Node localNode2 = localNamedNodeMap.item(k);
          paramMap.put(str + ".$" + localNode2.getNodeName(), localNode2.getNodeValue());
        }
      }
      HashMap localHashMap = new HashMap();
      NodeList localNodeList = paramNode.getChildNodes();
      while (i < localNodeList.getLength())
      {
        Node localNode1 = localNodeList.item(i);
        int j = Util.nullAsNil((Integer)localHashMap.get(localNode1.getNodeName()));
        a(paramMap, str, localNode1, j);
        localHashMap.put(localNode1.getNodeName(), Integer.valueOf(j + 1));
        i++;
      }
    }
  }

  public static Map<String, String> parseIni(String paramString)
  {
    Object localObject;
    if ((paramString == null) || (paramString.length() <= 0))
      localObject = null;
    while (true)
    {
      return localObject;
      localObject = new HashMap();
      for (String str1 : paramString.split("\n"))
        if ((str1 != null) && (str1.length() > 0))
        {
          String[] arrayOfString2 = str1.trim().split("=", 2);
          if ((arrayOfString2 != null) && (arrayOfString2.length >= 2))
          {
            String str2 = arrayOfString2[0];
            String str3 = arrayOfString2[1];
            if ((str2 != null) && (str2.length() > 0) && (str2.matches("^[a-zA-Z0-9_]*")))
              ((Map)localObject).put(str2, str3);
          }
        }
    }
  }

  // ERROR //
  public static Map<String, String> parseXml(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +18 -> 19
    //   4: iconst_m1
    //   5: istore_3
    //   6: iload_3
    //   7: ifge +22 -> 29
    //   10: ldc 22
    //   12: ldc 190
    //   14: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: bipush 60
    //   22: invokevirtual 197	java/lang/String:indexOf	(I)I
    //   25: istore_3
    //   26: goto -20 -> 6
    //   29: iload_3
    //   30: ifle +32 -> 62
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: astore 17
    //   39: aload 17
    //   41: iconst_0
    //   42: iload_3
    //   43: invokestatic 107	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: aastore
    //   47: ldc 22
    //   49: ldc 199
    //   51: aload 17
    //   53: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   56: aload_0
    //   57: iload_3
    //   58: invokevirtual 207	java/lang/String:substring	(I)Ljava/lang/String;
    //   61: astore_0
    //   62: aload_0
    //   63: ifnull -46 -> 17
    //   66: aload_0
    //   67: invokevirtual 156	java/lang/String:length	()I
    //   70: ifle -53 -> 17
    //   73: new 129	java/util/HashMap
    //   76: dup
    //   77: invokespecial 130	java/util/HashMap:<init>	()V
    //   80: astore 4
    //   82: invokestatic 213	javax/xml/parsers/DocumentBuilderFactory:newInstance	()Ljavax/xml/parsers/DocumentBuilderFactory;
    //   85: astore 5
    //   87: aload 5
    //   89: invokevirtual 217	javax/xml/parsers/DocumentBuilderFactory:newDocumentBuilder	()Ljavax/xml/parsers/DocumentBuilder;
    //   92: astore 7
    //   94: aload 7
    //   96: ifnonnull +21 -> 117
    //   99: ldc 22
    //   101: ldc 219
    //   103: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aconst_null
    //   107: areturn
    //   108: astore 6
    //   110: aload 6
    //   112: invokevirtual 222	javax/xml/parsers/ParserConfigurationException:printStackTrace	()V
    //   115: aconst_null
    //   116: areturn
    //   117: new 224	org/xml/sax/InputSource
    //   120: dup
    //   121: new 226	java/io/ByteArrayInputStream
    //   124: dup
    //   125: aload_0
    //   126: invokevirtual 230	java/lang/String:getBytes	()[B
    //   129: invokespecial 233	java/io/ByteArrayInputStream:<init>	([B)V
    //   132: invokespecial 236	org/xml/sax/InputSource:<init>	(Ljava/io/InputStream;)V
    //   135: astore 8
    //   137: aload_2
    //   138: ifnull +9 -> 147
    //   141: aload 8
    //   143: aload_2
    //   144: invokevirtual 239	org/xml/sax/InputSource:setEncoding	(Ljava/lang/String;)V
    //   147: aload 7
    //   149: aload 8
    //   151: invokevirtual 245	javax/xml/parsers/DocumentBuilder:parse	(Lorg/xml/sax/InputSource;)Lorg/w3c/dom/Document;
    //   154: astore 16
    //   156: aload 16
    //   158: astore 13
    //   160: aload 13
    //   162: invokeinterface 250 1 0
    //   167: aload 13
    //   169: ifnonnull +52 -> 221
    //   172: ldc 22
    //   174: ldc 252
    //   176: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aconst_null
    //   180: areturn
    //   181: astore 12
    //   183: aconst_null
    //   184: astore 13
    //   186: aload 12
    //   188: invokevirtual 253	org/w3c/dom/DOMException:printStackTrace	()V
    //   191: goto -24 -> 167
    //   194: astore 11
    //   196: aload 11
    //   198: invokevirtual 254	org/xml/sax/SAXException:printStackTrace	()V
    //   201: aconst_null
    //   202: areturn
    //   203: astore 10
    //   205: aload 10
    //   207: invokevirtual 255	java/io/IOException:printStackTrace	()V
    //   210: aconst_null
    //   211: areturn
    //   212: astore 9
    //   214: aload 9
    //   216: invokevirtual 256	java/lang/Exception:printStackTrace	()V
    //   219: aconst_null
    //   220: areturn
    //   221: aload 13
    //   223: invokeinterface 260 1 0
    //   228: astore 14
    //   230: aload 14
    //   232: ifnonnull +13 -> 245
    //   235: ldc 22
    //   237: ldc_w 262
    //   240: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aconst_null
    //   244: areturn
    //   245: aload_1
    //   246: ifnull +30 -> 276
    //   249: aload_1
    //   250: aload 14
    //   252: invokeinterface 265 1 0
    //   257: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   260: ifeq +16 -> 276
    //   263: aload 4
    //   265: ldc 127
    //   267: aload 14
    //   269: iconst_0
    //   270: invokestatic 150	com/tencent/mm/sdk/platformtools/KVConfig:a	(Ljava/util/Map;Ljava/lang/String;Lorg/w3c/dom/Node;I)V
    //   273: aload 4
    //   275: areturn
    //   276: aload 14
    //   278: aload_1
    //   279: invokeinterface 269 2 0
    //   284: astore 15
    //   286: aload 15
    //   288: invokeinterface 137 1 0
    //   293: ifgt +13 -> 306
    //   296: ldc 22
    //   298: ldc_w 271
    //   301: invokestatic 193	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: aconst_null
    //   305: areturn
    //   306: aload 15
    //   308: invokeinterface 137 1 0
    //   313: iconst_1
    //   314: if_icmple +11 -> 325
    //   317: ldc 22
    //   319: ldc_w 273
    //   322: invokestatic 275	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload 4
    //   327: ldc 127
    //   329: aload 15
    //   331: iconst_0
    //   332: invokeinterface 138 2 0
    //   337: iconst_0
    //   338: invokestatic 150	com/tencent/mm/sdk/platformtools/KVConfig:a	(Ljava/util/Map;Ljava/lang/String;Lorg/w3c/dom/Node;I)V
    //   341: goto -68 -> 273
    //   344: astore 12
    //   346: goto -160 -> 186
    //
    // Exception table:
    //   from	to	target	type
    //   87	94	108	javax/xml/parsers/ParserConfigurationException
    //   117	137	181	org/w3c/dom/DOMException
    //   141	147	181	org/w3c/dom/DOMException
    //   147	156	181	org/w3c/dom/DOMException
    //   117	137	194	org/xml/sax/SAXException
    //   141	147	194	org/xml/sax/SAXException
    //   147	156	194	org/xml/sax/SAXException
    //   160	167	194	org/xml/sax/SAXException
    //   117	137	203	java/io/IOException
    //   141	147	203	java/io/IOException
    //   147	156	203	java/io/IOException
    //   160	167	203	java/io/IOException
    //   117	137	212	java/lang/Exception
    //   141	147	212	java/lang/Exception
    //   147	156	212	java/lang/Exception
    //   160	167	212	java/lang/Exception
    //   160	167	344	org/w3c/dom/DOMException
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.KVConfig
 * JD-Core Version:    0.6.2
 */