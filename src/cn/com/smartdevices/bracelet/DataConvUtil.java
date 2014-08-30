package cn.com.smartdevices.bracelet;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class DataConvUtil
{
  public static int byteToChar(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 0)];
  }

  public static int byteToInt(byte[] paramArrayOfByte)
  {
    int i = 0xFF & paramArrayOfByte[0];
    int j = 0xFF & paramArrayOfByte[1];
    int k = 0xFF & paramArrayOfByte[2];
    return (0xFF & paramArrayOfByte[3]) << 24 | (k << 16 | (i | j << 8));
  }

  public static int byteToInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0xFF & paramArrayOfByte[paramInt];
    int j = 0xFF & paramArrayOfByte[(paramInt + 1)];
    int k = 0xFF & paramArrayOfByte[(paramInt + 2)];
    return (0xFF & paramArrayOfByte[(paramInt + 3)]) << 24 | (k << 16 | (i | j << 8));
  }

  public static long byteToLong(byte[] paramArrayOfByte)
  {
    long l1 = 0xFF & paramArrayOfByte[0];
    long l2 = 0xFF & paramArrayOfByte[1];
    long l3 = 0xFF & paramArrayOfByte[2];
    long l4 = 0xFF & paramArrayOfByte[3];
    long l5 = 0xFF & paramArrayOfByte[4];
    long l6 = 0xFF & paramArrayOfByte[5];
    long l7 = 0xFF & paramArrayOfByte[6];
    long l8 = 0xFF & paramArrayOfByte[7];
    long l9 = l2 << 8;
    long l10 = l3 << 16;
    long l11 = l4 << 24;
    long l12 = l5 << 32;
    long l13 = l6 << 40;
    long l14 = l7 << 48;
    return l8 << 56 | (l14 | (l13 | (l12 | (l11 | (l10 | (l1 | l9))))));
  }

  public static short byteToShort(byte[] paramArrayOfByte)
  {
    return (short)((short)(0xFF & paramArrayOfByte[0]) | (short)((short)(0xFF & paramArrayOfByte[1]) << 8));
  }

  public static short byteToShort(byte[] paramArrayOfByte, int paramInt)
  {
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte, paramInt, 2);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    return localByteBuffer.getShort();
  }

  public static byte[] intToByte(int paramInt)
  {
    byte[] arrayOfByte = new byte[4];
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfByte.length)
        return arrayOfByte;
      arrayOfByte[i] = new Integer(paramInt & 0xFF).byteValue();
      paramInt >>= 8;
    }
  }

  public static byte[] longToByte(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfByte.length)
        return arrayOfByte;
      arrayOfByte[i] = new Long(0xFF & paramLong).byteValue();
      paramLong >>= 8;
    }
  }

  public static byte[] shortToByte(short paramShort)
  {
    byte[] arrayOfByte = new byte[2];
    for (int i = 0; ; i++)
    {
      if (i >= arrayOfByte.length)
        return arrayOfByte;
      arrayOfByte[i] = new Integer(paramShort & 0xFF).byteValue();
      paramShort >>= 8;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     cn.com.smartdevices.bracelet.DataConvUtil
 * JD-Core Version:    0.6.2
 */