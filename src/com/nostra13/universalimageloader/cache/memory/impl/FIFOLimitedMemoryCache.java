package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FIFOLimitedMemoryCache extends LimitedMemoryCache
{
  private final List<Bitmap> a = Collections.synchronizedList(new LinkedList());

  public FIFOLimitedMemoryCache(int paramInt)
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

  protected int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (super.put(paramString, paramBitmap))
    {
      this.a.add(paramBitmap);
      return true;
    }
    return false;
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
    return (Bitmap)this.a.remove(0);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.FIFOLimitedMemoryCache
 * JD-Core Version:    0.6.2
 */