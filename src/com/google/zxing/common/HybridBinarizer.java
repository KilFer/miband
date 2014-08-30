package com.google.zxing.common;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer
{
  private static final int a = 3;
  private static final int b = 8;
  private static final int c = 7;
  private static final int d = 40;
  private BitMatrix e;

  public HybridBinarizer(LuminanceSource paramLuminanceSource)
  {
    super(paramLuminanceSource);
  }

  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitMatrix paramBitMatrix)
  {
    int i = paramInt1 + paramInt2 * paramInt4;
    int j = 0;
    while (j < 8)
    {
      for (int k = 0; k < 8; k++)
        if ((0xFF & paramArrayOfByte[(i + k)]) <= paramInt3)
          paramBitMatrix.set(paramInt1 + k, paramInt2 + j);
      j++;
      i += paramInt4;
    }
  }

  private static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[][] paramArrayOfInt, BitMatrix paramBitMatrix)
  {
    int i = 0;
    int j;
    int k;
    label35: int m;
    if (i < paramInt2)
    {
      j = i << 3;
      if (j + 8 >= paramInt4)
        j = paramInt4 - 8;
      k = 0;
      if (k < paramInt1)
      {
        m = k << 3;
        if (m + 8 < paramInt3)
          break label303;
      }
    }
    label303: for (int n = paramInt3 - 8; ; n = m)
    {
      int i1;
      int i2;
      label84: int i3;
      if (k > 1)
      {
        i1 = k;
        if (i1 >= paramInt1 - 2)
          break label179;
        i2 = i1;
        if (i <= 1)
          break label187;
        i3 = i;
        label94: if (i3 >= paramInt2 - 2)
          break label193;
      }
      int i4;
      while (true)
      {
        i4 = 0;
        for (int i5 = -2; i5 <= 2; i5++)
        {
          int[] arrayOfInt = paramArrayOfInt[(i3 + i5)];
          i4 += arrayOfInt[(i2 - 2)] + arrayOfInt[(i2 - 1)] + arrayOfInt[i2] + arrayOfInt[(i2 + 1)] + arrayOfInt[(i2 + 2)];
        }
        i1 = 2;
        break;
        label179: i2 = paramInt1 - 3;
        break label84;
        label187: i3 = 2;
        break label94;
        label193: i3 = paramInt2 - 3;
      }
      int i6 = i4 / 25;
      int i7 = n + j * paramInt3;
      int i8 = 0;
      int i9 = i7;
      while (i8 < 8)
      {
        for (int i10 = 0; i10 < 8; i10++)
          if ((0xFF & paramArrayOfByte[(i9 + i10)]) <= i6)
            paramBitMatrix.set(n + i10, j + i8);
        i8++;
        i9 += paramInt3;
      }
      k++;
      break label35;
      i++;
      break;
      return;
    }
  }

  private static int[][] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int[] arrayOfInt = { paramInt2, paramInt1 };
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt);
    int i = 0;
    int k;
    label61: int i1;
    int i2;
    int i3;
    int i4;
    int i5;
    label115: int i8;
    int i9;
    label129: int i12;
    if (i < paramInt2)
    {
      int j = i << 3;
      if (j + 8 >= paramInt4)
        j = paramInt4 - 8;
      k = 0;
      if (k < paramInt1)
      {
        int m = k << 3;
        if (m + 8 >= paramInt3)
          m = paramInt3 - 8;
        int n = m + j * paramInt3;
        i1 = 0;
        i2 = n;
        i3 = 0;
        i4 = 255;
        i5 = 0;
        if (i1 < 8)
        {
          i8 = i5;
          i9 = 0;
          if (i9 < 8)
          {
            i12 = 0xFF & paramArrayOfByte[(i2 + i9)];
            i8 += i12;
            if (i12 < i4)
              i4 = i12;
            if (i12 <= i3)
              break label323;
          }
        }
      }
    }
    while (true)
    {
      i9++;
      i3 = i12;
      break label129;
      int i10 = i1 + 1;
      int i11 = i2 + paramInt3;
      i1 = i10;
      i2 = i11;
      i5 = i8;
      break label115;
      int i6 = i5 >> 6;
      int i7;
      if (i3 - i4 <= 24)
      {
        i7 = i4 >> 1;
        if ((i <= 0) || (k <= 0))
          break label316;
        i6 = arrayOfInt1[(i - 1)][k] + 2 * arrayOfInt1[i][(k - 1)] + arrayOfInt1[(i - 1)][(k - 1)] >> 2;
        if (i4 >= i6)
          break label316;
      }
      while (true)
      {
        arrayOfInt1[i][k] = i6;
        k++;
        break label61;
        i++;
        break;
        return arrayOfInt1;
        label316: i6 = i7;
      }
      label323: i12 = i3;
    }
  }

  public final Binarizer createBinarizer(LuminanceSource paramLuminanceSource)
  {
    return new HybridBinarizer(paramLuminanceSource);
  }

  public final BitMatrix getBlackMatrix()
  {
    if (this.e != null)
      return this.e;
    LuminanceSource localLuminanceSource = getLuminanceSource();
    byte[] arrayOfByte;
    int i;
    int j;
    int k;
    if ((localLuminanceSource.getWidth() >= 40) && (localLuminanceSource.getHeight() >= 40))
    {
      arrayOfByte = localLuminanceSource.getMatrix();
      i = localLuminanceSource.getWidth();
      j = localLuminanceSource.getHeight();
      k = i >> 3;
      if ((i & 0x7) == 0)
        break label775;
    }
    label775: for (int m = k + 1; ; m = k)
    {
      int n = j >> 3;
      if ((j & 0x7) != 0);
      for (int i1 = n + 1; ; i1 = n)
      {
        int[] arrayOfInt1 = { i1, m };
        int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, arrayOfInt1);
        int i2 = 0;
        int i20;
        label153: int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        label204: int i29;
        int i30;
        label218: int i32;
        if (i2 < i1)
        {
          int i19 = i2 << 3;
          if (i19 + 8 >= j)
            i19 = j - 8;
          i20 = 0;
          if (i20 < m)
          {
            int i21 = i20 << 3;
            if (i21 + 8 >= i)
              i21 = i - 8;
            i22 = i21 + i19 * i;
            i23 = 0;
            i24 = 0;
            i25 = 255;
            i26 = 0;
            if (i23 < 8)
            {
              i29 = i26;
              i30 = 0;
              if (i30 < 8)
              {
                i32 = 0xFF & arrayOfByte[(i22 + i30)];
                i29 += i32;
                if (i32 < i25)
                  i25 = i32;
                if (i32 <= i24)
                  break label761;
              }
            }
          }
        }
        while (true)
        {
          i30++;
          i24 = i32;
          break label218;
          int i31 = i23 + 1;
          i22 += i;
          i23 = i31;
          i26 = i29;
          break label204;
          int i27 = i26 >> 6;
          int i28;
          if (i24 - i25 <= 24)
          {
            i28 = i25 >> 1;
            if ((i2 <= 0) || (i20 <= 0))
              break label754;
            i27 = arrayOfInt[(i2 - 1)][i20] + 2 * arrayOfInt[i2][(i20 - 1)] + arrayOfInt[(i2 - 1)][(i20 - 1)] >> 2;
            if (i25 >= i27)
              break label754;
          }
          while (true)
          {
            arrayOfInt[i2][i20] = i27;
            i20++;
            break label153;
            i2++;
            break;
            BitMatrix localBitMatrix = new BitMatrix(i, j);
            int i3 = 0;
            int i4;
            int i5;
            label443: int i6;
            label446: int i7;
            if (i3 < i1)
            {
              i4 = i3 << 3;
              if (i4 + 8 < j)
                break label740;
              i5 = j - 8;
              i6 = 0;
              if (i6 < m)
              {
                i7 = i6 << 3;
                if (i7 + 8 < i)
                  break label747;
              }
            }
            label593: label602: label608: label740: label747: for (int i8 = i - 8; ; i8 = i7)
            {
              int i9;
              int i10;
              label497: int i11;
              if (i6 > 1)
              {
                i9 = i6;
                if (i9 >= m - 2)
                  break label593;
                i10 = i9;
                if (i3 <= 1)
                  break label602;
                i11 = i3;
                label507: if (i11 >= i1 - 2)
                  break label608;
              }
              int i12;
              while (true)
              {
                i12 = 0;
                for (int i13 = -2; i13 <= 2; i13++)
                {
                  int[] arrayOfInt2 = arrayOfInt[(i11 + i13)];
                  i12 += arrayOfInt2[(i10 - 2)] + arrayOfInt2[(i10 - 1)] + arrayOfInt2[i10] + arrayOfInt2[(i10 + 1)] + arrayOfInt2[(i10 + 2)];
                }
                i9 = 2;
                break;
                i10 = m - 3;
                break label497;
                i11 = 2;
                break label507;
                i11 = i1 - 3;
              }
              int i14 = i12 / 25;
              int i15 = i8 + i5 * i;
              int i16 = 0;
              int i17 = i15;
              while (i16 < 8)
              {
                for (int i18 = 0; i18 < 8; i18++)
                  if ((0xFF & arrayOfByte[(i17 + i18)]) <= i14)
                    localBitMatrix.set(i8 + i18, i5 + i16);
                i16++;
                i17 += i;
              }
              i6++;
              break label446;
              i3++;
              break;
              for (this.e = localBitMatrix; ; this.e = super.getBlackMatrix())
                return this.e;
              i5 = i4;
              break label443;
            }
            label754: i27 = i28;
          }
          label761: i32 = i24;
        }
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.HybridBinarizer
 * JD-Core Version:    0.6.2
 */