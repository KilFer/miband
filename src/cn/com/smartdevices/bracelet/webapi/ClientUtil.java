package cn.com.smartdevices.bracelet.webapi;

import android.os.SystemClock;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClientUtil
{
  private static String a = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

  public static String encodeStr(String paramString)
  {
    try
    {
      String str = URLEncoder.encode(paramString, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      return null;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }

  public static String encryptPassword(String paramString)
  {
    int i = 10 + new Random(SystemClock.currentThreadTimeMillis()).nextInt(90);
    return md5(new StringBuilder(String.valueOf(i)).append(paramString).toString()) + ":" + i;
  }

  public static String generateBgsid(HashMap<String, String> paramHashMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = paramHashMap.entrySet().iterator();
    Iterator localIterator2;
    if (!localIterator1.hasNext())
    {
      Collections.sort(localArrayList, String.CASE_INSENSITIVE_ORDER);
      localIterator2 = localArrayList.iterator();
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        localStringBuffer.append("c18c24046606b2e084edd37f9fe9f94d");
        return md5(localStringBuffer.toString());
        localArrayList.add((String)((Map.Entry)localIterator1.next()).getKey());
        break;
      }
      localStringBuffer.append((String)paramHashMap.get((String)localIterator2.next()));
    }
  }

  public static long generateCallId()
  {
    return new Date().getTime();
  }

  public static HashMap<String, String> getParamMap(Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(encodeStr("appid"), encodeStr("1uMqYWpHo3MoLH"));
    localHashMap.put(encodeStr("callid"), encodeStr(generateCallId()));
    localHashMap.put(encodeStr("v"), encodeStr("1.0"));
    localHashMap.put(encodeStr("lang"), encodeStr(Locale.getDefault().getLanguage()));
    if (paramMap != null)
      localHashMap.putAll(paramMap);
    localHashMap.put("bd_sig", generateBgsid(localHashMap));
    return localHashMap;
  }

  public static HashMap<String, String> getSysParamMap(Map<String, String> paramMap)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap1.put(encodeStr("appid"), encodeStr("1uMqYWpHo3MoLH"));
    localHashMap1.put(encodeStr("callid"), encodeStr(generateCallId()));
    localHashMap1.put(encodeStr("v"), encodeStr("1.0"));
    localHashMap1.put(encodeStr("lang"), encodeStr(Locale.getDefault().getLanguage()));
    localHashMap2.putAll(localHashMap1);
    if (paramMap != null)
      localHashMap2.putAll(paramMap);
    localHashMap1.put("bd_sig", generateBgsid(localHashMap2));
    return localHashMap1;
  }

  public static boolean isValidEmailAndPassword(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0));
    while ((paramString2 == null) || (paramString2.length() < 6) || (paramString2.length() > 25) || (!Pattern.compile(a).matcher(paramString1).matches()))
      return false;
    return true;
  }

  public static String md5(String paramString)
  {
    while (true)
    {
      byte[] arrayOfByte;
      StringBuilder localStringBuilder;
      int j;
      try
      {
        arrayOfByte = MessageDigest.getInstance("MD5").digest(paramString.getBytes("UTF-8"));
        localStringBuilder = new StringBuilder(arrayOfByte.length << 1);
        int i = arrayOfByte.length;
        j = 0;
        if (j >= i)
          return localStringBuilder.toString();
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        throw new RuntimeException("Huh, MD5 should be supported?", localNoSuchAlgorithmException);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new RuntimeException("Huh, UTF-8 should be supported?", localUnsupportedEncodingException);
      }
      int k = arrayOfByte[j];
      if ((k & 0xFF) < 16)
        localStringBuilder.append("0");
      localStringBuilder.append(Integer.toHexString(k & 0xFF));
      j++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.webapi.ClientUtil
 * JD-Core Version:    0.6.2
 */