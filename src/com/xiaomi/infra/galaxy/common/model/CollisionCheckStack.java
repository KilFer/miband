package com.xiaomi.infra.galaxy.common.model;

import java.util.AbstractList;
import java.util.Arrays;

public final class CollisionCheckStack<E> extends AbstractList<E>
{
  private Object[] data = new Object[16];
  private final int[] initialHash = new int[17];
  private boolean latestPushResult = false;
  private int[] next = new int[16];
  private int size = 0;
  private boolean useIdentity = true;

  static
  {
    if (!CollisionCheckStack.class.desiredAssertionStatus());
    for (boolean bool = true; ; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }

  private void expandCapacity()
  {
    int i = this.data.length;
    int j = i << 1;
    Object[] arrayOfObject = new Object[j];
    int[] arrayOfInt = new int[j];
    System.arraycopy(this.data, 0, arrayOfObject, 0, i);
    System.arraycopy(this.next, 0, arrayOfInt, 0, i);
    this.data = arrayOfObject;
    this.next = arrayOfInt;
  }

  private boolean findDuplicate(E paramE, int paramInt)
  {
    int j;
    for (int i = this.initialHash[paramInt]; i != 0; i = this.next[j])
    {
      j = i - 1;
      Object localObject = this.data[j];
      if (this.useIdentity)
      {
        if (localObject != paramE);
      }
      else
        while (paramE.equals(localObject))
          return true;
    }
    return false;
  }

  private int hash(Object paramObject)
  {
    if (this.useIdentity);
    for (int i = System.identityHashCode(paramObject); ; i = paramObject.hashCode())
      return (i & 0x7FFFFFFF) % this.initialHash.length;
  }

  public final boolean findDuplicate(E paramE)
  {
    return findDuplicate(paramE, hash(paramE));
  }

  public final E get(int paramInt)
  {
    return this.data[paramInt];
  }

  public final String getCycleString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = -1 + size();
    Object localObject1 = get(i);
    localStringBuilder.append(localObject1);
    Object localObject2;
    do
    {
      localStringBuilder.append(" -> ");
      i--;
      localObject2 = get(i);
      localStringBuilder.append(localObject2);
    }
    while (localObject1 != localObject2);
    return localStringBuilder.toString();
  }

  public final boolean getLatestPushResult()
  {
    return this.latestPushResult;
  }

  public final boolean getUseIdentity()
  {
    return this.useIdentity;
  }

  public final E peek()
  {
    return this.data[(-1 + this.size)];
  }

  public final E pop()
  {
    this.size = (-1 + this.size);
    Object localObject = this.data[this.size];
    this.data[this.size] = null;
    int i = this.next[this.size];
    if (i >= 0)
    {
      int j = hash(localObject);
      assert (this.initialHash[j] == 1 + this.size);
      this.initialHash[j] = i;
    }
    return localObject;
  }

  public final boolean push(E paramE)
  {
    if (this.data.length == this.size)
      expandCapacity();
    this.data[this.size] = paramE;
    int i = hash(paramE);
    boolean bool = findDuplicate(paramE, i);
    this.next[this.size] = this.initialHash[i];
    this.initialHash[i] = (1 + this.size);
    this.size = (1 + this.size);
    this.latestPushResult = bool;
    return this.latestPushResult;
  }

  public final void pushNocheck(E paramE)
  {
    if (this.data.length == this.size)
      expandCapacity();
    this.data[this.size] = paramE;
    this.next[this.size] = -1;
    this.size = (1 + this.size);
  }

  public final void reset()
  {
    if (this.size > 0)
    {
      this.size = 0;
      Arrays.fill(this.initialHash, 0);
    }
  }

  public final void setUseIdentity(boolean paramBoolean)
  {
    this.useIdentity = paramBoolean;
  }

  public final int size()
  {
    return this.size;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.xiaomi.infra.galaxy.common.model.CollisionCheckStack
 * JD-Core Version:    0.6.2
 */