package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.cache.disc.DiskCache;
import java.io.File;
import java.util.concurrent.Executor;

final class j
  implements Runnable
{
  j(c paramc, l paraml)
  {
  }

  public final void run()
  {
    File localFile = this.b.a.m.get(this.a.a());
    if ((localFile != null) && (localFile.exists()));
    for (int i = 1; ; i = 0)
    {
      c.a(this.b);
      if (i == 0)
        break;
      c.b(this.b).execute(this.a);
      return;
    }
    c.c(this.b).execute(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.j
 * JD-Core Version:    0.6.2
 */