package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class e
  implements Closeable
{
  private static final byte a = 13;
  private static final byte b = 10;
  private final InputStream c;
  private final Charset d;
  private byte[] e;
  private int f;
  private int g;

  private e(InputStream paramInputStream, int paramInt, Charset paramCharset)
  {
    if ((paramInputStream == null) || (paramCharset == null))
      throw new NullPointerException();
    if (!paramCharset.equals(g.a))
      throw new IllegalArgumentException("Unsupported encoding");
    this.c = paramInputStream;
    this.d = paramCharset;
    this.e = new byte[8192];
  }

  public e(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, 8192, paramCharset);
  }

  private void b()
  {
    int i = this.c.read(this.e, 0, this.e.length);
    if (i == -1)
      throw new EOFException();
    this.f = 0;
    this.g = i;
  }

  public final String a()
  {
    synchronized (this.c)
    {
      if (this.e == null)
        throw new IOException("LineReader is closed");
    }
    if (this.f >= this.g)
      b();
    for (int i = this.f; ; i++)
    {
      if (i != this.g)
      {
        if (this.e[i] != 10)
          continue;
        if ((i == this.f) || (this.e[(i - 1)] != 13))
          break label272;
      }
      label272: for (int k = i - 1; ; k = i)
      {
        String str2 = new String(this.e, this.f, k - this.f, this.d.name());
        this.f = (i + 1);
        return str2;
        f localf = new f(this, 80 + (this.g - this.f));
        while (true)
        {
          localf.write(this.e, this.f, this.g - this.f);
          this.g = -1;
          b();
          for (int j = this.f; j != this.g; j++)
            if (this.e[j] == 10)
            {
              if (j != this.f)
                localf.write(this.e, this.f, j - this.f);
              this.f = (j + 1);
              String str1 = localf.toString();
              return str1;
            }
        }
      }
    }
  }

  public final void close()
  {
    synchronized (this.c)
    {
      if (this.e != null)
      {
        this.e = null;
        this.c.close();
      }
      return;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.e
 * JD-Core Version:    0.6.2
 */