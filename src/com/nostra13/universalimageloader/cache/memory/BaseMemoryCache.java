package com.nostra13.universalimageloader.cache.memory;

import android.graphics.Bitmap;
import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class BaseMemoryCache
  implements MemoryCache
{
  private final Map<String, Reference<Bitmap>> a = Collections.synchronizedMap(new HashMap());

  public void clear()
  {
    this.a.clear();
  }

  protected abstract Reference<Bitmap> createReference(Bitmap paramBitmap);

  public Bitmap get(String paramString)
  {
    Reference localReference = (Reference)this.a.get(paramString);
    if (localReference != null)
      return (Bitmap)localReference.get();
    return null;
  }

  public Collection<String> keys()
  {
    synchronized (this.a)
    {
      HashSet localHashSet = new HashSet(this.a.keySet());
      return localHashSet;
    }
  }

  public boolean put(String paramString, Bitmap paramBitmap)
  {
    this.a.put(paramString, createReference(paramBitmap));
    return true;
  }

  public void remove(String paramString)
  {
    this.a.remove(paramString);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.BaseMemoryCache
 * JD-Core Version:    0.6.2
 */