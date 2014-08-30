package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

abstract class v<T>
  implements Iterator<T>
{
  private w<K, V> a = this.d.c.d;
  private w<K, V> b = null;
  private int c = this.d.b;

  private v(LinkedTreeMap paramLinkedTreeMap)
  {
  }

  final w<K, V> a()
  {
    w localw = this.a;
    if (localw == this.d.c)
      throw new NoSuchElementException();
    if (this.d.b != this.c)
      throw new ConcurrentModificationException();
    this.a = localw.d;
    this.b = localw;
    return localw;
  }

  public final boolean hasNext()
  {
    return this.a != this.d.c;
  }

  public final void remove()
  {
    if (this.b == null)
      throw new IllegalStateException();
    this.d.a(this.b, true);
    this.b = null;
    this.c = this.d.b;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.v
 * JD-Core Version:    0.6.2
 */