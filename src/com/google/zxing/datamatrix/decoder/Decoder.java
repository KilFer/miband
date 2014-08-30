package com.google.zxing.datamatrix.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Decoder
{
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.DATA_MATRIX_FIELD_256);

  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    int[] arrayOfInt = new int[j];
    for (int k = 0; k < j; k++)
      arrayOfInt[k] = (0xFF & paramArrayOfByte[k]);
    int m = paramArrayOfByte.length - paramInt;
    try
    {
      this.a.decode(arrayOfInt, m);
      while (i < paramInt)
      {
        paramArrayOfByte[i] = ((byte)arrayOfInt[i]);
        i++;
      }
    }
    catch (ReedSolomonException localReedSolomonException)
    {
      throw ChecksumException.getChecksumInstance();
    }
  }

  public final DecoderResult decode(BitMatrix paramBitMatrix)
  {
    a locala = new a(paramBitMatrix);
    Version localVersion = locala.a();
    b[] arrayOfb = b.a(locala.b(), localVersion);
    int i = arrayOfb.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      k += arrayOfb[j].a();
      j++;
    }
    byte[] arrayOfByte1 = new byte[k];
    for (int m = 0; m < i; m++)
    {
      b localb = arrayOfb[m];
      byte[] arrayOfByte2 = localb.b();
      int n = localb.a();
      int i1 = arrayOfByte2.length;
      int[] arrayOfInt = new int[i1];
      for (int i2 = 0; i2 < i1; i2++)
        arrayOfInt[i2] = (0xFF & arrayOfByte2[i2]);
      int i3 = arrayOfByte2.length - n;
      try
      {
        this.a.decode(arrayOfInt, i3);
        for (int i4 = 0; i4 < n; i4++)
          arrayOfByte2[i4] = ((byte)arrayOfInt[i4]);
      }
      catch (ReedSolomonException localReedSolomonException)
      {
        throw ChecksumException.getChecksumInstance();
      }
      for (int i5 = 0; i5 < n; i5++)
        arrayOfByte1[(m + i5 * i)] = arrayOfByte2[i5];
    }
    return c.a(arrayOfByte1);
  }

  public final DecoderResult decode(boolean[][] paramArrayOfBoolean)
  {
    int i = paramArrayOfBoolean.length;
    BitMatrix localBitMatrix = new BitMatrix(i);
    for (int j = 0; j < i; j++)
      for (int k = 0; k < i; k++)
        if (paramArrayOfBoolean[j][k] != 0)
          localBitMatrix.set(k, j);
    return decode(localBitMatrix);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.decoder.Decoder
 * JD-Core Version:    0.6.2
 */