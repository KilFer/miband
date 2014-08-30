package com.google.zxing.common;

public final class BitArray
{
  private int[] a;
  private int b;

  public BitArray()
  {
    this.b = 0;
    this.a = new int[1];
  }

  public BitArray(int paramInt)
  {
    this.b = paramInt;
    this.a = b(paramInt);
  }

  private void a(int paramInt)
  {
    if (paramInt > this.a.length << 5)
    {
      int[] arrayOfInt = b(paramInt);
      System.arraycopy(this.a, 0, arrayOfInt, 0, this.a.length);
      this.a = arrayOfInt;
    }
  }

  private static int[] b(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }

  public final void appendBit(boolean paramBoolean)
  {
    a(1 + this.b);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.a;
      int i = this.b >> 5;
      arrayOfInt[i] |= 1 << (0x1F & this.b);
    }
    this.b = (1 + this.b);
  }

  public final void appendBitArray(BitArray paramBitArray)
  {
    int i = paramBitArray.b;
    a(i + this.b);
    for (int j = 0; j < i; j++)
      appendBit(paramBitArray.get(j));
  }

  public final void appendBits(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32))
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    a(paramInt2 + this.b);
    if (paramInt2 > 0)
    {
      if ((0x1 & paramInt1 >> paramInt2 - 1) == 1);
      for (boolean bool = true; ; bool = false)
      {
        appendBit(bool);
        paramInt2--;
        break;
      }
    }
  }

  public final void clear()
  {
    int i = this.a.length;
    for (int j = 0; j < i; j++)
      this.a[j] = 0;
  }

  public final void flip(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int i = paramInt >> 5;
    arrayOfInt[i] ^= 1 << (paramInt & 0x1F);
  }

  public final boolean get(int paramInt)
  {
    return (this.a[(paramInt >> 5)] & 1 << (paramInt & 0x1F)) != 0;
  }

  public final int[] getBitArray()
  {
    return this.a;
  }

  public final int getNextSet(int paramInt)
  {
    int k;
    if (paramInt >= this.b)
      k = this.b;
    do
    {
      return k;
      int i = paramInt >> 5;
      for (int j = this.a[i] & (0xFFFFFFFF ^ -1 + (1 << (paramInt & 0x1F))); j == 0; j = this.a[i])
      {
        i++;
        if (i == this.a.length)
          return this.b;
      }
      k = (i << 5) + Integer.numberOfTrailingZeros(j);
    }
    while (k <= this.b);
    return this.b;
  }

  public final int getNextUnset(int paramInt)
  {
    int k;
    if (paramInt >= this.b)
      k = this.b;
    do
    {
      return k;
      int i = paramInt >> 5;
      for (int j = (0xFFFFFFFF ^ this.a[i]) & (0xFFFFFFFF ^ -1 + (1 << (paramInt & 0x1F))); j == 0; j = 0xFFFFFFFF ^ this.a[i])
      {
        i++;
        if (i == this.a.length)
          return this.b;
      }
      k = (i << 5) + Integer.numberOfTrailingZeros(j);
    }
    while (k <= this.b);
    return this.b;
  }

  public final int getSize()
  {
    return this.b;
  }

  public final int getSizeInBytes()
  {
    return 7 + this.b >> 3;
  }

  public final boolean isRange(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException();
    if (paramInt2 == paramInt1)
      return true;
    int i = paramInt2 - 1;
    int j = paramInt1 >> 5;
    int k = i >> 5;
    label156: label162: for (int m = j; m <= k; m++)
    {
      int n;
      int i1;
      label68: int i3;
      label83: int i4;
      if (m > j)
      {
        n = 0;
        if (m >= k)
          break label117;
        i1 = 31;
        if ((n != 0) || (i1 != 31))
          break label127;
        i3 = -1;
        i4 = i3 & this.a[m];
        if (!paramBoolean)
          break label156;
      }
      while (true)
      {
        if (i4 == i3)
          break label162;
        return false;
        n = paramInt1 & 0x1F;
        break;
        label117: i1 = i & 0x1F;
        break label68;
        label127: int i2 = n;
        i3 = 0;
        while (i2 <= i1)
        {
          i3 |= 1 << i2;
          i2++;
        }
        break label83;
        i3 = 0;
      }
    }
    return true;
  }

  public final void reverse()
  {
    int[] arrayOfInt = new int[this.a.length];
    int i = this.b;
    for (int j = 0; j < i; j++)
      if (get(-1 + (i - j)))
      {
        int k = j >> 5;
        arrayOfInt[k] |= 1 << (j & 0x1F);
      }
    this.a = arrayOfInt;
  }

  public final void set(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int i = paramInt >> 5;
    arrayOfInt[i] |= 1 << (paramInt & 0x1F);
  }

  public final void setBulk(int paramInt1, int paramInt2)
  {
    this.a[(paramInt1 >> 5)] = paramInt2;
  }

  public final void setRange(int paramInt1, int paramInt2)
  {
    if (paramInt2 < paramInt1)
      throw new IllegalArgumentException();
    if (paramInt2 == paramInt1)
      return;
    int i = paramInt2 - 1;
    int j = paramInt1 >> 5;
    int k = i >> 5;
    int m = j;
    label37: int n;
    label54: int i1;
    label65: int i3;
    if (m <= k)
    {
      if (m <= j)
        break label105;
      n = 0;
      if (m >= k)
        break label114;
      i1 = 31;
      if ((n != 0) || (i1 != 31))
        break label123;
      i3 = -1;
    }
    while (true)
    {
      int[] arrayOfInt = this.a;
      arrayOfInt[m] = (i3 | arrayOfInt[m]);
      m++;
      break label37;
      break;
      label105: n = paramInt1 & 0x1F;
      break label54;
      label114: i1 = i & 0x1F;
      break label65;
      label123: int i2 = n;
      i3 = 0;
      while (i2 <= i1)
      {
        i3 |= 1 << i2;
        i2++;
      }
    }
  }

  public final void toBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    int m;
    for (int j = paramInt1; i < paramInt3; j = m)
    {
      int k = 0;
      m = j;
      int n = 0;
      while (k < 8)
      {
        if (get(m))
          n |= 1 << 7 - k;
        m++;
        k++;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)n);
      i++;
    }
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.b);
    int i = 0;
    if (i < this.b)
    {
      if ((i & 0x7) == 0)
        localStringBuilder.append(' ');
      if (get(i));
      for (char c = 'X'; ; c = '.')
      {
        localStringBuilder.append(c);
        i++;
        break;
      }
    }
    return localStringBuilder.toString();
  }

  public final void xor(BitArray paramBitArray)
  {
    if (this.a.length != paramBitArray.a.length)
      throw new IllegalArgumentException("Sizes don't match");
    for (int i = 0; i < this.a.length; i++)
    {
      int[] arrayOfInt = this.a;
      arrayOfInt[i] ^= paramBitArray.a[i];
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.common.BitArray
 * JD-Core Version:    0.6.2
 */