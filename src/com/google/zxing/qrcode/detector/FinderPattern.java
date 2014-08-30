package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern extends ResultPoint
{
  private final float a;
  private int b;

  FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramFloat1, paramFloat2, paramFloat3, 1);
  }

  private FinderPattern(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    super(paramFloat1, paramFloat2);
    this.a = paramFloat3;
    this.b = paramInt;
  }

  private void b()
  {
    this.b = (1 + this.b);
  }

  final int a()
  {
    return this.b;
  }

  final boolean a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool1 = Math.abs(paramFloat2 - getY()) < paramFloat1;
    boolean bool2 = false;
    if (!bool1)
    {
      boolean bool3 = Math.abs(paramFloat3 - getX()) < paramFloat1;
      bool2 = false;
      if (!bool3)
      {
        float f = Math.abs(paramFloat1 - this.a);
        if (f > 1.0F)
        {
          boolean bool4 = f < this.a;
          bool2 = false;
          if (bool4);
        }
        else
        {
          bool2 = true;
        }
      }
    }
    return bool2;
  }

  final FinderPattern b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    int i = 1 + this.b;
    return new FinderPattern((paramFloat2 + this.b * getX()) / i, (paramFloat1 + this.b * getY()) / i, (paramFloat3 + this.b * this.a) / i, i);
  }

  public final float getEstimatedModuleSize()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPattern
 * JD-Core Version:    0.6.2
 */