package de.greenrobot.dao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public class IdentityScopeObject<K, T>
  implements IdentityScope<K, T>
{
  private final ReentrantLock lock = new ReentrantLock();
  private final HashMap<K, Reference<T>> map = new HashMap();

  public void clear()
  {
    this.lock.lock();
    try
    {
      this.map.clear();
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }

  public boolean detach(K paramK, T paramT)
  {
    this.lock.lock();
    try
    {
      if ((get(paramK) == paramT) && (paramT != null))
      {
        remove(paramK);
        return true;
      }
      return false;
    }
    finally
    {
      this.lock.unlock();
    }
  }

  public T get(K paramK)
  {
    this.lock.lock();
    try
    {
      Reference localReference = (Reference)this.map.get(paramK);
      this.lock.unlock();
      if (localReference != null)
        return localReference.get();
    }
    finally
    {
      this.lock.unlock();
    }
    return null;
  }

  public T getNoLock(K paramK)
  {
    Reference localReference = (Reference)this.map.get(paramK);
    if (localReference != null)
      return localReference.get();
    return null;
  }

  public void lock()
  {
    this.lock.lock();
  }

  public void put(K paramK, T paramT)
  {
    this.lock.lock();
    try
    {
      this.map.put(paramK, new WeakReference(paramT));
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }

  public void putNoLock(K paramK, T paramT)
  {
    this.map.put(paramK, new WeakReference(paramT));
  }

  public void remove(Iterable<K> paramIterable)
  {
    this.lock.lock();
    try
    {
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        this.map.remove(localObject2);
      }
    }
    finally
    {
      this.lock.unlock();
    }
    this.lock.unlock();
  }

  public void remove(K paramK)
  {
    this.lock.lock();
    try
    {
      this.map.remove(paramK);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }

  public void reserveRoom(int paramInt)
  {
  }

  public void unlock()
  {
    this.lock.unlock();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.identityscope.IdentityScopeObject
 * JD-Core Version:    0.6.2
 */