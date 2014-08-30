package com.loopj.android.http;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Base64OutputStream extends FilterOutputStream
{
  private static byte[] e = new byte[0];
  private final g a;
  private final int b;
  private byte[] c = null;
  private int d = 0;

  public Base64OutputStream(OutputStream paramOutputStream, int paramInt)
  {
    this(paramOutputStream, paramInt, true);
  }

  public Base64OutputStream(OutputStream paramOutputStream, int paramInt, boolean paramBoolean)
  {
    super(paramOutputStream);
    this.b = paramInt;
    if (paramBoolean)
    {
      this.a = new i(paramInt, null);
      return;
    }
    this.a = new h(paramInt, null);
  }

  private void a()
  {
    if (this.d > 0)
    {
      a(this.c, 0, this.d, false);
      this.d = 0;
    }
  }

  private void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    g localg = this.a;
    byte[] arrayOfByte = this.a.a;
    int i = this.a.a(paramInt2);
    if ((arrayOfByte == null) || (arrayOfByte.length < i))
      arrayOfByte = new byte[i];
    localg.a = arrayOfByte;
    if (!this.a.a(paramArrayOfByte, paramInt1, paramInt2, paramBoolean))
      throw new Base64DataException("bad base-64");
    this.out.write(this.a.a, 0, this.a.b);
  }

  private static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt))
      paramArrayOfByte = new byte[paramInt];
    return paramArrayOfByte;
  }

  public void close()
  {
    Object localObject1 = null;
    try
    {
      a();
      a(e, 0, 0, true);
    }
    catch (IOException localIOException1)
    {
      try
      {
        if ((0x10 & this.b) == 0)
          this.out.close();
        for (Object localObject2 = localObject1; ; localObject2 = localObject1)
        {
          if (localObject2 == null)
            return;
          throw localObject2;
          localIOException1 = localIOException1;
          localObject1 = localIOException1;
          break;
          this.out.flush();
        }
      }
      catch (IOException localIOException2)
      {
        while (true)
          if (localObject1 == null)
            Object localObject3 = localObject1;
      }
    }
  }

  public void write(int paramInt)
  {
    if (this.c == null)
      this.c = new byte[1024];
    if (this.d >= this.c.length)
    {
      a(this.c, 0, this.d, false);
      this.d = 0;
    }
    byte[] arrayOfByte = this.c;
    int i = this.d;
    this.d = (i + 1);
    arrayOfByte[i] = ((byte)paramInt);
  }

  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 <= 0)
      return;
    a();
    a(paramArrayOfByte, paramInt1, paramInt2, false);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.loopj.android.http.Base64OutputStream
 * JD-Core Version:    0.6.2
 */