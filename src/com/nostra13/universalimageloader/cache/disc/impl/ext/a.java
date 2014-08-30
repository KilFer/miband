package com.nostra13.universalimageloader.cache.disc.impl.ext;

import java.util.concurrent.Callable;

final class a
  implements Callable<Void>
{
  a(DiskLruCache paramDiskLruCache)
  {
  }

  private Void a()
  {
    synchronized (this.a)
    {
      if (DiskLruCache.a(this.a) == null)
        return null;
      DiskLruCache.b(this.a);
      DiskLruCache.c(this.a);
      if (DiskLruCache.d(this.a))
      {
        DiskLruCache.e(this.a);
        DiskLruCache.a(this.a, 0);
      }
      return null;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.impl.ext.a
 * JD-Core Version:    0.6.2
 */