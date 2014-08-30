package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Encoder
{
  private static final int[] a = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  private static String b = "ISO-8859-1";

  private static int a(int paramInt)
  {
    if (paramInt < a.length)
      return a[paramInt];
    return -1;
  }

  private static int a(int paramInt, Version paramVersion, Mode paramMode)
  {
    return (7 + (paramInt + (4 + paramMode.getCharacterCountBits(paramVersion)))) / 8;
  }

  private static int a(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, int paramInt, ByteMatrix paramByteMatrix)
  {
    int i = 2147483647;
    int j = -1;
    int k = 0;
    int i17;
    int i16;
    if (k < 8)
    {
      d.a(paramBitArray, paramErrorCorrectionLevel, paramInt, k, paramByteMatrix);
      int m = 0 + a.a(paramByteMatrix);
      int n = 0;
      byte[][] arrayOfByte1 = paramByteMatrix.getArray();
      int i1 = paramByteMatrix.getWidth();
      int i2 = paramByteMatrix.getHeight();
      int i3 = 0;
      while (i3 < i2 - 1)
      {
        int i22 = n;
        for (int i23 = 0; i23 < i1 - 1; i23++)
        {
          int i24 = arrayOfByte1[i3][i23];
          if ((i24 == arrayOfByte1[i3][(i23 + 1)]) && (i24 == arrayOfByte1[(i3 + 1)][i23]) && (i24 == arrayOfByte1[(i3 + 1)][(i23 + 1)]))
            i22 += 3;
        }
        i3++;
        n = i22;
      }
      int i4 = m + n;
      int i5 = 0;
      byte[][] arrayOfByte2 = paramByteMatrix.getArray();
      int i6 = paramByteMatrix.getWidth();
      int i7 = paramByteMatrix.getHeight();
      int i8 = 0;
      while (i8 < i7)
      {
        int i20 = i5;
        for (int i21 = 0; i21 < i6; i21++)
        {
          if ((i21 + 6 < i6) && (arrayOfByte2[i8][i21] == 1) && (arrayOfByte2[i8][(i21 + 1)] == 0) && (arrayOfByte2[i8][(i21 + 2)] == 1) && (arrayOfByte2[i8][(i21 + 3)] == 1) && (arrayOfByte2[i8][(i21 + 4)] == 1) && (arrayOfByte2[i8][(i21 + 5)] == 0) && (arrayOfByte2[i8][(i21 + 6)] == 1) && (((i21 + 10 < i6) && (arrayOfByte2[i8][(i21 + 7)] == 0) && (arrayOfByte2[i8][(i21 + 8)] == 0) && (arrayOfByte2[i8][(i21 + 9)] == 0) && (arrayOfByte2[i8][(i21 + 10)] == 0)) || ((i21 - 4 >= 0) && (arrayOfByte2[i8][(i21 - 1)] == 0) && (arrayOfByte2[i8][(i21 - 2)] == 0) && (arrayOfByte2[i8][(i21 - 3)] == 0) && (arrayOfByte2[i8][(i21 - 4)] == 0))))
            i20 += 40;
          if ((i8 + 6 < i7) && (arrayOfByte2[i8][i21] == 1) && (arrayOfByte2[(i8 + 1)][i21] == 0) && (arrayOfByte2[(i8 + 2)][i21] == 1) && (arrayOfByte2[(i8 + 3)][i21] == 1) && (arrayOfByte2[(i8 + 4)][i21] == 1) && (arrayOfByte2[(i8 + 5)][i21] == 0) && (arrayOfByte2[(i8 + 6)][i21] == 1) && (((i8 + 10 < i7) && (arrayOfByte2[(i8 + 7)][i21] == 0) && (arrayOfByte2[(i8 + 8)][i21] == 0) && (arrayOfByte2[(i8 + 9)][i21] == 0) && (arrayOfByte2[(i8 + 10)][i21] == 0)) || ((i8 - 4 >= 0) && (arrayOfByte2[(i8 - 1)][i21] == 0) && (arrayOfByte2[(i8 - 2)][i21] == 0) && (arrayOfByte2[(i8 - 3)][i21] == 0) && (arrayOfByte2[(i8 - 4)][i21] == 0))))
            i20 += 40;
        }
        i8++;
        i5 = i20;
      }
      int i9 = i4 + i5;
      int i10 = 0;
      byte[][] arrayOfByte3 = paramByteMatrix.getArray();
      int i11 = paramByteMatrix.getWidth();
      int i12 = paramByteMatrix.getHeight();
      int i13 = 0;
      while (i13 < i12)
      {
        int i18 = i10;
        for (int i19 = 0; i19 < i11; i19++)
          if (arrayOfByte3[i13][i19] == 1)
            i18++;
        i13++;
        i10 = i18;
      }
      int i14 = paramByteMatrix.getHeight() * paramByteMatrix.getWidth();
      int i15 = i9 + 10 * (Math.abs((int)(100.0D * (i10 / i14) - 50.0D)) / 5);
      if (i15 >= i)
        break label848;
      i17 = i15;
      i16 = k;
    }
    while (true)
    {
      k++;
      i = i17;
      j = i16;
      break;
      return j;
      label848: i16 = j;
      i17 = i;
    }
  }

  private static int a(ByteMatrix paramByteMatrix)
  {
    int i = 0 + a.a(paramByteMatrix);
    byte[][] arrayOfByte1 = paramByteMatrix.getArray();
    int j = paramByteMatrix.getWidth();
    int k = paramByteMatrix.getHeight();
    int m = 0;
    int n = 0;
    while (m < k - 1)
    {
      for (int i14 = 0; i14 < j - 1; i14++)
      {
        int i15 = arrayOfByte1[m][i14];
        if ((i15 == arrayOfByte1[m][(i14 + 1)]) && (i15 == arrayOfByte1[(m + 1)][i14]) && (i15 == arrayOfByte1[(m + 1)][(i14 + 1)]))
          n += 3;
      }
      m++;
    }
    int i1 = i + n;
    byte[][] arrayOfByte2 = paramByteMatrix.getArray();
    int i2 = paramByteMatrix.getWidth();
    int i3 = paramByteMatrix.getHeight();
    int i4 = 0;
    int i5 = 0;
    while (i4 < i3)
    {
      for (int i13 = 0; i13 < i2; i13++)
      {
        if ((i13 + 6 < i2) && (arrayOfByte2[i4][i13] == 1) && (arrayOfByte2[i4][(i13 + 1)] == 0) && (arrayOfByte2[i4][(i13 + 2)] == 1) && (arrayOfByte2[i4][(i13 + 3)] == 1) && (arrayOfByte2[i4][(i13 + 4)] == 1) && (arrayOfByte2[i4][(i13 + 5)] == 0) && (arrayOfByte2[i4][(i13 + 6)] == 1) && (((i13 + 10 < i2) && (arrayOfByte2[i4][(i13 + 7)] == 0) && (arrayOfByte2[i4][(i13 + 8)] == 0) && (arrayOfByte2[i4][(i13 + 9)] == 0) && (arrayOfByte2[i4][(i13 + 10)] == 0)) || ((i13 - 4 >= 0) && (arrayOfByte2[i4][(i13 - 1)] == 0) && (arrayOfByte2[i4][(i13 - 2)] == 0) && (arrayOfByte2[i4][(i13 - 3)] == 0) && (arrayOfByte2[i4][(i13 - 4)] == 0))))
          i5 += 40;
        if ((i4 + 6 < i3) && (arrayOfByte2[i4][i13] == 1) && (arrayOfByte2[(i4 + 1)][i13] == 0) && (arrayOfByte2[(i4 + 2)][i13] == 1) && (arrayOfByte2[(i4 + 3)][i13] == 1) && (arrayOfByte2[(i4 + 4)][i13] == 1) && (arrayOfByte2[(i4 + 5)][i13] == 0) && (arrayOfByte2[(i4 + 6)][i13] == 1) && (((i4 + 10 < i3) && (arrayOfByte2[(i4 + 7)][i13] == 0) && (arrayOfByte2[(i4 + 8)][i13] == 0) && (arrayOfByte2[(i4 + 9)][i13] == 0) && (arrayOfByte2[(i4 + 10)][i13] == 0)) || ((i4 - 4 >= 0) && (arrayOfByte2[(i4 - 1)][i13] == 0) && (arrayOfByte2[(i4 - 2)][i13] == 0) && (arrayOfByte2[(i4 - 3)][i13] == 0) && (arrayOfByte2[(i4 - 4)][i13] == 0))))
          i5 += 40;
      }
      i4++;
    }
    int i6 = i1 + i5;
    byte[][] arrayOfByte3 = paramByteMatrix.getArray();
    int i7 = paramByteMatrix.getWidth();
    int i8 = paramByteMatrix.getHeight();
    int i9 = 0;
    int i10 = 0;
    while (i9 < i8)
    {
      for (int i12 = 0; i12 < i7; i12++)
        if (arrayOfByte3[i9][i12] == 1)
          i10++;
      i9++;
    }
    int i11 = paramByteMatrix.getHeight() * paramByteMatrix.getWidth();
    return i6 + 10 * (Math.abs((int)(100.0D * (i10 / i11) - 50.0D)) / 5);
  }

  private static Mode a(String paramString1, String paramString2)
  {
    int i = 0;
    if ("Shift_JIS".equals(paramString2))
    {
      if (a(paramString1))
        return Mode.KANJI;
      return Mode.BYTE;
    }
    int j = 0;
    int k = 0;
    if (i < paramString1.length())
    {
      int m = paramString1.charAt(i);
      if ((m >= 48) && (m <= 57))
        k = 1;
      while (true)
      {
        i++;
        break;
        if (a(m) == -1)
          break label83;
        j = 1;
      }
      label83: return Mode.BYTE;
    }
    if (j != 0)
      return Mode.ALPHANUMERIC;
    if (k != 0)
      return Mode.NUMERIC;
    return Mode.BYTE;
  }

  private static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramInt4 >= paramInt3)
      throw new WriterException("Block ID too large");
    int i = paramInt1 % paramInt3;
    int j = paramInt3 - i;
    int k = paramInt1 / paramInt3;
    int m = k + 1;
    int n = paramInt2 / paramInt3;
    int i1 = n + 1;
    int i2 = k - n;
    int i3 = m - i1;
    if (i2 != i3)
      throw new WriterException("EC bytes mismatch");
    if (paramInt3 != j + i)
      throw new WriterException("RS blocks mismatch");
    if (paramInt1 != j * (n + i2) + i * (i1 + i3))
      throw new WriterException("Total bytes mismatch");
    if (paramInt4 < j)
    {
      paramArrayOfInt1[0] = n;
      paramArrayOfInt2[0] = i2;
      return;
    }
    paramArrayOfInt1[0] = i1;
    paramArrayOfInt2[0] = i3;
  }

  private static void a(int paramInt1, int paramInt2, Mode paramMode, BitArray paramBitArray)
  {
    int i = paramMode.getCharacterCountBits(Version.getVersionForNumber(paramInt2));
    if (paramInt1 > -1 + (1 << i))
      throw new WriterException(paramInt1 + "is bigger than" + (-1 + (1 << i)));
    paramBitArray.appendBits(paramInt1, i);
  }

  private static void a(int paramInt, BitArray paramBitArray)
  {
    int i = paramInt << 3;
    if (paramBitArray.getSize() > i)
      throw new WriterException("data bits cannot fit in the QR Code" + paramBitArray.getSize() + " > " + i);
    for (int j = 0; (j < 4) && (paramBitArray.getSize() < i); j++)
      paramBitArray.appendBit(false);
    int k = 0x7 & paramBitArray.getSize();
    if (k > 0)
      while (k < 8)
      {
        paramBitArray.appendBit(false);
        k++;
      }
    int m = paramInt - paramBitArray.getSizeInBytes();
    int n = 0;
    if (n < m)
    {
      if ((n & 0x1) == 0);
      for (int i1 = 236; ; i1 = 17)
      {
        paramBitArray.appendBits(i1, 8);
        n++;
        break;
      }
    }
    if (paramBitArray.getSize() != i)
      throw new WriterException("Bits size does not equal capacity");
  }

  private static void a(int paramInt, ErrorCorrectionLevel paramErrorCorrectionLevel, Mode paramMode, QRCode paramQRCode)
  {
    paramQRCode.setECLevel(paramErrorCorrectionLevel);
    paramQRCode.setMode(paramMode);
    for (int i = 1; i <= 40; i++)
    {
      Version localVersion = Version.getVersionForNumber(i);
      int j = localVersion.getTotalCodewords();
      Version.ECBlocks localECBlocks = localVersion.getECBlocksForLevel(paramErrorCorrectionLevel);
      int k = localECBlocks.getTotalECCodewords();
      int m = localECBlocks.getNumBlocks();
      int n = j - k;
      if (n >= (7 + (paramInt + (4 + paramMode.getCharacterCountBits(localVersion)))) / 8)
      {
        paramQRCode.setVersion(i);
        paramQRCode.setNumTotalBytes(j);
        paramQRCode.setNumDataBytes(n);
        paramQRCode.setNumRSBlocks(m);
        paramQRCode.setNumECBytes(k);
        paramQRCode.setMatrixWidth(localVersion.getDimensionForVersion());
        return;
      }
    }
    throw new WriterException("Cannot find proper rs block info (input data too big?)");
  }

  private static void a(BitArray paramBitArray1, int paramInt1, int paramInt2, int paramInt3, BitArray paramBitArray2)
  {
    if (paramBitArray1.getSizeInBytes() != paramInt2)
      throw new WriterException("Number of bits and data bytes does not match");
    ArrayList localArrayList = new ArrayList(paramInt3);
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    if (i < paramInt3)
    {
      int[] arrayOfInt1 = new int[1];
      int[] arrayOfInt2 = new int[1];
      if (i >= paramInt3)
        throw new WriterException("Block ID too large");
      int i2 = paramInt1 % paramInt3;
      int i3 = paramInt3 - i2;
      int i4 = paramInt1 / paramInt3;
      int i5 = i4 + 1;
      int i6 = paramInt2 / paramInt3;
      int i7 = i6 + 1;
      int i8 = i4 - i6;
      int i9 = i5 - i7;
      if (i8 != i9)
        throw new WriterException("EC bytes mismatch");
      if (paramInt3 != i3 + i2)
        throw new WriterException("RS blocks mismatch");
      if (paramInt1 != i3 * (i6 + i8) + i2 * (i7 + i9))
        throw new WriterException("Total bytes mismatch");
      if (i < i3)
      {
        arrayOfInt1[0] = i6;
        arrayOfInt2[0] = i8;
      }
      while (true)
      {
        int i10 = arrayOfInt1[0];
        byte[] arrayOfByte3 = new byte[i10];
        paramBitArray1.toBytes(j * 8, arrayOfByte3, 0, i10);
        byte[] arrayOfByte4 = a(arrayOfByte3, arrayOfInt2[0]);
        localArrayList.add(new a(arrayOfByte3, arrayOfByte4));
        k = Math.max(k, i10);
        int i11 = Math.max(m, arrayOfByte4.length);
        int i12 = j + arrayOfInt1[0];
        i++;
        j = i12;
        m = i11;
        break;
        arrayOfInt1[0] = i7;
        arrayOfInt2[0] = i9;
      }
    }
    if (paramInt2 != j)
      throw new WriterException("Data bytes does not match offset");
    for (int n = 0; n < k; n++)
    {
      Iterator localIterator2 = localArrayList.iterator();
      while (localIterator2.hasNext())
      {
        byte[] arrayOfByte2 = ((a)localIterator2.next()).a();
        if (n < arrayOfByte2.length)
          paramBitArray2.appendBits(arrayOfByte2[n], 8);
      }
    }
    for (int i1 = 0; i1 < m; i1++)
    {
      Iterator localIterator1 = localArrayList.iterator();
      while (localIterator1.hasNext())
      {
        byte[] arrayOfByte1 = ((a)localIterator1.next()).b();
        if (i1 < arrayOfByte1.length)
          paramBitArray2.appendBits(arrayOfByte1[i1], 8);
      }
    }
    if (paramInt1 != paramBitArray2.getSizeInBytes())
      throw new WriterException("Interleaving error: " + paramInt1 + " and " + paramBitArray2.getSizeInBytes() + " differ.");
  }

  private static void a(CharacterSetECI paramCharacterSetECI, BitArray paramBitArray)
  {
    paramBitArray.appendBits(Mode.ECI.getBits(), 4);
    paramBitArray.appendBits(paramCharacterSetECI.getValue(), 8);
  }

  private static void a(Mode paramMode, BitArray paramBitArray)
  {
    paramBitArray.appendBits(paramMode.getBits(), 4);
  }

  private static void a(CharSequence paramCharSequence, BitArray paramBitArray)
  {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i)
    {
      int k = '￐' + paramCharSequence.charAt(j);
      if (j + 2 < i)
      {
        int m = '￐' + paramCharSequence.charAt(j + 1);
        paramBitArray.appendBits('￐' + paramCharSequence.charAt(j + 2) + (k * 100 + m * 10), 10);
        j += 3;
      }
      else if (j + 1 < i)
      {
        paramBitArray.appendBits('￐' + paramCharSequence.charAt(j + 1) + k * 10, 7);
        j += 2;
      }
      else
      {
        paramBitArray.appendBits(k, 4);
        j++;
      }
    }
  }

  private static void a(String paramString, BitArray paramBitArray)
  {
    while (true)
    {
      int j;
      int m;
      int n;
      try
      {
        byte[] arrayOfByte = paramString.getBytes("Shift_JIS");
        int i = arrayOfByte.length;
        j = 0;
        if (j >= i)
          break label158;
        int k = 0xFF & arrayOfByte[j];
        m = 0xFF & arrayOfByte[(j + 1)] | k << 8;
        if ((m >= 33088) && (m <= 40956))
        {
          n = m - 33088;
          if (n != -1)
            break label130;
          throw new WriterException("Invalid byte sequence");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new WriterException(localUnsupportedEncodingException.toString());
      }
      if ((m >= 57408) && (m <= 60351))
      {
        n = m - 49472;
        continue;
        label130: paramBitArray.appendBits(192 * (n >> 8) + (n & 0xFF), 13);
        j += 2;
      }
      else
      {
        label158: n = -1;
      }
    }
  }

  private static void a(String paramString1, BitArray paramBitArray, String paramString2)
  {
    try
    {
      byte[] arrayOfByte = paramString1.getBytes(paramString2);
      int i = arrayOfByte.length;
      for (int j = 0; j < i; j++)
        paramBitArray.appendBits(arrayOfByte[j], 8);
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new WriterException(localUnsupportedEncodingException.toString());
    }
  }

  private static void a(String paramString1, Mode paramMode, BitArray paramBitArray, String paramString2)
  {
    int i = 0;
    int i5;
    switch (b.a[paramMode.ordinal()])
    {
    default:
      throw new WriterException("Invalid mode: " + paramMode);
    case 1:
      i5 = paramString1.length();
    case 2:
    case 3:
      while (i < i5)
      {
        int i6 = '￐' + paramString1.charAt(i);
        if (i + 2 < i5)
        {
          int i7 = '￐' + paramString1.charAt(i + 1);
          paramBitArray.appendBits('￐' + paramString1.charAt(i + 2) + (i6 * 100 + i7 * 10), 10);
          i += 3;
        }
        else if (i + 1 < i5)
        {
          paramBitArray.appendBits('￐' + paramString1.charAt(i + 1) + i6 * 10, 7);
          i += 2;
        }
        else
        {
          paramBitArray.appendBits(i6, 4);
          i++;
          continue;
          int i2 = paramString1.length();
          while (i < i2)
          {
            int i3 = a(paramString1.charAt(i));
            if (i3 == -1)
              throw new WriterException();
            if (i + 1 < i2)
            {
              int i4 = a(paramString1.charAt(i + 1));
              if (i4 == -1)
                throw new WriterException();
              paramBitArray.appendBits(i4 + i3 * 45, 11);
              i += 2;
            }
            else
            {
              paramBitArray.appendBits(i3, 6);
              i++;
              continue;
              try
              {
                byte[] arrayOfByte2 = paramString1.getBytes(paramString2);
                int i1 = arrayOfByte2.length;
                while (i < i1)
                {
                  paramBitArray.appendBits(arrayOfByte2[i], 8);
                  i++;
                }
              }
              catch (UnsupportedEncodingException localUnsupportedEncodingException2)
              {
                throw new WriterException(localUnsupportedEncodingException2.toString());
              }
            }
          }
        }
      }
    case 4:
    }
    while (true)
    {
      int m;
      int n;
      try
      {
        byte[] arrayOfByte1 = paramString1.getBytes("Shift_JIS");
        int j = arrayOfByte1.length;
        if (i >= j)
          break label533;
        int k = 0xFF & arrayOfByte1[i];
        m = 0xFF & arrayOfByte1[(i + 1)] | k << 8;
        if ((m >= 33088) && (m <= 40956))
        {
          n = m - 33088;
          if (n != -1)
            break label505;
          throw new WriterException("Invalid byte sequence");
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        throw new WriterException(localUnsupportedEncodingException1.toString());
      }
      if ((m >= 57408) && (m <= 60351))
      {
        n = m - 49472;
        continue;
        label505: paramBitArray.appendBits(192 * (n >> 8) + (n & 0xFF), 13);
        i += 2;
      }
      else
      {
        label533: n = -1;
      }
    }
  }

  private static boolean a(String paramString)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes("Shift_JIS");
      int i = arrayOfByte.length;
      if (i % 2 != 0)
        return false;
      for (int j = 0; ; j += 2)
      {
        if (j >= i)
          break label75;
        int k = 0xFF & arrayOfByte[j];
        if (((k < 129) || (k > 159)) && ((k < 224) || (k > 235)))
          break;
      }
      label75: return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    return false;
  }

  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = paramArrayOfByte.length;
    int[] arrayOfInt = new int[j + paramInt];
    for (int k = 0; k < j; k++)
      arrayOfInt[k] = (0xFF & paramArrayOfByte[k]);
    new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(arrayOfInt, paramInt);
    byte[] arrayOfByte = new byte[paramInt];
    while (i < paramInt)
    {
      arrayOfByte[i] = ((byte)arrayOfInt[(j + i)]);
      i++;
    }
    return arrayOfByte;
  }

  private static void b(CharSequence paramCharSequence, BitArray paramBitArray)
  {
    int i = paramCharSequence.length();
    int j = 0;
    while (j < i)
    {
      int k = a(paramCharSequence.charAt(j));
      if (k == -1)
        throw new WriterException();
      if (j + 1 < i)
      {
        int m = a(paramCharSequence.charAt(j + 1));
        if (m == -1)
          throw new WriterException();
        paramBitArray.appendBits(m + k * 45, 11);
        j += 2;
      }
      else
      {
        paramBitArray.appendBits(k, 6);
        j++;
      }
    }
  }

  public static Mode chooseMode(String paramString)
  {
    return a(paramString, null);
  }

  public static void encode(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel, QRCode paramQRCode)
  {
    encode(paramString, paramErrorCorrectionLevel, null, paramQRCode);
  }

  public static void encode(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<EncodeHintType, ?> paramMap, QRCode paramQRCode)
  {
    int i = 0;
    if (paramMap == null);
    Mode localMode;
    BitArray localBitArray1;
    for (String str = null; ; str = (String)paramMap.get(EncodeHintType.CHARACTER_SET))
    {
      if (str == null)
        str = "ISO-8859-1";
      localMode = a(paramString, str);
      localBitArray1 = new BitArray();
      switch (b.a[localMode.ordinal()])
      {
      default:
        throw new WriterException("Invalid mode: " + localMode);
      case 1:
      case 2:
      case 3:
      case 4:
      }
    }
    int i2 = paramString.length();
    while (i < i2)
    {
      int i3 = '￐' + paramString.charAt(i);
      if (i + 2 < i2)
      {
        int i4 = '￐' + paramString.charAt(i + 1);
        localBitArray1.appendBits('￐' + paramString.charAt(i + 2) + (i3 * 100 + i4 * 10), 10);
        i += 3;
      }
      else if (i + 1 < i2)
      {
        localBitArray1.appendBits('￐' + paramString.charAt(i + 1) + i3 * 10, 7);
        i += 2;
      }
      else
      {
        localBitArray1.appendBits(i3, 4);
        i++;
        continue;
        int m = paramString.length();
        while (i < m)
        {
          int n = a(paramString.charAt(i));
          if (n == -1)
            throw new WriterException();
          if (i + 1 < m)
          {
            int i1 = a(paramString.charAt(i + 1));
            if (i1 == -1)
              throw new WriterException();
            localBitArray1.appendBits(i1 + n * 45, 11);
            i += 2;
          }
          else
          {
            localBitArray1.appendBits(n, 6);
            i++;
            continue;
            a(paramString, localBitArray1, str);
          }
        }
      }
    }
    a(localBitArray1.getSize(), paramErrorCorrectionLevel, localMode, paramQRCode);
    BitArray localBitArray2 = new BitArray();
    if ((localMode == Mode.BYTE) && (!"ISO-8859-1".equals(str)))
    {
      CharacterSetECI localCharacterSetECI = CharacterSetECI.getCharacterSetECIByName(str);
      if (localCharacterSetECI != null)
      {
        localBitArray2.appendBits(Mode.ECI.getBits(), 4);
        localBitArray2.appendBits(localCharacterSetECI.getValue(), 8);
      }
    }
    localBitArray2.appendBits(localMode.getBits(), 4);
    if (localMode == Mode.BYTE);
    int k;
    for (int j = localBitArray1.getSizeInBytes(); ; j = paramString.length())
    {
      k = localMode.getCharacterCountBits(Version.getVersionForNumber(paramQRCode.getVersion()));
      if (j <= -1 + (1 << k))
        break label569;
      throw new WriterException(j + "is bigger than" + (-1 + (1 << k)));
      a(paramString, localBitArray1);
      break;
    }
    label569: localBitArray2.appendBits(j, k);
    localBitArray2.appendBitArray(localBitArray1);
    a(paramQRCode.getNumDataBytes(), localBitArray2);
    BitArray localBitArray3 = new BitArray();
    a(localBitArray2, paramQRCode.getNumTotalBytes(), paramQRCode.getNumDataBytes(), paramQRCode.getNumRSBlocks(), localBitArray3);
    ByteMatrix localByteMatrix = new ByteMatrix(paramQRCode.getMatrixWidth(), paramQRCode.getMatrixWidth());
    paramQRCode.setMaskPattern(a(localBitArray3, paramErrorCorrectionLevel, paramQRCode.getVersion(), localByteMatrix));
    d.a(localBitArray3, paramErrorCorrectionLevel, paramQRCode.getVersion(), paramQRCode.getMaskPattern(), localByteMatrix);
    paramQRCode.setMatrix(localByteMatrix);
    if (!paramQRCode.isValid())
      throw new WriterException("Invalid QR code: " + paramQRCode.toString());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.encoder.Encoder
 * JD-Core Version:    0.6.2
 */