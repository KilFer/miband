package com.loopj.android.http;

import java.io.UnsupportedEncodingException;

public class Base64
{
  public static final int CRLF = 4;
  public static final int DEFAULT = 0;
  public static final int NO_CLOSE = 16;
  public static final int NO_PADDING = 1;
  public static final int NO_WRAP = 2;
  public static final int URL_SAFE = 8;

  public static byte[] decode(String paramString, int paramInt)
  {
    return decode(paramString.getBytes(), paramInt);
  }

  public static byte[] decode(byte[] paramArrayOfByte, int paramInt)
  {
    return decode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }

  public static byte[] decode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    h localh = new h(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localh.a(paramArrayOfByte, paramInt1, paramInt2, true))
      throw new IllegalArgumentException("bad base-64");
    if (localh.b == localh.a.length)
      return localh.a;
    byte[] arrayOfByte = new byte[localh.b];
    System.arraycopy(localh.a, 0, arrayOfByte, 0, localh.b);
    return arrayOfByte;
  }

  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
  {
    return encode(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }

  public static byte[] encode(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    i locali = new i(paramInt3, null);
    int i = paramInt2 / 3 << 2;
    int j;
    if (locali.c)
    {
      if (paramInt2 % 3 > 0)
        i += 4;
      if ((locali.d) && (paramInt2 > 0))
      {
        j = 1 + (paramInt2 - 1) / 57;
        if (!locali.e)
          break label159;
      }
    }
    label159: for (int k = 2; ; k = 1)
    {
      i += k * j;
      locali.a = new byte[i];
      locali.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if (locali.b == i)
        break label165;
      throw new AssertionError();
      switch (paramInt2 % 3)
      {
      case 0:
      default:
        break;
      case 1:
        i += 2;
        break;
      case 2:
        i += 3;
        break;
      }
    }
    label165: return locali.a;
  }

  public static String encodeToString(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      String str = new String(encode(paramArrayOfByte, paramInt), "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }

  public static String encodeToString(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      String str = new String(encode(paramArrayOfByte, paramInt1, paramInt2, paramInt3), "US-ASCII");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new AssertionError(localUnsupportedEncodingException);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.Base64
 * JD-Core Version:    0.6.2
 */