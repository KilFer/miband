package com.xiaomi.channel.openauth.utils;

public class Base64Coder
{
  private static final String a = System.getProperty("line.separator");
  private static char[] b = new char[64];
  private static byte[] c;

  static
  {
    int i = 65;
    int j = 0;
    int m;
    label30: int i1;
    label41: int i4;
    label83: int i6;
    if (i > 90)
    {
      m = 97;
      if (m <= 122)
        break label129;
      i1 = 48;
      if (i1 <= 57)
        break label158;
      char[] arrayOfChar4 = b;
      int i3 = j + 1;
      arrayOfChar4[j] = '+';
      b[i3] = '/';
      c = new byte[''];
      i4 = 0;
      int i5 = c.length;
      i6 = 0;
      if (i4 < i5)
        break label187;
    }
    while (true)
    {
      if (i6 >= 64)
      {
        return;
        char[] arrayOfChar1 = b;
        int k = j + 1;
        arrayOfChar1[j] = i;
        i = (char)(i + 1);
        j = k;
        break;
        label129: char[] arrayOfChar2 = b;
        int n = j + 1;
        arrayOfChar2[j] = m;
        m = (char)(m + 1);
        j = n;
        break label30;
        label158: char[] arrayOfChar3 = b;
        int i2 = j + 1;
        arrayOfChar3[j] = i1;
        i1 = (char)(i1 + 1);
        j = i2;
        break label41;
        label187: c[i4] = -1;
        i4++;
        break label83;
      }
      c[b[i6]] = ((byte)i6);
      i6++;
    }
  }

  public static byte[] decode(String paramString)
  {
    return decode(paramString.toCharArray());
  }

  public static byte[] decode(char[] paramArrayOfChar)
  {
    return decode(paramArrayOfChar, 0, paramArrayOfChar.length);
  }

  public static byte[] decode(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    if (paramInt2 % 4 != 0)
      throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
    while ((paramInt2 > 0) && (paramArrayOfChar[(-1 + (paramInt1 + paramInt2))] == '='))
      paramInt2--;
    int i = paramInt2 * 3 / 4;
    byte[] arrayOfByte = new byte[i];
    int j = paramInt1 + paramInt2;
    int k = paramInt1;
    int m = 0;
    if (k >= j)
      return arrayOfByte;
    int n = k + 1;
    int i1 = paramArrayOfChar[k];
    int i2 = n + 1;
    int i3 = paramArrayOfChar[n];
    int i4;
    int i5;
    if (i2 < j)
    {
      int i17 = i2 + 1;
      i4 = paramArrayOfChar[i2];
      i2 = i17;
      if (i2 >= j)
        break label182;
      int i16 = i2 + 1;
      i5 = paramArrayOfChar[i2];
      k = i16;
    }
    while (true)
    {
      if ((i1 <= 127) && (i3 <= 127) && (i4 <= 127) && (i5 <= 127))
        break label193;
      throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
      i4 = 65;
      break;
      label182: k = i2;
      i5 = 65;
    }
    label193: int i6 = c[i1];
    int i7 = c[i3];
    int i8 = c[i4];
    int i9 = c[i5];
    if ((i6 < 0) || (i7 < 0) || (i8 < 0) || (i9 < 0))
      throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
    int i10 = i6 << 2 | i7 >>> 4;
    int i11 = (i7 & 0xF) << 4 | i8 >>> 2;
    int i12 = i9 | (i8 & 0x3) << 6;
    int i13 = m + 1;
    arrayOfByte[m] = ((byte)i10);
    int i14;
    if (i13 < i)
    {
      i14 = i13 + 1;
      arrayOfByte[i13] = ((byte)i11);
    }
    while (true)
    {
      if (i14 < i)
      {
        int i15 = i14 + 1;
        arrayOfByte[i14] = ((byte)i12);
        m = i15;
        break;
      }
      m = i14;
      break;
      i14 = i13;
    }
  }

  public static byte[] decodeLines(String paramString)
  {
    char[] arrayOfChar = new char[paramString.length()];
    int i = 0;
    int j = 0;
    while (true)
    {
      if (i >= paramString.length())
        return decode(arrayOfChar, 0, j);
      int k = paramString.charAt(i);
      if ((k != 32) && (k != 13) && (k != 10) && (k != 9))
      {
        int m = j + 1;
        arrayOfChar[j] = k;
        j = m;
      }
      i++;
    }
  }

  public static String decodeString(String paramString)
  {
    return new String(decode(paramString));
  }

  public static char[] encode(byte[] paramArrayOfByte)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public static char[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramInt);
  }

  public static char[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = (2 + (paramInt2 << 2)) / 3;
    char[] arrayOfChar = new char[(paramInt2 + 2) / 3 << 2];
    int j = paramInt1 + paramInt2;
    int k = 0;
    if (paramInt1 >= j)
      return arrayOfChar;
    int m = paramInt1 + 1;
    int n = 0xFF & paramArrayOfByte[paramInt1];
    int i1;
    label77: int i2;
    int i3;
    label100: int i7;
    int i10;
    label189: int i11;
    if (m < j)
    {
      int i14 = m + 1;
      i1 = 0xFF & paramArrayOfByte[m];
      m = i14;
      if (m >= j)
        break label245;
      i2 = m + 1;
      i3 = 0xFF & paramArrayOfByte[m];
      int i4 = n >>> 2;
      int i5 = (n & 0x3) << 4 | i1 >>> 4;
      int i6 = (i1 & 0xF) << 2 | i3 >>> 6;
      i7 = i3 & 0x3F;
      int i8 = k + 1;
      arrayOfChar[k] = b[i4];
      int i9 = i8 + 1;
      arrayOfChar[i8] = b[i5];
      if (i9 >= i)
        break label255;
      i10 = b[i6];
      arrayOfChar[i9] = i10;
      i11 = i9 + 1;
      if (i11 >= i)
        break label262;
    }
    label262: for (int i12 = b[i7]; ; i12 = 61)
    {
      arrayOfChar[i11] = i12;
      int i13 = i11 + 1;
      paramInt1 = i2;
      k = i13;
      break;
      i1 = 0;
      break label77;
      label245: i2 = m;
      i3 = 0;
      break label100;
      label255: i10 = 61;
      break label189;
    }
  }

  public static String encodeLines(byte[] paramArrayOfByte)
  {
    return encodeLines(paramArrayOfByte, 0, paramArrayOfByte.length, 76, a);
  }

  public static String encodeLines(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int i = paramInt3 * 3 / 4;
    if (i <= 0)
      throw new IllegalArgumentException();
    int j = (-1 + (paramInt2 + i)) / i;
    StringBuilder localStringBuilder = new StringBuilder(((paramInt2 + 2) / 3 << 2) + j * paramString.length());
    int k = 0;
    while (true)
    {
      if (k >= paramInt2)
        return localStringBuilder.toString();
      int m = Math.min(paramInt2 - k, i);
      localStringBuilder.append(encode(paramArrayOfByte, paramInt1 + k, m));
      localStringBuilder.append(paramString);
      k += m;
    }
  }

  public static String encodeString(String paramString)
  {
    return new String(encode(paramString.getBytes()));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.channel.openauth.utils.Base64Coder
 * JD-Core Version:    0.6.2
 */