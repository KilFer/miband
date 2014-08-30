package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

final class b
{
  private static final int[] a = { 1, 1, 2 };
  private static final int[] b = { 24, 20, 18, 17, 12, 6, 3, 10, 9, 5 };
  private final int[] c = new int[4];
  private final StringBuilder d = new StringBuilder();

  private static int a(int paramInt)
  {
    for (int i = 0; i < 10; i++)
      if (paramInt == b[i])
        return i;
    throw NotFoundException.getNotFoundInstance();
  }

  private int a(BitArray paramBitArray, int[] paramArrayOfInt, StringBuilder paramStringBuilder)
  {
    int[] arrayOfInt = this.c;
    arrayOfInt[0] = 0;
    arrayOfInt[1] = 0;
    arrayOfInt[2] = 0;
    arrayOfInt[3] = 0;
    int i = paramBitArray.getSize();
    int j = paramArrayOfInt[1];
    int k = 0;
    int m = 0;
    while ((m < 5) && (j < i))
    {
      int i6 = UPCEANReader.a(paramBitArray, arrayOfInt, j, UPCEANReader.e);
      paramStringBuilder.append((char)(48 + i6 % 10));
      int i7 = arrayOfInt.length;
      int i8 = 0;
      int i10;
      for (int i9 = j; i8 < i7; i9 = i10)
      {
        i10 = i9 + arrayOfInt[i8];
        i8++;
      }
      if (i6 >= 10)
        k |= 1 << 4 - m;
      if (m != 4)
        i9 = paramBitArray.getNextUnset(paramBitArray.getNextSet(i9));
      m++;
      j = i9;
    }
    if (paramStringBuilder.length() != 5)
      throw NotFoundException.getNotFoundInstance();
    String str;
    int i1;
    int i2;
    for (int n = 0; n < 10; n++)
      if (k == b[n])
      {
        str = paramStringBuilder.toString();
        i1 = str.length();
        i2 = 0;
        for (int i3 = i1 - 2; i3 >= 0; i3 -= 2)
          i2 += '￐' + str.charAt(i3);
      }
    throw NotFoundException.getNotFoundInstance();
    int i4 = i2 * 3;
    for (int i5 = i1 - 1; i5 >= 0; i5 -= 2)
      i4 += '￐' + str.charAt(i5);
    if (i4 * 3 % 10 != n)
      throw NotFoundException.getNotFoundInstance();
    return j;
  }

  private static int a(CharSequence paramCharSequence)
  {
    int i = paramCharSequence.length();
    int j = 0;
    for (int k = i - 2; k >= 0; k -= 2)
      j += '￐' + paramCharSequence.charAt(k);
    int m = j * 3;
    for (int n = i - 1; n >= 0; n -= 2)
      m += '￐' + paramCharSequence.charAt(n);
    return m * 3 % 10;
  }

  private static Map<ResultMetadataType, Object> a(String paramString)
  {
    Object localObject2;
    Object localObject1;
    switch (paramString.length())
    {
    case 3:
    case 4:
    default:
    case 2:
      do
      {
        return null;
        localObject2 = ResultMetadataType.ISSUE_NUMBER;
        localObject1 = Integer.valueOf(paramString);
      }
      while (localObject1 == null);
      EnumMap localEnumMap = new EnumMap(ResultMetadataType.class);
      localEnumMap.put(localObject2, localObject1);
      return localEnumMap;
    case 5:
    }
    ResultMetadataType localResultMetadataType = ResultMetadataType.SUGGESTED_PRICE;
    String str2;
    label124: String str3;
    int j;
    switch (paramString.charAt(0))
    {
    default:
      str2 = "";
      int i = Integer.parseInt(paramString.substring(1));
      str3 = String.valueOf(i / 100);
      j = i % 100;
      if (j >= 10)
        break;
    case '0':
    case '5':
    case '9':
    }
    for (String str4 = "0" + j; ; str4 = String.valueOf(j))
    {
      String str1 = str2 + str3 + '.' + str4;
      while (true)
      {
        localObject1 = str1;
        localObject2 = localResultMetadataType;
        break;
        str2 = "£";
        break label124;
        str2 = "$";
        break label124;
        if ("90000".equals(paramString))
        {
          str1 = null;
        }
        else if ("99991".equals(paramString))
        {
          str1 = "0.00";
        }
        else
        {
          if (!"99990".equals(paramString))
            break label274;
          str1 = "Used";
        }
      }
      label274: str2 = "";
      break label124;
    }
  }

  private static Integer b(String paramString)
  {
    return Integer.valueOf(paramString);
  }

  private static String c(String paramString)
  {
    String str1;
    String str2;
    int j;
    switch (paramString.charAt(0))
    {
    default:
      str1 = "";
      int i = Integer.parseInt(paramString.substring(1));
      str2 = String.valueOf(i / 100);
      j = i % 100;
      if (j >= 10)
        break;
    case '0':
    case '5':
    case '9':
    }
    for (String str3 = "0" + j; ; str3 = String.valueOf(j))
    {
      return str1 + str2 + '.' + str3;
      str1 = "£";
      break;
      str1 = "$";
      break;
      if ("90000".equals(paramString))
        return null;
      if ("99991".equals(paramString))
        return "0.00";
      if ("99990".equals(paramString))
        return "Used";
      str1 = "";
      break;
    }
  }

