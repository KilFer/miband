package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.Result;
import com.google.zxing.common.BitArray;
import java.util.Map;

public final class UPCAReader extends UPCEANReader
{
  private final UPCEANReader a = new EAN13Reader();

  private static Result a(Result paramResult)
  {
    String str = paramResult.getText();
    if (str.charAt(0) == '0')
      return new Result(str.substring(1), null, paramResult.getResultPoints(), BarcodeFormat.UPC_A);
    throw FormatException.getFormatInstance();
  }

  final BarcodeFormat a()
  {
    return BarcodeFormat.UPC_A;
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap)
  {
    return a(this.a.decode(paramBinaryBitmap));
  }

  public final Result decode(BinaryBitmap paramBinaryBitmap, Map<DecodeHintType, ?> paramMap)
  {
    return a(this.a.decode(paramBinaryBitmap, paramMap));
  }

  protected final int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    return this.a.decodeMiddle(paramBitArray, paramArrayOfInt, paramStringBuilder);
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    return a(this.a.decodeRow(paramInt, paramBitArray, paramMap));
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, int[] paramArrayOfInt, Map<DecodeHintType, ?> paramMap)
  {
    return a(this.a.decodeRow(paramInt, paramBitArray, paramArrayOfInt, paramMap));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.UPCAReader
 * JD-Core Version:    0.6.2
 */