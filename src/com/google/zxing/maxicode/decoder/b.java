package com.google.zxing.maxicode.decoder;

import com.google.zxing.common.DecoderResult;
import java.text.DecimalFormat;
import java.text.NumberFormat;

final class b
{
  private static final char a = '￰';
  private static final char b = '￱';
  private static final char c = '￲';
  private static final char d = '￳';
  private static final char e = '￴';
  private static final char f = '￵';
  private static final char g = '￶';
  private static final char h = '￷';
  private static final char i = '￸';
  private static final char j = '￹';
  private static final char k = '￺';
  private static final char l = '￻';
  private static final char m = '￼';
  private static final char n = '\034';
  private static final char o = '\035';
  private static final char p = '\036';
  private static final NumberFormat q = new DecimalFormat("000000000");
  private static final NumberFormat r = new DecimalFormat("000");
  private static final String[] s = { "\nABCDEFGHIJKLMNOPQRSTUVWXYZ￺\034\035\036￻ ￼\"#$%&'()*+,-./0123456789:￱￲￳￴￸", "`abcdefghijklmnopqrstuvwxyz￺\034\035\036￻{￼}~;<=>?[\\]^_ ,./:@!|￼￵￶￼￰￲￳￴￷", "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏÐÑÒÓÔÕÖ×ØÙÚ￺\034\035\036ÛÜÝÞßª¬±²³µ¹º¼½¾￷ ￹￳￴￸", "àáâãäåæçèéêëìíîïðñòóôõö÷øùú￺\034\035\036￻ûüýþÿ¡¨«¯°´·¸»¿￷ ￲￹￴￸", "", "" };

  private static int a(int paramInt, byte[] paramArrayOfByte)
  {
    int i1 = 1;
    int i2 = paramInt - 1;
    if ((paramArrayOfByte[(i2 / 6)] & i1 << 5 - i2 % 6) == 0)
      i1 = 0;
    return i1;
  }

