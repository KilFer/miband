package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class ITFWriter extends UPCEANWriter
{
  public final BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.ITF)
      throw new IllegalArgumentException("Can only encode ITF, but got " + paramBarcodeFormat);
    return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }

  public final byte[] encode(String paramString)
  {
    int i = paramString.length();
    if (i % 2 != 0)
      throw new IllegalArgumentException("The lenght of the input should be even");
    if (i > 80)
      throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + i);
    byte[] arrayOfByte = new byte[9 + i * 9];
    int j = appendPattern(arrayOfByte, 0, new int[] { 1, 1, 1, 1 }, 1);
    int k = 0;
    int m = j;
    while (k < i)
    {
      int n = Character.digit(paramString.charAt(k), 10);
      int i1 = Character.digit(paramString.charAt(k + 1), 10);
      int[] arrayOfInt = new int[18];
      for (int i2 = 0; i2 < 5; i2++)
      {
        arrayOfInt[(i2 << 1)] = ITFReader.a[n][i2];
        arrayOfInt[(1 + (i2 << 1))] = ITFReader.a[i1][i2];
      }
      m += appendPattern(arrayOfByte, m, arrayOfInt, 1);
      k += 2;
    }
    appendPattern(arrayOfByte, m, new int[] { 3, 1, 1 }, 1);
    return arrayOfByte;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.ITFWriter
 * JD-Core Version:    0.6.2
 */