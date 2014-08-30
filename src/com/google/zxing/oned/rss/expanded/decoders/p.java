package com.google.zxing.oned.rss.expanded.decoders;

final class p extends q
{
  private static int c = 10;
  private final int a;
  private final int b;

  p(int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1);
    this.a = paramInt2;
    this.b = paramInt3;
    if ((this.a < 0) || (this.a > 10))
      throw new IllegalArgumentException("Invalid firstDigit: " + paramInt2);
    if ((this.b < 0) || (this.b > 10))
      throw new IllegalArgumentException("Invalid secondDigit: " + paramInt3);
  }

  private int f()
  {
    return 10 * this.a + this.b;
  }

  private boolean g()
  {
    return (this.a == 10) || (this.b == 10);
  }

  final int a()
  {
    return this.a;
  }

  final int b()
  {
    return this.b;
  }

  final boolean c()
  {
    return this.a == 10;
  }

  final boolean d()
  {
    return this.b == 10;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.p
 * JD-Core Version:    0.6.2
 */