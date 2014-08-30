package com.xiaomi.infra.galaxy.common.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class StringUtils
{
  public static final int INDEX_NOT_FOUND = -1;

  public static String fromBigDecimal(BigDecimal paramBigDecimal)
  {
    return paramBigDecimal.toString();
  }

  public static String fromBigInteger(BigInteger paramBigInteger)
  {
    return paramBigInteger.toString();
  }

  public static String fromBoolean(Boolean paramBoolean)
  {
    return Boolean.toString(paramBoolean.booleanValue());
  }

  public static String fromByte(Byte paramByte)
  {
    return Byte.toString(paramByte.byteValue());
  }

  public static String fromByteBuffer(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasArray())
      return Base64Utils.encode(paramByteBuffer.array());
    byte[] arrayOfByte = new byte[paramByteBuffer.limit()];
    paramByteBuffer.get(arrayOfByte);
    return Base64Utils.encode(arrayOfByte);
  }

  public static String fromDouble(Double paramDouble)
  {
    return Double.toString(paramDouble.doubleValue());
  }

  public static String fromFloat(Float paramFloat)
  {
    return Float.toString(paramFloat.floatValue());
  }

  public static String fromInteger(Integer paramInteger)
  {
    return Integer.toString(paramInteger.intValue());
  }

  public static String fromLong(Long paramLong)
  {
    return Long.toString(paramLong.longValue());
  }

  public static String fromString(String paramString)
  {
    return paramString;
  }

  public static boolean isBlank(CharSequence paramCharSequence)
  {
    int i;
    boolean bool1;
    if (paramCharSequence != null)
    {
      i = paramCharSequence.length();
      if (i != 0);
    }
    else
    {
      bool1 = true;
      return bool1;
    }
    for (int j = 0; ; j++)
    {
      if (j >= i)
        break label51;
      boolean bool2 = Character.isWhitespace(paramCharSequence.charAt(j));
      bool1 = false;
      if (!bool2)
        break;
    }
    label51: return true;
  }

  public static boolean isEmpty(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() == 0);
  }

  public static boolean isNotBlank(CharSequence paramCharSequence)
  {
    return !isBlank(paramCharSequence);
  }

  public static boolean isNotEmpty(CharSequence paramCharSequence)
  {
    return !isEmpty(paramCharSequence);
  }

  public static String join(String paramString, String[] paramArrayOfString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      localStringBuilder.append(paramArrayOfString[i].toString());
      if (i < -1 + paramArrayOfString.length)
        localStringBuilder.append(paramString);
    }
    return localStringBuilder.toString();
  }

  public static String replace(String paramString1, String paramString2, String paramString3)
  {
    return replace(paramString1, paramString2, paramString3, -1);
  }

  public static String replace(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    int i = 64;
    if ((isEmpty(paramString1)) || (isEmpty(paramString2)) || (paramString3 == null) || (paramInt == 0));
    int j;
    do
    {
      return paramString1;
      j = paramString1.indexOf(paramString2, 0);
    }
    while (j == -1);
    int k = paramString2.length();
    int m = paramString3.length() - k;
    if (m < 0)
      m = 0;
    if (paramInt < 0)
      i = 16;
    StringBuilder localStringBuilder;
    int n;
    while (true)
    {
      localStringBuilder = new StringBuilder(i * m + paramString1.length());
      n = 0;
      while (j != -1)
      {
        localStringBuilder.append(paramString1.substring(n, j)).append(paramString3);
        n = j + k;
        paramInt--;
        if (paramInt == 0)
          break;
        j = paramString1.indexOf(paramString2, n);
      }
      if (paramInt <= i)
        i = paramInt;
    }
    localStringBuilder.append(paramString1.substring(n));
    return localStringBuilder.toString();
  }

  public static BigDecimal toBigDecimal(String paramString)
  {
    return new BigDecimal(paramString);
  }

  public static BigInteger toBigInteger(String paramString)
  {
    return new BigInteger(paramString);
  }

  public static Boolean toBoolean(StringBuilder paramStringBuilder)
  {
    return Boolean.valueOf(Boolean.getBoolean(paramStringBuilder.toString()));
  }

  public static Integer toInteger(StringBuilder paramStringBuilder)
  {
    return Integer.valueOf(Integer.parseInt(paramStringBuilder.toString()));
  }

  public static String toString(StringBuilder paramStringBuilder)
  {
    return paramStringBuilder.toString();
  }

  public static String trim(String paramString)
  {
    if (paramString == null)
      return null;
    return paramString.trim();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.util.StringUtils
 * JD-Core Version:    0.6.2
 */