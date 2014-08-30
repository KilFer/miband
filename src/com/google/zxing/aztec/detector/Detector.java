package com.google.zxing.aztec.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.aztec.AztecDetectorResult;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.detector.WhiteRectangleDetector;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

public final class Detector
{
  private final BitMatrix a;
  private boolean b;
  private int c;
  private int d;
  private int e;
  private int f;

  public Detector(BitMatrix paramBitMatrix)
  {
    this.a = paramBitMatrix;
  }

  private static int a(float paramFloat)
  {
    return (int)(0.5F + paramFloat);
  }

  private int a(a parama1, a parama2)
  {
    float f1 = b(parama1, parama2);
    float f2 = (parama2.a - parama1.a) / f1;
    float f3 = (parama2.b - parama1.b) / f1;
    float f4 = parama1.a;
    float f5 = parama1.b;
    boolean bool = this.a.get(parama1.a, parama1.b);
    int i = 0;
    float f6 = f4;
    float f7 = f5;
    for (int j = 0; j < f1; j++)
    {
      f6 += f2;
      f7 += f3;
      if (this.a.get((int)(0.5F + f6), (int)(0.5F + f7)) != bool)
        i++;
    }
    float f8 = i / f1;
    if ((f8 > 0.1D) && (f8 < 0.9D))
      return 0;
    if (f8 <= 0.1D)
    {
      if (bool)
        return 1;
      return -1;
    }
    if (bool)
      return -1;
    return 1;
  }

  private a a()
  {
    try
    {
      ResultPoint[] arrayOfResultPoint2 = new WhiteRectangleDetector(this.a).detect();
      localResultPoint1 = arrayOfResultPoint2[0];
      localResultPoint2 = arrayOfResultPoint2[1];
      localResultPoint3 = arrayOfResultPoint2[2];
      localResultPoint4 = arrayOfResultPoint2[3];
      k = (int)(0.5F + (localResultPoint1.getX() + localResultPoint4.getX() + localResultPoint2.getX() + localResultPoint3.getX()) / 4.0F);
      m = (int)(0.5F + (localResultPoint1.getY() + localResultPoint4.getY() + localResultPoint2.getY() + localResultPoint3.getY()) / 4.0F);
    }
    catch (NotFoundException localNotFoundException1)
    {
      try
      {
        ResultPoint[] arrayOfResultPoint1 = new WhiteRectangleDetector(this.a, 15, k, m).detect();
        localResultPoint5 = arrayOfResultPoint1[0];
        localResultPoint6 = arrayOfResultPoint1[1];
        localResultPoint7 = arrayOfResultPoint1[2];
        localResultPoint8 = arrayOfResultPoint1[3];
        return new a((int)(0.5F + (localResultPoint5.getX() + localResultPoint8.getX() + localResultPoint6.getX() + localResultPoint7.getX()) / 4.0F), (int)(0.5F + (localResultPoint5.getY() + localResultPoint8.getY() + localResultPoint6.getY() + localResultPoint7.getY()) / 4.0F), (byte)0);
        localNotFoundException1 = localNotFoundException1;
        int i = this.a.getWidth() / 2;
        int j = this.a.getHeight() / 2;
        ResultPoint localResultPoint1 = a(new a(i + 7, j - 7, (byte)0), false, 1, -1).a();
        ResultPoint localResultPoint2 = a(new a(i + 7, j + 7, (byte)0), false, 1, 1).a();
        ResultPoint localResultPoint3 = a(new a(i - 7, j + 7, (byte)0), false, -1, 1).a();
        ResultPoint localResultPoint4 = a(new a(i - 7, j - 7, (byte)0), false, -1, -1).a();
      }
      catch (NotFoundException localNotFoundException2)
      {
        while (true)
        {
          int k;
          int m;
          ResultPoint localResultPoint5 = a(new a(k + 7, m - 7, (byte)0), false, 1, -1).a();
          ResultPoint localResultPoint6 = a(new a(k + 7, m + 7, (byte)0), false, 1, 1).a();
          ResultPoint localResultPoint7 = a(new a(k - 7, m + 7, (byte)0), false, -1, 1).a();
          ResultPoint localResultPoint8 = a(new a(k - 7, m - 7, (byte)0), false, -1, -1).a();
        }
      }
    }
  }

