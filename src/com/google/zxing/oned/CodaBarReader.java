package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class CodaBarReader extends OneDReader
{
  static final char[] a = "0123456789-$:/.+ABCDTN".toCharArray();
  static final int[] b = { 3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14, 26, 41 };
  private static final String c = "0123456789-$:/.+ABCDTN";
  private static final int d = 6;
  private static final char[] e = { 69, 42, 65, 66, 67, 68, 84, 78 };

  private static char a(int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    int j = 2147483647;
    int k = 0;
    int m = 0;
    while (k < i)
    {
      if (paramArrayOfInt[k] < j)
        j = paramArrayOfInt[k];
      if (paramArrayOfInt[k] > m)
        m = paramArrayOfInt[k];
      k++;
    }
    do
    {
      int n = 0;
      int i1 = 0;
      int i2 = 0;
      while (n < i)
      {
        if (paramArrayOfInt[n] > m)
        {
          i1 |= 1 << i - 1 - n;
          i2++;
        }
        n++;
      }
      if ((i2 == 2) || (i2 == 3))
        for (int i3 = 0; i3 < b.length; i3++)
          if (b[i3] == i1)
            return a[i3];
      m--;
    }
    while (m > j);
    return '!';
  }

  static boolean a(char[] paramArrayOfChar, char paramChar)
  {
    boolean bool = false;
    int i;
    if (paramArrayOfChar != null)
      i = paramArrayOfChar.length;
    for (int j = 0; ; j++)
    {
      bool = false;
      if (j < i)
      {
        if (paramArrayOfChar[j] == paramChar)
          bool = true;
      }
      else
        return bool;
    }
  }

  private static int[] a(BitArray paramBitArray)
  {
    int i = paramBitArray.getSize();
    int j = paramBitArray.getNextSet(0);
    int[] arrayOfInt1 = new int[7];
    int k = arrayOfInt1.length;
    int m = 0;
    int n = 0;
    int i1 = j;
    while (i1 < i)
    {
      int i4;
      int i5;
      int i6;
      if ((m ^ paramBitArray.get(i1)) != 0)
      {
        arrayOfInt1[n] = (1 + arrayOfInt1[n]);
        int i8 = m;
        i4 = n;
        i5 = j;
        i6 = i8;
        i1++;
        int i7 = i6;
        j = i5;
        n = i4;
        m = i7;
      }
      else
      {
        int i2;
        if (n == k - 1)
          try
          {
            if ((a(e, a(arrayOfInt1))) && (paramBitArray.isRange(Math.max(0, j - (i1 - j) / 2), j, false)))
            {
              int[] arrayOfInt2 = { j, i1 };
              return arrayOfInt2;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            j += arrayOfInt1[0] + arrayOfInt1[1];
            System.arraycopy(arrayOfInt1, 2, arrayOfInt1, 0, k - 2);
            arrayOfInt1[(k - 2)] = 0;
            arrayOfInt1[(k - 1)] = 0;
            i2 = n - 1;
          }
        while (true)
        {
          arrayOfInt1[i2] = 1;
          int i3 = m ^ 0x1;
          i4 = i2;
          i5 = j;
          i6 = i3;
          break;
          i2 = n + 1;
        }
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt1 = a(paramBitArray);
    arrayOfInt1[1] = 0;
    int i = paramBitArray.getNextSet(arrayOfInt1[1]);
    int j = paramBitArray.getSize();
    StringBuilder localStringBuilder = new StringBuilder();
    int[] arrayOfInt2 = new int[7];
    while (true)
    {
      for (int k = 0; k < arrayOfInt2.length; k++)
        arrayOfInt2[k] = 0;
      recordPattern(paramBitArray, i, arrayOfInt2);
      char c1 = a(arrayOfInt2);
      if (c1 == '!')
        throw NotFoundException.getNotFoundInstance();
      localStringBuilder.append(c1);
      int m = arrayOfInt2.length;
      int n = 0;
      int i1 = i;
      while (n < m)
      {
        i1 += arrayOfInt2[n];
        n++;
      }
      int i2 = paramBitArray.getNextSet(i1);
      if (i2 >= j)
      {
        int i3 = 0;
        int i4 = arrayOfInt2.length;
        for (int i5 = 0; i5 < i4; i5++)
          i3 += arrayOfInt2[i5];
        int i6 = i2 - i - i3;
        if ((i2 != j) && (i6 / 2 < i3))
          throw NotFoundException.getNotFoundInstance();
        if (localStringBuilder.length() < 2)
          throw NotFoundException.getNotFoundInstance();
        char c2 = localStringBuilder.charAt(0);
        if (!a(e, c2))
          throw NotFoundException.getNotFoundInstance();
        for (int i7 = 1; ; i7++)
          if (i7 < localStringBuilder.length())
          {
            if ((localStringBuilder.charAt(i7) == c2) && (i7 + 1 != localStringBuilder.length()))
              localStringBuilder.delete(i7 + 1, -1 + localStringBuilder.length());
          }
          else
          {
            if (localStringBuilder.length() > 6)
              break;
            throw NotFoundException.getNotFoundInstance();
          }
        localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
        localStringBuilder.deleteCharAt(0);
        float f1 = (arrayOfInt1[1] + arrayOfInt1[0]) / 2.0F;
        float f2 = (i + i2) / 2.0F;
        String str = localStringBuilder.toString();
        ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
        arrayOfResultPoint[0] = new ResultPoint(f1, paramInt);
        arrayOfResultPoint[1] = new ResultPoint(f2, paramInt);
        return new Result(str, null, arrayOfResultPoint, BarcodeFormat.CODABAR);
      }
      i = i2;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.CodaBarReader
 * JD-Core Version:    0.6.2
 */