package com.google.zxing.pdf417.detector;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.DetectorResult;
import com.google.zxing.common.GridSampler;
import java.util.Arrays;
import java.util.Map;

public final class Detector
{
  private static final int a = 107;
  private static final int b = 204;
  private static final int c = 2;
  private static final int[] d = { 8, 1, 1, 1, 1, 1, 1, 3 };
  private static final int[] e = { 3, 1, 1, 1, 1, 1, 1, 8 };
  private static final int[] f = { 7, 1, 1, 3, 1, 1, 1, 2, 1 };
  private static final int[] g = { 1, 2, 1, 1, 1, 3, 1, 1, 7 };
  private final BinaryBitmap h;

  public Detector(BinaryBitmap paramBinaryBitmap)
  {
    this.h = paramBinaryBitmap;
  }

  private static float a(ResultPoint[] paramArrayOfResultPoint)
  {
    return ((ResultPoint.distance(paramArrayOfResultPoint[0], paramArrayOfResultPoint[4]) + ResultPoint.distance(paramArrayOfResultPoint[1], paramArrayOfResultPoint[5])) / 34.0F + (ResultPoint.distance(paramArrayOfResultPoint[6], paramArrayOfResultPoint[2]) + ResultPoint.distance(paramArrayOfResultPoint[7], paramArrayOfResultPoint[3])) / 36.0F) / 2.0F;
  }

  private static int a(float paramFloat)
  {
    return (int)(0.5F + paramFloat);
  }

  private static int a(ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, float paramFloat)
  {
    return 17 * ((8 + ((int)(0.5F + ResultPoint.distance(paramResultPoint1, paramResultPoint2) / paramFloat) + (int)(0.5F + ResultPoint.distance(paramResultPoint3, paramResultPoint4) / paramFloat) >> 1)) / 17);
  }