  private a a(a parama, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + parama.a;
    int j = paramInt2 + parama.b;
    while ((a(i, j)) && (this.a.get(i, j) == paramBoolean))
    {
      i += paramInt1;
      j += paramInt2;
    }
    int k = i - paramInt1;
    int m = j - paramInt2;
    while ((a(k, m)) && (this.a.get(k, m) == paramBoolean))
      k += paramInt1;
    int n = k - paramInt1;
    int i1 = m;
    while ((a(n, i1)) && (this.a.get(n, i1) == paramBoolean))
      i1 += paramInt2;
    return new a(n, i1 - paramInt2, (byte)0);
  }

  private BitMatrix a(BitMatrix paramBitMatrix, ResultPoint paramResultPoint1, ResultPoint paramResultPoint2, ResultPoint paramResultPoint3, ResultPoint paramResultPoint4)
  {
    int i;
    if (this.b)
      i = 11 + 4 * this.c;
    while (true)
    {
      GridSampler localGridSampler = GridSampler.getInstance();
      float f1 = i - 0.5F;
      float f2 = i - 0.5F;
      float f3 = i - 0.5F;
      float f4 = i - 0.5F;
      float f5 = paramResultPoint1.getX();
      float f6 = paramResultPoint1.getY();
      float f7 = paramResultPoint4.getX();
      float f8 = paramResultPoint4.getY();
      float f9 = paramResultPoint3.getX();
      float f10 = paramResultPoint3.getY();
      float f11 = paramResultPoint2.getX();
      float f12 = paramResultPoint2.getY();
      return localGridSampler.sampleGrid(paramBitMatrix, i, i, 0.5F, 0.5F, f1, 0.5F, f2, f3, 0.5F, f4, f5, f6, f7, f8, f9, f10, f11, f12);
      if (this.c <= 4)
        i = 15 + 4 * this.c;
      else
        i = 15 + (4 * this.c + 2 * (1 + (-4 + this.c) / 8));
    }
  }

