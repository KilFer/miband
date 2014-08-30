package com.google.gson.internal;

final class z
  implements CharSequence
{
  char[] a;

  public final char charAt(int paramInt)
  {
    return this.a[paramInt];
  }

  public final int length()
  {
    return this.a.length;
  }

  public final CharSequence subSequence(int paramInt1, int paramInt2)
  {
    return new String(this.a, paramInt1, paramInt2 - paramInt1);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.gson.internal.z
 * JD-Core Version:    0.6.2
 */