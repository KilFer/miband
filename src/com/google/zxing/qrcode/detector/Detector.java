package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.PerspectiveTransform;
import com.google.zxing.qrcode.decoder.Version;
import java.util.Map;

public class Detector
{
  private final BitMatrix a;
  private ResultPointCallback b;

  public Detector(BitMatrix paramBitMatrix)
  {
    this.a = paramBitMatrix;
  }

  private float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = 0;
    float f1 = b(paramInt1, paramInt2, paramInt3, paramInt4);
    int j = paramInt1 - (paramInt3 - paramInt1);
    float f2;
    int k;
    if (j < 0)
    {
      f2 = paramInt1 / (paramInt1 - j);
      k = 0;
    }
    while (true)
    {
      int m = (int)(paramInt2 - f2 * (paramInt4 - paramInt2));
      float f3;
      if (m < 0)
        f3 = paramInt2 / (paramInt2 - m);
      while (true)
      {
        return f1 + b(paramInt1, paramInt2, (int)(paramInt1 + f3 * (k - paramInt1)), i) - 1.0F;
        if (j < this.a.getWidth())
          break label196;
        f2 = (-1 + this.a.getWidth() - paramInt1) / (j - paramInt1);
        k = -1 + this.a.getWidth();
        break;
        if (m >= this.a.getHeight())
        {
          f3 = (-1 + this.a.getHeight() - paramInt2) / (m - paramInt2);
          i = -1 + this.a.getHeight();
        }
        else
        {
          i = m;
          f3 = 1.0F;
        }
      }
      label196: k = j;
      f2 = 1.0F;
    }
  }

  private float a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2)
  {
    float f1 = a((int)paramResultPoint1.getX(), (int)paramResultPoint1.getY(), (int)paramResultPoint2.getX(), (int)paramResultPoint2.getY());
    float f2 = a((int)paramResultPoint2.getX(), (int)paramResultPoint2.getY(), (int)paramResultPoint1.getX(), (int)paramResultPoint1.getY());
    if (Float.isNaN(f1))
      return f2 / 7.0F;
    if (Float.isNaN(f2))
      return f1 / 7.0F;
    return (f1 + f2) / 14.0F;
  }

  private static int a(float paramFloat)
  {
    return (int)(0.5F + paramFloat);
  }

  private static BitMatrix a(BitMatrix paramBitMatrix, PerspectiveTransform paramPerspectiveTransform, int paramInt)
  {
    return GridSampler.getInstance().sampleGrid(paramBitMatrix, paramInt, paramInt, paramPerspectiveTransform);
  }

  private float b(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i;
    if (Math.abs(paramInt4 - paramInt2) > Math.abs(paramInt3 - paramInt1))
    {
      i = 1;
      if (i == 0)
        break label337;
    }
    while (true)
    {
      int m = Math.abs(paramInt4 - paramInt2);
      int n = Math.abs(paramInt3 - paramInt1);
      int i1 = -m >> 1;
      int i2;
      label57: int i3;
      label65: int i4;
      int i5;
      int i6;
      int i7;
      if (paramInt2 < paramInt4)
      {
        i2 = 1;
        if (paramInt1 >= paramInt3)
          break label182;
        i3 = 1;
        i4 = 0;
        i5 = paramInt4 + i2;
        i6 = paramInt2;
        i7 = i1;
      }
      label101: label110: int i15;
      label182: label195: label202: label208: int i16;
      int i17;
      int i18;
      for (int i8 = paramInt1; ; i8 = i17)
      {
        if (i6 == i5)
          break label330;
        int i12;
        int i13;
        if (i != 0)
        {
          i12 = i8;
          if (i == 0)
            break label195;
          i13 = i6;
          if (i4 != 1)
            break label202;
        }
        for (int i14 = 1; ; i14 = 0)
        {
          if (i14 != this.a.get(i12, i13))
            break label323;
          if (i4 != 2)
            break label208;
          int i19 = i6 - paramInt2;
          int i20 = i8 - paramInt1;
          return (float)Math.sqrt(i19 * i19 + i20 * i20);
          i = 0;
          break;
          i2 = -1;
          break label57;
          i3 = -1;
          break label65;
          i12 = i6;
          break label101;
          i13 = i8;
          break label110;
        }
        i15 = i4 + 1;
        i16 = i7 + n;
        if (i16 <= 0)
          break label312;
        if (i8 == paramInt3)
          break label268;
        i17 = i8 + i3;
        i18 = i16 - m;
        label246: i6 += i2;
        i4 = i15;
        i7 = i18;
      }
      label268: label312: label323: label330: for (int i9 = i15; ; i9 = i4)
      {
        if (i9 == 2)
        {
          int i10 = paramInt4 + i2 - paramInt2;
          int i11 = paramInt3 - paramInt1;
          return (float)Math.sqrt(i10 * i10 + i11 * i11);
        }
        return (0.0F / 0.0F);
        i17 = i8;
        i18 = i16;
        break label246;
        i15 = i4;
        break;
      }
      label337: int j = paramInt4;
      paramInt4 = paramInt3;
      paramInt3 = j;
      int k = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = k;
    }
  }

  protected static int computeDimension(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, float paramFloat)
  {
    int i = 7 + ((int)(0.5F + ResultPoint.distance(paramResultPoint1, paramResultPoint2) / paramFloat) + (int)(0.5F + ResultPoint.distance(paramResultPoint1, paramResultPoint3) / paramFloat) >> 1);
    switch (i & 0x3)
    {
    case 1:
    default:
      return i;
    case 0:
      return i + 1;
    case 2:
      return i - 1;
    case 3:
    }
    throw NotFoundException.getNotFoundInstance();
  }

  public static PerspectiveTransform createTransform(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt)
  {
    float f1 = paramInt - 3.5F;
    float f2;
    float f3;
    float f4;
    if (paramResultPoint4 != null)
    {
      f2 = paramResultPoint4.getX();
      f3 = paramResultPoint4.getY();
      f4 = f1 - 3.0F;
    }
    for (float f5 = f4; ; f5 = f1)
    {
      return PerspectiveTransform.quadrilateralToQuadrilateral(3.5F, 3.5F, f1, 3.5F, f5, f4, 3.5F, f1, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint2.getX(), paramResultPoint2.getY(), f2, f3, paramResultPoint3.getX(), paramResultPoint3.getY());
      f2 = paramResultPoint2.getX() - paramResultPoint1.getX() + paramResultPoint3.getX();
      f3 = paramResultPoint2.getY() - paramResultPoint1.getY() + paramResultPoint3.getY();
      f4 = f1;
    }
  }

  protected float calculateModuleSize(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3)
  {
    return (a(paramResultPoint1, paramResultPoint2) + a(paramResultPoint1, paramResultPoint3)) / 2.0F;
  }

  public DetectorResult detect()
  {
    return detect(null);
  }

  public DetectorResult detect(Map<DecodeHintType, ?> paramMap)
  {
    if (paramMap == null);
    for (ResultPointCallback localResultPointCallback = null; ; localResultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK))
    {
      this.b = localResultPointCallback;
      return processFinderPatternInfo(new FinderPatternFinder(this.a, this.b).b(paramMap));
    }
  }

  protected AlignmentPattern findAlignmentInRegion(float paramFloat1, int paramInt1, int paramInt2, float paramFloat2)
  {
    int i = (int)(paramFloat2 * paramFloat1);
    int j = Math.max(0, paramInt1 - i);
    int k = Math.min(-1 + this.a.getWidth(), paramInt1 + i);
    if (k - j < paramFloat1 * 3.0F)
      throw NotFoundException.getNotFoundInstance();
    int m = Math.max(0, paramInt2 - i);
    int n = Math.min(-1 + this.a.getHeight(), i + paramInt2);
    if (n - m < paramFloat1 * 3.0F)
      throw NotFoundException.getNotFoundInstance();
    return new a(this.a, j, m, k - j, n - m, paramFloat1, this.b).a();
  }

  protected BitMatrix getImage()
  {
    return this.a;
  }

  protected ResultPointCallback getResultPointCallback()
  {
    return this.b;
  }

  protected DetectorResult processFinderPatternInfo(FinderPatternInfo paramFinderPatternInfo)
  {
    FinderPattern localFinderPattern1 = paramFinderPatternInfo.getTopLeft();
    FinderPattern localFinderPattern2 = paramFinderPatternInfo.getTopRight();
    FinderPattern localFinderPattern3 = paramFinderPatternInfo.getBottomLeft();
    float f1 = calculateModuleSize(localFinderPattern1, localFinderPattern2, localFinderPattern3);
    if (f1 < 1.0F)
      throw NotFoundException.getNotFoundInstance();
    int i = computeDimension(localFinderPattern1, localFinderPattern2, localFinderPattern3, f1);
    Version localVersion = Version.getProvisionalVersionForDimension(i);
    int j = -7 + localVersion.getDimensionForVersion();
    int k = localVersion.getAlignmentPatternCenters().length;
    Object localObject = null;
    int m;
    int n;
    int i1;
    float f5;
    if (k > 0)
    {
      float f2 = localFinderPattern2.getX() - localFinderPattern1.getX() + localFinderPattern3.getX();
      float f3 = localFinderPattern2.getY() - localFinderPattern1.getY() + localFinderPattern3.getY();
      float f4 = 1.0F - 3.0F / j;
      m = (int)(localFinderPattern1.getX() + f4 * (f2 - localFinderPattern1.getX()));
      n = (int)(localFinderPattern1.getY() + f4 * (f3 - localFinderPattern1.getY()));
      i1 = 4;
      localObject = null;
      if (i1 <= 16)
        f5 = i1;
    }
    while (true)
    {
      try
      {
        AlignmentPattern localAlignmentPattern = findAlignmentInRegion(f1, m, n, f5);
        localObject = localAlignmentPattern;
        PerspectiveTransform localPerspectiveTransform = createTransform(localFinderPattern1, localFinderPattern2, localFinderPattern3, localObject, i);
        BitMatrix localBitMatrix1 = this.a;
        BitMatrix localBitMatrix2 = GridSampler.getInstance().sampleGrid(localBitMatrix1, i, i, localPerspectiveTransform);
        if (localObject != null)
          break label279;
        arrayOfResultPoint = new ResultPoint[] { localFinderPattern3, localFinderPattern1, localFinderPattern2 };
        return new DetectorResult(localBitMatrix2, arrayOfResultPoint);
      }
      catch (NotFoundException localNotFoundException)
      {
        i1 <<= 1;
      }
      break;
      label279: ResultPoint[] arrayOfResultPoint = { localFinderPattern3, localFinderPattern1, localFinderPattern2, localObject };
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.detector.Detector
 * JD-Core Version:    0.6.2
 */