package com.tencent.stat.common;

public class StatBase64
{
  static
  {
    if (!StatBase64.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      return;
    }
  }

  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }

  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    d locald = new d(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!locald.a(paramArrayOfByte, paramInt1, paramInt2, true))
      throw new IllegalArgumentException("bad base-64");
    if (locald.b == locald.a.length)
      return locald.a;
    byte[] arrayOfByte = new byte[locald.b];
    System.arraycopy(locald.a, 0, arrayOfByte, 0, locald.b);
    return arrayOfByte;
  }

  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }

  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    e locale = new e(paramInt3, null);
    int i = paramInt2 / 3 << 2;
    int j;
    if (locale.c)
    {
      if (paramInt2 % 3 > 0)
        i += 4;
      if ((locale.d) && (paramInt2 > 0))
      {
        j = 1 + (paramInt2 - 1) / 57;
        if (!locale.e)
          break label167;
      }
    }
    label167: for (int k = 2; ; k = 1)
    {
      i += k * j;
      locale.a = new byte[i];
      locale.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((a) || (locale.b == i))
        break label173;
      throw new AssertionError();
      switch (paramInt2 % 3)
      {
      case 0:
      default:
        break;
      case 1:
        i += 2;
        break;
      case 2:
        i += 3;
        break;
      }
    }
    label173: return locale.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.StatBase64
 * JD-Core Version:    0.6.2
 */