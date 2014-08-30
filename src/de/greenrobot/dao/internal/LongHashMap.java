package de.greenrobot.dao.internal;

import de.greenrobot.dao.DaoLog;
import java.util.Arrays;

public final class LongHashMap<T>
{
  private int capacity;
  private int size;
  private LongHashMap.Entry<T>[] table;
  private int threshold;

  public LongHashMap()
  {
    this(16);
  }

  public LongHashMap(int paramInt)
  {
    this.capacity = paramInt;
    this.threshold = ((paramInt << 2) / 3);
    this.table = new LongHashMap.Entry[paramInt];
  }

  public final void clear()
  {
    this.size = 0;
    Arrays.fill(this.table, null);
  }

  public final boolean containsKey(long paramLong)
  {
    int i = (0x7FFFFFFF & ((int)(paramLong >>> 32) ^ (int)paramLong)) % this.capacity;
    for (LongHashMap.Entry localEntry = this.table[i]; localEntry != null; localEntry = localEntry.next)
      if (localEntry.key == paramLong)
        return true;
    return false;
  }

  public final T get(long paramLong)
  {
    int i = (0x7FFFFFFF & ((int)(paramLong >>> 32) ^ (int)paramLong)) % this.capacity;
    for (LongHashMap.Entry localEntry = this.table[i]; localEntry != null; localEntry = localEntry.next)
      if (localEntry.key == paramLong)
        return localEntry.value;
    return null;
  }

  public final void logStats()
  {
    LongHashMap.Entry[] arrayOfEntry = this.table;
    int i = arrayOfEntry.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      for (LongHashMap.Entry localEntry = arrayOfEntry[j]; (localEntry != null) && (localEntry.next != null); localEntry = localEntry.next)
        k++;
      j++;
    }
    DaoLog.d("load: " + this.size / this.capacity + ", size: " + this.size + ", capa: " + this.capacity + ", collisions: " + k + ", collision ratio: " + k / this.size);
  }

  public final T put(long paramLong, T paramT)
  {
    int i = (0x7FFFFFFF & ((int)(paramLong >>> 32) ^ (int)paramLong)) % this.capacity;
    LongHashMap.Entry localEntry1 = this.table[i];
    for (LongHashMap.Entry localEntry2 = localEntry1; localEntry2 != null; localEntry2 = localEntry2.next)
      if (localEntry2.key == paramLong)
      {
        Object localObject = localEntry2.value;
        localEntry2.value = paramT;
        return localObject;
      }
    this.table[i] = new LongHashMap.Entry(paramLong, paramT, localEntry1);
    this.size = (1 + this.size);
    if (this.size > this.threshold)
      setCapacity(2 * this.capacity);
    return null;
  }

  public final T remove(long paramLong)
  {
    int i = (0x7FFFFFFF & ((int)(paramLong >>> 32) ^ (int)paramLong)) % this.capacity;
    Object localObject1 = this.table[i];
    Object localObject2 = null;
    while (true)
    {
      Object localObject3 = null;
      LongHashMap.Entry localEntry;
      if (localObject1 != null)
      {
        localEntry = ((LongHashMap.Entry)localObject1).next;
        if (((LongHashMap.Entry)localObject1).key != paramLong)
          break label96;
        if (localObject2 != null)
          break label86;
        this.table[i] = localEntry;
      }
      while (true)
      {
        this.size = (-1 + this.size);
        localObject3 = ((LongHashMap.Entry)localObject1).value;
        return localObject3;
        label86: localObject2.next = localEntry;
      }
      label96: localObject2 = localObject1;
      localObject1 = localEntry;
    }
  }

  public final void reserveRoom(int paramInt)
  {
    setCapacity(paramInt * 5 / 3);
  }

  public final void setCapacity(int paramInt)
  {
    LongHashMap.Entry[] arrayOfEntry = new LongHashMap.Entry[paramInt];
    int i = this.table.length;
    for (int j = 0; j < i; j++)
    {
      LongHashMap.Entry localEntry;
      for (Object localObject = this.table[j]; localObject != null; localObject = localEntry)
      {
        long l = ((LongHashMap.Entry)localObject).key;
        int k = (0x7FFFFFFF & ((int)(l >>> 32) ^ (int)l)) % paramInt;
        localEntry = ((LongHashMap.Entry)localObject).next;
        ((LongHashMap.Entry)localObject).next = arrayOfEntry[k];
        arrayOfEntry[k] = localObject;
      }
    }
    this.table = arrayOfEntry;
    this.capacity = paramInt;
    this.threshold = ((paramInt << 2) / 3);
  }

  public final int size()
  {
    return this.size;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.internal.LongHashMap
 * JD-Core Version:    0.6.2
 */