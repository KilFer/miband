package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.L;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class LimitedMemoryCache extends BaseMemoryCache
{
  private static final int a = 16;
  private static final int b = 16777216;
  private final int c;
  private final AtomicInteger d;
  private final List<Bitmap> e = Collections.synchronizedList(new LinkedList());

  public LimitedMemoryCache(int paramInt)
  {
    this.c = paramInt;
    this.d = new AtomicInteger();
    if (paramInt > 16777216)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(16);
      L.w("You set too large memory cache size (more than %1$d Mb)", arrayOfObject);
    }
  }

  public void clear()
  {
    this.e.clear();
    this.d.set(0);
    super.clear();
  }

  protected abstract int getSize(Bitmap paramBitmap);

  protected int getSizeLimit()
  {
    return this.c;
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    int i = getSize(paramBitmap);
    int j = getSizeLimit();
    int k = this.d.get();
    boolean bool = false;
    if (i < j)
    {
      int m = k;
      while (m + i > j)
      {
        Bitmap localBitmap = removeNext();
        if (this.e.remove(localBitmap))
          m = this.d.addAndGet(-getSize(localBitmap));
      }
      this.e.add(paramBitmap);
      this.d.addAndGet(i);
      bool = true;
    }
    super.put(paramString, paramBitmap);
    return bool;
  }

  public void remove(String paramString)
  {
    Bitmap localBitmap = super.get(paramString);
    if ((localBitmap != null) && (this.e.remove(localBitmap)))
      this.d.addAndGet(-getSize(localBitmap));
    super.remove(paramString);
  }

  protected abstract Bitmap removeNext();
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache
 * JD-Core Version:    0.6.2
 */