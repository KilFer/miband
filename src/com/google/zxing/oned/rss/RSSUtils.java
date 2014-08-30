package com.google.zxing.oned.rss;

public final class RSSUtils
{
  private static int a(int paramInt1, int paramInt2)
  {
    int i = 1;
    int k;
    if (paramInt1 - paramInt2 > paramInt2)
      k = paramInt1 - paramInt2;
    int m;
    while (true)
    {
      m = i;
      while (paramInt1 > k)
      {
        m *= paramInt1;
        if (i <= paramInt2)
        {
          m /= i;
          i++;
        }
        paramInt1--;
      }
      int j = paramInt1 - paramInt2;
      k = paramInt2;
      paramInt2 = j;
    }
    while (true)
    {
      int n;
      if (i <= paramInt2)
      {
        n /= i;
        i++;
      }
      else
      {
        return n;
        n = m;
      }
    }
  }

  private static int[] a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    int[] arrayOfInt = new int[paramInt3];
    int i = 0;
    int j = 0;
    int k = paramInt1;
    while (j < paramInt3 - 1)
    {
      i |= 1 << j;
      int m = 1;
      int n = a(-1 + (paramInt2 - m), -2 + (paramInt3 - j));
      if ((paramBoolean) && (i == 0) && (paramInt2 - m - (-1 + (paramInt3 - j)) >= -1 + (paramInt3 - j)))
        n -= a(paramInt2 - m - (paramInt3 - j), -2 + (paramInt3 - j));
      if (-1 + (paramInt3 - j) > 1)
      {
        int i1 = 0;
        for (int i2 = paramInt2 - m - (-2 + (paramInt3 - j)); i2 > paramInt4; i2--)
          i1 += a(-1 + (paramInt2 - m - i2), -3 + (paramInt3 - j));
        n -= i1 * (paramInt3 - 1 - j);
      }
      while (true)
      {
        k -= n;
        if (k < 0)
          break label226;
        m++;
        i &= (0xFFFFFFFF ^ 1 << j);
        break;
        if (paramInt2 - m > paramInt4)
          n--;
      }
      label226: k += n;
      paramInt2 -= m;
      arrayOfInt[j] = m;
      j++;
    }
    arrayOfInt[j] = paramInt2;
    return arrayOfInt;
  }

  private static int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[2 + paramArrayOfInt.length];
    int i = paramInt2 << 1;
    arrayOfInt[0] = 1;
    int j = 10;
    int k = 1;
    for (int m = 1; m < i - 2; m += 2)
    {
      arrayOfInt[m] = (paramArrayOfInt[(m - 1)] - arrayOfInt[(m - 1)]);
      arrayOfInt[(m + 1)] = (paramArrayOfInt[m] - arrayOfInt[m]);
      k += arrayOfInt[m] + arrayOfInt[(m + 1)];
      if (arrayOfInt[m] < j)
        j = arrayOfInt[m];
    }
    arrayOfInt[(i - 1)] = (paramInt1 - k);
    if (arrayOfInt[(i - 1)] < j);
    for (int n = arrayOfInt[(i - 1)]; ; n = j)
    {
      if (n > 1)
        for (int i1 = 0; i1 < i; i1 += 2)
        {
          arrayOfInt[i1] += n - 1;
          int i2 = i1 + 1;
          arrayOfInt[i2] -= n - 1;
        }
      return arrayOfInt;
    }
  }

  public static int getRSSvalue(int[] paramArrayOfInt, int paramInt, boolean paramBoolean)
  {
    int i = paramArrayOfInt.length;
    int j = 0;
    int i11;
    for (int k = 0; j < i; k = i11)
    {
      i11 = k + paramArrayOfInt[j];
      j++;
    }
    int m = 0;
    int n = 0;
    int i1 = k;
    int i2 = 0;
    while (m < i - 1)
    {
      int i3 = i2 | 1 << m;
      int i4 = n;
      int i5 = i3;
      int i6 = 1;
      if (i6 < paramArrayOfInt[m])
      {
        int i8 = a(-1 + (i1 - i6), -2 + (i - m));
        if ((paramBoolean) && (i5 == 0) && (i1 - i6 - (-1 + (i - m)) >= -1 + (i - m)))
          i8 -= a(i1 - i6 - (i - m), -2 + (i - m));
        if (-1 + (i - m) > 1)
        {
          int i9 = i1 - i6 - (-2 + (i - m));
          int i10 = 0;
          while (i9 > paramInt)
          {
            i10 += a(-1 + (i1 - i6 - i9), -3 + (i - m));
            i9--;
          }
          i8 -= i10 * (i - 1 - m);
        }
        while (true)
        {
          i4 += i8;
          i6++;
          i5 &= (0xFFFFFFFF ^ 1 << m);
          break;
          if (i1 - i6 > paramInt)
            i8--;
        }
      }
      int i7 = i1 - i6;
      m++;
      i1 = i7;
      i2 = i5;
      n = i4;
    }
    return n;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.RSSUtils
 * JD-Core Version:    0.6.2
 */