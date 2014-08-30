package de.greenrobot.dao.internal;

final class LongHashMap$Entry<T>
{
  final long key;
  Entry<T> next;
  T value;

  LongHashMap$Entry(long paramLong, T paramT, Entry<T> paramEntry)
  {
    this.key = paramLong;
    this.value = paramT;
    this.next = paramEntry;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     de.greenrobot.dao.internal.LongHashMap.Entry
 * JD-Core Version:    0.6.2
 */