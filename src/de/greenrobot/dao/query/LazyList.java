package de.greenrobot.dao.query;

import android.database.Cursor;
import de.greenrobot.dao.DaoException;
import de.greenrobot.dao.InternalQueryDaoAccess;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.locks.ReentrantLock;

public class LazyList<E>
  implements Closeable, List<E>
{
  private final Cursor cursor;
  private final InternalQueryDaoAccess<E> daoAccess;
  private final List<E> entities;
  private volatile int loadedCount;
  private final ReentrantLock lock;
  private final int size;

  LazyList(InternalQueryDaoAccess<E> paramInternalQueryDaoAccess, Cursor paramCursor, boolean paramBoolean)
  {
    this.cursor = paramCursor;
    this.daoAccess = paramInternalQueryDaoAccess;
    this.size = paramCursor.getCount();
    if (paramBoolean)
    {
      this.entities = new ArrayList(this.size);
      for (int i = 0; i < this.size; i++)
        this.entities.add(null);
    }
    this.entities = null;
    if (this.size == 0)
      paramCursor.close();
    this.lock = new ReentrantLock();
  }

  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  protected void checkCached()
  {
    if (this.entities == null)
      throw new DaoException("This operation only works with cached lazy lists");
  }

  public void clear()
  {
    throw new UnsupportedOperationException();
  }

  public void close()
  {
    this.cursor.close();
  }

  public boolean contains(Object paramObject)
  {
    loadRemaining();
    return this.entities.contains(paramObject);
  }

  public boolean containsAll(Collection<?> paramCollection)
  {
    loadRemaining();
    return this.entities.containsAll(paramCollection);
  }

  public E get(int paramInt)
  {
    if (this.entities != null)
    {
      Object localObject1 = this.entities.get(paramInt);
      if (localObject1 == null)
        this.lock.lock();
      try
      {
        localObject1 = this.entities.get(paramInt);
        if (localObject1 == null)
        {
          localObject1 = loadEntity(paramInt);
          this.entities.set(paramInt, localObject1);
          this.loadedCount = (1 + this.loadedCount);
          if (this.loadedCount == this.size)
            this.cursor.close();
        }
        return localObject1;
      }
      finally
      {
        this.lock.unlock();
      }
    }
    return loadEntity(paramInt);
  }

  public int getLoadedCount()
  {
    return this.loadedCount;
  }

  public int indexOf(Object paramObject)
  {
    loadRemaining();
    return this.entities.indexOf(paramObject);
  }

  public boolean isClosed()
  {
    return this.cursor.isClosed();
  }

  public boolean isEmpty()
  {
    return this.size == 0;
  }

  public boolean isLoadedCompletely()
  {
    return this.loadedCount == this.size;
  }

  public Iterator<E> iterator()
  {
    return new LazyList.LazyIterator(this, 0, false);
  }

  public int lastIndexOf(Object paramObject)
  {
    loadRemaining();
    return this.entities.lastIndexOf(paramObject);
  }

  public CloseableListIterator<E> listIterator()
  {
    return new LazyList.LazyIterator(this, 0, false);
  }

  public ListIterator<E> listIterator(int paramInt)
  {
    return new LazyList.LazyIterator(this, paramInt, false);
  }

  public CloseableListIterator<E> listIteratorAutoClose()
  {
    return new LazyList.LazyIterator(this, 0, true);
  }

  protected E loadEntity(int paramInt)
  {
    this.cursor.moveToPosition(paramInt);
    Object localObject = this.daoAccess.loadCurrent(this.cursor, 0, true);
    if (localObject == null)
      throw new DaoException("Loading of entity failed (null) at position " + paramInt);
    return localObject;
  }

  public void loadRemaining()
  {
    checkCached();
    int i = this.entities.size();
    for (int j = 0; j < i; j++)
      get(j);
  }

  public E peak(int paramInt)
  {
    if (this.entities != null)
      return this.entities.get(paramInt);
    return null;
  }

  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }

  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }

  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }

  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public int size()
  {
    return this.size;
  }

  public List<E> subList(int paramInt1, int paramInt2)
  {
    checkCached();
    for (int i = paramInt1; i < paramInt2; i++)
      this.entities.get(i);
    return this.entities.subList(paramInt1, paramInt2);
  }

  public Object[] toArray()
  {
    loadRemaining();
    return this.entities.toArray();
  }

  public <T> T[] toArray(T[] paramArrayOfT)
  {
    loadRemaining();
    return this.entities.toArray(paramArrayOfT);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.LazyList
 * JD-Core Version:    0.6.2
 */