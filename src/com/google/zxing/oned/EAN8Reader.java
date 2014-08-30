package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.common.BitArray;

public final class EAN8Reader extends UPCEANReader
{
  private final int[] a = new int[4];

  final BarcodeFormat a()
  {
    return BarcodeFormat.EAN_8;
  }

  protected final int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.a;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.getSize();
    int j = paramArrayOfInt[1];
    int k = 0;
    while ((k < 4) && (j < i))
    {
      paramStringBuilder.append((char)(48 + a(paramBitArray, arrayOfInt, j, d)));
      int i4 = arrayOfInt.length;
      int i5 = j;
      for (int i6 = 0; i6 < i4; i6++)
        i5 += arrayOfInt[i6];
      k++;
      j = i5;
    }
    int m = a(paramBitArray, j, true, c)[1];
    for (int n = 0; (n < 4) && (m < i); n++)
    {
      paramStringBuilder.append((char)(48 + a(paramBitArray, arrayOfInt, m, d)));
      int i1 = arrayOfInt.length;
      int i2 = 0;
      while (i2 < i1)
      {
        int i3 = m + arrayOfInt[i2];
        i2++;
        m = i3;
      }
    }
    return m;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.EAN8Reader
 * JD-Core Version:    0.6.2
 */