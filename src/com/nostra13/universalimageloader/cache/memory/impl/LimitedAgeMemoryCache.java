package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LimitedAgeMemoryCache
  implements MemoryCache
{
  private final MemoryCache a;
  private final long b;
  private final Map<String, Long> c = Collections.synchronizedMap(new HashMap());

  public LimitedAgeMemoryCache(MemoryCache paramMemoryCache, long paramLong)
  {
    this.a = paramMemoryCache;
    this.b = (1000L * paramLong);
  }

  public void clear()
  {
    this.a.clear();
    this.c.clear();
  }

  public Bitmap get(String paramString)
  {
    Long localLong = (Long)this.c.get(paramString);
    if ((localLong != null) && (System.currentTimeMillis() - localLong.longValue() > this.b))
    {
      this.a.remove(paramString);
      this.c.remove(paramString);
    }
    return (Bitmap)this.a.get(paramString);
  }

  public Collection<String> keys()
  {
    return this.a.keys();
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    boolean bool = this.a.put(paramString, paramBitmap);
    if (bool)
      this.c.put(paramString, Long.valueOf(System.currentTimeMillis()));
    return bool;
  }

  public void remove(String paramString)
  {
    this.a.remove(paramString);
    this.c.remove(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LimitedAgeMemoryCache
 * JD-Core Version:    0.6.2
 */