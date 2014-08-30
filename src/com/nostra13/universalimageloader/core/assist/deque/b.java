package com.nostra13.universalimageloader.core.assist.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;

abstract class b
  implements Iterator<E>
{
  private a<E> a;
  private E b;
  private a<E> c;

  b(LinkedBlockingDeque paramLinkedBlockingDeque)
  {
    ReentrantLock localReentrantLock = paramLinkedBlockingDeque.c;
    localReentrantLock.lock();
    try
    {
      this.a = a();
      if (this.a == null);
      for (Object localObject2 = null; ; localObject2 = this.a.a)
      {
        this.b = localObject2;
        return;
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  private a<E> b(a<E> parama)
  {
    while (true)
    {
      a locala = a(parama);
      if (locala == null)
        locala = null;
      while (locala.a != null)
        return locala;
      if (locala == parama)
        return a();
      parama = locala;
    }
  }

  private void b()
  {
    ReentrantLock localReentrantLock = this.d.c;
    localReentrantLock.lock();
    while (true)
    {
      a locala1;
      try
      {
        localObject2 = this.a;
        locala1 = a((a)localObject2);
        if (locala1 == null)
        {
          locala1 = null;
          this.a = locala1;
          a locala2 = this.a;
          localObject3 = null;
          if (locala2 == null)
            this.b = localObject3;
        }
        else
        {
          if (locala1.a != null)
            continue;
          if (locala1 != localObject2)
            break label105;
          locala1 = a();
          continue;
        }
        Object localObject3 = this.a.a;
        continue;
      }
      finally
      {
        localReentrantLock.unlock();
      }
      label105: Object localObject2 = locala1;
    }
  }

  abstract a<E> a();

  abstract a<E> a(a<E> parama);

  public boolean hasNext()
  {
    return this.a != null;
  }

  public E next()
  {
    if (this.a == null)
      throw new NoSuchElementException();
    this.c = this.a;
    Object localObject = this.b;
    b();
    return localObject;
  }

  public void remove()
  {
    a locala = this.c;
    if (locala == null)
      throw new IllegalStateException();
    this.c = null;
    ReentrantLock localReentrantLock = this.d.c;
    localReentrantLock.lock();
    try
    {
      if (locala.a != null)
        this.d.a(locala);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.b
 * JD-Core Version:    0.6.2
 */