  private void a(a[] paramArrayOfa)
  {
    int i = 2;
    int j = 0;
    boolean[] arrayOfBoolean1 = a(paramArrayOfa[0], paramArrayOfa[1], 1 + 2 * this.e);
    boolean[] arrayOfBoolean2 = a(paramArrayOfa[1], paramArrayOfa[i], 1 + 2 * this.e);
    boolean[] arrayOfBoolean3 = a(paramArrayOfa[i], paramArrayOfa[3], 1 + 2 * this.e);
    boolean[] arrayOfBoolean4 = a(paramArrayOfa[3], paramArrayOfa[0], 1 + 2 * this.e);
    if ((arrayOfBoolean1[0] != 0) && (arrayOfBoolean1[(2 * this.e)] != 0))
      this.f = 0;
    while (this.b)
    {
      boolean[] arrayOfBoolean7 = new boolean[28];
      int i13 = 0;
      while (true)
        if (i13 < 7)
        {
          arrayOfBoolean7[i13] = arrayOfBoolean1[(i13 + 2)];
          arrayOfBoolean7[(i13 + 7)] = arrayOfBoolean2[(i13 + 2)];
          arrayOfBoolean7[(i13 + 14)] = arrayOfBoolean3[(i13 + 2)];
          arrayOfBoolean7[(i13 + 21)] = arrayOfBoolean4[(i13 + 2)];
          i13++;
          continue;
          if ((arrayOfBoolean2[0] != 0) && (arrayOfBoolean2[(2 * this.e)] != 0))
          {
            this.f = 1;
            break;
          }
          if ((arrayOfBoolean3[0] != 0) && (arrayOfBoolean3[(2 * this.e)] != 0))
          {
            this.f = i;
            break;
          }
          if ((arrayOfBoolean4[0] != 0) && (arrayOfBoolean4[(2 * this.e)] != 0))
          {
            this.f = 3;
            break;
          }
          throw NotFoundException.getNotFoundInstance();
        }
      arrayOfBoolean6 = new boolean[28];
      for (int i14 = 0; i14 < 28; i14++)
        arrayOfBoolean6[i14] = arrayOfBoolean7[((i14 + 7 * this.f) % 28)];
    }
    boolean[] arrayOfBoolean5 = new boolean[40];
    for (int k = 0; k < 11; k++)
    {
      if (k < 5)
      {
        arrayOfBoolean5[k] = arrayOfBoolean1[(k + 2)];
        arrayOfBoolean5[(k + 10)] = arrayOfBoolean2[(k + 2)];
        arrayOfBoolean5[(k + 20)] = arrayOfBoolean3[(k + 2)];
        arrayOfBoolean5[(k + 30)] = arrayOfBoolean4[(k + 2)];
      }
      if (k > 5)
      {
        arrayOfBoolean5[(k - 1)] = arrayOfBoolean1[(k + 2)];
        arrayOfBoolean5[(-1 + (k + 10))] = arrayOfBoolean2[(k + 2)];
        arrayOfBoolean5[(-1 + (k + 20))] = arrayOfBoolean3[(k + 2)];
        arrayOfBoolean5[(-1 + (k + 30))] = arrayOfBoolean4[(k + 2)];
      }
    }
    boolean[] arrayOfBoolean6 = new boolean[40];
    for (int m = 0; m < 40; m++)
      arrayOfBoolean6[m] = arrayOfBoolean5[((m + 10 * this.f) % 40)];
    int n;
    int i1;
    int i2;
    int[] arrayOfInt;
    if (this.b)
    {
      n = 7;
      i1 = i;
      i2 = n - i1;
      arrayOfInt = new int[n];
    }
    for (int i3 = 0; ; i3++)
    {
      if (i3 >= n)
        break label626;
      int i11 = 1;
      int i12 = 1;
      while (true)
        if (i11 <= 4)
        {
          if (arrayOfBoolean6[(4 + i3 * 4 - i11)] != 0)
            arrayOfInt[i3] = (i12 + arrayOfInt[i3]);
          i12 <<= 1;
          i11++;
          continue;
          n = 10;
          i1 = 4;
          break;
        }
    }
    while (true)
    {
      label626: int i4;
      try
      {
        new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(arrayOfInt, i2);
        i4 = 0;
        if (i4 >= i1)
          break;
        int i7 = 1;
        int i8 = 1;
        if (i7 > 4)
          break label723;
        int i9 = 4 + (i4 << 2) - i7;
        if ((i8 & arrayOfInt[i4]) == i8)
        {
          i10 = 1;
          arrayOfBoolean6[i9] = i10;
          i8 <<= 1;
          i7++;
          continue;
        }
      }
      catch (ReedSolomonException localReedSolomonException)
      {
        throw NotFoundException.getNotFoundInstance();
      }
      int i10 = 0;
      continue;
      label723: i4++;
    }
    int i5;
    if (this.b)
      i5 = 6;
    while (j < i)
    {
      this.c <<= 1;
      if (arrayOfBoolean6[j] != 0)
        this.c = (1 + this.c);
      j++;
      continue;
      i = 5;
      i5 = 11;
      j = 0;
    }
    for (int i6 = i; i6 < i + i5; i6++)
    {
      this.d <<= 1;
      if (arrayOfBoolean6[i6] != 0)
        this.d = (1 + this.d);
    }
    this.c = (1 + this.c);
    this.d = (1 + this.d);
  }

  private void a(boolean[] paramArrayOfBoolean)
  {
    int i;
    if (this.b)
      i = 2;
    for (int j = 6; ; j = 11)
    {
      for (int k = 0; k < i; k++)
      {
        this.c <<= 1;
        if (paramArrayOfBoolean[k] != 0)
          this.c = (1 + this.c);
      }
      i = 5;
    }
    for (int m = i; m < i + j; m++)
    {
      this.d <<= 1;
      if (paramArrayOfBoolean[m] != 0)
        this.d = (1 + this.d);
    }
    this.c = (1 + this.c);
    this.d = (1 + this.d);
  }

