package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Code128Reader extends OneDReader
{
  static final int[][] a = { { 2, 1, 2, 2, 2, 2 }, { 2, 2, 2, 1, 2, 2 }, { 2, 2, 2, 2, 2, 1 }, { 1, 2, 1, 2, 2, 3 }, { 1, 2, 1, 3, 2, 2 }, { 1, 3, 1, 2, 2, 2 }, { 1, 2, 2, 2, 1, 3 }, { 1, 2, 2, 3, 1, 2 }, { 1, 3, 2, 2, 1, 2 }, { 2, 2, 1, 2, 1, 3 }, { 2, 2, 1, 3, 1, 2 }, { 2, 3, 1, 2, 1, 2 }, { 1, 1, 2, 2, 3, 2 }, { 1, 2, 2, 1, 3, 2 }, { 1, 2, 2, 2, 3, 1 }, { 1, 1, 3, 2, 2, 2 }, { 1, 2, 3, 1, 2, 2 }, { 1, 2, 3, 2, 2, 1 }, { 2, 2, 3, 2, 1, 1 }, { 2, 2, 1, 1, 3, 2 }, { 2, 2, 1, 2, 3, 1 }, { 2, 1, 3, 2, 1, 2 }, { 2, 2, 3, 1, 1, 2 }, { 3, 1, 2, 1, 3, 1 }, { 3, 1, 1, 2, 2, 2 }, { 3, 2, 1, 1, 2, 2 }, { 3, 2, 1, 2, 2, 1 }, { 3, 1, 2, 2, 1, 2 }, { 3, 2, 2, 1, 1, 2 }, { 3, 2, 2, 2, 1, 1 }, { 2, 1, 2, 1, 2, 3 }, { 2, 1, 2, 3, 2, 1 }, { 2, 3, 2, 1, 2, 1 }, { 1, 1, 1, 3, 2, 3 }, { 1, 3, 1, 1, 2, 3 }, { 1, 3, 1, 3, 2, 1 }, { 1, 1, 2, 3, 1, 3 }, { 1, 3, 2, 1, 1, 3 }, { 1, 3, 2, 3, 1, 1 }, { 2, 1, 1, 3, 1, 3 }, { 2, 3, 1, 1, 1, 3 }, { 2, 3, 1, 3, 1, 1 }, { 1, 1, 2, 1, 3, 3 }, { 1, 1, 2, 3, 3, 1 }, { 1, 3, 2, 1, 3, 1 }, { 1, 1, 3, 1, 2, 3 }, { 1, 1, 3, 3, 2, 1 }, { 1, 3, 3, 1, 2, 1 }, { 3, 1, 3, 1, 2, 1 }, { 2, 1, 1, 3, 3, 1 }, { 2, 3, 1, 1, 3, 1 }, { 2, 1, 3, 1, 1, 3 }, { 2, 1, 3, 3, 1, 1 }, { 2, 1, 3, 1, 3, 1 }, { 3, 1, 1, 1, 2, 3 }, { 3, 1, 1, 3, 2, 1 }, { 3, 3, 1, 1, 2, 1 }, { 3, 1, 2, 1, 1, 3 }, { 3, 1, 2, 3, 1, 1 }, { 3, 3, 2, 1, 1, 1 }, { 3, 1, 4, 1, 1, 1 }, { 2, 2, 1, 4, 1, 1 }, { 4, 3, 1, 1, 1, 1 }, { 1, 1, 1, 2, 2, 4 }, { 1, 1, 1, 4, 2, 2 }, { 1, 2, 1, 1, 2, 4 }, { 1, 2, 1, 4, 2, 1 }, { 1, 4, 1, 1, 2, 2 }, { 1, 4, 1, 2, 2, 1 }, { 1, 1, 2, 2, 1, 4 }, { 1, 1, 2, 4, 1, 2 }, { 1, 2, 2, 1, 1, 4 }, { 1, 2, 2, 4, 1, 1 }, { 1, 4, 2, 1, 1, 2 }, { 1, 4, 2, 2, 1, 1 }, { 2, 4, 1, 2, 1, 1 }, { 2, 2, 1, 1, 1, 4 }, { 4, 1, 3, 1, 1, 1 }, { 2, 4, 1, 1, 1, 2 }, { 1, 3, 4, 1, 1, 1 }, { 1, 1, 1, 2, 4, 2 }, { 1, 2, 1, 1, 4, 2 }, { 1, 2, 1, 2, 4, 1 }, { 1, 1, 4, 2, 1, 2 }, { 1, 2, 4, 1, 1, 2 }, { 1, 2, 4, 2, 1, 1 }, { 4, 1, 1, 2, 1, 2 }, { 4, 2, 1, 1, 1, 2 }, { 4, 2, 1, 2, 1, 1 }, { 2, 1, 2, 1, 4, 1 }, { 2, 1, 4, 1, 2, 1 }, { 4, 1, 2, 1, 2, 1 }, { 1, 1, 1, 1, 4, 3 }, { 1, 1, 1, 3, 4, 1 }, { 1, 3, 1, 1, 4, 1 }, { 1, 1, 4, 1, 1, 3 }, { 1, 1, 4, 3, 1, 1 }, { 4, 1, 1, 1, 1, 3 }, { 4, 1, 1, 3, 1, 1 }, { 1, 1, 3, 1, 4, 1 }, { 1, 1, 4, 1, 3, 1 }, { 3, 1, 1, 1, 4, 1 }, { 4, 1, 1, 1, 3, 1 }, { 2, 1, 1, 4, 1, 2 }, { 2, 1, 1, 2, 1, 4 }, { 2, 1, 1, 2, 3, 2 }, { 2, 3, 3, 1, 1, 1, 2 } };
  private static final int b = 64;
  private static final int c = 179;
  private static final int d = 98;
  private static final int e = 99;
  private static final int f = 100;
  private static final int g = 101;
  private static final int h = 102;
  private static final int i = 97;
  private static final int j = 96;
  private static final int k = 101;
  private static final int l = 100;
  private static final int m = 103;
  private static final int n = 104;
  private static final int o = 105;
  private static final int p = 106;

  private static int a(BitArray paramBitArray, int[] paramArrayOfInt, int paramInt)
  {
    recordPattern(paramBitArray, paramInt, paramArrayOfInt);
    int i1 = 64;
    int i2 = -1;
    for (int i3 = 0; i3 < a.length; i3++)
    {
      int i4 = patternMatchVariance(paramArrayOfInt, a[i3], 179);
      if (i4 < i1)
      {
        i2 = i3;
        i1 = i4;
      }
    }
    if (i2 >= 0)
      return i2;
    throw NotFoundException.getNotFoundInstance();
  }

  private static int[] a(BitArray paramBitArray)
  {
    int i1 = paramBitArray.getSize();
    int i2 = paramBitArray.getNextSet(0);
    int[] arrayOfInt = new int[6];
    int i3 = arrayOfInt.length;
    int i4 = 0;
    int i5 = 0;
    int i6 = i2;
    int i9;
    int i7;
    int i11;
    int i12;
    int i13;
    label106: int i14;
    while (true)
      if (i6 < i1)
        if ((i4 ^ paramBitArray.get(i6)) != 0)
        {
          arrayOfInt[i5] = (1 + arrayOfInt[i5]);
          i9 = i4;
          i7 = i5;
          int i10 = i6 + 1;
          i4 = i9;
          i5 = i7;
          i6 = i10;
        }
        else if (i5 == i3 - 1)
        {
          i11 = 64;
          i12 = -1;
          i13 = 103;
          if (i13 <= 105)
          {
            i14 = patternMatchVariance(arrayOfInt, a[i13], 179);
            if (i14 >= i11)
              break label276;
            i12 = i13;
          }
        }
    while (true)
    {
      i13++;
      i11 = i14;
      break label106;
      if ((i12 >= 0) && (paramBitArray.isRange(Math.max(0, i2 - (i6 - i2) / 2), i2, false)))
        return new int[] { i2, i6, i12 };
      int i8 = i2 + (arrayOfInt[0] + arrayOfInt[1]);
      System.arraycopy(arrayOfInt, 2, arrayOfInt, 0, i3 - 2);
      arrayOfInt[(i3 - 2)] = 0;
      arrayOfInt[(i3 - 1)] = 0;
      i7 = i5 - 1;
      label235: arrayOfInt[i7] = 1;
      if (i4 == 0);
      for (i9 = 1; ; i9 = 0)
      {
        i2 = i8;
        break;
        i7 = i5 + 1;
        i8 = i2;
        break label235;
      }
      throw NotFoundException.getNotFoundInstance();
      label276: i14 = i11;
    }
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    int i1 = paramBitArray.getSize();
    int i2 = paramBitArray.getNextSet(0);
    int i3 = 0;
    int[] arrayOfInt1 = new int[6];
    int i4 = 0;
    int i5 = arrayOfInt1.length;
    int i6 = i2;
    int i9;
    int i7;
    int i11;
    int i12;
    int i13;
    label114: int i57;
    while (true)
      if (i6 < i1)
        if ((i4 ^ paramBitArray.get(i6)) != 0)
        {
          arrayOfInt1[i3] = (1 + arrayOfInt1[i3]);
          i9 = i4;
          i7 = i3;
          int i10 = i6 + 1;
          i4 = i9;
          i3 = i7;
          i6 = i10;
        }
        else if (i3 == i5 - 1)
        {
          i11 = 64;
          i12 = -1;
          i13 = 103;
          if (i13 <= 105)
          {
            i57 = patternMatchVariance(arrayOfInt1, a[i13], 179);
            if (i57 >= i11)
              break label1527;
            i12 = i13;
          }
        }
    while (true)
    {
      i13++;
      i11 = i57;
      break label114;
      int[] arrayOfInt2;
      int i14;
      if ((i12 >= 0) && (paramBitArray.isRange(Math.max(0, i2 - (i6 - i2) / 2), i2, false)))
      {
        arrayOfInt2 = new int[] { i2, i6, i12 };
        i14 = arrayOfInt2[2];
      }
      label293: int i15;
      switch (i14)
      {
      default:
        throw FormatException.getFormatInstance();
        int i8 = i2 + (arrayOfInt1[0] + arrayOfInt1[1]);
        System.arraycopy(arrayOfInt1, 2, arrayOfInt1, 0, i5 - 2);
        arrayOfInt1[(i5 - 2)] = 0;
        arrayOfInt1[(i5 - 1)] = 0;
        i7 = i3 - 1;
        arrayOfInt1[i7] = 1;
        if (i4 == 0);
        for (i9 = 1; ; i9 = 0)
        {
          i2 = i8;
          break;
          i7 = i3 + 1;
          i8 = i2;
          break label293;
        }
        throw NotFoundException.getNotFoundInstance();
      case 103:
        i15 = 101;
      case 104:
      case 105:
      }
      StringBuilder localStringBuilder;
      ArrayList localArrayList;
      int i17;
      int i18;
      int i19;
      int i20;
      int i21;
      int i22;
      int i23;
      int i24;
      int i25;
      int i26;
      int i31;
      int i32;
      int i35;
      while (true)
      {
        localStringBuilder = new StringBuilder(20);
        localArrayList = new ArrayList(20);
        int i16 = arrayOfInt2[0];
        i17 = arrayOfInt2[1];
        int[] arrayOfInt3 = new int[6];
        i18 = 1;
        i19 = 0;
        i20 = i15;
        i21 = 0;
        i22 = i14;
        i23 = 0;
        i24 = 0;
        i25 = i16;
        i26 = 0;
        if (i24 != 0)
          break label1273;
        i31 = 0;
        i32 = a(paramBitArray, arrayOfInt3, i17);
        localArrayList.add(Byte.valueOf((byte)i32));
        if (i32 != 106)
          i18 = 1;
        if (i32 != 106)
        {
          i21++;
          i22 += i21 * i32;
        }
        int i33 = arrayOfInt3.length;
        int i34 = 0;
        i35 = i17;
        while (i34 < i33)
        {
          i35 += arrayOfInt3[i34];
          i34++;
        }
        i15 = 100;
        continue;
        i15 = 99;
      }
      int i37;
      switch (i32)
      {
      default:
        switch (i20)
        {
        default:
          int i42 = i24;
          i36 = i20;
          i37 = i42;
          label592: if (i19 != 0)
            if (i36 != 101)
              break label1266;
          break;
        case 101:
        case 100:
        case 99:
        }
        break;
      case 103:
      case 104:
      case 105:
      }
      label1266: for (int i36 = 100; ; i36 = 101)
      {
        i25 = i17;
        i19 = i31;
        i17 = i35;
        i26 = i23;
        i23 = i32;
        int i38 = i37;
        i20 = i36;
        i24 = i38;
        break;
        throw FormatException.getFormatInstance();
        if (i32 < 64)
        {
          localStringBuilder.append((char)(i32 + 32));
          int i56 = i24;
          i36 = i20;
          i37 = i56;
          i31 = 0;
          break label592;
        }
        if (i32 < 96)
        {
          localStringBuilder.append((char)(i32 - 64));
          int i55 = i24;
          i36 = i20;
          i37 = i55;
          i31 = 0;
          break label592;
        }
        if (i32 != 106)
          i18 = 0;
        switch (i32)
        {
        case 103:
        case 104:
        case 105:
        default:
        case 96:
        case 97:
        case 101:
        case 102:
        case 98:
        case 100:
        case 99:
        case 106:
        }
        while (true)
        {
          int i50 = i24;
          i36 = i20;
          i37 = i50;
          i31 = 0;
          break;
          int i54 = i24;
          i36 = i20;
          i37 = i54;
          i31 = 0;
          break;
          i31 = 1;
          int i53 = i24;
          i36 = 100;
          i37 = i53;
          break;
          int i52 = i24;
          i36 = 100;
          i37 = i52;
          i31 = 0;
          break;
          int i51 = i24;
          i36 = 99;
          i37 = i51;
          i31 = 0;
          break;
          i24 = 1;
        }
        if (i32 < 96)
        {
          localStringBuilder.append((char)(i32 + 32));
          int i49 = i24;
          i36 = i20;
          i37 = i49;
          i31 = 0;
          break label592;
        }
        if (i32 != 106)
          i18 = 0;
        switch (i32)
        {
        case 103:
        case 104:
        case 105:
        default:
        case 96:
        case 97:
        case 100:
        case 102:
        case 98:
        case 101:
        case 99:
        case 106:
        }
        while (true)
        {
          int i44 = i24;
          i36 = i20;
          i37 = i44;
          i31 = 0;
          break;
          int i48 = i24;
          i36 = i20;
          i37 = i48;
          i31 = 0;
          break;
          i31 = 1;
          int i47 = i24;
          i36 = 101;
          i37 = i47;
          break;
          int i46 = i24;
          i36 = 101;
          i37 = i46;
          i31 = 0;
          break;
          int i45 = i24;
          i36 = 99;
          i37 = i45;
          i31 = 0;
          break;
          i24 = 1;
        }
        if (i32 < 100)
        {
          if (i32 < 10)
            localStringBuilder.append('0');
          localStringBuilder.append(i32);
          int i43 = i24;
          i36 = i20;
          i37 = i43;
          i31 = 0;
          break label592;
        }
        if (i32 != 106)
          i18 = 0;
        switch (i32)
        {
        case 103:
        case 104:
        case 105:
        default:
          break;
        case 100:
          int i41 = i24;
          i36 = 100;
          i37 = i41;
          i31 = 0;
          break;
        case 102:
          int i40 = i24;
          i36 = i20;
          i37 = i40;
          i31 = 0;
          break;
        case 101:
          int i39 = i24;
          i36 = 101;
          i37 = i39;
          i31 = 0;
          break;
        case 106:
          i36 = i20;
          i37 = 1;
          i31 = 0;
          break label592;
        }
      }
      label1273: int i27 = paramBitArray.getNextUnset(i17);
      if (!paramBitArray.isRange(i27, Math.min(paramBitArray.getSize(), i27 + (i27 - i25) / 2), false))
        throw NotFoundException.getNotFoundInstance();
      if ((i22 - i21 * i26) % 103 != i26)
        throw ChecksumException.getChecksumInstance();
      int i28 = localStringBuilder.length();
      if (i28 == 0)
        throw NotFoundException.getNotFoundInstance();
      if ((i28 > 0) && (i18 != 0))
      {
        if (i20 != 99)
          break label1452;
        localStringBuilder.delete(i28 - 2, i28);
      }
      float f1;
      float f2;
      byte[] arrayOfByte;
      while (true)
      {
        f1 = (arrayOfInt2[1] + arrayOfInt2[0]) / 2.0F;
        f2 = (i27 + i25) / 2.0F;
        int i29 = localArrayList.size();
        arrayOfByte = new byte[i29];
        for (int i30 = 0; i30 < i29; i30++)
          arrayOfByte[i30] = ((Byte)localArrayList.get(i30)).byteValue();
        label1452: localStringBuilder.delete(i28 - 1, i28);
      }
      String str = localStringBuilder.toString();
      ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
      arrayOfResultPoint[0] = new ResultPoint(f1, paramInt);
      arrayOfResultPoint[1] = new ResultPoint(f2, paramInt);
      return new Result(str, arrayOfByte, arrayOfResultPoint, BarcodeFormat.CODE_128);
      label1527: i57 = i11;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.Code128Reader
 * JD-Core Version:    0.6.2
 */