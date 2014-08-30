package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class EAN13Reader extends UPCEANReader
{
  static final int[] a = { 0, 11, 13, 14, 19, 25, 28, 21, 22, 26 };
  private final int[] f = new int[4];

  private static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i < 10; i++)
      if (paramInt == a[i])
      {
        paramStringBuilder.insert(0, (char)(i + 48));
        return;
      }
    throw NotFoundException.getNotFoundInstance();
  }

  final BarcodeFormat a()
  {
    return BarcodeFormat.EAN_13;
  }

  protected final int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.f;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.getSize();
    int j = paramArrayOfInt[1];
    int k = 0;
    int m = 0;
    while ((k < 6) && (j < i))
    {
      int i6 = a(paramBitArray, arrayOfInt, j, e);
      paramStringBuilder.append((char)(48 + i6 % 10));
      int i7 = arrayOfInt.length;
      for (int i8 = 0; i8 < i7; i8++)
        j += arrayOfInt[i8];
      if (i6 >= 10)
        m |= 1 << 5 - k;
      k++;
    }
    int n = 0;
    int i1;
    if (n < 10)
      if (m == a[n])
      {
        paramStringBuilder.insert(0, (char)(n + 48));
        i1 = a(paramBitArray, j, true, c)[1];
      }
    for (int i2 = 0; ; i2++)
    {
      if ((i2 >= 6) || (i1 >= i))
        break label274;
      paramStringBuilder.append((char)(48 + a(paramBitArray, arrayOfInt, i1, d)));
      int i3 = arrayOfInt.length;
      int i4 = 0;
      while (true)
        if (i4 < i3)
        {
          int i5 = i1 + arrayOfInt[i4];
          i4++;
          i1 = i5;
          continue;
          n++;
          break;
          throw NotFoundException.getNotFoundInstance();
        }
    }
    label274: return i1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.EAN13Reader
 * JD-Core Version:    0.6.2
 */