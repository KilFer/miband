package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader
  implements MultipleBarcodeReader
{
  private static final int a = 100;
  private final Reader b;

  public GenericMultipleBarcodeReader(Reader paramReader)
  {
    this.b = paramReader;
  }

  private static Result a(Result paramResult, int paramInt1, int paramInt2)
  {
    ResultPoint[] arrayOfResultPoint1 = paramResult.getResultPoints();
    if (arrayOfResultPoint1 == null)
      return paramResult;
    ResultPoint[] arrayOfResultPoint2 = new ResultPoint[arrayOfResultPoint1.length];
    for (int i = 0; i < arrayOfResultPoint1.length; i++)
    {
      ResultPoint localResultPoint = arrayOfResultPoint1[i];
      arrayOfResultPoint2[i] = new ResultPoint(localResultPoint.getX() + paramInt1, localResultPoint.getY() + paramInt2);
    }
    return new Result(paramResult.getText(), paramResult.getRawBytes(), arrayOfResultPoint2, paramResult.getBarcodeFormat());
  }

  private void a(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap, List<Result> paramList, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    while (true)
    {
      float f3;
      float f4;
      try
      {
        Result localResult1 = this.b.decode(paramBinaryBitmap, paramMap);
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext())
          break label501;
        if (!((Result)localIterator.next()).getText().equals(localResult1.getText()))
          continue;
        j = 1;
        if (j != 0)
          return;
        ResultPoint[] arrayOfResultPoint1 = localResult1.getResultPoints();
        int m;
        int n;
        float f1;
        float f2;
        if (arrayOfResultPoint1 == null)
        {
          localResult2 = localResult1;
          paramList.add(localResult2);
          ResultPoint[] arrayOfResultPoint3 = localResult1.getResultPoints();
          if ((arrayOfResultPoint3 == null) || (arrayOfResultPoint3.length == 0))
            continue;
          m = paramBinaryBitmap.getWidth();
          n = paramBinaryBitmap.getHeight();
          f1 = m;
          f2 = n;
          f3 = 0.0F;
          f4 = 0.0F;
          int i1 = arrayOfResultPoint3.length;
          int i2 = 0;
          if (i2 >= i1)
            continue;
          ResultPoint localResultPoint1 = arrayOfResultPoint3[i2];
          f5 = localResultPoint1.getX();
          f6 = localResultPoint1.getY();
          if (f5 < f1)
            f1 = f5;
          if (f6 < f2)
            f2 = f6;
          if (f5 <= f3)
            break label494;
          if (f6 <= f4)
            break label487;
          i2++;
          f4 = f6;
          f3 = f5;
          continue;
        }
        ResultPoint[] arrayOfResultPoint2 = new ResultPoint[arrayOfResultPoint1.length];
        int k = 0;
        if (k < arrayOfResultPoint1.length)
        {
          ResultPoint localResultPoint2 = arrayOfResultPoint1[k];
          arrayOfResultPoint2[k] = new ResultPoint(localResultPoint2.getX() + paramInt1, localResultPoint2.getY() + i);
          k++;
          continue;
        }
        Result localResult2 = new Result(localResult1.getText(), localResult1.getRawBytes(), arrayOfResultPoint2, localResult1.getBarcodeFormat());
        continue;
        if (f1 > 100.0F)
        {
          int i8 = (int)f1;
          a(paramBinaryBitmap.crop(0, 0, i8, n), paramMap, paramList, paramInt1, i);
        }
        if (f2 > 100.0F)
        {
          int i7 = (int)f2;
          a(paramBinaryBitmap.crop(0, 0, m, i7), paramMap, paramList, paramInt1, i);
        }
        if (f3 < m - 100)
        {
          int i5 = (int)f3;
          int i6 = m - (int)f3;
          a(paramBinaryBitmap.crop(i5, 0, i6, n), paramMap, paramList, paramInt1 + (int)f3, i);
        }
        if (f4 >= n - 100)
          continue;
        int i3 = (int)f4;
        int i4 = n - (int)f4;
        paramBinaryBitmap = paramBinaryBitmap.crop(0, i3, m, i4);
        i += (int)f4;
        continue;
      }
      catch (ReaderException localReaderException)
      {
        return;
      }
      label487: float f6 = f4;
      continue;
      label494: float f5 = f3;
      continue;
      label501: int j = 0;
    }
  }

  public final Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap)
  {
    return decodeMultiple(paramBinaryBitmap, null);
  }

  public final Result[] decodeMultiple(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramBinaryBitmap, paramMap, localArrayList, 0, 0);
    if (localArrayList.isEmpty())
      throw NotFoundException.getNotFoundInstance();
    return (Result[])localArrayList.toArray(new Result[localArrayList.size()]);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.multi.GenericMultipleBarcodeReader
 * JD-Core Version:    0.6.2
 */