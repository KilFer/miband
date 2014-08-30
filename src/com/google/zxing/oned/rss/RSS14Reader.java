package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class RSS14Reader extends AbstractRSSReader
{
  private static final int[] a = { 1, 10, 34, 70, 126 };
  private static final int[] b = { 4, 20, 48, 81 };
  private static final int[] c = { 0, 161, 961, 2015, 2715 };
  private static final int[] d = { 0, 336, 1036, 1516 };
  private static final int[] e = { 8, 6, 4, 3, 1 };
  private static final int[] f = { 2, 4, 6, 8 };
  private static final int[][] g = { { 3, 8, 2, 1 }, { 3, 5, 5, 1 }, { 3, 3, 7, 1 }, { 3, 1, 9, 1 }, { 2, 7, 4, 1 }, { 2, 5, 6, 1 }, { 2, 3, 8, 1 }, { 1, 5, 7, 1 }, { 1, 3, 9, 1 } };
  private final List<a> h = new ArrayList();
  private final List<a> i = new ArrayList();

  private static Result a(a parama1, a parama2)
  {
    String str1 = String.valueOf(4537077L * parama1.getValue() + parama2.getValue());
    StringBuilder localStringBuilder = new StringBuilder(14);
    for (int j = 13 - str1.length(); j > 0; j--)
      localStringBuilder.append('0');
    localStringBuilder.append(str1);
    int k = 0;
    int m = 0;
    while (m < 13)
    {
      int i1 = '￐' + localStringBuilder.charAt(m);
      if ((m & 0x1) == 0)
        i1 *= 3;
      int i2 = i1 + k;
      m++;
      k = i2;
    }
    int n = 10 - k % 10;
    if (n == 10)
      n = 0;
    localStringBuilder.append(n);
    ResultPoint[] arrayOfResultPoint1 = parama1.a().getResultPoints();
    ResultPoint[] arrayOfResultPoint2 = parama2.a().getResultPoints();
    String str2 = String.valueOf(localStringBuilder.toString());
    ResultPoint[] arrayOfResultPoint3 = new ResultPoint[4];
    arrayOfResultPoint3[0] = arrayOfResultPoint1[0];
    arrayOfResultPoint3[1] = arrayOfResultPoint1[1];
    arrayOfResultPoint3[2] = arrayOfResultPoint2[0];
    arrayOfResultPoint3[3] = arrayOfResultPoint2[1];
    return new Result(str2, null, arrayOfResultPoint3, BarcodeFormat.RSS_14);
  }

  private DataCharacter a(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean)
  {
    int[] arrayOfInt1 = getDataCharacterCounters();
    arrayOfInt1[0] = 0;
    arrayOfInt1[1] = 0;
    arrayOfInt1[2] = 0;
    arrayOfInt1[3] = 0;
    arrayOfInt1[4] = 0;
    arrayOfInt1[5] = 0;
    arrayOfInt1[6] = 0;
    arrayOfInt1[7] = 0;
    int n;
    label72: int[] arrayOfInt2;
    int[] arrayOfInt3;
    float[] arrayOfFloat2;
    int i1;
    label111: float f2;
    int i34;
    label146: int i35;
    if (paramBoolean)
    {
      recordPatternInReverse(paramBitArray, paramFinderPattern.getStartEnd()[0], arrayOfInt1);
      if (!paramBoolean)
        break label247;
      n = 16;
      float f1 = count(arrayOfInt1) / n;
      arrayOfInt2 = getOddCounts();
      arrayOfInt3 = getEvenCounts();
      float[] arrayOfFloat1 = getOddRoundingErrors();
      arrayOfFloat2 = getEvenRoundingErrors();
      i1 = 0;
      if (i1 >= arrayOfInt1.length)
        break label289;
      f2 = arrayOfInt1[i1] / f1;
      i34 = (int)(0.5F + f2);
      if (i34 > 0)
        break label254;
      i34 = 1;
      i35 = i1 >> 1;
      if ((i1 & 0x1) != 0)
        break label268;
      arrayOfInt2[i35] = i34;
      arrayOfFloat1[i35] = (f2 - i34);
    }
    while (true)
    {
      i1++;
      break label111;
      recordPattern(paramBitArray, 1 + paramFinderPattern.getStartEnd()[1], arrayOfInt1);
      int j = 0;
      for (int k = -1 + arrayOfInt1.length; j < k; k--)
      {
        int m = arrayOfInt1[j];
        arrayOfInt1[j] = arrayOfInt1[k];
        arrayOfInt1[k] = m;
        j++;
      }
      break;
      label247: n = 15;
      break label72;
      label254: if (i34 <= 8)
        break label146;
      i34 = 8;
      break label146;
      label268: arrayOfInt3[i35] = i34;
      arrayOfFloat2[i35] = (f2 - i34);
    }
    label289: int i2 = count(getOddCounts());
    int i3 = count(getEvenCounts());
    int i4 = i2 + i3 - n;
    int i5 = i2 & 0x1;
    int i6;
    int i7;
    label340: int i8;
    label351: int i9;
    int i10;
    int i11;
    label371: int i12;
    if (paramBoolean)
    {
      i6 = 1;
      if (i5 != i6)
        break label407;
      i7 = 1;
      if ((i3 & 0x1) != 1)
        break label413;
      i8 = 1;
      i9 = 0;
      i10 = 0;
      if (!paramBoolean)
        break label461;
      if (i2 <= 12)
        break label419;
      i11 = 1;
      if (i3 <= 12)
        break label440;
      i12 = 1;
    }
    while (true)
      if (i4 == 1)
        if (i7 != 0)
        {
          if (i8 != 0)
          {
            throw NotFoundException.getNotFoundInstance();
            i6 = 0;
            break;
            label407: i7 = 0;
            break label340;
            label413: i8 = 0;
            break label351;
            label419: i11 = 0;
            i9 = 0;
            if (i2 >= 4)
              break label371;
            i9 = 1;
            i11 = 0;
            break label371;
            label440: i12 = 0;
            i10 = 0;
            if (i3 >= 4)
              continue;
            i10 = 1;
            i12 = 0;
            continue;
            label461: if (i2 > 11)
              i11 = 1;
            while (true)
            {
              if (i3 <= 10)
                break label508;
              i12 = 1;
              i10 = 0;
              break;
              i11 = 0;
              i9 = 0;
              if (i2 < 5)
              {
                i9 = 1;
                i11 = 0;
              }
            }
            label508: i12 = 0;
            i10 = 0;
            if (i3 >= 4)
              continue;
            i10 = 1;
            i12 = 0;
            continue;
          }
          i11 = 1;
        }
    while (i9 != 0)
      if (i11 != 0)
      {
        throw NotFoundException.getNotFoundInstance();
        if (i8 == 0)
          throw NotFoundException.getNotFoundInstance();
        i12 = 1;
        continue;
        if (i4 == -1)
        {
          if (i7 != 0)
          {
            if (i8 != 0)
              throw NotFoundException.getNotFoundInstance();
            i9 = 1;
          }
          else
          {
            if (i8 == 0)
              throw NotFoundException.getNotFoundInstance();
            i10 = 1;
          }
        }
        else if (i4 == 0)
        {
          if (i7 != 0)
          {
            if (i8 == 0)
              throw NotFoundException.getNotFoundInstance();
            if (i2 < i3)
            {
              i9 = 1;
              i12 = 1;
            }
            else
            {
              i11 = 1;
              i10 = 1;
            }
          }
          else if (i8 != 0)
          {
            throw NotFoundException.getNotFoundInstance();
          }
        }
        else
          throw NotFoundException.getNotFoundInstance();
      }
      else
      {
        increment(getOddCounts(), getOddRoundingErrors());
      }
    if (i11 != 0)
      decrement(getOddCounts(), getOddRoundingErrors());
    if (i10 != 0)
    {
      if (i12 != 0)
        throw NotFoundException.getNotFoundInstance();
      increment(getEvenCounts(), getOddRoundingErrors());
    }
    if (i12 != 0)
      decrement(getEvenCounts(), getEvenRoundingErrors());
    int i13 = -1 + arrayOfInt2.length;
    int i14 = 0;
    int i33;
    for (int i15 = 0; i13 >= 0; i15 = i33)
    {
      int i32 = i14 * 9 + arrayOfInt2[i13];
      i33 = i15 + arrayOfInt2[i13];
      i13--;
      i14 = i32;
    }
    int i16 = 0;
    int i17 = 0;
    for (int i18 = -1 + arrayOfInt3.length; i18 >= 0; i18--)
    {
      i16 = i16 * 9 + arrayOfInt3[i18];
      i17 += arrayOfInt3[i18];
    }
    int i19 = i14 + i16 * 3;
    if (paramBoolean)
    {
      if (((i15 & 0x1) != 0) || (i15 > 12) || (i15 < 4))
        throw NotFoundException.getNotFoundInstance();
      int i26 = (12 - i15) / 2;
      int i27 = e[i26];
      int i28 = 9 - i27;
      int i29 = RSSUtils.getRSSvalue(arrayOfInt2, i27, false);
      int i30 = RSSUtils.getRSSvalue(arrayOfInt3, i28, true);
      int i31 = a[i26];
      return new DataCharacter(c[i26] + (i30 + i29 * i31), i19);
    }
    if (((i17 & 0x1) != 0) || (i17 > 10) || (i17 < 4))
      throw NotFoundException.getNotFoundInstance();
    int i20 = (10 - i17) / 2;
    int i21 = f[i20];
    int i22 = 9 - i21;
    int i23 = RSSUtils.getRSSvalue(arrayOfInt2, i21, true);
    int i24 = RSSUtils.getRSSvalue(arrayOfInt3, i22, false);
    int i25 = b[i20];
    return new DataCharacter(d[i20] + (i23 + i24 * i25), i19);
  }

  private FinderPattern a(BitArray paramBitArray, int paramInt, boolean paramBoolean, int[] paramArrayOfInt)
  {
    boolean bool = paramBitArray.get(paramArrayOfInt[0]);
    for (int j = -1 + paramArrayOfInt[0]; (j >= 0) && ((bool ^ paramBitArray.get(j))); j--);
    int k = j + 1;
    int m = paramArrayOfInt[0] - k;
    int[] arrayOfInt1 = getDecodeFinderCounters();
    System.arraycopy(arrayOfInt1, 0, arrayOfInt1, 1, -1 + arrayOfInt1.length);
    arrayOfInt1[0] = m;
    int n = parseFinderValue(arrayOfInt1, g);
    int i1 = paramArrayOfInt[1];
    int i2;
    if (paramBoolean)
    {
      i2 = -1 + paramBitArray.getSize() - k;
      i1 = -1 + paramBitArray.getSize() - i1;
    }
    while (true)
    {
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = k;
      arrayOfInt2[1] = paramArrayOfInt[1];
      return new FinderPattern(n, arrayOfInt2, i2, i1, paramInt);
      i2 = k;
    }
  }

  private a a(BitArray paramBitArray, boolean paramBoolean, int paramInt, Map<DecodeHintType, ?> paramMap)
  {
    int j = 0;
    try
    {
      int[] arrayOfInt1 = getDecodeFinderCounters();
      arrayOfInt1[0] = 0;
      arrayOfInt1[1] = 0;
      arrayOfInt1[2] = 0;
      arrayOfInt1[3] = 0;
      int k = paramBitArray.getSize();
      boolean bool1 = false;
      if (j < k)
        if (!paramBitArray.get(j))
          bool1 = true;
      int n;
      int i9;
      boolean bool6;
      int i7;
      int i8;
      boolean bool4;
      while (true)
      {
        int m;
        int[] arrayOfInt2;
        int i1;
        if (m < k)
        {
          if ((bool2 ^ paramBitArray.get(m)))
          {
            arrayOfInt1[n] = (1 + arrayOfInt1[n]);
            boolean bool8 = bool2;
            i9 = j;
            bool6 = bool8;
          }
          else
          {
            if (n != 3)
              break label580;
            if (isFinderPattern(arrayOfInt1))
            {
              arrayOfInt2 = new int[] { j, m };
              boolean bool3 = paramBitArray.get(arrayOfInt2[0]);
              for (i1 = -1 + arrayOfInt2[0]; (i1 >= 0) && ((bool3 ^ paramBitArray.get(i1))); i1--);
            }
            i7 = j + (arrayOfInt1[0] + arrayOfInt1[1]);
            arrayOfInt1[0] = arrayOfInt1[2];
            arrayOfInt1[1] = arrayOfInt1[3];
            arrayOfInt1[2] = 0;
            arrayOfInt1[3] = 0;
            i8 = n - 1;
            arrayOfInt1[i8] = 1;
            if (bool2)
              break label597;
            bool4 = true;
            break label561;
          }
        }
        else
        {
          throw NotFoundException.getNotFoundInstance();
          int i2 = i1 + 1;
          int i3 = arrayOfInt2[0] - i2;
          int[] arrayOfInt3 = getDecodeFinderCounters();
          System.arraycopy(arrayOfInt3, 0, arrayOfInt3, 1, -1 + arrayOfInt3.length);
          arrayOfInt3[0] = i3;
          int i4 = parseFinderValue(arrayOfInt3, g);
          int i5 = arrayOfInt2[1];
          int i6;
          if (paramBoolean)
          {
            i6 = -1 + paramBitArray.getSize() - i2;
            i5 = -1 + paramBitArray.getSize() - i5;
          }
          while (true)
          {
            int[] arrayOfInt4 = new int[2];
            arrayOfInt4[0] = i2;
            arrayOfInt4[1] = arrayOfInt2[1];
            FinderPattern localFinderPattern = new FinderPattern(i4, arrayOfInt4, i6, i5, paramInt);
            if (paramMap == null);
            ResultPointCallback localResultPointCallback;
            for (Object localObject = null; ; localObject = localResultPointCallback)
            {
              if (localObject != null)
              {
                float f1 = (arrayOfInt2[0] + arrayOfInt2[1]) / 2.0F;
                if (paramBoolean)
                  f1 = -1 + paramBitArray.getSize() - f1;
                localObject.foundPossibleResultPoint(new ResultPoint(f1, paramInt));
              }
              DataCharacter localDataCharacter1 = a(paramBitArray, localFinderPattern, true);
              DataCharacter localDataCharacter2 = a(paramBitArray, localFinderPattern, false);
              return new a(1597 * localDataCharacter1.getValue() + localDataCharacter2.getValue(), localDataCharacter1.getChecksumPortion() + 4 * localDataCharacter2.getChecksumPortion(), localFinderPattern);
              localResultPointCallback = (ResultPointCallback)paramMap.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            }
            i6 = i2;
          }
          while (true)
          {
            if (paramBoolean == bool1)
              break label529;
            j++;
            break;
            bool1 = false;
          }
          label529: m = j;
          bool2 = bool1;
          n = 0;
          continue;
        }
        label543: m++;
        boolean bool7 = bool6;
        j = i9;
        boolean bool2 = bool7;
      }
      while (true)
      {
        label561: i9 = i7;
        boolean bool5 = bool4;
        n = i8;
        bool6 = bool5;
        break label543;
        label580: int i10 = n + 1;
        i7 = j;
        i8 = i10;
        break;
        label597: bool4 = false;
      }
    }
    catch (NotFoundException localNotFoundException)
    {
    }
    return null;
  }

  private static void a(Collection<a> paramCollection, a parama)
  {
    if (parama == null);
    while (true)
    {
      return;
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (locala.getValue() == parama.getValue())
          locala.c();
      }
      for (int j = 1; j == 0; j = 0)
      {
        paramCollection.add(parama);
        return;
      }
    }
  }

  private void a(boolean paramBoolean, int paramInt)
  {
    int j = 1;
    int k = count(getOddCounts());
    int m = count(getEvenCounts());
    int n = k + m - paramInt;
    int i1 = k & 0x1;
    int i2;
    int i3;
    label52: int i4;
    label63: int i5;
    int i6;
    if (paramBoolean)
    {
      i2 = j;
      if (i1 != i2)
        break label119;
      i3 = j;
      if ((m & 0x1) != j)
        break label125;
      i4 = j;
      if (!paramBoolean)
        break label161;
      if (k <= 12)
        break label131;
      i5 = j;
      i6 = 0;
    }
    while (true)
    {
      label80: int i8;
      int i7;
      if (m > 12)
      {
        i8 = 0;
        i7 = j;
      }
      while (true)
        if (n == j)
          if (i3 != 0)
            if (i4 != 0)
            {
              throw NotFoundException.getNotFoundInstance();
              i2 = 0;
              break;
              label119: i3 = 0;
              break label52;
              label125: i4 = 0;
              break label63;
              label131: if (k >= 4)
                break label500;
              i6 = j;
              i5 = 0;
              break label80;
              if (m >= 4)
                break label482;
              i8 = j;
              i7 = 0;
              continue;
              label161: if (k > 11)
              {
                i5 = j;
                i6 = 0;
              }
            }
      while (true)
      {
        if (m > 10)
        {
          i7 = j;
          i8 = 0;
          break;
          if (k >= 5)
            break label491;
          i6 = j;
          i5 = 0;
          continue;
        }
        if (m < 4)
        {
          i8 = j;
          i7 = 0;
          break;
          int i10 = i6;
          int i13 = j;
          j = i8;
          int i9 = i13;
          while (true)
            if (i10 != 0)
            {
              if (i9 != 0)
              {
                throw NotFoundException.getNotFoundInstance();
                if (i4 == 0)
                  throw NotFoundException.getNotFoundInstance();
                i7 = j;
                j = i8;
                i9 = i5;
                i10 = i6;
                continue;
                if (n == -1)
                {
                  if (i3 != 0)
                  {
                    if (i4 != 0)
                      throw NotFoundException.getNotFoundInstance();
                    int i12 = i8;
                    i9 = i5;
                    i10 = j;
                    j = i12;
                  }
                  else
                  {
                    if (i4 == 0)
                      throw NotFoundException.getNotFoundInstance();
                    i9 = i5;
                    i10 = i6;
                  }
                }
                else if (n == 0)
                {
                  if (i3 != 0)
                  {
                    if (i4 == 0)
                      throw NotFoundException.getNotFoundInstance();
                    if (k < m)
                    {
                      i7 = j;
                      int i11 = i8;
                      i9 = i5;
                      i10 = j;
                      j = i11;
                    }
                    else
                    {
                      i9 = j;
                      i10 = i6;
                    }
                  }
                  else if (i4 != 0)
                  {
                    throw NotFoundException.getNotFoundInstance();
                  }
                }
                else
                  throw NotFoundException.getNotFoundInstance();
              }
              else
              {
                increment(getOddCounts(), getOddRoundingErrors());
              }
            }
            else
            {
              if (i9 != 0)
                decrement(getOddCounts(), getOddRoundingErrors());
              if (j != 0)
              {
                if (i7 != 0)
                  throw NotFoundException.getNotFoundInstance();
                increment(getEvenCounts(), getOddRoundingErrors());
              }
              if (i7 != 0)
                decrement(getEvenCounts(), getEvenRoundingErrors());
              return;
              j = i8;
              i9 = i5;
              i10 = i6;
            }
        }
        label482: i7 = 0;
        i8 = 0;
        break;
        label491: i5 = 0;
        i6 = 0;
      }
      label500: i5 = 0;
      i6 = 0;
    }
  }

  private int[] a(BitArray paramBitArray, int paramInt, boolean paramBoolean)
  {
    int[] arrayOfInt = getDecodeFinderCounters();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int j = paramBitArray.getSize();
    boolean bool1 = false;
    int k = paramInt;
    if (k < j)
    {
      if (!paramBitArray.get(k));
      for (bool1 = true; ; bool1 = false)
      {
        if (paramBoolean == bool1)
          break label75;
        k++;
        break;
      }
    }
    label75: boolean bool2 = bool1;
    int m = k;
    int n = k;
    int i1 = 0;
    if (m < j)
    {
      if ((bool2 ^ paramBitArray.get(m)))
        arrayOfInt[i1] = (1 + arrayOfInt[i1]);
      while (true)
      {
        m++;
        break;
        if (i1 == 3)
        {
          if (isFinderPattern(arrayOfInt))
            return new int[] { n, m };
          n += arrayOfInt[0] + arrayOfInt[1];
          arrayOfInt[0] = arrayOfInt[2];
          arrayOfInt[1] = arrayOfInt[3];
          arrayOfInt[2] = 0;
          arrayOfInt[3] = 0;
          i1--;
        }
        while (true)
        {
          arrayOfInt[i1] = 1;
          if (bool2)
            break label221;
          bool2 = true;
          break;
          i1++;
        }
        label221: bool2 = false;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }

  private static boolean b(a parama1, a parama2)
  {
    parama1.a().getValue();
    parama2.a().getValue();
    int j = (parama1.getChecksumPortion() + 16 * parama2.getChecksumPortion()) % 79;
    int k = 9 * parama1.a().getValue() + parama2.a().getValue();
    if (k > 72)
      k--;
    if (k > 8)
      k--;
    return j == k;
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    a locala1 = a(paramBitArray, false, paramInt, paramMap);
    a(this.h, locala1);
    paramBitArray.reverse();
    a locala2 = a(paramBitArray, true, paramInt, paramMap);
    a(this.i, locala2);
    paramBitArray.reverse();
    Iterator localIterator1 = this.h.iterator();
    break label99;
    label57: a locala3;
    do
    {
      if (!localIterator1.hasNext())
        break;
      locala3 = (a)localIterator1.next();
    }
    while (locala3.b() <= 1);
    Iterator localIterator2 = this.i.iterator();
    label99: a locala4;
    String str1;
    StringBuilder localStringBuilder;
    while (true)
    {
      if (!localIterator2.hasNext())
        break label57;
      locala4 = (a)localIterator2.next();
      if (locala4.b() <= 1)
        break;
      locala3.a().getValue();
      locala4.a().getValue();
      int j = (locala3.getChecksumPortion() + 16 * locala4.getChecksumPortion()) % 79;
      int k = 9 * locala3.a().getValue() + locala4.a().getValue();
      if (k > 72)
        k--;
      if (k > 8)
        k--;
      if (j == k);
      for (int m = 1; m != 0; m = 0)
      {
        str1 = String.valueOf(4537077L * locala3.getValue() + locala4.getValue());
        localStringBuilder = new StringBuilder(14);
        for (int n = 13 - str1.length(); n > 0; n--)
          localStringBuilder.append('0');
      }
    }
    localStringBuilder.append(str1);
    int i1 = 0;
    int i2 = 0;
    while (i1 < 13)
    {
      int i4 = '￐' + localStringBuilder.charAt(i1);
      if ((i1 & 0x1) == 0)
        i4 *= 3;
      i2 += i4;
      i1++;
    }
    int i3 = 10 - i2 % 10;
    if (i3 == 10)
      i3 = 0;
    localStringBuilder.append(i3);
    ResultPoint[] arrayOfResultPoint1 = locala3.a().getResultPoints();
    ResultPoint[] arrayOfResultPoint2 = locala4.a().getResultPoints();
    String str2 = String.valueOf(localStringBuilder.toString());
    ResultPoint[] arrayOfResultPoint3 = new ResultPoint[4];
    arrayOfResultPoint3[0] = arrayOfResultPoint1[0];
    arrayOfResultPoint3[1] = arrayOfResultPoint1[1];
    arrayOfResultPoint3[2] = arrayOfResultPoint2[0];
    arrayOfResultPoint3[3] = arrayOfResultPoint2[1];
    return new Result(str2, null, arrayOfResultPoint3, BarcodeFormat.RSS_14);
    throw NotFoundException.getNotFoundInstance();
  }

  public final void reset()
  {
    this.h.clear();
    this.i.clear();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.RSS14Reader
 * JD-Core Version:    0.6.2
 */