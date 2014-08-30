package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class ITFReader extends OneDReader
{
  static final int[][] a = { { 1, 1, 3, 3, 1 }, { 3, 1, 1, 1, 3 }, { 1, 3, 1, 1, 3 }, { 3, 3, 1, 1, 1 }, { 1, 1, 3, 1, 3 }, { 3, 1, 3, 1, 1 }, { 1, 3, 3, 1, 1 }, { 1, 1, 1, 3, 3 }, { 3, 1, 1, 3, 1 }, { 1, 3, 1, 3, 1 } };
  private static final int b = 107;
  private static final int c = 204;
  private static final int d = 3;
  private static final int e = 1;
  private static final int[] f = { 44, 24, 20, 18, 16, 14, 12, 10, 8, 6 };
  private static final int[] h = { 1, 1, 1, 1 };
  private static final int[] i = { 1, 1, 3 };
  private int g = -1;

  private static int a(int[] paramArrayOfInt)
  {
    int j = 107;
    int k = -1;
    int m = a.length;
    int n = 0;
    int i1;
    if (n < m)
    {
      i1 = patternMatchVariance(paramArrayOfInt, a[n], 204);
      if (i1 >= j)
        break label62;
      k = n;
    }
    while (true)
    {
      n++;
      j = i1;
      break;
      if (k >= 0)
        return k;
      throw NotFoundException.getNotFoundInstance();
      label62: i1 = j;
    }
  }

  private void a(BitArray paramBitArray, int paramInt)
  {
    int j = 10 * this.g;
    for (int k = paramInt - 1; (j > 0) && (k >= 0) && (!paramBitArray.get(k)); k--)
      j--;
    if (j != 0)
      throw NotFoundException.getNotFoundInstance();
  }

  private static void a(BitArray paramBitArray, int paramInt1, int paramInt2, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt1 = new int[10];
    int[] arrayOfInt2 = new int[5];
    int[] arrayOfInt3 = new int[5];
    int n;
    for (int j = paramInt1; j < paramInt2; j = n)
    {
      recordPattern(paramBitArray, j, arrayOfInt1);
      for (int k = 0; k < 5; k++)
      {
        int i2 = k << 1;
        arrayOfInt2[k] = arrayOfInt1[i2];
        arrayOfInt3[k] = arrayOfInt1[(i2 + 1)];
      }
      paramStringBuilder.append((char)(48 + a(arrayOfInt2)));
      paramStringBuilder.append((char)(48 + a(arrayOfInt3)));
      int m = arrayOfInt1.length;
      n = j;
      for (int i1 = 0; i1 < m; i1++)
        n += arrayOfInt1[i1];
    }
  }

  private int[] a(BitArray paramBitArray)
  {
    int[] arrayOfInt = a(paramBitArray, b(paramBitArray), h);
    this.g = (arrayOfInt[1] - arrayOfInt[0] >> 2);
    a(paramBitArray, arrayOfInt[0]);
    return arrayOfInt;
  }

  private static int[] a(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int[] arrayOfInt = new int[j];
    int k = paramBitArray.getSize();
    int m = paramInt;
    int n = 0;
    int i1 = 0;
    if (paramInt < k)
    {
      if ((i1 ^ paramBitArray.get(paramInt)) != 0)
        arrayOfInt[n] = (1 + arrayOfInt[n]);
      while (true)
      {
        paramInt++;
        break;
        if (n == j - 1)
        {
          if (patternMatchVariance(arrayOfInt, paramArrayOfInt, 204) < 107)
            return new int[] { m, paramInt };
          m += arrayOfInt[0] + arrayOfInt[1];
          System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, j - 2);
          arrayOfInt[(j - 2)] = 0;
          arrayOfInt[(j - 1)] = 0;
          n--;
        }
        while (true)
        {
          arrayOfInt[n] = 1;
          if (i1 != 0)
            break label159;
          i1 = 1;
          break;
          n++;
        }
        label159: i1 = 0;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }

  private static int b(BitArray paramBitArray)
  {
    int j = paramBitArray.getSize();
    int k = paramBitArray.getNextSet(0);
    if (k == j)
      throw NotFoundException.getNotFoundInstance();
    return k;
  }

  private int[] c(BitArray paramBitArray)
  {
    paramBitArray.reverse();
    try
    {
      int[] arrayOfInt = a(paramBitArray, b(paramBitArray), i);
      a(paramBitArray, arrayOfInt[0]);
      int j = arrayOfInt[0];
      arrayOfInt[0] = (paramBitArray.getSize() - arrayOfInt[1]);
      arrayOfInt[1] = (paramBitArray.getSize() - j);
      return arrayOfInt;
    }
    finally
    {
      paramBitArray.reverse();
    }
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int[] arrayOfInt1 = a(paramBitArray, b(paramBitArray), h);
    this.g = (arrayOfInt1[1] - arrayOfInt1[0] >> 2);
    a(paramBitArray, arrayOfInt1[0]);
    int[] arrayOfInt2 = c(paramBitArray);
    StringBuilder localStringBuilder = new StringBuilder(20);
    a(paramBitArray, arrayOfInt1[1], arrayOfInt2[0], localStringBuilder);
    String str = localStringBuilder.toString();
    if (paramMap != null);
    for (int[] arrayOfInt3 = (int[])paramMap.get(DecodeHintType.ALLOWED_LENGTHS); ; arrayOfInt3 = null)
    {
      if (arrayOfInt3 == null)
        arrayOfInt3 = f;
      int j = str.length();
      int k = arrayOfInt3.length;
      int m = 0;
      if (m < k)
        if (j != arrayOfInt3[m]);
      for (int n = 1; ; n = 0)
      {
        if (n == 0)
        {
          throw FormatException.getFormatInstance();
          m++;
          break;
        }
        ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
        arrayOfResultPoint[0] = new ResultPoint(arrayOfInt1[1], paramInt);
        arrayOfResultPoint[1] = new ResultPoint(arrayOfInt2[0], paramInt);
        return new Result(str, null, arrayOfResultPoint, BarcodeFormat.ITF);
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.ITFReader
 * JD-Core Version:    0.6.2
 */