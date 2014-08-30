package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.List;

public final class VEventResultParser extends ResultParser
{
  private static String a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    List localList = VCardResultParser.a(paramCharSequence, paramString, true);
    if ((localList == null) || (localList.isEmpty()))
      return null;
    return (String)localList.get(0);
  }

  public final CalendarParsedResult parse(Result paramResult)
  {
    double d1 = (0.0D / 0.0D);
    String str1 = paramResult.getText();
    if (str1 == null)
      return null;
    if (str1.indexOf("BEGIN:VEVENT") < 0)
      return null;
    String str2 = a("SUMMARY", str1, true);
    String str3 = a("DTSTART", str1, true);
    if (str3 == null)
      return null;
    String str4 = a("DTEND", str1, true);
    String str5 = a("LOCATION", str1, true);
    String str6 = a("DESCRIPTION", str1, true);
    String str7 = a("GEO", str1, true);
    double d2;
    if (str7 == null)
      d2 = d1;
    while (true)
    {
      try
      {
        CalendarParsedResult localCalendarParsedResult = new CalendarParsedResult(str2, str3, str4, str5, null, str6, d2, d1);
        return localCalendarParsedResult;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        return null;
      }
      int i = str7.indexOf(';');
      try
      {
        d2 = Double.parseDouble(str7.substring(0, i));
        double d3 = Double.parseDouble(str7.substring(i + 1));
        d1 = d3;
      }
      catch (NumberFormatException localNumberFormatException)
      {
      }
    }
    return null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.VEventResultParser
 * JD-Core Version:    0.6.2
 */