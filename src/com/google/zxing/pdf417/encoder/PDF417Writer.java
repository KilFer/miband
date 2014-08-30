package com.google.zxing.pdf417.encoder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.lang.reflect.Array;
import java.util.Map;

public final class PDF417Writer
  implements Writer
{
  private static BitMatrix a(c paramc, String paramString, int paramInt1, int paramInt2)
  {
    paramc.a(paramString, 2);
    byte[][] arrayOfByte1 = paramc.a().a(2, 8);
    int i;
    int j;
    if (paramInt2 > paramInt1)
    {
      i = 1;
      if (arrayOfByte1[0].length >= arrayOfByte1.length)
        break label130;
      j = 1;
      label40: if ((i ^ j) == 0)
        break label156;
      arrayOfByte1 = b(arrayOfByte1);
    }
    label130: label143: label149: label156: for (int k = 1; ; k = 0)
    {
      int m = paramInt1 / arrayOfByte1[0].length;
      int n = paramInt2 / arrayOfByte1.length;
      label81: byte[][] arrayOfByte2;
      if (m < n)
      {
        if (m <= 1)
          break label143;
        arrayOfByte2 = paramc.a().a(m << 1, m << 2 << 1);
        if (k == 0)
          break label149;
      }
      for (byte[][] arrayOfByte3 = b(arrayOfByte2); ; arrayOfByte3 = arrayOfByte2)
      {
        return a(arrayOfByte3);
        i = 0;
        break;
        j = 0;
        break label40;
        m = n;
        break label81;
        return a(arrayOfByte1);
      }
    }
  }

  private static BitMatrix a(byte[][] paramArrayOfByte)
  {
    BitMatrix localBitMatrix = new BitMatrix(60 + paramArrayOfByte.length, 60 + paramArrayOfByte[0].length);
    localBitMatrix.clear();
    for (int i = 0; i < paramArrayOfByte.length; i++)
      for (int j = 0; j < paramArrayOfByte[0].length; j++)
        if (paramArrayOfByte[i][j] == 1)
          localBitMatrix.set(i + 30, j + 30);
    return localBitMatrix;
  }

  private static c a(BarcodeFormat paramBarcodeFormat, boolean paramBoolean)
  {
    if (paramBarcodeFormat != BarcodeFormat.PDF_417)
      throw new IllegalArgumentException("Can only encode PDF_417, but got " + paramBarcodeFormat);
    c localc = new c();
    localc.a(paramBoolean);
    return localc;
  }

  private static byte[][] b(byte[][] paramArrayOfByte)
  {
    int[] arrayOfInt = { paramArrayOfByte[0].length, paramArrayOfByte.length };
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, arrayOfInt);
    for (int i = 0; i < paramArrayOfByte.length; i++)
    {
      int j = -1 + (paramArrayOfByte.length - i);
      for (int k = 0; k < paramArrayOfByte[0].length; k++)
        arrayOfByte[k][j] = paramArrayOfByte[i][k];
    }
    return arrayOfByte;
  }

  public final BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2)
  {
    return a(a(paramBarcodeFormat, false), paramString, paramInt1, paramInt2);
  }

  public final BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2);
  }

  public final BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Compaction paramCompaction)
  {
    c localc = a(paramBarcodeFormat, paramBoolean);
    localc.a(paramInt4, paramInt3, paramInt6, paramInt5);
    localc.a(paramCompaction);
    return a(localc, paramString, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.encoder.PDF417Writer
 * JD-Core Version:    0.6.2
 */