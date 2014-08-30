package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class Code93Reader extends OneDReader
{
  private static final String a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";
  private static final char[] b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();
  private static final int[] c = arrayOfInt;
  private static final int d = arrayOfInt[47];

  static
  {
    int[] arrayOfInt = { 276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350 };
  }

  private static char a(int paramInt)
  {
    for (int i = 0; i < c.length; i++)
      if (c[i] == paramInt)
        return b[i];
    throw NotFoundException.getNotFoundInstance();
  }

  private static int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int j = 0;
    int i6;
    for (int k = 0; j < i; k = i6)
    {
      i6 = k + paramArrayOfInt[j];
      j++;
    }
    int m = 0;
    int n = 0;
    int i2;
    if (m < i)
    {
      int i1 = 9 * (paramArrayOfInt[m] << 8) / k;
      i2 = i1 >> 8;
      if ((i1 & 0xFF) <= 127)
        break label143;
    }
    label143: for (int i3 = i2 + 1; ; i3 = i2)
    {
      if ((i3 <= 0) || (i3 > 4))
      {
        n = -1;
        return n;
      }
      if ((m & 0x1) == 0)
      {
        int i4 = 0;
        while (i4 < i3)
        {
          int i5 = 0x1 | n << 1;
          i4++;
          n = i5;
        }
      }
      n <<= i3;
      m++;
      break;
    }
  }

  private static String a(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    StringBuilder localStringBuilder = new StringBuilder(i);
    int j = 0;
    if (j < i)
    {
      char c1 = paramCharSequence.charAt(j);
      int m;
      char c2;
      if ((c1 >= 'a') && (c1 <= 'd'))
      {
        m = paramCharSequence.charAt(j + 1);
        switch (c1)
        {
        default:
          c2 = '\000';
          label91: localStringBuilder.append(c2);
        case 'd':
        case 'a':
        case 'b':
        case 'c':
        }
      }
      for (int k = j + 1; ; k = j)
      {
        j = k + 1;
        break;
        if ((m >= 65) && (m <= 90))
        {
          c2 = (char)(m + 32);
          break label91;
        }
        throw FormatException.getFormatInstance();
        if ((m >= 65) && (m <= 90))
        {
          c2 = (char)(m - 64);
          break label91;
        }
        throw FormatException.getFormatInstance();
        if ((m >= 65) && (m <= 69))
        {
          c2 = (char)(m - 38);
          break label91;
        }
        if ((m >= 70) && (m <= 87))
        {
          c2 = (char)(m - 11);
          break label91;
        }
        throw FormatException.getFormatInstance();
        if ((m >= 65) && (m <= 79))
        {
          c2 = (char)(m - 32);
          break label91;
        }
        if (m == 90)
        {
          c2 = ':';
          break label91;
        }
        throw FormatException.getFormatInstance();
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }

  private static void a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int i = paramInt1 - 1;
    int j = 1;
    int k = i;
    int n;
    for (int m = 0; k >= 0; m = n)
    {
      n = m + j * "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(paramCharSequence.charAt(k));
      int i1 = j + 1;
      if (i1 > paramInt2)
        i1 = 1;
      k--;
      j = i1;
    }
    if (paramCharSequence.charAt(paramInt1) != b[(m % 47)])
      throw ChecksumException.getChecksumInstance();
  }

  private static int[] a(BitArray paramBitArray)
  {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    int[] arrayOfInt = new int[6];
    int k = arrayOfInt.length;
    int m = 0;
    int n = 0;
    int i1 = j;
    if (i1 < i)
    {
      if ((m ^ paramBitArray.get(i1)) != 0)
        arrayOfInt[n] = (1 + arrayOfInt[n]);
      while (true)
      {
        i1++;
        break;
        if (n == k - 1)
        {
          if (a(arrayOfInt) == d)
            return new int[] { j, i1 };
          j += arrayOfInt[0] + arrayOfInt[1];
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, k - 2);
          arrayOfInt[(k - 2)] = 0;
          arrayOfInt[(k - 1)] = 0;
          n--;
        }
        while (true)
        {
          arrayOfInt[n] = 1;
          if (m != 0)
            break label155;
          m = 1;
          break;
          n++;
        }
        label155: m = 0;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }

  private static void b(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    a(paramCharSequence, i - 2, 20);
    a(paramCharSequence, i - 1, 15);
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    int k = 0;
    int[] arrayOfInt1 = new int[6];
    int m = 0;
    int n = arrayOfInt1.length;
    int i1 = j;
    int[] arrayOfInt2;
    int i2;
    int i3;
    StringBuilder localStringBuilder;
    int[] arrayOfInt3;
    while (true)
      if (i1 < i)
        if ((m ^ paramBitArray.get(i1)) != 0)
        {
          arrayOfInt1[k] = (1 + arrayOfInt1[k]);
          i1++;
        }
        else if (k == n - 1)
        {
          if (a(arrayOfInt1) == d)
          {
            arrayOfInt2 = new int[] { j, i1 };
            i2 = paramBitArray.getNextSet(arrayOfInt2[1]);
            i3 = paramBitArray.getSize();
            localStringBuilder = new StringBuilder(20);
            arrayOfInt3 = new int[6];
          }
        }
    while (true)
    {
      recordPattern(paramBitArray, i2, arrayOfInt3);
      int i4 = a(arrayOfInt3);
      if (i4 < 0)
      {
        throw NotFoundException.getNotFoundInstance();
        j += arrayOfInt1[0] + arrayOfInt1[1];
        System.arraycopy(arrayOfInt1, 2, arrayOfInt1, 0, n - 2);
        arrayOfInt1[(n - 2)] = 0;
        arrayOfInt1[(n - 1)] = 0;
        k--;
        while (true)
        {
          arrayOfInt1[k] = 1;
          if (m != 0)
            break label232;
          m = 1;
          break;
          k++;
        }
        label232: m = 0;
        break;
        throw NotFoundException.getNotFoundInstance();
      }
      char c1 = a(i4);
      localStringBuilder.append(c1);
      int i5 = arrayOfInt3.length;
      int i6 = 0;
      int i7 = i2;
      while (i6 < i5)
      {
        i7 += arrayOfInt3[i6];
        i6++;
      }
      int i8 = paramBitArray.getNextSet(i7);
      if (c1 == '*')
      {
        localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        if ((i8 == i3) || (!paramBitArray.get(i8)))
          throw NotFoundException.getNotFoundInstance();
        if (localStringBuilder.length() < 2)
          throw NotFoundException.getNotFoundInstance();
        int i9 = localStringBuilder.length();
        a(localStringBuilder, i9 - 2, 20);
        a(localStringBuilder, i9 - 1, 15);
        localStringBuilder.setLength(-2 + localStringBuilder.length());
        String str = a(localStringBuilder);
        float f1 = (arrayOfInt2[1] + arrayOfInt2[0]) / 2.0F;
        float f2 = (i2 + i8) / 2.0F;
        ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
        arrayOfResultPoint[0] = new ResultPoint(f1, paramInt);
        arrayOfResultPoint[1] = new ResultPoint(f2, paramInt);
        return new Result(str, null, arrayOfResultPoint, BarcodeFormat.CODE_93);
      }
      i2 = i8;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.Code93Reader
 * JD-Core Version:    0.6.2
 */