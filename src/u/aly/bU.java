package u.aly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class bU extends di<bd>
{
  private void a(cy paramcy, bd parambd)
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
      }
      while (true)
      {
        paramcy.m();
        break;
        if (localct.b == 11)
        {
          parambd.a = paramcy.z();
          parambd.a(true);
        }
        else
        {
          db.a(paramcy, localct.b);
          continue;
          if (localct.b == 10)
          {
            parambd.b = paramcy.x();
            parambd.b(true);
          }
          else
          {
            db.a(paramcy, localct.b);
            continue;
            if (localct.b == 10)
            {
              parambd.c = paramcy.x();
              parambd.c(true);
            }
            else
            {
              db.a(paramcy, localct.b);
              continue;
              if (localct.b == 10)
              {
                parambd.d = paramcy.x();
                parambd.d(true);
              }
              else
              {
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 15)
                {
                  cu localcu2 = paramcy.p();
                  parambd.e = new ArrayList(localcu2.b);
                  for (int j = 0; ; j++)
                  {
                    if (j >= localcu2.b)
                    {
                      paramcy.q();
                      parambd.e(true);
                      break;
                    }
                    ay localay = new ay();
                    localay.a(paramcy);
                    parambd.e.add(localay);
                  }
                }
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 15)
                {
                  cu localcu1 = paramcy.p();
                  parambd.f = new ArrayList(localcu1.b);
                  for (int i = 0; ; i++)
                  {
                    if (i >= localcu1.b)
                    {
                      paramcy.q();
                      parambd.f(true);
                      break;
                    }
                    aw localaw = new aw();
                    localaw.a(paramcy);
                    parambd.f.add(localaw);
                  }
                }
                db.a(paramcy, localct.b);
                continue;
                if (localct.b == 12)
                {
                  parambd.g = new be();
                  parambd.g.a(paramcy);
                  parambd.g(true);
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
    paramcy.k();
    if (!parambd.i())
      throw new cz("Required field 'start_time' was not found in serialized data! Struct: " + toString());
    if (!parambd.l())
      throw new cz("Required field 'end_time' was not found in serialized data! Struct: " + toString());
    if (!parambd.o())
      throw new cz("Required field 'duration' was not found in serialized data! Struct: " + toString());
    parambd.C();
  }

  private static void b(cy paramcy, bd parambd)
  {
    parambd.C();
    paramcy.a(bd.D());
    if (parambd.a != null)
    {
      paramcy.a(bd.E());
      paramcy.a(parambd.a);
      paramcy.c();
    }
    paramcy.a(bd.F());
    paramcy.a(parambd.b);
    paramcy.c();
    paramcy.a(bd.G());
    paramcy.a(parambd.c);
    paramcy.c();
    paramcy.a(bd.H());
    paramcy.a(parambd.d);
    paramcy.c();
    Iterator localIterator2;
    Iterator localIterator1;
    if ((parambd.e != null) && (parambd.t()))
    {
      paramcy.a(bd.I());
      paramcy.a(new cu((byte)12, parambd.e.size()));
      localIterator2 = parambd.e.iterator();
      if (!localIterator2.hasNext())
      {
        paramcy.f();
        paramcy.c();
      }
    }
    else if ((parambd.f != null) && (parambd.y()))
    {
      paramcy.a(bd.J());
      paramcy.a(new cu((byte)12, parambd.f.size()));
      localIterator1 = parambd.f.iterator();
    }
    while (true)
    {
      if (!localIterator1.hasNext())
      {
        paramcy.f();
        paramcy.c();
        if ((parambd.g != null) && (parambd.B()))
        {
          paramcy.a(bd.K());
          parambd.g.b(paramcy);
          paramcy.c();
        }
        paramcy.d();
        paramcy.b();
        return;
        ((ay)localIterator2.next()).b(paramcy);
        break;
      }
      ((aw)localIterator1.next()).b(paramcy);
    }
  }
}

/* Location:           C:\Users\Fernando\Desktop\Mibandesv2.3\classes-dex2jar.jar
 * Qualified Name:     u.aly.bU
 * JD-Core Version:    0.6.2
 */