package com.google.zxing.oned.rss;

import com.google.zxing.ResultPoint;

public final class FinderPattern
{
  private final int a;
  private final int[] b;
  private final ResultPoint[] c;

  public FinderPattern(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramArrayOfInt;
    ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
    arrayOfResultPoint[0] = new ResultPoint(paramInt2, paramInt4);
    arrayOfResultPoint[1] = new ResultPoint(paramInt3, paramInt4);
    this.c = arrayOfResultPoint;
  }

  public final ResultPoint[] getResultPoints()
  {
    return this.c;
  }

  public final int[] getStartEnd()
  {
    return this.b;
  }

  public final int getValue()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.FinderPattern
 * JD-Core Version:    0.6.2
 */