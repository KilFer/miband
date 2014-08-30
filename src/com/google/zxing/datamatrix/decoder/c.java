package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.DecoderResult;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class c
{
  private static final char[] a = { 42, 42, 42, 32, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 };
  private static final char[] b = { 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95 };
  private static final char[] c = { 42, 42, 42, 32, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122 };
  private static final char[] d = { 39, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 123, 124, 125, 126, 127 };

  private static int a(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - (1 + paramInt2 * 149 % 255);
    if (i >= 0)
      return i;
    return i + 256;
  }

  static DecoderResult a(byte[] paramArrayOfByte)
  {
    BitSource localBitSource = new BitSource(paramArrayOfByte);
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    StringBuilder localStringBuilder2 = new StringBuilder(0);
    ArrayList localArrayList = new ArrayList(1);
    e locale = e.b;
    String str;
    while (locale == e.b)
    {
      locale = a(localBitSource, localStringBuilder1, localStringBuilder2);
      if ((locale == e.a) || (localBitSource.available() <= 0))
      {
        if (localStringBuilder2.length() > 0)
          localStringBuilder1.append(localStringBuilder2.toString());
        str = localStringBuilder1.toString();
        if (!localArrayList.isEmpty())
          break label219;
      }
    }
    label219: for (Object localObject = null; ; localObject = localArrayList)
    {
      return new DecoderResult(paramArrayOfByte, str, (List)localObject, null);
      switch (d.a[locale.ordinal()])
      {
      default:
        throw FormatException.getFormatInstance();
      case 1:
        a(localBitSource, localStringBuilder1);
      case 2:
      case 3:
      case 4:
      case 5:
      }
      while (true)
      {
        locale = e.b;
        break;
        b(localBitSource, localStringBuilder1);
        continue;
        c(localBitSource, localStringBuilder1);
        continue;
        d(localBitSource, localStringBuilder1);
        continue;
        a(localBitSource, localStringBuilder1, localArrayList);
      }
    }
  }

  private static e a(BitSource paramBitSource, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    int i = 0;
    break label102;
    label2: int j = paramBitSource.readBits(8);
    if (j == 0)
      throw FormatException.getFormatInstance();
    if (j <= 128)
      if (i == 0)
        break label307;
    label307: for (int m = j + 128; ; m = j)
    {
      paramStringBuilder1.append((char)(m - 1));
      return e.b;
      if (j == 129)
        return e.a;
      if (j <= 229)
      {
        int k = j - 130;
        if (k < 10)
          paramStringBuilder1.append('0');
        paramStringBuilder1.append(k);
      }
      label102: 
      while (paramBitSource.available() <= 0)
      {
        return e.b;
        if (j == 230)
          return e.c;
        if (j == 231)
          return e.g;
        if (j == 232)
          paramStringBuilder1.append('\035');
        else if ((j != 233) && (j != 234))
          if (j == 235)
          {
            i = 1;
          }
          else if (j == 236)
          {
            paramStringBuilder1.append("[)>\03605\035");
            paramStringBuilder2.insert(0, "\036\004");
          }
          else
          {
            if (j != 237)
              break label236;
            paramStringBuilder1.append("[)>\03606\035");
            paramStringBuilder2.insert(0, "\036\004");
          }
      }
      break label2;
      label236: if (j == 238)
        return e.e;
      if (j == 239)
        return e.d;
      if (j == 240)
        return e.f;
      if ((j == 241) || (j < 242) || ((j == 254) && (paramBitSource.available() == 0)))
        break;
      throw FormatException.getFormatInstance();
    }
  }

  private static void a(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    int i = -1 + (paramInt2 + (paramInt1 << 8));
    int j = i / 1600;
    paramArrayOfInt[0] = j;
    int k = i - j * 1600;
    int m = k / 40;
    paramArrayOfInt[1] = m;
    paramArrayOfInt[2] = (k - m * 40);
  }

  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = new int[3];
    int i = 0;
    int j = 0;
    label163: 
    do
    {
      if (paramBitSource.available() == 8);
      int k;
      do
      {
        return;
        k = paramBitSource.readBits(8);
      }
      while (k == 254);
      a(k, paramBitSource.readBits(8), arrayOfInt);
      int m = 0;
      if (m < 3)
      {
        int n = arrayOfInt[m];
        switch (i)
        {
        default:
          throw FormatException.getFormatInstance();
        case 0:
          if (n < 3)
            i = n + 1;
          while (true)
          {
            m++;
            break;
            if (n >= a.length)
              break label163;
            char c2 = a[n];
            if (j != 0)
            {
              paramStringBuilder.append((char)(c2 + ''));
              j = 0;
            }
            else
            {
              paramStringBuilder.append(c2);
            }
          }
          throw FormatException.getFormatInstance();
        case 1:
          if (j != 0)
          {
            paramStringBuilder.append((char)(n + 128));
            j = 0;
          }
          while (true)
          {
            i = 0;
            break;
            paramStringBuilder.append((char)n);
          }
        case 2:
          char c1;
          if (n < b.length)
          {
            c1 = b[n];
            if (j != 0)
            {
              paramStringBuilder.append((char)(c1 + ''));
              j = 0;
            }
          }
          while (true)
          {
            i = 0;
            break;
            paramStringBuilder.append(c1);
            continue;
            if (n == 27)
            {
              paramStringBuilder.append('\035');
            }
            else
            {
              if (n != 30)
                break label285;
              j = 1;
            }
          }
          throw FormatException.getFormatInstance();
        case 3:
        }
        if (j != 0)
        {
          paramStringBuilder.append((char)(n + 224));
          j = 0;
        }
        while (true)
        {
          i = 0;
          break;
          paramStringBuilder.append((char)(n + 96));
        }
      }
    }
    while (paramBitSource.available() > 0);
    label285:
  }

  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, Collection<byte[]> paramCollection)
  {
    int i = 1 + paramBitSource.getByteOffset();
    int j = paramBitSource.readBits(8);
    int k = i + 1;
    int m = a(j, i);
    int i3;
    if (m == 0)
      i3 = paramBitSource.available() / 8;
    while (i3 < 0)
    {
      throw FormatException.getFormatInstance();
      if (m < 250)
      {
        i3 = m;
      }
      else
      {
        int n = 250 * (m - 249);
        int i1 = paramBitSource.readBits(8);
        int i2 = k + 1;
        i3 = n + a(i1, k);
        k = i2;
      }
    }
    byte[] arrayOfByte = new byte[i3];
    int i4 = 0;
    while (i4 < i3)
    {
      if (paramBitSource.available() < 8)
        throw FormatException.getFormatInstance();
      int i5 = paramBitSource.readBits(8);
      int i6 = k + 1;
      arrayOfByte[i4] = ((byte)a(i5, k));
      i4++;
      k = i6;
    }
    paramCollection.add(arrayOfByte);
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "ISO8859_1"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new IllegalStateException("Platform does not support required encoding: " + localUnsupportedEncodingException);
    }
  }

  private static void b(BitSource paramBitSource, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = new int[3];
    int i = 0;
    int j = 0;
    label163: 
    do
    {
      if (paramBitSource.available() == 8);
      int k;
      do
      {
        return;
        k = paramBitSource.readBits(8);
      }
      while (k == 254);
      a(k, paramBitSource.readBits(8), arrayOfInt);
      int m = 0;
      if (m < 3)
      {
        int n = arrayOfInt[m];
        switch (i)
        {
        default:
          throw FormatException.getFormatInstance();
        case 0:
          if (n < 3)
            i = n + 1;
          while (true)
          {
            m++;
            break;
            if (n >= c.length)
              break label163;
            char c3 = c[n];
            if (j != 0)
            {
              paramStringBuilder.append((char)(c3 + ''));
              j = 0;
            }
            else
            {
              paramStringBuilder.append(c3);
            }
          }
          throw FormatException.getFormatInstance();
        case 1:
          if (j != 0)
          {
            paramStringBuilder.append((char)(n + 128));
            j = 0;
          }
          while (true)
          {
            i = 0;
            break;
            paramStringBuilder.append((char)n);
          }
        case 2:
          char c2;
          if (n < b.length)
          {
            c2 = b[n];
            if (j != 0)
            {
              paramStringBuilder.append((char)(c2 + ''));
              j = 0;
            }
          }
          while (true)
          {
            i = 0;
            break;
            paramStringBuilder.append(c2);
            continue;
            if (n == 27)
            {
              paramStringBuilder.append('\035');
            }
            else
            {
              if (n != 30)
                break label285;
              j = 1;
            }
          }
          throw FormatException.getFormatInstance();
        case 3:
        }
        if (n < d.length)
        {
          char c1 = d[n];
          if (j != 0)
          {
            paramStringBuilder.append((char)(c1 + ''));
            j = 0;
          }
          while (true)
          {
            i = 0;
            break;
            paramStringBuilder.append(c1);
          }
        }
        throw FormatException.getFormatInstance();
      }
    }
    while (paramBitSource.available() > 0);
    label285:
  }

  private static void c(BitSource paramBitSource, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = new int[3];
    label162: 
    do
    {
      if (paramBitSource.available() == 8);
      int i;
      do
      {
        return;
        i = paramBitSource.readBits(8);
      }
      while (i == 254);
      a(i, paramBitSource.readBits(8), arrayOfInt);
      int j = 0;
      if (j < 3)
      {
        int k = arrayOfInt[j];
        if (k == 0)
          paramStringBuilder.append('\r');
        while (true)
        {
          j++;
          break;
          if (k == 1)
          {
            paramStringBuilder.append('*');
          }
          else if (k == 2)
          {
            paramStringBuilder.append('>');
          }
          else if (k == 3)
          {
            paramStringBuilder.append(' ');
          }
          else if (k < 14)
          {
            paramStringBuilder.append((char)(k + 44));
          }
          else
          {
            if (k >= 40)
              break label162;
            paramStringBuilder.append((char)(k + 51));
          }
        }
        throw FormatException.getFormatInstance();
      }
    }
    while (paramBitSource.available() > 0);
  }

  private static void d(BitSource paramBitSource, StringBuilder paramStringBuilder)
  {
    int i = 0;
    if (paramBitSource.available() <= 16)
      label11: return;
    int j = 0;
    label14: int k;
    if (j < 4)
    {
      k = paramBitSource.readBits(6);
      if (k != 31)
        break label93;
    }
    label86: label93: for (int m = 1; ; m = i)
    {
      if (m == 0)
        if ((k & 0x20) != 0)
          break label86;
      for (int n = k | 0x40; ; n = k)
      {
        paramStringBuilder.append((char)n);
        j++;
        i = m;
        break label14;
        if (i != 0)
          break label11;
        if (paramBitSource.available() > 0)
          break;
        return;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.decoder.c
 * JD-Core Version:    0.6.2
 */