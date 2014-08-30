package com.tencent.utils;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

final class f extends BufferedOutputStream
{
  private int a = 0;

  private f(OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  private int a()
  {
    return this.a;
  }

  public final void write(byte[] paramArrayOfByte)
  {
    super.write(paramArrayOfByte);
    this.a += paramArrayOfByte.length;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.utils.f
 * JD-Core Version:    0.6.2
 */