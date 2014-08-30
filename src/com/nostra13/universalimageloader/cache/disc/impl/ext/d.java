package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class d
{
  private final String a;
  private final long[] b;
  private boolean c;
  private DiskLruCache.Editor d;
  private long e;

  private d(DiskLruCache paramDiskLruCache, String paramString)
  {
    this.a = paramString;
    this.b = new long[DiskLruCache.f(paramDiskLruCache)];
  }

  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != DiskLruCache.f(this.f))
      throw b(paramArrayOfString);
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.b[i] = Long.parseLong(paramArrayOfString[i]);
        i++;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw b(paramArrayOfString);
    }
  }

  private static IOException b(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }

  public final File a(int paramInt)
  {
    return new File(DiskLruCache.g(this.f), this.a + "." + paramInt);
  }

  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    for (long l : this.b)
      localStringBuilder.append(' ').append(l);
    return localStringBuilder.toString();
  }

  public final File b(int paramInt)
  {
    return new File(DiskLruCache.g(this.f), this.a + "." + paramInt + ".tmp");
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.d
 * JD-Core Version:    0.6.2
 */