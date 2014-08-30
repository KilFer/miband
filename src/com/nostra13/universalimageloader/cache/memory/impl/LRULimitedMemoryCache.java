package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRULimitedMemoryCache extends LimitedMemoryCache
{
  private static final int a = 10;
  private static final float b = 1.1F;
  private final Map<String, Bitmap> c = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));

  public LRULimitedMemoryCache(int paramInt)
  {
    super(paramInt);
  }

  public void clear()
  {
    this.c.clear();
    super.clear();
  }

  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }

  public Bitmap get(String paramString)
  {
    this.c.get(paramString);
    return super.get(paramString);
  }

  protected int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (super.put(paramString, paramBitmap))
    {
      this.c.put(paramString, paramBitmap);
      return true;
    }
    return false;
  }

  public void remove(String paramString)
  {
    this.c.remove(paramString);
    super.remove(paramString);
  }

  protected Bitmap removeNext()
  {
    synchronized (this.c)
    {
      Iterator localIterator = this.c.entrySet().iterator();
      boolean bool = localIterator.hasNext();
      Bitmap localBitmap = null;
      if (bool)
      {
        localBitmap = (Bitmap)((Map.Entry)localIterator.next()).getValue();
        localIterator.remove();
      }
      return localBitmap;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.LRULimitedMemoryCache
 * JD-Core Version:    0.6.2
 */