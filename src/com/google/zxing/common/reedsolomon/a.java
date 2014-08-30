package com.google.zxing.common.reedsolomon;

final class a
{
  private final GenericGF a;
  private final int[] b;

  a(GenericGF paramGenericGF, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt.length == 0)
      throw new IllegalArgumentException();
    this.a = paramGenericGF;
    int j = paramArrayOfInt.length;
    if ((j > i) && (paramArrayOfInt[0] == 0))
    {
      while ((i < j) && (paramArrayOfInt[i] == 0))
        i++;
      if (i == j)
      {
        this.b = paramGenericGF.a().b;
        return;
      }
      this.b = new int[j - i];
      System.arraycopy(paramArrayOfInt, i, this.b, 0, this.b.length);
      return;
    }
    this.b = paramArrayOfInt;
  }

  final int a(int paramInt)
  {
    return this.b[(-1 + this.b.length - paramInt)];
  }

  final a a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0)
      throw new IllegalArgumentException();
    if (paramInt2 == 0)
      return this.a.a();
    int i = this.b.length;
    int[] arrayOfInt = new int[i + paramInt1];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = this.a.c(this.b[j], paramInt2);
    return new a(this.a, arrayOfInt);
  }

  final a a(a parama)
  {
    if (!this.a.equals(parama.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if (c())
      return parama;
    if (parama.c())
      return this;
    Object localObject1 = this.b;
    Object localObject2 = parama.b;
    if (localObject1.length > localObject2.length);
    while (true)
    {
      int[] arrayOfInt = new int[localObject1.length];
      int i = localObject1.length - localObject2.length;
      System.arraycopy(localObject1, 0, arrayOfInt, 0, i);
      for (int j = i; j < localObject1.length; j++)
        arrayOfInt[j] = GenericGF.b(localObject2[(j - i)], localObject1[j]);
      return new a(this.a, arrayOfInt);
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }

  final int[] a()
  {
    return this.b;
  }

  final int b()
  {
    return -1 + this.b.length;
  }

  final int b(int paramInt)
  {
    int i = 0;
    int k;
    if (paramInt == 0)
      k = a(0);
    while (true)
    {
      return k;
      int j = this.b.length;
      if (paramInt == 1)
      {
        int i1;
        for (k = 0; i < j; k = i1)
        {
          i1 = GenericGF.b(k, this.b[i]);
          i++;
        }
      }
      else
      {
        k = this.b[0];
        int m = 1;
        while (m < j)
        {
          int n = GenericGF.b(this.a.c(paramInt, k), this.b[m]);
          m++;
          k = n;
        }
      }
    }
  }

  final a b(a parama)
  {
    if (!this.a.equals(parama.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if ((c()) || (parama.c()))
      return this.a.a();
    int[] arrayOfInt1 = this.b;
    int i = arrayOfInt1.length;
    int[] arrayOfInt2 = parama.b;
    int j = arrayOfInt2.length;
    int[] arrayOfInt3 = new int[-1 + (i + j)];
    for (int k = 0; k < i; k++)
    {
      int m = arrayOfInt1[k];
      for (int n = 0; n < j; n++)
        arrayOfInt3[(k + n)] = GenericGF.b(arrayOfInt3[(k + n)], this.a.c(m, arrayOfInt2[n]));
    }
    return new a(this.a, arrayOfInt3);
  }

  final a c(int paramInt)
  {
    if (paramInt == 0)
      this = this.a.a();
    while (paramInt == 1)
      return this;
    int i = this.b.length;
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++)
      arrayOfInt[j] = this.a.c(this.b[j], paramInt);
    return new a(this.a, arrayOfInt);
  }

  final boolean c()
  {
    int i = this.b[0];
    boolean bool = false;
    if (i == 0)
      bool = true;
    return bool;
  }

  final a[] c(a parama)
  {
    if (!this.a.equals(parama.a))
      throw new IllegalArgumentException("GenericGFPolys do not have same GenericGF field");
    if (parama.c())
      throw new IllegalArgumentException("Divide by 0");
    a locala1 = this.a.a();
    int i = parama.a(-1 + parama.b.length);
    int j = this.a.c(i);
    a locala2 = locala1;
    a locala4;
    for (a locala3 = this; (-1 + locala3.b.length >= -1 + parama.b.length) && (!locala3.c()); locala3 = locala3.a(locala4))
    {
      int k = -1 + locala3.b.length - (-1 + parama.b.length);
      int m = this.a.c(locala3.a(-1 + locala3.b.length), j);
      locala4 = parama.a(k, m);
      locala2 = locala2.a(this.a.a(k, m));
    }
    return new a[] { locala2, locala3 };
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(8 * (-1 + this.b.length));
    int i = -1 + this.b.length;
    if (i >= 0)
    {
      int j = a(i);
      label54: int k;
      if (j != 0)
      {
        if (j >= 0)
          break label107;
        localStringBuilder.append(" - ");
        j = -j;
        if ((i == 0) || (j != 1))
        {
          k = this.a.b(j);
          if (k != 0)
            break label124;
          localStringBuilder.append('1');
        }
        label85: if (i != 0)
        {
          if (i != 1)
            break label157;
          localStringBuilder.append('x');
        }
      }
      while (true)
      {
        i--;
        break;
        label107: if (localStringBuilder.length() <= 0)
          break label54;
        localStringBuilder.append(" + ");
        break label54;
        label124: if (k == 1)
        {
          localStringBuilder.append('a');
          break label85;
        }
        localStringBuilder.append("a^");
        localStringBuilder.append(k);
        break label85;
        label157: localStringBuilder.append("x^");
        localStringBuilder.append(i);
      }
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.a
 * JD-Core Version:    0.6.2
 */