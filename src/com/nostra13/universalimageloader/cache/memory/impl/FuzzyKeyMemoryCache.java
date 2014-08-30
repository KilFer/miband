package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache
  implements MemoryCache
{
  private final MemoryCache a;
  private final Comparator<String> b;

  public FuzzyKeyMemoryCache(MemoryCache paramMemoryCache, Comparator<String> paramComparator)
  {
    this.a = paramMemoryCache;
    this.b = paramComparator;
  }

  public void clear()
  {
    this.a.clear();
  }

  public Bitmap get(String paramString)
  {
    return (Bitmap)this.a.get(paramString);
  }

  public Collection<String> keys()
  {
    return this.a.keys();
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    while (true)
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.keys().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          if (this.b.compare(paramString, str) != 0)
            continue;
          if (str != null)
            this.a.remove(str);
          return this.a.put(paramString, paramBitmap);
        }
      }
      String str = null;
    }
  }

  public void remove(String paramString)
  {
    this.a.remove(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.FuzzyKeyMemoryCache
 * JD-Core Version:    0.6.2
 */