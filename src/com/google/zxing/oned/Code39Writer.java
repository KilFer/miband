package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public final class Code39Writer extends UPCEANWriter
{
  private static void a(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    if (i < 9)
    {
      if ((paramInt & 1 << i) == 0);
      for (int j = 1; ; j = 2)
      {
        paramArrayOfInt[i] = j;
        i++;
        break;
      }
    }
  }

  public final BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.CODE_39)
      throw new IllegalArgumentException("Can only encode CODE_39, but got " + paramBarcodeFormat);
    return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }

  public final byte[] encode(String paramString)
  {
    int i = paramString.length();
    if (i > 80)
      throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + i);
    int[] arrayOfInt1 = new int[9];
    int j = i + 25;
    int k = 0;
    while (k < i)
    {
      int i4 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(k));
      a(Code39Reader.a[i4], arrayOfInt1);
      int i5 = arrayOfInt1.length;
      int i6 = j;
      for (int i7 = 0; i7 < i5; i7++)
        i6 += arrayOfInt1[i7];
      k++;
      j = i6;
    }
    byte[] arrayOfByte = new byte[j];
    a(Code39Reader.a[39], arrayOfInt1);
    int m = appendPattern(arrayOfByte, 0, arrayOfInt1, 1);
    int[] arrayOfInt2 = { 1 };
    int n = m + appendPattern(arrayOfByte, m, arrayOfInt2, 0);
    for (int i1 = i - 1; i1 >= 0; i1--)
    {
      int i2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. *$/+%".indexOf(paramString.charAt(i1));
      a(Code39Reader.a[i2], arrayOfInt1);
      int i3 = n + appendPattern(arrayOfByte, n, arrayOfInt1, 1);
      n = i3 + appendPattern(arrayOfByte, i3, arrayOfInt2, 0);
    }
    a(Code39Reader.a[39], arrayOfInt1);
    appendPattern(arrayOfByte, n, arrayOfInt1, 1);
    return arrayOfByte;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.Code39Writer
 * JD-Core Version:    0.6.2
 */