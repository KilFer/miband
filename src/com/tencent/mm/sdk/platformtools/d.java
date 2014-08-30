package com.tencent.mm.sdk.platformtools;

final class d
  implements CharSequence
{
  d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
  }

  public final char charAt(int paramInt)
  {
    return (char)this.a[(paramInt + this.b)];
  }

  public final int length()
  {
    return this.c - this.b;
  }

  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    int i = paramInt1 - this.b;
    int j = paramInt2 - this.b;
    CharSequences.a(i, j, length());
    return CharSequences.forAsciiBytes(this.a, i, j);
  }

  public final String toString()
  {
    return new String(this.a, this.b, length());
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.d
 * JD-Core Version:    0.6.2
 */