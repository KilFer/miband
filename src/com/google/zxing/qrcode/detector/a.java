package com.google.zxing.qrcode.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class a
{
  private final BitMatrix a;
  private final List<AlignmentPattern> b;
  private final int c;
  private final int d;
  private final int e;
  private final int f;
  private final float g;
  private final int[] h;
  private final ResultPointCallback i;

  a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, ResultPointCallback paramResultPointCallback)
  {
    this.a = paramBitMatrix;
    this.b = new ArrayList(5);
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramInt3;
    this.f = paramInt4;
    this.g = paramFloat;
    this.h = new int[3];
    this.i = paramResultPointCallback;
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitMatrix localBitMatrix = this.a;
    int j = localBitMatrix.getHeight();
    int[] arrayOfInt = this.h;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    for (int k = paramInt1; (k >= 0) && (localBitMatrix.get(paramInt2, k)) && (arrayOfInt[1] <= paramInt3); k--)
      arrayOfInt[1] = (1 + arrayOfInt[1]);
    if ((k < 0) || (arrayOfInt[1] > paramInt3));
    int m;
    do
    {
      do
      {
        do
        {
          return (0.0F / 0.0F);
          while ((k >= 0) && (!localBitMatrix.get(paramInt2, k)) && (arrayOfInt[0] <= paramInt3))
          {
            arrayOfInt[0] = (1 + arrayOfInt[0]);
            k--;
          }
        }
        while (arrayOfInt[0] > paramInt3);
        for (m = paramInt1 + 1; (m < j) && (localBitMatrix.get(paramInt2, m)) && (arrayOfInt[1] <= paramInt3); m++)
          arrayOfInt[1] = (1 + arrayOfInt[1]);
      }
      while ((m == j) || (arrayOfInt[1] > paramInt3));
      while ((m < j) && (!localBitMatrix.get(paramInt2, m)) && (arrayOfInt[2] <= paramInt3))
      {
        arrayOfInt[2] = (1 + arrayOfInt[2]);
        m++;
      }
    }
    while ((arrayOfInt[2] > paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] - paramInt4) >= paramInt4 * 2) || (!a(arrayOfInt)));
    return a(arrayOfInt, m);
  }

  private static float a(int[] paramArrayOfInt, int paramInt)
  {
    return paramInt - paramArrayOfInt[2] - paramArrayOfInt[1] / 2.0F;
  }

  private AlignmentPattern a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int j = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2];
    float f1 = a(paramArrayOfInt, paramInt2);
    int k = (int)f1;
    int m = 2 * paramArrayOfInt[1];
    BitMatrix localBitMatrix = this.a;
    int n = localBitMatrix.getHeight();
    int[] arrayOfInt = this.h;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    for (int i1 = paramInt1; (i1 >= 0) && (localBitMatrix.get(k, i1)) && (arrayOfInt[1] <= m); i1--)
      arrayOfInt[1] = (1 + arrayOfInt[1]);
    float f2;
    if ((i1 < 0) || (arrayOfInt[1] > m))
      f2 = (0.0F / 0.0F);
    while (!Float.isNaN(f2))
    {
      float f3 = (paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2]) / 3.0F;
      Iterator localIterator = this.b.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          AlignmentPattern localAlignmentPattern2 = (AlignmentPattern)localIterator.next();
          if (localAlignmentPattern2.a(f3, f2, f1))
          {
            return localAlignmentPattern2.b(f2, f1, f3);
            while ((i1 >= 0) && (!localBitMatrix.get(k, i1)) && (arrayOfInt[0] <= m))
            {
              arrayOfInt[0] = (1 + arrayOfInt[0]);
              i1--;
            }
            if (arrayOfInt[0] > m)
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            for (int i2 = paramInt1 + 1; (i2 < n) && (localBitMatrix.get(k, i2)) && (arrayOfInt[1] <= m); i2++)
              arrayOfInt[1] = (1 + arrayOfInt[1]);
            if ((i2 == n) || (arrayOfInt[1] > m))
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            while ((i2 < n) && (!localBitMatrix.get(k, i2)) && (arrayOfInt[2] <= m))
            {
              arrayOfInt[2] = (1 + arrayOfInt[2]);
              i2++;
            }
            if (arrayOfInt[2] > m)
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            if (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] - j) >= j * 2)
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            if (a(arrayOfInt))
            {
              f2 = a(arrayOfInt, i2);
              break;
            }
            f2 = (0.0F / 0.0F);
            break;
          }
        }
      AlignmentPattern localAlignmentPattern1 = new AlignmentPattern(f1, f2, f3);
      this.b.add(localAlignmentPattern1);
      if (this.i != null)
        this.i.foundPossibleResultPoint(localAlignmentPattern1);
    }
    return null;
  }

  private boolean a(int[] paramArrayOfInt)
  {
    float f1 = this.g;
    float f2 = f1 / 2.0F;
    for (int j = 0; j < 3; j++)
      if (Math.abs(f1 - paramArrayOfInt[j]) >= f2)
        return false;
    return true;
  }

  final AlignmentPattern a()
  {
    int j = this.c;
    int k = this.f;
    int m = j + this.e;
    int n = this.d + (k >> 1);
    int[] arrayOfInt = new int[3];
    label281: for (int i1 = 0; i1 < k; i1++)
    {
      if ((i1 & 0x1) == 0);
      int i3;
      int i4;
      for (int i2 = i1 + 1 >> 1; ; i2 = -(i1 + 1 >> 1))
      {
        i3 = n + i2;
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        arrayOfInt[2] = 0;
        for (i4 = j; (i4 < m) && (!this.a.get(i4, i3)); i4++);
      }
      int i5 = i4;
      int i6 = 0;
      AlignmentPattern localAlignmentPattern;
      if (i5 < m)
        if (this.a.get(i5, i3))
        {
          if (i6 == 1)
            break label241;
          if (i6 == 2)
            if (a(arrayOfInt))
            {
              localAlignmentPattern = a(arrayOfInt, i3, i5);
              if (localAlignmentPattern == null);
            }
        }
      label241: 
      do
      {
        return localAlignmentPattern;
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = 1;
        arrayOfInt[2] = 0;
        i6 = 1;
        while (true)
        {
          i5++;
          break;
          i6++;
          arrayOfInt[i6] = (1 + arrayOfInt[i6]);
          continue;
          if (i6 == 1)
            i6++;
          arrayOfInt[i6] = (1 + arrayOfInt[i6]);
        }
        if (!a(arrayOfInt))
          break label281;
        localAlignmentPattern = a(arrayOfInt, i3, m);
      }
      while (localAlignmentPattern != null);
    }
    if (!this.b.isEmpty())
      return (AlignmentPattern)this.b.get(0);
    throw NotFoundException.getNotFoundInstance();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.a
 * JD-Core Version:    0.6.2
 */