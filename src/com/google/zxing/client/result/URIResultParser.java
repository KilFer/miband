package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class URIResultParser extends ResultParser
{
  private static final String a = "(:\\d{1,5})?(/|\\?|$)";
  private static final Pattern b = Pattern.compile("[a-zA-Z0-9]{2,}://[a-zA-Z0-9\\-]+(\\.[a-zA-Z0-9\\-]+)*(:\\d{1,5})?(/|\\?|$)");
  private static final Pattern c = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z0-9\\-]{2,}(:\\d{1,5})?(/|\\?|$)");

  static boolean a(CharSequence paramCharSequence)
  {
    Matcher localMatcher1 = b.matcher(paramCharSequence);
    if ((localMatcher1.find()) && (localMatcher1.start() == 0));
    Matcher localMatcher2;
    do
    {
      return true;
      localMatcher2 = c.matcher(paramCharSequence);
    }
    while ((localMatcher2.find()) && (localMatcher2.start() == 0));
    return false;
  }

  public final URIParsedResult parse(Result paramResult)
  {
    String str1 = paramResult.getText();
    if (str1.startsWith("URL:"))
      str1 = str1.substring(4);
    String str2 = str1.trim();
    if (a(str2))
      return new URIParsedResult(str2, null);
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.URIResultParser
 * JD-Core Version:    0.6.2
 */