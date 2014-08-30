package com.google.zxing.pdf417.encoder;

import com.google.zxing.WriterException;
import java.math.BigInteger;
import java.util.Arrays;

final class e
{
  private static final int a = 0;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 0;
  private static final int e = 1;
  private static final int f = 2;
  private static final int g = 3;
  private static final int h = 900;
  private static final int i = 901;
  private static final int j = 902;
  private static final int k = 913;
  private static final int l = 924;
  private static final byte[] m;
  private static final byte[] n;
  private static final byte[] o;
  private static final byte[] p;

  static
  {
    int i1 = 0;
    m = new byte[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0 };
    n = new byte[] { 59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0 };
    o = new byte[''];
    p = new byte[''];
    Arrays.fill(o, (byte)-1);
    for (int i2 = 0; i2 < m.length; i2 = (byte)(i2 + 1))
    {
      int i4 = m[i2];
      if (i4 > 0)
        o[i4] = i2;
    }
    Arrays.fill(p, (byte)-1);
    while (i1 < n.length)
    {
      int i3 = n[i1];
      if (i3 > 0)
        p[i3] = i1;
      i1 = (byte)(i1 + 1);
    }
  }

  private static int a(CharSequence paramCharSequence, int paramInt)
  {
    int i1 = paramCharSequence.length();
    int i2 = 0;
    if (paramInt < i1)
    {
      char c1 = paramCharSequence.charAt(paramInt);
      while ((a(c1)) && (paramInt < i1))
      {
        i2++;
        paramInt++;
        if (paramInt < i1)
          c1 = paramCharSequence.charAt(paramInt);
      }
    }
    return i2;
  }

