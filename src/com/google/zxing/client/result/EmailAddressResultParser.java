package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.Map;

public final class EmailAddressResultParser extends ResultParser
{
  public final EmailAddressParsedResult parse(Result paramResult)
  {
    String str1 = paramResult.getText();
    String str2;
    Map localMap;
    String str3;
    String str4;
    if ((str1.startsWith("mailto:")) || (str1.startsWith("MAILTO:")))
    {
      str2 = str1.substring(7);
      int i = str2.indexOf('?');
      if (i >= 0)
        str2 = str2.substring(0, i);
      localMap = b(str1);
      if (localMap == null)
        break label177;
      if (str2.length() != 0)
        break label171;
      str3 = (String)localMap.get("to");
      str4 = (String)localMap.get("subject");
    }
    for (String str5 = (String)localMap.get("body"); ; str5 = null)
    {
      EmailAddressParsedResult localEmailAddressParsedResult = new EmailAddressParsedResult(str3, str4, str5, str1);
      boolean bool;
      do
      {
        return localEmailAddressParsedResult;
        bool = EmailDoCoMoResultParser.a(str1);
        localEmailAddressParsedResult = null;
      }
      while (!bool);
      return new EmailAddressParsedResult(str1, null, null, "mailto:" + str1);
      label171: str3 = str2;
      break;
      label177: str3 = str2;
      str4 = null;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.EmailAddressResultParser
 * JD-Core Version:    0.6.2
 */