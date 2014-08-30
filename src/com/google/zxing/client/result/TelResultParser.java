package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class TelResultParser extends ResultParser
{
  public final TelParsedResult parse(Result paramResult)
  {
    String str1 = paramResult.getText();
    if ((!str1.startsWith("tel:")) && (!str1.startsWith("TEL:")))
      return null;
    String str2;
    int i;
    if (str1.startsWith("TEL:"))
    {
      str2 = "tel:" + str1.substring(4);
      i = str1.indexOf('?', 4);
      if (i >= 0)
        break label93;
    }
    label93: for (String str3 = str1.substring(4); ; str3 = str1.substring(4, i))
    {
      return new TelParsedResult(str3, str2, null);
      str2 = str1;
      break;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.TelResultParser
 * JD-Core Version:    0.6.2
 */