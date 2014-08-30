package de.greenrobot.dao.query;

import java.util.NoSuchElementException;

public class LazyList$LazyIterator
  implements CloseableListIterator<E>
{
  private final boolean closeWhenDone;
  private int index;

  public LazyList$LazyIterator(LazyList paramLazyList, int paramInt, boolean paramBoolean)
  {
    this.index = paramInt;
    this.closeWhenDone = paramBoolean;
  }

  public void add(E paramE)
  {
    throw new UnsupportedOperationException();
  }

  public void close()
  {
    this.this$0.close();
  }

  public boolean hasNext()
  {
    return this.index < LazyList.access$000(this.this$0);
  }

  public boolean hasPrevious()
  {
    return this.index > 0;
  }

  public E next()
  {
    if (this.index >= LazyList.access$000(this.this$0))
      throw new NoSuchElementException();
    Object localObject = this.this$0.get(this.index);
    this.index = (1 + this.index);
    if ((this.index == LazyList.access$000(this.this$0)) && (this.closeWhenDone))
      close();
    return localObject;
  }

  public int nextIndex()
  {
    return this.index;
  }

  public E previous()
  {
    if (this.index <= 0)
      throw new NoSuchElementException();
    this.index = (-1 + this.index);
    return this.this$0.get(this.index);
  }

  public int previousIndex()
  {
    return -1 + this.index;
  }

  public void remove()
  {
    throw new UnsupportedOperationException();
  }

  public void set(E paramE)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.query.LazyList.LazyIterator
 * JD-Core Version:    0.6.2
 */