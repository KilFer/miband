package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

final class aY extends dj<av>
{
  private static void a(cy paramcy, av paramav)
  {
    de localde = (de)paramcy;
    localde.a(paramav.a);
    BitSet localBitSet = new BitSet();
    if (paramav.k())
      localBitSet.set(0);
    if (paramav.p())
      localBitSet.set(1);
    if (paramav.u())
      localBitSet.set(2);
    localde.a(localBitSet, 3);
    Iterator localIterator3;
    Iterator localIterator2;
    label135: Iterator localIterator1;
    if (paramav.k())
    {
      localde.a(paramav.b.size());
      localIterator3 = paramav.b.iterator();
      if (localIterator3.hasNext());
    }
    else
    {
      if (paramav.p())
      {
        localde.a(paramav.c.size());
        localIterator2 = paramav.c.iterator();
        if (localIterator2.hasNext())
          break label204;
      }
      if (paramav.u())
      {
        localde.a(paramav.d.size());
        localIterator1 = paramav.d.iterator();
      }
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        return;
        ((am)localIterator3.next()).b(localde);
        break;
        label204: ((ao)localIterator2.next()).b(localde);
        break label135;
      }
      ((ao)localIterator1.next()).b(localde);
    }
  }

  private static void b(cy paramcy, av paramav)
  {
    int i = 0;
    de localde = (de)paramcy;
    paramav.a = localde.z();
    paramav.a(true);
    BitSet localBitSet = localde.b(3);
    int j;
    int k;
    label128: cu localcu3;
    if (localBitSet.get(0))
    {
      cu localcu1 = new cu((byte)12, localde.w());
      paramav.b = new ArrayList(localcu1.b);
      j = 0;
      if (j >= localcu1.b)
        paramav.b(true);
    }
    else
    {
      if (localBitSet.get(1))
      {
        cu localcu2 = new cu((byte)12, localde.w());
        paramav.c = new ArrayList(localcu2.b);
        k = 0;
        if (k < localcu2.b)
          break label231;
        paramav.c(true);
      }
      if (localBitSet.get(2))
      {
        localcu3 = new cu((byte)12, localde.w());
        paramav.d = new ArrayList(localcu3.b);
      }
    }
    while (true)
    {
      if (i >= localcu3.b)
      {
        paramav.d(true);
        return;
        am localam = new am();
        localam.a(localde);
        paramav.b.add(localam);
        j++;
        break;
        label231: ao localao1 = new ao();
        localao1.a(localde);
        paramav.c.add(localao1);
        k++;
        break label128;
      }
      ao localao2 = new ao();
      localao2.a(localde);
      paramav.d.add(localao2);
      i++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aY
 * JD-Core Version:    0.6.2
 */