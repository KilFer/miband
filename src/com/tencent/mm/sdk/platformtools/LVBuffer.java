package com.tencent.mm.sdk.platformtools;

import java.nio.ByteBuffer;

public class LVBuffer
{
  public static final int LENGTH_ALLOC_PER_NEW = 4096;
  public static final int MAX_STRING_LENGTH = 2048;
  private ByteBuffer a;
  private boolean b;

  private int a(int paramInt)
  {
    if (this.a.limit() - this.a.position() > paramInt)
      return 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(4096 + this.a.limit());
    localByteBuffer.put(this.a.array(), 0, this.a.position());
    this.a = localByteBuffer;
    return 0;
  }

  public byte[] buildFinish()
  {
    if (!this.b)
      throw new Exception("Buffer For Parse");
    a(1);
    this.a.put((byte)125);
    byte[] arrayOfByte = new byte[this.a.position()];
    System.arraycopy(this.a.array(), 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }

  public boolean checkGetFinish()
  {
    return this.a.limit() - this.a.position() <= 1;
  }

  public int getInt()
  {
    if (this.b)
      throw new Exception("Buffer For Build");
    return this.a.getInt();
  }

  public long getLong()
  {
    if (this.b)
      throw new Exception("Buffer For Build");
    return this.a.getLong();
  }

  public String getString()
  {
    if (this.b)
      throw new Exception("Buffer For Build");
    int i = this.a.getShort();
    if (i > 2048)
    {
      this.a = null;
      throw new Exception("Buffer String Length Error");
    }
    if (i == 0)
      return "";
    byte[] arrayOfByte = new byte[i];
    this.a.get(arrayOfByte, 0, i);
    return new String(arrayOfByte);
  }

  public int initBuild()
  {
    this.a = ByteBuffer.allocate(4096);
    this.a.put((byte)123);
    this.b = true;
    return 0;
  }

  public int initParse(byte[] paramArrayOfByte)
  {
    int i;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
      i = -1;
    while (i != 0)
    {
      this.a = null;
      return -1;
      if (paramArrayOfByte[0] != 123)
        i = -2;
      else if (paramArrayOfByte[(-1 + paramArrayOfByte.length)] != 125)
        i = -3;
      else
        i = 0;
    }
    this.a = ByteBuffer.wrap(paramArrayOfByte);
    this.a.position(1);
    this.b = false;
    return 0;
  }

  public int putInt(int paramInt)
  {
    if (!this.b)
      throw new Exception("Buffer For Parse");
    a(4);
    this.a.putInt(paramInt);
    return 0;
  }

  public int putLong(long paramLong)
  {
    if (!this.b)
      throw new Exception("Buffer For Parse");
    a(8);
    this.a.putLong(paramLong);
    return 0;
  }

  public int putString(String paramString)
  {
    if (!this.b)
      throw new Exception("Buffer For Parse");
    byte[] arrayOfByte = null;
    if (paramString != null)
      arrayOfByte = paramString.getBytes();
    if (arrayOfByte == null)
      arrayOfByte = new byte[0];
    if (arrayOfByte.length > 2048)
      throw new Exception("Buffer String Length Error");
    a(2 + arrayOfByte.length);
    this.a.putShort((short)arrayOfByte.length);
    if (arrayOfByte.length > 0)
      this.a.put(arrayOfByte);
    return 0;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.LVBuffer
 * JD-Core Version:    0.6.2
 */