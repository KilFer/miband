package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class cC extends di<bf>
{
  private static void a(cy paramcy, bf parambf)
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
      case 6:
      case 7:
      case 8:
      case 9:
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 12)
        {
          parambf.a = new aj();
          parambf.a.a(paramcy);
          parambf.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 12)
          {
            parambf.b = new ai();
            parambf.b.a(paramcy);
            parambf.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 12)
            {
              parambf.c = new ak();
              parambf.c.a(paramcy);
              parambf.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 12)
              {
                parambf.d = new ax();
                parambf.d.a(paramcy);
                parambf.d(true);
              }
              else
              {
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 12)
                {
                  parambf.e = new ah();
                  parambf.e.a(paramcy);
                  parambf.e(true);
                }
                else
                {
                  db.a(paramcy, localct.b);
                  continue;
                  if (localct.b == 15)
                  {
                    cu localcu2 = paramcy.p();
                    parambf.f = new ArrayList(localcu2.b);
                    for (int j = 0; ; j++)
                    {
                      if (j >= localcu2.b)
                      {
                        paramcy.q();
                        parambf.f(true);
                        break;
                      }
                      av localav = new av();
                      localav.a(paramcy);
                      parambf.f.add(localav);
                    }
                  }
                  db.a(paramcy, localct.b);
                  continue;
                  if (localct.b == 15)
                  {
                    cu localcu1 = paramcy.p();
                    parambf.g = new ArrayList(localcu1.b);
                    for (int i = 0; ; i++)
                    {
                      if (i >= localcu1.b)
                      {
                        paramcy.q();
                        parambf.g(true);
                        break;
                      }
                      bd localbd = new bd();
                      localbd.a(paramcy);
                      parambf.g.add(localbd);
                    }
                  }
                  db.a(paramcy, localct.b);
                  continue;
                  if (localct.b == 12)
                  {
                    parambf.h = new at();
                    parambf.h.a(paramcy);
                    parambf.h(true);
                  }
                  else
                  {
                    db.a(paramcy, localct.b);
                    continue;
                    if (localct.b == 12)
                    {
                      parambf.i = new as();
                      parambf.i.a(paramcy);
                      parambf.i(true);
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
        }
      }
    }
    paramcy.k();
    parambf.I();
  }

  private static void b(cy paramcy, bf parambf)
  {
    parambf.I();
    paramcy.a(bf.J());
    if (parambf.a != null)
    {
      paramcy.a(bf.K());
      parambf.a.b(paramcy);
      paramcy.c();
    }
    if (parambf.b != null)
    {
      paramcy.a(bf.L());
      parambf.b.b(paramcy);
      paramcy.c();
    }
    if (parambf.c != null)
    {
      paramcy.a(bf.M());
      parambf.c.b(paramcy);
      paramcy.c();
    }
    if (parambf.d != null)
    {
      paramcy.a(bf.N());
      parambf.d.b(paramcy);
      paramcy.c();
    }
    if ((parambf.e != null) && (parambf.r()))
    {
      paramcy.a(bf.O());
      parambf.e.b(paramcy);
      paramcy.c();
    }
    Iterator localIterator2;
    Iterator localIterator1;
    if ((parambf.f != null) && (parambf.w()))
    {
      paramcy.a(bf.P());
      paramcy.a(new cu((byte)12, parambf.f.size()));
      localIterator2 = parambf.f.iterator();
      if (!localIterator2.hasNext())
      {
        paramcy.f();
        paramcy.c();
      }
    }
    else if ((parambf.g != null) && (parambf.B()))
    {
      paramcy.a(bf.Q());
      paramcy.a(new cu((byte)12, parambf.g.size()));
      localIterator1 = parambf.g.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        paramcy.f();
        paramcy.c();
        if ((parambf.h != null) && (parambf.E()))
        {
          paramcy.a(bf.R());
          parambf.h.b(paramcy);
          paramcy.c();
        }
        if ((parambf.i != null) && (parambf.H()))
        {
          paramcy.a(bf.S());
          parambf.i.b(paramcy);
          paramcy.c();
        }
        paramcy.d();
        paramcy.b();
        return;
        ((av)localIterator2.next()).b(paramcy);
        break;
      }
      ((bd)localIterator1.next()).b(paramcy);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.cC
 * JD-Core Version:    0.6.2
 */