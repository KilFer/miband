package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class WhiteRectangleDetector
{
  private static final int a = 30;
  private static final int b = 1;
  private final BitMatrix c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  private final int h;
  private final int i;

  public WhiteRectangleDetector(BitMatrix paramBitMatrix)
  {
    this.c = paramBitMatrix;
    this.d = paramBitMatrix.getHeight();
    this.e = paramBitMatrix.getWidth();
    this.f = (-30 + this.e >> 1);
    this.g = (30 + this.e >> 1);
    this.i = (-30 + this.d >> 1);
    this.h = (30 + this.d >> 1);
    if ((this.i < 0) || (this.f < 0) || (this.h >= this.d) || (this.g >= this.e))
      throw NotFoundException.getNotFoundInstance();
  }

  public WhiteRectangleDetector(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramBitMatrix;
    this.d = paramBitMatrix.getHeight();
    this.e = paramBitMatrix.getWidth();
    int j = paramInt1 >> 1;
    this.f = (paramInt2 - j);
    this.g = (paramInt2 + j);
    this.i = (paramInt3 - j);
    this.h = (j + paramInt3);
    if ((this.i < 0) || (this.f < 0) || (this.h >= this.d) || (this.g >= this.e))
      throw NotFoundException.getNotFoundInstance();
  }

  private static int a(float paramFloat)
  {
    return (int)(0.5F + paramFloat);
  }

  private ResultPoint a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 - paramFloat3;
    float f2 = paramFloat2 - paramFloat4;
    int j = (int)(0.5F + (float)Math.sqrt(f1 * f1 + f2 * f2));
    float f3 = (paramFloat3 - paramFloat1) / j;
    float f4 = (paramFloat4 - paramFloat2) / j;
    for (int k = 0; k < j; k++)
    {
      int m = (int)(0.5F + (paramFloat1 + f3 * k));
      int n = (int)(0.5F + (paramFloat2 + f4 * k));
      if (this.c.get(m, n))
        return new ResultPoint(m, n);
    }
    return null;
  }

  private boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if (paramBoolean)
      while (paramInt1 <= paramInt2)
      {
        if (this.c.get(paramInt1, paramInt3))
          return true;
        paramInt1++;
      }
    do
    {
      paramInt1++;
      if (paramInt1 > paramInt2)
        break;
    }
    while (!this.c.get(paramInt3, paramInt1));
    return true;
    return false;
  }

  private ResultPoint[] a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
  {
    float f1 = paramResultPoint1.getX();
    float f2 = paramResultPoint1.getY();
    float f3 = paramResultPoint2.getX();
    float f4 = paramResultPoint2.getY();
    float f5 = paramResultPoint3.getX();
    float f6 = paramResultPoint3.getY();
    float f7 = paramResultPoint4.getX();
    float f8 = paramResultPoint4.getY();
    if (f1 < this.e / 2)
    {
      ResultPoint[] arrayOfResultPoint2 = new ResultPoint[4];
      arrayOfResultPoint2[0] = new ResultPoint(f7 - 1.0F, f8 + 1.0F);
      arrayOfResultPoint2[1] = new ResultPoint(f3 + 1.0F, f4 + 1.0F);
      arrayOfResultPoint2[2] = new ResultPoint(f5 - 1.0F, f6 - 1.0F);
      arrayOfResultPoint2[3] = new ResultPoint(f1 + 1.0F, f2 - 1.0F);
      return arrayOfResultPoint2;
    }
    ResultPoint[] arrayOfResultPoint1 = new ResultPoint[4];
    arrayOfResultPoint1[0] = new ResultPoint(f7 + 1.0F, f8 + 1.0F);
    arrayOfResultPoint1[1] = new ResultPoint(f3 + 1.0F, f4 - 1.0F);
    arrayOfResultPoint1[2] = new ResultPoint(f5 - 1.0F, f6 + 1.0F);
    arrayOfResultPoint1[3] = new ResultPoint(f1 - 1.0F, f2 - 1.0F);
    return arrayOfResultPoint1;
  }

  private static int b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    float f1 = paramFloat1 - paramFloat3;
    float f2 = paramFloat2 - paramFloat4;
    return (int)(0.5F + (float)Math.sqrt(f1 * f1 + f2 * f2));
  }

  public final ResultPoint[] detect()
  {
    int j = this.f;
    int k = this.g;
    int m = this.i;
    int n = this.h;
    int i1 = 1;
    int i2 = 0;
    int i8;
    int i3;
    int i5;
    int i6;
    int i7;
    if (i1 != 0)
    {
      i1 = 0;
      boolean bool1 = true;
      while ((bool1) && (k < this.e))
      {
        bool1 = a(m, n, k, false);
        if (bool1)
        {
          k++;
          i1 = 1;
        }
      }
      if (k >= this.e)
      {
        i8 = 1;
        i3 = k;
        int i17 = m;
        i5 = j;
        i6 = n;
        i7 = i17;
      }
    }
    while (true)
    {
      label104: if ((i8 == 0) && (i2 != 0))
      {
        int i9 = i3 - i5;
        ResultPoint localResultPoint1 = null;
        int i10 = 1;
        while (true)
          if (i10 < i9)
          {
            localResultPoint1 = a(i5, i6 - i10, i5 + i10, i6);
            if (localResultPoint1 == null)
            {
              i10++;
              continue;
              boolean bool2 = true;
              while ((bool2) && (n < this.d))
              {
                bool2 = a(j, k, n, true);
                if (bool2)
                {
                  n++;
                  i1 = 1;
                }
              }
              if (n >= this.d)
              {
                i8 = 1;
                i3 = k;
                int i16 = m;
                i5 = j;
                i6 = n;
                i7 = i16;
                break label104;
              }
              boolean bool3 = true;
              while ((bool3) && (j >= 0))
              {
                bool3 = a(m, n, j, false);
                if (bool3)
                {
                  j--;
                  i1 = 1;
                }
              }
              if (j < 0)
              {
                i8 = 1;
                i3 = k;
                int i15 = m;
                i5 = j;
                i6 = n;
                i7 = i15;
                break label104;
              }
              boolean bool4 = true;
              while ((bool4) && (m >= 0))
              {
                bool4 = a(j, k, m, true);
                if (bool4)
                {
                  m--;
                  i1 = 1;
                }
              }
              if (m < 0)
              {
                i8 = 1;
                i3 = k;
                int i14 = m;
                i5 = j;
                i6 = n;
                i7 = i14;
                break label104;
              }
              if (i1 == 0)
                break;
              i2 = 1;
              break;
            }
          }
        ResultPoint localResultPoint2 = localResultPoint1;
        if (localResultPoint2 == null)
          throw NotFoundException.getNotFoundInstance();
        ResultPoint localResultPoint3 = null;
        for (int i11 = 1; i11 < i9; i11++)
        {
          localResultPoint3 = a(i5, i7 + i11, i5 + i11, i7);
          if (localResultPoint3 != null)
            break;
        }
        ResultPoint localResultPoint4 = localResultPoint3;
        if (localResultPoint4 == null)
          throw NotFoundException.getNotFoundInstance();
        ResultPoint localResultPoint5 = null;
        for (int i12 = 1; i12 < i9; i12++)
        {
          localResultPoint5 = a(i3, i7 + i12, i3 - i12, i7);
          if (localResultPoint5 != null)
            break;
        }
        ResultPoint localResultPoint6 = localResultPoint5;
        if (localResultPoint6 == null)
          throw NotFoundException.getNotFoundInstance();
        ResultPoint localResultPoint7 = null;
        for (int i13 = 1; i13 < i9; i13++)
        {
          localResultPoint7 = a(i3, i6 - i13, i3 - i13, i6);
          if (localResultPoint7 != null)
            break;
        }
        if (localResultPoint7 == null)
          throw NotFoundException.getNotFoundInstance();
        float f1 = localResultPoint7.getX();
        float f2 = localResultPoint7.getY();
        float f3 = localResultPoint2.getX();
        float f4 = localResultPoint2.getY();
        float f5 = localResultPoint6.getX();
        float f6 = localResultPoint6.getY();
        float f7 = localResultPoint4.getX();
        float f8 = localResultPoint4.getY();
        if (f1 < this.e / 2)
        {
          ResultPoint[] arrayOfResultPoint2 = new ResultPoint[4];
          arrayOfResultPoint2[0] = new ResultPoint(f7 - 1.0F, f8 + 1.0F);
          arrayOfResultPoint2[1] = new ResultPoint(f3 + 1.0F, f4 + 1.0F);
          arrayOfResultPoint2[2] = new ResultPoint(f5 - 1.0F, f6 - 1.0F);
          arrayOfResultPoint2[3] = new ResultPoint(f1 + 1.0F, f2 - 1.0F);
          return arrayOfResultPoint2;
        }
        ResultPoint[] arrayOfResultPoint1 = new ResultPoint[4];
        arrayOfResultPoint1[0] = new ResultPoint(f7 + 1.0F, f8 + 1.0F);
        arrayOfResultPoint1[1] = new ResultPoint(f3 + 1.0F, f4 - 1.0F);
        arrayOfResultPoint1[2] = new ResultPoint(f5 - 1.0F, f6 + 1.0F);
        arrayOfResultPoint1[3] = new ResultPoint(f1 - 1.0F, f2 - 1.0F);
        return arrayOfResultPoint1;
      }
      throw NotFoundException.getNotFoundInstance();
      i3 = k;
      int i4 = m;
      i5 = j;
      i6 = n;
      i7 = i4;
      i8 = 0;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.detector.WhiteRectangleDetector
 * JD-Core Version:    0.6.2
 */