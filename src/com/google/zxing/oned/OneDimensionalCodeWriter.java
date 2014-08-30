package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract class OneDimensionalCodeWriter
  implements Writer
{
  private final int a;

  protected OneDimensionalCodeWriter(int paramInt)
  {
    this.a = paramInt;
  }

  private BitMatrix a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte.length;
    int j = i + this.a;
    int k = Math.max(paramInt1, j);
    int m = Math.max(1, paramInt2);
    int n = k / j;
    int i1 = (k - i * n) / 2;
    BitMatrix localBitMatrix = new BitMatrix(k, m);
    int i2 = i1;
    int i3 = 0;
    while (i3 < i)
    {
      if (paramArrayOfByte[i3] == 1)
        localBitMatrix.setRegion(i2, 0, n, m);
      i3++;
      i2 += n;
    }
    return localBitMatrix;
  }

  protected static int appendPattern(byte[] paramArrayOfByte, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if ((paramInt2 != 0) && (paramInt2 != 1))
      throw new IllegalArgumentException("startColor must be either 0 or 1, but got: " + paramInt2);
    int i = (byte)paramInt2;
    int j = paramArrayOfInt.length;
    int k = 0;
    int m = i;
    int n = paramInt1;
    int i1 = 0;
    while (k < j)
    {
      int i2 = paramArrayOfInt[k];
      int i3 = n;
      int i4 = i1;
      for (int i5 = 0; i5 < i2; i5++)
      {
        paramArrayOfByte[i3] = m;
        i3++;
        i4++;
      }
      m = (byte)(m ^ 0x1);
      k++;
      i1 = i4;
      n = i3;
    }
    return i1;
  }

  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2)
  {
    return encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, null);
  }

  public BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramString.length() == 0)
      throw new IllegalArgumentException("Found empty contents");
    if ((paramInt1 < 0) || (paramInt2 < 0))
      throw new IllegalArgumentException("Negative size is not allowed. Input: " + paramInt1 + 'x' + paramInt2);
    return a(encode(paramString), paramInt1, paramInt2);
  }

  public abstract byte[] encode(String paramString);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.OneDimensionalCodeWriter
 * JD-Core Version:    0.6.2
 */