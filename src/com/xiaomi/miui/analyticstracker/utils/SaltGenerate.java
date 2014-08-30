package com.xiaomi.miui.analyticstracker.utils;

import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;

public class SaltGenerate
{
  private static final String a = "8007236f-";
  private static final String b = "a2d6-4847-ac83-";
  private static final String c = "c49395ad6d65";

  private static byte[] a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("UTF-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return paramString.getBytes();
  }

  public static String getKeyFromParams(List<NameValuePair> paramList)
  {
    Collections.sort(paramList, new a());
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramList.iterator();
    for (int i = 1; localIterator.hasNext(); i = 0)
    {
      NameValuePair localNameValuePair = (NameValuePair)localIterator.next();
      if (i == 0)
        localStringBuilder.append("&");
      localStringBuilder.append(localNameValuePair.getName()).append("=").append(localNameValuePair.getValue());
    }
    localStringBuilder.append("&8007236f-");
    localStringBuilder.append("a2d6-4847-ac83-");
    localStringBuilder.append("c49395ad6d65");
    return MD5.getMd5Digest(Base64.encodeToString(a(localStringBuilder.toString()), 2));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.utils.SaltGenerate
 * JD-Core Version:    0.6.2
 */