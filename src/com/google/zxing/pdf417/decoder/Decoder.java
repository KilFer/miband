package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;

public final class Decoder
{
  private static final int a = 3;
  private static final int b = 512;

  private static void a(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt.length < 4)
      throw FormatException.getFormatInstance();
    int i = paramArrayOfInt[0];
    if (i > paramArrayOfInt.length)
      throw FormatException.getFormatInstance();
    if (i == 0)
    {
      if (paramInt < paramArrayOfInt.length)
        paramArrayOfInt[0] = (paramArrayOfInt.length - paramInt);
    }
    else
      return;
    throw FormatException.getFormatInstance();
  }

  private static int b(int[] paramArrayOfInt, int paramInt)
  {
    if ((paramArrayOfInt.length > 3 + paramInt / 2) || (paramInt < 0) || (paramInt > 512))
      throw FormatException.getFormatInstance();
    if (paramArrayOfInt.length > 3)
      throw FormatException.getFormatInstance();
    return 0;
  }

  public final DecoderResult decode(BitMatrix paramBitMatrix)
  {
    a locala = new a(paramBitMatrix);
    int[] arrayOfInt1 = locala.a();
    if (arrayOfInt1.length == 0)
      throw FormatException.getFormatInstance();
    int i = 1 << 1 + locala.c();
    int[] arrayOfInt2 = locala.b();
    if ((arrayOfInt2.length > 3 + i / 2) || (i < 0) || (i > 512))
      throw FormatException.getFormatInstance();
    if (arrayOfInt2.length > 3)
      throw FormatException.getFormatInstance();
    if (arrayOfInt1.length < 4)
      throw FormatException.getFormatInstance();
    int j = arrayOfInt1[0];
    if (j > arrayOfInt1.length)
      throw FormatException.getFormatInstance();
    if (j == 0)
    {
      if (i < arrayOfInt1.length)
        arrayOfInt1[0] = (arrayOfInt1.length - i);
    }
    else
      return b.a(arrayOfInt1);
    throw FormatException.getFormatInstance();
  }

  public final DecoderResult decode(boolean[][] paramArrayOfBoolean)
  {
    int i = paramArrayOfBoolean.length;
    BitMatrix localBitMatrix = new BitMatrix(i);
    for (int j = 0; j < i; j++)
      for (int k = 0; k < i; k++)
        if (paramArrayOfBoolean[k][j] != 0)
          localBitMatrix.set(k, j);
    return decode(localBitMatrix);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.Decoder
 * JD-Core Version:    0.6.2
 */