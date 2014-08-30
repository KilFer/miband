package com.google.zxing.qrcode.decoder;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.BitSource;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.DecoderResult;
import com.google.zxing.common.StringUtils;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class m
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 32, 36, 37, 42, 43, 45, 46, 47, 58 };
  private static final int b = 1;

  private static char a(int paramInt)
  {
    if (paramInt >= a.length)
      throw FormatException.getFormatInstance();
    return a[paramInt];
  }

  private static int a(BitSource paramBitSource)
  {
    int i = paramBitSource.readBits(8);
    if ((i & 0x80) == 0)
      return i & 0x7F;
    if ((i & 0xC0) == 128)
      return paramBitSource.readBits(8) | (i & 0x3F) << 8;
    if ((i & 0xE0) == 192)
      return paramBitSource.readBits(16) | (i & 0x1F) << 16;
    throw new IllegalArgumentException("Bad ECI bits starting with byte " + i);
  }

  static DecoderResult a(byte[] paramArrayOfByte, Version paramVersion, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<DecodeHintType, ?> paramMap)
  {
    BitSource localBitSource = new BitSource(paramArrayOfByte);
    StringBuilder localStringBuilder = new StringBuilder(50);
    CharacterSetECI localCharacterSetECI = null;
    boolean bool1 = false;
    ArrayList localArrayList = new ArrayList(1);
    while (true)
    {
      Object localObject;
      boolean bool2;
      if (localBitSource.available() < 4)
      {
        localObject = Mode.TERMINATOR;
        if (localObject == Mode.TERMINATOR)
          break label502;
        if ((localObject != Mode.FNC1_FIRST_POSITION) && (localObject != Mode.FNC1_SECOND_POSITION))
          break label152;
        bool2 = true;
      }
      while (true)
      {
        label78: if (localObject != Mode.TERMINATOR)
          break label509;
        String str1 = localStringBuilder.toString();
        if (localArrayList.isEmpty())
          localArrayList = null;
        if (paramErrorCorrectionLevel == null);
        for (String str2 = null; ; str2 = paramErrorCorrectionLevel.toString())
        {
          while (true)
          {
            return new DecoderResult(paramArrayOfByte, str1, localArrayList, str2);
            try
            {
              Mode localMode = Mode.forBits(localBitSource.readBits(4));
              localObject = localMode;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              throw FormatException.getFormatInstance();
            }
          }
          label152: if (localObject == Mode.STRUCTURED_APPEND)
          {
            localBitSource.readBits(16);
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.ECI)
          {
            int m = localBitSource.readBits(8);
            int n;
            if ((m & 0x80) == 0)
              n = m & 0x7F;
            while (true)
            {
              localCharacterSetECI = CharacterSetECI.getCharacterSetECIByValue(n);
              if (localCharacterSetECI != null)
                break label315;
              throw FormatException.getFormatInstance();
              if ((m & 0xC0) == 128)
              {
                n = localBitSource.readBits(8) | (m & 0x3F) << 8;
              }
              else
              {
                if ((m & 0xE0) != 192)
                  break;
                n = localBitSource.readBits(16) | (m & 0x1F) << 16;
              }
            }
            throw new IllegalArgumentException("Bad ECI bits starting with byte " + m);
            label315: bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.HANZI)
          {
            int j = localBitSource.readBits(4);
            int k = localBitSource.readBits(((Mode)localObject).getCharacterCountBits(paramVersion));
            if (j == 1)
              a(localBitSource, localStringBuilder, k);
            bool2 = bool1;
            break label78;
          }
          int i = localBitSource.readBits(((Mode)localObject).getCharacterCountBits(paramVersion));
          if (localObject == Mode.NUMERIC)
          {
            c(localBitSource, localStringBuilder, i);
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.ALPHANUMERIC)
          {
            a(localBitSource, localStringBuilder, i, bool1);
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.BYTE)
          {
            a(localBitSource, localStringBuilder, i, localCharacterSetECI, localArrayList, paramMap);
            bool2 = bool1;
            break label78;
          }
          if (localObject == Mode.KANJI)
          {
            b(localBitSource, localStringBuilder, i);
            bool2 = bool1;
            break label78;
          }
          throw FormatException.getFormatInstance();
        }
        label502: bool2 = bool1;
      }
      label509: bool1 = bool2;
    }
  }

  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramBitSource.available())
      throw FormatException.getFormatInstance();
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramBitSource.readBits(13);
      int k = j / 96 << 8 | j % 96;
      if (k < 959);
      for (int m = k + 41377; ; m = k + 42657)
      {
        arrayOfByte[i] = ((byte)(m >> 8));
        arrayOfByte[(i + 1)] = ((byte)m);
        int n = i + 2;
        paramInt--;
        i = n;
        break;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "GB2312"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw FormatException.getFormatInstance();
  }

  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, CharacterSetECI paramCharacterSetECI, Collection<byte[]> paramCollection, Map<DecodeHintType, ?> paramMap)
  {
    if (paramInt << 3 > paramBitSource.available())
      throw FormatException.getFormatInstance();
    byte[] arrayOfByte = new byte[paramInt];
    for (int i = 0; i < paramInt; i++)
      arrayOfByte[i] = ((byte)paramBitSource.readBits(8));
    String str;
    if (paramCharacterSetECI == null)
      str = StringUtils.guessEncoding(arrayOfByte, paramMap);
    try
    {
      while (true)
      {
        paramStringBuilder.append(new String(arrayOfByte, str));
        paramCollection.add(arrayOfByte);
        return;
        str = paramCharacterSetECI.name();
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw FormatException.getFormatInstance();
  }

  private static void a(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt, boolean paramBoolean)
  {
    int i = paramStringBuilder.length();
    while (paramInt > 1)
    {
      int j = paramBitSource.readBits(11);
      paramStringBuilder.append(a(j / 45));
      paramStringBuilder.append(a(j % 45));
      paramInt -= 2;
    }
    if (paramInt == 1)
      paramStringBuilder.append(a(paramBitSource.readBits(6)));
    if (paramBoolean)
      if (i < paramStringBuilder.length())
      {
        if (paramStringBuilder.charAt(i) == '%')
        {
          if ((i >= -1 + paramStringBuilder.length()) || (paramStringBuilder.charAt(i + 1) != '%'))
            break label133;
          paramStringBuilder.deleteCharAt(i + 1);
        }
        while (true)
        {
          i++;
          break;
          label133: paramStringBuilder.setCharAt(i, '\035');
        }
      }
  }

  private static void b(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    if (paramInt * 13 > paramBitSource.available())
      throw FormatException.getFormatInstance();
    byte[] arrayOfByte = new byte[paramInt * 2];
    int i = 0;
    if (paramInt > 0)
    {
      int j = paramBitSource.readBits(13);
      int k = j / 192 << 8 | j % 192;
      if (k < 7936);
      for (int m = k + 33088; ; m = k + 49472)
      {
        arrayOfByte[i] = ((byte)(m >> 8));
        arrayOfByte[(i + 1)] = ((byte)m);
        int n = i + 2;
        paramInt--;
        i = n;
        break;
      }
    }
    try
    {
      paramStringBuilder.append(new String(arrayOfByte, "SJIS"));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    throw FormatException.getFormatInstance();
  }

  private static void c(BitSource paramBitSource, StringBuilder paramStringBuilder, int paramInt)
  {
    while (paramInt >= 3)
    {
      if (paramBitSource.available() < 10)
        throw FormatException.getFormatInstance();
      int k = paramBitSource.readBits(10);
      if (k >= 1000)
        throw FormatException.getFormatInstance();
      paramStringBuilder.append(a(k / 100));
      paramStringBuilder.append(a(k / 10 % 10));
      paramStringBuilder.append(a(k % 10));
      paramInt -= 3;
    }
    if (paramInt == 2)
    {
      if (paramBitSource.available() < 7)
        throw FormatException.getFormatInstance();
      j = paramBitSource.readBits(7);
      if (j >= 100)
        throw FormatException.getFormatInstance();
      paramStringBuilder.append(a(j / 10));
      paramStringBuilder.append(a(j % 10));
    }
    while (paramInt != 1)
    {
      int j;
      return;
    }
    if (paramBitSource.available() < 4)
      throw FormatException.getFormatInstance();
    int i = paramBitSource.readBits(4);
    if (i >= 10)
      throw FormatException.getFormatInstance();
    paramStringBuilder.append(a(i));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.qrcode.decoder.m
 * JD-Core Version:    0.6.2
 */