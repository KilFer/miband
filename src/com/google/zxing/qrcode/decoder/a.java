package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.BitMatrix;

class a
{
  private final BitMatrix a;
  private Version b;
  private n c;

  a(BitMatrix paramBitMatrix)
  {
    int i = paramBitMatrix.getHeight();
    if ((i < 21) || ((i & 0x3) != 1))
      throw FormatException.getFormatInstance();
    this.a = paramBitMatrix;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.a.get(paramInt1, paramInt2))
      return 0x1 | paramInt3 << 1;
    return paramInt3 << 1;
  }

  final n a()
  {
    int i = 0;
    if (this.c != null)
      return this.c;
    int j = 0;
    int k = 0;
    while (j < 6)
    {
      k = a(j, 8, k);
      j++;
    }
    int m = a(8, 7, a(8, 8, a(7, 8, k)));
    for (int n = 5; n >= 0; n--)
      m = a(8, n, m);
    int i1 = this.a.getHeight();
    int i2 = i1 - 7;
    for (int i3 = i1 - 1; i3 >= i2; i3--)
      i = a(8, i3, i);
    for (int i4 = i1 - 8; i4 < i1; i4++)
      i = a(i4, 8, i);
    this.c = n.b(m, i);
    if (this.c != null)
      return this.c;
    throw FormatException.getFormatInstance();
  }

  final Version b()
  {
    if (this.b != null)
      return this.b;
    int i = this.a.getHeight();
    int j = i - 17 >> 2;
    if (j <= 6)
      return Version.getVersionForNumber(j);
    int k = i - 11;
    int m = 5;
    int n = 0;
    while (m >= 0)
    {
      for (int i5 = i - 9; i5 >= k; i5--)
        n = a(i5, m, n);
      m--;
    }
    Version localVersion1 = Version.a(n);
    if ((localVersion1 != null) && (localVersion1.getDimensionForVersion() == i))
    {
      this.b = localVersion1;
      return localVersion1;
    }
    int i1 = 5;
    int i2 = 0;
    while (i1 >= 0)
    {
      int i3 = i - 9;
      while (i3 >= k)
      {
        int i4 = a(i1, i3, i2);
        i3--;
        i2 = i4;
      }
      i1--;
    }
    Version localVersion2 = Version.a(i2);
    if ((localVersion2 != null) && (localVersion2.getDimensionForVersion() == i))
    {
      this.b = localVersion2;
      return localVersion2;
    }
    throw FormatException.getFormatInstance();
  }

  final byte[] c()
  {
    n localn = a();
    Version localVersion = b();
    c localc = c.a(localn.b());
    int i = this.a.getHeight();
    localc.a(this.a, i);
    BitMatrix localBitMatrix = localVersion.a();
    byte[] arrayOfByte = new byte[localVersion.getTotalCodewords()];
    int j = i - 1;
    int k = 0;
    int m = 0;
    int n = 0;
    int i3;
    for (int i1 = 1; j > 0; i1 = i3)
    {
      if (j == 6)
        j--;
      for (int i2 = 0; i2 < i; i2++)
      {
        if (i1 != 0);
        for (int i4 = i - 1 - i2; ; i4 = i2)
          for (int i5 = 0; i5 < 2; i5++)
            if (!localBitMatrix.get(j - i5, i4))
            {
              k++;
              m <<= 1;
              if (this.a.get(j - i5, i4))
                m |= 1;
              if (k == 8)
              {
                int i6 = n + 1;
                arrayOfByte[n] = ((byte)m);
                m = 0;
                n = i6;
                k = 0;
              }
            }
      }
      i3 = i1 ^ 0x1;
      j -= 2;
    }
    if (n != localVersion.getTotalCodewords())
      throw FormatException.getFormatInstance();
    return arrayOfByte;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.a
 * JD-Core Version:    0.6.2
 */