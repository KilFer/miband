package u.aly;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class aA extends dj<ao>
{
  private static void a(cy paramcy, ao paramao)
  {
    de localde = (de)paramcy;
    localde.a(paramao.a);
    localde.a(paramao.b.size());
    Iterator localIterator = paramao.b.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localde.a(paramao.e);
        BitSet localBitSet = new BitSet();
        if (paramao.m())
          localBitSet.set(0);
        if (paramao.p())
          localBitSet.set(1);
        localde.a(localBitSet, 2);
        if (paramao.m())
          localde.a(paramao.c);
        if (paramao.p())
          localde.a(paramao.d);
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localde.a((String)localEntry.getKey());
      ((az)localEntry.getValue()).b(localde);
    }
  }

  private static void b(cy paramcy, ao paramao)
  {
    de localde = (de)paramcy;
    paramao.a = localde.z();
    paramao.a(true);
    cv localcv = new cv((byte)11, (byte)12, localde.w());
    paramao.b = new HashMap(2 * localcv.c);
    for (int i = 0; ; i++)
    {
      if (i >= localcv.c)
      {
        paramao.b(true);
        paramao.e = localde.x();
        paramao.e(true);
        BitSet localBitSet = localde.b(2);
        if (localBitSet.get(0))
        {
          paramao.c = localde.x();
          paramao.c(true);
        }
        if (localBitSet.get(1))
        {
          paramao.d = localde.w();
          paramao.d(true);
        }
        return;
      }
      String str = localde.z();
      az localaz = new az();
      localaz.a(localde);
      paramao.b.put(str, localaz);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aA
 * JD-Core Version:    0.6.2
 */