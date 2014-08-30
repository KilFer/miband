package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Q extends di<al>
{
  private void a(cy paramcy, al paramal)
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
      case 4:
      case 5:
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 10)
        {
          paramal.a = paramcy.x();
          paramal.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            paramal.b = paramcy.z();
            paramal.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 13)
            {
              cv localcv = paramcy.n();
              paramal.c = new HashMap(2 * localcv.c);
              for (int i = 0; ; i++)
              {
                if (i >= localcv.c)
                {
                  paramcy.o();
                  paramal.c(true);
                  break;
                }
                String str1 = paramcy.z();
                String str2 = paramcy.z();
                paramal.c.put(str1, str2);
              }
            }
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 10)
            {
              paramal.d = paramcy.x();
              paramal.d(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 8)
              {
                paramal.e = paramcy.w();
                paramal.e(true);
              }
              else
              {
                db.a(paramcy, localct.b);
              }
            }
          }
        }
      }
    }
    paramcy.k();
    if (!paramal.e())
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    paramal.t();
  }

  private static void b(cy paramcy, al paramal)
  {
    paramal.t();
    paramcy.a(al.u());
    paramcy.a(al.v());
    paramcy.a(paramal.a);
    paramcy.c();
    if (paramal.b != null)
    {
      paramcy.a(al.w());
      paramcy.a(paramal.b);
      paramcy.c();
    }
    Iterator localIterator;
    if (paramal.c != null)
    {
      paramcy.a(al.x());
      paramcy.a(new cv((byte)11, (byte)11, paramal.c.size()));
      localIterator = paramal.c.entrySet().iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        paramcy.e();
        paramcy.c();
        if (paramal.p())
        {
          paramcy.a(al.y());
          paramcy.a(paramal.d);
          paramcy.c();
        }
        if (paramal.s())
        {
          paramcy.a(al.z());
          paramcy.a(paramal.e);
          paramcy.c();
        }
        paramcy.d();
        paramcy.b();
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramcy.a((String)localEntry.getKey());
      paramcy.a((String)localEntry.getValue());
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.Q
 * JD-Core Version:    0.6.2
 */