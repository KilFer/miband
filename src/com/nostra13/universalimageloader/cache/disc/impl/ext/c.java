package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class c extends FilterOutputStream
{
  private c(DiskLruCache.Editor paramEditor, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
  }

  public final void close()
  {
    try
    {
      this.out.close();
      return;
    }
    catch (IOException localIOException)
    {
      DiskLruCache.Editor.a(this.a, true);
    }
  }

  public final void flush()
  {
    try
    {
      this.out.flush();
      return;
    }
    catch (IOException localIOException)
    {
      DiskLruCache.Editor.a(this.a, true);
    }
  }

  public final void write(int paramInt)
  {
    try
    {
      this.out.write(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      DiskLruCache.Editor.a(this.a, true);
    }
  }

  public final void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      DiskLruCache.Editor.a(this.a, true);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.c
 * JD-Core Version:    0.6.2
 */