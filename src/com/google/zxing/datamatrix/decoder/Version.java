package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;

public final class Version
{
  private static final Version[] a = arrayOfVersion;
  private final int b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final h g;
  private final int h;

  static
  {
    Version[] arrayOfVersion = new Version[30];
    arrayOfVersion[0] = new Version(1, 10, 10, 8, 8, new h(5, new g(1, 3, 0), 0));
    arrayOfVersion[1] = new Version(2, 12, 12, 10, 10, new h(7, new g(1, 5, 0), 0));
    arrayOfVersion[2] = new Version(3, 14, 14, 12, 12, new h(10, new g(1, 8, 0), 0));
    arrayOfVersion[3] = new Version(4, 16, 16, 14, 14, new h(12, new g(1, 12, 0), 0));
    arrayOfVersion[4] = new Version(5, 18, 18, 16, 16, new h(14, new g(1, 18, 0), 0));
    arrayOfVersion[5] = new Version(6, 20, 20, 18, 18, new h(18, new g(1, 22, 0), 0));
    arrayOfVersion[6] = new Version(7, 22, 22, 20, 20, new h(20, new g(1, 30, 0), 0));
    arrayOfVersion[7] = new Version(8, 24, 24, 22, 22, new h(24, new g(1, 36, 0), 0));
    arrayOfVersion[8] = new Version(9, 26, 26, 24, 24, new h(28, new g(1, 44, 0), 0));
    arrayOfVersion[9] = new Version(10, 32, 32, 14, 14, new h(36, new g(1, 62, 0), 0));
    arrayOfVersion[10] = new Version(11, 36, 36, 16, 16, new h(42, new g(1, 86, 0), 0));
    arrayOfVersion[11] = new Version(12, 40, 40, 18, 18, new h(48, new g(1, 114, 0), 0));
    arrayOfVersion[12] = new Version(13, 44, 44, 20, 20, new h(56, new g(1, 144, 0), 0));
    arrayOfVersion[13] = new Version(14, 48, 48, 22, 22, new h(68, new g(1, 174, 0), 0));
    arrayOfVersion[14] = new Version(15, 52, 52, 24, 24, new h(42, new g(2, 102, 0), 0));
    arrayOfVersion[15] = new Version(16, 64, 64, 14, 14, new h(56, new g(2, 140, 0), 0));
    arrayOfVersion[16] = new Version(17, 72, 72, 16, 16, new h(36, new g(4, 92, 0), 0));
    arrayOfVersion[17] = new Version(18, 80, 80, 18, 18, new h(48, new g(4, 114, 0), 0));
    arrayOfVersion[18] = new Version(19, 88, 88, 20, 20, new h(56, new g(4, 144, 0), 0));
    arrayOfVersion[19] = new Version(20, 96, 96, 22, 22, new h(68, new g(4, 174, 0), 0));
    arrayOfVersion[20] = new Version(21, 104, 104, 24, 24, new h(56, new g(6, 136, 0), 0));
    arrayOfVersion[21] = new Version(22, 120, 120, 18, 18, new h(68, new g(6, 175, 0), 0));
    arrayOfVersion[22] = new Version(23, 132, 132, 20, 20, new h(62, new g(8, 163, 0), 0));
    arrayOfVersion[23] = new Version(24, 144, 144, 22, 22, new h(62, new g(8, 156, 0), new g(2, 155, 0), 0));
    arrayOfVersion[24] = new Version(25, 8, 18, 6, 16, new h(7, new g(1, 5, 0), 0));
    arrayOfVersion[25] = new Version(26, 8, 32, 6, 14, new h(11, new g(1, 10, 0), 0));
    arrayOfVersion[26] = new Version(27, 12, 26, 10, 24, new h(14, new g(1, 16, 0), 0));
    arrayOfVersion[27] = new Version(28, 12, 36, 10, 16, new h(18, new g(1, 22, 0), 0));
    arrayOfVersion[28] = new Version(29, 16, 36, 14, 16, new h(24, new g(1, 32, 0), 0));
    arrayOfVersion[29] = new Version(30, 16, 48, 14, 22, new h(28, new g(1, 49, 0), 0));
  }

