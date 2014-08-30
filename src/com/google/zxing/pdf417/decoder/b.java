package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.DecoderResult;
import java.math.BigInteger;

final class b
{
  private static final int a = 900;
  private static final int b = 901;
  private static final int c = 902;
  private static final int d = 924;
  private static final int e = 928;
  private static final int f = 923;
  private static final int g = 922;
  private static final int h = 913;
  private static final int i = 15;
  private static final int j = 25;
  private static final int k = 27;
  private static final int l = 27;
  private static final int m = 28;
  private static final int n = 28;
  private static final int o = 29;
  private static final int p = 29;
  private static final char[] q = { 59, 60, 62, 64, 91, 92, 125, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39 };
  private static final char[] r = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94 };
  private static final BigInteger[] s;

  static
  {
    BigInteger[] arrayOfBigInteger = new BigInteger[16];
    s = arrayOfBigInteger;
    arrayOfBigInteger[0] = BigInteger.ONE;
    BigInteger localBigInteger = BigInteger.valueOf(900L);
    s[1] = localBigInteger;
    for (int i1 = 2; i1 < s.length; i1++)
      s[i1] = s[(i1 - 1)].multiply(localBigInteger);
  }

  private static int a(int paramInt1, int[] paramArrayOfInt, int paramInt2, StringBuilder paramStringBuilder)
  {
    int i6;
    long l3;
    char[] arrayOfChar2;
    int[] arrayOfInt;
    int i7;
    if (paramInt1 == 901)
    {
      i6 = 0;
      l3 = 0L;
      arrayOfChar2 = new char[6];
      arrayOfInt = new int[6];
      i7 = 0;
    }
    label448: label452: label454: label458: 
    while (true)
    {
      int i9;
      int i10;
      if ((paramInt2 < paramArrayOfInt[0]) && (i7 == 0))
      {
        i9 = paramInt2 + 1;
        i10 = paramArrayOfInt[paramInt2];
        if (i10 < 900)
        {
          arrayOfInt[i6] = i10;
          i6++;
          l3 = l3 * 900L + i10;
          paramInt2 = i9;
        }
      }
      while (true)
      {
        if ((i6 % 5 != 0) || (i6 <= 0))
          break label458;
        int i11 = 0;
        while (true)
          if (i11 < 6)
          {
            arrayOfChar2[(5 - i11)] = ((char)(int)(l3 % 256L));
            l3 >>= 8;
            i11++;
            continue;
            if ((i10 != 900) && (i10 != 901) && (i10 != 902) && (i10 != 924) && (i10 != 928) && (i10 != 923) && (i10 != 922))
              break label454;
            paramInt2 = i9 - 1;
            i7 = 1;
            break;
          }
        paramStringBuilder.append(arrayOfChar2);
        i6 = 0;
        break;
        int i8 = 5 * (i6 / 5);
        int i1;
        long l1;
        int i2;
        while (i8 < i6)
        {
          paramStringBuilder.append((char)arrayOfInt[i8]);
          i8++;
          continue;
          if (paramInt1 == 924)
          {
            i1 = 0;
            l1 = 0L;
            i2 = 0;
          }
        }
        while (true)
        {
          int i3;
          int i4;
          if ((paramInt2 < paramArrayOfInt[0]) && (i2 == 0))
          {
            i3 = paramInt2 + 1;
            i4 = paramArrayOfInt[paramInt2];
            if (i4 < 900)
            {
              i1++;
              l1 = l1 * 900L + i4;
              paramInt2 = i3;
            }
          }
          while (true)
          {
            if ((i1 % 5 != 0) || (i1 <= 0))
              break label452;
            char[] arrayOfChar1 = new char[6];
            int i5 = 0;
            while (true)
              if (i5 < 6)
              {
                arrayOfChar1[(5 - i5)] = ((char)(int)(0xFF & l1));
                long l2 = l1 >> 8;
                i5++;
                l1 = l2;
                continue;
                if ((i4 != 900) && (i4 != 901) && (i4 != 902) && (i4 != 924) && (i4 != 928) && (i4 != 923) && (i4 != 922))
                  break label448;
                paramInt2 = i3 - 1;
                i2 = 1;
                break;
              }
            paramStringBuilder.append(arrayOfChar1);
            break;
            return paramInt2;
            paramInt2 = i3;
          }
        }
        paramInt2 = i9;
      }
    }
  }

  private static int a(int[] paramArrayOfInt, int paramInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt1 = new int[paramArrayOfInt[0] << 1];
    int[] arrayOfInt2 = new int[paramArrayOfInt[0] << 1];
    int i1 = 0;
    int i2 = 0;
    while ((paramInt < paramArrayOfInt[0]) && (i2 == 0))
    {
      int i6 = paramInt + 1;
      int i7 = paramArrayOfInt[paramInt];
      if (i7 < 900)
      {
        arrayOfInt1[i1] = (i7 / 30);
        arrayOfInt1[(i1 + 1)] = (i7 % 30);
        i1 += 2;
        paramInt = i6;
      }
      else
      {
        switch (i7)
        {
        default:
          paramInt = i6;
          break;
        case 900:
          paramInt = i6 - 1;
          i2 = 1;
          break;
        case 901:
          paramInt = i6 - 1;
          i2 = 1;
          break;
        case 902:
          paramInt = i6 - 1;
          i2 = 1;
          break;
        case 913:
          arrayOfInt1[i1] = 913;
          paramInt = i6 + 1;
          arrayOfInt2[i1] = paramArrayOfInt[i6];
          i1++;
          break;
        case 924:
          paramInt = i6 - 1;
          i2 = 1;
        }
      }
    }
    Object localObject1 = d.a;
    Object localObject2 = d.a;
    int i3 = 0;
    int i4;
    char c1;
    if (i3 < i1)
    {
      i4 = arrayOfInt1[i3];
      int i5 = c.a[localObject1.ordinal()];
      c1 = '\000';
      switch (i5)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    }
    while (true)
    {
      if (c1 != 0)
        paramStringBuilder.append(c1);
      i3++;
      break;
      if (i4 < 26)
      {
        c1 = (char)(i4 + 65);
      }
      else if (i4 == 26)
      {
        c1 = ' ';
      }
      else if (i4 == 27)
      {
        localObject1 = d.b;
        c1 = '\000';
      }
      else if (i4 == 28)
      {
        localObject1 = d.c;
        c1 = '\000';
      }
      else if (i4 == 29)
      {
        d locald4 = d.f;
        Object localObject6 = localObject1;
        localObject1 = locald4;
        localObject2 = localObject6;
        c1 = '\000';
      }
      else
      {
        c1 = '\000';
        if (i4 == 913)
        {
          paramStringBuilder.append((char)arrayOfInt2[i3]);
          c1 = '\000';
          continue;
          if (i4 < 26)
          {
            c1 = (char)(i4 + 97);
          }
          else if (i4 == 26)
          {
            c1 = ' ';
          }
          else if (i4 == 27)
          {
            d locald3 = d.e;
            Object localObject5 = localObject1;
            localObject1 = locald3;
            localObject2 = localObject5;
            c1 = '\000';
          }
          else if (i4 == 28)
          {
            localObject1 = d.c;
            c1 = '\000';
          }
          else if (i4 == 29)
          {
            d locald2 = d.f;
            Object localObject4 = localObject1;
            localObject1 = locald2;
            localObject2 = localObject4;
            c1 = '\000';
          }
          else
          {
            c1 = '\000';
            if (i4 == 913)
            {
              paramStringBuilder.append((char)arrayOfInt2[i3]);
              c1 = '\000';
              continue;
              if (i4 < 25)
              {
                c1 = r[i4];
              }
              else if (i4 == 25)
              {
                localObject1 = d.d;
                c1 = '\000';
              }
              else if (i4 == 26)
              {
                c1 = ' ';
              }
              else if (i4 == 27)
              {
                localObject1 = d.b;
                c1 = '\000';
              }
              else if (i4 == 28)
              {
                localObject1 = d.a;
                c1 = '\000';
              }
              else if (i4 == 29)
              {
                d locald1 = d.f;
                Object localObject3 = localObject1;
                localObject1 = locald1;
                localObject2 = localObject3;
                c1 = '\000';
              }
              else
              {
                c1 = '\000';
                if (i4 == 913)
                {
                  paramStringBuilder.append((char)arrayOfInt2[i3]);
                  c1 = '\000';
                  continue;
                  if (i4 < 29)
                  {
                    c1 = q[i4];
                  }
                  else if (i4 == 29)
                  {
                    localObject1 = d.a;
                    c1 = '\000';
                  }
                  else
                  {
                    c1 = '\000';
                    if (i4 == 913)
                    {
                      paramStringBuilder.append((char)arrayOfInt2[i3]);
                      c1 = '\000';
                      continue;
                      if (i4 < 26)
                      {
                        c1 = (char)(i4 + 65);
                        localObject1 = localObject2;
                      }
                      else if (i4 == 26)
                      {
                        c1 = ' ';
                        localObject1 = localObject2;
                        continue;
                        if (i4 < 29)
                        {
                          c1 = q[i4];
                          localObject1 = localObject2;
                        }
                        else if (i4 == 29)
                        {
                          localObject1 = d.a;
                          c1 = '\000';
                          continue;
                          return paramInt;
                        }
                      }
                      else
                      {
                        localObject1 = localObject2;
                        c1 = '\000';
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
  }

  static DecoderResult a(int[] paramArrayOfInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    int i1 = 2;
    int i2 = paramArrayOfInt[1];
    if (i1 < paramArrayOfInt[0])
    {
      int i3;
      switch (i2)
      {
      default:
        i3 = a(paramArrayOfInt, i1 - 1, localStringBuilder);
      case 900:
      case 901:
      case 902:
      case 913:
      case 924:
      }
      while (true)
      {
        if (i3 >= paramArrayOfInt.length)
          break label164;
        i1 = i3 + 1;
        i2 = paramArrayOfInt[i3];
        break;
        i3 = a(paramArrayOfInt, i1, localStringBuilder);
        continue;
        i3 = a(i2, paramArrayOfInt, i1, localStringBuilder);
        continue;
        i3 = b(paramArrayOfInt, i1, localStringBuilder);
        continue;
        i3 = a(i2, paramArrayOfInt, i1, localStringBuilder);
        continue;
        i3 = a(i2, paramArrayOfInt, i1, localStringBuilder);
      }
      label164: throw FormatException.getFormatInstance();
    }
    return new DecoderResult(null, localStringBuilder.toString(), null, null);
  }

  private static String a(int[] paramArrayOfInt, int paramInt)
  {
    BigInteger localBigInteger = BigInteger.ZERO;
    for (int i1 = 0; i1 < paramInt; i1++)
      localBigInteger = localBigInteger.add(s[(-1 + (paramInt - i1))].multiply(BigInteger.valueOf(paramArrayOfInt[i1])));
    String str = localBigInteger.toString();
    if (str.charAt(0) != '1')
      throw FormatException.getFormatInstance();
    return str.substring(1);
  }

  private static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt, StringBuilder paramStringBuilder)
  {
    Object localObject1 = d.a;
    Object localObject2 = d.a;
    int i1 = 0;
    int i2;
    char c1;
    if (i1 < paramInt)
    {
      i2 = paramArrayOfInt1[i1];
      int i3 = c.a[localObject1.ordinal()];
      c1 = '\000';
      switch (i3)
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      }
    }
    while (true)
    {
      if (c1 != 0)
        paramStringBuilder.append(c1);
      i1++;
      break;
      if (i2 < 26)
      {
        c1 = (char)(i2 + 65);
      }
      else if (i2 == 26)
      {
        c1 = ' ';
      }
      else if (i2 == 27)
      {
        localObject1 = d.b;
        c1 = '\000';
      }
      else if (i2 == 28)
      {
        localObject1 = d.c;
        c1 = '\000';
      }
      else if (i2 == 29)
      {
        d locald4 = d.f;
        Object localObject6 = localObject1;
        localObject1 = locald4;
        localObject2 = localObject6;
        c1 = '\000';
      }
      else
      {
        c1 = '\000';
        if (i2 == 913)
        {
          paramStringBuilder.append((char)paramArrayOfInt2[i1]);
          c1 = '\000';
          continue;
          if (i2 < 26)
          {
            c1 = (char)(i2 + 97);
          }
          else if (i2 == 26)
          {
            c1 = ' ';
          }
          else if (i2 == 27)
          {
            d locald3 = d.e;
            Object localObject5 = localObject1;
            localObject1 = locald3;
            localObject2 = localObject5;
            c1 = '\000';
          }
          else if (i2 == 28)
          {
            localObject1 = d.c;
            c1 = '\000';
          }
          else if (i2 == 29)
          {
            d locald2 = d.f;
            Object localObject4 = localObject1;
            localObject1 = locald2;
            localObject2 = localObject4;
            c1 = '\000';
          }
          else
          {
            c1 = '\000';
            if (i2 == 913)
            {
              paramStringBuilder.append((char)paramArrayOfInt2[i1]);
              c1 = '\000';
              continue;
              if (i2 < 25)
              {
                c1 = r[i2];
              }
              else if (i2 == 25)
              {
                localObject1 = d.d;
                c1 = '\000';
              }
              else if (i2 == 26)
              {
                c1 = ' ';
              }
              else if (i2 == 27)
              {
                localObject1 = d.b;
                c1 = '\000';
              }
              else if (i2 == 28)
              {
                localObject1 = d.a;
                c1 = '\000';
              }
              else if (i2 == 29)
              {
                d locald1 = d.f;
                Object localObject3 = localObject1;
                localObject1 = locald1;
                localObject2 = localObject3;
                c1 = '\000';
              }
              else
              {
                c1 = '\000';
                if (i2 == 913)
                {
                  paramStringBuilder.append((char)paramArrayOfInt2[i1]);
                  c1 = '\000';
                  continue;
                  if (i2 < 29)
                  {
                    c1 = q[i2];
                  }
                  else if (i2 == 29)
                  {
                    localObject1 = d.a;
                    c1 = '\000';
                  }
                  else
                  {
                    c1 = '\000';
                    if (i2 == 913)
                    {
                      paramStringBuilder.append((char)paramArrayOfInt2[i1]);
                      c1 = '\000';
                      continue;
                      if (i2 < 26)
                      {
                        c1 = (char)(i2 + 65);
                        localObject1 = localObject2;
                      }
                      else if (i2 == 26)
                      {
                        c1 = ' ';
                        localObject1 = localObject2;
                        continue;
                        if (i2 < 29)
                        {
                          c1 = q[i2];
                          localObject1 = localObject2;
                        }
                        else if (i2 == 29)
                        {
                          localObject1 = d.a;
                          c1 = '\000';
                        }
                      }
                      else
                      {
                        localObject1 = localObject2;
                        c1 = '\000';
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
  }

  private static int b(int[] paramArrayOfInt, int paramInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = new int[15];
    int i1 = 0;
    int i2 = 0;
    label235: label239: 
    while (true)
    {
      int i3;
      int i4;
      if ((paramInt < paramArrayOfInt[0]) && (i1 == 0))
      {
        i3 = paramInt + 1;
        i4 = paramArrayOfInt[paramInt];
        if (i3 == paramArrayOfInt[0])
          i1 = 1;
        if (i4 < 900)
        {
          arrayOfInt[i2] = i4;
          i2++;
          paramInt = i3;
        }
      }
      while (true)
      {
        if ((i2 % 15 != 0) && (i4 != 902) && (i1 == 0))
          break label239;
        BigInteger localBigInteger = BigInteger.ZERO;
        int i5 = 0;
        while (true)
          if (i5 < i2)
          {
            localBigInteger = localBigInteger.add(s[(-1 + (i2 - i5))].multiply(BigInteger.valueOf(arrayOfInt[i5])));
            i5++;
            continue;
            if ((i4 != 900) && (i4 != 901) && (i4 != 924) && (i4 != 928) && (i4 != 923) && (i4 != 922))
              break label235;
            paramInt = i3 - 1;
            i1 = 1;
            break;
          }
        String str = localBigInteger.toString();
        if (str.charAt(0) != '1')
          throw FormatException.getFormatInstance();
        paramStringBuilder.append(str.substring(1));
        i2 = 0;
        break;
        return paramInt;
        paramInt = i3;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.pdf417.decoder.b
 * JD-Core Version:    0.6.2
 */