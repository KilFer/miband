package com.google.gson.internal;

import java.math.BigDecimal;

public final class LazilyParsedNumber extends Number
{
  private final String a;

  public LazilyParsedNumber(String paramString)
  {
    this.a = paramString;
  }

  private Object writeReplace()
  {
    return new BigDecimal(this.a);
  }

  public final double doubleValue()
  {
    return Double.parseDouble(this.a);
  }

  public final float floatValue()
  {
    return Float.parseFloat(this.a);
  }

  public final int intValue()
  {
    try
    {
      int i = Integer.parseInt(this.a);
      return i;
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      try
      {
        long l = Long.parseLong(this.a);
        return (int)l;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
      }
    }
    return new BigDecimal(this.a).intValue();
  }

  public final long longValue()
  {
    try
    {
      long l = Long.parseLong(this.a);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return new BigDecimal(this.a).longValue();
  }

  public final String toString()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.LazilyParsedNumber
 * JD-Core Version:    0.6.2
 */