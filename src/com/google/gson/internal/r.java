package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map.Entry;

final class r extends AbstractSet<Map.Entry<K, V>>
{
  r(LinkedTreeMap paramLinkedTreeMap)
  {
  }

  public final void clear()
  {
    this.a.clear();
  }

  public final boolean contains(Object paramObject)
  {
    return ((paramObject instanceof Map.Entry)) && (this.a.a((Map.Entry)paramObject) != null);
  }

  public final Iterator<Map.Entry<K, V>> iterator()
  {
    return new s(this);
  }

  public final boolean remove(Object paramObject)
  {
    if (!(paramObject instanceof Map.Entry));
    w localw;
    do
    {
      return false;
      localw = this.a.a((Map.Entry)paramObject);
    }
    while (localw == null);
    this.a.a(localw, true);
    return true;
  }

  public final int size()
  {
    return this.a.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.r
 * JD-Core Version:    0.6.2
 */