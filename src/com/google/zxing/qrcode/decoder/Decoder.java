package com.google.zxing.qrcode.decoder;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

public final class Decoder
{
  private final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);

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
    return decode(paramBitMatrix, null);
  }

  public final DecoderResult decode(BitMatrix paramBitMatrix, Map<DecodeHintType, ?> paramMap)
  {
    a locala = new a(paramBitMatrix);
    Version localVersion = locala.b();
    ErrorCorrectionLevel localErrorCorrectionLevel = locala.a().a();
    b[] arrayOfb = b.a(locala.c(), localVersion, localErrorCorrectionLevel);
    int i = 0;
    int j = arrayOfb.length;
    for (int k = 0; k < j; k++)
      i += arrayOfb[k].a();
    byte[] arrayOfByte1 = new byte[i];
    int m = 0;
    int n = arrayOfb.length;
    for (int i1 = 0; i1 < n; i1++)
    {
      b localb = arrayOfb[i1];
      byte[] arrayOfByte2 = localb.b();
      int i2 = localb.a();
      int i3 = arrayOfByte2.length;
      int[] arrayOfInt = new int[i3];
      for (int i4 = 0; i4 < i3; i4++)
        arrayOfInt[i4] = (0xFF & arrayOfByte2[i4]);
      int i5 = arrayOfByte2.length - i2;
      try
      {
        this.a.decode(arrayOfInt, i5);
        for (int i6 = 0; i6 < i2; i6++)
          arrayOfByte2[i6] = ((byte)arrayOfInt[i6]);
      }
      catch (ReedSolomonException localReedSolomonException)
      {
        throw ChecksumException.getChecksumInstance();
      }
      int i7 = 0;
      while (i7 < i2)
      {
        int i8 = m + 1;
        arrayOfByte1[m] = arrayOfByte2[i7];
        i7++;
        m = i8;
      }
    }
    return m.a(arrayOfByte1, localVersion, localErrorCorrectionLevel, paramMap);
  }

  public final DecoderResult decode(boolean[][] paramArrayOfBoolean)
  {
    return decode(paramArrayOfBoolean, null);
  }

  public final DecoderResult decode(boolean[][] paramArrayOfBoolean, Map<DecodeHintType, ?> paramMap)
  {
    int i = paramArrayOfBoolean.length;
    BitMatrix localBitMatrix = new BitMatrix(i);
    for (int j = 0; j < i; j++)
      for (int k = 0; k < i; k++)
        if (paramArrayOfBoolean[j][k] != 0)
          localBitMatrix.set(k, j);
    return decode(localBitMatrix, paramMap);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.Decoder
 * JD-Core Version:    0.6.2
 */