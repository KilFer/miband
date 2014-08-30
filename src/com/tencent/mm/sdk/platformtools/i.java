package com.tencent.mm.sdk.platformtools;

import java.nio.ByteBuffer;

final class i
{
  private ByteBuffer a = null;

  private int c()
  {
    return this.a.capacity();
  }

  public final int a()
  {
    return this.a.position();
  }

  public final void a(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    this.a = ByteBuffer.allocateDirect(i);
    this.a.position(0);
    this.a.put(paramArrayOfByte, 0, i);
    this.a.position(0);
  }

  public final ByteBuffer b()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.i
 * JD-Core Version:    0.6.2
 */