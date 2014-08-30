package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

final class t extends AbstractSet<K>
{
  t(LinkedTreeMap paramLinkedTreeMap)
  {
  }

  public final void clear()
  {
    this.a.clear();
  }

  public final boolean contains(Object paramObject)
  {
    return this.a.containsKey(paramObject);
  }

  public final Iterator<K> iterator()
  {
    return new u(this);
  }

  public final boolean remove(Object paramObject)
  {
    return this.a.a(paramObject) != null;
  }

  public final int size()
  {
    return this.a.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.t
 * JD-Core Version:    0.6.2
 */