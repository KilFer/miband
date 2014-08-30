package com.tencent.mm.algorithm;

import java.util.Comparator;
import java.util.Map.Entry;

final class a
  implements Comparator<Map.Entry<K, LRUMap<K, O>.TimeVal<O>>>
{
  a(LRUMap paramLRUMap)
  {
  }

  private static int a(Map.Entry<K, LRUMap<K, O>.TimeVal<O>> paramEntry1, Map.Entry<K, LRUMap<K, O>.TimeVal<O>> paramEntry2)
  {
    return ((LRUMap.TimeVal)paramEntry1.getValue()).t.compareTo(((LRUMap.TimeVal)paramEntry2.getValue()).t);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.algorithm.a
 * JD-Core Version:    0.6.2
 */