package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

abstract class c
{
  private static final c[] a = arrayOfc;

  static
  {
    c[] arrayOfc = new c[8];
    arrayOfc[0] = new e(0);
    arrayOfc[1] = new f(0);
    arrayOfc[2] = new g(0);
    arrayOfc[3] = new h(0);
    arrayOfc[4] = new i(0);
    arrayOfc[5] = new j(0);
    arrayOfc[6] = new k(0);
    arrayOfc[7] = new l(0);
  }

  static c a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 7))
      throw new IllegalArgumentException();
    return a[paramInt];
  }

  final void a(BitMatrix paramBitMatrix, int paramInt)
  {
    for (int i = 0; i < paramInt; i++)
      for (int j = 0; j < paramInt; j++)
        if (a(i, j))
          paramBitMatrix.flip(j, i);
  }

  abstract boolean a(int paramInt1, int paramInt2);
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.c
 * JD-Core Version:    0.6.2
 */