package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

final class bW extends dj<bd>
{
  private static void a(cy paramcy, bd parambd)
  {
    de localde = (de)paramcy;
    localde.a(parambd.a);
    localde.a(parambd.b);
    localde.a(parambd.c);
    localde.a(parambd.d);
    BitSet localBitSet = new BitSet();
    if (parambd.t())
      localBitSet.set(0);
    if (parambd.y())
      localBitSet.set(1);
    if (parambd.B())
      localBitSet.set(2);
    localde.a(localBitSet, 3);
    Iterator localIterator2;
    Iterator localIterator1;
    if (parambd.t())
    {
      localde.a(parambd.e.size());
      localIterator2 = parambd.e.iterator();
      if (localIterator2.hasNext());
    }
    else if (parambd.y())
    {
      localde.a(parambd.f.size());
      localIterator1 = parambd.f.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        if (parambd.B())
          parambd.g.b(localde);
        return;
        ((ay)localIterator2.next()).b(localde);
        break;
      }
      ((aw)localIterator1.next()).b(localde);
    }
  }

  private static void b(cy paramcy, bd parambd)
  {
    int i = 0;
    de localde = (de)paramcy;
    parambd.a = localde.z();
    parambd.a(true);
    parambd.b = localde.x();
    parambd.b(true);
    parambd.c = localde.x();
    parambd.c(true);
    parambd.d = localde.x();
    parambd.d(true);
    BitSet localBitSet = localde.b(3);
    int j;
    cu localcu2;
    if (localBitSet.get(0))
    {
      cu localcu1 = new cu((byte)12, localde.w());
      parambd.e = new ArrayList(localcu1.b);
      j = 0;
      if (j >= localcu1.b)
        parambd.e(true);
    }
    else if (localBitSet.get(1))
    {
      localcu2 = new cu((byte)12, localde.w());
      parambd.f = new ArrayList(localcu2.b);
    }
    while (true)
    {
      if (i >= localcu2.b)
      {
        parambd.f(true);
        if (localBitSet.get(2))
        {
          parambd.g = new be();
          parambd.g.a(localde);
          parambd.g(true);
        }
        return;
        ay localay = new ay();
        localay.a(localde);
        parambd.e.add(localay);
        j++;
        break;
      }
      aw localaw = new aw();
      localaw.a(localde);
      parambd.f.add(localaw);
      i++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.bW
 * JD-Core Version:    0.6.2
 */