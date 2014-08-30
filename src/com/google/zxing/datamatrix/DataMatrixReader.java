package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.datamatrix.decoder.Decoder;
import com.google.zxing.datamatrix.detector.Detector;
import java.util.List;
import java.util.Map;

public final class DataMatrixReader
  implements Reader
{
  private static final ResultPoint[] a = new ResultPoint[0];
  private final Decoder b = new Decoder();

  private static int a(int[] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.getWidth();
    int j = paramArrayOfInt[0];
    int k = paramArrayOfInt[1];
    while ((j < i) && (paramBitMatrix.get(j, k)))
      j++;
    if (j == i)
      throw NotFoundException.getNotFoundInstance();
    int m = j - paramArrayOfInt[0];
    if (m == 0)
      throw NotFoundException.getNotFoundInstance();
    return m;
  }

  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    int[] arrayOfInt1 = paramBitMatrix.getTopLeftOnBit();
    int[] arrayOfInt2 = paramBitMatrix.getBottomRightOnBit();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
      throw NotFoundException.getNotFoundInstance();
    int i = paramBitMatrix.getWidth();
    int j = arrayOfInt1[0];
    int k = arrayOfInt1[1];
    while ((j < i) && (paramBitMatrix.get(j, k)))
      j++;
    if (j == i)
      throw NotFoundException.getNotFoundInstance();
    int m = j - arrayOfInt1[0];
    if (m == 0)
      throw NotFoundException.getNotFoundInstance();
    int n = arrayOfInt1[1];
    int i1 = arrayOfInt2[1];
    int i2 = arrayOfInt1[0];
    int i3 = (1 + (arrayOfInt2[0] - i2)) / m;
    int i4 = (1 + (i1 - n)) / m;
    if ((i3 <= 0) || (i4 <= 0))
      throw NotFoundException.getNotFoundInstance();
    int i5 = m >> 1;
    int i6 = n + i5;
    int i7 = i5 + i2;
    BitMatrix localBitMatrix = new BitMatrix(i3, i4);
    for (int i8 = 0; i8 < i4; i8++)
    {
      int i9 = i6 + i8 * m;
      for (int i10 = 0; i10 < i3; i10++)
        if (paramBitMatrix.get(i7 + i10 * m, i9))
          localBitMatrix.set(i10, i8);
    }
    return localBitMatrix;
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap)
  {
    return decode(paramBinaryBitmap, null);
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    DecoderResult localDecoderResult;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.PURE_BARCODE)))
    {
      BitMatrix localBitMatrix1 = paramBinaryBitmap.getBlackMatrix();
      int[] arrayOfInt1 = localBitMatrix1.getTopLeftOnBit();
      int[] arrayOfInt2 = localBitMatrix1.getBottomRightOnBit();
      if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
        throw NotFoundException.getNotFoundInstance();
      int i = localBitMatrix1.getWidth();
      int j = arrayOfInt1[0];
      int k = arrayOfInt1[1];
      while ((j < i) && (localBitMatrix1.get(j, k)))
        j++;
      if (j == i)
        throw NotFoundException.getNotFoundInstance();
      int m = j - arrayOfInt1[0];
      if (m == 0)
        throw NotFoundException.getNotFoundInstance();
      int n = arrayOfInt1[1];
      int i1 = arrayOfInt2[1];
      int i2 = arrayOfInt1[0];
      int i3 = (1 + (arrayOfInt2[0] - i2)) / m;
      int i4 = (1 + (i1 - n)) / m;
      if ((i3 <= 0) || (i4 <= 0))
        throw NotFoundException.getNotFoundInstance();
      int i5 = m >> 1;
      int i6 = n + i5;
      int i7 = i5 + i2;
      BitMatrix localBitMatrix2 = new BitMatrix(i3, i4);
      for (int i8 = 0; i8 < i4; i8++)
      {
        int i9 = i6 + i8 * m;
        for (int i10 = 0; i10 < i3; i10++)
          if (localBitMatrix1.get(i7 + i10 * m, i9))
            localBitMatrix2.set(i10, i8);
      }
      localDecoderResult = this.b.decode(localBitMatrix2);
    }
    DetectorResult localDetectorResult;
    for (ResultPoint[] arrayOfResultPoint = a; ; arrayOfResultPoint = localDetectorResult.getPoints())
    {
      Result localResult = new Result(localDecoderResult.getText(), localDecoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.DATA_MATRIX);
      List localList = localDecoderResult.getByteSegments();
      if (localList != null)
        localResult.putMetadata(ResultMetadataType.BYTE_SEGMENTS, localList);
      String str = localDecoderResult.getECLevel();
      if (str != null)
        localResult.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
      return localResult;
      localDetectorResult = new Detector(paramBinaryBitmap.getBlackMatrix()).detect();
      localDecoderResult = this.b.decode(localDetectorResult.getBits());
    }
  }

  public final void reset()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.DataMatrixReader
 * JD-Core Version:    0.6.2
 */