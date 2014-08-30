package com.google.zxing.datamatrix.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class Detector
{
  private final BitMatrix a;
  private final WhiteRectangleDetector b;

  public Detector(BitMatrix paramBitMatrix)
  {
    this.a = paramBitMatrix;
    this.b = new WhiteRectangleDetector(paramBitMatrix);
  }

  private static int a(float paramFloat)
  {
    return (int)(0.5F + paramFloat);
  }

  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    return (int)(0.5F + (float)Math.sqrt((paramResultPoint1.getX() - paramResultPoint2.getX()) * (paramResultPoint1.getX() - paramResultPoint2.getX()) + (paramResultPoint1.getY() - paramResultPoint2.getY()) * (paramResultPoint1.getY() - paramResultPoint2.getY())));
  }

  private ResultPoint a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt)
  {
    float f1 = a(paramResultPoint1, paramResultPoint2) / paramInt;
    int i = a(paramResultPoint3, paramResultPoint4);
    float f2 = (paramResultPoint4.getX() - paramResultPoint3.getX()) / i;
    float f3 = (paramResultPoint4.getY() - paramResultPoint3.getY()) / i;
    ResultPoint localResultPoint1 = new ResultPoint(paramResultPoint4.getX() + f2 * f1, paramResultPoint4.getY() + f1 * f3);
    float f4 = a(paramResultPoint1, paramResultPoint2) / paramInt;
    int j = a(paramResultPoint2, paramResultPoint4);
    float f5 = (paramResultPoint4.getX() - paramResultPoint2.getX()) / j;
    float f6 = (paramResultPoint4.getY() - paramResultPoint2.getY()) / j;
    ResultPoint localResultPoint2 = new ResultPoint(paramResultPoint4.getX() + f5 * f4, paramResultPoint4.getY() + f4 * f6);
    if (!a(localResultPoint1))
      if (!a(localResultPoint2));
    do
    {
      return localResultPoint2;
      return null;
      if (!a(localResultPoint2))
        return localResultPoint1;
    }
    while (Math.abs(b(paramResultPoint3, localResultPoint1).c() - b(paramResultPoint2, localResultPoint1).c()) > Math.abs(b(paramResultPoint3, localResultPoint2).c() - b(paramResultPoint2, localResultPoint2).c()));
    return localResultPoint1;
  }

  private ResultPoint a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2)
  {
    float f1 = a(paramResultPoint1, paramResultPoint2) / paramInt1;
    int i = a(paramResultPoint3, paramResultPoint4);
    float f2 = (paramResultPoint4.getX() - paramResultPoint3.getX()) / i;
    float f3 = (paramResultPoint4.getY() - paramResultPoint3.getY()) / i;
    ResultPoint localResultPoint1 = new ResultPoint(paramResultPoint4.getX() + f2 * f1, paramResultPoint4.getY() + f1 * f3);
    float f4 = a(paramResultPoint1, paramResultPoint3) / paramInt2;
    int j = a(paramResultPoint2, paramResultPoint4);
    float f5 = (paramResultPoint4.getX() - paramResultPoint2.getX()) / j;
    float f6 = (paramResultPoint4.getY() - paramResultPoint2.getY()) / j;
    ResultPoint localResultPoint2 = new ResultPoint(paramResultPoint4.getX() + f5 * f4, paramResultPoint4.getY() + f4 * f6);
    if (!a(localResultPoint1))
      if (!a(localResultPoint2));
    do
    {
      return localResultPoint2;
      return null;
      if (!a(localResultPoint2))
        return localResultPoint1;
    }
    while (Math.abs(paramInt1 - b(paramResultPoint3, localResultPoint1).c()) + Math.abs(paramInt2 - b(paramResultPoint2, localResultPoint1).c()) > Math.abs(paramInt1 - b(paramResultPoint3, localResultPoint2).c()) + Math.abs(paramInt2 - b(paramResultPoint2, localResultPoint2).c()));
    return localResultPoint1;
  }

  private static BitMatrix a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt1, int paramInt2)
  {
    return GridSampler.getInstance().sampleGrid(paramBitMatrix, paramInt1, paramInt2, 0.5F, 0.5F, paramInt1 - 0.5F, 0.5F, paramInt1 - 0.5F, paramInt2 - 0.5F, 0.5F, paramInt2 - 0.5F, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint4.getX(), paramResultPoint4.getY(), paramResultPoint3.getX(), paramResultPoint3.getY(), paramResultPoint2.getX(), paramResultPoint2.getY());
  }

  private static void a(Map<ResultPoint, Integer> paramMap, ResultPoint paramResultPoint)
  {
    Integer localInteger = (Integer)paramMap.get(paramResultPoint);
    if (localInteger == null);
    for (int i = 1; ; i = 1 + localInteger.intValue())
    {
      paramMap.put(paramResultPoint, Integer.valueOf(i));
      return;
    }
  }

  private boolean a(ResultPoint paramResultPoint)
  {
    return (paramResultPoint.getX() >= 0.0F) && (paramResultPoint.getX() < this.a.getWidth()) && (paramResultPoint.getY() > 0.0F) && (paramResultPoint.getY() < this.a.getHeight());
  }

  private b b(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    int i = (int)paramResultPoint1.getX();
    int j = (int)paramResultPoint1.getY();
    int k = (int)paramResultPoint2.getX();
    int m = (int)paramResultPoint2.getY();
    int n;
    if (Math.abs(m - j) > Math.abs(k - i))
    {
      n = 1;
      if (n == 0)
        break label303;
    }
    while (true)
    {
      int i3 = Math.abs(m - j);
      int i4 = Math.abs(k - i);
      int i5 = -i3 >> 1;
      int i6;
      label88: int i7;
      label98: int i8;
      int i9;
      label115: int i10;
      label124: boolean bool1;
      int i11;
      int i12;
      label142: BitMatrix localBitMatrix2;
      int i13;
      if (i < k)
      {
        i6 = 1;
        if (j >= m)
          break label257;
        i7 = 1;
        i8 = 0;
        BitMatrix localBitMatrix1 = this.a;
        if (n == 0)
          break label263;
        i9 = i;
        if (n == 0)
          break label270;
        i10 = j;
        bool1 = localBitMatrix1.get(i9, i10);
        i11 = i5;
        i12 = i;
        if (j == m)
          break label290;
        localBitMatrix2 = this.a;
        if (n == 0)
          break label276;
        i13 = i12;
        label164: if (n == 0)
          break label283;
      }
      label257: label263: label270: label276: label283: for (int i14 = j; ; i14 = i12)
      {
        boolean bool2 = localBitMatrix2.get(i13, i14);
        if (bool2 != bool1)
        {
          i8++;
          bool1 = bool2;
        }
        int i15 = i11 + i4;
        if (i15 > 0)
        {
          if (i12 == k)
            break label290;
          i12 += i6;
          i15 -= i3;
        }
        j += i7;
        i11 = i15;
        break label142;
        n = 0;
        break;
        i6 = -1;
        break label88;
        i7 = -1;
        break label98;
        i9 = j;
        break label115;
        i10 = i;
        break label124;
        i13 = j;
        break label164;
      }
      label290: return new b(paramResultPoint1, paramResultPoint2, i8, (byte)0);
      label303: int i1 = m;
      m = k;
      k = i1;
      int i2 = j;
      j = i;
      i = i2;
    }
  }

  public final DetectorResult detect()
  {
    ResultPoint[] arrayOfResultPoint1 = this.b.detect();
    ResultPoint localResultPoint1 = arrayOfResultPoint1[0];
    ResultPoint localResultPoint2 = arrayOfResultPoint1[1];
    ResultPoint localResultPoint3 = arrayOfResultPoint1[2];
    ResultPoint localResultPoint4 = arrayOfResultPoint1[3];
    ArrayList localArrayList = new ArrayList(4);
    localArrayList.add(b(localResultPoint1, localResultPoint2));
    localArrayList.add(b(localResultPoint1, localResultPoint3));
    localArrayList.add(b(localResultPoint2, localResultPoint4));
    localArrayList.add(b(localResultPoint3, localResultPoint4));
    Collections.sort(localArrayList, new c((byte)0));
    b localb1 = (b)localArrayList.get(0);
    b localb2 = (b)localArrayList.get(1);
    HashMap localHashMap = new HashMap();
    a(localHashMap, localb1.a());
    a(localHashMap, localb1.b());
    a(localHashMap, localb2.a());
    a(localHashMap, localb2.b());
    Iterator localIterator = localHashMap.entrySet().iterator();
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ResultPoint localResultPoint11 = (ResultPoint)localEntry.getKey();
      if (((Integer)localEntry.getValue()).intValue() == 2)
        localObject1 = localResultPoint11;
      else if (localObject2 == null)
        localObject2 = localResultPoint11;
      else
        localObject3 = localResultPoint11;
    }
    if ((localObject2 == null) || (localObject1 == null) || (localObject3 == null))
      throw NotFoundException.getNotFoundInstance();
    ResultPoint[] arrayOfResultPoint2 = { localObject2, localObject1, localObject3 };
    ResultPoint.orderBestPatterns(arrayOfResultPoint2);
    ResultPoint localResultPoint5 = arrayOfResultPoint2[0];
    ResultPoint localResultPoint6 = arrayOfResultPoint2[1];
    ResultPoint localResultPoint7 = arrayOfResultPoint2[2];
    ResultPoint localResultPoint8;
    int k;
    int m;
    ResultPoint localResultPoint9;
    if (!localHashMap.containsKey(localResultPoint1))
    {
      localResultPoint8 = localResultPoint1;
      int i = b(localResultPoint7, localResultPoint8).c();
      int j = b(localResultPoint5, localResultPoint8).c();
      if ((i & 0x1) == 1)
        i++;
      k = i + 2;
      if ((j & 0x1) == 1)
        j++;
      m = j + 2;
      if ((k * 4 < m * 7) && (m * 4 < k * 7))
        break label886;
      float f1 = a(localResultPoint6, localResultPoint5) / k;
      int n = a(localResultPoint7, localResultPoint8);
      float f2 = (localResultPoint8.getX() - localResultPoint7.getX()) / n;
      float f3 = (localResultPoint8.getY() - localResultPoint7.getY()) / n;
      localObject4 = new ResultPoint(localResultPoint8.getX() + f2 * f1, localResultPoint8.getY() + f1 * f3);
      float f4 = a(localResultPoint6, localResultPoint7) / m;
      int i1 = a(localResultPoint5, localResultPoint8);
      float f5 = (localResultPoint8.getX() - localResultPoint5.getX()) / i1;
      float f6 = (localResultPoint8.getY() - localResultPoint5.getY()) / i1;
      localResultPoint9 = new ResultPoint(localResultPoint8.getX() + f5 * f4, localResultPoint8.getY() + f4 * f6);
      if (a((ResultPoint)localObject4))
        break label797;
      if (a(localResultPoint9))
        break label879;
    }
    BitMatrix localBitMatrix;
    label797: label879: for (Object localObject4 = null; ; localObject4 = localResultPoint9)
      do
      {
        if (localObject4 == null)
          localObject4 = localResultPoint8;
        int i2 = b(localResultPoint7, (ResultPoint)localObject4).c();
        int i3 = b(localResultPoint5, (ResultPoint)localObject4).c();
        if ((i2 & 0x1) == 1)
          i2++;
        if ((i3 & 0x1) == 1)
          i3++;
        localBitMatrix = a(this.a, localResultPoint7, localResultPoint6, localResultPoint5, (ResultPoint)localObject4, i2, i3);
        return new DetectorResult(localBitMatrix, new ResultPoint[] { localResultPoint7, localResultPoint6, localResultPoint5, localObject4 });
        if (!localHashMap.containsKey(localResultPoint2))
        {
          localResultPoint8 = localResultPoint2;
          break;
        }
        if (!localHashMap.containsKey(localResultPoint3))
        {
          localResultPoint8 = localResultPoint3;
          break;
        }
        localResultPoint8 = localResultPoint4;
        break;
      }
      while ((!a(localResultPoint9)) || (Math.abs(k - b(localResultPoint7, (ResultPoint)localObject4).c()) + Math.abs(m - b(localResultPoint5, (ResultPoint)localObject4).c()) <= Math.abs(k - b(localResultPoint7, localResultPoint9).c()) + Math.abs(m - b(localResultPoint5, localResultPoint9).c())));
    label886: int i4 = Math.min(m, k);
    float f7 = a(localResultPoint6, localResultPoint5) / i4;
    int i5 = a(localResultPoint7, localResultPoint8);
    float f8 = (localResultPoint8.getX() - localResultPoint7.getX()) / i5;
    float f9 = (localResultPoint8.getY() - localResultPoint7.getY()) / i5;
    localObject4 = new ResultPoint(localResultPoint8.getX() + f8 * f7, localResultPoint8.getY() + f7 * f9);
    float f10 = a(localResultPoint6, localResultPoint5) / i4;
    int i6 = a(localResultPoint5, localResultPoint8);
    float f11 = (localResultPoint8.getX() - localResultPoint5.getX()) / i6;
    float f12 = (localResultPoint8.getY() - localResultPoint5.getY()) / i6;
    ResultPoint localResultPoint10 = new ResultPoint(localResultPoint8.getX() + f11 * f10, localResultPoint8.getY() + f10 * f12);
    if (!a((ResultPoint)localObject4))
      if (a(localResultPoint10))
        break label1229;
    label1229: for (localObject4 = null; ; localObject4 = localResultPoint10)
      do
      {
        if (localObject4 == null)
          localObject4 = localResultPoint8;
        int i7 = 1 + Math.max(b(localResultPoint7, (ResultPoint)localObject4).c(), b(localResultPoint5, (ResultPoint)localObject4).c());
        if ((i7 & 0x1) == 1)
          i7++;
        localBitMatrix = a(this.a, localResultPoint7, localResultPoint6, localResultPoint5, (ResultPoint)localObject4, i7, i7);
        break;
      }
      while ((!a(localResultPoint10)) || (Math.abs(b(localResultPoint7, (ResultPoint)localObject4).c() - b(localResultPoint5, (ResultPoint)localObject4).c()) <= Math.abs(b(localResultPoint7, localResultPoint10).c() - b(localResultPoint5, localResultPoint10).c())));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.datamatrix.detector.Detector
 * JD-Core Version:    0.6.2
 */