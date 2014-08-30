package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import java.util.List;

class a
{
  private final boolean a;
  private final DataCharacter b;
  private final DataCharacter c;
  private final FinderPattern d;

  private a()
  {
  }

  a(DataCharacter paramDataCharacter1, DataCharacter paramDataCharacter2, FinderPattern paramFinderPattern, boolean paramBoolean)
  {
    this.b = paramDataCharacter1;
    this.c = paramDataCharacter2;
    this.d = paramFinderPattern;
    this.a = paramBoolean;
  }

  static BitArray a(List<a> paramList)
  {
    int i = -1 + (paramList.size() << 1);
    if (((a)paramList.get(-1 + paramList.size())).c() == null);
    for (int j = i - 1; ; j = i)
    {
      BitArray localBitArray = new BitArray(j * 12);
      int k = ((a)paramList.get(0)).c().getValue();
      int m = 11;
      int i10;
      for (int n = 0; m >= 0; n = i10)
      {
        if ((k & 1 << m) != 0)
          localBitArray.set(n);
        i10 = n + 1;
        m--;
      }
      int i1 = 1;
      int i5;
      for (int i2 = n; i1 < paramList.size(); i2 = i5)
      {
        a locala = (a)paramList.get(i1);
        int i3 = locala.b().getValue();
        int i4 = 11;
        while (i4 >= 0)
        {
          if ((i3 & 1 << i4) != 0)
            localBitArray.set(i2);
          int i9 = i2 + 1;
          i4--;
          i2 = i9;
        }
        if (locala.c() != null)
        {
          int i6 = locala.c().getValue();
          i5 = i2;
          int i7 = 11;
          while (i7 >= 0)
          {
            if ((i6 & 1 << i7) != 0)
              localBitArray.set(i5);
            int i8 = i5 + 1;
            i7--;
            i5 = i8;
          }
        }
        i5 = i2;
        i1++;
      }
      return localBitArray;
    }
  }

  boolean a()
  {
    return this.a;
  }

  DataCharacter b()
  {
    return this.b;
  }

  DataCharacter c()
  {
    return this.c;
  }

  FinderPattern d()
  {
    return this.d;
  }

  public boolean e()
  {
    return this.c == null;
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     com.google.zxing.oned.rss.expanded.a
 * JD-Core Version:    0.6.2
 */