package com.xiaomi.market.sdk;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class h
{
  private TreeMap a = new TreeMap();

  public h(c paramc)
  {
    this(paramc, true);
  }

  public h(c paramc, boolean paramBoolean)
  {
    if (paramBoolean)
      paramc.x = this;
  }

  public h a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.put(paramString, "true");
      return this;
    }
    this.a.put(paramString, "false");
    return this;
  }

  public h d(String paramString1, String paramString2)
  {
    if (paramString2 == null)
      paramString2 = "";
    this.a.put(paramString1, paramString2);
    return this;
  }

  public String get(String paramString)
  {
    return (String)this.a.get(paramString);
  }

  public boolean isEmpty()
  {
    return this.a.isEmpty();
  }

  public TreeMap j()
  {
    return this.a;
  }

  public String toString()
  {
    if (this.a.isEmpty())
      return "";
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.a.keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
        return localStringBuilder.deleteCharAt(-1 + localStringBuilder.length()).toString();
      String str = (String)localIterator.next();
      localStringBuilder.append(str);
      localStringBuilder.append("=");
      try
      {
        localStringBuilder.append(URLEncoder.encode((String)this.a.get(str), "UTF-8"));
        label101: localStringBuilder.append("&");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        break label101;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.h
 * JD-Core Version:    0.6.2
 */