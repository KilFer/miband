package com.tencent.b.b;

public final class u
{
  public byte[] a;
  public String b = "GBK";

  public final String toString()
  {
    try
    {
      String str = new String(this.a, this.b);
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.b.b.u
 * JD-Core Version:    0.6.2
 */