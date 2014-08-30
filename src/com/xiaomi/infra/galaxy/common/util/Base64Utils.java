package com.xiaomi.infra.galaxy.common.util;

import java.io.ByteArrayOutputStream;

public class Base64Utils
{
  private static byte[] base64DecodeChars = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
  private static char[] base64EncodeChars = { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };

  public static byte[] decode(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(i);
    int j = 0;
    if (j < i);
    while (true)
    {
      byte[] arrayOfByte1 = base64DecodeChars;
      int k = j + 1;
      int m = arrayOfByte1[paramArrayOfByte[j]];
      if ((k >= i) || (m != -1))
      {
        if (m != -1);
        while (true)
        {
          byte[] arrayOfByte2 = base64DecodeChars;
          int n = k + 1;
          int i1 = arrayOfByte2[paramArrayOfByte[k]];
          if ((n >= i) || (i1 != -1))
          {
            if (i1 != -1)
              localByteArrayOutputStream.write(m << 2 | (i1 & 0x30) >>> 4);
            while (true)
            {
              int i2 = n + 1;
              int i3 = paramArrayOfByte[n];
              if (i3 == 61)
                return localByteArrayOutputStream.toByteArray();
              int i4 = base64DecodeChars[i3];
              if ((i2 >= i) || (i4 != -1))
              {
                if (i4 != -1)
                  localByteArrayOutputStream.write((i1 & 0xF) << 4 | (i4 & 0x3C) >>> 2);
                while (true)
                {
                  j = i2 + 1;
                  int i5 = paramArrayOfByte[i2];
                  if (i5 == 61)
                    return localByteArrayOutputStream.toByteArray();
                  int i6 = base64DecodeChars[i5];
                  if ((j >= i) || (i6 != -1))
                  {
                    if (i6 != -1)
                    {
                      localByteArrayOutputStream.write(i6 | (i4 & 0x3) << 6);
                      break;
                    }
                    return localByteArrayOutputStream.toByteArray();
                  }
                  i2 = j;
                }
              }
              n = i2;
            }
          }
          k = n;
        }
      }
      j = k;
    }
  }

  public static String encode(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = paramArrayOfByte.length;
    int j = 0;
    while (true)
    {
      int k;
      int m;
      if (j < i)
      {
        k = j + 1;
        m = 0xFF & paramArrayOfByte[j];
        if (k != i)
          break label78;
        localStringBuffer.append(base64EncodeChars[(m >>> 2)]);
        localStringBuffer.append(base64EncodeChars[((m & 0x3) << 4)]);
        localStringBuffer.append("==");
      }
      label78: int n;
      int i1;
      while (true)
      {
        return localStringBuffer.toString();
        n = k + 1;
        i1 = 0xFF & paramArrayOfByte[k];
        if (n != i)
          break;
        localStringBuffer.append(base64EncodeChars[(m >>> 2)]);
        localStringBuffer.append(base64EncodeChars[((m & 0x3) << 4 | (i1 & 0xF0) >>> 4)]);
        localStringBuffer.append(base64EncodeChars[((i1 & 0xF) << 2)]);
        localStringBuffer.append("=");
      }
      j = n + 1;
      int i2 = 0xFF & paramArrayOfByte[n];
      localStringBuffer.append(base64EncodeChars[(m >>> 2)]);
      localStringBuffer.append(base64EncodeChars[((m & 0x3) << 4 | (i1 & 0xF0) >>> 4)]);
      localStringBuffer.append(base64EncodeChars[((i1 & 0xF) << 2 | (i2 & 0xC0) >>> 6)]);
      localStringBuffer.append(base64EncodeChars[(i2 & 0x3F)]);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.util.Base64Utils
 * JD-Core Version:    0.6.2
 */