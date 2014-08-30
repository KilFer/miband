package com.tencent.mm.sdk.storage;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArraySet;

public abstract class MStorageEvent<T, E>
{
  private int a = 0;
  private final Hashtable<T, Object> b = new Hashtable();
  private final CopyOnWriteArraySet<E> c = new CopyOnWriteArraySet();

  private Vector<T> a()
  {
    try
    {
      Vector localVector = new Vector();
      localVector.addAll(this.b.keySet());
      return localVector;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void b()
  {
    Vector localVector = a();
    if ((localVector == null) || (localVector.size() <= 0))
      return;
    HashMap localHashMap = new HashMap();
    Iterator localIterator1 = localVector.iterator();
    while (localIterator1.hasNext())
    {
      Object localObject1 = localIterator1.next();
      Object localObject2 = this.b.get(localObject1);
      Iterator localIterator2 = this.c.iterator();
      while (localIterator2.hasNext())
      {
        Object localObject3 = localIterator2.next();
        if ((localObject3 != null) && (localObject2 != null))
          if ((localObject2 instanceof Looper))
          {
            Looper localLooper = (Looper)localObject2;
            Handler localHandler = (Handler)localHashMap.get(localLooper);
            if (localHandler == null)
            {
              localHandler = new Handler(localLooper);
              localHashMap.put(localLooper, localHandler);
            }
            localHandler.post(new E(this, localObject1, localObject3));
          }
          else
          {
            processEvent(localObject1, localObject3);
          }
      }
    }
    this.c.clear();
  }

  public void add(T paramT, Looper paramLooper)
  {
    try
    {
      if (!this.b.containsKey(paramT))
      {
        if (paramLooper == null)
          break label30;
        this.b.put(paramT, paramLooper);
      }
      while (true)
      {
        return;
        label30: this.b.put(paramT, new Object());
      }
    }
    finally
    {
    }
  }

  public void doNotify()
  {
    if (!isLocked())
      b();
  }

  public boolean event(E paramE)
  {
    return this.c.add(paramE);
  }

  public boolean isLocked()
  {
    return this.a > 0;
  }

  public void lock()
  {
    this.a = (1 + this.a);
  }

  protected abstract void processEvent(T paramT, E paramE);

  public void remove(T paramT)
  {
    try
    {
      this.b.remove(paramT);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void removeAll()
  {
    try
    {
      this.b.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void unlock()
  {
    this.a = (-1 + this.a);
    if (this.a <= 0)
    {
      this.a = 0;
      b();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.storage.MStorageEvent
 * JD-Core Version:    0.6.2
 */