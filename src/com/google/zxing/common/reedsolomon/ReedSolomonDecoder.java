package com.google.zxing.common.reedsolomon;

public final class ReedSolomonDecoder
{
  private final GenericGF a;

  public ReedSolomonDecoder(GenericGF paramGenericGF)
  {
    this.a = paramGenericGF;
  }

  private int[] a(a parama)
  {
    int i = 0;
    int j = 1;
    int k = parama.b();
    if (k == j)
    {
      int[] arrayOfInt2 = new int[j];
      arrayOfInt2[0] = parama.a(j);
      return arrayOfInt2;
    }
    int[] arrayOfInt1 = new int[k];
    while ((j < this.a.getSize()) && (i < k))
    {
      if (parama.b(j) == 0)
      {
        arrayOfInt1[i] = this.a.c(j);
        i++;
      }
      j++;
    }
    if (i != k)
      throw new ReedSolomonException("Error locator degree does not match number of roots");
    return arrayOfInt1;
  }

  private int[] a(a parama, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i];
    int j = 0;
    int k;
    int m;
    int n;
    label39: int i2;
    int i3;
    if (j < i)
    {
      k = this.a.c(paramArrayOfInt[j]);
      m = 1;
      n = 0;
      if (n < i)
      {
        if (j == n)
          break label173;
        i2 = this.a.c(paramArrayOfInt[n], k);
        if ((i2 & 0x1) == 0)
          i3 = i2 | 0x1;
      }
    }
    label81: for (int i1 = this.a.c(m, i3); ; i1 = m)
    {
      n++;
      m = i1;
      break label39;
      i3 = i2 & 0xFFFFFFFE;
      break label81;
      arrayOfInt[j] = this.a.c(parama.b(k), this.a.c(m));
      if (paramBoolean)
        arrayOfInt[j] = this.a.c(arrayOfInt[j], k);
      j++;
      break;
      return arrayOfInt;
    }
  }

  private a[] a(a parama1, a parama2, int paramInt)
  {
    if (parama1.b() < parama2.b());
    while (true)
    {
      Object localObject1 = this.a.b();
      Object localObject2 = this.a.a();
      Object localObject3 = this.a.a();
      Object localObject4 = this.a.b();
      Object localObject5 = parama1;
      while (((a)localObject5).b() >= paramInt / 2)
      {
        if (((a)localObject5).c())
          throw new ReedSolomonException("r_{i-1} was zero");
        a locala2 = this.a.a();
        int k = ((a)localObject5).a(((a)localObject5).b());
        int m = this.a.c(k);
        int n;
        int i1;
        for (a locala3 = parama2; (locala3.b() >= ((a)localObject5).b()) && (!locala3.c()); locala3 = locala3.a(((a)localObject5).a(n, i1)))
        {
          n = locala3.b() - ((a)localObject5).b();
          i1 = this.a.c(locala3.a(locala3.b()), m);
          locala2 = locala2.a(this.a.a(n, i1));
        }
        a locala4 = locala2.b((a)localObject2).a((a)localObject1);
        a locala5 = locala2.b((a)localObject4).a((a)localObject3);
        parama2 = (a)localObject5;
        localObject5 = locala3;
        localObject1 = localObject2;
        localObject2 = locala4;
        localObject3 = localObject4;
        localObject4 = locala5;
      }
      int i = ((a)localObject4).a(0);
      if (i == 0)
        throw new ReedSolomonException("sigmaTilde(0) was zero");
      int j = this.a.c(i);
      return new a[] { ((a)localObject4).c(j), ((a)localObject5).c(j) };
      a locala1 = parama2;
      parama2 = parama1;
      parama1 = locala1;
    }
  }

  public final void decode(int[] paramArrayOfInt, int paramInt)
  {
    a locala1 = new a(this.a, paramArrayOfInt);
    int[] arrayOfInt1 = new int[paramInt];
    boolean bool = this.a.equals(GenericGF.DATA_MATRIX_FIELD_256);
    int i = 1;
    int j = 0;
    int i17;
    if (j < paramInt)
    {
      GenericGF localGenericGF = this.a;
      if (bool)
      {
        i17 = j + 1;
        label59: int i18 = locala1.b(localGenericGF.a(i17));
        arrayOfInt1[(-1 + arrayOfInt1.length - j)] = i18;
        if (i18 == 0)
          break label863;
      }
    }
    label525: label552: label595: label863: for (int i19 = 0; ; i19 = i)
    {
      j++;
      i = i19;
      break;
      i17 = j;
      break label59;
      if (i != 0)
        return;
      Object localObject1 = new a(this.a, arrayOfInt1);
      Object localObject2 = this.a.a(paramInt, 1);
      if (((a)localObject2).b() < ((a)localObject1).b());
      while (true)
      {
        Object localObject4 = this.a.b();
        Object localObject5 = this.a.a();
        Object localObject6 = this.a.a();
        Object localObject7 = this.a.b();
        Object localObject8 = localObject2;
        Object localObject11;
        for (Object localObject9 = localObject1; localObject8.b() >= paramInt / 2; localObject9 = localObject11)
        {
          if (localObject8.c())
            throw new ReedSolomonException("r_{i-1} was zero");
          a locala4 = this.a.a();
          int i13 = localObject8.a(localObject8.b());
          int i14 = this.a.c(i13);
          while ((((a)localObject9).b() >= localObject8.b()) && (!((a)localObject9).c()))
          {
            int i15 = ((a)localObject9).b() - localObject8.b();
            int i16 = this.a.c(((a)localObject9).a(((a)localObject9).b()), i14);
            locala4 = locala4.a(this.a.a(i15, i16));
            localObject9 = ((a)localObject9).a(localObject8.a(i15, i16));
          }
          a locala5 = locala4.b((a)localObject5).a((a)localObject4);
          a locala6 = locala4.b((a)localObject7).a((a)localObject6);
          localObject6 = localObject7;
          localObject7 = locala6;
          localObject4 = localObject5;
          localObject5 = locala5;
          localObject11 = localObject8;
          localObject8 = localObject9;
        }
        int k = ((a)localObject7).a(0);
        if (k == 0)
          throw new ReedSolomonException("sigmaTilde(0) was zero");
        int m = this.a.c(k);
        a[] arrayOfa = { ((a)localObject7).c(m), localObject8.c(m) };
        a locala2 = arrayOfa[0];
        a locala3 = arrayOfa[1];
        int n = locala2.b();
        Object localObject10;
        label511: int[] arrayOfInt3;
        int i4;
        int i7;
        int i8;
        int i9;
        int i11;
        int i12;
        if (n == 1)
        {
          localObject10 = new int[1];
          localObject10[0] = locala2.a(1);
          int i3 = localObject10.length;
          arrayOfInt3 = new int[i3];
          i4 = 0;
          if (i4 >= i3)
            break label774;
          i7 = this.a.c(localObject10[i4]);
          i8 = 1;
          i9 = 0;
          if (i9 >= i3)
            break label716;
          if (i4 == i9)
            break label841;
          i11 = this.a.c(localObject10[i9], i7);
          if ((i11 & 0x1) != 0)
            break label706;
          i12 = i11 | 0x1;
        }
        for (int i10 = this.a.c(i8, i12); ; i10 = i8)
        {
          i9++;
          i8 = i10;
          break label552;
          int[] arrayOfInt2 = new int[n];
          int i1 = 0;
          for (int i2 = 1; (i2 < this.a.getSize()) && (i1 < n); i2++)
            if (locala2.b(i2) == 0)
            {
              arrayOfInt2[i1] = this.a.c(i2);
              i1++;
            }
          if (i1 != n)
            throw new ReedSolomonException("Error locator degree does not match number of roots");
          localObject10 = arrayOfInt2;
          break label511;
          i12 = i11 & 0xFFFFFFFE;
          break label595;
          arrayOfInt3[i4] = this.a.c(locala3.b(i7), this.a.c(i8));
          if (bool)
            arrayOfInt3[i4] = this.a.c(arrayOfInt3[i4], i7);
          i4++;
          break label525;
          for (int i5 = 0; i5 < localObject10.length; i5++)
          {
            int i6 = -1 + paramArrayOfInt.length - this.a.b(localObject10[i5]);
            if (i6 < 0)
              throw new ReedSolomonException("Bad error location");
            paramArrayOfInt[i6] = GenericGF.b(paramArrayOfInt[i6], arrayOfInt3[i5]);
          }
          break;
        }
        Object localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.reedsolomon.ReedSolomonDecoder
 * JD-Core Version:    0.6.2
 */