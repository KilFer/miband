package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class UsingFreqLimitedMemoryCache extends LimitedMemoryCache
{
  private final Map<Bitmap, Integer> a = Collections.synchronizedMap(new HashMap());

  public UsingFreqLimitedMemoryCache(int paramInt)
  {
    super(paramInt);
  }

  public void clear()
  {
    this.a.clear();
    super.clear();
  }

  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }

  public Bitmap get(String paramString)
  {
    Bitmap localBitmap = super.get(paramString);
    if (localBitmap != null)
    {
      Integer localInteger = (Integer)this.a.get(localBitmap);
      if (localInteger != null)
        this.a.put(localBitmap, Integer.valueOf(1 + localInteger.intValue()));
    }
    return localBitmap;
  }

  protected int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    boolean bool1 = super.put(paramString, paramBitmap);
    boolean bool2 = false;
    if (bool1)
    {
      this.a.put(paramBitmap, Integer.valueOf(0));
      bool2 = true;
    }
    return bool2;
  }

  public void remove(String paramString)
  {
    Bitmap localBitmap = super.get(paramString);
    if (localBitmap != null)
      this.a.remove(localBitmap);
    super.remove(paramString);
  }

  protected Bitmap removeNext()
  {
    Object localObject1 = null;
    Set localSet = this.a.entrySet();
    while (true)
    {
      synchronized (this.a)
      {
        Iterator localIterator = localSet.iterator();
        localObject3 = null;
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          if (localObject1 == null)
          {
            Bitmap localBitmap = (Bitmap)localEntry.getKey();
            Integer localInteger = (Integer)localEntry.getValue();
            localObject1 = localBitmap;
            localObject3 = localInteger;
            continue;
          }
          localObject4 = (Integer)localEntry.getValue();
          if (((Integer)localObject4).intValue() >= localObject3.intValue())
            break label152;
          localObject5 = (Bitmap)localEntry.getKey();
          break label159;
        }
        this.a.remove(localObject1);
        return localObject1;
      }
      label152: Object localObject5 = localObject1;
      Object localObject4 = localObject3;
      label159: localObject1 = localObject5;
      Object localObject3 = localObject4;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache
 * JD-Core Version:    0.6.2
 */