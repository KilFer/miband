package com.xiaomi.channel.openauth;

import java.util.Comparator;
import org.apache.http.NameValuePair;

final class c
  implements Comparator<NameValuePair>
{
  private static int a(NameValuePair paramNameValuePair1, NameValuePair paramNameValuePair2)
  {
    return paramNameValuePair1.getName().compareTo(paramNameValuePair2.getName());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.c
 * JD-Core Version:    0.6.2
 */