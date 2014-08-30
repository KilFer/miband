package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Code128Writer extends UPCEANWriter
{
  private static final int a = 104;
  private static final int b = 105;
  private static final int c = 100;
  private static final int d = 99;
  private static final int e = 106;
  private static final char f = 'ñ';
  private static final char g = 'ò';
  private static final char h = 'ó';
  private static final char i = 'ô';
  private static final int j = 102;
  private static final int k = 97;
  private static final int l = 96;
  private static final int m = 100;

  private static boolean a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    int n = paramInt1 + paramInt2;
    int i1 = paramCharSequence.length();
    while ((paramInt1 < n) && (paramInt1 < i1))
    {
      int i2 = paramCharSequence.charAt(paramInt1);
      if ((i2 < 48) || (i2 > 57))
      {
        if (i2 != 241)
          return false;
        n++;
      }
      paramInt1++;
    }
    return n <= i1;
  }

  public final BitMatrix encode(String paramString, BarcodeFormat paramBarcodeFormat, int paramInt1, int paramInt2, Map<EncodeHintType, ?> paramMap)
  {
    if (paramBarcodeFormat != BarcodeFormat.CODE_128)
      throw new IllegalArgumentException("Can only encode CODE_128, but got " + paramBarcodeFormat);
    return super.encode(paramString, paramBarcodeFormat, paramInt1, paramInt2, paramMap);
  }

  public final byte[] encode(String paramString)
  {
    int n = 0;
    int i1 = paramString.length();
    if ((i1 <= 0) || (i1 > 80))
      throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got " + i1);
    for (int i2 = 0; i2 < i1; i2++)
    {
      char c1 = paramString.charAt(i2);
      if ((c1 < ' ') || (c1 > '~'))
        switch (c1)
        {
        default:
          throw new IllegalArgumentException("Bad character in input: " + c1);
        case 'ñ':
        case 'ò':
        case 'ó':
        case 'ô':
        }
    }
    ArrayList localArrayList = new ArrayList();
    int i3 = 0;
    int i4 = 0;
    int i5 = 1;
    int i6 = 0;
    int i11;
    label172: int i12;
    label187: int i13;
    int i16;
    int i15;
    int i17;
    if (i3 < i1)
      if (i4 == 99)
      {
        i11 = 2;
        if (!a(paramString, i3, i11))
          break label282;
        i12 = 99;
        if (i12 != i4)
          break label420;
        if (i4 != 100)
          break label289;
        i13 = '￠' + paramString.charAt(i3);
        i16 = i3 + 1;
        i15 = i4;
        localArrayList.add(Code128Reader.a[i13]);
        i17 = i6 + i13 * i5;
        if (i16 == 0)
          break label616;
      }
    label282: label289: label420: label616: for (int i18 = i5 + 1; ; i18 = i5)
    {
      i5 = i18;
      i6 = i17;
      i4 = i15;
      i3 = i16;
      break;
      i11 = 4;
      break label172;
      i12 = 100;
      break label187;
      switch (paramString.charAt(i3))
      {
      default:
        i13 = Integer.parseInt(paramString.substring(i3, i3 + 2));
        i16 = i3 + 2;
        i15 = i4;
        break;
      case 'ñ':
        i13 = 102;
        i16 = i3 + 1;
        i15 = i4;
        break;
      case 'ò':
        i13 = 97;
        i16 = i3 + 1;
        i15 = i4;
        break;
      case 'ó':
        i13 = 96;
        i16 = i3 + 1;
        i15 = i4;
        break;
      case 'ô':
        i16 = i3 + 1;
        i15 = i4;
        i13 = 100;
        break;
        if (i4 == 0)
          if (i12 == 100)
            i13 = 104;
        while (true)
        {
          int i14 = i3;
          i15 = i12;
          i16 = i14;
          break;
          i13 = 105;
          continue;
          i13 = i12;
        }
        int i7 = i6 % 103;
        localArrayList.add(Code128Reader.a[i7]);
        localArrayList.add(Code128Reader.a[106]);
        Iterator localIterator1 = localArrayList.iterator();
        int i8 = 0;
        while (localIterator1.hasNext())
        {
          int[] arrayOfInt = (int[])localIterator1.next();
          int i9 = arrayOfInt.length;
          for (int i10 = 0; i10 < i9; i10++)
            i8 += arrayOfInt[i10];
        }
        byte[] arrayOfByte = new byte[i8];
        Iterator localIterator2 = localArrayList.iterator();
        while (localIterator2.hasNext())
          n += appendPattern(arrayOfByte, n, (int[])localIterator2.next(), 1);
        return arrayOfByte;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.Code128Writer
 * JD-Core Version:    0.6.2
 */