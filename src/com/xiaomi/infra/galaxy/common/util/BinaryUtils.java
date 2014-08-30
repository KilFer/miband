package com.xiaomi.infra.galaxy.common.util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Locale;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BinaryUtils
{
  private static final String DEFAULT_ENCODING = "UTF-8";
  private static final Log log = LogFactory.getLog(BinaryUtils.class);

  public static byte[] fromBase64(String paramString)
  {
    try
    {
      byte[] arrayOfByte = Base64Utils.decode(paramString.getBytes("UTF-8"));
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      log.warn("Tried to Base64-decode a String with the wrong encoding: ", localUnsupportedEncodingException);
    }
    return Base64Utils.decode(paramString.getBytes());
  }

  public static byte[] fromHex(String paramString)
  {
    int i = 0;
    byte[] arrayOfByte = new byte[(1 + paramString.length()) / 2];
    int k;
    for (int j = 0; j < paramString.length(); j = k)
    {
      String str = paramString.substring(j, j + 2);
      k = j + 2;
      int m = i + 1;
      arrayOfByte[i] = ((byte)Integer.parseInt(str, 16));
      i = m;
    }
    return arrayOfByte;
  }

  public static String toBase64(byte[] paramArrayOfByte)
  {
    return Base64Utils.encode(paramArrayOfByte);
  }

  public static String toHex(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length << 1);
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i]);
      if (str.length() == 1)
        localStringBuilder.append("0");
      while (true)
      {
        localStringBuilder.append(str);
        i++;
        break;
        if (str.length() == 8)
          str = str.substring(6);
      }
    }
    return localStringBuilder.toString().toLowerCase(Locale.getDefault());
  }

  public static InputStream toStream(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    return new ByteArrayInputStream(arrayOfByte);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.util.BinaryUtils
 * JD-Core Version:    0.6.2
 */