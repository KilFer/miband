package u.aly;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class aM extends dj<as>
{
  private static void a(cy paramcy, as paramas)
  {
    de localde = (de)paramcy;
    localde.a(paramas.a.size());
    Iterator localIterator1 = paramas.a.entrySet().iterator();
    Iterator localIterator2;
    if (!localIterator1.hasNext())
    {
      BitSet localBitSet = new BitSet();
      if (paramas.l())
        localBitSet.set(0);
      if (paramas.o())
        localBitSet.set(1);
      localde.a(localBitSet, 2);
      if (paramas.l())
      {
        localde.a(paramas.b.size());
        localIterator2 = paramas.b.iterator();
      }
    }
    while (true)
    {
      if (!localIterator2.hasNext())
      {
        if (paramas.o())
          localde.a(paramas.c);
        return;
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        localde.a((String)localEntry.getKey());
        ((ar)localEntry.getValue()).b(localde);
        break;
      }
      ((aq)localIterator2.next()).b(localde);
    }
  }

  private static void b(cy paramcy, as paramas)
  {
    int i = 0;
    de localde = (de)paramcy;
    cv localcv = new cv((byte)11, (byte)12, localde.w());
    paramas.a = new HashMap(2 * localcv.c);
    int j = 0;
    BitSet localBitSet;
    cu localcu;
    if (j >= localcv.c)
    {
      paramas.a(true);
      localBitSet = localde.b(2);
      if (localBitSet.get(0))
      {
        localcu = new cu((byte)12, localde.w());
        paramas.b = new ArrayList(localcu.b);
      }
    }
    while (true)
    {
      if (i >= localcu.b)
      {
        paramas.b(true);
        if (localBitSet.get(1))
        {
          paramas.c = localde.z();
          paramas.c(true);
        }
        return;
        String str = localde.z();
        ar localar = new ar();
        localar.a(localde);
        paramas.a.put(str, localar);
        j++;
        break;
      }
      aq localaq = new aq();
      localaq.a(localde);
      paramas.b.add(localaq);
      i++;
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aM
 * JD-Core Version:    0.6.2
 */