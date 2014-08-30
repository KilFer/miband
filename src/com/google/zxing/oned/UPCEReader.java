package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

public final class UPCEReader extends UPCEANReader
{
  private static final int[] a = { 1, 1, 1, 1, 1, 1 };
  private static final int[][] f = { { 56, 52, 50, 49, 44, 38, 35, 42, 41, 37 }, { 7, 11, 13, 14, 19, 25, 28, 21, 22, 26 } };
  private final int[] g = new int[4];

  private static void a(StringBuilder paramStringBuilder, int paramInt)
  {
    for (int i = 0; i <= 1; i++)
      for (int j = 0; j < 10; j++)
        if (paramInt == f[i][j])
        {
          paramStringBuilder.insert(0, (char)(i + 48));
          paramStringBuilder.append((char)(j + 48));
          return;
        }
    throw NotFoundException.getNotFoundInstance();
  }

  public static String convertUPCEtoUPCA(String paramString)
  {
    char[] arrayOfChar = new char[6];
    paramString.getChars(1, 7, arrayOfChar, 0);
    StringBuilder localStringBuilder = new StringBuilder(12);
    localStringBuilder.append(paramString.charAt(0));
    char c = arrayOfChar[5];
    switch (c)
    {
    default:
      localStringBuilder.append(arrayOfChar, 0, 5);
      localStringBuilder.append("0000");
      localStringBuilder.append(c);
    case '0':
    case '1':
    case '2':
    case '3':
    case '4':
    }
    while (true)
    {
      localStringBuilder.append(paramString.charAt(7));
      return localStringBuilder.toString();
      localStringBuilder.append(arrayOfChar, 0, 2);
      localStringBuilder.append(c);
      localStringBuilder.append("0000");
      localStringBuilder.append(arrayOfChar, 2, 3);
      continue;
      localStringBuilder.append(arrayOfChar, 0, 3);
      localStringBuilder.append("00000");
      localStringBuilder.append(arrayOfChar, 3, 2);
      continue;
      localStringBuilder.append(arrayOfChar, 0, 4);
      localStringBuilder.append("00000");
      localStringBuilder.append(arrayOfChar[4]);
    }
  }

  final BarcodeFormat a()
  {
    return BarcodeFormat.UPC_E;
  }

  protected final boolean checkChecksum(String paramString)
  {
    return super.checkChecksum(convertUPCEtoUPCA(paramString));
  }

  protected final int[] decodeEnd(BitArray paramBitArray, int paramInt)
  {
    return a(paramBitArray, paramInt, true, a);
  }

  protected final int decodeMiddle(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.g;
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
      int i2 = a(paramBitArray, arrayOfInt, j, e);
      paramStringBuilder.append((char)(48 + i2 % 10));
      int i3 = arrayOfInt.length;
      int i4 = 0;
      int i5 = j;
      while (i4 < i3)
      {
        i5 += arrayOfInt[i4];
        i4++;
      }
      if (i2 >= 10)
        m |= 1 << 5 - k;
      k++;
      j = i5;
    }
    for (int n = 0; n <= 1; n++)
      for (int i1 = 0; i1 < 10; i1++)
        if (m == f[n][i1])
        {
          paramStringBuilder.insert(0, (char)(n + 48));
          paramStringBuilder.append((char)(i1 + 48));
          return j;
        }
    throw NotFoundException.getNotFoundInstance();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.UPCEReader
 * JD-Core Version:    0.6.2
 */