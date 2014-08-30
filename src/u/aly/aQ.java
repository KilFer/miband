package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class aQ extends dj<at>
{
  private static void a(cy paramcy, at paramat)
  {
    de localde = (de)paramcy;
    localde.a(paramat.a.size());
    Iterator localIterator = paramat.a.entrySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        localde.a(paramat.b);
        localde.a(paramat.c);
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localde.a((String)localEntry.getKey());
      ((au)localEntry.getValue()).b(localde);
    }
  }

  private static void b(cy paramcy, at paramat)
  {
    de localde = (de)paramcy;
    cv localcv = new cv((byte)11, (byte)12, localde.w());
    paramat.a = new HashMap(2 * localcv.c);
    for (int i = 0; ; i++)
    {
      if (i >= localcv.c)
      {
        paramat.a(true);
        paramat.b = localde.w();
        paramat.b(true);
        paramat.c = localde.z();
        paramat.c(true);
        return;
      }
      String str = localde.z();
      au localau = new au();
      localau.a(localde);
      paramat.a.put(str, localau);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aQ
 * JD-Core Version:    0.6.2
 */