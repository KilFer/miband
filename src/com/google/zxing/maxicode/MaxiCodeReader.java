package com.google.zxing.maxicode;

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
import com.google.zxing.maxicode.decoder.Decoder;
import java.util.Map;

public final class MaxiCodeReader
  implements Reader
{
  private static final ResultPoint[] a = new ResultPoint[0];
  private static final int b = 30;
  private static final int c = 33;
  private final Decoder d = new Decoder();

  private static BitMatrix a(BitMatrix paramBitMatrix)
  {
    int[] arrayOfInt = paramBitMatrix.getEnclosingRectangle();
    if (arrayOfInt == null)
      throw NotFoundException.getNotFoundInstance();
    int i = arrayOfInt[0];
    int j = arrayOfInt[1];
    int k = arrayOfInt[2];
    int m = arrayOfInt[3];
    BitMatrix localBitMatrix = new BitMatrix(30, 33);
    for (int n = 0; n < 33; n++)
    {
      int i1 = j + (n * m + m / 2) / 33;
      for (int i2 = 0; i2 < 30; i2++)
        if (paramBitMatrix.get(i + (i2 * k + k / 2 + k * (n & 0x1) / 2) / 30, i1))
          localBitMatrix.set(i2, n);
    }
    return localBitMatrix;
  }

  private Decoder a()
  {
    return this.d;
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap)
  {
    return decode(paramBinaryBitmap, null);
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.PURE_BARCODE)))
    {
      BitMatrix localBitMatrix1 = paramBinaryBitmap.getBlackMatrix();
      int[] arrayOfInt = localBitMatrix1.getEnclosingRectangle();
      if (arrayOfInt == null)
        throw NotFoundException.getNotFoundInstance();
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      int k = arrayOfInt[2];
      int m = arrayOfInt[3];
      BitMatrix localBitMatrix2 = new BitMatrix(30, 33);
      for (int n = 0; n < 33; n++)
      {
        int i1 = j + (n * m + m / 2) / 33;
        for (int i2 = 0; i2 < 30; i2++)
          if (localBitMatrix1.get(i + (i2 * k + k / 2 + k * (n & 0x1) / 2) / 30, i1))
            localBitMatrix2.set(i2, n);
      }
      DecoderResult localDecoderResult = this.d.decode(localBitMatrix2, paramMap);
      ResultPoint[] arrayOfResultPoint = a;
      Result localResult = new Result(localDecoderResult.getText(), localDecoderResult.getRawBytes(), arrayOfResultPoint, BarcodeFormat.MAXICODE);
      String str = localDecoderResult.getECLevel();
      if (str != null)
        localResult.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
      return localResult;
    }
    throw NotFoundException.getNotFoundInstance();
  }

  public final void reset()
  {
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.maxicode.MaxiCodeReader
 * JD-Core Version:    0.6.2
 */