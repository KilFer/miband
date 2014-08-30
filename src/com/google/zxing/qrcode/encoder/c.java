package com.google.zxing.qrcode.encoder;

final class c
{
  static int a(ByteMatrix paramByteMatrix)
  {
    return a.a(paramByteMatrix, true) + a.a(paramByteMatrix, false);
  }

  private static int a(ByteMatrix paramByteMatrix, boolean paramBoolean)
  {
    int i = -1;
    int j;
    int k;
    label21: byte[][] arrayOfByte;
    int m;
    int n;
    if (paramBoolean)
    {
      j = paramByteMatrix.getHeight();
      if (!paramBoolean)
        break label105;
      k = paramByteMatrix.getWidth();
      arrayOfByte = paramByteMatrix.getArray();
      m = 0;
      n = 0;
    }
    while (true)
    {
      if (m >= j)
        break label158;
      int i1 = 0;
      int i2 = 0;
      label45: if (i1 < k)
      {
        int i3;
        label66: int i5;
        if (paramBoolean)
        {
          i3 = arrayOfByte[m][i1];
          if (i3 != i)
            break label139;
          i5 = i2 + 1;
          if (i5 != 5)
            break label127;
          n += 3;
        }
        while (true)
        {
          i1++;
          i2 = i5;
          break label45;
          j = paramByteMatrix.getWidth();
          break;
          label105: k = paramByteMatrix.getHeight();
          break label21;
          i3 = arrayOfByte[i1][m];
          break label66;
          label127: if (i5 > 5)
          {
            n++;
            continue;
            int i4 = i3;
            i5 = 1;
            i = i4;
          }
        }
      }
      label139: m++;
    }
    label158: return n;
  }

  static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!QRCode.isValidMaskPattern(paramInt1))
      throw new IllegalArgumentException("Invalid mask pattern");
    int i;
    switch (paramInt1)
    {
    default:
      throw new IllegalArgumentException("Invalid mask pattern: " + paramInt1);
    case 0:
      i = 0x1 & paramInt3 + paramInt2;
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    }
    while (i == 0)
    {
      return true;
      i = paramInt3 & 0x1;
      continue;
      i = paramInt2 % 3;
      continue;
      i = (paramInt3 + paramInt2) % 3;
      continue;
      i = 0x1 & (paramInt3 >>> 1) + paramInt2 / 3;
      continue;
      int k = paramInt3 * paramInt2;
      i = (k & 0x1) + k % 3;
      continue;
      int j = paramInt3 * paramInt2;
      i = 0x1 & (j & 0x1) + j % 3;
      continue;
      i = 0x1 & paramInt3 * paramInt2 % 3 + (0x1 & paramInt3 + paramInt2);
    }
    return false;
  }

  static int b(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int i = paramByteMatrix.getWidth();
    int j = paramByteMatrix.getHeight();
    int k = 0;
    int m = 0;
    while (k < j - 1)
    {
      for (int n = 0; n < i - 1; n++)
      {
        int i1 = arrayOfByte[k][n];
        if ((i1 == arrayOfByte[k][(n + 1)]) && (i1 == arrayOfByte[(k + 1)][n]) && (i1 == arrayOfByte[(k + 1)][(n + 1)]))
          m += 3;
      }
      k++;
    }
    return m;
  }

  static int c(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int i = paramByteMatrix.getWidth();
    int j = paramByteMatrix.getHeight();
    int k = 0;
    int m = 0;
    while (k < j)
    {
      for (int n = 0; n < i; n++)
      {
        if ((n + 6 < i) && (arrayOfByte[k][n] == 1) && (arrayOfByte[k][(n + 1)] == 0) && (arrayOfByte[k][(n + 2)] == 1) && (arrayOfByte[k][(n + 3)] == 1) && (arrayOfByte[k][(n + 4)] == 1) && (arrayOfByte[k][(n + 5)] == 0) && (arrayOfByte[k][(n + 6)] == 1) && (((n + 10 < i) && (arrayOfByte[k][(n + 7)] == 0) && (arrayOfByte[k][(n + 8)] == 0) && (arrayOfByte[k][(n + 9)] == 0) && (arrayOfByte[k][(n + 10)] == 0)) || ((n - 4 >= 0) && (arrayOfByte[k][(n - 1)] == 0) && (arrayOfByte[k][(n - 2)] == 0) && (arrayOfByte[k][(n - 3)] == 0) && (arrayOfByte[k][(n - 4)] == 0))))
          m += 40;
        if ((k + 6 < j) && (arrayOfByte[k][n] == 1) && (arrayOfByte[(k + 1)][n] == 0) && (arrayOfByte[(k + 2)][n] == 1) && (arrayOfByte[(k + 3)][n] == 1) && (arrayOfByte[(k + 4)][n] == 1) && (arrayOfByte[(k + 5)][n] == 0) && (arrayOfByte[(k + 6)][n] == 1) && (((k + 10 < j) && (arrayOfByte[(k + 7)][n] == 0) && (arrayOfByte[(k + 8)][n] == 0) && (arrayOfByte[(k + 9)][n] == 0) && (arrayOfByte[(k + 10)][n] == 0)) || ((k - 4 >= 0) && (arrayOfByte[(k - 1)][n] == 0) && (arrayOfByte[(k - 2)][n] == 0) && (arrayOfByte[(k - 3)][n] == 0) && (arrayOfByte[(k - 4)][n] == 0))))
          m += 40;
      }
      k++;
    }
    return m;
  }

  static int d(ByteMatrix paramByteMatrix)
  {
    byte[][] arrayOfByte = paramByteMatrix.getArray();
    int i = paramByteMatrix.getWidth();
    int j = paramByteMatrix.getHeight();
    int k = 0;
    int m = 0;
    while (k < j)
    {
      for (int i1 = 0; i1 < i; i1++)
        if (arrayOfByte[k][i1] == 1)
          m++;
      k++;
    }
    int n = paramByteMatrix.getHeight() * paramByteMatrix.getWidth();
    return 10 * (Math.abs((int)(100.0D * (m / n) - 50.0D)) / 5);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.c
 * JD-Core Version:    0.6.2
 */