  private static int a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = paramArrayOfInt1.length;
    int j = 0;
    int k = 0;
    int m = 0;
    while (j < i)
    {
      int i7 = k + paramArrayOfInt1[j];
      int i8 = m + paramArrayOfInt2[j];
      j++;
      m = i8;
      k = i7;
    }
    if (k < m);
    int i3;
    label153: 
    while (true)
    {
      return 2147483647;
      int n = (k << 8) / m;
      int i1 = n * 204 >> 8;
      int i2 = 0;
      i3 = 0;
      if (i2 >= i)
        break;
      int i4 = paramArrayOfInt1[i2] << 8;
      int i5 = n * paramArrayOfInt2[i2];
      if (i4 > i5);
      for (int i6 = i4 - i5; ; i6 = i5 - i4)
      {
        if (i6 > i1)
          break label153;
        i3 += i6;
        i2++;
        break;
      }
    }
    return i3 / k;
  }

  private static BitMatrix a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4, int paramInt)
  {
    return GridSampler.getInstance().sampleGrid(paramBitMatrix, paramInt, paramInt, 0.0F, 0.0F, paramInt, 0.0F, paramInt, paramInt, 0.0F, paramInt, paramResultPoint1.getX(), paramResultPoint1.getY(), paramResultPoint3.getX(), paramResultPoint3.getY(), paramResultPoint4.getX(), paramResultPoint4.getY(), paramResultPoint2.getX(), paramResultPoint2.getY());
  }

  private static void a(ResultPoint[] paramArrayOfResultPoint, boolean paramBoolean)
  {
    float f1 = paramArrayOfResultPoint[4].getY() - paramArrayOfResultPoint[6].getY();
    if (paramBoolean)
      f1 = -f1;
    float f14;
    if (f1 > 2.0F)
    {
      float f12 = paramArrayOfResultPoint[4].getX() - paramArrayOfResultPoint[0].getX();
      float f13 = paramArrayOfResultPoint[6].getX() - paramArrayOfResultPoint[0].getX();
      f14 = f12 * (paramArrayOfResultPoint[6].getY() - paramArrayOfResultPoint[0].getY()) / f13;
    }
    float f5;
    do
    {
      paramArrayOfResultPoint[4] = new ResultPoint(paramArrayOfResultPoint[4].getX(), f14 + paramArrayOfResultPoint[4].getY());
      while (true)
      {
        f5 = paramArrayOfResultPoint[7].getY() - paramArrayOfResultPoint[5].getY();
        if (paramBoolean)
          f5 = -f5;
        if (f5 <= 2.0F)
          break;
        float f9 = paramArrayOfResultPoint[5].getX() - paramArrayOfResultPoint[1].getX();
        float f10 = paramArrayOfResultPoint[7].getX() - paramArrayOfResultPoint[1].getX();
        float f11 = f9 * (paramArrayOfResultPoint[7].getY() - paramArrayOfResultPoint[1].getY()) / f10;
        paramArrayOfResultPoint[5] = new ResultPoint(paramArrayOfResultPoint[5].getX(), f11 + paramArrayOfResultPoint[5].getY());
        return;
        if (-f1 > 2.0F)
        {
          float f2 = paramArrayOfResultPoint[2].getX() - paramArrayOfResultPoint[6].getX();
          float f3 = paramArrayOfResultPoint[2].getX() - paramArrayOfResultPoint[4].getX();
          float f4 = f2 * (paramArrayOfResultPoint[2].getY() - paramArrayOfResultPoint[4].getY()) / f3;
          paramArrayOfResultPoint[6] = new ResultPoint(paramArrayOfResultPoint[6].getX(), paramArrayOfResultPoint[6].getY() - f4);
        }
      }
    }
    while (-f5 <= 2.0F);
    float f6 = paramArrayOfResultPoint[3].getX() - paramArrayOfResultPoint[7].getX();
    float f7 = paramArrayOfResultPoint[3].getX() - paramArrayOfResultPoint[5].getX();
    float f8 = f6 * (paramArrayOfResultPoint[3].getY() - paramArrayOfResultPoint[5].getY()) / f7;
    paramArrayOfResultPoint[7] = new ResultPoint(paramArrayOfResultPoint[7].getX(), paramArrayOfResultPoint[7].getY() - f8);
  }

  private static int[] a(BitMatrix paramBitMatrix, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    Arrays.fill(paramArrayOfInt2, 0, paramArrayOfInt2.length, 0);
    int i = paramArrayOfInt1.length;
    int j = 0;
    int k = paramInt1;
    int m = paramInt1;
    boolean bool = paramBoolean;
    if (k < paramInt1 + paramInt3)
    {
      if ((bool ^ paramBitMatrix.get(k, paramInt2)))
        paramArrayOfInt2[j] = (1 + paramArrayOfInt2[j]);
      while (true)
      {
        k++;
        break;
        if (j == i - 1)
        {
          int n = paramArrayOfInt2.length;
          int i1 = 0;
          int i2 = 0;
          int i12;
          for (int i3 = 0; i2 < n; i3 = i12)
          {
            i12 = i3 + paramArrayOfInt2[i2];
            i1 += paramArrayOfInt1[i2];
            i2++;
          }
          int i8;
          if (i3 < i1)
            i8 = 2147483647;
          while (i8 < 107)
          {
            return new int[] { m, k };
            int i4 = (i3 << 8) / i1;
            int i5 = i4 * 204 >> 8;
            int i6 = 0;
            for (int i7 = 0; ; i7++)
            {
              if (i7 >= n)
                break label264;
              int i9 = paramArrayOfInt2[i7] << 8;
              int i10 = i4 * paramArrayOfInt1[i7];
              if (i9 > i10);
              for (int i11 = i9 - i10; ; i11 = i10 - i9)
              {
                if (i11 <= i5)
                  break label251;
                i8 = 2147483647;
                break;
              }
              label251: i6 += i11;
            }
            label264: i8 = i6 / i3;
          }
          m += paramArrayOfInt2[0] + paramArrayOfInt2[1];
          System.arraycopy(paramArrayOfInt2, 2, paramArrayOfInt2, 0, i - 2);
          paramArrayOfInt2[(i - 2)] = 0;
          paramArrayOfInt2[(i - 1)] = 0;
          j--;
        }
        while (true)
        {
          paramArrayOfInt2[j] = 1;
          if (bool)
            break label343;
          bool = true;
          break;
          j++;
        }
        label343: bool = false;
      }
    }
    return null;
  }

  private static ResultPoint[] a(BitMatrix paramBitMatrix)
  {
    int i = 1;
    int j = paramBitMatrix.getHeight();
    int k = paramBitMatrix.getWidth();
    ResultPoint[] arrayOfResultPoint = new ResultPoint[8];
    int[] arrayOfInt1 = new int[d.length];
    int m = 0;
    if (m < j)
    {
      int[] arrayOfInt6 = a(paramBitMatrix, 0, m, k, false, d, arrayOfInt1);
      if (arrayOfInt6 != null)
      {
        arrayOfResultPoint[0] = new ResultPoint(arrayOfInt6[0], m);
        arrayOfResultPoint[4] = new ResultPoint(arrayOfInt6[i], m);
      }
    }
    for (int n = i; ; n = 0)
    {
      int i3;
      if (n != 0)
      {
        i3 = j - 1;
        label108: if (i3 <= 0)
          break label385;
        int[] arrayOfInt5 = a(paramBitMatrix, 0, i3, k, false, d, arrayOfInt1);
        if (arrayOfInt5 == null)
          break label348;
        arrayOfResultPoint[i] = new ResultPoint(arrayOfInt5[0], i3);
        arrayOfResultPoint[5] = new ResultPoint(arrayOfInt5[i], i3);
      }
      label385: for (n = i; ; n = 0)
      {
        int[] arrayOfInt2 = new int[f.length];
        int i2;
        if (n != 0)
        {
          i2 = 0;
          label191: if (i2 >= j)
            break label379;
          int[] arrayOfInt4 = a(paramBitMatrix, 0, i2, k, false, f, arrayOfInt2);
          if (arrayOfInt4 == null)
            break label354;
          arrayOfResultPoint[2] = new ResultPoint(arrayOfInt4[i], i2);
          arrayOfResultPoint[6] = new ResultPoint(arrayOfInt4[0], i2);
        }
        label270: label348: label354: label379: for (n = i; ; n = 0)
        {
          int i1;
          if (n != 0)
          {
            i1 = j - 1;
            if (i1 > 0)
            {
              int[] arrayOfInt3 = a(paramBitMatrix, 0, i1, k, false, f, arrayOfInt2);
              if (arrayOfInt3 != null)
              {
                arrayOfResultPoint[3] = new ResultPoint(arrayOfInt3[i], i1);
                arrayOfResultPoint[7] = new ResultPoint(arrayOfInt3[0], i1);
              }
            }
          }
          while (true)
          {
            if (i != 0)
            {
              return arrayOfResultPoint;
              m++;
              break;
              i3--;
              break label108;
              i2++;
              break label191;
              i1--;
              break label270;
            }
            return null;
            i = 0;
            continue;
            i = n;
          }
        }
      }
    }
  }

  private static ResultPoint[] b(BitMatrix paramBitMatrix)
  {
    boolean bool1 = true;
    int i = paramBitMatrix.getHeight();
    int j = paramBitMatrix.getWidth() >> 1;
    ResultPoint[] arrayOfResultPoint = new ResultPoint[8];
    int[] arrayOfInt1 = new int[e.length];
    int k = i - 1;
    if (k > 0)
    {
      int[] arrayOfInt6 = a(paramBitMatrix, j, k, j, bool1, e, arrayOfInt1);
      if (arrayOfInt6 != null)
      {
        arrayOfResultPoint[0] = new ResultPoint(arrayOfInt6[bool1], k);
        arrayOfResultPoint[4] = new ResultPoint(arrayOfInt6[0], k);
      }
    }
    for (boolean bool2 = bool1; ; bool2 = false)
    {
      int i1;
      if (bool2)
      {
        i1 = 0;
        label109: if (i1 >= i)
          break label387;
        int[] arrayOfInt5 = a(paramBitMatrix, j, i1, j, bool1, e, arrayOfInt1);
        if (arrayOfInt5 == null)
          break label350;
        arrayOfResultPoint[bool1] = new ResultPoint(arrayOfInt5[bool1], i1);
        arrayOfResultPoint[5] = new ResultPoint(arrayOfInt5[0], i1);
      }
      label387: for (bool2 = bool1; ; bool2 = false)
      {
        int[] arrayOfInt2 = new int[g.length];
        int n;
        if (bool2)
        {
          n = i - 1;
          label195: if (n <= 0)
            break label381;
          int[] arrayOfInt4 = a(paramBitMatrix, 0, n, j, false, g, arrayOfInt2);
          if (arrayOfInt4 == null)
            break label356;
          arrayOfResultPoint[2] = new ResultPoint(arrayOfInt4[0], n);
          arrayOfResultPoint[6] = new ResultPoint(arrayOfInt4[bool1], n);
        }
        label271: label350: label356: label381: for (bool2 = bool1; ; bool2 = false)
        {
          int m;
          if (bool2)
          {
            m = 0;
            if (m < i)
            {
              int[] arrayOfInt3 = a(paramBitMatrix, 0, m, j, false, g, arrayOfInt2);
              if (arrayOfInt3 != null)
              {
                arrayOfResultPoint[3] = new ResultPoint(arrayOfInt3[0], m);
                arrayOfResultPoint[7] = new ResultPoint(arrayOfInt3[bool1], m);
              }
            }
          }
          while (true)
          {
            if (bool1)
            {
              return arrayOfResultPoint;
              k--;
              break;
              i1++;
              break label109;
              n--;
              break label195;
              m++;
              break label271;
            }
            return null;
            bool1 = false;
            continue;
            bool1 = bool2;
          }
        }
      }
    }
  }

  public final DetectorResult detect()
  {
    return detect(null);
  }

  public final DetectorResult detect(Map<DecodeHintType, ?> paramMap)
  {
    BitMatrix localBitMatrix1 = this.h.getBlackMatrix();
    int i = localBitMatrix1.getHeight();
    int j = localBitMatrix1.getWidth();
    ResultPoint[] arrayOfResultPoint1 = new ResultPoint[8];
    int[] arrayOfInt1 = new int[d.length];
    int k = 0;
    if (k < i)
    {
      int[] arrayOfInt12 = a(localBitMatrix1, 0, k, j, false, d, arrayOfInt1);
      if (arrayOfInt12 != null)
      {
        arrayOfResultPoint1[0] = new ResultPoint(arrayOfInt12[0], k);
        arrayOfResultPoint1[4] = new ResultPoint(arrayOfInt12[1], k);
      }
    }
    label200: label358: label752: label1138: for (int m = 1; ; m = 0)
    {
      int i11;
      if (m != 0)
      {
        i11 = i - 1;
        label116: if (i11 <= 0)
          break label1156;
        int[] arrayOfInt11 = a(localBitMatrix1, 0, i11, j, false, d, arrayOfInt1);
        if (arrayOfInt11 == null)
          break label752;
        arrayOfResultPoint1[1] = new ResultPoint(arrayOfInt11[0], i11);
        arrayOfResultPoint1[5] = new ResultPoint(arrayOfInt11[1], i11);
      }
      label758: label1144: for (m = 1; ; m = 0)
      {
        int[] arrayOfInt2 = new int[f.length];
        int i10;
        if (m != 0)
        {
          i10 = 0;
          if (i10 >= i)
            break label1150;
          int[] arrayOfInt10 = a(localBitMatrix1, 0, i10, j, false, f, arrayOfInt2);
          if (arrayOfInt10 == null)
            break label758;
          arrayOfResultPoint1[2] = new ResultPoint(arrayOfInt10[1], i10);
          arrayOfResultPoint1[6] = new ResultPoint(arrayOfInt10[0], i10);
        }
        label764: label1150: for (m = 1; ; m = 0)
        {
          int i9;
          if (m != 0)
          {
            i9 = i - 1;
            if (i9 <= 0)
              break label1144;
            int[] arrayOfInt9 = a(localBitMatrix1, 0, i9, j, false, f, arrayOfInt2);
            if (arrayOfInt9 == null)
              break label764;
            arrayOfResultPoint1[3] = new ResultPoint(arrayOfInt9[1], i9);
            arrayOfResultPoint1[7] = new ResultPoint(arrayOfInt9[0], i9);
          }
          for (m = 1; ; m = 0)
          {
            Object localObject1;
            int i1;
            int i2;
            ResultPoint[] arrayOfResultPoint3;
            int[] arrayOfInt3;
            int i3;
            if (m != 0)
            {
              localObject1 = arrayOfResultPoint1;
              if (localObject1 != null)
                break label806;
              i1 = localBitMatrix1.getHeight();
              i2 = localBitMatrix1.getWidth() >> 1;
              arrayOfResultPoint3 = new ResultPoint[8];
              arrayOfInt3 = new int[e.length];
              i3 = i1 - 1;
              if (i3 <= 0)
                break label1138;
              int[] arrayOfInt8 = a(localBitMatrix1, i2, i3, i2, true, e, arrayOfInt3);
              if (arrayOfInt8 == null)
                break label776;
              arrayOfResultPoint3[0] = new ResultPoint(arrayOfInt8[1], i3);
              arrayOfResultPoint3[4] = new ResultPoint(arrayOfInt8[0], i3);
            }
            for (int i4 = 1; ; i4 = 0)
            {
              int i8;
              if (i4 != 0)
              {
                i8 = 0;
                if (i8 >= i1)
                  break label1132;
                int[] arrayOfInt7 = a(localBitMatrix1, i2, i8, i2, true, e, arrayOfInt3);
                if (arrayOfInt7 == null)
                  break label782;
                arrayOfResultPoint3[1] = new ResultPoint(arrayOfInt7[1], i8);
                arrayOfResultPoint3[5] = new ResultPoint(arrayOfInt7[0], i8);
              }
              for (i4 = 1; ; i4 = 0)
              {
                int[] arrayOfInt4 = new int[g.length];
                int i7;
                if (i4 != 0)
                {
                  i7 = i1 - 1;
                  if (i7 <= 0)
                    break label1126;
                  int[] arrayOfInt6 = a(localBitMatrix1, 0, i7, i2, false, g, arrayOfInt4);
                  if (arrayOfInt6 == null)
                    break label788;
                  arrayOfResultPoint3[2] = new ResultPoint(arrayOfInt6[0], i7);
                  arrayOfResultPoint3[6] = new ResultPoint(arrayOfInt6[1], i7);
                }
                for (i4 = 1; ; i4 = 0)
                {
                  int i6;
                  int i5;
                  if (i4 != 0)
                  {
                    i6 = 0;
                    if (i6 < i1)
                    {
                      int[] arrayOfInt5 = a(localBitMatrix1, 0, i6, i2, false, g, arrayOfInt4);
                      if (arrayOfInt5 != null)
                      {
                        arrayOfResultPoint3[3] = new ResultPoint(arrayOfInt5[0], i6);
                        arrayOfResultPoint3[7] = new ResultPoint(arrayOfInt5[1], i6);
                        i5 = 1;
                      }
                    }
                  }
                  while (true)
                  {
                    if (i5 != 0)
                    {
                      localObject1 = arrayOfResultPoint3;
                      if (localObject1 == null)
                        break label812;
                      a((ResultPoint[])localObject1, true);
                    }
                    for (Object localObject2 = localObject1; ; localObject2 = localObject1)
                    {
                      if (localObject2 != null)
                        break label819;
                      throw NotFoundException.getNotFoundInstance();
                      k++;
                      break;
                      i11--;
                      break label116;
                      i10++;
                      break label200;
                      i9--;
                      break label280;
                      localObject1 = null;
                      break label358;
                      i3--;
                      break label398;
                      i8++;
                      break label475;
                      i7--;
                      break label565;
                      i6++;
                      break label642;
                      localObject1 = null;
                      break label722;
                      a((ResultPoint[])localObject1, false);
                    }
                    float f1 = ((ResultPoint.distance(localObject2[0], localObject2[4]) + ResultPoint.distance(localObject2[1], localObject2[5])) / 34.0F + (ResultPoint.distance(localObject2[6], localObject2[2]) + ResultPoint.distance(localObject2[7], localObject2[3])) / 36.0F) / 2.0F;
                    if (f1 < 1.0F)
                      throw NotFoundException.getNotFoundInstance();
                    ResultPoint localResultPoint1 = localObject2[4];
                    ResultPoint localResultPoint2 = localObject2[6];
                    ResultPoint localResultPoint3 = localObject2[5];
                    ResultPoint localResultPoint4 = localObject2[7];
                    int n = 17 * ((8 + ((int)(0.5F + ResultPoint.distance(localResultPoint1, localResultPoint2) / f1) + (int)(0.5F + ResultPoint.distance(localResultPoint3, localResultPoint4) / f1) >> 1)) / 17);
                    if (n <= 0)
                      throw NotFoundException.getNotFoundInstance();
                    Object localObject3 = localObject2[4];
                    Object localObject4 = localObject2[5];
                    Object localObject5 = localObject2[6];
                    Object localObject6 = localObject2[7];
                    BitMatrix localBitMatrix2 = GridSampler.getInstance().sampleGrid(localBitMatrix1, n, n, 0.0F, 0.0F, n, 0.0F, n, n, 0.0F, n, localObject3.getX(), localObject3.getY(), localObject5.getX(), localObject5.getY(), localObject6.getX(), localObject6.getY(), localObject4.getX(), localObject4.getY());
                    ResultPoint[] arrayOfResultPoint2 = new ResultPoint[4];
                    arrayOfResultPoint2[0] = localObject2[5];
                    arrayOfResultPoint2[1] = localObject2[4];
                    arrayOfResultPoint2[2] = localObject2[6];
                    arrayOfResultPoint2[3] = localObject2[7];
                    return new DetectorResult(localBitMatrix2, arrayOfResultPoint2);
                    i5 = 0;
                    continue;
                    i5 = i4;
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.detector.Detector
 * JD-Core Version:    0.6.2
 */