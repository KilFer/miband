package com.xiaomi.infra.galaxy.common.util;

import com.xiaomi.infra.galaxy.common.BasicGalaxyRequest;
import com.xiaomi.infra.galaxy.common.HttpMethodName;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtils
{
  private static final String DEFAULT_ENCODING = "UTF-8";
  private static final Pattern ENCODED_CHARACTERS_PATTERN = Pattern.compile(localStringBuilder.toString());

  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Pattern.quote("+")).append("|").append(Pattern.quote("*")).append("|").append(Pattern.quote("%7E")).append("|").append(Pattern.quote("%2F"));
  }

  public static String encodeParameters(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    ArrayList localArrayList1;
    if (paramBasicGalaxyRequest.getParameters().size() > 0)
    {
      localArrayList1 = new ArrayList(paramBasicGalaxyRequest.getParameters().size());
      Iterator localIterator = paramBasicGalaxyRequest.getParameters().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        localArrayList1.add(new BasicNameValuePair((String)localEntry.getKey(), (String)localEntry.getValue()));
      }
    }
    for (ArrayList localArrayList2 = localArrayList1; ; localArrayList2 = null)
    {
      if (localArrayList2 != null)
        return URLEncodedUtils.format(localArrayList2, "UTF-8");
      return null;
    }
  }

  public static boolean isUsingNonDefaultPort(URI paramURI)
  {
    String str = paramURI.getScheme().toLowerCase();
    int i = paramURI.getPort();
    if (i <= 0);
    while (((str.equals("http")) && (i == 80)) || ((str.equals("https")) && (i == 443)))
      return false;
    return true;
  }

  public static String urlEncode(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
      return "";
    Matcher localMatcher;
    StringBuffer localStringBuffer;
    while (true)
    {
      String str3;
      try
      {
        String str1 = URLEncoder.encode(paramString, "UTF-8");
        localMatcher = ENCODED_CHARACTERS_PATTERN.matcher(str1);
        localStringBuffer = new StringBuffer(str1.length());
        if (!localMatcher.find())
          break;
        str3 = localMatcher.group(0);
        if ("+".equals(str3))
        {
          str3 = "%20";
          localMatcher.appendReplacement(localStringBuffer, str3);
          continue;
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new RuntimeException(localUnsupportedEncodingException);
      }
      if ("*".equals(str3))
        str3 = "%2A";
      else if ("%7E".equals(str3))
        str3 = "~";
      else if ((paramBoolean) && ("%2F".equals(str3)))
        str3 = "/";
    }
    localMatcher.appendTail(localStringBuffer);
    String str2 = localStringBuffer.toString();
    return str2;
  }

  public static boolean usePayloadForQueryParameters(BasicGalaxyRequest paramBasicGalaxyRequest)
  {
    boolean bool = HttpMethodName.POST.equals(paramBasicGalaxyRequest.getHttpMethod());
    if (paramBasicGalaxyRequest.getContent() == null);
    for (int i = 1; (bool) && (i != 0); i = 0)
      return true;
    return false;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.util.HttpUtils
 * JD-Core Version:    0.6.2
 */