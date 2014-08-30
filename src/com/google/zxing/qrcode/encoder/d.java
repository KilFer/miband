package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

final class d
{
  private static final int[][] a = { { 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 1, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
  private static final int[][] b = { { 0, 0, 0, 0, 0, 0, 0, 0 } };
  private static final int[][] c = { { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 }, { 0 } };
  private static final int[][] d = { { 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1 } };
  private static final int[][] e = { { -1, -1, -1, -1, -1, -1, -1 }, { 6, 18, -1, -1, -1, -1, -1 }, { 6, 22, -1, -1, -1, -1, -1 }, { 6, 26, -1, -1, -1, -1, -1 }, { 6, 30, -1, -1, -1, -1, -1 }, { 6, 34, -1, -1, -1, -1, -1 }, { 6, 22, 38, -1, -1, -1, -1 }, { 6, 24, 42, -1, -1, -1, -1 }, { 6, 26, 46, -1, -1, -1, -1 }, { 6, 28, 50, -1, -1, -1, -1 }, { 6, 30, 54, -1, -1, -1, -1 }, { 6, 32, 58, -1, -1, -1, -1 }, { 6, 34, 62, -1, -1, -1, -1 }, { 6, 26, 46, 66, -1, -1, -1 }, { 6, 26, 48, 70, -1, -1, -1 }, { 6, 26, 50, 74, -1, -1, -1 }, { 6, 30, 54, 78, -1, -1, -1 }, { 6, 30, 56, 82, -1, -1, -1 }, { 6, 30, 58, 86, -1, -1, -1 }, { 6, 34, 62, 90, -1, -1, -1 }, { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, { 6, 32, 58, 84, 110, -1, -1 }, { 6, 30, 58, 86, 114, -1, -1 }, { 6, 34, 62, 90, 118, -1, -1 }, { 6, 26, 50, 74, 98, 122, -1 }, { 6, 30, 54, 78, 102, 126, -1 }, { 6, 26, 52, 78, 104, 130, -1 }, { 6, 30, 56, 82, 108, 134, -1 }, { 6, 34, 60, 86, 112, 138, -1 }, { 6, 30, 58, 86, 114, 142, -1 }, { 6, 34, 62, 90, 118, 146, -1 }, { 6, 30, 54, 78, 102, 126, 150 }, { 6, 24, 50, 76, 102, 128, 154 }, { 6, 28, 54, 80, 106, 132, 158 }, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, { 6, 30, 58, 86, 114, 142, 170 } };
  private static final int[][] f = { { 8, 0 }, { 8, 1 }, { 8, 2 }, { 8, 3 }, { 8, 4 }, { 8, 5 }, { 8, 7 }, { 8, 8 }, { 7, 8 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 2, 8 }, { 1, 8 }, { 0, 8 } };
  private static final int g = 7973;
  private static final int h = 1335;
  private static final int i = 21522;

  private static int a(int paramInt)
  {
    for (int j = 0; paramInt != 0; j++)
      paramInt >>>= 1;
    return j;
  }

  private static int a(int paramInt1, int paramInt2)
  {
    int j = a(paramInt2);
    int k = paramInt1 << j - 1;
    while (a(k) >= j)
      k ^= paramInt2 << a(k) - j;
    return k;
  }

  private static void a(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    if ((b[0].length != 8) || (b.length != 1))
      throw new WriterException("Bad horizontal separation pattern");
    for (int j = 0; j < 8; j++)
    {
      if (!b(paramByteMatrix.get(paramInt1 + j, paramInt2)))
        throw new WriterException();
      paramByteMatrix.set(paramInt1 + j, paramInt2, b[0][j]);
    }
  }

  private static void a(int paramInt, BitArray paramBitArray)
  {
    paramBitArray.appendBits(paramInt, 6);
    paramBitArray.appendBits(a(paramInt, 7973), 12);
    if (paramBitArray.getSize() != 18)
      throw new WriterException("should not happen but we got: " + paramBitArray.getSize());
  }

  private static void a(int paramInt, ByteMatrix paramByteMatrix)
  {
    int j = a[0].length;
    d(0, 0, paramByteMatrix);
    d(paramByteMatrix.getWidth() - j, 0, paramByteMatrix);
    d(0, paramByteMatrix.getWidth() - j, paramByteMatrix);
    int k = b[0].length;
    a(0, k - 1, paramByteMatrix);
    a(paramByteMatrix.getWidth() - k, k - 1, paramByteMatrix);
    a(0, paramByteMatrix.getWidth() - k, paramByteMatrix);
    int m = c.length;
    b(m, 0, paramByteMatrix);
    b(-1 + (paramByteMatrix.getHeight() - m), 0, paramByteMatrix);
    b(m, paramByteMatrix.getHeight() - m, paramByteMatrix);
    if (paramByteMatrix.get(8, -8 + paramByteMatrix.getHeight()) == 0)
      throw new WriterException();
    paramByteMatrix.set(8, -8 + paramByteMatrix.getHeight(), 1);
    if (paramInt >= 2)
    {
      int i2 = paramInt - 1;
      int[] arrayOfInt = e[i2];
      int i3 = e[i2].length;
      for (int i4 = 0; i4 < i3; i4++)
        for (int i5 = 0; i5 < i3; i5++)
        {
          int i6 = arrayOfInt[i4];
          int i7 = arrayOfInt[i5];
          if ((i7 != -1) && (i6 != -1) && (b(paramByteMatrix.get(i7, i6))))
          {
            int i8 = i7 - 2;
            int i9 = i6 - 2;
            if ((d[0].length != 5) || (d.length != 5))
              throw new WriterException("Bad position adjustment");
            for (int i10 = 0; i10 < 5; i10++)
              for (int i11 = 0; i11 < 5; i11++)
              {
                if (!b(paramByteMatrix.get(i8 + i11, i9 + i10)))
                  throw new WriterException();
                paramByteMatrix.set(i8 + i11, i9 + i10, d[i10][i11]);
              }
          }
        }
    }
    for (int n = 8; n < -8 + paramByteMatrix.getWidth(); n++)
    {
      int i1 = (n + 1) % 2;
      if (!c(paramByteMatrix.get(n, 6)))
        throw new WriterException();
      if (b(paramByteMatrix.get(n, 6)))
        paramByteMatrix.set(n, 6, i1);
      if (!c(paramByteMatrix.get(6, n)))
        throw new WriterException();
      if (b(paramByteMatrix.get(6, n)))
        paramByteMatrix.set(6, n, i1);
    }
  }

  private static void a(BitArray paramBitArray, int paramInt, ByteMatrix paramByteMatrix)
  {
    int j = -1 + paramByteMatrix.getWidth();
    int k = -1 + paramByteMatrix.getHeight();
    int m = -1;
    int n = 0;
    int i1;
    int i2;
    int i3;
    if (j > 0)
    {
      if (j != 6)
        break label491;
      int i14 = j - 1;
      i1 = k;
      i2 = i14;
      i3 = n;
    }
    while (true)
      if ((i1 >= 0) && (i1 < paramByteMatrix.getHeight()))
      {
        int i7 = 0;
        if (i7 < 2)
        {
          int i8 = i2 - i7;
          int i9;
          int i10;
          label233: int i11;
          if (b(paramByteMatrix.get(i8, i1)))
          {
            if (i3 < paramBitArray.getSize())
            {
              boolean bool2 = paramBitArray.get(i3);
              i9 = i3 + 1;
              bool1 = bool2;
            }
            while (paramInt != -1)
              if (!QRCode.isValidMaskPattern(paramInt))
              {
                throw new IllegalArgumentException("Invalid mask pattern");
                i9 = i3;
                bool1 = false;
              }
              else
              {
                switch (paramInt)
                {
                default:
                  throw new IllegalArgumentException("Invalid mask pattern: " + paramInt);
                case 0:
                  i10 = 0x1 & i1 + i8;
                  if (i10 != 0)
                    break label386;
                  i11 = 1;
                  label241: if (i11 != 0)
                    if (bool1)
                      break label392;
                  break;
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                }
              }
          }
          label386: label392: for (boolean bool1 = true; ; bool1 = false)
          {
            paramByteMatrix.set(i8, i1, bool1);
            i3 = i9;
            i7++;
            break;
            i10 = i1 & 0x1;
            break label233;
            i10 = i8 % 3;
            break label233;
            i10 = (i1 + i8) % 3;
            break label233;
            i10 = 0x1 & (i1 >>> 1) + i8 / 3;
            break label233;
            int i13 = i1 * i8;
            i10 = (i13 & 0x1) + i13 % 3;
            break label233;
            int i12 = i1 * i8;
            i10 = 0x1 & (i12 & 0x1) + i12 % 3;
            break label233;
            i10 = 0x1 & i1 * i8 % 3 + (0x1 & i1 + i8);
            break label233;
            i11 = 0;
            break label241;
          }
        }
        i1 += m;
      }
      else
      {
        int i4 = -m;
        int i5 = i1 + i4;
        int i6 = i2 - 2;
        m = i4;
        n = i3;
        k = i5;
        j = i6;
        break;
        if (n != paramBitArray.getSize())
          throw new WriterException("Not all bits consumed: " + n + '/' + paramBitArray.getSize());
        return;
        label491: i1 = k;
        i2 = j;
        i3 = n;
      }
  }

  static void a(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    paramByteMatrix.clear((byte)-1);
    int j = a[0].length;
    d(0, 0, paramByteMatrix);
    d(paramByteMatrix.getWidth() - j, 0, paramByteMatrix);
    d(0, paramByteMatrix.getWidth() - j, paramByteMatrix);
    int k = b[0].length;
    a(0, k - 1, paramByteMatrix);
    a(paramByteMatrix.getWidth() - k, k - 1, paramByteMatrix);
    a(0, paramByteMatrix.getWidth() - k, paramByteMatrix);
    int m = c.length;
    b(m, 0, paramByteMatrix);
    b(-1 + (paramByteMatrix.getHeight() - m), 0, paramByteMatrix);
    b(m, paramByteMatrix.getHeight() - m, paramByteMatrix);
    if (paramByteMatrix.get(8, -8 + paramByteMatrix.getHeight()) == 0)
      throw new WriterException();
    paramByteMatrix.set(8, -8 + paramByteMatrix.getHeight(), 1);
    if (paramInt1 >= 2)
    {
      int i4 = paramInt1 - 1;
      int[] arrayOfInt = e[i4];
      int i5 = e[i4].length;
      for (int i6 = 0; i6 < i5; i6++)
        for (int i7 = 0; i7 < i5; i7++)
        {
          int i8 = arrayOfInt[i6];
          int i9 = arrayOfInt[i7];
          if ((i9 != -1) && (i8 != -1) && (b(paramByteMatrix.get(i9, i8))))
          {
            int i10 = i9 - 2;
            int i11 = i8 - 2;
            if ((d[0].length != 5) || (d.length != 5))
              throw new WriterException("Bad position adjustment");
            for (int i12 = 0; i12 < 5; i12++)
              for (int i13 = 0; i13 < 5; i13++)
              {
                if (!b(paramByteMatrix.get(i10 + i13, i11 + i12)))
                  throw new WriterException();
                paramByteMatrix.set(i10 + i13, i11 + i12, d[i12][i13]);
              }
          }
        }
    }
    for (int n = 8; n < -8 + paramByteMatrix.getWidth(); n++)
    {
      int i3 = (n + 1) % 2;
      if (!c(paramByteMatrix.get(n, 6)))
        throw new WriterException();
      if (b(paramByteMatrix.get(n, 6)))
        paramByteMatrix.set(n, 6, i3);
      if (!c(paramByteMatrix.get(6, n)))
        throw new WriterException();
      if (b(paramByteMatrix.get(6, n)))
        paramByteMatrix.set(6, n, i3);
    }
    BitArray localBitArray1 = new BitArray();
    if (!QRCode.isValidMaskPattern(paramInt2))
      throw new WriterException("Invalid mask pattern");
    int i1 = paramInt2 | paramErrorCorrectionLevel.getBits() << 3;
    localBitArray1.appendBits(i1, 5);
    localBitArray1.appendBits(a(i1, 1335), 10);
    BitArray localBitArray2 = new BitArray();
    localBitArray2.appendBits(21522, 15);
    localBitArray1.xor(localBitArray2);
    if (localBitArray1.getSize() != 15)
      throw new WriterException("should not happen but we got: " + localBitArray1.getSize());
    int i2 = 0;
    if (i2 < localBitArray1.getSize())
    {
      boolean bool = localBitArray1.get(-1 + localBitArray1.getSize() - i2);
      paramByteMatrix.set(f[i2][0], f[i2][1], bool);
      if (i2 < 8)
        paramByteMatrix.set(-1 + (paramByteMatrix.getWidth() - i2), 8, bool);
      while (true)
      {
        i2++;
        break;
        paramByteMatrix.set(8, -7 + paramByteMatrix.getHeight() + (i2 - 8), bool);
      }
    }
    b(paramInt1, paramByteMatrix);
    a(paramBitArray, paramInt2, paramByteMatrix);
  }

  private static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, BitArray paramBitArray)
  {
    if (!QRCode.isValidMaskPattern(paramInt))
      throw new WriterException("Invalid mask pattern");
    int j = paramInt | paramErrorCorrectionLevel.getBits() << 3;
    paramBitArray.appendBits(j, 5);
    paramBitArray.appendBits(a(j, 1335), 10);
    BitArray localBitArray = new BitArray();
    localBitArray.appendBits(21522, 15);
    paramBitArray.xor(localBitArray);
    if (paramBitArray.getSize() != 15)
      throw new WriterException("should not happen but we got: " + paramBitArray.getSize());
  }

  private static void a(ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ByteMatrix paramByteMatrix)
  {
    BitArray localBitArray1 = new BitArray();
    if (!QRCode.isValidMaskPattern(paramInt))
      throw new WriterException("Invalid mask pattern");
    int j = paramInt | paramErrorCorrectionLevel.getBits() << 3;
    localBitArray1.appendBits(j, 5);
    localBitArray1.appendBits(a(j, 1335), 10);
    BitArray localBitArray2 = new BitArray();
    localBitArray2.appendBits(21522, 15);
    localBitArray1.xor(localBitArray2);
    if (localBitArray1.getSize() != 15)
      throw new WriterException("should not happen but we got: " + localBitArray1.getSize());
    int k = 0;
    if (k < localBitArray1.getSize())
    {
      boolean bool = localBitArray1.get(-1 + localBitArray1.getSize() - k);
      paramByteMatrix.set(f[k][0], f[k][1], bool);
      if (k < 8)
        paramByteMatrix.set(-1 + (paramByteMatrix.getWidth() - k), 8, bool);
      while (true)
      {
        k++;
        break;
        paramByteMatrix.set(8, -7 + paramByteMatrix.getHeight() + (k - 8), bool);
      }
    }
  }

  private static void a(ByteMatrix paramByteMatrix)
  {
    paramByteMatrix.clear((byte)-1);
  }

  private static void b(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    if ((c[0].length != 1) || (c.length != 7))
      throw new WriterException("Bad vertical separation pattern");
    for (int j = 0; j < 7; j++)
    {
      if (!b(paramByteMatrix.get(paramInt1, paramInt2 + j)))
        throw new WriterException();
      paramByteMatrix.set(paramInt1, paramInt2 + j, c[j][0]);
    }
  }

  private static void b(int paramInt, ByteMatrix paramByteMatrix)
  {
    if (paramInt < 7);
    while (true)
    {
      return;
      BitArray localBitArray = new BitArray();
      localBitArray.appendBits(paramInt, 6);
      localBitArray.appendBits(a(paramInt, 7973), 12);
      if (localBitArray.getSize() != 18)
        throw new WriterException("should not happen but we got: " + localBitArray.getSize());
      int j = 17;
      int k = 0;
      while (k < 6)
      {
        int m = j;
        for (int n = 0; n < 3; n++)
        {
          boolean bool = localBitArray.get(m);
          m--;
          paramByteMatrix.set(k, n + (-11 + paramByteMatrix.getHeight()), bool);
          paramByteMatrix.set(n + (-11 + paramByteMatrix.getHeight()), k, bool);
        }
        k++;
        j = m;
      }
    }
  }

  private static void b(ByteMatrix paramByteMatrix)
  {
    for (int j = 8; j < -8 + paramByteMatrix.getWidth(); j++)
    {
      int k = (j + 1) % 2;
      if (!c(paramByteMatrix.get(j, 6)))
        throw new WriterException();
      if (b(paramByteMatrix.get(j, 6)))
        paramByteMatrix.set(j, 6, k);
      if (!c(paramByteMatrix.get(6, j)))
        throw new WriterException();
      if (b(paramByteMatrix.get(6, j)))
        paramByteMatrix.set(6, j, k);
    }
  }

  private static boolean b(int paramInt)
  {
    return paramInt == -1;
  }

  private static void c(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    if ((d[0].length != 5) || (d.length != 5))
      throw new WriterException("Bad position adjustment");
    for (int j = 0; j < 5; j++)
      for (int k = 0; k < 5; k++)
      {
        if (!b(paramByteMatrix.get(paramInt1 + k, paramInt2 + j)))
          throw new WriterException();
        paramByteMatrix.set(paramInt1 + k, paramInt2 + j, d[j][k]);
      }
  }

  private static void c(int paramInt, ByteMatrix paramByteMatrix)
  {
    if (paramInt < 2);
    while (true)
    {
      return;
      int j = paramInt - 1;
      int[] arrayOfInt = e[j];
      int k = e[j].length;
      for (int m = 0; m < k; m++)
        for (int n = 0; n < k; n++)
        {
          int i1 = arrayOfInt[m];
          int i2 = arrayOfInt[n];
          if ((i2 != -1) && (i1 != -1) && (b(paramByteMatrix.get(i2, i1))))
          {
            int i3 = i2 - 2;
            int i4 = i1 - 2;
            if ((d[0].length != 5) || (d.length != 5))
              throw new WriterException("Bad position adjustment");
            for (int i5 = 0; i5 < 5; i5++)
              for (int i6 = 0; i6 < 5; i6++)
              {
                if (!b(paramByteMatrix.get(i3 + i6, i4 + i5)))
                  throw new WriterException();
                paramByteMatrix.set(i3 + i6, i4 + i5, d[i5][i6]);
              }
          }
        }
    }
  }

  private static void c(ByteMatrix paramByteMatrix)
  {
    if (paramByteMatrix.get(8, -8 + paramByteMatrix.getHeight()) == 0)
      throw new WriterException();
    paramByteMatrix.set(8, -8 + paramByteMatrix.getHeight(), 1);
  }

  private static boolean c(int paramInt)
  {
    return (paramInt == -1) || (paramInt == 0) || (paramInt == 1);
  }

  private static void d(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    if ((a[0].length != 7) || (a.length != 7))
      throw new WriterException("Bad position detection pattern");
    for (int j = 0; j < 7; j++)
      for (int k = 0; k < 7; k++)
      {
        if (!b(paramByteMatrix.get(paramInt1 + k, paramInt2 + j)))
          throw new WriterException();
        paramByteMatrix.set(paramInt1 + k, paramInt2 + j, a[j][k]);
      }
  }

  private static void d(ByteMatrix paramByteMatrix)
  {
    int j = a[0].length;
    d(0, 0, paramByteMatrix);
    d(paramByteMatrix.getWidth() - j, 0, paramByteMatrix);
    d(0, paramByteMatrix.getWidth() - j, paramByteMatrix);
    int k = b[0].length;
    a(0, k - 1, paramByteMatrix);
    a(paramByteMatrix.getWidth() - k, k - 1, paramByteMatrix);
    a(0, paramByteMatrix.getWidth() - k, paramByteMatrix);
    int m = c.length;
    b(m, 0, paramByteMatrix);
    b(-1 + (paramByteMatrix.getHeight() - m), 0, paramByteMatrix);
    b(m, paramByteMatrix.getHeight() - m, paramByteMatrix);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.d
 * JD-Core Version:    0.6.2
 */