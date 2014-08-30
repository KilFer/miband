package com.nostra13.universalimageloader.core.assist.deque;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E>
  implements BlockingDeque<E>, Serializable
{
  private static final long serialVersionUID = -387911632671998426L;
  transient a<E> a;
  transient a<E> b;
  final ReentrantLock c = new ReentrantLock();
  private transient int d;
  private final int e;
  private final Condition f = this.c.newCondition();
  private final Condition g = this.c.newCondition();

  public LinkedBlockingDeque()
  {
    this(2147483647);
  }

  public LinkedBlockingDeque(int paramInt)
  {
    if (paramInt <= 0)
      throw new IllegalArgumentException();
    this.e = paramInt;
  }

  public LinkedBlockingDeque(Collection<? extends E> paramCollection)
  {
    this(2147483647);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    while (true)
    {
      Object localObject2;
      try
      {
        Iterator localIterator = paramCollection.iterator();
        if (!localIterator.hasNext())
          break;
        localObject2 = localIterator.next();
        if (localObject2 == null)
          throw new NullPointerException();
      }
      finally
      {
        localReentrantLock.unlock();
      }
      if (!c(new a(localObject2)))
        throw new IllegalStateException("Deque full");
    }
    localReentrantLock.unlock();
  }

  private E a()
  {
    a locala1 = this.a;
    if (locala1 == null)
      return null;
    a locala2 = locala1.c;
    Object localObject = locala1.a;
    locala1.a = null;
    locala1.c = locala1;
    this.a = locala2;
    if (locala2 == null)
      this.b = null;
    while (true)
    {
      this.d = (-1 + this.d);
      this.g.signal();
      return localObject;
      locala2.b = null;
    }
  }

  private E b()
  {
    a locala1 = this.b;
    if (locala1 == null)
      return null;
    a locala2 = locala1.b;
    Object localObject = locala1.a;
    locala1.a = null;
    locala1.b = locala1;
    this.b = locala2;
    if (locala2 == null)
      this.a = null;
    while (true)
    {
      this.d = (-1 + this.d);
      this.g.signal();
      return localObject;
      locala2.c = null;
    }
  }

  private boolean b(a<E> parama)
  {
    if (this.d >= this.e)
      return false;
    a locala = this.a;
    parama.c = locala;
    this.a = parama;
    if (this.b == null)
      this.b = parama;
    while (true)
    {
      this.d = (1 + this.d);
      this.f.signal();
      return true;
      locala.b = parama;
    }
  }

  private boolean c(a<E> parama)
  {
    if (this.d >= this.e)
      return false;
    a locala = this.b;
    parama.b = locala;
    this.b = parama;
    if (this.a == null)
      this.a = parama;
    while (true)
    {
      this.d = (1 + this.d);
      this.f.signal();
      return true;
      locala.c = parama;
    }
  }

  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    this.d = 0;
    this.a = null;
    this.b = null;
    while (true)
    {
      Object localObject = paramObjectInputStream.readObject();
      if (localObject == null)
        break;
      add(localObject);
    }
  }

  private void writeObject(ObjectOutputStream paramObjectOutputStream)
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      paramObjectOutputStream.defaultWriteObject();
      for (a locala = this.a; locala != null; locala = locala.c)
        paramObjectOutputStream.writeObject(locala.a);
      paramObjectOutputStream.writeObject(null);
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  final void a(a<E> parama)
  {
    a locala1 = parama.b;
    a locala2 = parama.c;
    if (locala1 == null)
    {
      a();
      return;
    }
    if (locala2 == null)
    {
      b();
      return;
    }
    locala1.c = locala2;
    locala2.b = locala1;
    parama.a = null;
    this.d = (-1 + this.d);
    this.g.signal();
  }

  public boolean add(E paramE)
  {
    addLast(paramE);
    return true;
  }

  public void addFirst(E paramE)
  {
    if (!offerFirst(paramE))
      throw new IllegalStateException("Deque full");
  }

  public void addLast(E paramE)
  {
    if (!offerLast(paramE))
      throw new IllegalStateException("Deque full");
  }

  public void clear()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      a locala;
      for (Object localObject2 = this.a; localObject2 != null; localObject2 = locala)
      {
        ((a)localObject2).a = null;
        locala = ((a)localObject2).c;
        ((a)localObject2).b = null;
        ((a)localObject2).c = null;
      }
      this.b = null;
      this.a = null;
      this.d = 0;
      this.g.signalAll();
      return;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public boolean contains(Object paramObject)
  {
    if (paramObject == null)
      return false;
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (a locala = this.a; locala != null; locala = locala.c)
      {
        boolean bool = paramObject.equals(locala.a);
        if (bool)
          return true;
      }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public Iterator<E> descendingIterator()
  {
    return new c(this, (byte)0);
  }

  public int drainTo(Collection<? super E> paramCollection)
  {
    return drainTo(paramCollection, 2147483647);
  }

  public int drainTo(Collection<? super E> paramCollection, int paramInt)
  {
    if (paramCollection == null)
      throw new NullPointerException();
    if (paramCollection == this)
      throw new IllegalArgumentException();
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = Math.min(paramInt, this.d);
      for (int j = 0; j < i; j++)
      {
        paramCollection.add(this.a.a);
        a();
      }
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E element()
  {
    return getFirst();
  }

  public E getFirst()
  {
    Object localObject = peekFirst();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public E getLast()
  {
    Object localObject = peekLast();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public Iterator<E> iterator()
  {
    return new d(this, (byte)0);
  }

  public boolean offer(E paramE)
  {
    return offerLast(paramE);
  }

  public boolean offer(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    return offerLast(paramE, paramLong, paramTimeUnit);
  }

  public boolean offerFirst(E paramE)
  {
    if (paramE == null)
      throw new NullPointerException();
    a locala = new a(paramE);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      boolean bool = b(locala);
      return bool;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public boolean offerFirst(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE == null)
      throw new NullPointerException();
    a locala = new a(paramE);
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (true)
      {
        boolean bool = b(locala);
        if (bool)
          break;
        if (l1 <= 0L)
          return false;
        long l2 = this.g.awaitNanos(l1);
        l1 = l2;
      }
      return true;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public boolean offerLast(E paramE)
  {
    if (paramE == null)
      throw new NullPointerException();
    a locala = new a(paramE);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      boolean bool = c(locala);
      return bool;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public boolean offerLast(E paramE, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramE == null)
      throw new NullPointerException();
    a locala = new a(paramE);
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lockInterruptibly();
    try
    {
      while (true)
      {
        boolean bool = c(locala);
        if (bool)
          break;
        if (l1 <= 0L)
          return false;
        long l2 = this.g.awaitNanos(l1);
        l1 = l2;
      }
      return true;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E peek()
  {
    return peekFirst();
  }

  public E peekFirst()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      a locala = this.a;
      if (locala == null);
      for (Object localObject2 = null; ; localObject2 = this.a.a)
        return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E peekLast()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      a locala = this.b;
      if (locala == null);
      for (Object localObject2 = null; ; localObject2 = this.b.a)
        return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E poll()
  {
    return pollFirst();
  }

  public E poll(long paramLong, TimeUnit paramTimeUnit)
  {
    return pollFirst(paramLong, paramTimeUnit);
  }

  public E pollFirst()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject2 = a();
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E pollFirst(long paramLong, TimeUnit paramTimeUnit)
  {
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lockInterruptibly();
    long l2 = l1;
    try
    {
      Object localObject2;
      while (true)
      {
        localObject2 = a();
        if (localObject2 != null)
          break;
        if (l2 <= 0L)
          return null;
        long l3 = this.f.awaitNanos(l2);
        l2 = l3;
      }
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E pollLast()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object localObject2 = b();
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E pollLast(long paramLong, TimeUnit paramTimeUnit)
  {
    long l1 = paramTimeUnit.toNanos(paramLong);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lockInterruptibly();
    long l2 = l1;
    try
    {
      Object localObject2;
      while (true)
      {
        localObject2 = b();
        if (localObject2 != null)
          break;
        if (l2 <= 0L)
          return null;
        long l3 = this.f.awaitNanos(l2);
        l2 = l3;
      }
      return localObject2;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E pop()
  {
    return removeFirst();
  }

  public void push(E paramE)
  {
    addFirst(paramE);
  }

  public void put(E paramE)
  {
    putLast(paramE);
  }

  public void putFirst(E paramE)
  {
    if (paramE == null)
      throw new NullPointerException();
    a locala = new a(paramE);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      if (!b(locala))
        this.g.await();
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public void putLast(E paramE)
  {
    if (paramE == null)
      throw new NullPointerException();
    a locala = new a(paramE);
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      if (!c(locala))
        this.g.await();
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public int remainingCapacity()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.e;
      int j = this.d;
      int k = i - j;
      return k;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E remove()
  {
    return removeFirst();
  }

  public boolean remove(Object paramObject)
  {
    return removeFirstOccurrence(paramObject);
  }

  public E removeFirst()
  {
    Object localObject = pollFirst();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public boolean removeFirstOccurrence(Object paramObject)
  {
    if (paramObject == null)
      return false;
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (a locala = this.a; locala != null; locala = locala.c)
        if (paramObject.equals(locala.a))
        {
          a(locala);
          return true;
        }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E removeLast()
  {
    Object localObject = pollLast();
    if (localObject == null)
      throw new NoSuchElementException();
    return localObject;
  }

  public boolean removeLastOccurrence(Object paramObject)
  {
    if (paramObject == null)
      return false;
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      for (a locala = this.b; locala != null; locala = locala.b)
        if (paramObject.equals(locala.a))
        {
          a(locala);
          return true;
        }
      return false;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public int size()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      int i = this.d;
      return i;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public E take()
  {
    return takeFirst();
  }

  public E takeFirst()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    Object localObject2;
    try
    {
      while (true)
      {
        localObject2 = a();
        if (localObject2 != null)
          break;
        this.f.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    localReentrantLock.unlock();
    return localObject2;
  }

  public E takeLast()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    Object localObject2;
    try
    {
      while (true)
      {
        localObject2 = b();
        if (localObject2 != null)
          break;
        this.f.await();
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
    localReentrantLock.unlock();
    return localObject2;
  }

  public Object[] toArray()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      Object[] arrayOfObject = new Object[this.d];
      int i = 0;
      a locala = this.a;
      while (locala != null)
      {
        int j = i + 1;
        arrayOfObject[i] = locala.a;
        locala = locala.c;
        i = j;
      }
      return arrayOfObject;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      if (paramArrayOfT.length < this.d)
        paramArrayOfT = (Object[])Array.newInstance(paramArrayOfT.getClass().getComponentType(), this.d);
      int i = 0;
      a locala = this.a;
      while (locala != null)
      {
        int j = i + 1;
        paramArrayOfT[i] = locala.a;
        locala = locala.c;
        i = j;
      }
      if (paramArrayOfT.length > i)
        paramArrayOfT[i] = null;
      return paramArrayOfT;
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }

  public String toString()
  {
    ReentrantLock localReentrantLock = this.c;
    localReentrantLock.lock();
    try
    {
      a locala1 = this.a;
      if (locala1 == null)
        return "[]";
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('[');
      a locala2;
      for (Object localObject2 = locala1; ; localObject2 = locala2)
      {
        Object localObject3 = ((a)localObject2).a;
        if (localObject3 == this)
          localObject3 = "(this Collection)";
        localStringBuilder.append(localObject3);
        locala2 = ((a)localObject2).c;
        if (locala2 == null)
        {
          String str = ']';
          return str;
        }
        localStringBuilder.append(',').append(' ');
      }
    }
    finally
    {
      localReentrantLock.unlock();
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque
 * JD-Core Version:    0.6.2
 */