package com.google.zxing.oned.rss.expanded;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class RSSExpandedReader extends AbstractRSSReader
{
  private static final int[] a = { 7, 5, 4, 3, 1 };
  private static final int[] b = { 4, 20, 52, 104, 204 };
  private static final int[] c = { 0, 348, 1388, 2948, 3988 };
  private static final int[][] d = { { 1, 8, 4, 1 }, { 3, 6, 4, 1 }, { 3, 4, 6, 1 }, { 3, 2, 8, 1 }, { 2, 6, 5, 1 }, { 2, 2, 9, 1 } };
  private static final int[][] e = { { 1, 3, 9, 27, 81, 32, 96, 77 }, { 20, 60, 180, 118, 143, 7, 21, 63 }, { 189, 145, 13, 39, 117, 140, 209, 205 }, { 193, 157, 49, 147, 19, 57, 171, 91 }, { 62, 186, 136, 197, 169, 85, 44, 132 }, { 185, 133, 188, 142, 4, 12, 36, 108 }, { 113, 128, 173, 97, 80, 29, 87, 50 }, { 150, 28, 84, 41, 123, 158, 52, 156 }, { 46, 138, 203, 187, 139, 206, 196, 166 }, { 76, 17, 51, 153, 37, 111, 122, 155 }, { 43, 129, 176, 106, 107, 110, 119, 146 }, { 16, 48, 144, 10, 30, 90, 59, 177 }, { 109, 116, 137, 200, 178, 112, 125, 164 }, { 70, 210, 208, 202, 184, 130, 179, 115 }, { 134, 191, 151, 31, 93, 68, 204, 190 }, { 148, 22, 66, 198, 172, 94, 71, 2 }, { 6, 18, 54, 162, 64, 192, 154, 40 }, { 120, 149, 25, 75, 14, 42, 126, 167 }, { 79, 26, 78, 23, 69, 207, 199, 175 }, { 103, 98, 83, 38, 114, 131, 182, 124 }, { 161, 61, 183, 127, 170, 88, 53, 159 }, { 55, 165, 73, 8, 24, 72, 5, 15 }, { 45, 135, 194, 160, 58, 174, 100, 89 } };
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  private static final int i = 3;
  private static final int j = 4;
  private static final int k = 5;
  private static final int[][] l = arrayOfInt;
  private static final int m = 0;
  private static final int n = 11;
  private final List<a> o = new ArrayList(11);
  private final int[] p = new int[2];
  private final int[] q = new int[m];

  static
  {
    int[][] arrayOfInt = { { 0, 0 }, { 0, 1, 1 }, { 0, 2, 1, 3 }, { 0, 4, 1, 3, 2 }, { 0, 4, 1, 3, 3, 5 }, { 0, 4, 1, 3, 4, 5, 5 }, { 0, 0, 1, 1, 2, 2, 3, 3 }, { 0, 0, 1, 1, 2, 2, 3, 4, 4 }, { 0, 0, 1, 1, 2, 2, 3, 4, 5, 5 }, { 0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5 } };
  }

  private static int a(BitArray paramBitArray, int paramInt)
  {
    if (paramBitArray.get(paramInt))
      return paramBitArray.getNextSet(paramBitArray.getNextUnset(paramInt));
    return paramBitArray.getNextUnset(paramBitArray.getNextSet(paramInt));
  }

  private static Result a(List<a> paramList)
  {
    int i1 = -1 + (paramList.size() << 1);
    if (((a)paramList.get(-1 + paramList.size())).c() == null);
    for (int i2 = i1 - 1; ; i2 = i1)
    {
      BitArray localBitArray = new BitArray(i2 * 12);
      int i3 = ((a)paramList.get(0)).c().getValue();
      int i4 = 11;
      int i15;
      for (int i5 = 0; i4 >= 0; i5 = i15)
      {
        if ((i3 & 1 << i4) != 0)
          localBitArray.set(i5);
        i15 = i5 + 1;
        i4--;
      }
      int i6 = 1;
      int i10;
      for (int i7 = i5; i6 < paramList.size(); i7 = i10)
      {
        a locala = (a)paramList.get(i6);
        int i8 = locala.b().getValue();
        int i9 = 11;
        while (i9 >= 0)
        {
          if ((i8 & 1 << i9) != 0)
            localBitArray.set(i7);
          int i14 = i7 + 1;
          i9--;
          i7 = i14;
        }
        if (locala.c() != null)
        {
          int i11 = locala.c().getValue();
          i10 = i7;
          int i12 = 11;
          while (i12 >= 0)
          {
            if ((i11 & 1 << i12) != 0)
              localBitArray.set(i10);
            int i13 = i10 + 1;
            i12--;
            i10 = i13;
          }
        }
        i10 = i7;
        i6++;
      }
      String str = AbstractExpandedDecoder.createDecoder(localBitArray).parseInformation();
      ResultPoint[] arrayOfResultPoint1 = ((a)paramList.get(0)).d().getResultPoints();
      ResultPoint[] arrayOfResultPoint2 = ((a)paramList.get(-1 + paramList.size())).d().getResultPoints();
      ResultPoint[] arrayOfResultPoint3 = new ResultPoint[4];
      arrayOfResultPoint3[0] = arrayOfResultPoint1[0];
      arrayOfResultPoint3[1] = arrayOfResultPoint1[1];
      arrayOfResultPoint3[2] = arrayOfResultPoint2[0];
      arrayOfResultPoint3[3] = arrayOfResultPoint2[1];
      return new Result(str, null, arrayOfResultPoint3, BarcodeFormat.RSS_EXPANDED);
    }
  }

  private DataCharacter a(BitArray paramBitArray, FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2)
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
    int[] arrayOfInt2;
    int[] arrayOfInt3;
    float[] arrayOfFloat2;
    int i4;
    label103: float f2;
    int i33;
    label140: int i34;
    if (paramBoolean2)
    {
      recordPatternInReverse(paramBitArray, paramFinderPattern.getStartEnd()[0], arrayOfInt1);
      float f1 = count(arrayOfInt1) / 17.0F;
      arrayOfInt2 = getOddCounts();
      arrayOfInt3 = getEvenCounts();
      float[] arrayOfFloat1 = getOddRoundingErrors();
      arrayOfFloat2 = getEvenRoundingErrors();
      i4 = 0;
      if (i4 >= arrayOfInt1.length)
        break label276;
      f2 = 1.0F * arrayOfInt1[i4] / f1;
      i33 = (int)(0.5F + f2);
      if (i33 > 0)
        break label241;
      i33 = 1;
      i34 = i4 >> 1;
      if ((i4 & 0x1) != 0)
        break label255;
      arrayOfInt2[i34] = i33;
      arrayOfFloat1[i34] = (f2 - i33);
    }
    while (true)
    {
      i4++;
      break label103;
      recordPattern(paramBitArray, 1 + paramFinderPattern.getStartEnd()[1], arrayOfInt1);
      int i1 = 0;
      for (int i2 = -1 + arrayOfInt1.length; i1 < i2; i2--)
      {
        int i3 = arrayOfInt1[i1];
        arrayOfInt1[i1] = arrayOfInt1[i2];
        arrayOfInt1[i2] = i3;
        i1++;
      }
      break;
      label241: if (i33 <= 8)
        break label140;
      i33 = 8;
      break label140;
      label255: arrayOfInt3[i34] = i33;
      arrayOfFloat2[i34] = (f2 - i33);
    }
    label276: int i5 = count(getOddCounts());
    int i6 = count(getEvenCounts());
    int i7 = -17 + (i5 + i6);
    int i8;
    int i9;
    label325: int i10;
    int i11;
    label338: int i12;
    int i13;
    if ((i5 & 0x1) == 1)
    {
      i8 = 1;
      if ((i6 & 0x1) != 0)
        break label377;
      i9 = 1;
      i10 = 0;
      if (i5 <= 13)
        break label383;
      i11 = 1;
      i12 = 0;
      if (i6 <= 13)
        break label404;
      i13 = 1;
    }
    while (true)
      if (i7 == 1)
        if (i8 != 0)
        {
          if (i9 != 0)
          {
            throw NotFoundException.getNotFoundInstance();
            i8 = 0;
            break;
            label377: i9 = 0;
            break label325;
            label383: i11 = 0;
            i10 = 0;
            if (i5 >= 4)
              break label338;
            i10 = 1;
            i11 = 0;
            break label338;
            label404: i13 = 0;
            i12 = 0;
            if (i6 >= 4)
              continue;
            i12 = 1;
            i13 = 0;
            continue;
          }
          i11 = 1;
        }
    while (i10 != 0)
      if (i11 != 0)
      {
        throw NotFoundException.getNotFoundInstance();
        if (i9 == 0)
          throw NotFoundException.getNotFoundInstance();
        i13 = 1;
        continue;
        if (i7 == -1)
        {
          if (i8 != 0)
          {
            if (i9 != 0)
              throw NotFoundException.getNotFoundInstance();
            i10 = 1;
          }
          else
          {
            if (i9 == 0)
              throw NotFoundException.getNotFoundInstance();
            i12 = 1;
          }
        }
        else if (i7 == 0)
        {
          if (i8 != 0)
          {
            if (i9 == 0)
              throw NotFoundException.getNotFoundInstance();
            if (i5 < i6)
            {
              i10 = 1;
              i13 = 1;
            }
            else
            {
              i11 = 1;
              i12 = 1;
            }
          }
          else if (i9 != 0)
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
    if (i12 != 0)
    {
      if (i13 != 0)
        throw NotFoundException.getNotFoundInstance();
      increment(getEvenCounts(), getOddRoundingErrors());
    }
    if (i13 != 0)
      decrement(getEvenCounts(), getEvenRoundingErrors());
    int i14 = 4 * paramFinderPattern.getValue();
    int i15;
    int i16;
    if (paramBoolean1)
    {
      i15 = 0;
      i16 = i14 + i15;
      if (!paramBoolean2)
        break label742;
    }
    int i18;
    int i20;
    int i22;
    label742: for (int i17 = 0; ; i17 = 1)
    {
      i18 = -1 + (i17 + i16);
      int i19 = -1 + arrayOfInt2.length;
      i20 = 0;
      int i21 = i19;
      i22 = 0;
      while (i21 >= 0)
      {
        if (a(paramFinderPattern, paramBoolean1, paramBoolean2))
          i22 += e[i18][(i21 * 2)] * arrayOfInt2[i21];
        int i32 = i20 + arrayOfInt2[i21];
        i21--;
        i20 = i32;
      }
      i15 = 2;
      break;
    }
    int i23 = 0;
    for (int i24 = -1 + arrayOfInt3.length; i24 >= 0; i24--)
      if (a(paramFinderPattern, paramBoolean1, paramBoolean2))
        i23 += e[i18][(1 + i24 * 2)] * arrayOfInt3[i24];
    int i25 = i22 + i23;
    if (((i20 & 0x1) != 0) || (i20 > 13) || (i20 < 4))
      throw NotFoundException.getNotFoundInstance();
    int i26 = (13 - i20) / 2;
    int i27 = a[i26];
    int i28 = 9 - i27;
    int i29 = RSSUtils.getRSSvalue(arrayOfInt2, i27, true);
    int i30 = RSSUtils.getRSSvalue(arrayOfInt3, i28, false);
    int i31 = b[i26];
    return new DataCharacter(c[i26] + (i30 + i29 * i31), i25);
  }

  private FinderPattern a(BitArray paramBitArray, int paramInt, boolean paramBoolean)
  {
    int i1;
    int i3;
    int i2;
    if (paramBoolean)
    {
      for (int i5 = -1 + this.p[0]; (i5 >= 0) && (!paramBitArray.get(i5)); i5--);
      i1 = i5 + 1;
      i3 = this.p[0] - i1;
      i2 = this.p[1];
    }
    while (true)
    {
      int[] arrayOfInt = getDecodeFinderCounters();
      System.arraycopy(arrayOfInt, 0, arrayOfInt, 1, -1 + arrayOfInt.length);
      arrayOfInt[0] = i3;
      try
      {
        int i4 = parseFinderValue(arrayOfInt, d);
        return new FinderPattern(i4, new int[] { i1, i2 }, i1, i2, paramInt);
        i1 = this.p[0];
        i2 = paramBitArray.getNextUnset(1 + this.p[1]);
        i3 = i2 - this.p[1];
      }
      catch (NotFoundException localNotFoundException)
      {
      }
    }
    return null;
  }

  private a a(BitArray paramBitArray, List<a> paramList, int paramInt)
  {
    boolean bool1;
    int i1;
    if (paramList.size() % 2 == 0)
    {
      bool1 = true;
      i1 = 1;
    }
    label61: label75: label82: int i12;
    for (int i2 = -1; ; i2 = i12)
    {
      int[] arrayOfInt1 = getDecodeFinderCounters();
      arrayOfInt1[0] = 0;
      arrayOfInt1[1] = 0;
      arrayOfInt1[2] = 0;
      arrayOfInt1[3] = 0;
      int i3 = paramBitArray.getSize();
      int i4;
      int i5;
      int i6;
      if (i2 >= 0)
      {
        i4 = i2;
        if (paramList.size() % 2 == 0)
          break label163;
        i5 = 1;
        i6 = i4;
        i7 = 0;
        if (i6 >= i3)
          break label175;
        if (paramBitArray.get(i6))
          break label169;
      }
      label163: label169: for (int i7 = 1; ; i7 = 0)
      {
        if (i7 == 0)
          break label175;
        i6++;
        break label82;
        bool1 = false;
        break;
        if (paramList.isEmpty())
        {
          i4 = 0;
          break label61;
        }
        i4 = ((a)paramList.get(-1 + paramList.size())).d().getStartEnd()[1];
        break label61;
        i5 = 0;
        break label75;
      }
      label175: int i8 = i6;
      int i9 = i6;
      int i10 = i7;
      int i11 = 0;
      FinderPattern localFinderPattern;
      int i20;
      label311: int i13;
      while (true)
        if (i8 < i3)
          if ((i10 ^ paramBitArray.get(i8)) != 0)
          {
            arrayOfInt1[i11] = (1 + arrayOfInt1[i11]);
            i8++;
          }
          else if (i11 == 3)
          {
            if (i5 != 0)
              a(arrayOfInt1);
            if (isFinderPattern(arrayOfInt1))
            {
              this.p[0] = i9;
              this.p[1] = i8;
              localFinderPattern = a(paramBitArray, paramInt, bool1);
              if (localFinderPattern != null)
                break label445;
              i20 = this.p[0];
              if (!paramBitArray.get(i20))
                break label430;
              i12 = paramBitArray.getNextSet(paramBitArray.getNextUnset(i20));
              i13 = i1;
            }
          }
      while (true)
        if (i13 == 0)
        {
          int i14 = 1 + paramList.size();
          if (i14 > this.q.length)
          {
            throw NotFoundException.getNotFoundInstance();
            if (i5 != 0)
              a(arrayOfInt1);
            i9 += arrayOfInt1[0] + arrayOfInt1[1];
            arrayOfInt1[0] = arrayOfInt1[2];
            arrayOfInt1[1] = arrayOfInt1[3];
            arrayOfInt1[2] = 0;
            arrayOfInt1[3] = 0;
            i11--;
            while (true)
            {
              arrayOfInt1[i11] = 1;
              if (i10 != 0)
                break label420;
              i10 = 1;
              break;
              i11++;
            }
            label420: i10 = 0;
            break;
            throw NotFoundException.getNotFoundInstance();
            label430: i12 = paramBitArray.getNextUnset(paramBitArray.getNextSet(i20));
            break label311;
            label445: i12 = i2;
            i13 = 0;
            continue;
          }
          for (int i15 = 0; i15 < paramList.size(); i15++)
            this.q[i15] = ((a)paramList.get(i15)).d().getValue();
          this.q[(i14 - 1)] = localFinderPattern.getValue();
          int[][] arrayOfInt = l;
          int i16 = arrayOfInt.length;
          int i17 = 0;
          while (true)
          {
            int i19;
            label554: boolean bool2;
            label595: DataCharacter localDataCharacter1;
            if (i17 < i16)
            {
              int[] arrayOfInt2 = arrayOfInt[i17];
              if (arrayOfInt2.length >= i14)
              {
                int i18 = 1;
                i19 = 0;
                if (i19 < i14)
                {
                  if (this.q[i19] != arrayOfInt2[i19])
                    i18 = 0;
                }
                else
                {
                  if (i18 == 0)
                    break label651;
                  if (i14 != arrayOfInt2.length)
                    break label645;
                  bool2 = true;
                  localDataCharacter1 = a(paramBitArray, localFinderPattern, bool1, true);
                }
              }
            }
            try
            {
              DataCharacter localDataCharacter3 = a(paramBitArray, localFinderPattern, bool1, false);
              localDataCharacter2 = localDataCharacter3;
              return new a(localDataCharacter1, localDataCharacter2, localFinderPattern, bool2);
              i19++;
              break label554;
              label645: bool2 = false;
              break label595;
              label651: i17++;
              continue;
              throw NotFoundException.getNotFoundInstance();
            }
            catch (NotFoundException localNotFoundException)
            {
              DataCharacter localDataCharacter2;
              while (bool2)
                localDataCharacter2 = null;
              throw localNotFoundException;
            }
          }
        }
      i1 = i13;
    }
  }

  private List<a> a(int paramInt, BitArray paramBitArray)
  {
    a locala1;
    do
    {
      do
      {
        locala1 = a(paramBitArray, this.o, paramInt);
        this.o.add(locala1);
      }
      while (!locala1.a());
      a locala2 = (a)this.o.get(0);
      DataCharacter localDataCharacter1 = locala2.b();
      int i1 = locala2.c().getChecksumPortion();
      int i2 = 2;
      int i3 = i1;
      for (int i4 = 1; i4 < this.o.size(); i4++)
      {
        a locala3 = (a)this.o.get(i4);
        i3 += locala3.b().getChecksumPortion();
        i2++;
        DataCharacter localDataCharacter2 = locala3.c();
        if (localDataCharacter2 != null)
        {
          i3 += localDataCharacter2.getChecksumPortion();
          i2++;
        }
      }
      if (i3 % 211 + 211 * (i2 - 4) == localDataCharacter1.getValue());
      for (int i5 = 1; i5 != 0; i5 = 0)
        return this.o;
    }
    while (!locala1.e());
    throw NotFoundException.getNotFoundInstance();
  }

  private void a(int paramInt)
  {
    int i1 = 1;
    int i2 = count(getOddCounts());
    int i3 = count(getEvenCounts());
    int i4 = -17 + (i2 + i3);
    int i5;
    int i6;
    label48: int i7;
    int i8;
    if ((i2 & 0x1) == i1)
    {
      i5 = i1;
      if ((i3 & 0x1) != 0)
        break label99;
      i6 = i1;
      if (i2 <= 13)
        break label105;
      i7 = i1;
      i8 = 0;
    }
    while (true)
    {
      label60: int i10;
      int i9;
      if (i3 > 13)
      {
        i10 = 0;
        i9 = i1;
      }
      while (true)
      {
        label99: label105: int i12;
        int i11;
        if (i4 == i1)
          if (i5 != 0)
          {
            if (i6 != 0)
            {
              throw NotFoundException.getNotFoundInstance();
              i5 = 0;
              break;
              i6 = 0;
              break label48;
              if (i2 >= 4)
                break label404;
              i8 = i1;
              i7 = 0;
              break label60;
              if (i3 >= 4)
                break label395;
              i10 = i1;
              i9 = 0;
              continue;
            }
            i12 = i8;
            int i15 = i1;
            i1 = i10;
            i11 = i15;
          }
        while (true)
          if (i12 != 0)
          {
            if (i11 != 0)
            {
              throw NotFoundException.getNotFoundInstance();
              if (i6 == 0)
                throw NotFoundException.getNotFoundInstance();
              i9 = i1;
              i1 = i10;
              i11 = i7;
              i12 = i8;
              continue;
              if (i4 == -1)
              {
                if (i5 != 0)
                {
                  if (i6 != 0)
                    throw NotFoundException.getNotFoundInstance();
                  int i14 = i10;
                  i11 = i7;
                  i12 = i1;
                  i1 = i14;
                }
                else
                {
                  if (i6 == 0)
                    throw NotFoundException.getNotFoundInstance();
                  i11 = i7;
                  i12 = i8;
                }
              }
              else if (i4 == 0)
              {
                if (i5 != 0)
                {
                  if (i6 == 0)
                    throw NotFoundException.getNotFoundInstance();
                  if (i2 < i3)
                  {
                    i9 = i1;
                    int i13 = i10;
                    i11 = i7;
                    i12 = i1;
                    i1 = i13;
                  }
                  else
                  {
                    i11 = i1;
                    i12 = i8;
                  }
                }
                else if (i6 != 0)
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
            if (i11 != 0)
              decrement(getOddCounts(), getOddRoundingErrors());
            if (i1 != 0)
            {
              if (i9 != 0)
                throw NotFoundException.getNotFoundInstance();
              increment(getEvenCounts(), getOddRoundingErrors());
            }
            if (i9 != 0)
              decrement(getEvenCounts(), getEvenRoundingErrors());
            return;
            i1 = i10;
            i11 = i7;
            i12 = i8;
          }
        label395: i9 = 0;
        i10 = 0;
      }
      label404: i7 = 0;
      i8 = 0;
    }
  }

  private static void a(int[] paramArrayOfInt)
  {
    int i1 = paramArrayOfInt.length;
    for (int i2 = 0; i2 < i1 / 2; i2++)
    {
      int i3 = paramArrayOfInt[i2];
      paramArrayOfInt[i2] = paramArrayOfInt[(-1 + (i1 - i2))];
      paramArrayOfInt[(-1 + (i1 - i2))] = i3;
    }
  }

  private boolean a()
  {
    a locala1 = (a)this.o.get(0);
    DataCharacter localDataCharacter1 = locala1.b();
    int i1 = locala1.c().getChecksumPortion();
    int i2 = 2;
    int i3 = i1;
    for (int i4 = 1; i4 < this.o.size(); i4++)
    {
      a locala2 = (a)this.o.get(i4);
      i3 += locala2.b().getChecksumPortion();
      i2++;
      DataCharacter localDataCharacter2 = locala2.c();
      if (localDataCharacter2 != null)
      {
        i3 += localDataCharacter2.getChecksumPortion();
        i2++;
      }
    }
    return i3 % 211 + 211 * (i2 - 4) == localDataCharacter1.getValue();
  }

  private static boolean a(FinderPattern paramFinderPattern, boolean paramBoolean1, boolean paramBoolean2)
  {
    return (paramFinderPattern.getValue() != 0) || (!paramBoolean1) || (!paramBoolean2);
  }

  private boolean a(List<a> paramList, FinderPattern paramFinderPattern)
  {
    int i1 = 1 + paramList.size();
    if (i1 > this.q.length)
      throw NotFoundException.getNotFoundInstance();
    for (int i2 = 0; i2 < paramList.size(); i2++)
      this.q[i2] = ((a)paramList.get(i2)).d().getValue();
    this.q[(i1 - 1)] = paramFinderPattern.getValue();
    int[][] arrayOfInt = l;
    int i3 = arrayOfInt.length;
    int i4 = 0;
    int[] arrayOfInt1;
    int i5;
    if (i4 < i3)
    {
      arrayOfInt1 = arrayOfInt[i4];
      if (arrayOfInt1.length >= i1)
      {
        i5 = 0;
        label115: if (i5 >= i1)
          break label180;
        if (this.q[i5] == arrayOfInt1[i5]);
      }
    }
    label180: for (int i6 = 0; ; i6 = 1)
    {
      if (i6 != 0)
      {
        int i7 = arrayOfInt1.length;
        boolean bool = false;
        if (i1 == i7)
          bool = true;
        return bool;
        i5++;
        break label115;
      }
      i4++;
      break;
      throw NotFoundException.getNotFoundInstance();
    }
  }

  private void b(BitArray paramBitArray, List<a> paramList, int paramInt)
  {
    int[] arrayOfInt = getDecodeFinderCounters();
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i1 = paramBitArray.getSize();
    int i2;
    label50: int i4;
    if (paramInt >= 0)
    {
      if (paramList.size() % 2 == 0)
        break label129;
      i2 = 1;
      i3 = 0;
      i4 = paramInt;
      label56: if (i4 >= i1)
        break label141;
      if (paramBitArray.get(i4))
        break label135;
    }
    label129: label135: for (int i3 = 1; ; i3 = 0)
    {
      if (i3 == 0)
        break label141;
      i4++;
      break label56;
      if (paramList.isEmpty())
      {
        paramInt = 0;
        break;
      }
      paramInt = ((a)paramList.get(-1 + paramList.size())).d().getStartEnd()[1];
      break;
      i2 = 0;
      break label50;
    }
    label141: int i5 = i4;
    int i6 = i3;
    int i7 = i4;
    int i8 = 0;
    if (i5 < i1)
    {
      if ((i6 ^ paramBitArray.get(i5)) != 0)
        arrayOfInt[i8] = (1 + arrayOfInt[i8]);
      while (true)
      {
        i5++;
        break;
        if (i8 == 3)
        {
          if (i2 != 0)
            a(arrayOfInt);
          if (isFinderPattern(arrayOfInt))
          {
            this.p[0] = i7;
            this.p[1] = i5;
            return;
          }
          if (i2 != 0)
            a(arrayOfInt);
          i7 += arrayOfInt[0] + arrayOfInt[1];
          arrayOfInt[0] = arrayOfInt[2];
          arrayOfInt[1] = arrayOfInt[3];
          arrayOfInt[2] = 0;
          arrayOfInt[3] = 0;
          i8--;
        }
        while (true)
        {
          arrayOfInt[i8] = 1;
          if (i6 != 0)
            break label310;
          i6 = 1;
          break;
          i8++;
        }
        label310: i6 = 0;
      }
    }
    throw NotFoundException.getNotFoundInstance();
  }

  public final Result decodeRow(int paramInt, BitArray paramBitArray, Map<DecodeHintType, ?> paramMap)
  {
    reset();
    a locala1;
    do
    {
      locala1 = a(paramBitArray, this.o, paramInt);
      this.o.add(locala1);
    }
    while (!locala1.a());
    a locala2 = (a)this.o.get(0);
    DataCharacter localDataCharacter1 = locala2.b();
    int i1 = locala2.c().getChecksumPortion();
    int i2 = 1;
    int i3 = 2;
    int i4 = i1;
    while (i2 < this.o.size())
    {
      a locala4 = (a)this.o.get(i2);
      i4 += locala4.b().getChecksumPortion();
      i3++;
      DataCharacter localDataCharacter2 = locala4.c();
      if (localDataCharacter2 != null)
      {
        i4 += localDataCharacter2.getChecksumPortion();
        i3++;
      }
      i2++;
    }
    int i5;
    label181: List localList;
    int i6;
    if (i4 % 211 + 211 * (i3 - 4) == localDataCharacter1.getValue())
    {
      i5 = 1;
      if (i5 == 0)
        break label318;
      localList = this.o;
      i6 = -1 + (localList.size() << 1);
      if (((a)localList.get(-1 + localList.size())).c() != null)
        break label589;
    }
    label318: label589: for (int i7 = i6 - 1; ; i7 = i6)
    {
      BitArray localBitArray = new BitArray(i7 * 12);
      int i8 = ((a)localList.get(0)).c().getValue();
      int i9 = 0;
      int i10 = 11;
      while (true)
        if (i10 >= 0)
        {
          if ((i8 & 1 << i10) != 0)
            localBitArray.set(i9);
          i9++;
          i10--;
          continue;
          i5 = 0;
          break label181;
          if (!locala1.e())
            break;
          throw NotFoundException.getNotFoundInstance();
        }
      int i11 = i9;
      int i12 = 1;
      while (i12 < localList.size())
      {
        a locala3 = (a)localList.get(i12);
        int i13 = locala3.b().getValue();
        for (int i14 = 11; i14 >= 0; i14--)
        {
          if ((i13 & 1 << i14) != 0)
            localBitArray.set(i11);
          i11++;
        }
        if (locala3.c() != null)
        {
          int i16 = locala3.c().getValue();
          i15 = i11;
          for (int i17 = 11; i17 >= 0; i17--)
          {
            if ((i16 & 1 << i17) != 0)
              localBitArray.set(i15);
            i15++;
          }
        }
        int i15 = i11;
        i12++;
        i11 = i15;
      }
      String str = AbstractExpandedDecoder.createDecoder(localBitArray).parseInformation();
      ResultPoint[] arrayOfResultPoint1 = ((a)localList.get(0)).d().getResultPoints();
      ResultPoint[] arrayOfResultPoint2 = ((a)localList.get(-1 + localList.size())).d().getResultPoints();
      ResultPoint[] arrayOfResultPoint3 = new ResultPoint[4];
      arrayOfResultPoint3[0] = arrayOfResultPoint1[0];
      arrayOfResultPoint3[1] = arrayOfResultPoint1[1];
      arrayOfResultPoint3[2] = arrayOfResultPoint2[0];
      arrayOfResultPoint3[3] = arrayOfResultPoint2[1];
      return new Result(str, null, arrayOfResultPoint3, BarcodeFormat.RSS_EXPANDED);
    }
  }

  public final void reset()
  {
    this.o.clear();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.RSSExpandedReader
 * JD-Core Version:    0.6.2
 */