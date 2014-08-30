package android.support.v4.util;

public class SparseArrayCompat<E>
{
  private static final Object a = new Object();
  private boolean b = false;
  private int[] c;
  private Object[] d;
  private int e;

  public SparseArrayCompat()
  {
    this(10);
  }

  public SparseArrayCompat(int paramInt)
  {
    int i = b(paramInt);
    this.c = new int[i];
    this.d = new Object[i];
    this.e = 0;
  }

  private static int a(int paramInt)
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

  private static int a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 + 0;
    int j = -1;
    int k = i;
    while (k - j > 1)
    {
      int m = (k + j) / 2;
      if (paramArrayOfInt[m] < paramInt3)
        j = m;
      else
        k = m;
    }
    if (k == paramInt2 + 0)
      k = 0xFFFFFFFF ^ paramInt2 + 0;
    while (paramArrayOfInt[k] == paramInt3)
      return k;
    return k ^ 0xFFFFFFFF;
  }

  private void a()
  {
    int i = this.e;
    int[] arrayOfInt = this.c;
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
          arrayOfInt[k] = arrayOfInt[j];
          arrayOfObject[k] = localObject;
        }
        k++;
      }
      j++;
    }
    this.b = false;
    this.e = k;
  }

  private static int b(int paramInt)
  {
    int i = paramInt << 2;
    for (int j = 4; ; j++)
      if (j < 32)
      {
        if (i <= -12 + (1 << j))
          i = -12 + (1 << j);
      }
      else
        return i / 4;
  }

  public void append(int paramInt, E paramE)
  {
    if ((this.e != 0) && (paramInt <= this.c[(-1 + this.e)]))
    {
      put(paramInt, paramE);
      return;
    }
    if ((this.b) && (this.e >= this.c.length))
      a();
    int i = this.e;
    if (i >= this.c.length)
    {
      int j = b(i + 1);
      int[] arrayOfInt = new int[j];
      Object[] arrayOfObject = new Object[j];
      System.arraycopy(this.c, 0, arrayOfInt, 0, this.c.length);
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
      this.c = arrayOfInt;
      this.d = arrayOfObject;
    }
    this.c[i] = paramInt;
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

  public void delete(int paramInt)
  {
    int i = a(this.c, 0, this.e, paramInt);
    if ((i >= 0) && (this.d[i] != a))
    {
      this.d[i] = a;
      this.b = true;
    }
  }

  public E get(int paramInt)
  {
    return get(paramInt, null);
  }

  public E get(int paramInt, E paramE)
  {
    int i = a(this.c, 0, this.e, paramInt);
    if ((i < 0) || (this.d[i] == a))
      return paramE;
    return this.d[i];
  }

  public int indexOfKey(int paramInt)
  {
    if (this.b)
      a();
    return a(this.c, 0, this.e, paramInt);
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

  public int keyAt(int paramInt)
  {
    if (this.b)
      a();
    return this.c[paramInt];
  }

  public void put(int paramInt, E paramE)
  {
    int i = a(this.c, 0, this.e, paramInt);
    if (i >= 0)
    {
      this.d[i] = paramE;
      return;
    }
    int j = i ^ 0xFFFFFFFF;
    if ((j < this.e) && (this.d[j] == a))
    {
      this.c[j] = paramInt;
      this.d[j] = paramE;
      return;
    }
    if ((this.b) && (this.e >= this.c.length))
    {
      a();
      j = 0xFFFFFFFF ^ a(this.c, 0, this.e, paramInt);
    }
    if (this.e >= this.c.length)
    {
      int k = b(1 + this.e);
      int[] arrayOfInt = new int[k];
      Object[] arrayOfObject = new Object[k];
      System.arraycopy(this.c, 0, arrayOfInt, 0, this.c.length);
      System.arraycopy(this.d, 0, arrayOfObject, 0, this.d.length);
      this.c = arrayOfInt;
      this.d = arrayOfObject;
    }
    if (this.e - j != 0)
    {
      System.arraycopy(this.c, j, this.c, j + 1, this.e - j);
      System.arraycopy(this.d, j, this.d, j + 1, this.e - j);
    }
    this.c[j] = paramInt;
    this.d[j] = paramE;
    this.e = (1 + this.e);
  }

  public void remove(int paramInt)
  {
    delete(paramInt);
  }

  public void removeAt(int paramInt)
  {
    if (this.d[paramInt] != a)
    {
      this.d[paramInt] = a;
      this.b = true;
    }
  }

  public void removeAtRange(int paramInt1, int paramInt2)
  {
    int i = Math.min(this.e, paramInt1 + paramInt2);
    while (paramInt1 < i)
    {
      removeAt(paramInt1);
      paramInt1++;
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
 * Qualified Name:     android.support.v4.util.SparseArrayCompat
 * JD-Core Version:    0.6.2
 */