  private static void a(boolean[] paramArrayOfBoolean, boolean paramBoolean)
  {
    int i;
    int j;
    int k;
    int[] arrayOfInt;
    if (paramBoolean)
    {
      i = 7;
      j = 2;
      k = i - j;
      arrayOfInt = new int[i];
    }
    for (int m = 0; ; m++)
    {
      if (m >= i)
        break label93;
      int i5 = 1;
      int i6 = 1;
      while (true)
        if (i5 <= 4)
        {
          if (paramArrayOfBoolean[(4 + m * 4 - i5)] != 0)
            arrayOfInt[m] = (i6 + arrayOfInt[m]);
          i6 <<= 1;
          i5++;
          continue;
          i = 10;
          j = 4;
          break;
        }
    }
    while (true)
    {
      label93: int n;
      try
      {
        new ReedSolomonDecoder(GenericGF.AZTEC_PARAM).decode(arrayOfInt, k);
        n = 0;
        if (n >= j)
          break;
        int i1 = 1;
        int i2 = 1;
        if (i1 > 4)
          break label188;
        int i3 = 4 + (n << 2) - i1;
        if ((i2 & arrayOfInt[n]) == i2)
        {
          i4 = 1;
          paramArrayOfBoolean[i3] = i4;
          i2 <<= 1;
          i1++;
          continue;
        }
      }
      catch (ReedSolomonException localReedSolomonException)
      {
        throw NotFoundException.getNotFoundInstance();
      }
      int i4 = 0;
      continue;
      label188: n++;
    }
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 >= 0) && (paramInt1 < this.a.getWidth()) && (paramInt2 > 0) && (paramInt2 < this.a.getHeight());
  }

  private boolean a(a parama1, a parama2, a parama3, a parama4)
  {
    a locala1 = new a(-3 + parama1.a, 3 + parama1.b, (byte)0);
    a locala2 = new a(-3 + parama2.a, -3 + parama2.b, (byte)0);
    a locala3 = new a(3 + parama3.a, -3 + parama3.b, (byte)0);
    a locala4 = new a(3 + parama4.a, 3 + parama4.b, (byte)0);
    int i = a(locala4, locala1);
    if (i == 0);
    while ((a(locala1, locala2) != i) || (a(locala2, locala3) != i) || (a(locala3, locala4) != i))
      return false;
    return true;
  }

  private a[] a(a parama)
  {
    boolean bool1 = true;
    this.e = 1;
    Object localObject1 = parama;
    Object localObject2 = parama;
    Object localObject3 = parama;
    if (this.e < 9)
    {
      a locala1 = a((a)localObject2, bool1, 1, -1);
      a locala2 = a((a)localObject1, bool1, 1, 1);
      a locala3 = a(parama, bool1, -1, 1);
      a locala4 = a((a)localObject3, bool1, -1, -1);
      int i9;
      if (this.e > 2)
      {
        float f2 = b(locala4, locala1) * this.e / (b((a)localObject3, (a)localObject2) * (2 + this.e));
        if ((f2 < 0.75D) || (f2 > 1.25D))
          break label331;
        a locala5 = new a(-3 + locala1.a, 3 + locala1.b, (byte)0);
        a locala6 = new a(-3 + locala2.a, -3 + locala2.b, (byte)0);
        a locala7 = new a(3 + locala3.a, -3 + locala3.b, (byte)0);
        a locala8 = new a(3 + locala4.a, 3 + locala4.b, (byte)0);
        int i8 = a(locala8, locala5);
        if ((i8 != 0) && (a(locala5, locala6) == i8) && (a(locala6, locala7) == i8) && (a(locala7, locala8) == i8))
        {
          i9 = 1;
          label282: if (i9 == 0)
            break label331;
        }
      }
      else
      {
        if (bool1)
          break label326;
      }
      label326: for (bool1 = true; ; bool1 = false)
      {
        this.e = (1 + this.e);
        parama = locala3;
        localObject1 = locala2;
        localObject2 = locala1;
        localObject3 = locala4;
        break;
        i9 = 0;
        break label282;
      }
    }
    label331: if ((this.e != 5) && (this.e != 7))
      throw NotFoundException.getNotFoundInstance();
    if (this.e == 5);
    int k;
    int m;
    int n;
    int i1;
    int i4;
    int i5;
    int i6;
    int i7;
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.b = bool2;
      float f1 = 1.5F / (-3 + 2 * this.e);
      int i = ((a)localObject2).a - parama.a;
      int j = ((a)localObject2).b - parama.b;
      k = (int)(0.5F + (parama.a - f1 * i));
      m = (int)(0.5F + (parama.b - f1 * j));
      n = (int)(0.5F + (((a)localObject2).a + f1 * i));
      i1 = (int)(0.5F + (((a)localObject2).b + f1 * j));
      int i2 = ((a)localObject1).a - ((a)localObject3).a;
      int i3 = ((a)localObject1).b - ((a)localObject3).b;
      i4 = (int)(0.5F + (((a)localObject3).a - f1 * i2));
      i5 = (int)(0.5F + (((a)localObject3).b - f1 * i3));
      i6 = (int)(0.5F + (((a)localObject1).a + f1 * i2));
      i7 = (int)(0.5F + (((a)localObject1).b + f1 * i3));
      if ((a(n, i1)) && (a(i6, i7)) && (a(k, m)) && (a(i4, i5)))
        break;
      throw NotFoundException.getNotFoundInstance();
    }
    return new a[] { new a(n, i1, 0), new a(i6, i7, 0), new a(k, m, 0), new a(i4, i5, 0) };
  }

  private boolean[] a(a parama1, a parama2, int paramInt)
  {
    boolean[] arrayOfBoolean = new boolean[paramInt];
    float f1 = b(parama1, parama2);
    float f2 = f1 / (paramInt - 1);
    float f3 = f2 * (parama2.a - parama1.a) / f1;
    float f4 = f2 * (parama2.b - parama1.b) / f1;
    float f5 = parama1.a;
    float f6 = parama1.b;
    for (int i = 0; i < paramInt; i++)
    {
      arrayOfBoolean[i] = this.a.get((int)(f5 + 0.5F), (int)(f6 + 0.5F));
      f5 += f3;
      f6 += f4;
    }
    return arrayOfBoolean;
  }

  private static float b(a parama1, a parama2)
  {
    return (float)Math.sqrt((parama1.a - parama2.a) * (parama1.a - parama2.a) + (parama1.b - parama2.b) * (parama1.b - parama2.b));
  }

  private ResultPoint[] b(a[] paramArrayOfa)
  {
    int i = 2 * this.c;
    int j;
    float f1;
    int m;
    label65: int i2;
    label95: int i4;
    int i5;
    int i6;
    int i7;
    int i9;
    label205: int i10;
    int i11;
    if (this.c > 4)
    {
      j = 1;
      f1 = (j + i + (-4 + this.c) / 8) / (2.0F * this.e);
      int k = paramArrayOfa[0].a - paramArrayOfa[2].a;
      if (k <= 0)
        break label375;
      m = 1;
      int n = k + m;
      int i1 = paramArrayOfa[0].b - paramArrayOfa[2].b;
      if (i1 <= 0)
        break label381;
      i2 = 1;
      int i3 = i2 + i1;
      i4 = (int)(0.5F + (paramArrayOfa[2].a - f1 * n));
      i5 = (int)(0.5F + (paramArrayOfa[2].b - f1 * i3));
      i6 = (int)(0.5F + (paramArrayOfa[0].a + f1 * n));
      i7 = (int)(0.5F + (paramArrayOfa[0].b + f1 * i3));
      int i8 = paramArrayOfa[1].a - paramArrayOfa[3].a;
      if (i8 <= 0)
        break label387;
      i9 = 1;
      i10 = i8 + i9;
      i11 = paramArrayOfa[1].b - paramArrayOfa[3].b;
      if (i11 <= 0)
        break label393;
    }
    int i14;
    int i15;
    int i16;
    int i17;
    label387: label393: for (int i12 = 1; ; i12 = -1)
    {
      int i13 = i12 + i11;
      i14 = (int)(0.5F + (paramArrayOfa[3].a - f1 * i10));
      i15 = (int)(0.5F + (paramArrayOfa[3].b - f1 * i13));
      i16 = (int)(0.5F + (paramArrayOfa[1].a + f1 * i10));
      i17 = (int)(0.5F + (paramArrayOfa[1].b + f1 * i13));
      if ((a(i6, i7)) && (a(i16, i17)) && (a(i4, i5)) && (a(i14, i15)))
        break label399;
      throw NotFoundException.getNotFoundInstance();
      j = 0;
      break;
      label375: m = -1;
      break label65;
      label381: i2 = -1;
      break label95;
      i9 = -1;
      break label205;
    }
    label399: ResultPoint[] arrayOfResultPoint = new ResultPoint[4];
    arrayOfResultPoint[0] = new ResultPoint(i6, i7);
    arrayOfResultPoint[1] = new ResultPoint(i16, i17);
    arrayOfResultPoint[2] = new ResultPoint(i4, i5);
    arrayOfResultPoint[3] = new ResultPoint(i14, i15);
    return arrayOfResultPoint;
  }

  public final AztecDetectorResult detect()
  {
    Object localObject1 = a();
    boolean bool1 = true;
    this.e = 1;
    Object localObject2 = localObject1;
    Object localObject3 = localObject1;
    Object localObject4 = localObject1;
    if (this.e < 9)
    {
      a locala1 = a(localObject4, bool1, 1, -1);
      a locala2 = a(localObject3, bool1, 1, 1);
      a locala3 = a(localObject2, bool1, -1, 1);
      a locala4 = a((a)localObject1, bool1, -1, -1);
      int i40;
      if (this.e > 2)
      {
        float f15 = b(locala4, locala1) * this.e / (b((a)localObject1, localObject4) * (2 + this.e));
        if ((f15 < 0.75D) || (f15 > 1.25D))
          break label335;
        a locala5 = new a(-3 + locala1.a, 3 + locala1.b, (byte)0);
        a locala6 = new a(-3 + locala2.a, -3 + locala2.b, (byte)0);
        a locala7 = new a(3 + locala3.a, -3 + locala3.b, (byte)0);
        a locala8 = new a(3 + locala4.a, 3 + locala4.b, (byte)0);
        int i39 = a(locala8, locala5);
        if ((i39 != 0) && (a(locala5, locala6) == i39) && (a(locala6, locala7) == i39) && (a(locala7, locala8) == i39))
        {
          i40 = 1;
          label286: if (i40 == 0)
            break label335;
        }
      }
      else
      {
        if (bool1)
          break label330;
      }
      label330: for (bool1 = true; ; bool1 = false)
      {
        this.e = (1 + this.e);
        localObject1 = locala4;
        localObject2 = locala3;
        localObject3 = locala2;
        localObject4 = locala1;
        break;
        i40 = 0;
        break label286;
      }
    }
    label335: if ((this.e != 5) && (this.e != 7))
      throw NotFoundException.getNotFoundInstance();
    if (this.e == 5);
    int k;
    int m;
    int n;
    int i1;
    int i4;
    int i5;
    int i6;
    int i7;
    for (boolean bool2 = true; ; bool2 = false)
    {
      this.b = bool2;
      float f1 = 1.5F / (-3 + 2 * this.e);
      int i = localObject4.a - localObject2.a;
      int j = localObject4.b - localObject2.b;
      k = (int)(0.5F + (localObject2.a - f1 * i));
      m = (int)(0.5F + (localObject2.b - f1 * j));
      n = (int)(0.5F + (localObject4.a + f1 * i));
      i1 = (int)(0.5F + (localObject4.b + f1 * j));
      int i2 = localObject3.a - ((a)localObject1).a;
      int i3 = localObject3.b - ((a)localObject1).b;
      i4 = (int)(0.5F + (((a)localObject1).a - f1 * i2));
      i5 = (int)(0.5F + (((a)localObject1).b - f1 * i3));
      i6 = (int)(0.5F + (localObject3.a + f1 * i2));
      i7 = (int)(0.5F + (localObject3.b + f1 * i3));
      if ((a(n, i1)) && (a(i6, i7)) && (a(k, m)) && (a(i4, i5)))
        break;
      throw NotFoundException.getNotFoundInstance();
    }
    a[] arrayOfa = { new a(n, i1, 0), new a(i6, i7, 0), new a(k, m, 0), new a(i4, i5, 0) };
    boolean[] arrayOfBoolean1 = a(arrayOfa[0], arrayOfa[1], 1 + 2 * this.e);
    boolean[] arrayOfBoolean2 = a(arrayOfa[1], arrayOfa[2], 1 + 2 * this.e);
    boolean[] arrayOfBoolean3 = a(arrayOfa[2], arrayOfa[3], 1 + 2 * this.e);
    boolean[] arrayOfBoolean4 = a(arrayOfa[3], arrayOfa[0], 1 + 2 * this.e);
    if ((arrayOfBoolean1[0] != 0) && (arrayOfBoolean1[(2 * this.e)] != 0))
      this.f = 0;
    while (this.b)
    {
      boolean[] arrayOfBoolean7 = new boolean[28];
      int i37 = 0;
      while (true)
        if (i37 < 7)
        {
          arrayOfBoolean7[i37] = arrayOfBoolean1[(i37 + 2)];
          arrayOfBoolean7[(i37 + 7)] = arrayOfBoolean2[(i37 + 2)];
          arrayOfBoolean7[(i37 + 14)] = arrayOfBoolean3[(i37 + 2)];
          arrayOfBoolean7[(i37 + 21)] = arrayOfBoolean4[(i37 + 2)];
          i37++;
          continue;
          if ((arrayOfBoolean2[0] != 0) && (arrayOfBoolean2[(2 * this.e)] != 0))
          {
            this.f = 1;
            break;
          }
          if ((arrayOfBoolean3[0] != 0) && (arrayOfBoolean3[(2 * this.e)] != 0))
          {
            this.f = 2;
            break;
          }
          if ((arrayOfBoolean4[0] != 0) && (arrayOfBoolean4[(2 * this.e)] != 0))
          {
            this.f = 3;
            break;
          }
          throw NotFoundException.getNotFoundInstance();
        }
      arrayOfBoolean6 = new boolean[28];
      for (int i38 = 0; i38 < 28; i38++)
        arrayOfBoolean6[i38] = arrayOfBoolean7[((i38 + 7 * this.f) % 28)];
    }
    boolean[] arrayOfBoolean5 = new boolean[40];
    for (int i8 = 0; i8 < 11; i8++)
    {
      if (i8 < 5)
      {
        arrayOfBoolean5[i8] = arrayOfBoolean1[(i8 + 2)];
        arrayOfBoolean5[(i8 + 10)] = arrayOfBoolean2[(i8 + 2)];
        arrayOfBoolean5[(i8 + 20)] = arrayOfBoolean3[(i8 + 2)];
        arrayOfBoolean5[(i8 + 30)] = arrayOfBoolean4[(i8 + 2)];
      }
      if (i8 > 5)
      {
        arrayOfBoolean5[(i8 - 1)] = arrayOfBoolean1[(i8 + 2)];
        arrayOfBoolean5[(-1 + (i8 + 10))] = arrayOfBoolean2[(i8 + 2)];
        arrayOfBoolean5[(-1 + (i8 + 20))] = arrayOfBoolean3[(i8 + 2)];
        arrayOfBoolean5[(-1 + (i8 + 30))] = arrayOfBoolean4[(i8 + 2)];
      }
    }
    boolean[] arrayOfBoolean6 = new boolean[40];
    for (int i9 = 0; i9 < 40; i9++)
      arrayOfBoolean6[i9] = arrayOfBoolean5[((i9 + 10 * this.f) % 40)];
    a(arrayOfBoolean6, this.b);
    int i10;
    if (this.b)
      i10 = 2;
    for (int i11 = 6; ; i11 = 11)
    {
      for (int i12 = 0; i12 < i10; i12++)
      {
        this.c <<= 1;
        if (arrayOfBoolean6[i12] != 0)
          this.c = (1 + this.c);
      }
      i10 = 5;
    }
    for (int i13 = i10; i13 < i10 + i11; i13++)
    {
      this.d <<= 1;
      if (arrayOfBoolean6[i13] != 0)
        this.d = (1 + this.d);
    }
    this.c = (1 + this.c);
    this.d = (1 + this.d);
    int i14 = 2 * this.c;
    int i15;
    float f2;
    int i17;
    label1445: int i20;
    label1477: int i22;
    int i23;
    int i24;
    int i25;
    int i27;
    label1593: int i28;
    int i29;
    if (this.c > 4)
    {
      i15 = 1;
      f2 = (i15 + i14 + (-4 + this.c) / 8) / (2.0F * this.e);
      int i16 = arrayOfa[0].a - arrayOfa[2].a;
      if (i16 <= 0)
        break label1770;
      i17 = 1;
      int i18 = i16 + i17;
      int i19 = arrayOfa[0].b - arrayOfa[2].b;
      if (i19 <= 0)
        break label1776;
      i20 = 1;
      int i21 = i20 + i19;
      i22 = (int)(0.5F + (arrayOfa[2].a - f2 * i18));
      i23 = (int)(0.5F + (arrayOfa[2].b - f2 * i21));
      i24 = (int)(0.5F + (arrayOfa[0].a + f2 * i18));
      i25 = (int)(0.5F + (arrayOfa[0].b + f2 * i21));
      int i26 = arrayOfa[1].a - arrayOfa[3].a;
      if (i26 <= 0)
        break label1782;
      i27 = 1;
      i28 = i26 + i27;
      i29 = arrayOfa[1].b - arrayOfa[3].b;
      if (i29 <= 0)
        break label1788;
    }
    int i32;
    int i33;
    int i34;
    int i35;
    label1770: label1776: label1782: label1788: for (int i30 = 1; ; i30 = -1)
    {
      int i31 = i30 + i29;
      i32 = (int)(0.5F + (arrayOfa[3].a - f2 * i28));
      i33 = (int)(0.5F + (arrayOfa[3].b - f2 * i31));
      i34 = (int)(0.5F + (arrayOfa[1].a + f2 * i28));
      i35 = (int)(0.5F + (arrayOfa[1].b + f2 * i31));
      if ((a(i24, i25)) && (a(i34, i35)) && (a(i22, i23)) && (a(i32, i33)))
        break label1794;
      throw NotFoundException.getNotFoundInstance();
      i15 = 0;
      break;
      i17 = -1;
      break label1445;
      i20 = -1;
      break label1477;
      i27 = -1;
      break label1593;
    }
    label1794: ResultPoint[] arrayOfResultPoint = new ResultPoint[4];
    arrayOfResultPoint[0] = new ResultPoint(i24, i25);
    arrayOfResultPoint[1] = new ResultPoint(i34, i35);
    arrayOfResultPoint[2] = new ResultPoint(i22, i23);
    arrayOfResultPoint[3] = new ResultPoint(i32, i33);
    BitMatrix localBitMatrix = this.a;
    ResultPoint localResultPoint1 = arrayOfResultPoint[(this.f % 4)];
    ResultPoint localResultPoint2 = arrayOfResultPoint[((3 + this.f) % 4)];
    ResultPoint localResultPoint3 = arrayOfResultPoint[((2 + this.f) % 4)];
    ResultPoint localResultPoint4 = arrayOfResultPoint[((1 + this.f) % 4)];
    int i36;
    if (this.b)
      i36 = 11 + 4 * this.c;
    while (true)
    {
      GridSampler localGridSampler = GridSampler.getInstance();
      float f3 = i36 - 0.5F;
      float f4 = i36 - 0.5F;
      float f5 = i36 - 0.5F;
      float f6 = i36 - 0.5F;
      float f7 = localResultPoint1.getX();
      float f8 = localResultPoint1.getY();
      float f9 = localResultPoint4.getX();
      float f10 = localResultPoint4.getY();
      float f11 = localResultPoint3.getX();
      float f12 = localResultPoint3.getY();
      float f13 = localResultPoint2.getX();
      float f14 = localResultPoint2.getY();
      return new AztecDetectorResult(localGridSampler.sampleGrid(localBitMatrix, i36, i36, 0.5F, 0.5F, f3, 0.5F, f4, f5, 0.5F, f6, f7, f8, f9, f10, f11, f12, f13, f14), arrayOfResultPoint, this.b, this.d, this.c);
      if (this.c <= 4)
        i36 = 15 + 4 * this.c;
      else
        i36 = 15 + (4 * this.c + 2 * (1 + (-4 + this.c) / 8));
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.aztec.detector.Detector
 * JD-Core Version:    0.6.2
 */