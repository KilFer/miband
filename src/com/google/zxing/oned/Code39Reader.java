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

public final class Code39Reader extends OneDReader
{
  static final int[] a = arrayOfInt;
  private static String b = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%";
  private static final char[] c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".toCharArray();
  private static final int d = arrayOfInt[39];
  private final boolean e;
  private final boolean f;

  static
  {
    int[] arrayOfInt = { 52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 148, 168, 162, 138, 42 };
  }

  public Code39Reader()
  {
    this.e = false;
    this.f = false;
  }

  public Code39Reader(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.f = false;
  }

  public Code39Reader(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = paramBoolean1;
    this.f = paramBoolean2;
  }

  private static char a(int paramInt)
  {
    for (int i = 0; i < a.length; i++)
      if (a[i] == paramInt)
        return c[i];
    throw NotFoundException.getNotFoundInstance();
  }

  private static int a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int k;
    for (int j = 0; ; j = k)
    {
      k = 2147483647;
      for (int m = 0; m < i; m++)
      {
        int i8 = paramArrayOfInt[m];
        if ((i8 < k) && (i8 > j))
          k = i8;
      }
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      int i3 = 0;
      while (n < i)
      {
        int i7 = paramArrayOfInt[n];
        if (paramArrayOfInt[n] > k)
        {
          i1 |= 1 << i - 1 - n;
          i3++;
          i2 += i7;
        }
        n++;
      }
      if (i3 == 3)
      {
        int i4 = i3;
        for (int i5 = 0; ; i5++)
          if ((i5 < i) && (i4 > 0))
          {
            int i6 = paramArrayOfInt[i5];
            if (paramArrayOfInt[i5] > k)
            {
              i4--;
              if (i6 << 1 >= i2)
                i1 = -1;
            }
          }
          else
          {
            return i1;
          }
      }
      if (i3 <= 3)
        return -1;
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
      int k;
      char c2;
      if ((c1 == '+') || (c1 == '$') || (c1 == '%') || (c1 == '/'))
      {
        k = paramCharSequence.charAt(j + 1);
        switch (c1)
        {
        default:
          c2 = '\000';
          label119: localStringBuilder.append(c2);
        case '+':
        case '$':
        case '%':
        case '/':
        }
      }
      for (int m = j + 1; ; m = j)
      {
        j = m + 1;
        break;
        if ((k >= 65) && (k <= 90))
        {
          c2 = (char)(k + 32);
          break label119;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 90))
        {
          c2 = (char)(k - 64);
          break label119;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 69))
        {
          c2 = (char)(k - 38);
          break label119;
        }
        if ((k >= 70) && (k <= 87))
        {
          c2 = (char)(k - 11);
          break label119;
        }
        throw FormatException.getFormatInstance();
        if ((k >= 65) && (k <= 79))
        {
          c2 = (char)(k - 32);
          break label119;
        }
        if (k == 90)
        {
          c2 = ':';
          break label119;
        }
        throw FormatException.getFormatInstance();
        localStringBuilder.append(c1);
      }
    }
    return localStringBuilder.toString();
  }

  private static int[] a(BitArray paramBitArray, int[] paramArrayOfInt)
  {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    int k = paramArrayOfInt.length;
    int m = 0;
    int n = 0;
    int i1 = j;
    if (i1 < i)
    {
      if ((m ^ paramBitArray.get(i1)) != 0)
        paramArrayOfInt[n] = (1 + paramArrayOfInt[n]);
      while (true)
      {
        i1++;
        break;
        if (n == k - 1)
        {
          if ((a(paramArrayOfInt) == d) && (paramBitArray.isRange(Math.max(0, j - (i1 - j >> 1)), j, false)))
            return new int[] { j, i1 };
          j += paramArrayOfInt[0] + paramArrayOfInt[1];
          System.arraycopy(paramArrayOfInt, 2, paramArrayOfInt, 0, k - 2);
          paramArrayOfInt[(k - 2)] = 0;
          paramArrayOfInt[(k - 1)] = 0;
          n--;
        }
        while (true)
        {
          paramArrayOfInt[n] = 1;
          if (m != 0)
            break label171;
          m = 1;
          break;
          n++;
        }
        label171: m = 0;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt1 = new int[9];
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    int k = 0;
    int m = 0;
    int n = arrayOfInt1.length;
    int i1 = j;
    int[] arrayOfInt2;
    int i2;
    int i3;
    StringBuilder localStringBuilder;
    while (true)
      if (i1 < i)
        if ((m ^ paramBitArray.get(i1)) != 0)
        {
          arrayOfInt1[k] = (1 + arrayOfInt1[k]);
          i1++;
        }
        else if (k == n - 1)
        {
          if ((a(arrayOfInt1) == d) && (paramBitArray.isRange(Math.max(0, j - (i1 - j >> 1)), j, false)))
          {
            arrayOfInt2 = new int[] { j, i1 };
            i2 = paramBitArray.getNextSet(arrayOfInt2[1]);
            i3 = paramBitArray.getSize();
            localStringBuilder = new StringBuilder(20);
          }
        }
    while (true)
    {
      recordPattern(paramBitArray, i2, arrayOfInt1);
      int i4 = a(arrayOfInt1);
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
            break label250;
          m = 1;
          break;
          k++;
        }
        label250: m = 0;
        break;
        throw NotFoundException.getNotFoundInstance();
      }
      char c1 = a(i4);
      localStringBuilder.append(c1);
      int i5 = arrayOfInt1.length;
      int i6 = 0;
      int i7 = i2;
      while (i6 < i5)
      {
        i7 += arrayOfInt1[i6];
        i6++;
      }
      int i8 = paramBitArray.getNextSet(i7);
      if (c1 == '*')
      {
        localStringBuilder.setLength(-1 + localStringBuilder.length());
        int i9 = 0;
        int i10 = arrayOfInt1.length;
        for (int i11 = 0; i11 < i10; i11++)
          i9 += arrayOfInt1[i11];
        int i12 = i8 - i2 - i9;
        if ((i8 != i3) && (i12 >> 1 < i9))
          throw NotFoundException.getNotFoundInstance();
        if (this.e)
        {
          int i13 = -1 + localStringBuilder.length();
          int i14 = 0;
          for (int i15 = 0; i15 < i13; i15++)
            i14 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(localStringBuilder.charAt(i15));
          if (localStringBuilder.charAt(i13) != c[(i14 % 43)])
            throw ChecksumException.getChecksumInstance();
          localStringBuilder.setLength(i13);
        }
        if (localStringBuilder.length() == 0)
          throw NotFoundException.getNotFoundInstance();
        if (this.f);
        for (String str = a(localStringBuilder); ; str = localStringBuilder.toString())
        {
          float f1 = (arrayOfInt2[1] + arrayOfInt2[0]) / 2.0F;
          float f2 = (i2 + i8) / 2.0F;
          ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
          arrayOfResultPoint[0] = new ResultPoint(f1, paramInt);
          arrayOfResultPoint[1] = new ResultPoint(f2, paramInt);
          return new Result(str, null, arrayOfResultPoint, BarcodeFormat.CODE_39);
        }
      }
      i2 = i8;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.Code39Reader
 * JD-Core Version:    0.6.2
 */