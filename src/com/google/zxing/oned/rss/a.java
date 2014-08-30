package com.google.zxing.oned.rss;

final class a extends DataCharacter
{
  private final FinderPattern a;
  private int b;

  a(int paramInt1, int paramInt2, FinderPattern paramFinderPattern)
  {
    super(paramInt1, paramInt2);
    this.a = paramFinderPattern;
  }

  final FinderPattern a()
  {
    return this.a;
  }

  final int b()
  {
    return this.b;
  }

  final void c()
  {
    this.b = (1 + this.b);
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.a
 * JD-Core Version:    0.6.2
 */