package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.Map;

public abstract class UPCEANReader extends OneDReader
{
  private static final int a = 122;
  static final int[] b = { 1, 1, 1 };
  static final int[] c = { 1, 1, 1, 1, 1 };
  static final int[][] d = { { 3, 2, 1, 1 }, { 2, 2, 2, 1 }, { 2, 1, 2, 2 }, { 1, 4, 1, 1 }, { 1, 1, 3, 2 }, { 1, 2, 3, 1 }, { 1, 1, 1, 4 }, { 1, 3, 1, 2 }, { 1, 2, 1, 3 }, { 3, 1, 1, 2 } };
  static final int[][] e = new int[20][];
  private static final int f = 179;
  private final StringBuilder g = new StringBuilder(20);
  private final b h = new b();
  private final a i = new a();

  static
  {
    System.arraycopy(d, 0, e, 0, 10);
    for (int j = 10; j < 20; j++)
    {
      int[] arrayOfInt1 = d[(j - 10)];
      int[] arrayOfInt2 = new int[arrayOfInt1.length];
      for (int k = 0; k < arrayOfInt1.length; k++)
        arrayOfInt2[k] = arrayOfInt1[(-1 + (arrayOfInt1.length - k))];
      e[j] = arrayOfInt2;
    }
  }

  static int a(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt, int[][] paramArrayOfInt1)
  {
    recordPattern(paramBitArray, paramInt, paramArrayOfInt);
    int j = 122;
    int k = -1;
    int m = paramArrayOfInt1.length;
    int n = 0;
    int i1;
    if (n < m)
    {
      i1 = patternMatchVariance(paramArrayOfInt, paramArrayOfInt1[n], 179);
      if (i1 >= j)
        break label73;
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
      label73: i1 = j;
    }
  }

  private static boolean a(CharSequence paramCharSequence)
  {
    int j = paramCharSequence.length();
    if (j == 0);
    int n;
    do
    {
      return false;
      int k = j - 2;
      int m = 0;
      while (k >= 0)
      {
        int i3 = '￐' + paramCharSequence.charAt(k);
        if ((i3 < 0) || (i3 > 9))
          throw FormatException.getFormatInstance();
        m += i3;
        k -= 2;
      }
      n = m * 3;
      for (int i1 = j - 1; i1 >= 0; i1 -= 2)
      {
        int i2 = '￐' + paramCharSequence.charAt(i1);
        if ((i2 < 0) || (i2 > 9))
          throw FormatException.getFormatInstance();
        n += i2;
      }
    }
    while (n % 10 != 0);
    return true;
  }

  static int[] a(BitArray paramBitArray)
  {
    int[] arrayOfInt1 = new int[b.length];
    int j = 0;
    int[] arrayOfInt2 = null;
    boolean bool = false;
    while (!bool)
    {
      Arrays.fill(arrayOfInt1, 0, b.length, 0);
      arrayOfInt2 = a(paramBitArray, j, false, b, arrayOfInt1);
      int k = arrayOfInt2[0];
      j = arrayOfInt2[1];
      int m = k - (j - k);
      if (m >= 0)
        bool = paramBitArray.isRange(m, k, false);
    }
    return arrayOfInt2;
  }

  static int[] a(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
  {
    return a(paramBitArray, paramInt, paramBoolean, paramArrayOfInt, new int[paramArrayOfInt.length]);
  }

  private static int[] a(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = paramArrayOfInt1.length;
    int k = paramBitArray.getSize();
    int m;
    boolean bool;
    int n;
    int i1;
    if (paramBoolean)
    {
      m = paramBitArray.getNextUnset(paramInt);
      bool = paramBoolean;
      n = 0;
      i1 = m;
      label31: if (i1 >= k)
        break label190;
      if (!(bool ^ paramBitArray.get(i1)))
        break label78;
      paramArrayOfInt2[n] = (1 + paramArrayOfInt2[n]);
    }
    while (true)
    {
      i1++;
      break label31;
      m = paramBitArray.getNextSet(paramInt);
      break;
      label78: if (n == j - 1)
      {
        if (patternMatchVariance(paramArrayOfInt2, paramArrayOfInt1, 179) < 122)
          return new int[] { m, i1 };
        m += paramArrayOfInt2[0] + paramArrayOfInt2[1];
        System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, j - 2);
        paramArrayOfInt2[(j - 2)] = 0;
        paramArrayOfInt2[(j - 1)] = 0;
        n--;
      }
      while (true)
      {
        paramArrayOfInt2[n] = 1;
        if (bool)
          break label184;
        bool = true;
        break;
        n++;
      }
      label184: bool = false;
    }
    label190: throw NotFoundException.getNotFoundInstance();
  }

