package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.List;

public final class BizcardResultParser extends a
{
  private static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return paramString2;
    if (paramString2 == null)
      return paramString1;
    return paramString1 + ' ' + paramString2;
  }

  private static String[] a(String paramString1, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList(3);
    if (paramString1 != null)
      localArrayList.add(paramString1);
    if (paramString2 != null)
      localArrayList.add(paramString2);
    if (paramString3 != null)
      localArrayList.add(paramString3);
    int i = localArrayList.size();
    if (i == 0)
      return null;
    return (String[])localArrayList.toArray(new String[i]);
  }

  public final AddressBookParsedResult parse(Result paramResult)
  {
    String str1 = paramResult.getText();
    if (!str1.startsWith("BIZCARD:"))
      return null;
    Object localObject = b("N:", str1, true);
    String str2 = b("X:", str1, true);
    String str3;
    String str4;
    String[] arrayOfString1;
    String str8;
    String[] arrayOfString2;
    ArrayList localArrayList;
    int i;
    if (localObject == null)
    {
      localObject = str2;
      str3 = b("T:", str1, true);
      str4 = b("C:", str1, true);
      arrayOfString1 = a("A:", str1, true);
      String str5 = b("B:", str1, true);
      String str6 = b("M:", str1, true);
      String str7 = b("F:", str1, true);
      str8 = b("E:", str1, true);
      arrayOfString2 = maybeWrap((String)localObject);
      localArrayList = new ArrayList(3);
      if (str5 != null)
        localArrayList.add(str5);
      if (str6 != null)
        localArrayList.add(str6);
      if (str7 != null)
        localArrayList.add(str7);
      i = localArrayList.size();
      if (i != 0)
        break label245;
    }
    label245: for (String[] arrayOfString3 = null; ; arrayOfString3 = (String[])localArrayList.toArray(new String[i]))
    {
      return new AddressBookParsedResult(arrayOfString2, null, arrayOfString3, null, maybeWrap(str8), null, null, null, arrayOfString1, null, str4, null, str3, null);
      if (str2 == null)
        break;
      localObject = (String)localObject + ' ' + str2;
      break;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.BizcardResultParser
 * JD-Core Version:    0.6.2
 */