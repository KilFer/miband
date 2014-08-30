package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

final class b
{
  private final boolean a;
  private final DataCharacter b;
  private final DataCharacter c;
  private final FinderPattern d;

  b(DataCharacter paramDataCharacter1, DataCharacter paramDataCharacter2, FinderPattern paramFinderPattern, boolean paramBoolean)
  {
    this.b = paramDataCharacter1;
    this.c = paramDataCharacter2;
    this.d = paramFinderPattern;
    this.a = paramBoolean;
  }

  final boolean a()
  {
    return this.a;
  }

  final DataCharacter b()
  {
    return this.b;
  }

  final DataCharacter c()
  {
    return this.c;
  }

  final FinderPattern d()
  {
    return this.d;
  }

  public final boolean e()
  {
    return this.c == null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.b
 * JD-Core Version:    0.6.2
 */