package com.google.zxing.pdf417;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.pdf417.decoder.Decoder;
import com.google.zxing.pdf417.detector.Detector;
import java.util.Map;

public final class PDF417Reader
  implements Reader
{
  private static final ResultPoint[] a = new ResultPoint[0];
  private final Decoder b = new Decoder();

  private static int a(int paramInt1, int paramInt2, BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.getWidth();
    int j = 0;
    boolean bool2;
    for (boolean bool1 = true; (paramInt1 < i - 1) && (j < 8); bool1 = bool2)
    {
      paramInt1++;
      bool2 = paramBitMatrix.get(paramInt1, paramInt2);
      if (bool1 != bool2)
        j++;
    }
    if (paramInt1 == i - 1)
      throw NotFoundException.getNotFoundInstance();
    return paramInt1;
  }

  private static int a(int[] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = paramArrayOfInt[0];
    int j = paramArrayOfInt[1];
    int k = paramBitMatrix.getWidth();
    while ((i < k) && (paramBitMatrix.get(i, j)))
      i++;
    if (i == k)
      throw NotFoundException.getNotFoundInstance();
    int m = i - paramArrayOfInt[0] >>> 3;
    if (m == 0)
      throw NotFoundException.getNotFoundInstance();
    return m;
  }

  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    boolean bool1 = true;
    int[] arrayOfInt1 = paramBitMatrix.getTopLeftOnBit();
    int[] arrayOfInt2 = paramBitMatrix.getBottomRightOnBit();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
      throw NotFoundException.getNotFoundInstance();
    int i = arrayOfInt1[0];
    int j = arrayOfInt1[bool1];
    int k = paramBitMatrix.getWidth();
    while ((i < k) && (paramBitMatrix.get(i, j)))
      i++;
    if (i == k)
      throw NotFoundException.getNotFoundInstance();
    int m = i - arrayOfInt1[0] >>> 3;
    if (m == 0)
      throw NotFoundException.getNotFoundInstance();
    int n = arrayOfInt1[bool1];
    int i1 = arrayOfInt2[bool1];
    int i2 = arrayOfInt1[0];
    int i3 = paramBitMatrix.getWidth();
    boolean bool2 = bool1;
    int i4 = i2;
    int i5 = 0;
    while ((i4 < i3 - 1) && (i5 < 8))
    {
      i4++;
      boolean bool4 = paramBitMatrix.get(i4, n);
      if (bool2 != bool4)
        i5++;
      bool2 = bool4;
    }
    if (i4 == i3 - 1)
      throw NotFoundException.getNotFoundInstance();
    int i6 = arrayOfInt1[0];
    for (int i7 = -1 + paramBitMatrix.getWidth(); (i7 > i6) && (!paramBitMatrix.get(i7, n)); i7--);
    int i8 = i7;
    int i9 = 0;
    while ((i8 > i6) && (i9 < 9))
    {
      int i18 = i8 - 1;
      boolean bool3 = paramBitMatrix.get(i18, n);
      if (bool1 != bool3)
        i9++;
      bool1 = bool3;
      i8 = i18;
    }
    if (i8 == i6)
      throw NotFoundException.getNotFoundInstance();
    int i10 = (1 + (i8 - i4)) / m;
    int i11 = (1 + (i1 - n)) / m;
    if ((i10 <= 0) || (i11 <= 0))
      throw NotFoundException.getNotFoundInstance();
    int i12 = m >> 1;
    int i13 = n + i12;
    int i14 = i4 + i12;
    BitMatrix localBitMatrix = new BitMatrix(i10, i11);
    for (int i15 = 0; i15 < i11; i15++)
    {
      int i16 = i13 + i15 * m;
      for (int i17 = 0; i17 < i10; i17++)
        if (paramBitMatrix.get(i14 + i17 * m, i16))
          localBitMatrix.set(i17, i15);
    }
    return localBitMatrix;
  }

  private static int b(int paramInt1, int paramInt2, BitMatrix paramBitMatrix)
  {
    for (int i = -1 + paramBitMatrix.getWidth(); (i > paramInt1) && (!paramBitMatrix.get(i, paramInt2)); i--);
    int j = 0;
    boolean bool1 = true;
    while ((i > paramInt1) && (j < 9))
    {
      int k = i - 1;
      boolean bool2 = paramBitMatrix.get(k, paramInt2);
      if (bool1 != bool2)
        j++;
      bool1 = bool2;
      i = k;
    }
    if (i == paramInt1)
      throw NotFoundException.getNotFoundInstance();
    return i;
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap)
  {
    return decode(paramBinaryBitmap, null);
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    boolean bool1 = true;
    DecoderResult localDecoderResult;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.PURE_BARCODE)))
    {
      BitMatrix localBitMatrix1 = paramBinaryBitmap.getBlackMatrix();
      int[] arrayOfInt1 = localBitMatrix1.getTopLeftOnBit();
      int[] arrayOfInt2 = localBitMatrix1.getBottomRightOnBit();
      if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
        throw NotFoundException.getNotFoundInstance();
      int i = arrayOfInt1[0];
      int j = arrayOfInt1[bool1];
      int k = localBitMatrix1.getWidth();
      while ((i < k) && (localBitMatrix1.get(i, j)))
        i++;
      if (i == k)
        throw NotFoundException.getNotFoundInstance();
      int m = i - arrayOfInt1[0] >>> 3;
      if (m == 0)
        throw NotFoundException.getNotFoundInstance();
      int n = arrayOfInt1[bool1];
      int i1 = arrayOfInt2[bool1];
      int i2 = arrayOfInt1[0];
      int i3 = localBitMatrix1.getWidth();
      boolean bool2 = bool1;
      int i4 = i2;
      int i5 = 0;
      while ((i4 < i3 - 1) && (i5 < 8))
      {
        i4++;
        boolean bool4 = localBitMatrix1.get(i4, n);
        if (bool2 != bool4)
          i5++;
        bool2 = bool4;
      }
      if (i4 == i3 - 1)
        throw NotFoundException.getNotFoundInstance();
      int i6 = arrayOfInt1[0];
      for (int i7 = -1 + localBitMatrix1.getWidth(); (i7 > i6) && (!localBitMatrix1.get(i7, n)); i7--);
      int i8 = i7;
      int i9 = 0;
      while ((i8 > i6) && (i9 < 9))
      {
        int i18 = i8 - 1;
        boolean bool3 = localBitMatrix1.get(i18, n);
        if (bool1 != bool3)
          i9++;
        bool1 = bool3;
        i8 = i18;
      }
      if (i8 == i6)
        throw NotFoundException.getNotFoundInstance();
      int i10 = (1 + (i8 - i4)) / m;
      int i11 = (1 + (i1 - n)) / m;
      if ((i10 <= 0) || (i11 <= 0))
        throw NotFoundException.getNotFoundInstance();
      int i12 = m >> 1;
      int i13 = n + i12;
      int i14 = i4 + i12;
      BitMatrix localBitMatrix2 = new BitMatrix(i10, i11);
      for (int i15 = 0; i15 < i11; i15++)
      {
        int i16 = i13 + i15 * m;
        for (int i17 = 0; i17 < i10; i17++)
          if (localBitMatrix1.get(i14 + i17 * m, i16))
            localBitMatrix2.set(i17, i15);
      }
      localDecoderResult = this.b.decode(localBitMatrix2);
    }
    DetectorResult localDetectorResult;
    for (ResultPoint[] arrayOfResultPoint = a; ; arrayOfResultPoint = localDetectorResult.getPoints())
    {
      return new Result(localDecoderResult.getText(), localDecoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.PDF_417);
      localDetectorResult = new Detector(paramBinaryBitmap).detect();
      localDecoderResult = this.b.decode(localDetectorResult.getBits());
    }
  }

  public final void reset()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.PDF417Reader
 * JD-Core Version:    0.6.2
 */