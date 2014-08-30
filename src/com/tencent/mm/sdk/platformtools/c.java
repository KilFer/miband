package com.tencent.mm.sdk.platformtools;

final class c
  implements CharSequence
{
  c(byte[] paramArrayOfByte)
  {
  }

  public final char charAt(int paramInt)
  {
    return (char)this.a[paramInt];
  }

  public final int length()
  {
    return this.a.length;
  }

  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return CharSequences.forAsciiBytes(this.a, paramInt1, paramInt2);
  }

  public final String toString()
  {
    return new String(this.a);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.c
 * JD-Core Version:    0.6.2
 */