package com.tencent.stat.common;

public class RC4
{
  private static byte[] a = "03a976511e2cbe3a7f26808fb7af3c05".getBytes();

  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    int[] arrayOfInt1 = new int[256];
    int[] arrayOfInt2 = new int[256];
    int j = paramArrayOfByte2.length;
    if ((j <= 0) || (j > 256))
      throw new IllegalArgumentException("key must be between 1 and 256 bytes");
    for (int k = 0; k < 256; k++)
    {
      arrayOfInt1[k] = k;
      arrayOfInt2[k] = paramArrayOfByte2[(k % j)];
    }
    int m = 0;
    for (int n = 0; n < 256; n++)
    {
      m = 0xFF & m + arrayOfInt1[n] + arrayOfInt2[n];
      int i4 = arrayOfInt1[n];
      arrayOfInt1[n] = arrayOfInt1[m];
      arrayOfInt1[m] = i4;
    }
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int i1 = 0;
    int i2 = 0;
    while (i < paramArrayOfByte1.length)
    {
      i1 = 0xFF & i1 + 1;
      i2 = 0xFF & i2 + arrayOfInt1[i1];
      int i3 = arrayOfInt1[i1];
      arrayOfInt1[i1] = arrayOfInt1[i2];
      arrayOfInt1[i2] = i3;
      arrayOfByte[i] = ((byte)(arrayOfInt1[(0xFF & arrayOfInt1[i1] + arrayOfInt1[i2])] ^ paramArrayOfByte1[i]));
      i++;
    }
    return arrayOfByte;
  }

  private static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2);
  }

  public static byte[] decrypt(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a);
  }

  public static byte[] encrypt(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.stat.common.RC4
 * JD-Core Version:    0.6.2
 */