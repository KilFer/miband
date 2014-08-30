package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FinderPatternFinder
{
  protected static final int MAX_MODULES = 57;
  protected static final int MIN_SKIP = 3;
  private static final int a = 2;
  private static final int b = 8;
  private final BitMatrix c;
  private final List<FinderPattern> d;
  private boolean e;
  private final int[] f;
  private final ResultPointCallback g;

  public FinderPatternFinder(BitMatrix paramBitMatrix)
  {
    this(paramBitMatrix, null);
  }

  public FinderPatternFinder(BitMatrix paramBitMatrix, ResultPointCallback paramResultPointCallback)
  {
    this.c = paramBitMatrix;
    this.d = new ArrayList();
    this.f = new int[5];
    this.g = paramResultPointCallback;
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitMatrix localBitMatrix = this.c;
    int i = localBitMatrix.getHeight();
    int[] arrayOfInt = a();
    for (int j = paramInt1; (j >= 0) && (localBitMatrix.get(paramInt2, j)); j--)
      arrayOfInt[2] = (1 + arrayOfInt[2]);
    if (j < 0);
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (0.0F / 0.0F);
              while ((j >= 0) && (!localBitMatrix.get(paramInt2, j)) && (arrayOfInt[1] <= paramInt3))
              {
                arrayOfInt[1] = (1 + arrayOfInt[1]);
                j--;
              }
            }
            while ((j < 0) || (arrayOfInt[1] > paramInt3));
            while ((j >= 0) && (localBitMatrix.get(paramInt2, j)) && (arrayOfInt[0] <= paramInt3))
            {
              arrayOfInt[0] = (1 + arrayOfInt[0]);
              j--;
            }
          }
          while (arrayOfInt[0] > paramInt3);
          for (k = paramInt1 + 1; (k < i) && (localBitMatrix.get(paramInt2, k)); k++)
            arrayOfInt[2] = (1 + arrayOfInt[2]);
        }
        while (k == i);
        while ((k < i) && (!localBitMatrix.get(paramInt2, k)) && (arrayOfInt[3] < paramInt3))
        {
          arrayOfInt[3] = (1 + arrayOfInt[3]);
          k++;
        }
      }
      while ((k == i) || (arrayOfInt[3] >= paramInt3));
      while ((k < i) && (localBitMatrix.get(paramInt2, k)) && (arrayOfInt[4] < paramInt3))
      {
        arrayOfInt[4] = (1 + arrayOfInt[4]);
        k++;
      }
    }
    while ((arrayOfInt[4] >= paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) >= paramInt4 * 2) || (!foundPatternCross(arrayOfInt)));
    return a(arrayOfInt, k);
  }

  private static float a(int[] paramArrayOfInt, int paramInt)
  {
    return paramInt - paramArrayOfInt[4] - paramArrayOfInt[3] - paramArrayOfInt[2] / 2.0F;
  }

  private int[] a()
  {
    this.f[0] = 0;
    this.f[1] = 0;
    this.f[2] = 0;
    this.f[3] = 0;
    this.f[4] = 0;
    return this.f;
  }

  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BitMatrix localBitMatrix = this.c;
    int i = localBitMatrix.getWidth();
    int[] arrayOfInt = a();
    for (int j = paramInt1; (j >= 0) && (localBitMatrix.get(j, paramInt2)); j--)
      arrayOfInt[2] = (1 + arrayOfInt[2]);
    if (j < 0);
    int k;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return (0.0F / 0.0F);
              while ((j >= 0) && (!localBitMatrix.get(j, paramInt2)) && (arrayOfInt[1] <= paramInt3))
              {
                arrayOfInt[1] = (1 + arrayOfInt[1]);
                j--;
              }
            }
            while ((j < 0) || (arrayOfInt[1] > paramInt3));
            while ((j >= 0) && (localBitMatrix.get(j, paramInt2)) && (arrayOfInt[0] <= paramInt3))
            {
              arrayOfInt[0] = (1 + arrayOfInt[0]);
              j--;
            }
          }
          while (arrayOfInt[0] > paramInt3);
          for (k = paramInt1 + 1; (k < i) && (localBitMatrix.get(k, paramInt2)); k++)
            arrayOfInt[2] = (1 + arrayOfInt[2]);
        }
        while (k == i);
        while ((k < i) && (!localBitMatrix.get(k, paramInt2)) && (arrayOfInt[3] < paramInt3))
        {
          arrayOfInt[3] = (1 + arrayOfInt[3]);
          k++;
        }
      }
      while ((k == i) || (arrayOfInt[3] >= paramInt3));
      while ((k < i) && (localBitMatrix.get(k, paramInt2)) && (arrayOfInt[4] < paramInt3))
      {
        arrayOfInt[4] = (1 + arrayOfInt[4]);
        k++;
      }
    }
    while ((arrayOfInt[4] >= paramInt3) || (5 * Math.abs(arrayOfInt[0] + arrayOfInt[1] + arrayOfInt[2] + arrayOfInt[3] + arrayOfInt[4] - paramInt4) >= paramInt4) || (!foundPatternCross(arrayOfInt)));
    return a(arrayOfInt, k);
  }

  private int b()
  {
    if (this.d.size() <= 1)
      return 0;
    Iterator localIterator = this.d.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      FinderPattern localFinderPattern = (FinderPattern)localIterator.next();
      if (localFinderPattern.a() >= 2)
        if (localObject == null)
        {
          localObject = localFinderPattern;
        }
        else
        {
          this.e = true;
          return (int)(Math.abs(localObject.getX() - localFinderPattern.getX()) - Math.abs(localObject.getY() - localFinderPattern.getY())) / 2;
        }
    }
    return 0;
  }

  private boolean c()
  {
    float f1 = 0.0F;
    int i = this.d.size();
    Iterator localIterator1 = this.d.iterator();
    float f2 = 0.0F;
    int j = 0;
    int m;
    float f4;
    if (localIterator1.hasNext())
    {
      FinderPattern localFinderPattern = (FinderPattern)localIterator1.next();
      if (localFinderPattern.a() < 2)
        break label161;
      m = j + 1;
      f4 = f2 + localFinderPattern.getEstimatedModuleSize();
    }
    for (int k = m; ; k = j)
    {
      j = k;
      f2 = f4;
      break;
      if (j < 3);
      do
      {
        return false;
        float f3 = f2 / i;
        Iterator localIterator2 = this.d.iterator();
        while (localIterator2.hasNext())
          f1 += Math.abs(((FinderPattern)localIterator2.next()).getEstimatedModuleSize() - f3);
      }
      while (f1 > 0.05F * f2);
      return true;
      label161: f4 = f2;
    }
  }

  private FinderPattern[] d()
  {
    float f1 = 0.0F;
    int i = this.d.size();
    if (i < 3)
      throw NotFoundException.getNotFoundInstance();
    int j;
    if (i > 3)
    {
      Iterator localIterator2 = this.d.iterator();
      float f3 = 0.0F;
      float f4 = 0.0F;
      while (localIterator2.hasNext())
      {
        float f8 = ((FinderPattern)localIterator2.next()).getEstimatedModuleSize();
        f4 += f8;
        f3 += f8 * f8;
      }
      float f5 = f4 / i;
      float f6 = (float)Math.sqrt(f3 / i - f5 * f5);
      Collections.sort(this.d, new d(f5, (byte)0));
      float f7 = Math.max(0.2F * f5, f6);
      j = 0;
      if ((j < this.d.size()) && (this.d.size() > 3))
      {
        if (Math.abs(((FinderPattern)this.d.get(j)).getEstimatedModuleSize() - f5) <= f7)
          break label391;
        this.d.remove(j);
      }
    }
    label391: for (int k = j - 1; ; k = j)
    {
      j = k + 1;
      break;
      if (this.d.size() > 3)
      {
        Iterator localIterator1 = this.d.iterator();
        while (localIterator1.hasNext())
          f1 += ((FinderPattern)localIterator1.next()).getEstimatedModuleSize();
        float f2 = f1 / this.d.size();
        Collections.sort(this.d, new c(f2, (byte)0));
        this.d.subList(3, this.d.size()).clear();
      }
      FinderPattern[] arrayOfFinderPattern = new FinderPattern[3];
      arrayOfFinderPattern[0] = ((FinderPattern)this.d.get(0));
      arrayOfFinderPattern[1] = ((FinderPattern)this.d.get(1));
      arrayOfFinderPattern[2] = ((FinderPattern)this.d.get(2));
      return arrayOfFinderPattern;
    }
  }

  protected static boolean foundPatternCross(int[] paramArrayOfInt)
  {
    int i = 0;
    int j = 0;
    int n;
    if (i < 5)
    {
      n = paramArrayOfInt[i];
      if (n != 0);
    }
    int k;
    int m;
    do
    {
      do
      {
        return false;
        j += n;
        i++;
        break;
      }
      while (j < 7);
      k = (j << 8) / 7;
      m = k / 2;
    }
    while ((Math.abs(k - (paramArrayOfInt[0] << 8)) >= m) || (Math.abs(k - (paramArrayOfInt[1] << 8)) >= m) || (Math.abs(k * 3 - (paramArrayOfInt[2] << 8)) >= m * 3) || (Math.abs(k - (paramArrayOfInt[3] << 8)) >= m) || (Math.abs(k - (paramArrayOfInt[4] << 8)) >= m));
    return true;
  }

  final FinderPatternInfo b(Map<DecodeHintType, ?> paramMap)
  {
    int i;
    int j;
    int k;
    int m;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
    {
      i = 1;
      j = this.c.getHeight();
      k = this.c.getWidth();
      m = j * 3 / 228;
      if ((m >= 3) && (i == 0))
        break label1015;
    }
    label117: label1015: for (int n = 3; ; n = m)
    {
      boolean bool1 = false;
      int[] arrayOfInt = new int[5];
      int i1 = n - 1;
      int i2 = n;
      int i6;
      int i7;
      boolean bool2;
      int i8;
      int i10;
      int i9;
      if ((i1 < j) && (!bool1))
      {
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        arrayOfInt[2] = 0;
        arrayOfInt[3] = 0;
        arrayOfInt[4] = 0;
        i6 = 0;
        i7 = 0;
        if (i7 < k)
        {
          if (this.c.get(i7, i1))
          {
            if ((i6 & 0x1) == 1)
              i6++;
            arrayOfInt[i6] = (1 + arrayOfInt[i6]);
          }
          while (true)
          {
            i7++;
            break label117;
            i = 0;
            break;
            if ((i6 & 0x1) != 0)
              break label515;
            if (i6 != 4)
              break label497;
            if (!foundPatternCross(arrayOfInt))
              break label457;
            if (!handlePossibleCenter(arrayOfInt, i1, i7))
              break label417;
            if (!this.e)
              break label257;
            bool2 = c();
            arrayOfInt[0] = 0;
            arrayOfInt[1] = 0;
            arrayOfInt[2] = 0;
            arrayOfInt[3] = 0;
            arrayOfInt[4] = 0;
            bool1 = bool2;
            i2 = 2;
            i6 = 0;
          }
          if (this.d.size() > 1)
          {
            Iterator localIterator3 = this.d.iterator();
            Object localObject = null;
            while (localIterator3.hasNext())
            {
              FinderPattern localFinderPattern = (FinderPattern)localIterator3.next();
              if (localFinderPattern.a() >= 2)
                if (localObject == null)
                {
                  localObject = localFinderPattern;
                }
                else
                {
                  this.e = true;
                  i8 = (int)(Math.abs(localObject.getX() - localFinderPattern.getX()) - Math.abs(localObject.getY() - localFinderPattern.getY())) / 2;
                  if (i8 <= arrayOfInt[2])
                    break label1004;
                  i10 = i1 + (-2 + (i8 - arrayOfInt[2]));
                  i9 = k - 1;
                }
            }
          }
        }
      }
      while (true)
      {
        i7 = i9;
        i1 = i10;
        bool2 = bool1;
        break label219;
        i8 = 0;
        break label366;
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = arrayOfInt[3];
        arrayOfInt[2] = arrayOfInt[4];
        arrayOfInt[3] = 1;
        arrayOfInt[4] = 0;
        i6 = 3;
        break label161;
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = arrayOfInt[3];
        arrayOfInt[2] = arrayOfInt[4];
        arrayOfInt[3] = 1;
        arrayOfInt[4] = 0;
        i6 = 3;
        break label161;
        i6++;
        arrayOfInt[i6] = (1 + arrayOfInt[i6]);
        break label161;
        arrayOfInt[i6] = (1 + arrayOfInt[i6]);
        break label161;
        if ((foundPatternCross(arrayOfInt)) && (handlePossibleCenter(arrayOfInt, i1, k)))
        {
          i2 = arrayOfInt[0];
          if (this.e)
            bool1 = c();
        }
        i1 += i2;
        break;
        int i3 = this.d.size();
        if (i3 < 3)
          throw NotFoundException.getNotFoundInstance();
        int i4;
        if (i3 > 3)
        {
          Iterator localIterator2 = this.d.iterator();
          float f3 = 0.0F;
          float f8;
          for (float f4 = 0.0F; localIterator2.hasNext(); f4 += f8 * f8)
          {
            f8 = ((FinderPattern)localIterator2.next()).getEstimatedModuleSize();
            f3 += f8;
          }
          float f5 = f3 / i3;
          float f6 = (float)Math.sqrt(f4 / i3 - f5 * f5);
          Collections.sort(this.d, new d(f5, (byte)0));
          float f7 = Math.max(0.2F * f5, f6);
          i4 = 0;
          if ((i4 < this.d.size()) && (this.d.size() > 3))
          {
            if (Math.abs(((FinderPattern)this.d.get(i4)).getEstimatedModuleSize() - f5) <= f7)
              break label997;
            this.d.remove(i4);
          }
        }
        for (int i5 = i4 - 1; ; i5 = i4)
        {
          i4 = i5 + 1;
          break;
          if (this.d.size() > 3)
          {
            Iterator localIterator1 = this.d.iterator();
            for (float f1 = 0.0F; localIterator1.hasNext(); f1 += ((FinderPattern)localIterator1.next()).getEstimatedModuleSize());
            float f2 = f1 / this.d.size();
            Collections.sort(this.d, new c(f2, (byte)0));
            this.d.subList(3, this.d.size()).clear();
          }
          FinderPattern[] arrayOfFinderPattern = new FinderPattern[3];
          arrayOfFinderPattern[0] = ((FinderPattern)this.d.get(0));
          arrayOfFinderPattern[1] = ((FinderPattern)this.d.get(1));
          arrayOfFinderPattern[2] = ((FinderPattern)this.d.get(2));
          ResultPoint.orderBestPatterns(arrayOfFinderPattern);
          return new FinderPatternInfo(arrayOfFinderPattern);
        }
        i9 = i7;
        i10 = i1;
      }
    }
  }

  protected BitMatrix getImage()
  {
    return this.c;
  }

  protected List<FinderPattern> getPossibleCenters()
  {
    return this.d;
  }

  protected boolean handlePossibleCenter(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfInt[0] + paramArrayOfInt[1] + paramArrayOfInt[2] + paramArrayOfInt[3] + paramArrayOfInt[4];
    float f1 = a(paramArrayOfInt, paramInt2);
    int j = (int)f1;
    int k = paramArrayOfInt[2];
    BitMatrix localBitMatrix1 = this.c;
    int m = localBitMatrix1.getHeight();
    int[] arrayOfInt1 = a();
    for (int n = paramInt1; (n >= 0) && (localBitMatrix1.get(j, n)); n--)
      arrayOfInt1[2] = (1 + arrayOfInt1[2]);
    float f2;
    if (n < 0)
      f2 = (0.0F / 0.0F);
    int i1;
    int i2;
    int i3;
    BitMatrix localBitMatrix2;
    int i4;
    int[] arrayOfInt2;
    int i5;
    float f3;
    float f4;
    int i6;
    while (true)
      if (!Float.isNaN(f2))
      {
        i1 = (int)f1;
        i2 = (int)f2;
        i3 = paramArrayOfInt[2];
        localBitMatrix2 = this.c;
        i4 = localBitMatrix2.getWidth();
        arrayOfInt2 = a();
        i5 = i1;
        while (true)
          if ((i5 >= 0) && (localBitMatrix2.get(i5, i2)))
          {
            arrayOfInt2[2] = (1 + arrayOfInt2[2]);
            i5--;
            continue;
            while ((n >= 0) && (!localBitMatrix1.get(j, n)) && (arrayOfInt1[1] <= k))
            {
              arrayOfInt1[1] = (1 + arrayOfInt1[1]);
              n--;
            }
            if ((n < 0) || (arrayOfInt1[1] > k))
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            while ((n >= 0) && (localBitMatrix1.get(j, n)) && (arrayOfInt1[0] <= k))
            {
              arrayOfInt1[0] = (1 + arrayOfInt1[0]);
              n--;
            }
            if (arrayOfInt1[0] > k)
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            for (int i9 = paramInt1 + 1; (i9 < m) && (localBitMatrix1.get(j, i9)); i9++)
              arrayOfInt1[2] = (1 + arrayOfInt1[2]);
            if (i9 == m)
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            while ((i9 < m) && (!localBitMatrix1.get(j, i9)) && (arrayOfInt1[3] < k))
            {
              arrayOfInt1[3] = (1 + arrayOfInt1[3]);
              i9++;
            }
            if ((i9 == m) || (arrayOfInt1[3] >= k))
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            while ((i9 < m) && (localBitMatrix1.get(j, i9)) && (arrayOfInt1[4] < k))
            {
              arrayOfInt1[4] = (1 + arrayOfInt1[4]);
              i9++;
            }
            if (arrayOfInt1[4] >= k)
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            if (5 * Math.abs(arrayOfInt1[0] + arrayOfInt1[1] + arrayOfInt1[2] + arrayOfInt1[3] + arrayOfInt1[4] - i) >= i * 2)
            {
              f2 = (0.0F / 0.0F);
              break;
            }
            if (foundPatternCross(arrayOfInt1))
            {
              f2 = a(arrayOfInt1, i9);
              break;
            }
            f2 = (0.0F / 0.0F);
            break;
          }
        if (i5 < 0)
        {
          f3 = (0.0F / 0.0F);
          if (Float.isNaN(f3))
            break label1086;
          f4 = i / 7.0F;
          i6 = 0;
          label584: if (i6 >= this.d.size())
            break label1088;
          FinderPattern localFinderPattern2 = (FinderPattern)this.d.get(i6);
          if (!localFinderPattern2.a(f4, f2, f3))
            break label1080;
          this.d.set(i6, localFinderPattern2.b(f2, f3, f4));
        }
      }
    label1080: label1086: label1088: for (int i7 = 1; ; i7 = 0)
    {
      if (i7 == 0)
      {
        FinderPattern localFinderPattern1 = new FinderPattern(f3, f2, f4);
        this.d.add(localFinderPattern1);
        if (this.g != null)
          this.g.foundPossibleResultPoint(localFinderPattern1);
      }
      return true;
      while ((i5 >= 0) && (!localBitMatrix2.get(i5, i2)) && (arrayOfInt2[1] <= i3))
      {
        arrayOfInt2[1] = (1 + arrayOfInt2[1]);
        i5--;
      }
      if ((i5 < 0) || (arrayOfInt2[1] > i3))
      {
        f3 = (0.0F / 0.0F);
        break;
      }
      while ((i5 >= 0) && (localBitMatrix2.get(i5, i2)) && (arrayOfInt2[0] <= i3))
      {
        arrayOfInt2[0] = (1 + arrayOfInt2[0]);
        i5--;
      }
      if (arrayOfInt2[0] > i3)
      {
        f3 = (0.0F / 0.0F);
        break;
      }
      for (int i8 = i1 + 1; (i8 < i4) && (localBitMatrix2.get(i8, i2)); i8++)
        arrayOfInt2[2] = (1 + arrayOfInt2[2]);
      if (i8 == i4)
      {
        f3 = (0.0F / 0.0F);
        break;
      }
      while ((i8 < i4) && (!localBitMatrix2.get(i8, i2)) && (arrayOfInt2[3] < i3))
      {
        arrayOfInt2[3] = (1 + arrayOfInt2[3]);
        i8++;
      }
      if ((i8 == i4) || (arrayOfInt2[3] >= i3))
      {
        f3 = (0.0F / 0.0F);
        break;
      }
      while ((i8 < i4) && (localBitMatrix2.get(i8, i2)) && (arrayOfInt2[4] < i3))
      {
        arrayOfInt2[4] = (1 + arrayOfInt2[4]);
        i8++;
      }
      if (arrayOfInt2[4] >= i3)
      {
        f3 = (0.0F / 0.0F);
        break;
      }
      if (5 * Math.abs(arrayOfInt2[0] + arrayOfInt2[1] + arrayOfInt2[2] + arrayOfInt2[3] + arrayOfInt2[4] - i) >= i)
      {
        f3 = (0.0F / 0.0F);
        break;
      }
      if (foundPatternCross(arrayOfInt2))
      {
        f3 = a(arrayOfInt2, i8);
        break;
      }
      f3 = (0.0F / 0.0F);
      break;
      i6++;
      break label584;
      return false;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.FinderPatternFinder
 * JD-Core Version:    0.6.2
 */