  final Result a(int paramInt1, BitArray paramBitArray, int paramInt2)
  {
    int[] arrayOfInt1 = UPCEANReader.a(paramBitArray, paramInt2, false, a);
    StringBuilder localStringBuilder = this.d;
    localStringBuilder.setLength(0);
    int[] arrayOfInt2 = this.c;
    arrayOfInt2[0] = 0;
    arrayOfInt2[1] = 0;
    arrayOfInt2[2] = 0;
    arrayOfInt2[3] = 0;
    int i = paramBitArray.getSize();
    int j = arrayOfInt1[1];
    int k = 0;
    int m = j;
    int n = 0;
    int i12;
    if ((n < 5) && (m < i))
    {
      int i9 = UPCEANReader.a(paramBitArray, arrayOfInt2, m, UPCEANReader.e);
      localStringBuilder.append((char)(48 + i9 % 10));
      int i10 = arrayOfInt2.length;
      int i11 = 0;
      int i14;
      for (i12 = m; i11 < i10; i12 = i14)
      {
        i14 = i12 + arrayOfInt2[i11];
        i11++;
      }
      if (i9 < 10)
        break label760;
    }
    label560: label717: label760: for (int i13 = k | 1 << 4 - n; ; i13 = k)
    {
      if (n != 4)
        i12 = paramBitArray.getNextUnset(paramBitArray.getNextSet(i12));
      n++;
      k = i13;
      m = i12;
      break;
      if (localStringBuilder.length() != 5)
        throw NotFoundException.getNotFoundInstance();
      String str1;
      int i2;
      int i3;
      for (int i1 = 0; i1 < 10; i1++)
        if (k == b[i1])
        {
          str1 = localStringBuilder.toString();
          i2 = str1.length();
          i3 = 0;
          for (int i4 = i2 - 2; i4 >= 0; i4 -= 2)
            i3 += '￐' + str1.charAt(i4);
        }
      throw NotFoundException.getNotFoundInstance();
      int i5 = i3 * 3;
      for (int i6 = i2 - 1; i6 >= 0; i6 -= 2)
        i5 += '￐' + str1.charAt(i6);
      if (i5 * 3 % 10 != i1)
        throw NotFoundException.getNotFoundInstance();
      String str2 = localStringBuilder.toString();
      Object localObject2;
      switch (str2.length())
      {
      case 3:
      case 4:
      default:
        localObject2 = null;
      case 2:
      case 5:
      }
      while (true)
      {
        ResultPoint[] arrayOfResultPoint = new ResultPoint[2];
        arrayOfResultPoint[0] = new ResultPoint((arrayOfInt1[0] + arrayOfInt1[1]) / 2.0F, paramInt1);
        arrayOfResultPoint[1] = new ResultPoint(m, paramInt1);
        Result localResult = new Result(str2, null, arrayOfResultPoint, BarcodeFormat.UPC_EAN_EXTENSION);
        if (localObject2 != null)
          localResult.putAllMetadata((Map)localObject2);
        return localResult;
        ResultMetadataType localResultMetadataType2 = ResultMetadataType.ISSUE_NUMBER;
        Integer localInteger = Integer.valueOf(str2);
        ResultMetadataType localResultMetadataType1 = localResultMetadataType2;
        Object localObject1 = localInteger;
        if (localObject1 == null)
        {
          localObject2 = null;
          continue;
          localResultMetadataType1 = ResultMetadataType.SUGGESTED_PRICE;
          String str4;
          String str5;
          int i8;
          switch (str2.charAt(0))
          {
          default:
            str4 = "";
            int i7 = Integer.parseInt(str2.substring(1));
            str5 = String.valueOf(i7 / 100);
            i8 = i7 % 100;
            if (i8 >= 10)
              break;
          case '0':
          case '5':
          case '9':
          }
          for (String str6 = "0" + i8; ; str6 = String.valueOf(i8))
          {
            String str3 = str4 + str5 + '.' + str6;
            while (true)
            {
              localObject1 = str3;
              break;
              str4 = "£";
              break label560;
              str4 = "$";
              break label560;
              if ("90000".equals(str2))
              {
                str3 = null;
              }
              else if ("99991".equals(str2))
              {
                str3 = "0.00";
              }
              else
              {
                if (!"99990".equals(str2))
                  break label717;
                str3 = "Used";
              }
            }
            str4 = "";
            break label560;
          }
        }
        else
        {
          localObject2 = new EnumMap(ResultMetadataType.class);
          ((Map)localObject2).put(localResultMetadataType1, localObject1);
        }
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.b
 * JD-Core Version:    0.6.2
 */