  abstract BarcodeFormat a();

  boolean checkChecksum(String paramString)
  {
    int j = paramString.length();
    boolean bool = false;
    if (j != 0)
    {
      int k = j - 2;
      int m = 0;
      while (k >= 0)
      {
        int i4 = '￐' + paramString.charAt(k);
        if ((i4 < 0) || (i4 > 9))
          throw FormatException.getFormatInstance();
        m += i4;
        k -= 2;
      }
      int n = m * 3;
      for (int i1 = j - 1; i1 >= 0; i1 -= 2)
      {
        int i3 = '￐' + paramString.charAt(i1);
        if ((i3 < 0) || (i3 > 9))
          throw FormatException.getFormatInstance();
        n += i3;
      }
      int i2 = n % 10;
      bool = false;
      if (i2 == 0)
        bool = true;
    }
    return bool;
  }

  int[] decodeEnd(BitArray paramBitArray, int paramInt)
  {
    return a(paramBitArray, paramInt, false, b);
  }

  protected abstract int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder);

  public Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    return decodeRow(paramInt, paramBitArray, a(paramBitArray), paramMap);
  }

  public Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt, Map<DecodeHintType, ?> paramMap)
  {
    if (paramMap == null);
    StringBuilder localStringBuilder;
    int[] arrayOfInt;
    for (ResultPointCallback localResultPointCallback = null; ; localResultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK))
    {
      if (localResultPointCallback != null)
        localResultPointCallback.foundPossibleResultPoint(new ResultPoint((paramArrayOfInt[0] + paramArrayOfInt[1]) / 2.0F, paramInt));
      localStringBuilder = this.g;
      localStringBuilder.setLength(0);
      int j = decodeMiddle(paramBitArray, paramArrayOfInt, localStringBuilder);
      if (localResultPointCallback != null)
        localResultPointCallback.foundPossibleResultPoint(new ResultPoint(j, paramInt));
      arrayOfInt = decodeEnd(paramBitArray, j);
      if (localResultPointCallback != null)
        localResultPointCallback.foundPossibleResultPoint(new ResultPoint((arrayOfInt[0] + arrayOfInt[1]) / 2.0F, paramInt));
      int k = arrayOfInt[1];
      int m = k + (k - arrayOfInt[0]);
      if ((m < paramBitArray.getSize()) && (paramBitArray.isRange(k, m, false)))
        break;
      throw NotFoundException.getNotFoundInstance();
    }
    String str1 = localStringBuilder.toString();
    if (!checkChecksum(str1))
      throw ChecksumException.getChecksumInstance();
    float f1 = (paramArrayOfInt[1] + paramArrayOfInt[0]) / 2.0F;
    float f2 = (arrayOfInt[1] + arrayOfInt[0]) / 2.0F;
    BarcodeFormat localBarcodeFormat = a();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
    arrayOfResultPoint[0] = new ResultPoint(f1, paramInt);
    arrayOfResultPoint[1] = new ResultPoint(f2, paramInt);
    Result localResult1 = new Result(str1, null, arrayOfResultPoint, localBarcodeFormat);
    try
    {
      Result localResult2 = this.h.a(paramInt, paramBitArray, arrayOfInt[1]);
      localResult1.putAllMetadata(localResult2.getResultMetadata());
      localResult1.addResultPoints(localResult2.getResultPoints());
      label327: if ((localBarcodeFormat == BarcodeFormat.EAN_13) || (localBarcodeFormat == BarcodeFormat.UPC_A))
      {
        String str2 = this.i.a(str1);
        if (str2 != null)
          localResult1.putMetadata(ResultMetadataType.POSSIBLE_COUNTRY, str2);
      }
      return localResult1;
    }
    catch (ReaderException localReaderException)
    {
      break label327;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.UPCEANReader
 * JD-Core Version:    0.6.2
 */