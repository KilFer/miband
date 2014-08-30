package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.oned.OneDReader;

public abstract class AbstractRSSReader extends OneDReader
{
  private static final int a = 51;
  private static final int b = 102;
  private static final float c = 0.7916667F;
  private static final float d = 0.8928571F;
  private final int[] e = new int[4];
  private final int[] f = new int[8];
  private final float[] g = new float[4];
  private final float[] h = new float[4];
  private final int[] i = new int[this.f.length / 2];
  private final int[] j = new int[this.f.length / 2];

  protected static int count(int[] paramArrayOfInt)
  {
    int k = 0;
    int m = paramArrayOfInt.length;
    int n = 0;
    while (k < m)
    {
      n += paramArrayOfInt[k];
      k++;
    }
    return n;
  }

  protected static void decrement(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int k = 0;
    float f1 = paramArrayOfFloat[0];
    for (int m = 1; m < paramArrayOfInt.length; m++)
      if (paramArrayOfFloat[m] < f1)
      {
        f1 = paramArrayOfFloat[m];
        k = m;
      }
    paramArrayOfInt[k] = (-1 + paramArrayOfInt[k]);
  }

  protected static void increment(int[] paramArrayOfInt, float[] paramArrayOfFloat)
  {
    int k = 0;
    float f1 = paramArrayOfFloat[0];
    for (int m = 1; m < paramArrayOfInt.length; m++)
      if (paramArrayOfFloat[m] > f1)
      {
        f1 = paramArrayOfFloat[m];
        k = m;
      }
    paramArrayOfInt[k] = (1 + paramArrayOfInt[k]);
  }

  protected static boolean isFinderPattern(int[] paramArrayOfInt)
  {
    int k = paramArrayOfInt[0] + paramArrayOfInt[1];
    int m = k + paramArrayOfInt[2] + paramArrayOfInt[3];
    float f1 = k / m;
    int n;
    int i1;
    int i3;
    int i4;
    if ((f1 >= 0.7916667F) && (f1 <= 0.8928571F))
    {
      n = 2147483647;
      i1 = -2147483648;
      int i2 = paramArrayOfInt.length;
      i3 = 0;
      if (i3 < i2)
      {
        i4 = paramArrayOfInt[i3];
        if (i4 > i1)
          i1 = i4;
        if (i4 >= n)
          break label110;
      }
    }
    while (true)
    {
      i3++;
      n = i4;
      break;
      return i1 < n * 10;
      return false;
      label110: i4 = n;
    }
  }

  protected static int parseFinderValue(int[] paramArrayOfInt, int[][] paramArrayOfInt1)
  {
    for (int k = 0; k < paramArrayOfInt1.length; k++)
      if (patternMatchVariance(paramArrayOfInt, paramArrayOfInt1[k], 102) < 51)
        return k;
    throw NotFoundException.getNotFoundInstance();
  }

  protected int[] getDataCharacterCounters()
  {
    return this.f;
  }

  protected int[] getDecodeFinderCounters()
  {
    return this.e;
  }

  protected int[] getEvenCounts()
  {
    return this.j;
  }

  protected float[] getEvenRoundingErrors()
  {
    return this.h;
  }

  protected int[] getOddCounts()
  {
    return this.i;
  }

  protected float[] getOddRoundingErrors()
  {
    return this.g;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.AbstractRSSReader
 * JD-Core Version:    0.6.2
 */