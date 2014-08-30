package com.google.gson.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

public final class LinkedTreeMap<K, V> extends AbstractMap<K, V>
  implements Serializable
{
  private static final Comparator<Comparable> d;
  int a = 0;
  int b = 0;
  final w<K, V> c = new w();
  private Comparator<? super K> e;
  private w<K, V> f;
  private LinkedTreeMap<K, V>.r g;
  private LinkedTreeMap<K, V>.t h;

  static
  {
    if (!LinkedTreeMap.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      i = bool;
      d = new q();
      return;
    }
  }

  public LinkedTreeMap()
  {
    this(d);
  }

  public LinkedTreeMap(Comparator<? super K> paramComparator)
  {
    if (paramComparator != null);
    while (true)
    {
      this.e = paramComparator;
      return;
      paramComparator = d;
    }
  }

  private w<K, V> a(K paramK, boolean paramBoolean)
  {
    Comparator localComparator = this.e;
    Object localObject1 = this.f;
    Object localObject3;
    label66: label83: label117: int m;
    Object localObject2;
    if (localObject1 != null)
    {
      Comparable localComparable;
      if (localComparator == d)
      {
        localComparable = (Comparable)paramK;
        if (localComparable == null)
          break label66;
      }
      for (int k = localComparable.compareTo(((w)localObject1).f); ; k = localComparator.compare(paramK, ((w)localObject1).f))
      {
        if (k != 0)
          break label83;
        localObject3 = localObject1;
        return localObject3;
        localComparable = null;
        break;
      }
      if (k < 0);
      for (w localw3 = ((w)localObject1).b; ; localw3 = ((w)localObject1).c)
      {
        if (localw3 == null)
          break label117;
        localObject1 = localw3;
        break;
      }
      m = k;
      localObject2 = localObject1;
    }
    for (int j = m; ; j = 0)
    {
      localObject3 = null;
      if (!paramBoolean)
        break;
      w localw1 = this.c;
      if (localObject2 == null)
      {
        if ((localComparator == d) && (!(paramK instanceof Comparable)))
          throw new ClassCastException(paramK.getClass().getName() + " is not Comparable");
        localw2 = new w(localObject2, paramK, localw1, localw1.e);
        this.f = localw2;
        this.a = (1 + this.a);
        this.b = (1 + this.b);
        return localw2;
      }
      w localw2 = new w(localObject2, paramK, localw1, localw1.e);
      if (j < 0)
        localObject2.b = localw2;
      while (true)
      {
        b(localObject2, true);
        break;
        localObject2.c = localw2;
      }
      localObject2 = localObject1;
    }
  }

  private void a(w<K, V> paramw)
  {
    w localw1 = paramw.b;
    w localw2 = paramw.c;
    w localw3 = localw2.b;
    w localw4 = localw2.c;
    paramw.c = localw3;
    if (localw3 != null)
      localw3.a = paramw;
    a(paramw, localw2);
    localw2.b = paramw;
    paramw.a = localw2;
    int j;
    if (localw1 != null)
    {
      j = localw1.h;
      if (localw3 == null)
        break label131;
    }
    label131: for (int k = localw3.h; ; k = 0)
    {
      paramw.h = (1 + Math.max(j, k));
      int m = paramw.h;
      int n = 0;
      if (localw4 != null)
        n = localw4.h;
      localw2.h = (1 + Math.max(m, n));
      return;
      j = 0;
      break;
    }
  }

  private void a(w<K, V> paramw1, w<K, V> paramw2)
  {
    w localw = paramw1.a;
    paramw1.a = null;
    if (paramw2 != null)
      paramw2.a = localw;
    if (localw != null)
    {
      if (localw.b == paramw1)
      {
        localw.b = paramw2;
        return;
      }
      if ((!i) && (localw.c != paramw1))
        throw new AssertionError();
      localw.c = paramw2;
      return;
    }
    this.f = paramw2;
  }

  private static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }

  private w<K, V> b(Object paramObject)
  {
    Object localObject = null;
    if (paramObject != null);
    try
    {
      w localw = a(paramObject, false);
      localObject = localw;
      return localObject;
    }
    catch (ClassCastException localClassCastException)
    {
    }
    return null;
  }

  private void b(w<K, V> paramw)
  {
    w localw1 = paramw.b;
    w localw2 = paramw.c;
    w localw3 = localw1.b;
    w localw4 = localw1.c;
    paramw.b = localw4;
    if (localw4 != null)
      localw4.a = paramw;
    a(paramw, localw1);
    localw1.c = paramw;
    paramw.a = localw1;
    int j;
    if (localw2 != null)
    {
      j = localw2.h;
      if (localw4 == null)
        break label131;
    }
    label131: for (int k = localw4.h; ; k = 0)
    {
      paramw.h = (1 + Math.max(j, k));
      int m = paramw.h;
      int n = 0;
      if (localw3 != null)
        n = localw3.h;
      localw1.h = (1 + Math.max(m, n));
      return;
      j = 0;
      break;
    }
  }

  private void b(w<K, V> paramw, boolean paramBoolean)
  {
    w localw1;
    w localw2;
    int j;
    label25: int k;
    label37: int m;
    int i3;
    label77: int i4;
    label89: int i5;
    if (paramw != null)
    {
      localw1 = paramw.b;
      localw2 = paramw.c;
      if (localw1 != null)
      {
        j = localw1.h;
        if (localw2 == null)
          break label134;
        k = localw2.h;
        m = j - k;
        if (m != -2)
          break label186;
        w localw5 = localw2.b;
        w localw6 = localw2.c;
        if (localw6 == null)
          break label140;
        i3 = localw6.h;
        if (localw5 == null)
          break label146;
        i4 = localw5.h;
        i5 = i4 - i3;
        if ((i5 != -1) && ((i5 != 0) || (paramBoolean)))
          break label152;
        a(paramw);
        label116: if (paramBoolean)
          break label259;
      }
    }
    while (true)
    {
      paramw = paramw.a;
      break;
      j = 0;
      break label25;
      label134: k = 0;
      break label37;
      label140: i3 = 0;
      break label77;
      label146: i4 = 0;
      break label89;
      label152: if ((!i) && (i5 != 1))
        throw new AssertionError();
      b(localw2);
      a(paramw);
      break label116;
      label186: int n;
      label216: int i1;
      label228: int i2;
      if (m == 2)
      {
        w localw3 = localw1.b;
        w localw4 = localw1.c;
        if (localw4 != null)
        {
          n = localw4.h;
          if (localw3 == null)
            break label266;
          i1 = localw3.h;
          i2 = i1 - n;
          if ((i2 != 1) && ((i2 != 0) || (paramBoolean)))
            break label272;
          b(paramw);
          label255: if (!paramBoolean)
            break label303;
        }
      }
      label259: label266: label272: label303: 
      do
      {
        return;
        n = 0;
        break label216;
        i1 = 0;
        break label228;
        if ((!i) && (i2 != -1))
          throw new AssertionError();
        a(localw1);
        b(paramw);
        break label255;
        break;
        if (m == 0)
        {
          paramw.h = (j + 1);
          if (!paramBoolean)
            break;
          return;
        }
        if ((!i) && (m != -1) && (m != 1))
          throw new AssertionError();
        paramw.h = (1 + Math.max(j, k));
      }
      while (!paramBoolean);
    }
  }

  private Object writeReplace()
  {
    return new LinkedHashMap(this);
  }

  final w<K, V> a(Object paramObject)
  {
    w localw = b(paramObject);
    if (localw != null)
      a(localw, true);
    return localw;
  }

  final w<K, V> a(Map.Entry<?, ?> paramEntry)
  {
    int j = 1;
    w localw = b(paramEntry.getKey());
    int k;
    if (localw != null)
    {
      Object localObject1 = localw.g;
      Object localObject2 = paramEntry.getValue();
      if ((localObject1 == localObject2) || ((localObject1 != null) && (localObject1.equals(localObject2))))
      {
        k = j;
        if (k == 0)
          break label73;
      }
    }
    while (true)
    {
      if (j == 0)
        break label78;
      return localw;
      k = 0;
      break;
      label73: j = 0;
    }
    label78: return null;
  }

  final void a(w<K, V> paramw, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramw.e.d = paramw.d;
      paramw.d.e = paramw.e;
    }
    w localw1 = paramw.b;
    w localw2 = paramw.c;
    w localw3 = paramw.a;
    w localw4;
    int j;
    if ((localw1 != null) && (localw2 != null))
      if (localw1.h > localw2.h)
      {
        localw4 = localw1.b();
        a(localw4, false);
        w localw5 = paramw.b;
        if (localw5 == null)
          break label258;
        j = localw5.h;
        localw4.b = localw5;
        localw5.a = localw4;
        paramw.b = null;
      }
    while (true)
    {
      w localw6 = paramw.c;
      int k = 0;
      if (localw6 != null)
      {
        k = localw6.h;
        localw4.c = localw6;
        localw6.a = localw4;
        paramw.c = null;
      }
      localw4.h = (1 + Math.max(j, k));
      a(paramw, localw4);
      return;
      localw4 = localw2.a();
      break;
      if (localw1 != null)
      {
        a(paramw, localw1);
        paramw.b = null;
      }
      while (true)
      {
        b(localw3, false);
        this.a = (-1 + this.a);
        this.b = (1 + this.b);
        return;
        if (localw2 != null)
        {
          a(paramw, localw2);
          paramw.c = null;
        }
        else
        {
          a(paramw, null);
        }
      }
      label258: j = 0;
    }
  }

  public final void clear()
  {
    this.f = null;
    this.a = 0;
    this.b = (1 + this.b);
    w localw = this.c;
    localw.e = localw;
    localw.d = localw;
  }

  public final boolean containsKey(Object paramObject)
  {
    return b(paramObject) != null;
  }

  public final Set<Map.Entry<K, V>> entrySet()
  {
    r localr1 = this.g;
    if (localr1 != null)
      return localr1;
    r localr2 = new r(this);
    this.g = localr2;
    return localr2;
  }

  public final V get(Object paramObject)
  {
    w localw = b(paramObject);
    if (localw != null)
      return localw.g;
    return null;
  }

  public final Set<K> keySet()
  {
    t localt1 = this.h;
    if (localt1 != null)
      return localt1;
    t localt2 = new t(this);
    this.h = localt2;
    return localt2;
  }

  public final V put(K paramK, V paramV)
  {
    if (paramK == null)
      throw new NullPointerException("key == null");
    w localw = a(paramK, true);
    Object localObject = localw.g;
    localw.g = paramV;
    return localObject;
  }

  public final V remove(Object paramObject)
  {
    w localw = a(paramObject);
    if (localw != null)
      return localw.g;
    return null;
  }

  public final int size()
  {
    return this.a;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.LinkedTreeMap
 * JD-Core Version:    0.6.2
 */