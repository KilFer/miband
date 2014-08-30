package u.aly;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class S extends dj<al>
{
  private static void a(cy paramcy, al paramal)
  {
    de localde = (de)paramcy;
    localde.a(paramal.a);
    localde.a(paramal.b);
    localde.a(paramal.c.size());
    Iterator localIterator = paramal.c.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        BitSet localBitSet = new BitSet();
        if (paramal.p())
          localBitSet.set(0);
        if (paramal.s())
          localBitSet.set(1);
        localde.a(localBitSet, 2);
        if (paramal.p())
          localde.a(paramal.d);
        if (paramal.s())
          localde.a(paramal.e);
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localde.a((String)localEntry.getKey());
      localde.a((String)localEntry.getValue());
    }
  }

  private static void b(cy paramcy, al paramal)
  {
    de localde = (de)paramcy;
    paramal.a = localde.x();
    paramal.a(true);
    paramal.b = localde.z();
    paramal.b(true);
    cv localcv = new cv((byte)11, (byte)11, localde.w());
    paramal.c = new HashMap(2 * localcv.c);
    for (int i = 0; ; i++)
    {
      if (i >= localcv.c)
      {
        paramal.c(true);
        BitSet localBitSet = localde.b(2);
        if (localBitSet.get(0))
        {
          paramal.d = localde.x();
          paramal.d(true);
        }
        if (localBitSet.get(1))
        {
          paramal.e = localde.w();
          paramal.e(true);
        }
        return;
      }
      String str1 = localde.z();
      String str2 = localde.z();
      paramal.c.put(str1, str2);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.S
 * JD-Core Version:    0.6.2
 */