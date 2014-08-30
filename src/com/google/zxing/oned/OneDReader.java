package com.google.zxing.oned;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public abstract class OneDReader
  implements Reader
{
  protected static final int INTEGER_MATH_SHIFT = 8;
  protected static final int PATTERN_MATCH_RESULT_SCALE_FACTOR = 256;

  private Result a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    int i = paramBinaryBitmap.getWidth();
    int j = paramBinaryBitmap.getHeight();
    BitArray localBitArray1 = new BitArray(i);
    int k = j >> 1;
    int m;
    int n;
    label55: int i2;
    label75: int i3;
    Object localObject1;
    Object localObject2;
    label85: int i4;
    int i5;
    label110: int i6;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
    {
      m = 1;
      if (m == 0)
        break label333;
      n = 8;
      int i1 = Math.max(1, j >> n);
      if (m == 0)
        break label339;
      i2 = j;
      i3 = 0;
      localObject1 = localBitArray1;
      localObject2 = paramMap;
      if (i3 >= i2)
        break label380;
      i4 = i3 + 1 >> 1;
      if ((i3 & 0x1) != 0)
        break label346;
      i5 = 1;
      if (i5 == 0)
        break label352;
      i6 = k + i4 * i1;
      if ((i6 < 0) || (i6 >= j))
        break label380;
    }
    while (true)
    {
      try
      {
        while (true)
        {
          BitArray localBitArray2 = paramBinaryBitmap.getBlackRow(i6, (BitArray)localObject1);
          localObject1 = localBitArray2;
          int i7 = 0;
          if (i7 >= 2)
            break label374;
          if (i7 != 1)
            break label384;
          ((BitArray)localObject1).reverse();
          if ((localObject2 == null) || (!((Map)localObject2).containsKey(DecodeHintType.NEED_RESULT_POINT_CALLBACK)))
            break label384;
          localObject3 = new EnumMap(DecodeHintType.class);
          ((Map)localObject3).putAll((Map)localObject2);
          ((Map)localObject3).remove(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
          try
          {
            Result localResult = decodeRow(i6, (BitArray)localObject1, (Map)localObject3);
            if (i7 == 1)
            {
              localResult.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(180));
              ResultPoint[] arrayOfResultPoint = localResult.getResultPoints();
              if (arrayOfResultPoint != null)
              {
                arrayOfResultPoint[0] = new ResultPoint(i - arrayOfResultPoint[0].getX() - 1.0F, arrayOfResultPoint[0].getY());
                arrayOfResultPoint[1] = new ResultPoint(i - arrayOfResultPoint[1].getX() - 1.0F, arrayOfResultPoint[1].getY());
              }
            }
            return localResult;
            m = 0;
            break;
            label333: n = 5;
            break label55;
            label339: i2 = 15;
            break label75;
            label346: i5 = 0;
            break label110;
            label352: i4 = -i4;
          }
          catch (ReaderException localReaderException)
          {
            i7++;
            localObject2 = localObject3;
          }
        }
        continue;
      }
      catch (NotFoundException localNotFoundException)
      {
        label374: i3++;
      }
      break label85;
      label380: throw NotFoundException.getNotFoundInstance();
      label384: Object localObject3 = localObject2;
    }
  }

  protected static int patternMatchVariance(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = paramArrayOfInt1.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < i)
    {
      m += paramArrayOfInt1[j];
      k += paramArrayOfInt2[j];
      j++;
    }
    if (m < k);
    int i3;
    label143: 
    while (true)
    {
      return 2147483647;
      int n = (m << 8) / k;
      int i1 = paramInt * n >> 8;
      int i2 = 0;
      i3 = 0;
      if (i2 >= i)
        break;
      int i4 = paramArrayOfInt1[i2] << 8;
      int i5 = n * paramArrayOfInt2[i2];
      if (i4 > i5);
      for (int i6 = i4 - i5; ; i6 = i5 - i4)
      {
        if (i6 > i1)
          break label143;
        i3 += i6;
        i2++;
        break;
      }
    }
    return i3 / m;
  }

  protected static void recordPattern(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    Arrays.fill(paramArrayOfInt, 0, i, 0);
    int j = paramBitArray.getSize();
    if (paramInt >= j)
      throw NotFoundException.getNotFoundInstance();
    if (!paramBitArray.get(paramInt));
    int m;
    int n;
    int i4;
    for (int k = 1; ; k = 0)
    {
      m = k;
      n = 0;
      while (true)
      {
        if (paramInt >= j)
          break label137;
        if ((m ^ paramBitArray.get(paramInt)) == 0)
          break;
        paramArrayOfInt[n] = (1 + paramArrayOfInt[n]);
        i4 = m;
        paramInt++;
        m = i4;
      }
    }
    int i1 = n + 1;
    if (i1 != i)
    {
      paramArrayOfInt[i1] = 1;
      if (m == 0);
      for (int i2 = 1; ; i2 = 0)
      {
        int i3 = i1;
        i4 = i2;
        n = i3;
        break;
      }
      label137: i1 = n;
    }
    if ((i1 != i) && ((i1 != i - 1) || (paramInt != j)))
      throw NotFoundException.getNotFoundInstance();
  }

  protected static void recordPatternInReverse(BitArray paramBitArray, int paramInt, int[] paramArrayOfInt)
  {
    int i = paramArrayOfInt.length;
    boolean bool = paramBitArray.get(paramInt);
    while ((paramInt > 0) && (i >= 0))
    {
      paramInt--;
      if (paramBitArray.get(paramInt) != bool)
      {
        i--;
        if (!bool)
          bool = true;
        else
          bool = false;
      }
    }
    if (i >= 0)
      throw NotFoundException.getNotFoundInstance();
    recordPattern(paramBitArray, paramInt + 1, paramArrayOfInt);
  }

  public Result decode(BinaryBitmap paramBinaryBitmap)
  {
    return decode(paramBinaryBitmap, null);
  }

  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    try
    {
      Result localResult2 = a(paramBinaryBitmap, paramMap);
      return localResult2;
    }
    catch (NotFoundException localNotFoundException)
    {
      int i;
      if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
        i = 1;
      while ((i != 0) && (paramBinaryBitmap.isRotateSupported()))
      {
        BinaryBitmap localBinaryBitmap = paramBinaryBitmap.rotateCounterClockwise();
        Result localResult1 = a(localBinaryBitmap, paramMap);
        Map localMap = localResult1.getResultMetadata();
        int j = 270;
        if ((localMap != null) && (localMap.containsKey(ResultMetadataType.ORIENTATION)))
          j = (270 + ((Integer)localMap.get(ResultMetadataType.ORIENTATION)).intValue()) % 360;
        localResult1.putMetadata(ResultMetadataType.ORIENTATION, Integer.valueOf(j));
        ResultPoint[] arrayOfResultPoint = localResult1.getResultPoints();
        if (arrayOfResultPoint != null)
        {
          int k = localBinaryBitmap.getHeight();
          int m = 0;
          while (true)
            if (m < arrayOfResultPoint.length)
            {
              arrayOfResultPoint[m] = new ResultPoint(k - arrayOfResultPoint[m].getY() - 1.0F, arrayOfResultPoint[m].getX());
              m++;
              continue;
              i = 0;
              break;
            }
        }
        return localResult1;
      }
    }
    throw localNotFoundException;
  }

  public abstract Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap);

  public void reset()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.OneDReader
 * JD-Core Version:    0.6.2
 */