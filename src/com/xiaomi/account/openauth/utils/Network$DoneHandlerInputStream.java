package com.xiaomi.account.openauth.utils;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class Network$DoneHandlerInputStream extends FilterInputStream
{
  private boolean a;

  public Network$DoneHandlerInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.a)
    {
      int i = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (i != -1)
        return i;
    }
    this.a = true;
    return -1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.account.openauth.utils.Network.DoneHandlerInputStream
 * JD-Core Version:    0.6.2
 */