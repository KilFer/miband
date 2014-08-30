package com.nostra13.universalimageloader.core.assist;

import java.io.InputStream;

public class ContentLengthInputStream extends InputStream
{
  private final InputStream a;
  private final int b;

  public ContentLengthInputStream(InputStream paramInputStream, int paramInt)
  {
    this.a = paramInputStream;
    this.b = paramInt;
  }

  public int available()
  {
    return this.b;
  }

  public void close()
  {
    this.a.close();
  }

  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }

  public boolean markSupported()
  {
    return this.a.markSupported();
  }

  public int read()
  {
    return this.a.read();
  }

  public int read(byte[] paramArrayOfByte)
  {
    return this.a.read(paramArrayOfByte);
  }

  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
  }

  public void reset()
  {
    this.a.reset();
  }

  public long skip(long paramLong)
  {
    return this.a.skip(paramLong);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.ContentLengthInputStream
 * JD-Core Version:    0.6.2
 */