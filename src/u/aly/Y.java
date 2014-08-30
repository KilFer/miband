package u.aly;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Y extends di<ao>
{
  private void a(cy paramcy, ao paramao)
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
        if (localct.b == 11)
        {
          paramao.a = paramcy.z();
          paramao.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 13)
          {
            cv localcv = paramcy.n();
            paramao.b = new HashMap(2 * localcv.c);
            for (int i = 0; ; i++)
            {
              if (i >= localcv.c)
              {
                paramcy.o();
                paramao.b(true);
                break;
              }
              String str = paramcy.z();
              az localaz = new az();
              localaz.a(paramcy);
              paramao.b.put(str, localaz);
            }
          }
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 10)
          {
            paramao.c = paramcy.x();
            paramao.c(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 8)
            {
              paramao.d = paramcy.w();
              paramao.d(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 10)
              {
                paramao.e = paramcy.x();
                paramao.e(true);
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
    if (!paramao.s())
      throw new cz("Required field 'ts' was not found in serialized data! Struct: " + toString());
    paramao.t();
  }

  private static void b(cy paramcy, ao paramao)
  {
    paramao.t();
    paramcy.a(ao.u());
    if (paramao.a != null)
    {
      paramcy.a(ao.v());
      paramcy.a(paramao.a);
      paramcy.c();
    }
    Iterator localIterator;
    if (paramao.b != null)
    {
      paramcy.a(ao.w());
      paramcy.a(new cv((byte)11, (byte)12, paramao.b.size()));
      localIterator = paramao.b.entrySet().iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
      {
        paramcy.e();
        paramcy.c();
        if (paramao.m())
        {
          paramcy.a(ao.x());
          paramcy.a(paramao.c);
          paramcy.c();
        }
        if (paramao.p())
        {
          paramcy.a(ao.y());
          paramcy.a(paramao.d);
          paramcy.c();
        }
        paramcy.a(ao.z());
        paramcy.a(paramao.e);
        paramcy.c();
        paramcy.d();
        paramcy.b();
        return;
      }
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramcy.a((String)localEntry.getKey());
      ((az)localEntry.getValue()).b(paramcy);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.Y
 * JD-Core Version:    0.6.2
 */