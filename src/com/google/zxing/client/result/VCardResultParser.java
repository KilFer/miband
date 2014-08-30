package com.google.zxing.client.result;

import com.google.zxing.Result;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class VCardResultParser extends ResultParser
{
  private static final Pattern a = Pattern.compile("BEGIN:VCARD", 2);
  private static final Pattern b = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");
  private static final Pattern c = Pattern.compile("\r\n[ \t]");
  private static final Pattern d = Pattern.compile("\\\\[nN]");
  private static final Pattern e = Pattern.compile("\\\\([,;\\\\])");
  private static final Pattern f = Pattern.compile("=");
  private static final Pattern g = Pattern.compile(";");

  private static String a(CharSequence paramCharSequence, String paramString)
  {
    int i = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    int j = 0;
    if (j < i)
    {
      char c1 = paramCharSequence.charAt(j);
      switch (c1)
      {
      default:
        a(localByteArrayOutputStream, paramString, localStringBuilder);
        localStringBuilder.append(c1);
      case '\n':
      case '\r':
      case '=':
      }
      while (true)
      {
        j++;
        break;
        if (j < i - 2)
        {
          char c2 = paramCharSequence.charAt(j + 1);
          if ((c2 != '\r') && (c2 != '\n'))
          {
            char c3 = paramCharSequence.charAt(j + 2);
            int k = parseHexDigit(c2);
            int m = parseHexDigit(c3);
            if ((k >= 0) && (m >= 0))
              localByteArrayOutputStream.write(m + (k << 4));
            j += 2;
          }
        }
      }
    }
    a(localByteArrayOutputStream, paramString, localStringBuilder);
    return localStringBuilder.toString();
  }

  private static String a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
      return null;
    return (String)paramList.get(0);
  }

  static List<String> a(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    List localList = b(paramCharSequence, paramString, paramBoolean);
    if ((localList == null) || (localList.isEmpty()))
      return null;
    return (List)localList.get(0);
  }

  private static void a(ByteArrayOutputStream paramByteArrayOutputStream, String paramString, StringBuilder paramStringBuilder)
  {
    byte[] arrayOfByte;
    String str;
    if (paramByteArrayOutputStream.size() > 0)
    {
      arrayOfByte = paramByteArrayOutputStream.toByteArray();
      if (paramString != null)
        break label38;
      str = new String(arrayOfByte);
    }
    while (true)
    {
      paramByteArrayOutputStream.reset();
      paramStringBuilder.append(str);
      return;
      try
      {
        label38: str = new String(arrayOfByte, paramString);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        str = new String(arrayOfByte);
      }
    }
  }

  private static void a(Iterable<List<String>> paramIterable)
  {
    if (paramIterable != null)
    {
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        List localList = (List)localIterator.next();
        String str = (String)localList.get(0);
        String[] arrayOfString = new String[5];
        int i = 0;
        int k;
        for (int j = 0; ; j = k + 1)
        {
          k = str.indexOf(';', j);
          if (k <= 0)
            break;
          arrayOfString[i] = str.substring(j, k);
          i++;
        }
        arrayOfString[i] = str.substring(j);
        StringBuilder localStringBuilder = new StringBuilder(100);
        a(arrayOfString, 3, localStringBuilder);
        a(arrayOfString, 1, localStringBuilder);
        a(arrayOfString, 2, localStringBuilder);
        a(arrayOfString, 0, localStringBuilder);
        a(arrayOfString, 4, localStringBuilder);
        localList.set(0, localStringBuilder.toString().trim());
      }
    }
  }

  private static void a(String[] paramArrayOfString, int paramInt, StringBuilder paramStringBuilder)
  {
    if (paramArrayOfString[paramInt] != null)
    {
      paramStringBuilder.append(' ');
      paramStringBuilder.append(paramArrayOfString[paramInt]);
    }
  }

  private static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (b.matcher(paramCharSequence).matches());
  }

  private static String[] a(Collection<List<String>> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
      return null;
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((List)localIterator.next()).get(0));
    return (String[])localArrayList.toArray(new String[paramCollection.size()]);
  }

  private static List<List<String>> b(CharSequence paramCharSequence, String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList1 = null;
    int i = 0;
    int j = paramString.length();
    int k;
    int m;
    Object localObject;
    int i4;
    label207: ArrayList localArrayList3;
    if (i < j)
    {
      Matcher localMatcher = Pattern.compile("(?:^|\n)" + paramCharSequence + "(?:;([^:]*))?:", 2).matcher(paramString);
      if (i > 0)
        i--;
      if (localMatcher.find(i))
      {
        k = localMatcher.end(0);
        String str1 = localMatcher.group(1);
        ArrayList localArrayList2 = null;
        m = 0;
        localObject = null;
        if (str1 == null)
          break label561;
        String[] arrayOfString1 = g.split(str1);
        int i2 = arrayOfString1.length;
        int i3 = 0;
        if (i3 < i2)
        {
          String str6 = arrayOfString1[i3];
          if (localArrayList2 == null)
            localArrayList2 = new ArrayList(1);
          localArrayList2.add(str6);
          String[] arrayOfString2 = f.split(str6, 2);
          if (arrayOfString2.length <= 1)
            break label554;
          String str7 = arrayOfString2[0];
          String str8 = arrayOfString2[1];
          if (("ENCODING".equalsIgnoreCase(str7)) && ("QUOTED-PRINTABLE".equalsIgnoreCase(str8)));
          for (i4 = 1; ; i4 = m)
          {
            i3++;
            m = i4;
            break;
            if (!"CHARSET".equalsIgnoreCase(str7))
              break label554;
            localObject = str8;
          }
        }
        localArrayList3 = localArrayList2;
      }
    }
    while (true)
    {
      int n = k;
      int i1;
      while (true)
      {
        i1 = paramString.indexOf('\n', n);
        if (i1 < 0)
          break;
        if ((i1 < -1 + paramString.length()) && ((paramString.charAt(i1 + 1) == ' ') || (paramString.charAt(i1 + 1) == '\t')))
        {
          n = i1 + 2;
        }
        else
        {
          if ((m == 0) || ((paramString.charAt(i1 - 1) != '=') && (paramString.charAt(i1 - 2) != '=')))
            break;
          n = i1 + 1;
        }
      }
      if (i1 < 0)
      {
        i = j;
        break;
      }
      if (i1 > k)
      {
        if (localArrayList1 == null)
          localArrayList1 = new ArrayList(1);
        if (paramString.charAt(i1 - 1) == '\r')
          i1--;
        String str2 = paramString.substring(k, i1);
        if (paramBoolean)
          str2 = str2.trim();
        String str5;
        if (m != 0)
        {
          str5 = a(str2, localObject);
          label430: if (localArrayList3 != null)
            break label521;
          ArrayList localArrayList4 = new ArrayList(1);
          localArrayList4.add(str5);
          localArrayList1.add(localArrayList4);
        }
        while (true)
        {
          i = i1 + 1;
          break;
          String str3 = c.matcher(str2).replaceAll("");
          String str4 = d.matcher(str3).replaceAll("\n");
          str5 = e.matcher(str4).replaceAll("$1");
          break label430;
          label521: localArrayList3.add(0, str5);
          localArrayList1.add(localArrayList3);
        }
      }
      i = i1 + 1;
      break;
      return localArrayList1;
      label554: i4 = m;
      break label207;
      label561: localObject = null;
      localArrayList3 = null;
      m = 0;
    }
  }

  private static String[] b(Collection<List<String>> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
      return null;
    ArrayList localArrayList = new ArrayList(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    int i;
    label58: String str;
    int j;
    if (localIterator.hasNext())
    {
      List localList = (List)localIterator.next();
      i = 1;
      if (i >= localList.size())
        break label163;
      str = (String)localList.get(i);
      j = str.indexOf('=');
      if (j >= 0);
    }
    while (true)
    {
      localArrayList.add(str);
      break;
      if ("TYPE".equalsIgnoreCase(str.substring(0, j)))
      {
        str = str.substring(j + 1);
      }
      else
      {
        i++;
        break label58;
        return (String[])localArrayList.toArray(new String[paramCollection.size()]);
        label163: str = null;
      }
    }
  }

  public final AddressBookParsedResult parse(Result paramResult)
  {
    String str1 = paramResult.getText();
    Matcher localMatcher = a.matcher(str1);
    if ((!localMatcher.find()) || (localMatcher.start() != 0))
      return null;
    List localList1 = b("FN", str1, true);
    List localList14;
    if (localList1 == null)
    {
      localList14 = b("N", str1, true);
      if (localList14 != null)
      {
        Iterator localIterator2 = localList14.iterator();
        while (localIterator2.hasNext())
        {
          List localList15 = (List)localIterator2.next();
          String str2 = (String)localList15.get(0);
          String[] arrayOfString = new String[5];
          int j = 0;
          int k = 0;
          while (true)
          {
            int m = str2.indexOf(';', j);
            if (m <= 0)
              break;
            arrayOfString[k] = str2.substring(j, m);
            k++;
            j = m + 1;
          }
          arrayOfString[k] = str2.substring(j);
          StringBuilder localStringBuilder = new StringBuilder(100);
          a(arrayOfString, 3, localStringBuilder);
          a(arrayOfString, 1, localStringBuilder);
          a(arrayOfString, 2, localStringBuilder);
          a(arrayOfString, 0, localStringBuilder);
          a(arrayOfString, 4, localStringBuilder);
          localList15.set(0, localStringBuilder.toString().trim());
        }
      }
    }
    for (List localList2 = localList14; ; localList2 = localList1)
    {
      List localList3 = b("TEL", str1, true);
      List localList4 = b("EMAIL", str1, true);
      List localList5 = a("NOTE", str1, false);
      List localList6 = b("ADR", str1, true);
      if (localList6 != null)
      {
        Iterator localIterator1 = localList6.iterator();
        while (localIterator1.hasNext())
        {
          List localList13 = (List)localIterator1.next();
          localList13.set(0, localList13.get(0));
        }
      }
      List localList7 = a("ORG", str1, true);
      List localList8 = a("BDAY", str1, true);
      int i;
      if (localList8 != null)
      {
        CharSequence localCharSequence = (CharSequence)localList8.get(0);
        if ((localCharSequence == null) || (b.matcher(localCharSequence).matches()))
        {
          i = 1;
          if (i != 0)
            break label518;
        }
      }
      label518: for (List localList9 = null; ; localList9 = localList8)
      {
        List localList10 = a("TITLE", str1, true);
        List localList11 = a("URL", str1, true);
        List localList12 = a("IMPP", str1, true);
        return new AddressBookParsedResult(a(localList2), null, a(localList3), b(localList3), a(localList4), b(localList4), a(localList12), a(localList5), a(localList6), b(localList6), a(localList7), a(localList9), a(localList10), a(localList11));
        i = 0;
        break;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.client.result.VCardResultParser
 * JD-Core Version:    0.6.2
 */