package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class aO extends di<at>
{
  private void a(cy paramcy, at paramat)
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
          paramat.a = new HashMap(2 * localcv.c);
          for (int i = 0; ; i++)
          {
            if (i >= localcv.c)
            {
              paramcy.o();
              paramat.a(true);
              break;
            }
            String str = paramcy.z();
            au localau = new au();
            localau.a(paramcy);
            paramat.a.put(str, localau);
          }
        }
        db.a(paramcy, localct.b);
        continue;
        if (localct.b == 8)
        {
          paramat.b = paramcy.w();
          paramat.b(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 11)
          {
            paramat.c = paramcy.z();
            paramat.c(true);
          }
          else
          {
            db.a(paramcy, localct.b);
          }
        }
      }
    }
    paramcy.k();
    if (!paramat.j())
      throw new cz("Required field 'version' was not found in serialized data! Struct: " + toString());
    paramat.n();
  }

  private static void b(cy paramcy, at paramat)
  {
    paramat.n();
    paramcy.a(at.o());
    Iterator localIterator;
    if (paramat.a != null)
    {
      paramcy.a(at.p());
      paramcy.a(new cv((byte)11, (byte)12, paramat.a.size()));
      localIterator = paramat.a.entrySet().iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        paramcy.e();
        paramcy.c();
        paramcy.a(at.q());
        paramcy.a(paramat.b);
        paramcy.c();
        if (paramat.c != null)
        {
          paramcy.a(at.r());
          paramcy.a(paramat.c);
          paramcy.c();
        }
        paramcy.d();
        paramcy.b();
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramcy.a((String)localEntry.getKey());
      ((au)localEntry.getValue()).b(paramcy);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.aO
 * JD-Core Version:    0.6.2
 */