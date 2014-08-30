package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

final class cE extends dj<bf>
{
  private static void a(cy paramcy, bf parambf)
  {
    de localde = (de)paramcy;
    parambf.a.b(localde);
    parambf.b.b(localde);
    parambf.c.b(localde);
    parambf.d.b(localde);
    BitSet localBitSet = new BitSet();
    if (parambf.r())
      localBitSet.set(0);
    if (parambf.w())
      localBitSet.set(1);
    if (parambf.B())
      localBitSet.set(2);
    if (parambf.E())
      localBitSet.set(3);
    if (parambf.H())
      localBitSet.set(4);
    localde.a(localBitSet, 5);
    if (parambf.r())
      parambf.e.b(localde);
    Iterator localIterator2;
    Iterator localIterator1;
    if (parambf.w())
    {
      localde.a(parambf.f.size());
      localIterator2 = parambf.f.iterator();
      if (localIterator2.hasNext());
    }
    else if (parambf.B())
    {
      localde.a(parambf.g.size());
      localIterator1 = parambf.g.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        if (parambf.E())
          parambf.h.b(localde);
        if (parambf.H())
          parambf.i.b(localde);
        return;
        ((av)localIterator2.next()).b(localde);
        break;
      }
      ((bd)localIterator1.next()).b(localde);
    }
  }

  private static void b(cy paramcy, bf parambf)
  {
    int i = 0;
    de localde = (de)paramcy;
    parambf.a = new aj();
    parambf.a.a(localde);
    parambf.a(true);
    parambf.b = new ai();
    parambf.b.a(localde);
    parambf.b(true);
    parambf.c = new ak();
    parambf.c.a(localde);
    parambf.c(true);
    parambf.d = new ax();
    parambf.d.a(localde);
    parambf.d(true);
    BitSet localBitSet = localde.b(5);
    if (localBitSet.get(0))
    {
      parambf.e = new ah();
      parambf.e.a(localde);
      parambf.e(true);
    }
    int j;
    cu localcu2;
    if (localBitSet.get(1))
    {
      cu localcu1 = new cu((byte)12, localde.w());
      parambf.f = new ArrayList(localcu1.b);
      j = 0;
      if (j >= localcu1.b)
        parambf.f(true);
    }
    else if (localBitSet.get(2))
    {
      localcu2 = new cu((byte)12, localde.w());
      parambf.g = new ArrayList(localcu2.b);
    }
    while (true)
    {
      if (i >= localcu2.b)
      {
        parambf.g(true);
        if (localBitSet.get(3))
        {
          parambf.h = new at();
          parambf.h.a(localde);
          parambf.h(true);
        }
        if (localBitSet.get(4))
        {
          parambf.i = new as();
          parambf.i.a(localde);
          parambf.i(true);
        }
        return;
        av localav = new av();
        localav.a(localde);
        parambf.f.add(localav);
        j++;
        break;
      }
      bd localbd = new bd();
      localbd.a(localde);
      parambf.g.add(localbd);
      i++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.cE
 * JD-Core Version:    0.6.2
 */