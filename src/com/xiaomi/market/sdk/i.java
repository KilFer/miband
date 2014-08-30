package com.xiaomi.market.sdk;

import java.io.OutputStream;

public abstract class i extends OutputStream
{
  protected OutputStream S;

  public i(c paramc, OutputStream paramOutputStream)
  {
    if (paramOutputStream == null)
      throw new IllegalArgumentException("outputstream is null");
    this.S = paramOutputStream;
  }

  public void close()
  {
    this.S.close();
  }

  public void flush()
  {
    this.S.flush();
  }

  public abstract void reset();

  public void write(int paramInt)
  {
    this.S.write(paramInt);
  }

  public void write(byte[] paramArrayOfByte)
  {
    this.S.write(paramArrayOfByte);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.S.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.market.sdk.i
 * JD-Core Version:    0.6.2
 */