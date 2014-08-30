package u.aly;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class aK extends di<as>
{
  private static void a(cy paramcy, as paramas)
  {
    paramcy.j();
    ct localct = paramcy.l();
    if (localct.b != 0)
    {
      switch (localct.c)
      {
      default:
        db.a(paramcy, localct.b);
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 13)
        {
          cv localcv = paramcy.n();
          paramas.a = new HashMap(2 * localcv.c);
          for (int j = 0; ; j++)
          {
            if (j >= localcv.c)
            {
              paramcy.o();
              paramas.a(true);
              break;
            }
            String str = paramcy.z();
            ar localar = new ar();
            localar.a(paramcy);
            paramas.a.put(str, localar);
          }
        }
        db.a(paramcy, localct.b);
        continue;
        if (localct.b == 15)
        {
          cu localcu = paramcy.p();
          paramas.b = new ArrayList(localcu.b);
          for (int i = 0; ; i++)
          {
            if (i >= localcu.b)
            {
              paramcy.q();
              paramas.b(true);
              break;
            }
            aq localaq = new aq();
            localaq.a(paramcy);
            paramas.b.add(localaq);
          }
        }
        db.a(paramcy, localct.b);
        continue;
        if (localct.b == 11)
        {
          paramas.c = paramcy.z();
          paramas.c(true);
        }
        else
        {
          db.a(paramcy, localct.b);
        }
      }
    }
    paramcy.k();
    paramas.p();
  }

  private static void b(cy paramcy, as paramas)
  {
    paramas.p();
    paramcy.a(as.q());
    Iterator localIterator2;
    Iterator localIterator1;
    if (paramas.a != null)
    {
      paramcy.a(as.r());
      paramcy.a(new cv((byte)11, (byte)12, paramas.a.size()));
      localIterator2 = paramas.a.entrySet().iterator();
      if (!localIterator2.hasNext())
      {
        paramcy.e();
        paramcy.c();
      }
    }
    else if ((paramas.b != null) && (paramas.l()))
    {
      paramcy.a(as.s());
      paramcy.a(new cu((byte)12, paramas.b.size()));
      localIterator1 = paramas.b.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        paramcy.f();
        paramcy.c();
        if ((paramas.c != null) && (paramas.o()))
        {
          paramcy.a(as.t());
          paramcy.a(paramas.c);
          paramcy.c();
        }
        paramcy.d();
        paramcy.b();
        return;
        Map.Entry localEntry = (Map.Entry)localIterator2.next();
        paramcy.a((String)localEntry.getKey());
        ((ar)localEntry.getValue()).b(paramcy);
        break;
      }
      ((aq)localIterator1.next()).b(paramcy);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aK
 * JD-Core Version:    0.6.2
 */