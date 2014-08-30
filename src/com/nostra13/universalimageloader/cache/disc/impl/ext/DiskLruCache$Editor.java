package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class DiskLruCache$Editor
{
  private final d a;
  private final boolean[] b;
  private boolean c;
  private boolean d;

  private DiskLruCache$Editor(DiskLruCache paramDiskLruCache, d paramd)
  {
    this.a = paramd;
    if (d.d(paramd));
    for (boolean[] arrayOfBoolean = null; ; arrayOfBoolean = new boolean[DiskLruCache.f(paramDiskLruCache)])
    {
      this.b = arrayOfBoolean;
      return;
    }
  }

  public final void abort()
  {
    DiskLruCache.a(this.e, this, false);
  }

  public final void abortUnlessCommitted()
  {
    if (!this.d);
    try
    {
      abort();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public final void commit()
  {
    if (this.c)
    {
      DiskLruCache.a(this.e, this, false);
      this.e.c(d.c(this.a));
    }
    while (true)
    {
      this.d = true;
      return;
      DiskLruCache.a(this.e, this, true);
    }
  }

  public final String getString(int paramInt)
  {
    InputStream localInputStream = newInputStream(paramInt);
    if (localInputStream != null)
      return DiskLruCache.a(localInputStream);
    return null;
  }

  public final InputStream newInputStream(int paramInt)
  {
    synchronized (this.e)
    {
      if (d.a(this.a) != this)
        throw new IllegalStateException();
    }
    if (!d.d(this.a))
      return null;
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(this.a.a(paramInt));
      return localFileInputStream;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
    }
    return null;
  }

  public final OutputStream newOutputStream(int paramInt)
  {
    synchronized (this.e)
    {
      if (d.a(this.a) != this)
        throw new IllegalStateException();
    }
    if (!d.d(this.a))
      this.b[paramInt] = true;
    File localFile = this.a.b(paramInt);
    try
    {
      FileOutputStream localFileOutputStream1 = new FileOutputStream(localFile);
      localObject2 = localFileOutputStream1;
      c localc = new c(this, (OutputStream)localObject2, (byte)0);
      return localc;
    }
    catch (FileNotFoundException localFileNotFoundException1)
    {
      while (true)
      {
        Object localObject2;
        DiskLruCache.g(this.e).mkdirs();
        try
        {
          FileOutputStream localFileOutputStream2 = new FileOutputStream(localFile);
          localObject2 = localFileOutputStream2;
        }
        catch (FileNotFoundException localFileNotFoundException2)
        {
          OutputStream localOutputStream = DiskLruCache.e();
          return localOutputStream;
        }
      }
    }
  }

  // ERROR //
  public final void set(int paramInt, String paramString)
  {
    // Byte code:
    //   0: new 115	java/io/OutputStreamWriter
    //   3: dup
    //   4: aload_0
    //   5: iload_1
    //   6: invokevirtual 117	com/nostra13/universalimageloader/cache/disc/impl/ext/DiskLruCache$Editor:newOutputStream	(I)Ljava/io/OutputStream;
    //   9: getstatic 122	com/nostra13/universalimageloader/cache/disc/impl/ext/g:b	Ljava/nio/charset/Charset;
    //   12: invokespecial 125	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   15: astore_3
    //   16: aload_3
    //   17: aload_2
    //   18: invokevirtual 131	java/io/Writer:write	(Ljava/lang/String;)V
    //   21: aload_3
    //   22: invokestatic 134	com/nostra13/universalimageloader/cache/disc/impl/ext/g:a	(Ljava/io/Closeable;)V
    //   25: return
    //   26: astore 4
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_3
    //   31: invokestatic 134	com/nostra13/universalimageloader/cache/disc/impl/ext/g:a	(Ljava/io/Closeable;)V
    //   34: aload 4
    //   36: athrow
    //   37: astore 4
    //   39: goto -9 -> 30
    //
    // Exception table:
    //   from	to	target	type
    //   0	16	26	finally
    //   16	21	37	finally
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Editor
 * JD-Core Version:    0.6.2
 */