  private Version(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, h paramh)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
    this.g = paramh;
    int j = paramh.a();
    g[] arrayOfg = paramh.b();
    int k = arrayOfg.length;
    int m = 0;
    while (i < k)
    {
      g localg = arrayOfg[i];
      m += localg.a() * (j + localg.b());
      i++;
    }
    this.h = m;
  }

  private static Version[] b()
  {
    Version[] arrayOfVersion = new Version[30];
    arrayOfVersion[0] = new Version(1, 10, 10, 8, 8, new h(5, new g(1, 3, 0), 0));
    arrayOfVersion[1] = new Version(2, 12, 12, 10, 10, new h(7, new g(1, 5, 0), 0));
    arrayOfVersion[2] = new Version(3, 14, 14, 12, 12, new h(10, new g(1, 8, 0), 0));
    arrayOfVersion[3] = new Version(4, 16, 16, 14, 14, new h(12, new g(1, 12, 0), 0));
    arrayOfVersion[4] = new Version(5, 18, 18, 16, 16, new h(14, new g(1, 18, 0), 0));
    arrayOfVersion[5] = new Version(6, 20, 20, 18, 18, new h(18, new g(1, 22, 0), 0));
    arrayOfVersion[6] = new Version(7, 22, 22, 20, 20, new h(20, new g(1, 30, 0), 0));
    arrayOfVersion[7] = new Version(8, 24, 24, 22, 22, new h(24, new g(1, 36, 0), 0));
    arrayOfVersion[8] = new Version(9, 26, 26, 24, 24, new h(28, new g(1, 44, 0), 0));
    arrayOfVersion[9] = new Version(10, 32, 32, 14, 14, new h(36, new g(1, 62, 0), 0));
    arrayOfVersion[10] = new Version(11, 36, 36, 16, 16, new h(42, new g(1, 86, 0), 0));
    arrayOfVersion[11] = new Version(12, 40, 40, 18, 18, new h(48, new g(1, 114, 0), 0));
    arrayOfVersion[12] = new Version(13, 44, 44, 20, 20, new h(56, new g(1, 144, 0), 0));
    arrayOfVersion[13] = new Version(14, 48, 48, 22, 22, new h(68, new g(1, 174, 0), 0));
    arrayOfVersion[14] = new Version(15, 52, 52, 24, 24, new h(42, new g(2, 102, 0), 0));
    arrayOfVersion[15] = new Version(16, 64, 64, 14, 14, new h(56, new g(2, 140, 0), 0));
    arrayOfVersion[16] = new Version(17, 72, 72, 16, 16, new h(36, new g(4, 92, 0), 0));
    arrayOfVersion[17] = new Version(18, 80, 80, 18, 18, new h(48, new g(4, 114, 0), 0));
    arrayOfVersion[18] = new Version(19, 88, 88, 20, 20, new h(56, new g(4, 144, 0), 0));
    arrayOfVersion[19] = new Version(20, 96, 96, 22, 22, new h(68, new g(4, 174, 0), 0));
    arrayOfVersion[20] = new Version(21, 104, 104, 24, 24, new h(56, new g(6, 136, 0), 0));
    arrayOfVersion[21] = new Version(22, 120, 120, 18, 18, new h(68, new g(6, 175, 0), 0));
    arrayOfVersion[22] = new Version(23, 132, 132, 20, 20, new h(62, new g(8, 163, 0), 0));
    arrayOfVersion[23] = new Version(24, 144, 144, 22, 22, new h(62, new g(8, 156, 0), new g(2, 155, 0), 0));
    arrayOfVersion[24] = new Version(25, 8, 18, 6, 16, new h(7, new g(1, 5, 0), 0));
    arrayOfVersion[25] = new Version(26, 8, 32, 6, 14, new h(11, new g(1, 10, 0), 0));
    arrayOfVersion[26] = new Version(27, 12, 26, 10, 24, new h(14, new g(1, 16, 0), 0));
    arrayOfVersion[27] = new Version(28, 12, 36, 10, 16, new h(18, new g(1, 22, 0), 0));
    arrayOfVersion[28] = new Version(29, 16, 36, 14, 16, new h(24, new g(1, 32, 0), 0));
    arrayOfVersion[29] = new Version(30, 16, 48, 14, 22, new h(28, new g(1, 49, 0), 0));
    return arrayOfVersion;
  }

  public static Version getVersionForDimensions(int paramInt1, int paramInt2)
  {
    if (((paramInt1 & 0x1) != 0) || ((paramInt2 & 0x1) != 0))
      throw FormatException.getFormatInstance();
    int i = a.length;
    for (int j = 0; j < i; j++)
    {
      Version localVersion = a[j];
      if ((localVersion.c == paramInt1) && (localVersion.d == paramInt2))
        return localVersion;
    }
    throw FormatException.getFormatInstance();
  }

  final h a()
  {
    return this.g;
  }

  public final int getDataRegionSizeColumns()
  {
    return this.f;
  }

  public final int getDataRegionSizeRows()
  {
    return this.e;
  }

  public final int getSymbolSizeColumns()
  {
    return this.d;
  }

  public final int getSymbolSizeRows()
  {
    return this.c;
  }

  public final int getTotalCodewords()
  {
    return this.h;
  }

  public final int getVersionNumber()
  {
    return this.b;
  }

  public final String toString()
  {
    return String.valueOf(this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.decoder.Version
 * JD-Core Version:    0.6.2
 */