  private static int a(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, new byte[] { 53, 54, 43, 44, 45, 46, 47, 48, 37, 38 });
  }

  private static int a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i1 = 0;
    int i2 = 0;
    if (i1 < paramArrayOfByte2.length)
    {
      int i3 = -1 + paramArrayOfByte2[i1];
      if ((paramArrayOfByte1[(i3 / 6)] & 1 << 5 - i3 % 6) == 0);
      for (int i4 = 0; ; i4 = 1)
      {
        i2 += (i4 << -1 + (paramArrayOfByte2.length - i1));
        i1++;
        break;
      }
    }
    return i2;
  }

  static DecoderResult a(byte[] paramArrayOfByte, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(144);
    switch (paramInt)
    {
    default:
    case 2:
    case 3:
    case 4:
    case 5:
    }
    while (true)
    {
      return new DecoderResult(paramArrayOfByte, localStringBuilder.toString(), null, String.valueOf(paramInt));
      int i1;
      if (paramInt == 2)
        i1 = a(paramArrayOfByte, new byte[] { 33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2 });
      String str2;
      String str3;
      char[] arrayOfChar;
      for (String str1 = new DecimalFormat("0000000000".substring(0, a(paramArrayOfByte, new byte[] { 39, 40, 41, 42, 31, 32 }))).format(i1); ; str1 = String.valueOf(arrayOfChar))
      {
        str2 = r.format(a(paramArrayOfByte, new byte[] { 53, 54, 43, 44, 45, 46, 47, 48, 37, 38 }));
        str3 = r.format(a(paramArrayOfByte, new byte[] { 55, 56, 57, 58, 59, 60, 49, 50, 51, 52 }));
        localStringBuilder.append(a(paramArrayOfByte, 10, 84));
        if (!localStringBuilder.toString().startsWith("[)>\03601\035"))
          break label843;
        localStringBuilder.insert(9, str1 + '\035' + str2 + '\035' + str3 + '\035');
        break;
        arrayOfChar = new char[6];
        arrayOfChar[0] = s[0].charAt(a(paramArrayOfByte, new byte[] { 39, 40, 41, 42, 31, 32 }));
        arrayOfChar[1] = s[0].charAt(a(paramArrayOfByte, new byte[] { 33, 34, 35, 36, 25, 26 }));
        arrayOfChar[2] = s[0].charAt(a(paramArrayOfByte, new byte[] { 27, 28, 29, 30, 19, 20 }));
        arrayOfChar[3] = s[0].charAt(a(paramArrayOfByte, new byte[] { 21, 22, 23, 24, 13, 14 }));
        arrayOfChar[4] = s[0].charAt(a(paramArrayOfByte, new byte[] { 15, 16, 17, 18, 7, 8 }));
        arrayOfChar[5] = s[0].charAt(a(paramArrayOfByte, new byte[] { 9, 10, 11, 12, 1, 2 }));
      }
      label843: localStringBuilder.insert(0, str1 + '\035' + str2 + '\035' + str3 + '\035');
      continue;
      localStringBuilder.append(a(paramArrayOfByte, 1, 93));
      continue;
      localStringBuilder.append(a(paramArrayOfByte, 1, 77));
    }
  }

  private static String a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i1 = paramInt1;
    int i2 = 0;
    int i3 = 0;
    int i4 = -1;
    if (i1 < paramInt1 + paramInt2)
    {
      int i5 = s[i3].charAt(paramArrayOfByte[i1]);
      int i8;
      int i7;
      switch (i5)
      {
      case 65530:
      default:
        localStringBuilder.append(i5);
        int i24 = i1;
        i8 = i3;
        i7 = i24;
      case 65527:
      case 65528:
      case 65520:
      case 65521:
      case 65522:
      case 65523:
      case 65524:
      case 65525:
      case 65526:
      case 65531:
      case 65529:
      }
      while (true)
      {
        int i9 = i4 - 1;
        if (i4 == 0)
          i8 = i2;
        int i10 = i7 + 1;
        i4 = i9;
        int i11 = i8;
        i1 = i10;
        i3 = i11;
        break;
        i7 = i1;
        i4 = -1;
        i8 = 0;
        continue;
        i7 = i1;
        i4 = -1;
        i8 = 1;
        continue;
        int i22 = i5 - 65520;
        i4 = 1;
        int i23 = i3;
        i7 = i1;
        i8 = i22;
        i2 = i23;
        continue;
        i4 = 2;
        i2 = i3;
        i7 = i1;
        i8 = 0;
        continue;
        i4 = 3;
        i2 = i3;
        i7 = i1;
        i8 = 0;
        continue;
        int i12 = i1 + 1;
        int i13 = paramArrayOfByte[i12] << 24;
        int i14 = i12 + 1;
        int i15 = i13 + (paramArrayOfByte[i14] << 18);
        int i16 = i14 + 1;
        int i17 = i15 + (paramArrayOfByte[i16] << 12);
        int i18 = i16 + 1;
        int i19 = i17 + (paramArrayOfByte[i18] << 6);
        int i20 = i18 + 1;
        int i21 = i19 + paramArrayOfByte[i20];
        localStringBuilder.append(q.format(i21));
        i8 = i3;
        i7 = i20;
        continue;
        i4 = -1;
        int i6 = i3;
        i7 = i1;
        i8 = i6;
      }
    }
    while ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(-1 + localStringBuilder.length()) == 65532))
      localStringBuilder.setLength(-1 + localStringBuilder.length());
    return localStringBuilder.toString();
  }

  private static int b(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, new byte[] { 55, 56, 57, 58, 59, 60, 49, 50, 51, 52 });
  }

  private static int c(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, new byte[] { 39, 40, 41, 42, 31, 32 });
  }

  private static int d(byte[] paramArrayOfByte)
  {
    return a(paramArrayOfByte, new byte[] { 33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2 });
  }

  private static String e(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[6];
    arrayOfChar[0] = s[0].charAt(a(paramArrayOfByte, new byte[] { 39, 40, 41, 42, 31, 32 }));
    arrayOfChar[1] = s[0].charAt(a(paramArrayOfByte, new byte[] { 33, 34, 35, 36, 25, 26 }));
    arrayOfChar[2] = s[0].charAt(a(paramArrayOfByte, new byte[] { 27, 28, 29, 30, 19, 20 }));
    arrayOfChar[3] = s[0].charAt(a(paramArrayOfByte, new byte[] { 21, 22, 23, 24, 13, 14 }));
    arrayOfChar[4] = s[0].charAt(a(paramArrayOfByte, new byte[] { 15, 16, 17, 18, 7, 8 }));
    arrayOfChar[5] = s[0].charAt(a(paramArrayOfByte, new byte[] { 9, 10, 11, 12, 1, 2 }));
    return String.valueOf(arrayOfChar);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.maxicode.decoder.b
 * JD-Core Version:    0.6.2
 */