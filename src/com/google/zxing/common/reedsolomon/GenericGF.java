package com.google.zxing.common.reedsolomon;

public final class GenericGF
{
  public static final GenericGF AZTEC_DATA_10;
  public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, 4096);
  public static final GenericGF AZTEC_DATA_6;
  public static final GenericGF AZTEC_DATA_8 = localGenericGF;
  public static final GenericGF AZTEC_PARAM;
  public static final GenericGF DATA_MATRIX_FIELD_256;
  public static final GenericGF MAXICODE_FIELD_64 = AZTEC_DATA_6;
  public static final GenericGF QR_CODE_FIELD_256;
  private static final int a;
  private int[] b;
  private int[] c;
  private a d;
  private a e;
  private final int f;
  private final int g;
  private boolean h = false;

  static
  {
    AZTEC_DATA_10 = new GenericGF(1033, 1024);
    AZTEC_DATA_6 = new GenericGF(67, 64);
    AZTEC_PARAM = new GenericGF(19, 16);
    QR_CODE_FIELD_256 = new GenericGF(285, 256);
    GenericGF localGenericGF = new GenericGF(301, 256);
    DATA_MATRIX_FIELD_256 = localGenericGF;
  }

  public GenericGF(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.f = paramInt2;
    if (paramInt2 <= 0)
      c();
  }

  static int b(int paramInt1, int paramInt2)
  {
    return paramInt1 ^ paramInt2;
  }

  private void c()
  {
    this.b = new int[this.f];
    this.c = new int[this.f];
    int i = 0;
    int j = 1;
    while (i < this.f)
    {
      this.b[i] = j;
      j <<= 1;
      if (j >= this.f)
        j = (j ^ this.g) & -1 + this.f;
      i++;
    }
    for (int k = 0; k < -1 + this.f; k++)
      this.c[this.b[k]] = k;
    this.d = new a(this, new int[] { 0 });
    this.e = new a(this, new int[] { 1 });
    this.h = true;
  }

  private void d()
  {
    if (!this.h)
      c();
  }

  final int a(int paramInt)
  {
    d();
    return this.b[paramInt];
  }

  final a a()
  {
    d();
    return this.d;
  }

  final a a(int paramInt1, int paramInt2)
  {
    d();
    if (paramInt1 < 0)
      throw new IllegalArgumentException();
    if (paramInt2 == 0)
      return this.d;
    int[] arrayOfInt = new int[paramInt1 + 1];
    arrayOfInt[0] = paramInt2;
    return new a(this, arrayOfInt);
  }

  final int b(int paramInt)
  {
    d();
    if (paramInt == 0)
      throw new IllegalArgumentException();
    return this.c[paramInt];
  }

  final a b()
  {
    d();
    return this.e;
  }

  final int c(int paramInt)
  {
    d();
    if (paramInt == 0)
      throw new ArithmeticException();
    return this.b[(-1 + (this.f - this.c[paramInt]))];
  }

  final int c(int paramInt1, int paramInt2)
  {
    d();
    if ((paramInt1 == 0) || (paramInt2 == 0))
      return 0;
    if ((paramInt1 < 0) || (paramInt2 < 0) || (paramInt1 >= this.f) || (paramInt2 >= this.f))
      paramInt1++;
    int i = this.c[paramInt1] + this.c[paramInt2];
    return this.b[(i % this.f + i / this.f)];
  }

  public final int getSize()
  {
    return this.f;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.GenericGF
 * JD-Core Version:    0.6.2
 */