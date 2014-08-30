package com.tencent.mm.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LRUMap<K, O>
{
  private Map<K, LRUMap<K, O>.TimeVal<O>> a = null;
  private int b;
  private int c;
  private LRUMap.PreRemoveCallback<K, O> d = null;

  public LRUMap(int paramInt)
  {
    this(paramInt, null);
  }

  public LRUMap(int paramInt, LRUMap.PreRemoveCallback<K, O> paramPreRemoveCallback)
  {
    this.b = paramInt;
    this.c = 0;
    this.d = paramPreRemoveCallback;
    this.a = new HashMap();
  }

  public boolean check(K paramK)
  {
    return this.a.containsKey(paramK);
  }

  public boolean checkAndUpTime(K paramK)
  {
    if (this.a.containsKey(paramK))
    {
      ((LRUMap.TimeVal)this.a.get(paramK)).UpTime();
      return true;
    }
    return false;
  }

  public void clear()
  {
    this.a.clear();
  }

  public void clear(LRUMap.OnClearListener<K, O> paramOnClearListener)
  {
    if (this.a != null)
    {
      if (paramOnClearListener != null)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          paramOnClearListener.onClear(localEntry.getKey(), ((LRUMap.TimeVal)localEntry.getValue()).obj);
        }
      }
      this.a.clear();
    }
  }

  public O get(K paramK)
  {
    return getAndUptime(paramK);
  }

  public O getAndUptime(K paramK)
  {
    LRUMap.TimeVal localTimeVal = (LRUMap.TimeVal)this.a.get(paramK);
    if (localTimeVal == null)
      return null;
    localTimeVal.UpTime();
    return localTimeVal.obj;
  }

  public void remove(K paramK)
  {
    if (!this.a.containsKey(paramK))
      return;
    if (this.d != null)
      this.d.preRemoveCallback(paramK, ((LRUMap.TimeVal)this.a.get(paramK)).obj);
    this.a.remove(paramK);
  }

  public void setMaxSize(int paramInt)
  {
    if (paramInt > 0)
      this.b = paramInt;
  }

  public void setPerDeleteSize(int paramInt)
  {
    if (paramInt > 0)
      this.c = paramInt;
  }

  public int size()
  {
    return this.a.size();
  }

  public void update(K paramK, O paramO)
  {
    int i;
    Iterator localIterator;
    if ((LRUMap.TimeVal)this.a.get(paramK) == null)
    {
      LRUMap.TimeVal localTimeVal = new LRUMap.TimeVal(this, paramO);
      this.a.put(paramK, localTimeVal);
      if (this.a.size() > this.b)
      {
        ArrayList localArrayList = new ArrayList(this.a.entrySet());
        Collections.sort(localArrayList, new a(this));
        if (this.c > 0)
          break label161;
        i = this.b / 10;
        if (i <= 0)
          i = 1;
        localIterator = localArrayList.iterator();
      }
    }
    int k;
    for (int j = i; ; j = k)
      if (localIterator.hasNext())
      {
        remove(((Map.Entry)localIterator.next()).getKey());
        k = j - 1;
        if (k > 0);
      }
      else
      {
        return;
        label161: i = this.c;
        break;
        ((LRUMap.TimeVal)this.a.get(paramK)).UpTime();
        ((LRUMap.TimeVal)this.a.get(paramK)).obj = paramO;
        return;
      }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.algorithm.LRUMap
 * JD-Core Version:    0.6.2
 */