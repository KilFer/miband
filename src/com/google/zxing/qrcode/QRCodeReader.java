package com.google.zxing.qrcode;

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
import com.google.zxing.qrcode.decoder.Decoder;
import com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

public class QRCodeReader
  implements Reader
{
  private static final ResultPoint[] a = new ResultPoint[0];
  private final Decoder b = new Decoder();

  private static float a(int[] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.getHeight();
    int j = paramBitMatrix.getWidth();
    int k = paramArrayOfInt[0];
    int m = paramArrayOfInt[1];
    int n = 1;
    int i1 = m;
    int i2 = k;
    int i3 = 0;
    int i6;
    label79: int i4;
    if ((i2 < j) && (i1 < i))
    {
      if (n == paramBitMatrix.get(i2, i1))
        break label133;
      int i5 = i3 + 1;
      if (i5 != 5)
        if (n == 0)
        {
          i6 = 1;
          i4 = i6;
          i3 = i5;
        }
    }
    while (true)
    {
      i2++;
      i1++;
      n = i4;
      break;
      i6 = 0;
      break label79;
      if ((i2 == j) || (i1 == i))
        throw NotFoundException.getNotFoundInstance();
      return (i2 - paramArrayOfInt[0]) / 7.0F;
      label133: i4 = n;
    }
  }

  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    int[] arrayOfInt1 = paramBitMatrix.getTopLeftOnBit();
    int[] arrayOfInt2 = paramBitMatrix.getBottomRightOnBit();
    if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
      throw NotFoundException.getNotFoundInstance();
    int i = paramBitMatrix.getHeight();
    int j = paramBitMatrix.getWidth();
    int k = arrayOfInt1[0];
    int m = arrayOfInt1[1];
    int n = 1;
    int i1 = m;
    int i2 = k;
    int i3 = 0;
    int i18;
    label103: int i16;
    if ((i2 < j) && (i1 < i))
    {
      if (n == paramBitMatrix.get(i2, i1))
        break label370;
      int i17 = i3 + 1;
      if (i17 != 5)
        if (n == 0)
        {
          i18 = 1;
          i16 = i18;
          i3 = i17;
        }
    }
    while (true)
    {
      i2++;
      i1++;
      n = i16;
      break;
      i18 = 0;
      break label103;
      if ((i2 == j) || (i1 == i))
        throw NotFoundException.getNotFoundInstance();
      float f = (i2 - arrayOfInt1[0]) / 7.0F;
      int i4 = arrayOfInt1[1];
      int i5 = arrayOfInt2[1];
      int i6 = arrayOfInt1[0];
      int i7 = arrayOfInt2[0];
      if (i5 - i4 != i7 - i6)
        i7 = i6 + (i5 - i4);
      int i8 = Math.round((1 + (i7 - i6)) / f);
      int i9 = Math.round((1 + (i5 - i4)) / f);
      if ((i8 <= 0) || (i9 <= 0))
        throw NotFoundException.getNotFoundInstance();
      if (i9 != i8)
        throw NotFoundException.getNotFoundInstance();
      int i10 = Math.round(f / 2.0F);
      int i11 = i4 + i10;
      int i12 = i6 + i10;
      BitMatrix localBitMatrix = new BitMatrix(i8, i9);
      for (int i13 = 0; i13 < i9; i13++)
      {
        int i14 = i11 + (int)(f * i13);
        for (int i15 = 0; i15 < i8; i15++)
          if (paramBitMatrix.get(i12 + (int)(f * i15), i14))
            localBitMatrix.set(i15, i13);
      }
      return localBitMatrix;
      label370: i16 = n;
    }
  }

  public Result decode(BinaryBitmap paramBinaryBitmap)
  {
    return decode(paramBinaryBitmap, null);
  }

  public Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    BitMatrix localBitMatrix1;
    int[] arrayOfInt1;
    int[] arrayOfInt2;
    int i;
    int j;
    int n;
    int i1;
    int i2;
    int i18;
    label138: int i16;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.PURE_BARCODE)))
    {
      localBitMatrix1 = paramBinaryBitmap.getBlackMatrix();
      arrayOfInt1 = localBitMatrix1.getTopLeftOnBit();
      arrayOfInt2 = localBitMatrix1.getBottomRightOnBit();
      if ((arrayOfInt1 == null) || (arrayOfInt2 == null))
        throw NotFoundException.getNotFoundInstance();
      i = localBitMatrix1.getHeight();
      j = localBitMatrix1.getWidth();
      int k = arrayOfInt1[0];
      int m = arrayOfInt1[1];
      n = 1;
      i1 = m;
      i2 = k;
      int i3 = 0;
      if ((i2 < j) && (i1 < i))
      {
        if (n == localBitMatrix1.get(i2, i1))
          break label536;
        int i17 = i3 + 1;
        if (i17 != 5)
          if (n == 0)
          {
            i18 = 1;
            i16 = i18;
            i3 = i17;
          }
      }
    }
    while (true)
    {
      i2++;
      i1++;
      n = i16;
      break;
      i18 = 0;
      break label138;
      if ((i2 == j) || (i1 == i))
        throw NotFoundException.getNotFoundInstance();
      float f = (i2 - arrayOfInt1[0]) / 7.0F;
      int i4 = arrayOfInt1[1];
      int i5 = arrayOfInt2[1];
      int i6 = arrayOfInt1[0];
      int i7 = arrayOfInt2[0];
      if (i5 - i4 != i7 - i6)
        i7 = i6 + (i5 - i4);
      int i8 = Math.round((1 + (i7 - i6)) / f);
      int i9 = Math.round((1 + (i5 - i4)) / f);
      if ((i8 <= 0) || (i9 <= 0))
        throw NotFoundException.getNotFoundInstance();
      if (i9 != i8)
        throw NotFoundException.getNotFoundInstance();
      int i10 = Math.round(f / 2.0F);
      int i11 = i4 + i10;
      int i12 = i6 + i10;
      BitMatrix localBitMatrix2 = new BitMatrix(i8, i9);
      for (int i13 = 0; i13 < i9; i13++)
      {
        int i14 = i11 + (int)(f * i13);
        for (int i15 = 0; i15 < i8; i15++)
          if (localBitMatrix1.get(i12 + (int)(f * i15), i14))
            localBitMatrix2.set(i15, i13);
      }
      DecoderResult localDecoderResult = this.b.decode(localBitMatrix2, paramMap);
      DetectorResult localDetectorResult;
      for (ResultPoint[] arrayOfResultPoint = a; ; arrayOfResultPoint = localDetectorResult.getPoints())
      {
        Result localResult = new Result(localDecoderResult.getText(), localDecoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.QR_CODE);
        List localList = localDecoderResult.getByteSegments();
        if (localList != null)
          localResult.putMetadata(ResultMetadataType.BYTE_SEGMENTS, localList);
        String str = localDecoderResult.getECLevel();
        if (str != null)
          localResult.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        return localResult;
        localDetectorResult = new Detector(paramBinaryBitmap.getBlackMatrix()).detect(paramMap);
        localDecoderResult = this.b.decode(localDetectorResult.getBits(), paramMap);
      }
      label536: i16 = n;
    }
  }

  protected Decoder getDecoder()
  {
    return this.b;
  }

  public void reset()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.QRCodeReader
 * JD-Core Version:    0.6.2
 */