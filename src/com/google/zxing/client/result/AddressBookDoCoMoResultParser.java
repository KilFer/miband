package com.google.zxing.client.result;

import com.google.zxing.Result;

public final class AddressBookDoCoMoResultParser extends a
{
  private static String a(String paramString)
  {
    int i = paramString.indexOf(',');
    if (i >= 0)
      paramString = paramString.substring(i + 1) + ' ' + paramString.substring(0, i);
    return paramString;
  }

  public final AddressBookParsedResult parse(Result paramResult)
  {
    String str1 = paramResult.getText();
    if (!str1.startsWith("MECARD:"))
      return null;
    String[] arrayOfString1 = a("N:", str1, true);
    if (arrayOfString1 == null)
      return null;
    String str2 = arrayOfString1[0];
    int i = str2.indexOf(',');
    if (i >= 0);
    for (String str3 = str2.substring(i + 1) + ' ' + str2.substring(0, i); ; str3 = str2)
    {
      String str4 = b("SOUND:", str1, true);
      String[] arrayOfString2 = a("TEL:", str1, true);
      String[] arrayOfString3 = a("EMAIL:", str1, true);
      String str5 = b("NOTE:", str1, false);
      String[] arrayOfString4 = a("ADR:", str1, true);
      String str6 = b("BDAY:", str1, true);
      if ((str6 != null) && (!isStringOfDigits(str6, 8)))
        str6 = null;
      String str7 = b("URL:", str1, true);
      String str8 = b("ORG:", str1, true);
      return new AddressBookParsedResult(maybeWrap(str3), str4, arrayOfString2, null, arrayOfString3, null, null, str5, arrayOfString4, null, str8, str6, null, str7);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.AddressBookDoCoMoResultParser
 * JD-Core Version:    0.6.2
 */