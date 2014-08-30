package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.Closeable;
import java.io.File;
import java.io.InputStream;

public final class DiskLruCache$Snapshot
  implements Closeable
{
  private final String a;
  private final long b;
  private File[] c;
  private final InputStream[] d;
  private final long[] e;

  private DiskLruCache$Snapshot(DiskLruCache paramDiskLruCache, String paramString, long paramLong, File[] paramArrayOfFile, InputStream[] paramArrayOfInputStream, long[] paramArrayOfLong)
  {
    this.a = paramString;
    this.b = paramLong;
    this.c = paramArrayOfFile;
    this.d = paramArrayOfInputStream;
    this.e = paramArrayOfLong;
  }

  public final void close()
  {
    InputStream[] arrayOfInputStream = this.d;
    int i = arrayOfInputStream.length;
    for (int j = 0; j < i; j++)
      g.a(arrayOfInputStream[j]);
  }

  public final DiskLruCache.Editor edit()
  {
    return DiskLruCache.a(this.f, this.a, this.b);
  }

  public final File getFile(int paramInt)
  {
    return this.c[paramInt];
  }

  public final InputStream getInputStream(int paramInt)
  {
    return this.d[paramInt];
  }

  public final long getLength(int paramInt)
  {
    return this.e[paramInt];
  }

  public final String getString(int paramInt)
  {
    return DiskLruCache.a(getInputStream(paramInt));
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.DiskLruCache.Snapshot
 * JD-Core Version:    0.6.2
 */