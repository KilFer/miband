package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

public final class MonochromeRectangleDetector
{
  private static final int a = 32;
  private final BitMatrix b;

  public MonochromeRectangleDetector(BitMatrix paramBitMatrix)
  {
    this.b = paramBitMatrix;
  }

  private ResultPoint a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
  {
    int i = paramInt1;
    int j = paramInt5;
    Object localObject = null;
    while ((j < paramInt8) && (j >= paramInt7) && (i < paramInt4) && (i >= paramInt3))
    {
      int[] arrayOfInt;
      if (paramInt2 == 0)
        arrayOfInt = a(j, paramInt9, paramInt3, paramInt4, true);
      while (arrayOfInt == null)
        if (localObject == null)
        {
          throw NotFoundException.getNotFoundInstance();
          arrayOfInt = a(i, paramInt9, paramInt7, paramInt8, false);
        }
        else
        {
          if (paramInt2 == 0)
          {
            int n = j - paramInt6;
            if (localObject[0] < paramInt1)
            {
              if (localObject[1] > paramInt1)
              {
                if (paramInt6 > 0);
                for (float f3 = localObject[0]; ; f3 = localObject[1])
                  return new ResultPoint(f3, n);
              }
              return new ResultPoint(localObject[0], n);
            }
            return new ResultPoint(localObject[1], n);
          }
          int m = i - paramInt2;
          if (localObject[0] < paramInt5)
          {
            if (localObject[1] > paramInt5)
            {
              float f1 = m;
              if (paramInt2 < 0);
              for (float f2 = localObject[0]; ; f2 = localObject[1])
                return new ResultPoint(f1, f2);
            }
            return new ResultPoint(m, localObject[0]);
          }
          return new ResultPoint(m, localObject[1]);
        }
      int k = j + paramInt6;
      i += paramInt2;
      localObject = arrayOfInt;
      j = k;
    }
    throw NotFoundException.getNotFoundInstance();
  }

  private int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int i = paramInt3 + paramInt4 >> 1;
    int j = i;
    int i3;
    label59: label86: int k;
    int m;
    if (j >= paramInt3)
    {
      if (paramBoolean)
      {
        if (!this.b.get(j, paramInt1));
      }
      else
        while (this.b.get(paramInt1, j))
        {
          j--;
          break;
        }
      i3 = j;
      do
      {
        i3--;
        if (i3 < paramInt3)
          break;
        if (!paramBoolean)
          break label146;
      }
      while (!this.b.get(i3, paramInt1));
      int i4 = j - i3;
      if ((i3 >= paramInt3) && (i4 <= paramInt2));
    }
    else
    {
      k = j + 1;
      m = i;
    }
    while (true)
    {
      label115: int i1;
      if (m < paramInt4)
      {
        if (paramBoolean)
        {
          if (!this.b.get(m, paramInt1));
        }
        else
          label146: 
          while (this.b.get(paramInt1, m))
          {
            m++;
            break label115;
            if (!this.b.get(paramInt1, i3))
              break label59;
            break label86;
            j = i3;
            break;
          }
        i1 = m;
        do
        {
          i1++;
          if (i1 >= paramInt4)
            break;
          if (!paramBoolean)
            break label261;
        }
        while (!this.b.get(i1, paramInt1));
      }
      while (true)
      {
        int i2 = i1 - m;
        if ((i1 < paramInt4) && (i2 <= paramInt2))
          break label277;
        int n = m - 1;
        if (n <= k)
          break label284;
        return new int[] { k, n };
        label261: if (!this.b.get(paramInt1, i1))
          break;
      }
      label277: m = i1;
    }
    label284: return null;
  }

  public final ResultPoint[] detect()
  {
    int i = this.b.getHeight();
    int j = this.b.getWidth();
    int k = i >> 1;
    int m = j >> 1;
    int n = Math.max(1, i / 256);
    int i1 = Math.max(1, j / 256);
    int i2 = -1 + (int)a(m, 0, 0, j, k, -n, 0, i, m >> 1).getY();
    ResultPoint localResultPoint1 = a(m, -i1, 0, j, k, 0, i2, i, k >> 1);
    int i3 = -1 + (int)localResultPoint1.getX();
    ResultPoint localResultPoint2 = a(m, i1, i3, j, k, 0, i2, i, k >> 1);
    int i4 = 1 + (int)localResultPoint2.getX();
    ResultPoint localResultPoint3 = a(m, 0, i3, i4, k, n, i2, i, m >> 1);
    int i5 = 1 + (int)localResultPoint3.getY();
    return new ResultPoint[] { a(m, 0, i3, i4, k, -n, i2, i5, m >> 2), localResultPoint1, localResultPoint2, localResultPoint3 };
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.detector.MonochromeRectangleDetector
 * JD-Core Version:    0.6.2
 */