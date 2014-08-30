package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class GeoResultParser extends ResultParser
{
  private static final Pattern a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

  public final GeoParsedResult parse(Result paramResult)
  {
    double d1 = 0.0D;
    String str1 = paramResult.getText();
    if (str1 == null);
    while (true)
    {
      return null;
      Matcher localMatcher = a.matcher(str1);
      if (localMatcher.matches())
      {
        String str2 = localMatcher.group(4);
        try
        {
          double d2 = Double.parseDouble(localMatcher.group(1));
          if ((d2 <= 90.0D) && (d2 >= -90.0D))
          {
            double d3 = Double.parseDouble(localMatcher.group(2));
            if ((d3 <= 180.0D) && (d3 >= -180.0D))
            {
              String str3 = localMatcher.group(3);
              if (str3 == null);
              while (true)
              {
                return new GeoParsedResult(d2, d3, d1, str2);
                double d4 = Double.parseDouble(localMatcher.group(3));
                if (d4 < d1)
                  break;
                d1 = d4;
              }
            }
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
        }
      }
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.GeoResultParser
 * JD-Core Version:    0.6.2
 */