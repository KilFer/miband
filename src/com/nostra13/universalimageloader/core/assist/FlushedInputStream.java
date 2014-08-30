package com.nostra13.universalimageloader.core.assist;

import java.io.FilterInputStream;
import java.io.InputStream;

public class FlushedInputStream extends FilterInputStream
{
  public FlushedInputStream(InputStream paramInputStream)
  {
    super(paramInputStream);
  }

  public long skip(long paramLong)
  {
    long l2;
    for (long l1 = 0L; l1 < paramLong; l1 = l2 + l1)
    {
      l2 = this.in.skip(paramLong - l1);
      if (l2 == 0L)
      {
        if (read() < 0)
          break;
        l2 = 1L;
      }
    }
    return l1;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.FlushedInputStream
 * JD-Core Version:    0.6.2
 */