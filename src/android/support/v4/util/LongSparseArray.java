package android.support.v4.util;

public class LongSparseArray<E>
  implements Cloneable
{
  private static final Object a = new Object();
  private boolean b = false;
  private long[] c;
  private Object[] d;
  private int e;

  public LongSparseArray()
  {
    this(10);
  }

  public LongSparseArray(int paramInt)
  {
    int i = idealLongArraySize(paramInt);
    this.c = new long[i];
    this.d = new Object[i];
    this.e = 0;
  }

  private static int a(long[] paramArrayOfLong, int paramInt1, int paramInt2, long paramLong)
  {
    int i = paramInt2 + 0;
    int j = -1;
    int k = i;
    while (k - j > 1)
    {
      int m = (k + j) / 2;
      if (paramArrayOfLong[m] < paramLong)
        j = m;
      else
        k = m;
    }
    if (k == paramInt2 + 0)
      k = 0xFFFFFFFF ^ paramInt2 + 0;
    while (paramArrayOfLong[k] == paramLong)
      return k;
    return k ^ 0xFFFFFFFF;
  }

  private void a()
  {
    int i = this.e;
    long[] arrayOfLong = this.c;
    Object[] arrayOfObject = this.d;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      Object localObject = arrayOfObject[j];
      if (localObject != a)
      {
        if (j != k)
        {
          arrayOfLong[k] = arrayOfLong[j];
          arrayOfObject[k] = localObject;
          arrayOfObject[j] = null;
        }
        k++;
      }
      j++;
    }
    this.b = false;
    this.e = k;
  }

  public static int idealByteArraySize(int paramInt)
  {
    for (int i = 4; ; i++)
      if (i < 32)
      {
        if (paramInt <= -12 + (1 << i))
          paramInt = -12 + (1 << i);
      }
      else
        return paramInt;
  }

  public static int idealLongArraySize(int paramInt)
  {
    return idealByteArraySize(paramInt << 3) / 8;
  }

  public void append(long paramLong, E paramE)
  {
    if ((this.e != 0) && (paramLong <= this.c[(-1 + this.e)]))
    {
      put(paramLong, paramE);
      return;
    }
    if ((this.b) && (this.e >= this.c.length))
      a();
    int i = this.e;
    if (i >= this.c.length)
    {
      int j = idealLongArraySize(i + 1);
      long[] arrayOfLong = new long[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.c, 0, arrayOfLong, 0, this.c.length);
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
      this.c = arrayOfLong;
      this.d = arrayOfObject;
    }
    this.c[i] = paramLong;
    this.d[i] = paramE;
    this.e = (i + 1);
  }

  public void clear()
  {
    int i = this.e;
    Object[] arrayOfObject = this.d;
    for (int j = 0; j < i; j++)
      arrayOfObject[j] = null;
    this.e = 0;
    this.b = false;
  }

  // ERROR //
  public LongSparseArray<E> clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 64	java/lang/Object:clone	()Ljava/lang/Object;
    //   4: checkcast 2	android/support/v4/util/LongSparseArray
    //   7: astore_2
    //   8: aload_2
    //   9: aload_0
    //   10: getfield 35	android/support/v4/util/LongSparseArray:c	[J
    //   13: invokevirtual 66	[J:clone	()Ljava/lang/Object;
    //   16: checkcast 65	[J
    //   19: putfield 35	android/support/v4/util/LongSparseArray:c	[J
    //   22: aload_2
    //   23: aload_0
    //   24: getfield 37	android/support/v4/util/LongSparseArray:d	[Ljava/lang/Object;
    //   27: invokevirtual 68	[Ljava/lang/Object;:clone	()Ljava/lang/Object;
    //   30: checkcast 67	[Ljava/lang/Object;
    //   33: putfield 37	android/support/v4/util/LongSparseArray:d	[Ljava/lang/Object;
    //   36: aload_2
    //   37: areturn
    //   38: astore_1
    //   39: aconst_null
    //   40: areturn
    //   41: astore_3
    //   42: aload_2
    //   43: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	38	java/lang/CloneNotSupportedException
    //   8	36	41	java/lang/CloneNotSupportedException
  }

  public void delete(long paramLong)
  {
    int i = a(this.c, 0, this.e, paramLong);
    if ((i >= 0) && (this.d[i] != a))
    {
      this.d[i] = a;
      this.b = true;
    }
  }

  public E get(long paramLong)
  {
    return get(paramLong, null);
  }

  public E get(long paramLong, E paramE)
  {
    int i = a(this.c, 0, this.e, paramLong);
    if ((i < 0) || (this.d[i] == a))
      return paramE;
    return this.d[i];
  }

  public int indexOfKey(long paramLong)
  {
    if (this.b)
      a();
    return a(this.c, 0, this.e, paramLong);
  }

  public int indexOfValue(E paramE)
  {
    if (this.b)
      a();
    for (int i = 0; i < this.e; i++)
      if (this.d[i] == paramE)
        return i;
    return -1;
  }

  public long keyAt(int paramInt)
  {
    if (this.b)
      a();
    return this.c[paramInt];
  }

  public void put(long paramLong, E paramE)
  {
    int i = a(this.c, 0, this.e, paramLong);
    if (i >= 0)
    {
      this.d[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.e) && (this.d[j] == a))
    {
      this.c[j] = paramLong;
      this.d[j] = paramE;
      return;
    }
    if ((this.b) && (this.e >= this.c.length))
    {
      a();
      j = 0xFFFFFFFF ^ a(this.c, 0, this.e, paramLong);
    }
    if (this.e >= this.c.length)
    {
      int k = idealLongArraySize(1 + this.e);
      long[] arrayOfLong = new long[k];
      Object[] arrayOfObject = new Object[k];
      System.arraycopy(this.c, 0, arrayOfLong, 0, this.c.length);
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
      this.c = arrayOfLong;
      this.d = arrayOfObject;
    }
    if (this.e - j != 0)
    {
      System.arraycopy(this.c, j, this.c, j + 1, this.e - j);
      System.arraycopy(this.d, j, this.d, j + 1, this.e - j);
    }
    this.c[j] = paramLong;
    this.d[j] = paramE;
    this.e = (1 + this.e);
  }

  public void remove(long paramLong)
  {
    delete(paramLong);
  }

  public void removeAt(int paramInt)
  {
    if (this.d[paramInt] != a)
    {
      this.d[paramInt] = a;
      this.b = true;
    }
  }

  public void setValueAt(int paramInt, E paramE)
  {
    if (this.b)
      a();
    this.d[paramInt] = paramE;
  }

  public int size()
  {
    if (this.b)
      a();
    return this.e;
  }

  public E valueAt(int paramInt)
  {
    if (this.b)
      a();
    return this.d[paramInt];
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     android.support.v4.util.LongSparseArray
 * JD-Core Version:    0.6.2
 */