  private static int a(CharSequence paramCharSequence, int paramInt1, int paramInt2, StringBuilder paramStringBuilder, int paramInt3)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt2);
    int i1 = 0;
    char c1;
    label73: 
    do
    {
      c1 = paramCharSequence.charAt(paramInt1 + i1);
      switch (paramInt3)
      {
      default:
        if (!e(c1))
          break label511;
        localStringBuilder.append((char)p[c1]);
        i1++;
      case 0:
      case 1:
      case 2:
      }
    }
    while (i1 < paramInt2);
    int i2 = localStringBuilder.length();
    int i3 = 0;
    int i4 = 0;
    label95: if (i4 < i2)
    {
      int i5;
      label112: char c2;
      if (i4 % 2 != 0)
      {
        i5 = 1;
        if (i5 == 0)
          break label531;
        c2 = (char)(i3 * 30 + localStringBuilder.charAt(i4));
        paramStringBuilder.append(c2);
      }
      while (true)
      {
        i4++;
        i3 = c2;
        break label95;
        if (b(c1))
        {
          if (c1 == ' ')
          {
            localStringBuilder.append('\032');
            break label73;
          }
          localStringBuilder.append((char)(c1 - 'A'));
          break label73;
        }
        if (c(c1))
        {
          localStringBuilder.append('\033');
          paramInt3 = 1;
          break;
        }
        if (d(c1))
        {
          paramInt3 = 2;
          localStringBuilder.append('\034');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)p[c1]);
        break label73;
        if (c(c1))
        {
          if (c1 == ' ')
          {
            localStringBuilder.append('\032');
            break label73;
          }
          localStringBuilder.append((char)(c1 - 'a'));
          break label73;
        }
        if (b(c1))
        {
          localStringBuilder.append('\033');
          localStringBuilder.append((char)(c1 - 'A'));
          break label73;
        }
        if (d(c1))
        {
          paramInt3 = 2;
          localStringBuilder.append('\034');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)p[c1]);
        break label73;
        if (d(c1))
        {
          localStringBuilder.append((char)o[c1]);
          break label73;
        }
        if (b(c1))
        {
          localStringBuilder.append('\034');
          paramInt3 = 0;
          break;
        }
        if (c(c1))
        {
          localStringBuilder.append('\033');
          paramInt3 = 1;
          break;
        }
        if ((1 + (paramInt1 + i1) < paramInt2) && (e(paramCharSequence.charAt(1 + (paramInt1 + i1)))))
        {
          paramInt3 = 3;
          localStringBuilder.append('\031');
          break;
        }
        localStringBuilder.append('\035');
        localStringBuilder.append((char)p[c1]);
        break label73;
        label511: localStringBuilder.append('\035');
        paramInt3 = 0;
        break;
        i5 = 0;
        break label112;
        c2 = localStringBuilder.charAt(i4);
      }
    }
    label531: if (i2 % 2 != 0)
      paramStringBuilder.append((char)(29 + i3 * 30));
    return paramInt3;
  }

  private static int a(CharSequence paramCharSequence, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = paramCharSequence.length();
    for (int i2 = paramInt; i2 < i1; i2++)
    {
      char c1 = paramCharSequence.charAt(i2);
      int i3 = 0;
      while ((i3 < 13) && (a(c1)))
      {
        i3++;
        int i6 = i2 + i3;
        if (i6 >= i1)
          break;
        c1 = paramCharSequence.charAt(i6);
      }
      if (i3 >= 13)
        return i2 - paramInt;
      char c2 = c1;
      int i4 = 0;
      while ((i4 < 5) && (f(c2)))
      {
        i4++;
        int i5 = i2 + i4;
        if (i5 >= i1)
          break;
        c2 = paramCharSequence.charAt(i5);
      }
      if (i4 >= 5)
        return i2 - paramInt;
      char c3 = paramCharSequence.charAt(i2);
      if ((paramArrayOfByte[i2] == 63) && (c3 != '?'))
        throw new WriterException("Non-encodable character detected: " + c3 + " (Unicode: " + c3 + ')');
    }
    return i2 - paramInt;
  }

  static String a(String paramString, Compaction paramCompaction)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length());
    int i1 = paramString.length();
    if (paramCompaction == Compaction.TEXT)
      a(paramString, 0, i1, localStringBuilder, 0);
    while (true)
    {
      return localStringBuilder.toString();
      if (paramCompaction == Compaction.BYTE)
      {
        byte[] arrayOfByte2 = paramString.getBytes();
        a(arrayOfByte2, 0, arrayOfByte2.length, 1, localStringBuilder);
      }
      else if (paramCompaction == Compaction.NUMERIC)
      {
        localStringBuilder.append('Ά');
        a(paramString, 0, i1, localStringBuilder);
      }
      else
      {
        int i4;
        while (i4 < i1)
        {
          int i5 = a(paramString, i4);
          int i3;
          int i2;
          if (i5 >= 13)
          {
            localStringBuilder.append('Ά');
            i3 = 2;
            a(paramString, i4, i5, localStringBuilder);
            i4 += i5;
            i2 = 0;
          }
          else
          {
            int i6 = b(paramString, i4);
            if ((i6 >= 5) || (i5 == i1))
            {
              if (i3 != 0)
              {
                localStringBuilder.append('΄');
                i2 = 0;
                i3 = 0;
              }
              i2 = a(paramString, i4, i6, localStringBuilder, i2);
              i4 += i6;
            }
            else
            {
              if (arrayOfByte1 == null)
                arrayOfByte1 = paramString.getBytes();
              int i7 = a(paramString, arrayOfByte1, i4);
              if (i7 == 0)
                i7 = 1;
              if ((i7 == 1) && (i3 == 0))
                a(arrayOfByte1, i4, 1, 0, localStringBuilder);
              while (true)
              {
                i4 += i7;
                break;
                a(arrayOfByte1, i4, i7, i3, localStringBuilder);
                i3 = 1;
                i2 = 0;
              }
              byte[] arrayOfByte1 = null;
              i2 = 0;
              i3 = 0;
              i4 = 0;
            }
          }
        }
      }
    }
  }

  private static void a(String paramString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder(1 + paramInt2 / 3);
    BigInteger localBigInteger1 = BigInteger.valueOf(900L);
    BigInteger localBigInteger2 = BigInteger.valueOf(0L);
    int i1 = 0;
    while (i1 < paramInt2 - 1)
    {
      localStringBuilder.setLength(0);
      int i2 = Math.min(44, paramInt2 - i1);
      BigInteger localBigInteger3 = new BigInteger("1" + paramString.substring(paramInt1 + i1, i2 + (paramInt1 + i1)));
      do
      {
        localStringBuilder.append((char)localBigInteger3.mod(localBigInteger1).intValue());
        localBigInteger3 = localBigInteger3.divide(localBigInteger1);
      }
      while (!localBigInteger3.equals(localBigInteger2));
      for (int i3 = -1 + localStringBuilder.length(); i3 >= 0; i3--)
        paramStringBuilder.append(localStringBuilder.charAt(i3));
      i1 += i2;
    }
  }

  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, StringBuilder paramStringBuilder)
  {
    if ((paramInt2 == 1) && (paramInt3 == 0))
      paramStringBuilder.append('Α');
    if (paramInt2 >= 6)
    {
      paramStringBuilder.append('Μ');
      char[] arrayOfChar = new char[5];
      for (i1 = paramInt1; paramInt1 + paramInt2 - i1 >= 6; i1 += 6)
      {
        long l1 = 0L;
        for (int i2 = 0; i2 < 6; i2++)
          l1 = (l1 << 8) + (0xFF & paramArrayOfByte[(i1 + i2)]);
        for (int i3 = 0; i3 < 5; i3++)
        {
          arrayOfChar[i3] = ((char)(int)(l1 % 900L));
          l1 /= 900L;
        }
        for (int i4 = -1 + arrayOfChar.length; i4 >= 0; i4--)
          paramStringBuilder.append(arrayOfChar[i4]);
      }
    }
    int i1 = paramInt1;
    if (i1 < paramInt1 + paramInt2)
      paramStringBuilder.append('΅');
    while (i1 < paramInt1 + paramInt2)
    {
      paramStringBuilder.append((char)(0xFF & paramArrayOfByte[i1]));
      i1++;
    }
  }

  private static boolean a(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }

  private static byte[] a(String paramString)
  {
    return paramString.getBytes();
  }

  private static int b(CharSequence paramCharSequence, int paramInt)
  {
    int i1 = paramCharSequence.length();
    int i2 = paramInt;
    char c1;
    int i3;
    if (i2 < i1)
    {
      c1 = paramCharSequence.charAt(i2);
      i3 = 0;
    }
    while (true)
    {
      int i4;
      if ((i3 < 13) && (a(c1)) && (i2 < i1))
      {
        i3++;
        i4 = i2 + 1;
        if (i4 < i1)
        {
          c1 = paramCharSequence.charAt(i4);
          i2 = i4;
        }
      }
      else
      {
        if (i3 >= 13)
          return i2 - paramInt - i3;
        if (i3 > 0)
          break;
        if (f(paramCharSequence.charAt(i2)))
        {
          i2++;
          break;
        }
        return i2 - paramInt;
        i2 = i4;
      }
    }
  }

  private static boolean b(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= 'A') && (paramChar <= 'Z'));
  }

  private static boolean c(char paramChar)
  {
    return (paramChar == ' ') || ((paramChar >= 'a') && (paramChar <= 'z'));
  }

  private static boolean d(char paramChar)
  {
    return o[paramChar] != -1;
  }

  private static boolean e(char paramChar)
  {
    return p[paramChar] != -1;
  }

  private static boolean f(char paramChar)
  {
    return (paramChar == '\t') || (paramChar == '\n') || (paramChar == '\r') || ((paramChar >= ' ') && (paramChar <= '~'));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.encoder.e
 * JD-Core Version:    0.6.2
 */