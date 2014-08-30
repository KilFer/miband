package com.google.zxing.datamatrix.detector;

import com.google.zxing.ResultPoint;

final class b
{
  private final ResultPoint a;
  private final ResultPoint b;
  private final int c;

  private b(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, int paramInt)
  {
    this.a = paramResultPoint1;
    this.b = paramResultPoint2;
    this.c = paramInt;
  }

  final ResultPoint a()
  {
    return this.a;
  }

  final ResultPoint b()
  {
    return this.b;
  }

  public final int c()
  {
    return this.c;
  }

  public final String toString()
  {
    return this.a + "/" + this.b + '/' + this.c;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.detector.b
 * JD-Core Version:    0.6.2
 */