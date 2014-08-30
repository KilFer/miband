package com.google.zxing.oned.rss.expanded.decoders;

final class o extends q
{
  private final String a;
  private final int b;
  private final boolean c;

  o(int paramInt, String paramString)
  {
    super(paramInt);
    this.a = paramString;
    this.c = false;
    this.b = 0;
  }

  o(int paramInt1, String paramString, int paramInt2)
  {
    super(paramInt1);
    this.c = true;
    this.b = paramInt2;
    this.a = paramString;
  }

  final String a()
  {
    return this.a;
  }

  final boolean b()
  {
    return this.c;
  }

  final int c()
  {
    return this.b;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.decoders.o
 * JD-Core Version:    0.6.2
 */