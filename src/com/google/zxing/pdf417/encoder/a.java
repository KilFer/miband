package com.google.zxing.pdf417.encoder;

import java.lang.reflect.Array;

final class a
{
  private final b[] a;
  private int b;
  private final int c;
  private final int d;

  a(int paramInt1, int paramInt2)
  {
    this.a = new b[paramInt1 + 2];
    int i = this.a.length;
    for (int j = 0; j < i; j++)
      this.a[j] = new b(1 + 17 * (paramInt2 + 4));
    this.d = (paramInt2 * 17);
    this.c = (paramInt1 + 2);
    this.b = 0;
  }

  private void a(int paramInt1, int paramInt2, byte paramByte)
  {
    this.a[paramInt2].a(paramInt1, paramByte);
  }

  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramBoolean);
    for (int i = 1; ; i = 0)
    {
      byte b1 = (byte)i;
      this.a[paramInt2].a(paramInt1, b1);
      return;
    }
  }

  private byte[][] a(int paramInt)
  {
    return a(paramInt, paramInt);
  }

  private byte[][] c()
  {
    return a(1, 1);
  }

  final void a()
  {
    this.b = (1 + this.b);
  }

  final byte[][] a(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = { paramInt2 * this.c, paramInt1 * this.d };
    byte[][] arrayOfByte = (byte[][])Array.newInstance(Byte.TYPE, arrayOfInt);
    int i = paramInt2 * this.c;
    for (int j = 0; j < i; j++)
      arrayOfByte[(-1 + (i - j))] = this.a[(j / paramInt2)].a(paramInt1);
    return arrayOfByte;
  }

  final b b()
  {
    return this.a[this.b];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.encoder.a
 * JD-Core Version:    0.6.2
 */