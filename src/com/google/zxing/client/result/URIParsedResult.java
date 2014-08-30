package com.google.zxing.client.result;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIParsedResult extends ParsedResult
{
  private static final Pattern a = Pattern.compile(":/*([^/@]+)@[^/]+");
  private final String b;
  private final String c;

  public URIParsedResult(String paramString1, String paramString2)
  {
    super(ParsedResultType.URI);
    String str1 = paramString1.trim();
    int i = str1.indexOf(':');
    String str2;
    if (i < 0)
      str2 = "http://" + str1;
    while (true)
    {
      this.b = str2;
      this.c = paramString2;
      return;
      if (a(str1, i))
        str2 = "http://" + str1;
      else
        str2 = str1.substring(0, i).toLowerCase(Locale.ENGLISH) + str1.substring(i);
    }
  }

  private static String a(String paramString)
  {
    String str = paramString.trim();
    int i = str.indexOf(':');
    if (i < 0)
      return "http://" + str;
    if (a(str, i))
      return "http://" + str;
    return str.substring(0, i).toLowerCase(Locale.ENGLISH) + str.substring(i);
  }

  private static boolean a(String paramString, int paramInt)
  {
    int i = paramString.indexOf('/', paramInt + 1);
    if (i < 0);
    for (int j = paramString.length(); ; j = i)
    {
      if (j <= paramInt + 1)
        return false;
      for (int k = paramInt + 1; ; k++)
      {
        if (k >= j)
          break label67;
        if ((paramString.charAt(k) < '0') || (paramString.charAt(k) > '9'))
          break;
      }
      label67: return true;
    }
  }

  public final String getDisplayResult()
  {
    StringBuilder localStringBuilder = new StringBuilder(30);
    maybeAppend(this.c, localStringBuilder);
    maybeAppend(this.b, localStringBuilder);
    return localStringBuilder.toString();
  }

  public final String getTitle()
  {
    return this.c;
  }

  public final String getURI()
  {
    return this.b;
  }

  public final boolean isPossiblyMaliciousURI()
  {
    return a.matcher(this.b).find();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.URIParsedResult
 * JD-Core Version:    0.6.2
 */