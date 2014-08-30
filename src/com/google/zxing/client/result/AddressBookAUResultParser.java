package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.List;

public final class AddressBookAUResultParser extends ResultParser
{
  private static String[] a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    int i = 1;
    ArrayList localArrayList = null;
    while (i <= 3)
    {
      String str = b(paramString1 + i + ':', paramString2, '\r', true);
      if (str == null)
        break;
      if (localArrayList == null)
        localArrayList = new ArrayList(3);
      localArrayList.add(str);
      i++;
    }
    if (localArrayList == null)
      return null;
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  public final AddressBookParsedResult parse(Result paramResult)
  {
    String str1 = paramResult.getText();
    if ((!str1.contains("MEMORY")) || (!str1.contains("\r\n")))
      return null;
    String str2 = b("NAME1:", str1, '\r', true);
    String str3 = b("NAME2:", str1, '\r', true);
    String[] arrayOfString1 = a("TEL", 3, str1, true);
    String[] arrayOfString2 = a("MAIL", 3, str1, true);
    String str4 = b("MEMORY:", str1, '\r', false);
    String str5 = b("ADD:", str1, '\r', true);
    if (str5 == null);
    for (String[] arrayOfString3 = null; ; arrayOfString3 = new String[] { str5 })
      return new AddressBookParsedResult(maybeWrap(str2), str3, arrayOfString1, null, arrayOfString2, null, null, str4, arrayOfString3, null, null, null, null, null);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.AddressBookAUResultParser
 * JD-Core Version:    0.6.2
 */