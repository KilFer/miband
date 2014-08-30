package com.tencent.mm.algorithm;

public class UIN extends Number
{
  private int a = 0;

  public UIN(int paramInt)
  {
    this.a = paramInt;
  }

  public UIN(long paramLong)
  {
    this.a = ((int)paramLong);
  }

  public static int valueOf(String paramString)
  {
    try
    {
      int i = new UIN(Long.valueOf(paramString).longValue()).intValue();
      return i;
    }
    catch (Exception localException)
    {
    }
    return 0;
  }

  public double doubleValue()
  {
    return 0.0D + this.a;
  }

  public float floatValue()
  {
    return (float)(0.0D + this.a);
  }

  public int intValue()
  {
    return this.a;
  }

  public long longValue()
  {
    return 0xFFFFFFFF & this.a;
  }

  public String toString()
  {
    return String.valueOf(0xFFFFFFFF & this.a);
  }

  public int value()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.algorithm.UIN
 * JD-Core Version:    0.6.2
 */