package com.xiaomi.miui.analyticstracker;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item
{
  private Pattern a;
  private String b;
  private Pattern c;
  private long d;
  private Random e = new Random();

  public Item(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    this.a = Pattern.compile(paramString1);
    this.b = paramString2;
    this.c = Pattern.compile(paramString3);
    this.d = paramLong;
  }

  public String getPolicy()
  {
    return this.b;
  }

  public boolean idMatches(String paramString)
  {
    return this.a.matcher(paramString).matches();
  }

  public boolean isDispatch(String paramString)
  {
    return (this.d >= 1 + this.e.nextInt(100)) && (this.c.matcher(paramString).matches());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.miui.analyticstracker.Item
 * JD-Core Version:    0.6.2
 */