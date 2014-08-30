package com.nostra13.universalimageloader.utils;

import java.util.Comparator;

final class b
  implements Comparator<String>
{
  private static int a(String paramString1, String paramString2)
  {
    return paramString1.substring(0, paramString1.lastIndexOf("_")).compareTo(paramString2.substring(0, paramString2.lastIndexOf("_")));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.b
 * JD-Core Version:    0.6.2
 */