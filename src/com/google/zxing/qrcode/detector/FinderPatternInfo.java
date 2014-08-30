package com.google.zxing.qrcode.detector;

public final class FinderPatternInfo
{
  private final FinderPattern a = paramArrayOfFinderPattern[0];
  private final FinderPattern b = paramArrayOfFinderPattern[1];
  private final FinderPattern c = paramArrayOfFinderPattern[2];

  public FinderPatternInfo(FinderPattern[] paramArrayOfFinderPattern)
  {
  }

  public final FinderPattern getBottomLeft()
  {
    return this.a;
  }

  public final FinderPattern getTopLeft()
  {
    return this.b;
  }

  public final FinderPattern getTopRight()
  {
    return this.c;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternInfo
 * JD-Core Version:    0.6.2
 */