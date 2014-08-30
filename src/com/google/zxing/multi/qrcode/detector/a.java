package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.detector.FinderPattern;
import com.google.zxing.qrcode.detector.FinderPatternFinder;
import com.google.zxing.qrcode.detector.FinderPatternInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class a extends FinderPatternFinder
{
  private static final FinderPatternInfo[] a = new FinderPatternInfo[0];
  private static final float b = 180.0F;
  private static final float c = 9.0F;
  private static final float d = 0.05F;
  private static final float e = 0.5F;

  private a(BitMatrix paramBitMatrix)
  {
    super(paramBitMatrix);
  }

  a(BitMatrix paramBitMatrix, ResultPointCallback paramResultPointCallback)
  {
    super(paramBitMatrix, paramResultPointCallback);
  }

  private FinderPattern[][] a()
  {
    List localList = getPossibleCenters();
    int i = localList.size();
    if (i < 3)
      throw NotFoundException.getNotFoundInstance();
    if (i == 3)
    {
      FinderPattern[][] arrayOfFinderPattern; = new FinderPattern[1][];
      FinderPattern[] arrayOfFinderPattern2 = new FinderPattern[3];
      arrayOfFinderPattern2[0] = ((FinderPattern)localList.get(0));
      arrayOfFinderPattern2[1] = ((FinderPattern)localList.get(1));
      arrayOfFinderPattern2[2] = ((FinderPattern)localList.get(2));
      arrayOfFinderPattern;[0] = arrayOfFinderPattern2;
      return arrayOfFinderPattern;;
    }
    Collections.sort(localList, new c((byte)0));
    ArrayList localArrayList = new ArrayList();
    for (int j = 0; j < i - 2; j++)
    {
      FinderPattern localFinderPattern1 = (FinderPattern)localList.get(j);
      if (localFinderPattern1 != null)
        for (int k = j + 1; k < i - 1; k++)
        {
          FinderPattern localFinderPattern2 = (FinderPattern)localList.get(k);
          if (localFinderPattern2 != null)
          {
            float f1 = (localFinderPattern1.getEstimatedModuleSize() - localFinderPattern2.getEstimatedModuleSize()) / Math.min(localFinderPattern1.getEstimatedModuleSize(), localFinderPattern2.getEstimatedModuleSize());
            if ((Math.abs(localFinderPattern1.getEstimatedModuleSize() - localFinderPattern2.getEstimatedModuleSize()) > 0.5F) && (f1 >= 0.05F))
              break;
            for (int m = k + 1; m < i; m++)
            {
              FinderPattern localFinderPattern3 = (FinderPattern)localList.get(m);
              if (localFinderPattern3 != null)
              {
                float f2 = (localFinderPattern2.getEstimatedModuleSize() - localFinderPattern3.getEstimatedModuleSize()) / Math.min(localFinderPattern2.getEstimatedModuleSize(), localFinderPattern3.getEstimatedModuleSize());
                if ((Math.abs(localFinderPattern2.getEstimatedModuleSize() - localFinderPattern3.getEstimatedModuleSize()) > 0.5F) && (f2 >= 0.05F))
                  break;
                FinderPattern[] arrayOfFinderPattern1 = { localFinderPattern1, localFinderPattern2, localFinderPattern3 };
                ResultPoint.orderBestPatterns(arrayOfFinderPattern1);
                FinderPatternInfo localFinderPatternInfo = new FinderPatternInfo(arrayOfFinderPattern1);
                float f3 = ResultPoint.distance(localFinderPatternInfo.getTopLeft(), localFinderPatternInfo.getBottomLeft());
                float f4 = ResultPoint.distance(localFinderPatternInfo.getTopRight(), localFinderPatternInfo.getBottomLeft());
                float f5 = ResultPoint.distance(localFinderPatternInfo.getTopLeft(), localFinderPatternInfo.getTopRight());
                float f6 = (f3 + f5) / (2.0F * localFinderPattern1.getEstimatedModuleSize());
                if ((f6 <= 180.0F) && (f6 >= 9.0F) && (Math.abs((f3 - f5) / Math.min(f3, f5)) < 0.1F))
                {
                  float f7 = (float)Math.sqrt(f3 * f3 + f5 * f5);
                  if (Math.abs((f4 - f7) / Math.min(f4, f7)) < 0.1F)
                    localArrayList.add(arrayOfFinderPattern1);
                }
              }
            }
          }
        }
    }
    if (!localArrayList.isEmpty())
      return (FinderPattern[][])localArrayList.toArray(new FinderPattern[localArrayList.size()][]);
    throw NotFoundException.getNotFoundInstance();
  }

  public final FinderPatternInfo[] a(Map<DecodeHintType, ?> paramMap)
  {
    int i;
    BitMatrix localBitMatrix;
    int j;
    int k;
    int m;
    if ((paramMap != null) && (paramMap.containsKey(DecodeHintType.TRY_HARDER)))
    {
      i = 1;
      localBitMatrix = getImage();
      j = localBitMatrix.getHeight();
      k = localBitMatrix.getWidth();
      m = (int)(3.0F * (j / 228.0F));
      if ((m >= 3) && (i == 0))
        break label1029;
    }
    label1029: for (int n = 3; ; n = m)
    {
      int[] arrayOfInt = new int[5];
      int i1 = n - 1;
      int i8;
      int i9;
      if (i1 < j)
      {
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        arrayOfInt[2] = 0;
        arrayOfInt[3] = 0;
        arrayOfInt[4] = 0;
        i8 = 0;
        i9 = 0;
        while (true)
          if (i9 < k)
          {
            if (localBitMatrix.get(i9, i1))
            {
              if ((i8 & 0x1) == 1)
                i8++;
              arrayOfInt[i8] = (1 + arrayOfInt[i8]);
              label150: i9++;
              continue;
              i = 0;
              break;
            }
            if ((i8 & 0x1) == 0)
              if (i8 == 4)
                if (foundPatternCross(arrayOfInt))
                {
                  if (handlePossibleCenter(arrayOfInt, i1, i9))
                    break label1022;
                  do
                    i9++;
                  while ((i9 < k) && (!localBitMatrix.get(i9, i1)));
                }
          }
      }
      label1022: for (int i10 = i9 - 1; ; i10 = i9)
      {
        arrayOfInt[0] = 0;
        arrayOfInt[1] = 0;
        arrayOfInt[2] = 0;
        arrayOfInt[3] = 0;
        arrayOfInt[4] = 0;
        i9 = i10;
        i8 = 0;
        break label150;
        arrayOfInt[0] = arrayOfInt[2];
        arrayOfInt[1] = arrayOfInt[3];
        arrayOfInt[2] = arrayOfInt[4];
        arrayOfInt[3] = 1;
        arrayOfInt[4] = 0;
        i8 = 3;
        break label150;
        i8++;
        arrayOfInt[i8] = (1 + arrayOfInt[i8]);
        break label150;
        arrayOfInt[i8] = (1 + arrayOfInt[i8]);
        break label150;
        if (foundPatternCross(arrayOfInt))
          handlePossibleCenter(arrayOfInt, i1, k);
        i1 += n;
        break;
        List localList = getPossibleCenters();
        int i2 = localList.size();
        if (i2 < 3)
          throw NotFoundException.getNotFoundInstance();
        FinderPattern[][] arrayOfFinderPattern;;
        if (i2 == 3)
        {
          arrayOfFinderPattern; = new FinderPattern[1][];
          FinderPattern[] arrayOfFinderPattern2 = new FinderPattern[3];
          arrayOfFinderPattern2[0] = ((FinderPattern)localList.get(0));
          arrayOfFinderPattern2[1] = ((FinderPattern)localList.get(1));
          arrayOfFinderPattern2[2] = ((FinderPattern)localList.get(2));
          arrayOfFinderPattern;[0] = arrayOfFinderPattern2;
        }
        ArrayList localArrayList2;
        ArrayList localArrayList1;
        for (Object localObject = arrayOfFinderPattern;; ; localObject = (FinderPattern[][])localArrayList1.toArray(new FinderPattern[localArrayList1.size()][]))
        {
          localArrayList2 = new ArrayList();
          int i4 = localObject.length;
          for (int i5 = 0; i5 < i4; i5++)
          {
            ResultPoint[] arrayOfResultPoint = localObject[i5];
            ResultPoint.orderBestPatterns(arrayOfResultPoint);
            localArrayList2.add(new FinderPatternInfo(arrayOfResultPoint));
          }
          Collections.sort(localList, new c((byte)0));
          localArrayList1 = new ArrayList();
          for (int i3 = 0; i3 < i2 - 2; i3++)
          {
            FinderPattern localFinderPattern1 = (FinderPattern)localList.get(i3);
            if (localFinderPattern1 != null)
              for (int i6 = i3 + 1; i6 < i2 - 1; i6++)
              {
                FinderPattern localFinderPattern2 = (FinderPattern)localList.get(i6);
                if (localFinderPattern2 != null)
                {
                  float f1 = (localFinderPattern1.getEstimatedModuleSize() - localFinderPattern2.getEstimatedModuleSize()) / Math.min(localFinderPattern1.getEstimatedModuleSize(), localFinderPattern2.getEstimatedModuleSize());
                  if ((Math.abs(localFinderPattern1.getEstimatedModuleSize() - localFinderPattern2.getEstimatedModuleSize()) > 0.5F) && (f1 >= 0.05F))
                    break;
                  for (int i7 = i6 + 1; i7 < i2; i7++)
                  {
                    FinderPattern localFinderPattern3 = (FinderPattern)localList.get(i7);
                    if (localFinderPattern3 != null)
                    {
                      float f2 = (localFinderPattern2.getEstimatedModuleSize() - localFinderPattern3.getEstimatedModuleSize()) / Math.min(localFinderPattern2.getEstimatedModuleSize(), localFinderPattern3.getEstimatedModuleSize());
                      if ((Math.abs(localFinderPattern2.getEstimatedModuleSize() - localFinderPattern3.getEstimatedModuleSize()) > 0.5F) && (f2 >= 0.05F))
                        break;
                      FinderPattern[] arrayOfFinderPattern1 = { localFinderPattern1, localFinderPattern2, localFinderPattern3 };
                      ResultPoint.orderBestPatterns(arrayOfFinderPattern1);
                      FinderPatternInfo localFinderPatternInfo = new FinderPatternInfo(arrayOfFinderPattern1);
                      float f3 = ResultPoint.distance(localFinderPatternInfo.getTopLeft(), localFinderPatternInfo.getBottomLeft());
                      float f4 = ResultPoint.distance(localFinderPatternInfo.getTopRight(), localFinderPatternInfo.getBottomLeft());
                      float f5 = ResultPoint.distance(localFinderPatternInfo.getTopLeft(), localFinderPatternInfo.getTopRight());
                      float f6 = (f3 + f5) / (2.0F * localFinderPattern1.getEstimatedModuleSize());
                      if ((f6 <= 180.0F) && (f6 >= 9.0F) && (Math.abs((f3 - f5) / Math.min(f3, f5)) < 0.1F))
                      {
                        float f7 = (float)Math.sqrt(f3 * f3 + f5 * f5);
                        if (Math.abs((f4 - f7) / Math.min(f4, f7)) < 0.1F)
                          localArrayList1.add(arrayOfFinderPattern1);
                      }
                    }
                  }
                }
              }
          }
          if (localArrayList1.isEmpty())
            break;
        }
        throw NotFoundException.getNotFoundInstance();
        if (localArrayList2.isEmpty())
          return a;
        return (FinderPatternInfo[])localArrayList2.toArray(new FinderPatternInfo[localArrayList2.size()]);
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.multi.qrcode.detector.a
 * JD-Core Version:    0.6.2
 */