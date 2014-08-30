package com.google.zxing.common;

public final class BitMatrix
{
  private final int a;
  private final int b;
  private final int c;
  private final int[] d;

  public BitMatrix(int paramInt)
  {
    this(paramInt, paramInt);
  }

  public BitMatrix(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = (paramInt1 + 31 >> 5);
    this.d = new int[paramInt2 * this.c];
  }

  public final void clear()
  {
    int i = this.d.length;
    for (int j = 0; j < i; j++)
      this.d[j] = 0;
  }

  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof BitMatrix));
    BitMatrix localBitMatrix;
    do
    {
      return false;
      localBitMatrix = (BitMatrix)paramObject;
    }
    while ((this.a != localBitMatrix.a) || (this.b != localBitMatrix.b) || (this.c != localBitMatrix.c) || (this.d.length != localBitMatrix.d.length));
    for (int i = 0; ; i++)
    {
      if (i >= this.d.length)
        break label92;
      if (this.d[i] != localBitMatrix.d[i])
        break;
    }
    label92: return true;
  }

  public final void flip(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    int[] arrayOfInt = this.d;
    arrayOfInt[i] ^= 1 << (paramInt1 & 0x1F);
  }

  public final boolean get(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    return (0x1 & this.d[i] >>> (paramInt1 & 0x1F)) != 0;
  }

  public final int[] getBottomRightOnBit()
  {
    for (int i = -1 + this.d.length; (i >= 0) && (this.d[i] == 0); i--);
    if (i < 0)
      return null;
    int j = i / this.c;
    int k = i % this.c << 5;
    int m = this.d[i];
    for (int n = 31; m >>> n == 0; n--);
    return new int[] { k + n, j };
  }

  public final int[] getEnclosingRectangle()
  {
    int i = this.a;
    int j = this.b;
    int k = i;
    int m = -1;
    int n = -1;
    int i1 = 0;
    int i4;
    label33: int i6;
    label132: int i7;
    int i8;
    int i9;
    if (i1 < this.b)
    {
      i4 = 0;
      if (i4 < this.c)
      {
        int i5 = this.d[(i4 + i1 * this.c)];
        if (i5 == 0)
          break label286;
        if (i1 < j)
          j = i1;
        if (i1 > n)
          n = i1;
        if (i4 << 5 >= k)
          break label280;
        for (int i12 = 0; i5 << 31 - i12 == 0; i12++);
        if (i12 + (i4 << 5) >= k)
          break label280;
        i6 = i12 + (i4 << 5);
        if (31 + (i4 << 5) <= m)
          break label266;
        for (int i10 = 31; i5 >>> i10 == 0; i10--);
        if (i10 + (i4 << 5) <= m)
          break label266;
        int i11 = i10 + (i4 << 5);
        i7 = j;
        i8 = i11;
        i9 = n;
      }
    }
    while (true)
    {
      i4++;
      n = i9;
      m = i8;
      j = i7;
      k = i6;
      break label33;
      i1++;
      break;
      int i2 = m - k;
      int i3 = n - j;
      if ((i2 < 0) || (i3 < 0))
        return null;
      return new int[] { k, j, i2, i3 };
      label266: i7 = j;
      i8 = m;
      i9 = n;
      continue;
      label280: i6 = k;
      break label132;
      label286: i6 = k;
      i7 = j;
      i8 = m;
      i9 = n;
    }
  }

  public final int getHeight()
  {
    return this.b;
  }

  public final BitArray getRow(int paramInt, BitArray paramBitArray)
  {
    if ((paramBitArray == null) || (paramBitArray.getSize() < this.a))
      paramBitArray = new BitArray(this.a);
    int i = paramInt * this.c;
    for (int j = 0; j < this.c; j++)
      paramBitArray.setBulk(j << 5, this.d[(i + j)]);
    return paramBitArray;
  }

  public final int[] getTopLeftOnBit()
  {
    for (int i = 0; (i < this.d.length) && (this.d[i] == 0); i++);
    if (i == this.d.length)
      return null;
    int j = i / this.c;
    int k = i % this.c << 5;
    int m = this.d[i];
    for (int n = 0; m << 31 - n == 0; n++);
    return new int[] { k + n, j };
  }

  public final int getWidth()
  {
    return this.a;
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (31 * this.a + this.a) + this.b) + this.c;
    int[] arrayOfInt = this.d;
    int j = arrayOfInt.length;
    for (int k = 0; k < j; k++)
      i = arrayOfInt[k] + i * 31;
    return i;
  }

  public final void set(int paramInt1, int paramInt2)
  {
    int i = paramInt2 * this.c + (paramInt1 >> 5);
    int[] arrayOfInt = this.d;
    arrayOfInt[i] |= 1 << (paramInt1 & 0x1F);
  }

  public final void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0))
      throw new IllegalArgumentException("Left and top must be nonnegative");
    if ((paramInt4 <= 0) || (paramInt3 <= 0))
      throw new IllegalArgumentException("Height and width must be at least 1");
    int i = paramInt1 + paramInt3;
    int j = paramInt2 + paramInt4;
    if ((j > this.b) || (i > this.a))
      throw new IllegalArgumentException("The region must fit inside the matrix");
    while (true)
    {
      paramInt2++;
      if (paramInt2 >= j)
        break;
      int k = paramInt2 * this.c;
      for (int m = paramInt1; m < i; m++)
      {
        int[] arrayOfInt = this.d;
        int n = k + (m >> 5);
        arrayOfInt[n] |= 1 << (m & 0x1F);
      }
    }
  }

  public final void setRow(int paramInt, BitArray paramBitArray)
  {
    System.arraycopy(paramBitArray.getBitArray(), 0, this.d, paramInt * this.c, this.c);
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b * (1 + this.a));
    for (int i = 0; i < this.b; i++)
    {
      int j = 0;
      if (j < this.a)
      {
        if (get(j, i));
        for (String str = "X "; ; str = "  ")
        {
          localStringBuilder.append(str);
          j++;
          break;
        }
      }
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.BitMatrix
 * JD-Core Version:    0.6.2
 */