package com.tencent.stat.event;

import java.util.Arrays;
import java.util.Properties;

public class CustomEvent$Key
{
  String a;
  String[] b;
  Properties c = null;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Key localKey;
    int i;
    label81: 
    do
    {
      return true;
      if (!(paramObject instanceof Key))
        break;
      localKey = (Key)paramObject;
      if ((this.a.equals(localKey.a)) && (Arrays.equals(this.b, localKey.b)));
      for (i = 1; ; i = 0)
      {
        if (this.c == null)
          break label81;
        if ((i != 0) && (this.c.equals(localKey.c)))
          break;
        return false;
      }
    }
    while ((i != 0) && (localKey.c == null));
    return false;
    return false;
  }

  public int hashCode()
  {
    String str = this.a;
    int i = 0;
    if (str != null)
      i = this.a.hashCode();
    if (this.b != null)
      i ^= Arrays.hashCode(this.b);
    if (this.c != null)
      i ^= this.c.hashCode();
    return i;
  }

  public String toString()
  {
    String str1 = this.a;
    String str2 = "";
    if (this.b != null)
    {
      String str3 = this.b[0];
      for (int i = 1; i < this.b.length; i++)
        str3 = str3 + "," + this.b[i];
      str2 = "[" + str3 + "]";
    }
    if (this.c != null)
      str2 = str2 + this.c.toString();
    return str1 + str2;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.event.CustomEvent.Key
 * JD-Core Version:    0.6.2
 */